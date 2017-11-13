package com.jeff.tianti.org.entity;

import com.jeff.tianti.common.entity.BaseEntity;

import javax.persistence.*;
import javax.print.DocFlavor;

/**
 * 企业
 * @author missC
 *
 */
@Entity
@Table(name = "org_company")
public class Company extends BaseEntity {

    private static final long serialVersionUID = -8821121831372299051L;

    //名称
    private String name;

    //审核人
    private String auditorId;

    //发布状态
    private String postStatus;

    //行业类型
    private  String industryType;

    //行业类型2
    private String viceIndustryTypes;

    //产品类型
    private String productType;

    //产品类型2
    private String byproductType;

    //企业性质
    private String businessNature;

    //资本来源
    private String investmentSource;

    //资本规模
    private String investmentScale;

    //项目区
    private String projectArea;

    //官网
    private String url;

    //介绍
    private String introduction;

    //发展
    private String development;

    //公司名片
    private String businessCard;

    //优势
    private String advantage;

    //荣誉
    private String honor;

    //研发团队
    private String rndTeam;

    @Column(name = "name",length=64)
    public String getName() {
        return name;
    }

    public void setName(String name){ this.name = name; }

    @Column(name = "auditor_id",length=32)
    public String getAuditorId() {
        return auditorId;
    }

    public void setAuditorId(String auditorId){ this.auditorId = auditorId; }

    @Column(name = "post_status",length=1)
    public String getPostStatus() {
        return postStatus;
    }

    public void setPostStatus(String postStatus) {
        this.postStatus = postStatus;
    }

    @Column(name = "industry_type",length=64)
    public String getIndustryType() {
        return industryType;
    }

    public void setIndustryType(String industryType) {
        this.industryType = industryType;
    }

    @Column(name = "vice_industry_types",length=32)
    public String getViceIndustryTypes() {
        return viceIndustryTypes;
    }

    public void setViceIndustryTypes(String viceIndustryTypes) {
        this.viceIndustryTypes = viceIndustryTypes;
    }

    @Column(name = "product_type",length=32)
    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    @Column(name = "byproduct_type",length=32)
    public String getByproductType() {
        return byproductType;
    }

    public void setByproductType(String byproductType) {
        this.byproductType = byproductType;
    }

    @Column(name = "business_nature",length=2)
    public String getBusinessNature() {
        return businessNature;
    }

    public void setBusinessNature(String businessNature) {
        this.businessNature = businessNature;
    }

    @Column(name = "investment_source",length=32)
    public String getInvestmentSource() {
        return investmentSource;
    }

    public void setInvestmentSource(String investmentSource) {
        this.investmentSource = investmentSource;
    }

    @Column(name = "investment_scale",length=32)
    public String getInvestmentScale() {
        return investmentScale;
    }

    public void setInvestmentScale(String investmentScale) {
        this.investmentScale = investmentScale;
    }

    @Column(name = "project_area",length=32)
    public String getProjectArea() {
        return projectArea;
    }

    public void setProjectArea(String projectArea) {
        this.projectArea = projectArea;
    }

    @Column(name = "url",length=64)
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Column(name = "introduction",length=2000)
    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    @Column(name = "development",length=2000)
    public String getDevelopment() {
        return development;
    }

    public void setDevelopment(String development) {
        this.development = development;
    }

    @Column(name = "name",length=64)
    public String getBusinessCard() {
        return businessCard;
    }

    public void setBusinessCard(String businessCard) {
        this.businessCard = businessCard;
    }

    @Column(name = "advantage",length=2000)
    public String getAdvantage() {
        return advantage;
    }

    public void setAdvantage(String advantage) {
        this.advantage = advantage;
    }

    @Column(name = "honor",length=2000)
    public String getHonor() {
        return honor;
    }

    public void setHonor(String honor) {
        this.honor = honor;
    }

    @Column(name = "rnd_team",length=2000)
    public String getRndTeam() {
        return rndTeam;
    }

    public void setRndTeam(String rndTeam) {
        this.rndTeam = rndTeam;
    }
}

