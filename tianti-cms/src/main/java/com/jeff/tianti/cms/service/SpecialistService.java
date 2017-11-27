package com.jeff.tianti.cms.service;

import com.jeff.tianti.cms.entity.Specialist;
import com.jeff.tianti.cms.dao.SpecialistDao;
import com.jeff.tianti.cms.dto.SpecialistQueryDTO;
import com.jeff.tianti.common.service.CommonService;
import com.jeff.tianti.common.entity.PageModel;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * @author missC
 * @desc SpecialistService类
 * @date 2017-11-27
 */
@Service
public class SpecialistService extends CommonService< Specialist,String >  {

    @Autowired
    private SpecialistDao specialistDao;

    @Autowired
    public void setSpecialistDao(SpecialistDao specialistDao){
      super.setCommonDao(specialistDao);
    }

    public PageModel<Specialist> querySpecialistPage(SpecialistQueryDTO specialistQueryDTO){
           return this.specialistDao.querySpecialistPage(specialistQueryDTO);
    }

    public List<Specialist> querySpecialistList(SpecialistQueryDTO specialistQueryDTO){
           return this.specialistDao.querySpecialistList(specialistQueryDTO);
    }


}