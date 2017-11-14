package com.jeff.tianti.org.entity;

import com.jeff.tianti.common.entity.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 企业
 * @author missC
 *
 */
@Entity
@Table(name = "sys_dic")
public class Dic extends BaseEntity {
    private static final long serialVersionUID = -8821121831372299051L;

    //名称
    private String name;

    //排序
    private Integer sort;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}