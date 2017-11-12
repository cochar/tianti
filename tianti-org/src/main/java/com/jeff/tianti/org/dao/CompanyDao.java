package com.jeff.tianti.org.dao;

import com.jeff.tianti.common.dao.CommonDao;
import com.jeff.tianti.common.entity.PageModel;
import com.jeff.tianti.org.dto.CompanyDTO;
import com.jeff.tianti.org.dto.UserQueryDTO;
import com.jeff.tianti.org.entity.Company;
import com.jeff.tianti.org.entity.Resource;
import com.jeff.tianti.org.entity.User;

public interface CompanyDao  extends CompanyDaoCustom, CommonDao<Company,String>{



}
