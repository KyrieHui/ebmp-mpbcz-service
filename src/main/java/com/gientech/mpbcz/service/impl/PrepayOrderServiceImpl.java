package com.gientech.mpbcz.service.impl;

import com.gientech.mpbcz.dto.PrepayOrderRequest;
import com.gientech.mpbcz.dto.PrepayOrderResponse;
import com.gientech.mpbcz.entity.PrepayMerchdInf;
import com.gientech.mpbcz.entity.PrepayOrder;
import com.gientech.mpbcz.entity.PrepayPointInf;
import com.gientech.mpbcz.entity.PrepayRightsInf;
import com.gientech.mpbcz.repository.PrepayMerchdInfRepository;
import com.gientech.mpbcz.repository.PrepayOrderRepository;
import com.gientech.mpbcz.repository.PrepayPointInfRepository;
import com.gientech.mpbcz.repository.PrepayRightsInfRepository;
import com.gientech.mpbcz.service.PrepayOrderService;
import com.gientech.mpbcz.utils.DateUtils;
import org.springframework.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 预下单服务实现类
 */
@Service
public class PrepayOrderServiceImpl implements PrepayOrderService {

    @Autowired
    private PrepayOrderRepository prepayOrderRepository;

    @Autowired
    private PrepayMerchdInfRepository prepayMerchdInfRepository;

    @Autowired
    private PrepayRightsInfRepository prepayRightsInfRepository;

    @Autowired
    private PrepayPointInfRepository prepayPointInfRepository;

    /**
     * 处理预下单请求
     * @param request 预下单请求参数
     * @return 预下单响应结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public PrepayOrderResponse processPrepayOrder(PrepayOrderRequest request) {
        // 1. 参数校验
        validateRequest(request);

        // 2. 构建预下单实体
        PrepayOrder prepayOrder = buildPrepayOrder(request);

        // 3. 保存预下单主表信息
        prepayOrderRepository.insertPrepayOrder(prepayOrder);

        // 4. 保存商品信息
        if (!CollectionUtils.isEmpty(request.getMerchdInf())) {
            List<PrepayMerchdInf> merchdInfs = buildPrepayMerchdInfs(request, prepayOrder.getLprCd());
            prepayMerchdInfRepository.batchInsertMerchdInf(merchdInfs);
        }

        // 5. 保存权益信息
        if (!CollectionUtils.isEmpty(request.getPrefrCpnInf())) {
            List<PrepayRightsInf> rightsInfs = buildPrepayRightsInfs(request, prepayOrder.getLprCd());
            prepayRightsInfRepository.batchInsertRightsInf(rightsInfs);
        }

        // 6. 保存积分信息
        if (!CollectionUtils.isEmpty(request.getPoint())) {
            List<PrepayPointInf> pointInfs = buildPrepayPointInfs(request, prepayOrder.getLprCd());
            prepayPointInfRepository.batchInsertPointInf(pointInfs);
        }

        // 7. 构建响应结果
        PrepayOrderResponse response = new PrepayOrderResponse();
        response.setPayOrdrId(prepayOrder.getBpaasOrdrId());

        return response;
    }

    /**
     * 参数校验
     * @param request 预下单请求参数
     */
    private void validateRequest(PrepayOrderRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("请求参数不能为空");
        }

        if (!StringUtils.hasText(request.getMerchtOrdrId())) {
            throw new IllegalArgumentException("商户订单编号不能为空");
        }

        if (request.getBizTxTm() == null) {
            throw new IllegalArgumentException("业务交易时间不能为空");
        }

        if (!StringUtils.hasText(request.getMerchtId())) {
            throw new IllegalArgumentException("商户号不能为空");
        }

        if (request.getOrgnlPrc() == null) {
            throw new IllegalArgumentException("原价不能为空");
        }

        if (request.getPayTotlAmt() == null) {
            throw new IllegalArgumentException("支付总金额不能为空");
        }

        if (!StringUtils.hasText(request.getBizTpCd())) {
            throw new IllegalArgumentException("业务类型编码不能为空");
        }

        if (!StringUtils.hasText(request.getEvtCd())) {
            throw new IllegalArgumentException("事件编码不能为空");
        }

        if (request.getOrdrValidPrdDt() == null) {
            throw new IllegalArgumentException("订单有效期不能为空");
        }

        if (!StringUtils.hasText(request.getCcy())) {
            throw new IllegalArgumentException("币种不能为空");
        }

