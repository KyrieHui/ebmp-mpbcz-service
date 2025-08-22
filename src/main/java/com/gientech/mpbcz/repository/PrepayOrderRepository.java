package com.gientech.mpbcz.repository;

import com.gientech.mpbcz.entity.PrepayOrder;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 预下单数据访问接口
 */
public interface PrepayOrderRepository {
    
    /**
     * 插入预下单信息
     * @param prepayOrder 预下单实体
     * @return 插入记录数
     */
    @Insert("INSERT INTO t_prepay_order(id, lpr_cd, global_seq_num, mercht_ordr_id, bpaas_ordr_id, usr_id, usr_open_org_id, usr_belg_org_id, mgr_org_id, biz_tx_tm, contr_mercht_id, contr_mercht_nm, mercht_id, mercht_nm, sec_mercht_id, orgnl_prc, prc_amt, point_prc_cnt, cost_prc, pay_totl_amt, rights_totl_amt, point_totl_cnt, point_totl_amt, point_kh_flg, adv_money_amt, cust_pay_amt, biz_tp_cd, evt_cd, ordr_valid_prd, ccy, usr_ip, tellr_no, org_cd, rtn_adr, advs_adr, payr_cpln, payr_cert_tp, payr_cert_no, payr_mobl_no, payr_mail, ordr_rmrk) " +
            "VALUES(#{id}, #{lprCd}, #{globalSeqNum}, #{merchtOrdrId}, #{bpaasOrdrId}, #{usrId}, #{usrOpenOrgId}, #{usrBelgOrgId}, #{mgrOrgId}, #{bizTxTm}, #{contrMerchtId}, #{contrMerchtNm}, #{merchtId}, #{merchtNm}, #{secMerchtId}, #{orgnlPrc}, #{prcAmt}, #{pointPrcCnt}, #{costPrc}, #{payTotlAmt}, #{rightsTotlAmt}, #{pointTotlCnt}, #{pointTotlAmt}, #{pointKhFlg}, #{advMoneyAmt}, #{custPayAmt}, #{bizTpCd}, #{evtCd}, #{ordrValidPrd}, #{ccy}, #{usrIp}, #{tellerNo}, #{orgCd}, #{rtnAdr}, #{advsAdr}, #{payrCpln}, #{payrCertTp}, #{payrCertNo}, #{payrMoblNo}, #{payrMail}, #{ordrRmrk})")
    int insertPrepayOrder(PrepayOrder prepayOrder);
    
    /**
     * 根据商户订单编号查询预下单信息
     * @param merchtOrdrId 商户订单编号
     * @return 预下单实体
     */
    @Select("SELECT * FROM t_prepay_order WHERE mercht_ordr_id = #{merchtOrdrId}")
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "lprCd", column = "lpr_cd"),
        @Result(property = "globalSeqNum", column = "global_seq_num"),
        @Result(property = "merchtOrdrId", column = "mercht_ordr_id"),
        @Result(property = "bpaasOrdrId", column = "bpaas_ordr_id"),
        @Result(property = "usrId", column = "usr_id"),
        @Result(property = "usrOpenOrgId", column = "usr_open_org_id"),
        @Result(property = "usrBelgOrgId", column = "usr_belg_org_id"),
        @Result(property = "mgrOrgId", column = "mgr_org_id"),
        @Result(property = "bizTxTm", column = "biz_tx_tm"),
        @Result(property = "contrMerchtId", column = "contr_mercht_id"),
        @Result(property = "contrMerchtNm", column = "contr_mercht_nm"),
        @Result(property = "merchtId", column = "mercht_id"),
        @Result(property = "merchtNm", column = "mercht_nm"),
        @Result(property = "secMerchtId", column = "sec_mercht_id"),
        @Result(property = "orgnlPrc", column = "orgnl_prc"),
        @Result(property = "prcAmt", column = "prc_amt"),
        @Result(property = "pointPrcCnt", column = "point_prc_cnt"),
        @Result(property = "costPrc", column = "cost_prc"),
        @Result(property = "payTotlAmt", column = "pay_totl_amt"),
        @Result(property = "rightsTotlAmt", column = "rights_totl_amt"),
        @Result(property = "pointTotlCnt", column = "point_totl_cnt"),
        @Result(property = "pointTotlAmt", column = "point_totl_amt"),
        @Result(property = "pointKhFlg", column = "point_kh_flg"),
        @Result(property = "advMoneyAmt", column = "adv_money_amt"),
        @Result(property = "custPayAmt", column = "cust_pay_amt"),
        @Result(property = "bizTpCd", column = "biz_tp_cd"),
        @Result(property = "evtCd", column = "evt_cd"),
        @Result(property = "ordrValidPrd", column = "ordr_valid_prd"),
        @Result(property = "ccy", column = "ccy"),
        @Result(property = "usrIp", column = "usr_ip"),
        @Result(property = "tellerNo", column = "teller_no"),
        @Result(property = "orgCd", column = "org_cd"),
        @Result(property = "rtnAdr", column = "rtn_adr"),
        @Result(property = "advsAdr", column = "advs_adr"),
        @Result(property = "payrCpln", column = "payr_cpln"),
        @Result(property = "payrCertTp", column = "payr_cert_tp"),
        @Result(property = "payrCertNo", column = "payr_cert_no"),
        @Result(property = "payrMoblNo", column = "payr_mobl_no"),
        @Result(property = "payrMail", column = "payr_mail"),
        @Result(property = "ordrRmrk", column = "ordr_rmrk")
    })
    PrepayOrder selectByMerchtOrdrId(String merchtOrdrId);
    
    /**
     * 更新预下单信息
     * @param prepayOrder 预下单实体
     * @return 更新记录数
     */
    @Update("UPDATE t_prepay_order SET bpaas_ordr_id = #{bpaasOrdrId} WHERE mercht_ordr_id = #{merchtOrdrId}")
    int updatePrepayOrder(PrepayOrder prepayOrder);
}