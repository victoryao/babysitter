package com.happymama.be.enums;

import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;

/**
 * Created by yaoqiang on 2018/8/30.
 */
public enum ChargeStatus {

    WAIT_FOR_PAY(0),
    PAID(10),
    PAID_FAILURE(20),
    APP_CONFIRM(30),
    DUPLICATE_PAID(40);

    @Getter
    int index;

    ChargeStatus(int i) {
        index = i;
    }

    public static Optional<ChargeStatus> valueByIndex(int index) {
        return Arrays.stream(ChargeStatus.values())
                .filter(e -> e.index == index)
                .findFirst();
    }

}
