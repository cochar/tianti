package com.jeff.tianti.org.dto;

import com.jeff.tianti.common.dto.CommonQueryDTO;

public class CompanyQueryDTO extends CommonQueryDTO {

    private String id;

    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
