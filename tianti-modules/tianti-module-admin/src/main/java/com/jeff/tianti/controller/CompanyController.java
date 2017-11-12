package com.jeff.tianti.controller;

import com.jeff.tianti.cms.dto.ArticleQueryDTO;
import com.jeff.tianti.cms.entity.Article;
import com.jeff.tianti.cms.service.ArticleService;
import com.jeff.tianti.common.dto.AjaxResult;
import com.jeff.tianti.common.entity.PageModel;
import com.jeff.tianti.org.dto.CompanyQueryDTO;
import com.jeff.tianti.org.entity.Company;
import com.jeff.tianti.org.entity.Resource;
import com.jeff.tianti.org.entity.Role;
import com.jeff.tianti.org.entity.User;
import com.jeff.tianti.org.service.CompanyService;
import com.jeff.tianti.org.service.RoleService;
import com.jeff.tianti.org.service.UserService;
import com.jeff.tianti.util.Constants;
import com.jeff.tianti.util.WebHelper;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 企业的Controller
 * @author MissC
 */
@Controller
@RequestMapping("/com")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    /**
     * 获取企业列表
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/list")
    public String companyList(HttpServletRequest request, Model model){
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

        CompanyQueryDTO companyQueryDTO= new CompanyQueryDTO();

        companyQueryDTO.setCurrentPage(currentPage);
        companyQueryDTO.setPageSize(pageSize);
        PageModel<Company> page = this.companyService.queryCompanyPage(companyQueryDTO);
//        List<Map<String,Object>> statisMapList = this.companyService.queryStatisMapList(companyQueryDTO);
//        Map<String,Object> statisMap = null;
//        if(statisMapList != null && statisMapList.size() > 0){
//            statisMap = statisMapList.get(0);
//        }
        model.addAttribute("page", page);
//        model.addAttribute("statisMap", statisMap);
        model.addAttribute("companyQueryDTO", companyQueryDTO);
        model.addAttribute(Constants.MENU_NAME, Constants.MENU_COMPANY_LIST);

        return "/company/list";
    }

    /**
     * 跳转到企业编辑页面
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/toEdit")
    public String dialogRoleEdit(HttpServletRequest request,Model model){

        Company company = null;
        User user = (User)request.getSession().getAttribute(WebHelper.SESSION_LOGIN_USER);
        if(StringUtils.isNotBlank(user.getCompanyId()))
            company = companyService.find(user.getCompanyId());

        model.addAttribute("company",company);
        model.addAttribute(Constants.MENU_NAME, Constants.MENU_COMPANY_INFO);
        return "company/edit";
    }

    /**
     * 保存企业
     * @param request
     * @return
     */
    @RequestMapping("/ajax/save")
    @ResponseBody
    public AjaxResult ajaxSave(HttpServletRequest request,Company company){
        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult.setSuccess(false);
        try {
            if (StringUtils.isNotBlank(company.getId())) {
                Company temp = companyService.find(company.getId());
                temp.setName(company.getName());
                company = temp;
                companyService.save(company);
            }else {
                company.setAuditFlag("0");
                companyService.save(company);
                User user = (User) request.getSession().getAttribute(WebHelper.SESSION_LOGIN_USER);
                user.setCompanyId(company.getId());//插入company时，新增ID。
                userService.save(user);
            }
            ajaxResult.setSuccess(true);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return ajaxResult;
    }

    /**
     * 详企业情
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/details")
    public String toAudit(HttpServletRequest request,Model model){

        Company  company = companyService.find(request.getParameter("id"));

        model.addAttribute("company",company);
        model.addAttribute(Constants.MENU_NAME, Constants.MENU_COMPANY_INFO);
        return "company/audit";
    }


    /**
     * 企业审核
     * @param request
     * @return
     */
    @RequestMapping("/ajax/audit")
    @ResponseBody
    public AjaxResult ajaxAudit(HttpServletRequest request){
        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult.setSuccess(false);

        try {
//            if(StringUtils.isNotBlank(request.getParameter("id")) && StringUtils.isNotBlank(request.getParameter("auditFlag"))){
            Company company = companyService.find(request.getParameter("id"));
            company.setAuditFlag(request.getParameter("auditFlag"));
            User user = (User)request.getSession().getAttribute(WebHelper.SESSION_LOGIN_USER);
            company.setAuditorId(user.getId());
            companyService.save(company);
            Set<Role> set = new HashSet<Role>();
            set.add(roleService.find("402880895f8effed015f8f1af3bb0000"));
            User comAdmin = userService.findUserByCompanyId(company.getId());
            comAdmin.setRoles(set);
            userService.save(comAdmin);
//            }
            ajaxResult.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ajaxResult;
    }
}
