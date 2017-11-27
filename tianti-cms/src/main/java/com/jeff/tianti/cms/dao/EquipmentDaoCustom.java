package com.jeff.tianti.cms.dao;

import com.jeff.tianti.common.entity.PageModel;
import java.util.List;
import com.jeff.tianti.cms.entity.Equipment;
import com.jeff.tianti.cms.dto.EquipmentQueryDTO;
/**
 * @author missC
 * @desc EquipmentDaoCustom接口 
 * @date 2017-11-27
 */
public interface EquipmentDaoCustom {

      PageModel<Equipment> queryEquipmentPage(EquipmentQueryDTO equipmentQueryDTO);

      List<Equipment> queryEquipmentList(EquipmentQueryDTO equipmentQueryDTO);



}