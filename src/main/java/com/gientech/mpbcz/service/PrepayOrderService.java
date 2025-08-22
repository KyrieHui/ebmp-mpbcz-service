package com.gientech.mpbcz.service;

import com.gientech.mpbcz.dto.PrepayOrderRequest;
import com.gientech.mpbcz.dto.PrepayOrderResponse;

/**
 * 预下单服务接口
 */
public interface PrepayOrderService {

    /**
     * 处理预下单请求
     * @param request 预下单请求参数
     * @return 预下单响应结果
     */
    PrepayOrderResponse processPrepayOrder(PrepayOrderRequest request);
}