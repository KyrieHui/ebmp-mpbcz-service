package com.gientech.mpbcz.repository;

import com.gientech.mpbcz.entity.PrepayRightsInf;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 预下单权益信息数据访问接口
 */
public interface PrepayRightsInfRepository {
    
    /**
     * 批量插入预下单权益信息
     * @param rightsInfs 预下单权益信息列表
     * @return 插入记录数
     */
    @Insert("<script>" +
            "INSERT INTO t_prepay_rights_inf(id, lpr_cd, mercht_ordr_id, rights_id, rights_dtl_id, rights_nm, rights_amt) VALUES " +
            "<foreach collection='rightsInfs' item='rightsInf' separator=','>" +
            "(#{rightsInf.id}, #{rightsInf.lprCd}, #{rightsInf.merchtOrdrId}, #{rightsInf.rightsId}, #{rightsInf.rightsDtlId}, #{rightsInf.rightsNm}, #{rightsInf.rightsAmt})" +
            "</foreach>" +
            "</script>")
    int batchInsertRightsInf(@Param("rightsInfs") List<PrepayRightsInf> rightsInfs);
    
    /**
     * 根据商户订单编号查询预下单权益信息列表
     * @param merchtOrdrId 商户订单编号
     * @return 预下单权益信息列表
     */
    @Select("SELECT * FROM t_prepay_rights_inf WHERE mercht_ordr_id = #{merchtOrdrId}")
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "lprCd", column = "lpr_cd"),
        @Result(property = "merchtOrdrId", column = "mercht_ordr_id"),
        @Result(property = "rightsId", column = "rights_id"),
        @Result(property = "rightsDtlId", column = "rights_dtl_id"),
        @Result(property = "rightsNm", column = "rights_nm"),
        @Result(property = "rightsAmt", column = "rights_amt")
    })
    List<PrepayRightsInf> selectByMerchtOrdrId(String merchtOrdrId);
    
    /**
     * 根据商户订单编号删除预下单权益信息
     * @param merchtOrdrId 商户订单编号
     * @return 删除记录数
     */
    @Delete("DELETE FROM t_prepay_rights_inf WHERE mercht_ordr_id = #{merchtOrdrId}")
    int deleteByMerchtOrdrId(String merchtOrdrId);
}