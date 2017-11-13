package com.jeff.tianti.cms.dao;

import com.jeff.tianti.common.dao.CustomBaseSqlDaoImpl;
import com.jeff.tianti.common.entity.PageModel;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.jeff.tianti.cms.entity.Tech;
import com.jeff.tianti.cms.dto.TechQueryDTO;
/**
 * @author missC
 * @desc TechDaoImpl类 
 * @date 2017-11-13
 */

public class TechDaoImpl extends CustomBaseSqlDaoImpl implements TechDaoCustom  {

    public PageModel<Tech> queryTechPage(TechQueryDTO techQueryDTO){
         Map<String,Object> map = new HashMap<String,Object>();
         StringBuilder hql = new StringBuilder();
         hql.append("select t from Tech t ");
         return this.queryForPageWithParams(hql.toString(),map,techQueryDTO.getCurrentPage(),techQueryDTO.getPageSize());
    }

    public List<Tech> queryTechList(TechQueryDTO techQueryDTO){
         Map<String,Object> map = new HashMap<String,Object>();
         StringBuilder hql = new StringBuilder();
         hql.append("select t from Tech t ");
         return this.queryByMapParams(hql.toString(),map);
    }


}