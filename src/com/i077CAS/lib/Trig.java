package com.i077CAS.lib;


import org.nevec.rjm.BigDecimalMath;

import java.math.BigDecimal;

/**
 * Created by imran on 2016-10-03.
 */
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
}
