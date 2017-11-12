package com.jeff.tianti.org.dao;

import com.jeff.tianti.common.dao.CustomBaseSqlDaoImpl;
import com.jeff.tianti.common.entity.PageModel;
import com.jeff.tianti.org.dto.CompanyDTO;
import com.jeff.tianti.org.dto.CompanyQueryDTO;
import com.jeff.tianti.org.entity.Company;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompanyDaoImpl extends CustomBaseSqlDaoImpl implements CompanyDaoCustom {

    /**
     * 查询企业分页信息
     * @param companyQueryDTO
     * @return
     */
    public PageModel<Company> queryCompanyPage(CompanyQueryDTO companyQueryDTO) {
        Map<String,Object> params = new HashMap<String,Object>();
        StringBuilder hql = new StringBuilder();
        hql.append(" select c from Company c where 1=1 ");

        hql.append(" order by c.createDate desc ");
        return this.queryForPageWithParams(hql.toString(), params, companyQueryDTO.getCurrentPage(), companyQueryDTO.getPageSize());
    }

    @Override
    public List<Company> findCompanyList(Map<String, Object> params) {
        StringBuilder sb = new StringBuilder();
        sb.append("select c from Company c where c.deleteFlag = 0");

        sb.append("order by c.createDate desc");

        return this.queryByMapParams(sb.toString(), params);
    }
}
