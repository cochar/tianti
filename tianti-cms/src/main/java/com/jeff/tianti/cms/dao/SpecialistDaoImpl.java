package com.jeff.tianti.cms.dao;

import com.jeff.tianti.common.dao.CustomBaseSqlDaoImpl;
import com.jeff.tianti.common.entity.PageModel;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.jeff.tianti.cms.entity.Specialist;
import com.jeff.tianti.cms.dto.SpecialistQueryDTO;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.util.StringUtil;

/**
 * @author missC
 * @desc SpecialistDaoImpl类
 * @date 2017-11-27
 */

public class SpecialistDaoImpl extends CustomBaseSqlDaoImpl implements SpecialistDaoCustom  {

    public PageModel<Specialist> querySpecialistPage(SpecialistQueryDTO specialistQueryDTO){
         Map<String,Object> map = new HashMap<String,Object>();
         StringBuilder hql = new StringBuilder();
         hql.append("select t from Specialist t where 1=1 ");
         if(StringUtils.isNotBlank(specialistQueryDTO.getCompanyId())) {
             hql.append("and t.company.id = :companyId ");
             map.put("companyId",specialistQueryDTO.getCompanyId());
         }
         return this.queryForPageWithParams(hql.toString(),map,specialistQueryDTO.getCurrentPage(),specialistQueryDTO.getPageSize());
    }

    public List<Specialist> querySpecialistList(SpecialistQueryDTO specialistQueryDTO){
         Map<String,Object> map = new HashMap<String,Object>();
         StringBuilder hql = new StringBuilder();
         hql.append("select t from Specialist t where 1=1 ");
        if(StringUtils.isNotBlank(specialistQueryDTO.getCompanyId())) {
            hql.append("and t.company.id = :companyId ");
            map.put("companyId",specialistQueryDTO.getCompanyId());
        }
         return this.queryByMapParams(hql.toString(),map);
    }


}