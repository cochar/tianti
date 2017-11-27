package com.jeff.tianti.cms.dao;

import com.jeff.tianti.common.dao.CustomBaseSqlDaoImpl;
import com.jeff.tianti.common.entity.PageModel;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.jeff.tianti.cms.entity.DynamicInfo;
import com.jeff.tianti.cms.dto.DynamicInfoQueryDTO;
/**
 * @author missC
 * @desc DynamicInfoDaoImpl类 
 * @date 2017-11-27
 */

public class DynamicInfoDaoImpl extends CustomBaseSqlDaoImpl implements DynamicInfoDaoCustom  {

    public PageModel<DynamicInfo> queryDynamicInfoPage(DynamicInfoQueryDTO dynamicInfoQueryDTO){
         Map<String,Object> map = new HashMap<String,Object>();
         StringBuilder hql = new StringBuilder();
         hql.append("select t from DynamicInfo t ");
         return this.queryForPageWithParams(hql.toString(),map,dynamicInfoQueryDTO.getCurrentPage(),dynamicInfoQueryDTO.getPageSize());
    }

    public List<DynamicInfo> queryDynamicInfoList(DynamicInfoQueryDTO dynamicInfoQueryDTO){
         Map<String,Object> map = new HashMap<String,Object>();
         StringBuilder hql = new StringBuilder();
         hql.append("select t from DynamicInfo t ");
         return this.queryByMapParams(hql.toString(),map);
    }


}