package com.jeff.tianti.controller;

import com.jeff.tianti.cms.dto.SpecialistQueryDTO;
import com.jeff.tianti.cms.entity.Specialist;
import com.jeff.tianti.cms.service.SpecialistService;
import com.jeff.tianti.cms.service.SpecialistService;
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
 * 专家Controller
 * @author MissC
 */
@Controller
@RequestMapping("/specialist")
public class SpecialistController {

    @Autowired
    private SpecialistService specialistService;

    /**
     * 获取专家列表
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

        SpecialistQueryDTO specialistQueryDTO= new SpecialistQueryDTO();

        specialistQueryDTO.setCurrentPage(currentPage);
        specialistQueryDTO.setPageSize(pageSize);

        if(StringUtils.isNoneEmpty(user.getCompanyId()))
            specialistQueryDTO.setCompanyId(user.getCompanyId());
        PageModel<Specialist> page = this.specialistService.querySpecialistPage(specialistQueryDTO);
//        List<Map<String,Object>> statisMapList = this.companyService.queryStatisMapList(companyQueryDTO);
//        Map<String,Object> statisMap = null;
//        if(statisMapList != null && statisMapList.size() > 0){
//            statisMap = statisMapList.get(0);
//        }
        model.addAttribute("page", page);
//        model.addAttribute("statisMap", statisMap);
        model.addAttribute("specialistQueryDTO", specialistQueryDTO);
        model.addAttribute(Constants.MENU_NAME, Constants.MENU_TECH_LIST);

        return "/specialist/list";
    }

    /**
     * 跳转到专家编辑页面
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/toEdit")
    public String dialogRoleEdit(HttpServletRequest request,Model model, String id) {

        Specialist specialist = null;
//        User user = (User) request.getSession().getAttribute(WebHelper.SESSION_LOGIN_USER);
        if (StringUtils.isNotBlank(id))
            specialist = specialistService.find(id);

        model.addAttribute("specialist", specialist);
        model.addAttribute(Constants.MENU_NAME, Constants.MENU_TECH_LIST);
        return "specialist/edit";
    }

    /**
     * 保存专家
     * @param request
     * @return
     */
    @RequestMapping("/ajax/save")
    @ResponseBody
    public AjaxResult ajaxSave(HttpServletRequest request, Specialist specialist){
        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult.setSuccess(false);
        try {
            if (StringUtils.isNotBlank(specialist.getId())) {
                Specialist temp = specialistService.find(specialist.getId());
                temp.setName(specialist.getName());
                specialist = temp;
                specialistService.save(specialist);
            }else {
                specialistService.save(specialist);
            }
            ajaxResult.setSuccess(true);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return ajaxResult;
    }

    /**
     * 专家详情
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/details")
    public String fetch(HttpServletRequest request,Model model){

        Specialist  specialist = specialistService.find(request.getParameter("id"));

        model.addAttribute("specialist",specialist);
        model.addAttribute(Constants.MENU_NAME, Constants.MENU_TECH_LIST);
        return "specialist/details";
    }


    /**
     * 专家审核
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
            Specialist specialist = specialistService.find(request.getParameter("id"));
            specialist.setAuditFlag(request.getParameter("auditFlag"));
            User user = (User)request.getSession().getAttribute(WebHelper.SESSION_LOGIN_USER);
            specialist.setAuditorId(user.getId());
            specialistService.save(specialist);
//            }
            ajaxResult.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ajaxResult;
    }
*/
}

