package com.xinchao.entrytask.bus.dao.sqlbuiler;

import com.xinchao.entrytask.bus.model.Task;
import com.xinchao.entrytask.bus.model.TaskQueryModel;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class TaskSqlBuilder {

    /**
     * 发布任务
     *
     * @param task
     * @return
     */
    public static String buildCreateTask(final Task task) {
        return new SQL() {{
            INSERT_INTO("task");
            INTO_COLUMNS("task_name,task_address,property_company,task_number,province,city,docking_person,creator,create_time,status,bonus,supplier_id,version_num,docking_phone");
            INTO_VALUES("#{taskName},#{taskAddress},#{propertyCompany},#{taskNumber},#{province},#{city},#{dockingPerson},#{creator},#{createTime},#{status},#{bonus},#{supplierId},#{versionNum},#{dockingPhone}");
        }}.toString();
    }

    /**
     * 根据微信和城市获取任务列表
     * 根据微信获取任务列表
     * 根据城市获取任务列表
     *
     * @return sql
     */
    public static String buildGetTaskByUserId(Map<String, Object> para) {

        return new SQL() {{
            SELECT("id",
                    "task_name",
                    "task_address",
                    "property_company",
                    "task_number",
                    "province",
                    "city",
                    "docking_person",
                    "creator",
                    "create_time",
                    "completion_time",
                    "status",
                    "bonus",
                    "supplier_id",
                    "version_num");
            FROM("task");
            WHERE("1=1");
            if (null != para.get("city") && !StringUtils.isBlank(para.get("city").toString())) {
                WHERE(" city='" + para.get("city").toString() + "'");

            }
            if (null != para.get("weixin") && !StringUtils.isBlank(para.get("weixin").toString())) {
                WHERE(" id in(select a.task_id " +
                        "from apply_order a, " +
                        "     apply_user b " +
                        "where a.apply_user_id=b.id " +
                        "      and b.apply_weixin='" + para.get("weixin").toString() + "')");
            }
            ORDER_BY("create_time desc");
        }}.toString();
    }

    /**
     * 根据查询条件获取类表
     *
     * @param taskQueryModel
     * @return
     */
    public static String buildGet(TaskQueryModel taskQueryModel) {

        SQL sql = new SQL();
        SQL sqlInner = new SQL();

        sqlInner.SELECT("c.task_id",
                "count(c.id)inOrdersNum",
                "f.apply_weixin",
                "f.apply_phone");
        sqlInner.FROM("apply_order c", "task d", "apply_user f");
        sqlInner.WHERE("d.id=c.task_id", "c.apply_user_id=f.id");
        if (!StringUtils.isBlank(taskQueryModel.getUserGroup())) {
            sqlInner.WHERE("d.supplier_id=#{userGroup}");
        }

        sqlInner.WHERE("d.status=2 and c.status=4");

        sqlInner.GROUP_BY("c.task_id", "f.apply_weixin", "f.apply_phone");

        sql.SELECT("a.id",
                "b.merger_short_name mergerShortName",
                "a.task_name taskName",
                "a.property_company propertyCompany",
                "a.task_address taskAddress",
                "a.bonus",
                "IFNULL(e.inOrdersNum,0) inOrdersNum",
                "a.docking_person dockingPerson",
                "a.docking_phone dockingPhone",
                "a.status",
                "a.creator",
                "a.create_time createTime",
                "a.completion_time completionTime",
                "if(a.status=2,e.apply_weixin,'')applyWeixin ",
                "if(a.status=2,e.apply_phone ,'')applyPhone",
                "b.id city",
                "b.parent_id province");
        sql.FROM("task a");
        sql.INNER_JOIN("sale_area b on a.city=b.id");
        sql.LEFT_OUTER_JOIN("(" + sqlInner.toString() + ")e on a.id=e.task_id");
        sql.WHERE("1=1");
        //城市
        if (!StringUtils.isBlank(taskQueryModel.getCity())) {
            sql.WHERE("b.id=#{city}");
        }
        //供应商
        if (!StringUtils.isBlank(taskQueryModel.getUserGroup())) {
            sql.WHERE("a.supplier_id=#{userGroup}");
        }
        //日期区间
        if (!StringUtils.isBlank(taskQueryModel.getStartTime()) && !StringUtils.isBlank(taskQueryModel.getEndTime())) {
            sql.WHERE("(a.create_time>=str_to_date(#{startTime},'%Y-%m-%d %T')and a.create_time<=STR_TO_DATE(#{endTime},'%Y-%m-%d %T'))");
        }
        //任务名称
        if (!StringUtils.isBlank(taskQueryModel.getTaskName())) {
//            sql.WHERE("a.task_name like #{taskName} || '%'");
            sql.WHERE("a.task_name like concat('%',#{taskName},'%')");
        }
        //对接人
        if (!StringUtils.isBlank(taskQueryModel.getDockingPerson())) {
//            sql.WHERE("a.docking_person like #{dockingPerson} || '%'");
            sql.WHERE("a.docking_person like concat('%',#{dockingPerson},'%')");
        }
        //状态
        if (null != taskQueryModel.getTaskStatus()) {
            sql.WHERE("a.status=#{taskStatus}");
        }
        //物业公司
        if (!StringUtils.isBlank(taskQueryModel.getPropertyCompany())) {
//            sql.WHERE("a.property_company like #{propertyCompany} || '%'");
            sql.WHERE("a.property_company like concat('%',#{propertyCompany},'%')");
        }

        sql.ORDER_BY("a.create_time desc");
//        System.out.println(sql.toString());
        return sql.toString();

    }

    /**
     * 统计简报
     * @return sql
     */
    public static String buildGetBriefing(final String supplierId){
        String sql="select sum(c.taskAllTaskNum)taskAllTaskNum, " +
                "  sum(c.taskInOrdersNum)taskInOrdersNum, " +
                "  sum(c.taskPauseOrdersNum)taskPauseOrdersNum, " +
                "   sum(c.taskFinishNum)taskFinishNum, " +
                "  sum(c.taskCancelNum)taskCancelNum,    " +
                "  sum(c.allInOrdersNum)allInOrdersNum, " +
                "  sum(c.applyNum)applyNum, " +
                "  sum(c.acceptNum)acceptNum, " +
                "  sum(c.finishNum)finishNum, " +
                "  sum(c.balanceNum)balanceNum, " +
                "  sum(c.rejectNum)rejectNum, " +
                "  sum(c.cancelNum)cancelNum, " +
                "  sum(c.outBonusFee)outBonusFee " +
                "from ( " +
                "select count(1)taskAllTaskNum, " +
                "   sum(case when status=1 then  " +
                "    1 " +
                "   else 0 " +
                "   end)taskInOrdersNum, " +
                "       sum(case when status=4 THEN " +
                "    1 " +
                "   else 0 " +
                "   end)taskPauseOrdersNum, " +
                "       sum(case when status=2 then  " +
                "    1 " +
                "   else 0 " +
                "   end)taskFinishNum, " +
                "   sum(case when status=3 then  " +
                "    1 " +
                "   else 0 " +
                "   end)taskCancelNum, " +
                "   0 allInOrdersNum, " +
                "   0 applyNum, " +
                "   0 acceptNum, " +
                "   0 finishNum, " +
                "   0 balanceNum, " +
                "   0 rejectNum, " +
                "   0 cancelNum, " +
                "   0 outBonusFee " +
                "from task  " +
                "where supplier_id='"+supplierId+"' " +
                "union all " +
                "select  " +
                "  0 taskAllTaskNum, " +
                "  0 taskInOrdersNum, " +
                "  0 taskPauseOrdersNum, " +
                "   0 taskFinishNum, " +
                "  0 taskCancelNum,      " +
                "   count(1)allInOrdersNum, " +
                "   sum(case when a.status=1 then  " +
                "    1 " +
                "   else 0 " +
                "   end)applyNum, " +
                "   sum(case when a.status=2 then  " +
                "    1 " +
                "   else 0 " +
                "   end)acceptNum, " +
                "    sum(case when a.status=3 then  " +
                "    1 " +
                "   else 0 " +
                "   end)finishNum, " +
                "   sum(case when a.status=4 then  " +
                "    1 " +
                "   else 0 " +
                "   end)balanceNum, " +
                "   sum(case when a.status=6 then  " +
                "    1 " +
                "   else 0 " +
                "   end)rejectNum, " +
                "   sum(case when a.status=5 then  " +
                "    1 " +
                "   else 0 " +
                "   end)cancelNum, " +
                "   sum(case when a.status=4 then  " +
                "     a.balance_bonus  " +
                "   else 0 " +
                "   end)outBonusFee " +
                "from apply_order a, " +
                "  task b " +
                "where a.task_id=b.id " +
                "  and b.supplier_id='"+supplierId+"')c ";

        return sql;
    }


    /**
     * 任务数据
     * @return sql
     */
    public static String buildGetBriefingGroupBySupplier(){
        String sql="select c.supplierId, " +
                "  sum(c.taskAllTaskNum)taskAllTaskNum, " +
                "  sum(c.taskInOrdersNum)taskInOrdersNum, " +
                "  sum(c.taskPauseOrdersNum)taskPauseOrdersNum, " +
                "   sum(c.taskFinishNum)taskFinishNum, " +
                "  sum(c.taskCancelNum)taskCancelNum,    " +
                "  sum(c.allInOrdersNum)allInOrdersNum, " +
                "  sum(c.applyNum)applyNum, " +
                "  sum(c.acceptNum)acceptNum, " +
                "  sum(c.finishNum)finishNum, " +
                "  sum(c.balanceNum)balanceNum, " +
                "  sum(c.rejectNum)rejectNum, " +
                "  sum(c.cancelNum)cancelNum, " +
                "  sum(c.outBonusFee)outBonusFee " +
                " from (  " +
                "     select count(1)taskAllTaskNum, " +
                "   sum(case when status=1 then  " +
                "    1 " +
                "   else 0 " +
                "   end)taskInOrdersNum, " +
                "       sum(case when status=4 THEN " +
                "    1 " +
                "   else 0 " +
                "   end)taskPauseOrdersNum, " +
                "       sum(case when status=2 then  " +
                "    1 " +
                "   else 0 " +
                "   end)taskFinishNum, " +
                "   sum(case when status=3 then  " +
                "    1 " +
                "   else 0 " +
                "   end)taskCancelNum, " +
                "   0 allInOrdersNum, " +
                "   0 applyNum, " +
                "   0 acceptNum, " +
                "   0 finishNum, " +
                "   0 balanceNum, " +
                "   0 rejectNum, " +
                "   0 cancelNum, " +
                "   0 outBonusFee, " +
                "  supplier_id supplierId " +
                "  from task group by supplier_id "+
                "  union all " +
                "  select  " +
                "  0 taskAllTaskNum, " +
                "  0 taskInOrdersNum, " +
                "  0 taskPauseOrdersNum, " +
                "   0 taskFinishNum, " +
                "  0 taskCancelNum,      " +
                "   count(1)allInOrdersNum, " +
                "   sum(case when a.status=1 then  " +
                "    1 " +
                "   else 0 " +
                "   end)applyNum, " +
                "   sum(case when a.status=2 then  " +
                "    1  " +
                "   else 0 " +
                "   end)acceptNum, " +
                "    sum(case when a.status=3 then  " +
                "    1 " +
                "   else 0 " +
                "   end)finishNum, " +
                "   sum(case when a.status=4 then  " +
                "    1 " +
                "   else 0 " +
                "   end)balanceNum, " +
                "   sum(case when a.status=6 then  " +
                "    1 " +
                "   else 0 " +
                "   end)rejectNum, " +
                "   sum(case when a.status=5 then  " +
                "    1 " +
                "   else 0 " +
                "   end)cancelNum, " +
                "   sum(case when a.status=4 then  " +
                "     a.balance_bonus  " +
                "   else 0  " +
                "   end)outBonusFee, " +
                "   b.supplier_id supplierId " +
                " from apply_order a, " +
                "  task b " +
                " where a.task_id=b.id group by b.supplier_id)c group by c.supplierId";
        return sql;
    }
}


















