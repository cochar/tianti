package com.jeff.tianti.cms.service;

import com.jeff.tianti.cms.entity.CompanyType;
import com.jeff.tianti.cms.dao.CompanyTypeDao;
import com.jeff.tianti.cms.dto.CompanyTypeQueryDTO;
import com.jeff.tianti.common.service.CommonService;
import com.jeff.tianti.common.entity.PageModel;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * @author missC
 * @desc CompanyTypeService类 
 * @date 2017-11-27
 */
@Service
public class CompanyTypeService extends CommonService< CompanyType,String >  {

    @Autowired
    private CompanyTypeDao companyTypeDao;

    @Autowired
    public void setCompanyTypeDao(CompanyTypeDao companyTypeDao){
      super.setCommonDao(companyTypeDao);
    }

    public PageModel<CompanyType> queryCompanyTypePage(CompanyTypeQueryDTO companyTypeQueryDTO){
           return this.companyTypeDao.queryCompanyTypePage(companyTypeQueryDTO);
    }

    public List<CompanyType> queryCompanyTypeList(CompanyTypeQueryDTO companyTypeQueryDTO){
           return this.companyTypeDao.queryCompanyTypeList(companyTypeQueryDTO);
    }


}