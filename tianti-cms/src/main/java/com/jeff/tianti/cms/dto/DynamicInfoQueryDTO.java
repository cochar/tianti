package com.jeff.tianti.cms.dto;

import com.jeff.tianti.common.dto.CommonQueryDTO;

/**
 * @author missC
 * @desc DynamicInfoQueryDTO 
 * @date 2017-11-27
 */
public class DynamicInfoQueryDTO extends CommonQueryDTO{

    //公司Id
    private String companyId;

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }
}