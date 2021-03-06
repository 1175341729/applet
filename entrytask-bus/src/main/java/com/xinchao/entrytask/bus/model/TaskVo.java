package com.xinchao.entrytask.bus.model;

import java.math.BigDecimal;
import java.util.Date;

public class TaskVo {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task.task_name
     *
     * @mbggenerated
     */
    private String taskName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task.task_address
     *
     * @mbggenerated
     */
    private String taskAddress;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task.property_company
     *
     * @mbggenerated
     */
    private String propertyCompany;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task.task_number
     *
     * @mbggenerated
     */
    private String taskNumber;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task.province
     *
     * @mbggenerated
     */
    private String province;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task.city
     *
     * @mbggenerated
     */
    private String city;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task.docking_person
     *
     * @mbggenerated
     */
    private String dockingPerson;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task.creator
     *
     * @mbggenerated
     */
    private String creator;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task.create_time
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task.completion_time
     *
     * @mbggenerated
     */
    private Date completionTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task.status
     *
     * @mbggenerated
     */
    private Byte status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task.bonus
     *
     * @mbggenerated
     */
    private BigDecimal bonus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task.supplier_id
     *
     * @mbggenerated
     */
    private String supplierId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task.version_num
     *
     * @mbggenerated
     */
    private String versionNum;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task.docking_phone
     *
     * @mbggenerated
     */
    private String dockingPhone;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task
     *
     * @mbggenerated
     */
    public TaskVo(Integer id, String taskName, String taskAddress, String propertyCompany, String taskNumber, String province, String city, String dockingPerson, String creator, Date createTime, Date completionTime, Byte status, BigDecimal bonus, String supplierId, String versionNum, String dockingPhone) {
        this.id = id;
        this.taskName = taskName;
        this.taskAddress = taskAddress;
        this.propertyCompany = propertyCompany;
        this.taskNumber = taskNumber;
        this.province = province;
        this.city = city;
        this.dockingPerson = dockingPerson;
        this.creator = creator;
        this.createTime = createTime;
        this.completionTime = completionTime;
        this.status = status;
        this.bonus = bonus;
        this.supplierId = supplierId;
        this.versionNum = versionNum;
        this.dockingPhone = dockingPhone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table task
     *
     * @mbggenerated
     */
    public TaskVo() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task.id
     *
     * @return the value of task.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task.id
     *
     * @param id the value for task.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task.task_name
     *
     * @return the value of task.task_name
     *
     * @mbggenerated
     */
    public String getTaskName() {
        return taskName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task.task_name
     *
     * @param taskName the value for task.task_name
     *
     * @mbggenerated
     */
    public void setTaskName(String taskName) {
        this.taskName = taskName == null ? null : taskName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task.task_address
     *
     * @return the value of task.task_address
     *
     * @mbggenerated
     */
    public String getTaskAddress() {
        return taskAddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task.task_address
     *
     * @param taskAddress the value for task.task_address
     *
     * @mbggenerated
     */
    public void setTaskAddress(String taskAddress) {
        this.taskAddress = taskAddress == null ? null : taskAddress.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task.property_company
     *
     * @return the value of task.property_company
     *
     * @mbggenerated
     */
    public String getPropertyCompany() {
        return propertyCompany;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task.property_company
     *
     * @param propertyCompany the value for task.property_company
     *
     * @mbggenerated
     */
    public void setPropertyCompany(String propertyCompany) {
        this.propertyCompany = propertyCompany == null ? null : propertyCompany.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task.task_number
     *
     * @return the value of task.task_number
     *
     * @mbggenerated
     */
    public String getTaskNumber() {
        return taskNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task.task_number
     *
     * @param taskNumber the value for task.task_number
     *
     * @mbggenerated
     */
    public void setTaskNumber(String taskNumber) {
        this.taskNumber = taskNumber == null ? null : taskNumber.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task.province
     *
     * @return the value of task.province
     *
     * @mbggenerated
     */
    public String getProvince() {
        return province;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task.province
     *
     * @param province the value for task.province
     *
     * @mbggenerated
     */
    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task.city
     *
     * @return the value of task.city
     *
     * @mbggenerated
     */
    public String getCity() {
        return city;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task.city
     *
     * @param city the value for task.city
     *
     * @mbggenerated
     */
    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task.docking_person
     *
     * @return the value of task.docking_person
     *
     * @mbggenerated
     */
    public String getDockingPerson() {
        return dockingPerson;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task.docking_person
     *
     * @param dockingPerson the value for task.docking_person
     *
     * @mbggenerated
     */
    public void setDockingPerson(String dockingPerson) {
        this.dockingPerson = dockingPerson == null ? null : dockingPerson.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task.creator
     *
     * @return the value of task.creator
     *
     * @mbggenerated
     */
    public String getCreator() {
        return creator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task.creator
     *
     * @param creator the value for task.creator
     *
     * @mbggenerated
     */
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task.create_time
     *
     * @return the value of task.create_time
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task.create_time
     *
     * @param createTime the value for task.create_time
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task.completion_time
     *
     * @return the value of task.completion_time
     *
     * @mbggenerated
     */
    public Date getCompletionTime() {
        return completionTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task.completion_time
     *
     * @param completionTime the value for task.completion_time
     *
     * @mbggenerated
     */
    public void setCompletionTime(Date completionTime) {
        this.completionTime = completionTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task.status
     *
     * @return the value of task.status
     *
     * @mbggenerated
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task.status
     *
     * @param status the value for task.status
     *
     * @mbggenerated
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task.bonus
     *
     * @return the value of task.bonus
     *
     * @mbggenerated
     */
    public BigDecimal getBonus() {
        return bonus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task.bonus
     *
     * @param bonus the value for task.bonus
     *
     * @mbggenerated
     */
    public void setBonus(BigDecimal bonus) {
        this.bonus = bonus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task.supplier_id
     *
     * @return the value of task.supplier_id
     *
     * @mbggenerated
     */
    public String getSupplierId() {
        return supplierId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task.supplier_id
     *
     * @param supplierId the value for task.supplier_id
     *
     * @mbggenerated
     */
    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId == null ? null : supplierId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task.version_num
     *
     * @return the value of task.version_num
     *
     * @mbggenerated
     */
    public String getVersionNum() {
        return versionNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task.version_num
     *
     * @param versionNum the value for task.version_num
     *
     * @mbggenerated
     */
    public void setVersionNum(String versionNum) {
        this.versionNum = versionNum == null ? null : versionNum.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task.docking_phone
     *
     * @return the value of task.docking_phone
     *
     * @mbggenerated
     */
    public String getDockingPhone() {
        return dockingPhone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task.docking_phone
     *
     * @param dockingPhone the value for task.docking_phone
     *
     * @mbggenerated
     */
    public void setDockingPhone(String dockingPhone) {
        this.dockingPhone = dockingPhone == null ? null : dockingPhone.trim();
    }
}