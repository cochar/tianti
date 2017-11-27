package com.jeff.tianti.cms.dao;

import com.jeff.tianti.common.dao.CustomBaseSqlDaoImpl;
import com.jeff.tianti.common.entity.PageModel;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.jeff.tianti.cms.entity.CompanyType;
import com.jeff.tianti.cms.dto.CompanyTypeQueryDTO;
/**
 * @author missC
 * @desc CompanyTypeDaoImpl类 
 * @date 2017-11-27
 */

public class CompanyTypeDaoImpl extends CustomBaseSqlDaoImpl implements CompanyTypeDaoCustom  {

    public PageModel<CompanyType> queryCompanyTypePage(CompanyTypeQueryDTO companyTypeQueryDTO){
         Map<String,Object> map = new HashMap<String,Object>();
         StringBuilder hql = new StringBuilder();
         hql.append("select t from CompanyType t ");
         return this.queryForPageWithParams(hql.toString(),map,companyTypeQueryDTO.getCurrentPage(),companyTypeQueryDTO.getPageSize());
    }

    public List<CompanyType> queryCompanyTypeList(CompanyTypeQueryDTO companyTypeQueryDTO){
         Map<String,Object> map = new HashMap<String,Object>();
         StringBuilder hql = new StringBuilder();
         hql.append("select t from CompanyType t ");
         return this.queryByMapParams(hql.toString(),map);
    }


}