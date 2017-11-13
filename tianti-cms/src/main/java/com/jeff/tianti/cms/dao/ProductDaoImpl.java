package com.jeff.tianti.cms.dao;

import com.jeff.tianti.common.dao.CustomBaseSqlDaoImpl;
import com.jeff.tianti.common.entity.PageModel;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.jeff.tianti.cms.entity.Product;
import com.jeff.tianti.cms.dto.ProductQueryDTO;
/**
 * @author missC
 * @desc ProductDaoImpl类 
 * @date 2017-11-13
 */

public class ProductDaoImpl extends CustomBaseSqlDaoImpl implements ProductDaoCustom  {

    public PageModel<Product> queryProductPage(ProductQueryDTO productQueryDTO){
         Map<String,Object> map = new HashMap<String,Object>();
         StringBuilder hql = new StringBuilder();
         hql.append("select t from Product t ");
         return this.queryForPageWithParams(hql.toString(),map,productQueryDTO.getCurrentPage(),productQueryDTO.getPageSize());
    }

    public List<Product> queryProductList(ProductQueryDTO productQueryDTO){
         Map<String,Object> map = new HashMap<String,Object>();
         StringBuilder hql = new StringBuilder();
         hql.append("select t from Product t ");
         return this.queryByMapParams(hql.toString(),map);
    }


}