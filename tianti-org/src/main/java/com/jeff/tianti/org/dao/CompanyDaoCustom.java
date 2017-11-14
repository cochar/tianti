package com.jeff.tianti.org.dao;

import com.jeff.tianti.common.entity.PageModel;
import com.jeff.tianti.org.dto.CompanyDTO;
import com.jeff.tianti.org.dto.CompanyQueryDTO;
import com.jeff.tianti.org.entity.Company;
import com.jeff.tianti.org.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface CompanyDaoCustom {

    /**
     * 查询企业分页信息
     * @param companyQueryDTO
     * @return
     */
    PageModel<Company> queryCompanyPage(CompanyQueryDTO companyQueryDTO);

    public List<Company> queryCompanyList(CompanyQueryDTO companyQueryDTO);

}
