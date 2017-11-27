package com.jeff.tianti.cms.dao;

import com.jeff.tianti.common.dao.CustomBaseSqlDaoImpl;
import com.jeff.tianti.common.entity.PageModel;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.jeff.tianti.cms.entity.Equipment;
import com.jeff.tianti.cms.dto.EquipmentQueryDTO;
import org.apache.commons.lang3.StringUtils;

/**
 * @author missC
 * @desc EquipmentDaoImpl类 
 * @date 2017-11-27
 */

public class EquipmentDaoImpl extends CustomBaseSqlDaoImpl implements EquipmentDaoCustom  {

    public PageModel<Equipment> queryEquipmentPage(EquipmentQueryDTO equipmentQueryDTO){
         Map<String,Object> map = new HashMap<String,Object>();
         StringBuilder hql = new StringBuilder();
         hql.append("select t from Equipment t where 1=1 ");
        if(StringUtils.isNotBlank(equipmentQueryDTO.getCompanyId())) {
            hql.append("and t.company.id =: companyId ");
            map.put("companyId",equipmentQueryDTO.getCompanyId());
        }
         return this.queryForPageWithParams(hql.toString(),map,equipmentQueryDTO.getCurrentPage(),equipmentQueryDTO.getPageSize());
    }

    public List<Equipment> queryEquipmentList(EquipmentQueryDTO equipmentQueryDTO){
         Map<String,Object> map = new HashMap<String,Object>();
         StringBuilder hql = new StringBuilder();
         hql.append("select t from Equipment t where 1=1 ");
        if(StringUtils.isNotBlank(equipmentQueryDTO.getCompanyId())) {
            hql.append("and t.company.id =: companyId ");
            map.put("companyId",equipmentQueryDTO.getCompanyId());
        }
         return this.queryByMapParams(hql.toString(),map);
    }


}