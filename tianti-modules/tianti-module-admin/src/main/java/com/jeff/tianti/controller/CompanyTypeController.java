package com.jeff.tianti.controller;

import com.jeff.tianti.cms.dto.CompanyTypeQueryDTO;
import com.jeff.tianti.cms.entity.CompanyType;
import com.jeff.tianti.cms.service.CompanyTypeService;
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
 * 公司维度Controller
 * @author MissC
 */
@Controller
@RequestMapping("/companyType")
public class CompanyTypeController {

    @Autowired
    private CompanyTypeService companyTypeService;

    /**
     * 获取公司维度列表
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

        CompanyTypeQueryDTO companyTypeQueryDTO= new CompanyTypeQueryDTO();

        companyTypeQueryDTO.setCurrentPage(currentPage);
        companyTypeQueryDTO.setPageSize(pageSize);

//        if(StringUtils.isNoneEmpty(user.getCompanyId()))
//            companyTypeQueryDTO.setCompanyId(user.getCompanyId());
        PageModel<CompanyType> page = this.companyTypeService.queryCompanyTypePage(companyTypeQueryDTO);
//        List<Map<String,Object>> statisMapList = this.companyService.queryStatisMapList(companyQueryDTO);
//        Map<String,Object> statisMap = null;
//        if(statisMapList != null && statisMapList.size() > 0){
//            statisMap = statisMapList.get(0);
//        }
        model.addAttribute("page", page);
//        model.addAttribute("statisMap", statisMap);
        model.addAttribute("companyTypeQueryDTO", companyTypeQueryDTO);
        model.addAttribute(Constants.MENU_NAME, Constants.MENU_COMCPANYTYPE_LIST);

        return "/companyType/list";
    }

    /**
     * 跳转到公司维度编辑页面
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/toEdit")
    public String dialogRoleEdit(HttpServletRequest request,Model model, String id) {

        CompanyType companyType = null;
//        User user = (User) request.getSession().getAttribute(WebHelper.SESSION_LOGIN_USER);
        if (StringUtils.isNotBlank(id))
            companyType = companyTypeService.find(id);

        model.addAttribute("companyType", companyType);
        model.addAttribute(Constants.MENU_NAME, Constants.MENU_COMCPANYTYPE_LIST);
        return "companyType/edit";
    }

    /**
     * 保存公司维度
     * @param request
     * @return
     */
    @RequestMapping("/ajax/save")
    @ResponseBody
    public AjaxResult ajaxSave(HttpServletRequest request, CompanyType companyType){
        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult.setSuccess(false);
        try {
            if (StringUtils.isNotBlank(companyType.getId())) {
                CompanyType temp = companyTypeService.find(companyType.getId());
                temp.setName(companyType.getName());
                companyType = temp;
                companyTypeService.save(companyType);
            }else {
                companyTypeService.save(companyType);
            }
            ajaxResult.setSuccess(true);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return ajaxResult;
    }

    /**
     * 公司维度详情
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/details")
    public String fetch(HttpServletRequest request,Model model){

        CompanyType  companyType = companyTypeService.find(request.getParameter("id"));

        model.addAttribute("companyType",companyType);
        model.addAttribute(Constants.MENU_NAME, Constants.MENU_COMCPANYTYPE_LIST);
        return "companyType/look";
    }


    /**
     * 公司维度审核
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
            CompanyType companyType = companyTypeService.find(request.getParameter("id"));
            companyType.setAuditFlag(request.getParameter("auditFlag"));
            User user = (User)request.getSession().getAttribute(WebHelper.SESSION_LOGIN_USER);
            companyType.setAuditorId(user.getId());
            companyTypeService.save(companyType);
//            }
            ajaxResult.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ajaxResult;
    }
*/
}

