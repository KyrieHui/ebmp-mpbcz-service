package com.gientech.mpbcz.repository;

import com.gientech.mpbcz.entity.PrepayMerchdInf;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 预下单商品信息数据访问接口
 */
public interface PrepayMerchdInfRepository {
    
    /**
     * 批量插入预下单商品信息
     * @param merchdInfs 预下单商品信息列表
     * @return 插入记录数
     */
    @Insert("<script>" +
            "INSERT INTO t_prepay_merchd_inf(id, lpr_cd, mercht_ordr_id, merchd_id, merchd_nm, merchd_cnt, merchd_orgnl_prc, merchd_cost_prc, merchd_prefr_prc) VALUES " +
            "<foreach collection='merchdInfs' item='merchdInf' separator=','>" +
            "(#{merchdInf.id}, #{merchdInf.lprCd}, #{merchdInf.merchtOrdrId}, #{merchdInf.merchdId}, #{merchdInf.merchdNm}, #{merchdInf.merchdCnt}, #{merchdInf.merchdOrgnlPrc}, #{merchdInf.merchdCostPrc}, #{merchdInf.merchdPrefrPrc})" +
            "</foreach>" +
            "</script>")
    int batchInsertMerchdInf(@Param("merchdInfs") List<PrepayMerchdInf> merchdInfs);
    
    /**
     * 根据商户订单编号查询预下单商品信息列表
     * @param merchtOrdrId 商户订单编号
     * @return 预下单商品信息列表
     */
    @Select("SELECT * FROM t_prepay_merchd_inf WHERE mercht_ordr_id = #{merchtOrdrId}")
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "lprCd", column = "lpr_cd"),
        @Result(property = "merchtOrdrId", column = "mercht_ordr_id"),
        @Result(property = "merchdId", column = "merchd_id"),
        @Result(property = "merchdNm", column = "merchd_nm"),
        @Result(property = "merchdCnt", column = "merchd_cnt"),
        @Result(property = "merchdOrgnlPrc", column = "merchd_orgnl_prc"),
        @Result(property = "merchdCostPrc", column = "merchd_cost_prc"),
        @Result(property = "merchdPrefrPrc", column = "merchd_prefr_prc")
    })
    List<PrepayMerchdInf> selectByMerchtOrdrId(String merchtOrdrId);
    
    /**
     * 根据商户订单编号删除预下单商品信息
     * @param merchtOrdrId 商户订单编号
     * @return 删除记录数
     */
    @Delete("DELETE FROM t_prepay_merchd_inf WHERE mercht_ordr_id = #{merchtOrdrId}")
    int deleteByMerchtOrdrId(String merchtOrdrId);
}