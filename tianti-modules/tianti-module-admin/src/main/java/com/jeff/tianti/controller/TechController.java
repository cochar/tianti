package com.jeff.tianti.controller;

import com.jeff.tianti.cms.dto.ProductQueryDTO;
import com.jeff.tianti.cms.dto.TechQueryDTO;
import com.jeff.tianti.cms.entity.Product;
import com.jeff.tianti.cms.entity.Tech;
import com.jeff.tianti.cms.service.ProductService;
import com.jeff.tianti.cms.service.TechService;
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
 * 技术Controller
 * @author MissC
 */
@Controller
@RequestMapping("/tech")
public class TechController {

    @Autowired
    private TechService techService;

    /**
     * 获取技术列表
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

        TechQueryDTO techQueryDTO= new TechQueryDTO();

        techQueryDTO.setCurrentPage(currentPage);
        techQueryDTO.setPageSize(pageSize);

        if(StringUtils.isNoneEmpty(user.getCompanyId()))
            techQueryDTO.setCompanyId(user.getCompanyId());
        PageModel<Tech> page = this.techService.queryTechPage(techQueryDTO);
//        List<Map<String,Object>> statisMapList = this.companyService.queryStatisMapList(companyQueryDTO);
//        Map<String,Object> statisMap = null;
//        if(statisMapList != null && statisMapList.size() > 0){
//            statisMap = statisMapList.get(0);
//        }
        model.addAttribute("page", page);
//        model.addAttribute("statisMap", statisMap);
        model.addAttribute("techQueryDTO", techQueryDTO);
        model.addAttribute(Constants.MENU_NAME, Constants.MENU_TECH_LIST);

        return "/tech/list";
    }

    /**
     * 跳转到技术编辑页面
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/toEdit")
    public String dialogRoleEdit(HttpServletRequest request,Model model){

        Tech tech = null;
        User user = (User)request.getSession().getAttribute(WebHelper.SESSION_LOGIN_USER);
        if(StringUtils.isNotBlank(user.getCompanyId()))
            tech = techService.find(user.getCompanyId());

        model.addAttribute("tech",tech);
        model.addAttribute(Constants.MENU_NAME, Constants.MENU_TECH_LIST);
        return "tech/edit";
    }

    /**
     * 新增技术
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/techAdd")
    public String techAdd(HttpServletRequest request,Model model){
        return "tech/tech_add";
    }

    /**
     * 保存技术
     * @param request
     * @return
     */
    @RequestMapping("/ajax/save")
    @ResponseBody
    public AjaxResult ajaxSave(HttpServletRequest request, Tech tech){
        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult.setSuccess(false);
        try {
            if (StringUtils.isNotBlank(tech.getId())) {
                Tech temp = techService.find(tech.getId());
                temp.setName(tech.getName());
                tech = temp;
                techService.save(tech);
            }else {
                tech.setAuditFlag("0");
                techService.save(tech);
            }
            ajaxResult.setSuccess(true);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return ajaxResult;
    }

    /**
     * 技术详情
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/details")
    public String toAudit(HttpServletRequest request,Model model){

        Tech  tech = techService.find(request.getParameter("id"));

        model.addAttribute("tech",tech);
        model.addAttribute(Constants.MENU_NAME, Constants.MENU_TECH_LIST);
        return "tech/audit";
    }


    /**
     * 技术审核
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
            Tech tech = techService.find(request.getParameter("id"));
            tech.setAuditFlag(request.getParameter("auditFlag"));
            User user = (User)request.getSession().getAttribute(WebHelper.SESSION_LOGIN_USER);
            tech.setAuditorId(user.getId());
            techService.save(tech);
//            }
            ajaxResult.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ajaxResult;
    }
}

