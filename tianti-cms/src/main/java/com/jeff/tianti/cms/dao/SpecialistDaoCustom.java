package com.jeff.tianti.cms.dao;

import com.jeff.tianti.common.entity.PageModel;
import java.util.List;
import com.jeff.tianti.cms.entity.Specialist;
import com.jeff.tianti.cms.dto.SpecialistQueryDTO;
/**
 * @author missC
 * @desc SpecialistDaoCustom接口
 * @date 2017-11-27
 */
public interface SpecialistDaoCustom {

      PageModel<Specialist> querySpecialistPage(SpecialistQueryDTO specialistQueryDTO);

      List<Specialist> querySpecialistList(SpecialistQueryDTO specialistQueryDTO);



}