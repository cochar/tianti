package com.jeff.tianti.cms.dao;

import com.jeff.tianti.common.dao.CustomBaseSqlDaoImpl;
import com.jeff.tianti.common.entity.PageModel;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.jeff.tianti.cms.entity.DynamicInfo;
import com.jeff.tianti.cms.dto.DynamicInfoQueryDTO;
import org.apache.commons.lang3.StringUtils;

/**
 * @author missC
 * @desc DynamicInfoDaoImpl类 
 * @date 2017-11-27
 */

public class DynamicInfoDaoImpl extends CustomBaseSqlDaoImpl implements DynamicInfoDaoCustom  {

    public PageModel<DynamicInfo> queryDynamicInfoPage(DynamicInfoQueryDTO dynamicInfoQueryDTO){
         Map<String,Object> map = new HashMap<String,Object>();
         StringBuilder hql = new StringBuilder();
         hql.append("select t from DynamicInfo t where 1=1 ");
        if(StringUtils.isNotBlank(dynamicInfoQueryDTO.getCompanyId())) {
            hql.append("and t.company.id =: companyId ");
            map.put("companyId",dynamicInfoQueryDTO.getCompanyId());
        }
         return this.queryForPageWithParams(hql.toString(),map,dynamicInfoQueryDTO.getCurrentPage(),dynamicInfoQueryDTO.getPageSize());
    }

    public List<DynamicInfo> queryDynamicInfoList(DynamicInfoQueryDTO dynamicInfoQueryDTO){
         Map<String,Object> map = new HashMap<String,Object>();
         StringBuilder hql = new StringBuilder();
         hql.append("select t from DynamicInfo t where 1=1 ");
        if(StringUtils.isNotBlank(dynamicInfoQueryDTO.getCompanyId())) {
            hql.append("and t.company.id =: companyId ");
            map.put("companyId",dynamicInfoQueryDTO.getCompanyId());
        }
         return this.queryByMapParams(hql.toString(),map);
    }


}