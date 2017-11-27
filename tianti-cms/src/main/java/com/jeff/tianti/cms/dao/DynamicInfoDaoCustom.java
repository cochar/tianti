package com.jeff.tianti.cms.dao;

import com.jeff.tianti.common.entity.PageModel;
import java.util.List;
import com.jeff.tianti.cms.entity.DynamicInfo;
import com.jeff.tianti.cms.dto.DynamicInfoQueryDTO;
/**
 * @author missC
 * @desc DynamicInfoDaoCustom接口 
 * @date 2017-11-27
 */
public interface DynamicInfoDaoCustom {

      PageModel<DynamicInfo> queryDynamicInfoPage(DynamicInfoQueryDTO dynamicInfoQueryDTO);

      List<DynamicInfo> queryDynamicInfoList(DynamicInfoQueryDTO dynamicInfoQueryDTO);



}