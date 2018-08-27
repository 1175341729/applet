package com.xinchao.entrytask.bus.dao;

import com.xinchao.entrytask.bus.model.*;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplyOrderMapper
{
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table apply_order
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table apply_order
     *
     * @mbggenerated
     */
    int insert(ApplyOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table apply_order
     *
     * @mbggenerated
     */
    int insertSelective(ApplyOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table apply_order
     *
     * @mbggenerated
     */
    ApplyOrder selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table apply_order
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(ApplyOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table apply_order
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(ApplyOrder record);

    int selectCount(ApplyOrderCondition condition);

    List<ApplyOrderSearchVo> selectByCondition(ApplyOrderCondition condition);

    List<ApplyOrderSearchVo> selectByWeixin(String applyWeiXin);

    void updateOrderStatus(ApplyOrder record);

    // updateByPrimaryKeySelective
    int payOrder(ApplyOrder record);

    @Select(value = "select b.apply_phone applyPhone,a.balance_bonus balanceBonus from apply_order a,apply_user b where a.status=4 and a.apply_user_id=b.id order by complete_time desc  LIMIT #{num}")
    List<ApplyOrderRollMsg> getTaskRollMsg(Integer num);

    @Select(value = "select sum(a.balance_bonus)balanceBonus,b.apply_phone applyPhone from apply_order a,apply_user b where a.apply_user_id=b.id and b.id=#{applyUserId} and a.status=4 group by b.apply_phone")
    ApplyOrderBonusVo getApplyBonus(Long applyUserId);

    @Select(value = "SELECT COUNT(*) FROM apply_order a WHERE a.apply_user_id=#{applyUserId} and a.task_id=#{taskId}")
    int selectByTaskIdAndUserId(@Param("taskId") Integer taskId, @Param("applyUserId") Integer applyUserId);

    @Update(value = "UPDATE apply_order a SET a.status = 5  WHERE a.task_id=#{taskId} AND a.status IN (1,2)")
    int updateOrderStatusToCancelOfTask(@Param("taskId") Integer taskId);

    @Update(value = "UPDATE ")
    int updateOrderStatusToFinished(@Param("orderId") Integer orderId);


}