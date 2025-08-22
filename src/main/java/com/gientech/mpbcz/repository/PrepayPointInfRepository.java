package com.gientech.mpbcz.repository;

import com.gientech.mpbcz.entity.PrepayPointInf;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 预下单积分信息数据访问接口
 */
public interface PrepayPointInfRepository {
    
    /**
     * 批量插入预下单积分信息
     * @param pointInfs 预下单积分信息列表
     * @return 插入记录数
     */
    @Insert("<script>" +
            "INSERT INTO t_prepay_point_inf(id, lpr_cd, mercht_ordr_id, sum_point_id, point_cnt, point_exchg_rto, point_comut_amt) VALUES " +
            "<foreach collection='pointInfs' item='pointInf' separator=','>" +
            "(#{pointInf.id}, #{pointInf.lprCd}, #{pointInf.merchtOrdrId}, #{pointInf.sumPointId}, #{pointInf.pointCnt}, #{pointInf.pointExchgRto}, #{pointInf.pointComutAmt})" +
            "</foreach>" +
            "</script>")
    int batchInsertPointInf(@Param("pointInfs") List<PrepayPointInf> pointInfs);
    
    /**
     * 根据商户订单编号查询预下单积分信息列表
     * @param merchtOrdrId 商户订单编号
     * @return 预下单积分信息列表
     */
    @Select("SELECT * FROM t_prepay_point_inf WHERE mercht_ordr_id = #{merchtOrdrId}")
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "lprCd", column = "lpr_cd"),
        @Result(property = "merchtOrdrId", column = "mercht_ordr_id"),
        @Result(property = "sumPointId", column = "sum_point_id"),
        @Result(property = "pointCnt", column = "point_cnt"),
        @Result(property = "pointExchgRto", column = "point_exchg_rto"),
        @Result(property = "pointComutAmt", column = "point_comut_amt")
    })
    List<PrepayPointInf> selectByMerchtOrdrId(String merchtOrdrId);
    
    /**
     * 根据商户订单编号删除预下单积分信息
     * @param merchtOrdrId 商户订单编号
     * @return 删除记录数
     */
    @Delete("DELETE FROM t_prepay_point_inf WHERE mercht_ordr_id = #{merchtOrdrId}")
    int deleteByMerchtOrdrId(String merchtOrdrId);
}