package com.jeff.tianti.cms.dto;

import com.jeff.tianti.common.dto.CommonQueryDTO;

/**
 * @author missC
 * @desc ProductQueryDTO 
 * @date 2017-11-13
 */
public class ProductQueryDTO extends CommonQueryDTO{

    //企业ID
    private String companyId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Integer getTop() {
        return top;
    }

    public void setTop(Integer top) {
        this.top = top;
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    //标题
    private String name;

    //公司
//    private String ;

    //开始时间
    private String startDate;

    //结束时间
    private String endDate;

    //前N条数据
    private Integer top;

    // 逻辑删除
    private String deleteFlag;

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

}