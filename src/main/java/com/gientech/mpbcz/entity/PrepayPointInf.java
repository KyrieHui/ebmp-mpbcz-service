package com.gientech.mpbcz.entity;

import java.math.BigDecimal;

/**
 * 预下单积分信息实体类
 */
public class PrepayPointInf {
    private Long id;
    private String lprCd;
    private String merchtOrdrId;
    private String sumPointId;
    private Long pointCnt;
    private BigDecimal pointExchgRto;
    private BigDecimal pointComutAmt;

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

    public String getSumPointId() {
        return sumPointId;
    }

    public void setSumPointId(String sumPointId) {
        this.sumPointId = sumPointId;
    }

    public Long getPointCnt() {
        return pointCnt;
    }

    public void setPointCnt(Long pointCnt) {
        this.pointCnt = pointCnt;
    }

    public BigDecimal getPointExchgRto() {
        return pointExchgRto;
    }

    public void setPointExchgRto(BigDecimal pointExchgRto) {
        this.pointExchgRto = pointExchgRto;
    }

    public BigDecimal getPointComutAmt() {
        return pointComutAmt;
    }

    public void setPointComutAmt(BigDecimal pointComutAmt) {
        this.pointComutAmt = pointComutAmt;
    }
}