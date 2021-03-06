package com.xinchao.entrytask.bus.model;

public class SaleArea {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sale_area.id
     *
     * @mbggenerated
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sale_area.parent_id
     *
     * @mbggenerated
     */
    private String parentId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sale_area.name
     *
     * @mbggenerated
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sale_area.short_name
     *
     * @mbggenerated
     */
    private String shortName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sale_area.merger_short_name
     *
     * @mbggenerated
     */
    private String mergerShortName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sale_area.level_type
     *
     * @mbggenerated
     */
    private String levelType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sale_area.city_code
     *
     * @mbggenerated
     */
    private String cityCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sale_area.zip_code
     *
     * @mbggenerated
     */
    private String zipCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sale_area.remark
     *
     * @mbggenerated
     */
    private String remark;

    /**
     * This field w <select id="selectByCondition" resultMap="BaseResultMap">
     SELECT  *
     from sale_area
     where 1=1
     <if test="parentId != null" >
     AND parent_id = #{parentId}
     </if>
     <if test="parentId != null" >
     AND level_type = #{levelType}
     </if>
     </select>as generated by MyBatis Generator.
     * This field corresponds to the database column sale_area.open
     *
     * @mbggenerated
     */
    private Short open;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sale_area.longitude
     *
     * @mbggenerated
     */
    private Double longitude;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sale_area.latitude
     *
     * @mbggenerated
     */
    private Double latitude;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sale_area
     *
     * @mbggenerated
     */
    public SaleArea(String id, String parentId, String name, String shortName, String mergerShortName, String levelType, String cityCode, String zipCode, String remark, Short open, Double longitude, Double latitude) {
        this.id = id;
        this.parentId = parentId;
        this.name = name;
        this.shortName = shortName;
        this.mergerShortName = mergerShortName;
        this.levelType = levelType;
        this.cityCode = cityCode;
        this.zipCode = zipCode;
        this.remark = remark;
        this.open = open;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sale_area
     *
     * @mbggenerated
     */
    public SaleArea() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sale_area.id
     *
     * @return the value of sale_area.id
     *
     * @mbggenerated
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sale_area.id
     *
     * @param id the value for sale_area.id
     *
     * @mbggenerated
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sale_area.parent_id
     *
     * @return the value of sale_area.parent_id
     *
     * @mbggenerated
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sale_area.parent_id
     *
     * @param parentId the value for sale_area.parent_id
     *
     * @mbggenerated
     */
    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sale_area.name
     *
     * @return the value of sale_area.name
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sale_area.name
     *
     * @param name the value for sale_area.name
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sale_area.short_name
     *
     * @return the value of sale_area.short_name
     *
     * @mbggenerated
     */
    public String getShortName() {
        return shortName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sale_area.short_name
     *
     * @param shortName the value for sale_area.short_name
     *
     * @mbggenerated
     */
    public void setShortName(String shortName) {
        this.shortName = shortName == null ? null : shortName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sale_area.merger_short_name
     *
     * @return the value of sale_area.merger_short_name
     *
     * @mbggenerated
     */
    public String getMergerShortName() {
        return mergerShortName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sale_area.merger_short_name
     *
     * @param mergerShortName the value for sale_area.merger_short_name
     *
     * @mbggenerated
     */
    public void setMergerShortName(String mergerShortName) {
        this.mergerShortName = mergerShortName == null ? null : mergerShortName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sale_area.level_type
     *
     * @return the value of sale_area.level_type
     *
     * @mbggenerated
     */
    public String getLevelType() {
        return levelType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sale_area.level_type
     *
     * @param levelType the value for sale_area.level_type
     *
     * @mbggenerated
     */
    public void setLevelType(String levelType) {
        this.levelType = levelType == null ? null : levelType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sale_area.city_code
     *
     * @return the value of sale_area.city_code
     *
     * @mbggenerated
     */
    public String getCityCode() {
        return cityCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sale_area.city_code
     *
     * @param cityCode the value for sale_area.city_code
     *
     * @mbggenerated
     */
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sale_area.zip_code
     *
     * @return the value of sale_area.zip_code
     *
     * @mbggenerated
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sale_area.zip_code
     *
     * @param zipCode the value for sale_area.zip_code
     *
     * @mbggenerated
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode == null ? null : zipCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sale_area.remark
     *
     * @return the value of sale_area.remark
     *
     * @mbggenerated
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sale_area.remark
     *
     * @param remark the value for sale_area.remark
     *
     * @mbggenerated
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sale_area.open
     *
     * @return the value of sale_area.open
     *
     * @mbggenerated
     */
    public Short getOpen() {
        return open;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sale_area.open
     *
     * @param open the value for sale_area.open
     *
     * @mbggenerated
     */
    public void setOpen(Short open) {
        this.open = open;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sale_area.longitude
     *
     * @return the value of sale_area.longitude
     *
     * @mbggenerated
     */
    public Double getLongitude() {
        return longitude;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sale_area.longitude
     *
     * @param longitude the value for sale_area.longitude
     *
     * @mbggenerated
     */
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sale_area.latitude
     *
     * @return the value of sale_area.latitude
     *
     * @mbggenerated
     */
    public Double getLatitude() {
        return latitude;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sale_area.latitude
     *
     * @param latitude the value for sale_area.latitude
     *
     * @mbggenerated
     */
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }
}