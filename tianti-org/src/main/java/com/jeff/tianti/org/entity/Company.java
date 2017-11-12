package com.jeff.tianti.org.entity;

import com.jeff.tianti.common.entity.BaseEntity;

import javax.persistence.*;

/**
 * 系统用户
 * @author Jeff Xu
 *
 */
@Entity
@Table(name = "org_company")
public class Company extends BaseEntity {

    private static final long serialVersionUID = -8821121831372299051L;

    //名称
    private String name;

    //审核人
    private String auditorId;

    @Column(name = "name",length=64)
    public String getName() {
        return name;
    }

    public void setName(String name){ this.name = name; }

    @Column(name = "auditor_id",length=64)
    public String getAuditorId() {
        return auditorId;
    }

    public void setAuditorId(String auditorId){ this.auditorId = auditorId; }
}

