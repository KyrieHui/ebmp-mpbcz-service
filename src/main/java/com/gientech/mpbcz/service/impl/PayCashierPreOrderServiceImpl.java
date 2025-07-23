package com.gientech.mpbcz.service.impl;

import com.dap.flow.engine.api.ModuleService;
import com.gientech.ebmp.mpbcz.service.PayCashierPreOrderService;
import com.gientech.ebmp.mpbcz.service.dto.PayCashierPreOrderInputDTO;
import com.gientech.ebmp.mpbcz.service.dto.PayCashierPreOrderOutputDTO;
import org.springframework.stereotype.Component;

@Component
public class PayCashierPreOrderServiceImpl
    implements ModuleService, PayCashierPreOrderService
{

    public PayCashierPreOrderOutputDTO execute(PayCashierPreOrderInputDTO input) {
        //转化dto到领域对象

        //调用领域服务

        //转化领域对象到输出dto


        PayCashierPreOrderOutputDTO output = new PayCashierPreOrderOutputDTO();
        return output;
    }

    public PayCashierPreOrderOutputDTO reverse(PayCashierPreOrderInputDTO inputDTO, PayCashierPreOrderOutputDTO outputDTO) {
        PayCashierPreOrderOutputDTO output = new PayCashierPreOrderOutputDTO();
        return output;
    }
}
