package com.gientech.mpbcz.entity;

import java.math.BigDecimal;

/**
 * 预下单商品信息实体类
 */
public class PrepayMerchdInf {
    private Long id;
    private String lprCd;
    private String merchtOrdrId;
    private String merchdId;
    private String merchdNm;
    private String merchdCnt;
    private BigDecimal merchdOrgnlPrc;
    private BigDecimal merchdCostPrc;
    private BigDecimal merchdPrefrPrc;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLprCd() {
        return lprCd;
    }

    public void setLprCd(String lprCd) {
        this.lprCd = lprCd;
    }

    public String getMerchtOrdrId() {
        return merchtOrdrId;
    }

    public void setMerchtOrdrId(String merchtOrdrId) {
        this.merchtOrdrId = merchtOrdrId;
    }

    public String getMerchdId() {
        return merchdId;
    }

    public void setMerchdId(String merchdId) {
        this.merchdId = merchdId;
    }

    public String getMerchdNm() {
        return merchdNm;
    }

    public void setMerchdNm(String merchdNm) {
        this.merchdNm = merchdNm;
    }

    public String getMerchdCnt() {
        return merchdCnt;
    }

    public void setMerchdCnt(String merchdCnt) {
        this.merchdCnt = merchdCnt;
    }

    public BigDecimal getMerchdOrgnlPrc() {
        return merchdOrgnlPrc;
    }

    public void setMerchdOrgnlPrc(BigDecimal merchdOrgnlPrc) {
        this.merchdOrgnlPrc = merchdOrgnlPrc;
    }

    public BigDecimal getMerchdCostPrc() {
        return merchdCostPrc;
    }

    public void setMerchdCostPrc(BigDecimal merchdCostPrc) {
        this.merchdCostPrc = merchdCostPrc;
    }

    public BigDecimal getMerchdPrefrPrc() {
        return merchdPrefrPrc;
    }

    public void setMerchdPrefrPrc(BigDecimal merchdPrefrPrc) {
        this.merchdPrefrPrc = merchdPrefrPrc;
    }
}