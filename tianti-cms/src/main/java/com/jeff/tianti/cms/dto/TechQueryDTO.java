package com.jeff.tianti.cms.dto;

import com.jeff.tianti.common.dto.CommonQueryDTO;

/**
 * @author missC
 * @desc TechQueryDTO 
 * @date 2017-11-13
 */
public class TechQueryDTO extends CommonQueryDTO{

    //企业ID
    private String companyId;

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }
}