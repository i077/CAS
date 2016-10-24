package com.i077CAS.lib;

import java.math.BigDecimal;

@SuppressWarnings("unused")
public class Trig {
    public static BigDecimal sin(BigDecimal x) {
        return new BigDecimal(Math.sin(x.doubleValue()));
    }

    public static BigDecimal cos(BigDecimal x) {
        return new BigDecimal(Math.cos(x.doubleValue()));
    }

    public static BigDecimal tan(BigDecimal x) {
        return new BigDecimal(Math.tan(x.doubleValue()));
    }

    public static BigDecimal arcsin(BigDecimal x) {
        return new BigDecimal(Math.asin(x.doubleValue()));
    }
}
