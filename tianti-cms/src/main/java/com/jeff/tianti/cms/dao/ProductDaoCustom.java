package com.jeff.tianti.cms.dao;

import com.jeff.tianti.common.entity.PageModel;
import java.util.List;
import com.jeff.tianti.cms.entity.Product;
import com.jeff.tianti.cms.dto.ProductQueryDTO;
/**
 * @author missC
 * @desc ProductDaoCustom接口 
 * @date 2017-11-13
 */
public interface ProductDaoCustom {

      PageModel<Product> queryProductPage(ProductQueryDTO productQueryDTO);

      List<Product> queryProductList(ProductQueryDTO productQueryDTO);



}