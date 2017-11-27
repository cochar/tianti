package com.jeff.tianti.cms.service;

import com.jeff.tianti.cms.entity.Specailist;
import com.jeff.tianti.cms.dao.SpecailistDao;
import com.jeff.tianti.cms.dto.SpecailistQueryDTO;
import com.jeff.tianti.common.service.CommonService;
import com.jeff.tianti.common.entity.PageModel;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * @author missC
 * @desc SpecailistService类 
 * @date 2017-11-27
 */
@Service
public class SpecailistService extends CommonService< Specailist,String >  {

    @Autowired
    private SpecailistDao specailistDao;

    @Autowired
    public void setSpecailistDao(SpecailistDao specailistDao){
      super.setCommonDao(specailistDao);
    }

    public PageModel<Specailist> querySpecailistPage(SpecailistQueryDTO specailistQueryDTO){
           return this.specailistDao.querySpecailistPage(specailistQueryDTO);
    }

    public List<Specailist> querySpecailistList(SpecailistQueryDTO specailistQueryDTO){
           return this.specailistDao.querySpecailistList(specailistQueryDTO);
    }


}