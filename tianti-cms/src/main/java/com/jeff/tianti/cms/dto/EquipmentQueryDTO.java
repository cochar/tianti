package com.jeff.tianti.cms.dto;

import com.jeff.tianti.common.dto.CommonQueryDTO;

/**
 * @author missC
 * @desc EquipmentQueryDTO 
 * @date 2017-11-27
 */
public class EquipmentQueryDTO extends CommonQueryDTO{

    //公司Id
    private String companyId;

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }
}