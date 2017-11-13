package com.jeff.tianti.cms.service;

import com.jeff.tianti.cms.entity.Product;
import com.jeff.tianti.cms.dao.ProductDao;
import com.jeff.tianti.cms.dto.ProductQueryDTO;
import com.jeff.tianti.common.service.CommonService;
import com.jeff.tianti.common.entity.PageModel;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * @author missC
 * @desc ProductService类 
 * @date 2017-11-13
 */
@Service
public class ProductService extends CommonService< Product,String >  {

    @Autowired
    private ProductDao productDao;

    @Autowired
    public void setProductDao(ProductDao productDao){
      super.setCommonDao(productDao);
    }

    public PageModel<Product> queryProductPage(ProductQueryDTO productQueryDTO){
           return this.productDao.queryProductPage(productQueryDTO);
    }

    public List<Product> queryProductList(ProductQueryDTO productQueryDTO){
           return this.productDao.queryProductList(productQueryDTO);
    }


}