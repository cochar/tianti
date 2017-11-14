package com.jeff.tianti.org.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jeff.tianti.common.dao.CommonDao;
import com.jeff.tianti.common.dto.AjaxResult;
import com.jeff.tianti.common.entity.PageModel;
import com.jeff.tianti.org.dao.CompanyDao;
import com.jeff.tianti.org.dao.UserDao;
import com.jeff.tianti.org.dto.CompanyQueryDTO;
import com.jeff.tianti.org.dto.UserQueryDTO;
import com.jeff.tianti.org.entity.Company;
import com.jeff.tianti.org.entity.Resource;
import com.jeff.tianti.org.entity.Role;
import com.jeff.tianti.org.entity.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeff.tianti.common.service.CommonService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class CompanyService  extends CommonService<Company,String> {

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    public void setCompanyDao(CompanyDao companyDao) {
        super.setCommonDao(companyDao);
    }
    /**
     * 查询企业分页信息
     * @param companyQueryDTO
     * @return
     */
    public PageModel<Company> queryCompanyPage(CompanyQueryDTO companyQueryDTO){
        return this.companyDao.queryCompanyPage(companyQueryDTO);
    }

    /**
     * 查询企业列表信息
     * @param companyQueryDTO
     * @return
     */
    public List<Company> queryCompanyList(CompanyQueryDTO companyQueryDTO){
        return this.companyDao.queryCompanyList(companyQueryDTO);
    }

}
