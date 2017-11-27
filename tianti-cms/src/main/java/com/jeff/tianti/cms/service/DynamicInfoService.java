package com.jeff.tianti.cms.service;

import com.jeff.tianti.cms.entity.DynamicInfo;
import com.jeff.tianti.cms.dao.DynamicInfoDao;
import com.jeff.tianti.cms.dto.DynamicInfoQueryDTO;
import com.jeff.tianti.common.service.CommonService;
import com.jeff.tianti.common.entity.PageModel;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * @author missC
 * @desc DynamicInfoService类 
 * @date 2017-11-27
 */
@Service
public class DynamicInfoService extends CommonService< DynamicInfo,String >  {

    @Autowired
    private DynamicInfoDao dynamicInfoDao;

    @Autowired
    public void setDynamicInfoDao(DynamicInfoDao dynamicInfoDao){
      super.setCommonDao(dynamicInfoDao);
    }

    public PageModel<DynamicInfo> queryDynamicInfoPage(DynamicInfoQueryDTO dynamicInfoQueryDTO){
           return this.dynamicInfoDao.queryDynamicInfoPage(dynamicInfoQueryDTO);
    }

    public List<DynamicInfo> queryDynamicInfoList(DynamicInfoQueryDTO dynamicInfoQueryDTO){
           return this.dynamicInfoDao.queryDynamicInfoList(dynamicInfoQueryDTO);
    }


}