package com.jeff.tianti.cms.dao;

import com.jeff.tianti.common.entity.PageModel;
import java.util.List;
import com.jeff.tianti.cms.entity.CompanyType;
import com.jeff.tianti.cms.dto.CompanyTypeQueryDTO;
/**
 * @author missC
 * @desc CompanyTypeDaoCustom接口 
 * @date 2017-11-27
 */
public interface CompanyTypeDaoCustom {

      PageModel<CompanyType> queryCompanyTypePage(CompanyTypeQueryDTO companyTypeQueryDTO);

      List<CompanyType> queryCompanyTypeList(CompanyTypeQueryDTO companyTypeQueryDTO);



}