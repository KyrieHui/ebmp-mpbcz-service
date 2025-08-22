package com.gientech.mpbcz.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 预下单实体类
 */
public class PrepayOrder {
    private Long id;
    private String lprCd;
    private String globalSeqNum;
    private String merchtOrdrId;
    private String bpaasOrdrId;
    private String usrId;
    private String usrOpenOrgId;
    private String usrBelgOrgId;
    private String mgrOrgId;
    private Date bizTxTm;
    private String contrMerchtId;
    private String contrMerchtNm;
    private String merchtId;
    private String merchtNm;
    private String secMerchtId;
    private BigDecimal orgnlPrc;
    private BigDecimal prcAmt;
    private Long pointPrcCnt;
    private BigDecimal costPrc;
    private BigDecimal payTotlAmt;
    private BigDecimal rightsTotlAmt;
    private Long pointTotlCnt;
    private BigDecimal pointTotlAmt;
    private Long pointKhFlg;
    private BigDecimal advMoneyAmt;
    private BigDecimal custPayAmt;
    private String bizTpCd;
    private String evtCd;
    private Date ordrValidPrd;
    private String ccy;
    private String usrIp;
    private String tellrNo;
    private String orgCd;
    private String rtnAdr;
    private String advsAdr;
    private String payrCpln;
    private String payrCertTp;
    private String payrCertNo;
    private String payrMoblNo;
    private String payrMail;
    private String ordrRmrk;

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

    public String getGlobalSeqNum() {
        return globalSeqNum;
    }

    public void setGlobalSeqNum(String globalSeqNum) {
        this.globalSeqNum = globalSeqNum;
    }

    public String getMerchtOrdrId() {
        return merchtOrdrId;
    }

    public void setMerchtOrdrId(String merchtOrdrId) {
        this.merchtOrdrId = merchtOrdrId;
    }

    public String getBpaasOrdrId() {
        return bpaasOrdrId;
    }

    public void setBpaasOrdrId(String bpaasOrdrId) {
        this.bpaasOrdrId = bpaasOrdrId;
    }

    public String getUsrId() {
        return usrId;
    }

    public void setUsrId(String usrId) {
        this.usrId = usrId;
    }

    public String getUsrOpenOrgId() {
        return usrOpenOrgId;
    }

    public void setUsrOpenOrgId(String usrOpenOrgId) {
        this.usrOpenOrgId = usrOpenOrgId;
    }

    public String getUsrBelgOrgId() {
        return usrBelgOrgId;
    }

    public void setUsrBelgOrgId(String usrBelgOrgId) {
        this.usrBelgOrgId = usrBelgOrgId;
    }

    public String getMgrOrgId() {
        return mgrOrgId;
    }

    public void setMgrOrgId(String mgrOrgId) {
        this.mgrOrgId = mgrOrgId;
    }

    public Date getBizTxTm() {
        return bizTxTm;
    }

    public void setBizTxTm(Date bizTxTm) {
        this.bizTxTm = bizTxTm;
    }

    public String getContrMerchtId() {
        return contrMerchtId;
    }

    public void setContrMerchtId(String contrMerchtId) {
        this.contrMerchtId = contrMerchtId;
    }

    public String getContrMerchtNm() {
        return contrMerchtNm;
    }

    public void setContrMerchtNm(String contrMerchtNm) {
        this.contrMerchtNm = contrMerchtNm;
    }

    public String getMerchtId() {
        return merchtId;
    }

    public void setMerchtId(String merchtId) {
        this.merchtId = merchtId;
    }

    public String getMerchtNm() {
        return merchtNm;
    }

    public void setMerchtNm(String merchtNm) {
        this.merchtNm = merchtNm;
    }

    public String getSecMerchtId() {
        return secMerchtId;
    }

    public void setSecMerchtId(String secMerchtId) {
        this.secMerchtId = secMerchtId;
    }

    public BigDecimal getOrgnlPrc() {
        return orgnlPrc;
    }

    public void setOrgnlPrc(BigDecimal orgnlPrc) {
        this.orgnlPrc = orgnlPrc;
    }

    public BigDecimal getPrcAmt() {
        return prcAmt;
    }

    public void setPrcAmt(BigDecimal prcAmt) {
        this.prcAmt = prcAmt;
    }

