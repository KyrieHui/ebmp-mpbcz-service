package com.gientech.mpbcz.dto;

/**
 * 预下单响应数据传输对象
 */
public class PrepayOrderResponse {
    private String payOrdrId; // 支付订单编号

    // Getters and Setters
    public String getPayOrdrId() {
        return payOrdrId;
    }

    public void setPayOrdrId(String payOrdrId) {
        this.payOrdrId = payOrdrId;
    }
}