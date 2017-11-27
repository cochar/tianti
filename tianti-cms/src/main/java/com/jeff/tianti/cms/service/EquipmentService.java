package com.jeff.tianti.cms.service;

import com.jeff.tianti.cms.entity.Equipment;
import com.jeff.tianti.cms.dao.EquipmentDao;
import com.jeff.tianti.cms.dto.EquipmentQueryDTO;
import com.jeff.tianti.common.service.CommonService;
import com.jeff.tianti.common.entity.PageModel;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * @author missC
 * @desc EquipmentService类 
 * @date 2017-11-27
 */
@Service
public class EquipmentService extends CommonService< Equipment,String >  {

    @Autowired
    private EquipmentDao equipmentDao;

    @Autowired
    public void setEquipmentDao(EquipmentDao equipmentDao){
      super.setCommonDao(equipmentDao);
    }

    public PageModel<Equipment> queryEquipmentPage(EquipmentQueryDTO equipmentQueryDTO){
           return this.equipmentDao.queryEquipmentPage(equipmentQueryDTO);
    }

    public List<Equipment> queryEquipmentList(EquipmentQueryDTO equipmentQueryDTO){
           return this.equipmentDao.queryEquipmentList(equipmentQueryDTO);
    }


}