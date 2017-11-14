package com.jeff.tianti.controller;

import com.jeff.tianti.cms.dto.ProductQueryDTO;
import com.jeff.tianti.cms.entity.Product;
import com.jeff.tianti.cms.service.ProductService;
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
 * 产品Controller
 * @author MissC
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * 获取产品列表
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

        ProductQueryDTO productQueryDTO= new ProductQueryDTO();

        productQueryDTO.setCurrentPage(currentPage);
        productQueryDTO.setPageSize(pageSize);

        if(StringUtils.isNoneEmpty(user.getCompanyId()))
            productQueryDTO.setCompanyId(user.getCompanyId());
        PageModel<Product> page = this.productService.queryProductPage(productQueryDTO);
//        List<Map<String,Object>> statisMapList = this.companyService.queryStatisMapList(companyQueryDTO);
//        Map<String,Object> statisMap = null;
//        if(statisMapList != null && statisMapList.size() > 0){
//            statisMap = statisMapList.get(0);
//        }
        model.addAttribute("page", page);
//        model.addAttribute("statisMap", statisMap);
        model.addAttribute("productQueryDTO", productQueryDTO);
        model.addAttribute(Constants.MENU_NAME, Constants.MENU_PRODUCT_LIST);

        return "/product/list";
    }
    @RequestMapping("/add")
    public String add(HttpServletRequest request, Model model){
        return "/product/addProduct";
    }

    /**
     * 跳转到产品编辑页面
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/toEdit")
    public String dialogRoleEdit(HttpServletRequest request,Model model){

        Product product = null;
        User user = (User)request.getSession().getAttribute(WebHelper.SESSION_LOGIN_USER);
        if(StringUtils.isNotBlank(user.getCompanyId()))
            product = productService.find(user.getCompanyId());

        model.addAttribute("product",product);
        model.addAttribute(Constants.MENU_NAME, Constants.MENU_PRODUCT_LIST);
        return "product/edit";
    }

    /**
     * 保存产品
     * @param request
     * @return
     */
    @RequestMapping("/ajax/save")
    @ResponseBody
    public AjaxResult ajaxSave(HttpServletRequest request, Product product){
        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult.setSuccess(false);
        try {
            if (StringUtils.isNotBlank(product.getId())) {
                Product temp = productService.find(product.getId());
                temp.setName(product.getName());
                product = temp;
                productService.save(product);
            }else {
                product.setAuditFlag("0");
                productService.save(product);
            }
            ajaxResult.setSuccess(true);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return ajaxResult;
    }

    /**
     * 产品详情
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/details")
    public String toAudit(HttpServletRequest request,Model model){

        Product  product = productService.find(request.getParameter("id"));

        model.addAttribute("product",product);
        model.addAttribute(Constants.MENU_NAME, Constants.MENU_PRODUCT_LIST);
        return "product/audit";
    }


    /**
     * 产品审核
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
            Product product = productService.find(request.getParameter("id"));
            product.setAuditFlag(request.getParameter("auditFlag"));
            User user = (User)request.getSession().getAttribute(WebHelper.SESSION_LOGIN_USER);
            product.setAuditorId(user.getId());
            productService.save(product);
//            }
            ajaxResult.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ajaxResult;
    }
}
