package com.jeff.tianti.cms.dao;

import com.jeff.tianti.common.entity.PageModel;
import java.util.List;
import com.jeff.tianti.cms.entity.Specailist;
import com.jeff.tianti.cms.dto.SpecailistQueryDTO;
/**
 * @author missC
 * @desc SpecailistDaoCustom接口 
 * @date 2017-11-27
 */
public interface SpecailistDaoCustom {

      PageModel<Specailist> querySpecailistPage(SpecailistQueryDTO specailistQueryDTO);

      List<Specailist> querySpecailistList(SpecailistQueryDTO specailistQueryDTO);



}