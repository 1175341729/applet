package com.xinchao.entrytask.bus.dao.sqlbuiler;

import org.apache.ibatis.jdbc.SQL;

public class AreaSqlBuilder {

    public static String buildSelectAreas(final String parentId, final String levelType) {
        return new SQL() {{
            SELECT("id,\n" +
                    "parent_id,\n" +
                    "name,\n" +
                    "short_name,\n" +
                    "merger_short_name,\n" +
                    "level_type,\n" +
                    "city_code,\n" +
                    "zip_code,\n" +
                    "remark,\n" +
                    "open,\n" +
                    "longitude,\n" +
                    "latitude");
            FROM("sale_area");
            WHERE("1=1");
            if (parentId != null) {
                WHERE("parent_id=#{parentId}");
            }
            if (levelType != null) {
                WHERE("level_type=#{levelType}");
            }
        }}.toString();
    }
}
