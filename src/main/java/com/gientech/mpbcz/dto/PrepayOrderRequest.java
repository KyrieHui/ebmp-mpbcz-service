package com.gientech.mpbcz.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 预下单请求数据传输对象
 */
public class PrepayOrderRequest {
    private String merchtOrdrId; // 商户订单编号
    private Date bizTxTm; // 业务交易时间
    private String merchtId; // 商户号
    private String merchtNm; // 商户名称
    private String secMerchtId; // 二级商户编号
    private String contrMerchtId; // 签约商户编号
    private String contrMerchtNm; // 签约商户名称
    private String usrId; // 用户编号
    private String usrIpAdr; // 用户ip
    private Date ordrValidPrdDt; // 订单有效期
    private String ccy; // 币种
    private BigDecimal orgnlPrc; // 原价
    private BigDecimal prcAmt; // 售价
    private Long pointPrcCnt; // 积分售价数量
    private BigDecimal costPrc; // 成本价
    private BigDecimal payTotlAmt; // 支付总金额
    private BigDecimal extRightsAmt; // 外部权益金额
    private String bizTpCd; // 业务类型编码
    private String evtCd; // 事件编码
    private List<DecisInf> decisInf; // 决策信息组
    private List<MerchdInf> merchdInf; // 商品信息数组
    private List<PrefrCpnInf> prefrCpnInf; // 优惠券信息
    private List<Point> point; // 积分信息组
    private String ordrRmrk; // 订单备注
    private String rtnAdr; // 回调地址
    private String advsAdr; // 通知地址
    private String payrCpln; // 付款方姓名
    private String payrCertTpCd; // 付款方证件类型
    private String payrCertNo; // 付款方证件号
    private String payrMoblNo; // 付款方手机号
    private String payrMailNo; // 付款方邮箱

    // Getters and Setters
    public String getMerchtOrdrId() {
        return merchtOrdrId;
    }

    public void setMerchtOrdrId(String merchtOrdrId) {
        this.merchtOrdrId = merchtOrdrId;
    }

    public Date getBizTxTm() {
        return bizTxTm;
    }

    public void setBizTxTm(Date bizTxTm) {
        this.bizTxTm = bizTxTm;
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

    public String getUsrId() {
        return usrId;
    }

    public void setUsrId(String usrId) {
        this.usrId = usrId;
    }

    public String getUsrIpAdr() {
        return usrIpAdr;
    }

    public void setUsrIpAdr(String usrIpAdr) {
        this.usrIpAdr = usrIpAdr;
    }

    public Date getOrdrValidPrdDt() {
        return ordrValidPrdDt;
    }

    public void setOrdrValidPrdDt(Date ordrValidPrdDt) {
        this.ordrValidPrdDt = ordrValidPrdDt;
    }

    public String getCcy() {
        return ccy;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
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

    public BigDecimal getExtRightsAmt() {
        return extRightsAmt;
    }

    public void setExtRightsAmt(BigDecimal extRightsAmt) {
        this.extRightsAmt = extRightsAmt;
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

    public List<DecisInf> getDecisInf() {
        return decisInf;
    }

    public void setDecisInf(List<DecisInf> decisInf) {
        this.decisInf = decisInf;
    }

    public List<MerchdInf> getMerchdInf() {
        return merchdInf;
    }

    public void setMerchdInf(List<MerchdInf> merchdInf) {
        this.merchdInf = merchdInf;
    }

    public List<PrefrCpnInf> getPrefrCpnInf() {
        return prefrCpnInf;
    }

    public void setPrefrCpnInf(List<PrefrCpnInf> prefrCpnInf) {
        this.prefrCpnInf = prefrCpnInf;
    }

    public List<Point> getPoint() {
        return point;
    }

    public void setPoint(List<Point> point) {
        this.point = point;
    }

    public String getOrdrRmrk() {
        return ordrRmrk;
    }

    public void setOrdrRmrk(String ordrRmrk) {
        this.ordrRmrk = ordrRmrk;
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

    public String getPayrCertTpCd() {
        return payrCertTpCd;
    }

    public void setPayrCertTpCd(String payrCertTpCd) {
        this.payrCertTpCd = payrCertTpCd;
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

    public String getPayrMailNo() {
        return payrMailNo;
    }

    public void setPayrMailNo(String payrMailNo) {
        this.payrMailNo = payrMailNo;
    }

    /**
     * 决策信息
     */
    public static class DecisInf {
        private String decisExtInd; // 决策扩展标识
        private String decisExtInf; // 决策扩展内容

        public String getDecisExtInd() {
            return decisExtInd;
        }

        public void setDecisExtInd(String decisExtInd) {
            this.decisExtInd = decisExtInd;
        }

        public String getDecisExtInf() {
            return decisExtInf;
        }

        public void setDecisExtInf(String decisExtInf) {
            this.decisExtInf = decisExtInf;
        }
    }

    /**
     * 商品信息
     */
    public static class MerchdInf {
        private String merchdId; // 商品编号
        private String merchdNm; // 商品名称
        private String merchdCnt; // 商品数量
        private BigDecimal merchdOrgnlPrc; // 商品原价
        private BigDecimal merchdCostPrc; // 商品成本价
        private BigDecimal merchdPrefrPrc; // 商品优惠价

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

    /**
     * 优惠券信息
     */
    public static class PrefrCpnInf {
        private String rightsId; // 权益ID
        private String rightsDtlId; // 权益明细ID
        private String rightsNm; // 权益名称
        private BigDecimal rightsAmt; // 权益金额

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

    /**
     * 积分信息
     */
    public static class Point {
        private String sumPointId; // 汇总积分编号
        private Long pointCnt; // 积分数量

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
    }
}