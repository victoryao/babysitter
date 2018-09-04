package com.happymama.be.service;

import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.happymama.be.pay.WeixinPayI;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

/**
 * Created by yaoqiang on 2018/8/30.
 */
@Service
public class PayService implements WeixinPayI {

    public boolean process(Map<String, String> params) {

        String outTradeNo = params.get("out_trade_no");
        String totalFee = params.get("total_fee");
        String tradeType = params.get("trade_type");
        String return_code = params.get("return_code");

        final String tradeTypeXCX = "JSAPI";
        Preconditions.checkArgument(Objects.nonNull(return_code));
//        Preconditions.checkState(checkSign(params, keyLocal));

        String returnCode = params.get("return_code");

        if ("FAIL".equals(returnCode) ||
                "FAIL".equals(returnCode)) {
            return false;
        }

        String coupon_fee = params.get("coupon_fee");
        String coupon_count = params.get("coupon_count");
        JSONObject ext = new JSONObject().fluentPut("mch_id", params.getOrDefault("mch_id", ""));
        if (!Strings.isNullOrEmpty(coupon_count) && !Strings.isNullOrEmpty(coupon_fee)) {
            ext.put("cut_money", coupon_fee);
            ext.put("openid", params.getOrDefault("openid", ""));
            ext.put("coupon_id", params.getOrDefault("coupon_id_0", ""));
        }
        return "SUCCESS".equals(params.get("result_code"));
    }


}
