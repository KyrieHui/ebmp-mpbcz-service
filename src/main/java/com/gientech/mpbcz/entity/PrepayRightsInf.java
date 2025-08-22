package com.gientech.mpbcz.entity;

import java.math.BigDecimal;

/**
 * 预下单权益信息实体类
 */
public class PrepayRightsInf {
    private Long id;
    private String lprCd;
    private String merchtOrdrId;
    private String rightsId;
    private String rightsDtlId;
    private String rightsNm;
    private BigDecimal rightsAmt;

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

    public String getRightsId() {
        return rightsId;
    }

    public void setRightsId(String rightsId) {
        this.rightsId = rightsId;
    }

    public String getRightsDtlId() {
        return rightsDtlId;
    }

    public void setRightsDtlId(String rightsDtlId) {
        this.rightsDtlId = rightsDtlId;
    }

    public String getRightsNm() {
        return rightsNm;
    }

    public void setRightsNm(String rightsNm) {
        this.rightsNm = rightsNm;
    }

    public BigDecimal getRightsAmt() {
        return rightsAmt;
    }

    public void setRightsAmt(BigDecimal rightsAmt) {
        this.rightsAmt = rightsAmt;
    }
}