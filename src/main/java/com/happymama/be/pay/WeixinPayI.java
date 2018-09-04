package com.happymama.be.pay;

import com.google.common.base.Strings;
import com.happymama.be.enums.ChargeStatus;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by yaoqiang on 2018/8/30.
 */
public interface WeixinPayI {


    default boolean checkSign(Map<String, String> map, String key) {
        if (Strings.isNullOrEmpty(map.get("sign"))) {
            return false;
        }
        String sign = map.get("sign");
        try {
            return sign(map, key).equals(sign);
        } catch (Exception ex) {
            return false;
        }
    }

    default boolean checkQuerySign(Map<String, String> map, String key) {
        if (map == null || map.size() == 0) {
            return false;
        }
        String sign = map.get("sign") == null ? "" : map.get("sign").toString();
        if (StringUtils.isBlank(sign)) {
            return false;
        }
        try {
            return sign(map, key).equals(sign);
        } catch (Exception ex) {
            return false;
        }
    }


    default ChargeStatus getChargeStatus(String str) {
        if(str == null){
            return null;
        }
        switch (str) {
            case "CLOSED":
            case "PAY_FAIL":
                return ChargeStatus.PAID_FAILURE;
            case "SUCCESS":
                return ChargeStatus.PAID;
            case "NOTPAY":
            case "ACCEPT":
                return ChargeStatus.WAIT_FOR_PAY;
            case "REFUND":
                return null;
            default:
                return null;
        }
    }

    default String sign(Map<String, String> map, String key) throws Exception {
        String str = map.entrySet().stream()
                .filter(
                        entry -> !"sign".equals(entry.getKey()) && StringUtils.isNotBlank(entry.getValue()))
                .map(entry -> entry.getKey() + "=" + entry.getValue())
                .sorted()
                .collect(Collectors.joining("&")) + "&key=" + key;
        return WXPayUtil.MD5(str).toUpperCase();
    }

}
