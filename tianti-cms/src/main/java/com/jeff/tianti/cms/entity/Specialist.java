package com.jeff.tianti.cms.entity;

import com.jeff.tianti.common.entity.BaseEntity;
import com.jeff.tianti.org.entity.Company;

import javax.persistence.*;

/**
 * 技术
 * @author missC
 *
 */
@Entity
@Table(name = "org_specialist")
public class Specialist extends BaseEntity {

    private static final long serialVersionUID = -8821121831372299051L;

    //名称
    private String name;

    //简介
    private String brief;

    //介绍
    private String introduction;

    //商务合作
    private String cooperation;

    //排序
    private Integer orderNo;

    //公司
    private Company company;

    //发布状态
    private String postStatus;

    @Column(name = "name",length=64)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "breif",length=200)
    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    @Column(name = "introduction",length=2000)
    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    @Column(name = "cooperation",length=2000)
    public String getCooperation() {
        return cooperation;
    }

    public void setCooperation(String cooperation) {
        this.cooperation = cooperation;
    }


    @Column(name = "order_no")
    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    @ManyToOne
    @JoinColumn(name = "company_id")
    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Column(name = "post_status",length=1)
    public String getPostStatus() {
        return postStatus;
    }

    public void setPostStatus(String postStatus) {
        this.postStatus = postStatus;
    }
}
