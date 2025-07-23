package com.gientech.mpbcz.processor;

import java.util.Map;
import com.dap.flow.engine.module.executor.init.AbstractModuleBusinessExpandProcessor;
import org.springframework.stereotype.Component;

@Component
public class MpbczProcessor
    extends AbstractModuleBusinessExpandProcessor
{

    public void pretreatment(String transCode,
        String version,
        Map<String, Object> reqHead,
        Map<String, Object> rspHead,
        Map<String, Object> mapExpand,
        boolean reverseFlag) {
    }

    public void posttreatment(String transCode,
        String version,
        Map<String, Object> mapReqHead,
        Map<String, Object> mapRspHead,
        Map<String, Map<String, Object>> mapNodeRspHead,
        Map<String, Object> mapExpand,
        boolean reverseFlag) {
    }
}