    public Long getPointPrcCnt() {
        return pointPrcCnt;
    }

    public void setPointPrcCnt(Long pointPrcCnt) {
        this.pointPrcCnt = pointPrcCnt;
    }

    public BigDecimal getCostPrc() {
        return costPrc;
    }

    public void setCostPrc(BigDecimal costPrc) {
        this.costPrc = costPrc;
    }

    public BigDecimal getPayTotlAmt() {
        return payTotlAmt;
    }

    public void setPayTotlAmt(BigDecimal payTotlAmt) {
        this.payTotlAmt = payTotlAmt;
    }

    public BigDecimal getRightsTotlAmt() {
        return rightsTotlAmt;
    }

    public void setRightsTotlAmt(BigDecimal rightsTotlAmt) {
        this.rightsTotlAmt = rightsTotlAmt;
    }

    public Long getPointTotlCnt() {
        return pointTotlCnt;
    }

    public void setPointTotlCnt(Long pointTotlCnt) {
        this.pointTotlCnt = pointTotlCnt;
    }

    public BigDecimal getPointTotlAmt() {
        return pointTotlAmt;
    }

    public void setPointTotlAmt(BigDecimal pointTotlAmt) {
        this.pointTotlAmt = pointTotlAmt;
    }

    public Long getPointKhFlg() {
        return pointKhFlg;
    }

    public void setPointKhFlg(Long pointKhFlg) {
        this.pointKhFlg = pointKhFlg;
    }

    public BigDecimal getAdvMoneyAmt() {
        return advMoneyAmt;
    }

    public void setAdvMoneyAmt(BigDecimal advMoneyAmt) {
        this.advMoneyAmt = advMoneyAmt;
    }

    public BigDecimal getCustPayAmt() {
        return custPayAmt;
    }

    public void setCustPayAmt(BigDecimal custPayAmt) {
        this.custPayAmt = custPayAmt;
    }

    public String getBizTpCd() {
        return bizTpCd;
    }

    public void setBizTpCd(String bizTpCd) {
        this.bizTpCd = bizTpCd;
    }

    public String getEvtCd() {
        return evtCd;
    }

    public void setEvtCd(String evtCd) {
        this.evtCd = evtCd;
    }

    public Date getOrdrValidPrd() {
        return ordrValidPrd;
    }

    public void setOrdrValidPrd(Date ordrValidPrd) {
        this.ordrValidPrd = ordrValidPrd;
    }

    public String getCcy() {
        return ccy;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    public String getUsrIp() {
        return usrIp;
    }

    public void setUsrIp(String usrIp) {
        this.usrIp = usrIp;
    }

    public String getTellerNo() {
        return tellrNo;
    }

    public void setTellerNo(String tellrNo) {
        this.tellrNo = tellrNo;
    }

    public String getOrgCd() {
        return orgCd;
    }

    public void setOrgCd(String orgCd) {
        this.orgCd = orgCd;
    }

    public String getRtnAdr() {
        return rtnAdr;
    }

    public void setRtnAdr(String rtnAdr) {
        this.rtnAdr = rtnAdr;
    }

    public String getAdvsAdr() {
        return advsAdr;
    }

    public void setAdvsAdr(String advsAdr) {
        this.advsAdr = advsAdr;
    }

    public String getPayrCpln() {
        return payrCpln;
    }

    public void setPayrCpln(String payrCpln) {
        this.payrCpln = payrCpln;
    }

    public String getPayrCertTp() {
        return payrCertTp;
    }

    public void setPayrCertTp(String payrCertTp) {
        this.payrCertTp = payrCertTp;
    }

    public String getPayrCertNo() {
        return payrCertNo;
    }

    public void setPayrCertNo(String payrCertNo) {
        this.payrCertNo = payrCertNo;
    }

    public String getPayrMoblNo() {
        return payrMoblNo;
    }

    public void setPayrMoblNo(String payrMoblNo) {
        this.payrMoblNo = payrMoblNo;
    }

    public String getPayrMail() {
        return payrMail;
    }

    public void setPayrMail(String payrMail) {
        this.payrMail = payrMail;
    }

    public String getOrdrRmrk() {
        return ordrRmrk;
    }

    public void setOrdrRmrk(String ordrRmrk) {
        this.ordrRmrk = ordrRmrk;
    }
}