        if (!StringUtils.hasText(request.getRtnAdr())) {
            throw new IllegalArgumentException("回调地址不能为空");
        }
    }

    /**
     * 构建预下单实体
     * @param request 预下单请求参数
     * @return 预下单实体
     */
    private PrepayOrder buildPrepayOrder(PrepayOrderRequest request) {
        PrepayOrder prepayOrder = new PrepayOrder();
        
        // 设置主键ID
        prepayOrder.setId(System.currentTimeMillis());
        
        // 设置法人代码
        prepayOrder.setLprCd("000000");
        
        // 设置全局流水号
        prepayOrder.setGlobalSeqNum(UUID.randomUUID().toString().replace("-", "").toUpperCase());
        
        // 设置商户订单编号
        prepayOrder.setMerchtOrdrId(request.getMerchtOrdrId());
        
        // 设置BPAAS订单编号
        prepayOrder.setBpaasOrdrId("BPAAS" + System.currentTimeMillis());
        
        // 设置用户编号
        prepayOrder.setUsrId(request.getUsrId());
        
        // 设置用户开户机构号
        prepayOrder.setUsrOpenOrgId("OPEN001");
        
        // 设置用户归属机构号
        prepayOrder.setUsrBelgOrgId("BELG001");
        
        // 设置管理机构号
        prepayOrder.setMgrOrgId("MGR001");
        
        // 设置业务交易时间
        prepayOrder.setBizTxTm(new Date());
        
        // 设置签约商户编号
        prepayOrder.setContrMerchtId(request.getContrMerchtId());
        
        // 设置签约商户名称
        prepayOrder.setContrMerchtNm(request.getContrMerchtNm());
        
        // 设置商户号
        prepayOrder.setMerchtId(request.getMerchtId());
        
        // 设置商户名称
        prepayOrder.setMerchtNm(request.getMerchtNm());
        
        // 设置二级商户编号
        prepayOrder.setSecMerchtId(request.getSecMerchtId());
        
        // 设置原价
        prepayOrder.setOrgnlPrc(request.getOrgnlPrc());
        
        // 设置售价
        prepayOrder.setPrcAmt(request.getPrcAmt());
        
        // 设置积分售价数量
        prepayOrder.setPointPrcCnt(request.getPointPrcCnt());
        
        // 设置成本价
        prepayOrder.setCostPrc(request.getCostPrc());
        
        // 设置支付总金额
        prepayOrder.setPayTotlAmt(request.getPayTotlAmt());
        
        // 设置外部权益金额
        BigDecimal extRightsAmt = request.getExtRightsAmt() != null ? request.getExtRightsAmt() : BigDecimal.ZERO;
        prepayOrder.setRightsTotlAmt(extRightsAmt);
        
        // 设置积分总数量
        prepayOrder.setPointTotlCnt(Long.valueOf(request.getPoint() != null ? 
            request.getPoint().stream().mapToInt(p -> p.getPointCnt() != null ? p.getPointCnt().intValue() : 0).sum() : 0));
        
        // 设置积分总金额
        prepayOrder.setPointTotlAmt(request.getPoint() != null ? 
            request.getPoint().stream().map(p -> {
                if (p.getPointCnt() != null && p.getPointCnt().compareTo(0L) > 0) {
                    return new BigDecimal(p.getPointCnt()).multiply(BigDecimal.valueOf(0.01));
                }
                return BigDecimal.ZERO;
            }).reduce(BigDecimal.ZERO, BigDecimal::add) : BigDecimal.ZERO);
        
        // 设置积分客户标识
        prepayOrder.setPointKhFlg(0L);
        
        // 设置预付金额
        prepayOrder.setAdvMoneyAmt(BigDecimal.ZERO);
        
        // 设置客户支付金额
        prepayOrder.setCustPayAmt(request.getPayTotlAmt());
        
        // 设置业务类型编码
        prepayOrder.setBizTpCd(request.getBizTpCd());
        
        // 设置事件编码
        prepayOrder.setEvtCd(request.getEvtCd());
        
        // 设置订单有效期
        prepayOrder.setOrdrValidPrd(new Date());
        
        // 设置币种
        prepayOrder.setCcy(request.getCcy());
        
        // 设置用户IP
        prepayOrder.setUsrIp(request.getUsrIpAdr());
        
        // 设置柜员号
        prepayOrder.setTellerNo("TELLER001");
        
        // 设置机构代码
        prepayOrder.setOrgCd("ORG001");
        
        // 设置回调地址
        prepayOrder.setRtnAdr(request.getRtnAdr());
        
        // 设置通知地址
        prepayOrder.setAdvsAdr(request.getAdvsAdr());
        
        // 设置付款方姓名
        prepayOrder.setPayrCpln(request.getPayrCpln());
        
        // 设置付款方证件类型
        prepayOrder.setPayrCertTp(request.getPayrCertTpCd());
        
        // 设置付款方证件号
        prepayOrder.setPayrCertNo(request.getPayrCertNo());
        
        // 设置付款方手机号
        prepayOrder.setPayrMoblNo(request.getPayrMoblNo());
        
        // 设置付款方邮箱
        prepayOrder.setPayrMail(request.getPayrMailNo());
        
        // 设置订单备注
        prepayOrder.setOrdrRmrk(request.getOrdrRmrk());
        
        return prepayOrder;
    }

    /**
     * 构建预下单商品信息列表
     * @param request 预下单请求参数
     * @param lprCd 法人代码
     * @return 预下单商品信息列表
     */
    private List<PrepayMerchdInf> buildPrepayMerchdInfs(PrepayOrderRequest request, String lprCd) {
        List<PrepayMerchdInf> merchdInfs = new ArrayList<>();
        for (int i = 0; i < request.getMerchdInf().size(); i++) {
            PrepayOrderRequest.MerchdInf merchdInf = request.getMerchdInf().get(i);
            PrepayMerchdInf prepayMerchdInf = new PrepayMerchdInf();
            prepayMerchdInf.setId(System.currentTimeMillis() + i);
            prepayMerchdInf.setLprCd(lprCd);
            prepayMerchdInf.setMerchtOrdrId(request.getMerchtOrdrId());
            prepayMerchdInf.setMerchdId(merchdInf.getMerchdId());
            prepayMerchdInf.setMerchdNm(merchdInf.getMerchdNm());
            prepayMerchdInf.setMerchdCnt(merchdInf.getMerchdCnt());
            prepayMerchdInf.setMerchdOrgnlPrc(merchdInf.getMerchdOrgnlPrc());
            prepayMerchdInf.setMerchdCostPrc(merchdInf.getMerchdCostPrc());
            prepayMerchdInf.setMerchdPrefrPrc(merchdInf.getMerchdPrefrPrc());
            merchdInfs.add(prepayMerchdInf);
        }
        return merchdInfs;
    }

    /**
     * 构建预下单权益信息列表
     * @param request 预下单请求参数
     * @param lprCd 法人代码
     * @return 预下单权益信息列表
     */
    private List<PrepayRightsInf> buildPrepayRightsInfs(PrepayOrderRequest request, String lprCd) {
        List<PrepayRightsInf> rightsInfs = new ArrayList<>();
        for (int i = 0; i < request.getPrefrCpnInf().size(); i++) {
            PrepayOrderRequest.PrefrCpnInf prefrCpnInf = request.getPrefrCpnInf().get(i);
            PrepayRightsInf prepayRightsInf = new PrepayRightsInf();
            prepayRightsInf.setId(System.currentTimeMillis() + i);
            prepayRightsInf.setLprCd(lprCd);
            prepayRightsInf.setMerchtOrdrId(request.getMerchtOrdrId());
            prepayRightsInf.setRightsId(prefrCpnInf.getRightsId());
            prepayRightsInf.setRightsDtlId(prefrCpnInf.getRightsDtlId());
            prepayRightsInf.setRightsNm(prefrCpnInf.getRightsNm());
            prepayRightsInf.setRightsAmt(prefrCpnInf.getRightsAmt());
            rightsInfs.add(prepayRightsInf);
        }
        return rightsInfs;
    }

    /**
     * 构建预下单积分信息列表
     * @param request 预下单请求参数
     * @param lprCd 法人代码
     * @return 预下单积分信息列表
     */
    private List<PrepayPointInf> buildPrepayPointInfs(PrepayOrderRequest request, String lprCd) {
        List<PrepayPointInf> pointInfs = new ArrayList<>();
        for (int i = 0; i < request.getPoint().size(); i++) {
            PrepayOrderRequest.Point point = request.getPoint().get(i);
            PrepayPointInf prepayPointInf = new PrepayPointInf();
            prepayPointInf.setId(System.currentTimeMillis() + i);
            prepayPointInf.setLprCd(lprCd);
            prepayPointInf.setMerchtOrdrId(request.getMerchtOrdrId());
            prepayPointInf.setSumPointId(point.getSumPointId());
            prepayPointInf.setPointCnt(point.getPointCnt());
            prepayPointInf.setPointExchgRto(BigDecimal.valueOf(0.01));
            prepayPointInf.setPointComutAmt(point.getPointCnt() != null ? 
                new BigDecimal(point.getPointCnt()).multiply(BigDecimal.valueOf(0.01)) : BigDecimal.ZERO);
            pointInfs.add(prepayPointInf);
        }
        return pointInfs;
    }
}