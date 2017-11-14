package com.jeff.tianti.cms.entity;

import com.jeff.tianti.common.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 产品
 * @author missC
 *
 */
@Entity
@Table(name = "cms_product")
public class Product extends BaseEntity {

    private static final long serialVersionUID = -8821121831372299051L;

    //名称
    private String name;

    //审核人
    private String auditorId;

    //发布状态
    private String postStatus;

    //企业Id
    private String companyId;

    //单位
    private String measurement;

    //产量
    private String capacity;

    //合作
    private String cooperation;

    //详情
    private String introduction;

    //排序
    private Integer sort;

    @Column(name = "name",length=64)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "auditor_id",length=32)
    public String getAuditorId() {
        return auditorId;
    }

    public void setAuditorId(String auditorId) {
        this.auditorId = auditorId;
    }

    @Column(name = "post_status",length=1)
    public String getPostStatus() {
        return postStatus;
    }

    public void setPostStatus(String postStatus) {
        this.postStatus = postStatus;
    }

    @Column(name = "company_id",length=32)
    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    @Column(name = "measurement",length=32)
    public String getMeasurement() {
        return measurement;
    }

    public void setMeasurement(String measurement) {
        this.measurement = measurement;
    }

    @Column(name = "capacity",length=32)
    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    @Column(name = "cooperation",length=2000)
    public String getCooperation() {
        return cooperation;
    }

    public void setCooperation(String cooperation) {
        this.cooperation = cooperation;
    }

    @Column(name = "introduction",length=2000)
    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    @Column(name = "sort")
    public int getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
