package com.jeff.tianti.cms.dao;

import com.jeff.tianti.common.dao.CustomBaseSqlDaoImpl;
import com.jeff.tianti.common.entity.PageModel;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.jeff.tianti.cms.entity.Specailist;
import com.jeff.tianti.cms.dto.SpecailistQueryDTO;
/**
 * @author missC
 * @desc SpecailistDaoImpl类 
 * @date 2017-11-27
 */

public class SpecailistDaoImpl extends CustomBaseSqlDaoImpl implements SpecailistDaoCustom  {

    public PageModel<Specailist> querySpecailistPage(SpecailistQueryDTO specailistQueryDTO){
         Map<String,Object> map = new HashMap<String,Object>();
         StringBuilder hql = new StringBuilder();
         hql.append("select t from Specailist t ");
         return this.queryForPageWithParams(hql.toString(),map,specailistQueryDTO.getCurrentPage(),specailistQueryDTO.getPageSize());
    }

    public List<Specailist> querySpecailistList(SpecailistQueryDTO specailistQueryDTO){
         Map<String,Object> map = new HashMap<String,Object>();
         StringBuilder hql = new StringBuilder();
         hql.append("select t from Specailist t ");
         return this.queryByMapParams(hql.toString(),map);
    }


}