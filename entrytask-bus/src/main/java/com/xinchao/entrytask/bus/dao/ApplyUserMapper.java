package com.xinchao.entrytask.bus.dao;

import com.xinchao.entrytask.bus.model.ApplyUser;

import javax.annotation.Nullable;

public interface ApplyUserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table apply_user
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table apply_user
     *
     * @mbggenerated
     */
    int insert(ApplyUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table apply_user
     *
     * @mbggenerated
     */
    int insertSelective(ApplyUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table apply_user
     *
     * @mbggenerated
     */
    ApplyUser selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table apply_user
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(ApplyUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table apply_user
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(ApplyUser record);

    ApplyUser selectByWeiXin(@Nullable  String applyWeiXin);
}