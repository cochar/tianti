package com.jeff.tianti.controller;

import com.jeff.tianti.cms.dto.DynamicInfoQueryDTO;
import com.jeff.tianti.cms.entity.DynamicInfo;
import com.jeff.tianti.cms.service.DynamicInfoService;
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
 * 动态信息Controller
 * @author MissC
 */
@Controller
@RequestMapping("/dynamicInfo")
public class DynamicInfoController {

    @Autowired
    private DynamicInfoService dynamicInfoService;

    /**
     * 获取动态信息列表
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

        DynamicInfoQueryDTO dynamicInfoQueryDTO= new DynamicInfoQueryDTO();

        dynamicInfoQueryDTO.setCurrentPage(currentPage);
        dynamicInfoQueryDTO.setPageSize(pageSize);

        if(StringUtils.isNoneEmpty(user.getCompanyId()))
            dynamicInfoQueryDTO.setCompanyId(user.getCompanyId());
        PageModel<DynamicInfo> page = this.dynamicInfoService.queryDynamicInfoPage(dynamicInfoQueryDTO);
//        List<Map<String,Object>> statisMapList = this.companyService.queryStatisMapList(companyQueryDTO);
//        Map<String,Object> statisMap = null;
//        if(statisMapList != null && statisMapList.size() > 0){
//            statisMap = statisMapList.get(0);
//        }
        model.addAttribute("page", page);
//        model.addAttribute("statisMap", statisMap);
        model.addAttribute("dynamicInfoQueryDTO", dynamicInfoQueryDTO);
        model.addAttribute(Constants.MENU_NAME, Constants.MENU_TECH_LIST);

        return "/dynamicInfo/list";
    }

    /**
     * 跳转到动态信息编辑页面
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/toEdit")
    public String dialogRoleEdit(HttpServletRequest request,Model model, String id) {

        DynamicInfo dynamicInfo = null;
//        User user = (User) request.getSession().getAttribute(WebHelper.SESSION_LOGIN_USER);
        if (StringUtils.isNotBlank(id))
            dynamicInfo = dynamicInfoService.find(id);

        model.addAttribute("dynamicInfo", dynamicInfo);
        model.addAttribute(Constants.MENU_NAME, Constants.MENU_TECH_LIST);
        return "dynamicInfo/edit";
    }

    /**
     * 保存动态信息
     * @param request
     * @return
     */
    @RequestMapping("/ajax/save")
    @ResponseBody
    public AjaxResult ajaxSave(HttpServletRequest request, DynamicInfo dynamicInfo){
        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult.setSuccess(false);
        try {
            if (StringUtils.isNotBlank(dynamicInfo.getId())) {
                DynamicInfo temp = dynamicInfoService.find(dynamicInfo.getId());
                temp.setName(dynamicInfo.getName());
                dynamicInfo = temp;
                dynamicInfoService.save(dynamicInfo);
            }else {
                dynamicInfoService.save(dynamicInfo);
            }
            ajaxResult.setSuccess(true);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return ajaxResult;
    }

    /**
     * 动态信息详情
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/details")
    public String fetch(HttpServletRequest request,Model model){

        DynamicInfo  dynamicInfo = dynamicInfoService.find(request.getParameter("id"));

        model.addAttribute("dynamicInfo",dynamicInfo);
        model.addAttribute(Constants.MENU_NAME, Constants.MENU_TECH_LIST);
        return "dynamicInfo/details";
    }


    /**
     * 动态信息审核
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
            DynamicInfo dynamicInfo = dynamicInfoService.find(request.getParameter("id"));
            dynamicInfo.setAuditFlag(request.getParameter("auditFlag"));
            User user = (User)request.getSession().getAttribute(WebHelper.SESSION_LOGIN_USER);
            dynamicInfo.setAuditorId(user.getId());
            dynamicInfoService.save(dynamicInfo);
//            }
            ajaxResult.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ajaxResult;
    }
*/
}

