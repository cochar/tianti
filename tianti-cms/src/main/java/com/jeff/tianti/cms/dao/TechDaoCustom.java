package com.jeff.tianti.cms.dao;

import com.jeff.tianti.common.entity.PageModel;
import java.util.List;
import com.jeff.tianti.cms.entity.Tech;
import com.jeff.tianti.cms.dto.TechQueryDTO;
/**
 * @author missC
 * @desc TechDaoCustom接口 
 * @date 2017-11-13
 */
public interface TechDaoCustom {

      PageModel<Tech> queryTechPage(TechQueryDTO techQueryDTO);

      List<Tech> queryTechList(TechQueryDTO techQueryDTO);



}