package com.jeff.tianti.org.dao;

import com.jeff.tianti.common.dao.CustomBaseSqlDaoImpl;
import com.jeff.tianti.common.entity.PageModel;
import com.jeff.tianti.org.dto.CompanyDTO;
import com.jeff.tianti.org.dto.CompanyQueryDTO;
import com.jeff.tianti.org.entity.Company;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompanyDaoImpl extends CustomBaseSqlDaoImpl implements CompanyDaoCustom {

    /**
     * 查询企业分页信息
     * @param companyQueryDTO
     * @return
     */
    public PageModel<Company> queryCompanyPage(CompanyQueryDTO companyQueryDTO) {
        Map<String,Object> map = new HashMap<String,Object>();
        StringBuilder hql = new StringBuilder();
        hql.append("select c from Company c where c.deleteFlag = 0");
        if(companyQueryDTO != null){
            if(StringUtils.isNotBlank(companyQueryDTO.getDeleteFlag())){
                hql.append(" and c.deleteFlag = :deleteFlag ");
                map.put("deleteFlag", companyQueryDTO.getDeleteFlag());
            }
            if(StringUtils.isNotBlank(companyQueryDTO.getStartDate())){
                hql.append(" and c.createDate  >= :startDate ");
                map.put("startDate",companyQueryDTO.getStartDate());
            }
            if(StringUtils.isNotBlank(companyQueryDTO.getEndDate())) {
                hql.append(" and c.createDate  <= :endDate ");
                map.put("endDate", companyQueryDTO.getEndDate());
            }
        }
        hql.append(" order by c.createDate desc ");
        return this.queryForPageWithParams(hql.toString(), map, companyQueryDTO.getCurrentPage(), companyQueryDTO.getPageSize());
    }

    @Override
    public List<Company> queryCompanyList(CompanyQueryDTO companyQueryDTO) {
        List<Company> companyList = null;
        Map<String,Object> map = new HashMap<String,Object>();
        StringBuilder hql = new StringBuilder();
        hql.append("select c from Company c where c.deleteFlag = 0");
        if(companyQueryDTO != null){
            if(StringUtils.isNotBlank(companyQueryDTO.getDeleteFlag())){
                hql.append(" and c.deleteFlag = :deleteFlag ");
                map.put("deleteFlag", companyQueryDTO.getDeleteFlag());
            }
            if(StringUtils.isNotBlank(companyQueryDTO.getStartDate())){
                hql.append(" and c.createDate  >= :startDate ");
                map.put("startDate",companyQueryDTO.getStartDate());
            }
            if(StringUtils.isNotBlank(companyQueryDTO.getEndDate())) {
                hql.append(" and c.createDate  <= :endDate ");
                map.put("endDate", companyQueryDTO.getEndDate());
            }
        }
        hql.append("order by c.createDate desc");
        if(companyQueryDTO.getTop() != null){
            PageModel pageModel = this.queryForPageWithParams(hql.toString(),map,0, companyQueryDTO.getTop());
            if(pageModel != null){
                companyList = pageModel.getList();
            }
        }else{
            companyList = this.queryByMapParams(hql.toString(),map);
        }
        return this.queryByMapParams(hql.toString(), map);
    }
}
