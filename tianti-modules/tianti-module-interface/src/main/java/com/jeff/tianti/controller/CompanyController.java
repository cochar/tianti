package com.jeff.tianti.controller;

import com.jeff.tianti.common.dto.AjaxResult;
import com.jeff.tianti.common.entity.PageModel;
import com.jeff.tianti.org.dto.CompanyQueryDTO;
import com.jeff.tianti.org.entity.Company;
import com.jeff.tianti.org.entity.User;
import com.jeff.tianti.org.service.CompanyService;
import com.jeff.tianti.org.service.RoleService;
import com.jeff.tianti.org.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 企业Controller
 * @author missC
 */
@Controller
@RequestMapping("/company/api")
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
     * @param response
     * @return
     */
    @RequestMapping("/list")
    public String list(HttpServletRequest request,HttpServletResponse response){
        String currentPageStr = request.getParameter("currentPage");
        String pageSizeStr = request.getParameter("pageSize");
        int currentPage = 1;
        int pageSize = 10;
//        User user = (User)request.getSession().getAttribute(WebHelper.SESSION_LOGIN_USER);
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

        return "/company/list";
    }

    /**
     * 详企业详情
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/details")
    public String toAudit(HttpServletRequest request,HttpServletResponse response){

        Company  company = companyService.find(request.getParameter("id"));

        return "company/audit";
    }
}
