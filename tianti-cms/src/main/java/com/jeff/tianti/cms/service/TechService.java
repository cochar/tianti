package com.jeff.tianti.cms.service;

import com.jeff.tianti.cms.entity.Tech;
import com.jeff.tianti.cms.dao.TechDao;
import com.jeff.tianti.cms.dto.TechQueryDTO;
import com.jeff.tianti.common.service.CommonService;
import com.jeff.tianti.common.entity.PageModel;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * @author missC
 * @desc TechService类 
 * @date 2017-11-13
 */
@Service
public class TechService extends CommonService< Tech,String >  {

    @Autowired
    private TechDao techDao;

    @Autowired
    public void setTechDao(TechDao techDao){
      super.setCommonDao(techDao);
    }

    public PageModel<Tech> queryTechPage(TechQueryDTO techQueryDTO){
           return this.techDao.queryTechPage(techQueryDTO);
    }

    public List<Tech> queryTechList(TechQueryDTO techQueryDTO){
           return this.techDao.queryTechList(techQueryDTO);
    }


}