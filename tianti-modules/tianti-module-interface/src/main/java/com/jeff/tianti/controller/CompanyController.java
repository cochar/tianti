package com.jeff.tianti.controller;

import com.jeff.tianti.cms.entity.Article;
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
import java.util.List;

/**
 * 企业Controller
 * @author missC
 */
@Controller
@RequestMapping("/company/api")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    /**
     * 获取企业列表
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public AjaxResult list(HttpServletRequest request,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
        AjaxResult ajaxResult = new AjaxResult();
        //是否分页:1为是，0为否，默认为分页
        String isPage = request.getParameter("isPage");
//        //type为shenhe时获取审核通过的数据，type为zhiding时获取置顶的数据
//        String type = request.getParameter("type");
        //获取前N条的数据
        String topStr = request.getParameter("top");
        String currentPageStr = request.getParameter("currentPage");
        String pageSizeStr = request.getParameter("pageSize");

        int currentPage = 1;
        int pageSize = 10;
        Integer top = null;
        if(StringUtils.isNotBlank(currentPageStr)){
            currentPage = Integer.parseInt(currentPageStr);
        }
        if(StringUtils.isNotBlank(pageSizeStr)){
            pageSize = Integer.parseInt(pageSizeStr);
        }
        if(StringUtils.isNotBlank(topStr)){
            top = Integer.parseInt(topStr);
        }

        PageModel<Company> page = null;
        List<Company> list = null;
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
        companyQueryDTO.setTop(top);
//        companyQueryDTO.setType(type);
        companyQueryDTO.setDeleteFlag(Article.DELETE_FLAG_NORMAL);
        if(StringUtils.isNotBlank(isPage)){
            if(isPage.equals("1")){
                page = this.companyService.queryCompanyPage(companyQueryDTO);
                ajaxResult.setData(page);
            }else{
                list = this.companyService.queryCompanyList(companyQueryDTO);
                ajaxResult.setData(list);
            }
        }else{
            page = this.companyService.queryCompanyPage(companyQueryDTO);
            ajaxResult.setData(page);
        }
        ajaxResult.setSuccess(true);
        return ajaxResult;
    }

    /**
     * 详企业详情
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/details")
    @ResponseBody
    public AjaxResult toAudit(HttpServletRequest request,HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
        AjaxResult ajaxResult = new AjaxResult();
        String id = request.getParameter("id");
        Company company = null;
        if (StringUtils.isNotBlank(id)) {
            company = this.companyService.find(id);
//            if(company != null){
//                company.setViewCount(article.getViewCount() == null ? 1 : article.getViewCount()+1);
//                this.companyService.update(article);
//            }
        }
        ajaxResult.setSuccess(true);
        ajaxResult.setData(company);
        return ajaxResult;
    }
}
