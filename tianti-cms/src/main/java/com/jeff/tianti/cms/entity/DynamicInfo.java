package com.jeff.tianti.cms.entity;

import com.jeff.tianti.common.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 技术
 * @author missC
 *
 */
@Entity
@Table(name = "cms_dynamic_info")
public class DynamicInfo extends BaseEntity {

    private static final long serialVersionUID = -8821121831372299051L;

    //名称
    private String name;

    //简介
    private String brief;

    //介绍
    private String introduction;

    //排序
    private int orderNo;

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

    @Column(name = "order_no")
    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }
}
