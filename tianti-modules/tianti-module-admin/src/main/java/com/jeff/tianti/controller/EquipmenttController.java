package com.jeff.tianti.controller;

import com.jeff.tianti.cms.dto.EquipmentQueryDTO;
import com.jeff.tianti.cms.entity.Equipment;
import com.jeff.tianti.cms.service.EquipmentService;
import com.jeff.tianti.common.dto.AjaxResult;
import com.jeff.tianti.common.entity.PageModel;
import com.jeff.tianti.org.entity.User;
import com.jeff.tianti.util.Constants;
import com.jeff.tianti.util.WebHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 设备Controller
 * @author MissC
 */
@Controller
@RequestMapping("/equipment")
public class EquipmenttController {

    @Autowired
    private EquipmentService equipmentService;

    /**
     * 获取设备列表
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/list")
    public String list(HttpServletRequest request, Model model){
        String currentPageStr = request.getParameter("currentPage");
        String pageSizeStr = request.getParameter("pageSize");
        int currentPage = 1;
        int pageSize = 10;
        User user = (User)request.getSession().getAttribute(WebHelper.SESSION_LOGIN_USER);
        if(StringUtils.isNotBlank(currentPageStr)){
            currentPage = Integer.parseInt(currentPageStr);
        }
        if(StringUtils.isNotBlank(pageSizeStr)){
            pageSize = Integer.parseInt(pageSizeStr);
        }

        EquipmentQueryDTO equipmentQueryDTO= new EquipmentQueryDTO();

        equipmentQueryDTO.setCurrentPage(currentPage);
        equipmentQueryDTO.setPageSize(pageSize);

        if(StringUtils.isNoneEmpty(user.getCompanyId()))
            equipmentQueryDTO.setCompanyId(user.getCompanyId());
        PageModel<Equipment> page = this.equipmentService.queryEquipmentPage(equipmentQueryDTO);
//        List<Map<String,Object>> statisMapList = this.companyService.queryStatisMapList(companyQueryDTO);
//        Map<String,Object> statisMap = null;
//        if(statisMapList != null && statisMapList.size() > 0){
//            statisMap = statisMapList.get(0);
//        }
        model.addAttribute("page", page);
//        model.addAttribute("statisMap", statisMap);
        model.addAttribute("equipmentQueryDTO", equipmentQueryDTO);
        model.addAttribute(Constants.MENU_NAME, Constants.MENU_TECH_LIST);

        return "/equipment/list";
    }

    /**
     * 跳转到设备编辑页面
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/toEdit")
    public String dialogRoleEdit(HttpServletRequest request,Model model, String id) {

        Equipment equipment = null;
//        User user = (User) request.getSession().getAttribute(WebHelper.SESSION_LOGIN_USER);
        if (StringUtils.isNotBlank(id))
            equipment = equipmentService.find(id);

        model.addAttribute("equipment", equipment);
        model.addAttribute(Constants.MENU_NAME, Constants.MENU_TECH_LIST);
        return "equipment/edit";
    }

    /**
     * 保存设备
     * @param request
     * @return
     */
    @RequestMapping("/ajax/save")
    @ResponseBody
    public AjaxResult ajaxSave(HttpServletRequest request, Equipment equipment){
        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult.setSuccess(false);
        try {
            if (StringUtils.isNotBlank(equipment.getId())) {
                Equipment temp = equipmentService.find(equipment.getId());
                temp.setName(equipment.getName());
                equipment = temp;
                equipmentService.save(equipment);
            }else {
                equipmentService.save(equipment);
            }
            ajaxResult.setSuccess(true);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return ajaxResult;
    }

    /**
     * 设备详情
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/details")
    public String fetch(HttpServletRequest request,Model model){

        Equipment  equipment = equipmentService.find(request.getParameter("id"));

        model.addAttribute("equipment",equipment);
        model.addAttribute(Constants.MENU_NAME, Constants.MENU_TECH_LIST);
        return "equipment/look";
    }


    /**
     * 设备审核
     * @param request
     * @return
     */
    /*@RequestMapping("/ajax/audit")
    @ResponseBody
    public AjaxResult ajaxAudit(HttpServletRequest request){
        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult.setSuccess(false);

        try {
//            if(StringUtils.isNotBlank(request.getParameter("id")) && StringUtils.isNotBlank(request.getParameter("auditFlag"))){
            Equipment equipment = equipmentService.find(request.getParameter("id"));
            equipment.setAuditFlag(request.getParameter("auditFlag"));
            User user = (User)request.getSession().getAttribute(WebHelper.SESSION_LOGIN_USER);
            equipment.setAuditorId(user.getId());
            equipmentService.save(equipment);
//            }
            ajaxResult.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ajaxResult;
    }
*/
}

