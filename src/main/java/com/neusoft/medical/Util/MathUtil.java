package com.neusoft.medical.Util;

import java.math.BigDecimal;

public class MathUtil {
    public static double doubleSetScale(double num, int i) {
        BigDecimal bigDecimal = new BigDecimal(num);
        return bigDecimal.setScale(i, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
