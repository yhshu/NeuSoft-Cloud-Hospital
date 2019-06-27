package com.neusoft.medical.Util.converter;

import org.apache.log4j.Logger;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class DoubleToUpperCaseConverter implements Converter<Double, String> {
    private Logger logger = Logger.getLogger(DoubleToUpperCaseConverter.class);

    private final String[] UNIT = {"万", "千", "佰", "拾", "亿", "千", "佰",
            "拾", "万", "千", "佰", "拾", "元", "角", "分"};

    private final String[] NUM = {"零", "壹", "贰", "叁", "肆", "伍", "陆",
            "柒", "捌", "玖"};

    private final double MAX_VALUE = 9999999999999.99D;

    /**
     * 将浮点数金额转换成中文大写金额
     *
     * @param money 金额
     * @return result 中文大写
     */
    public String convert(Double money) {
        if (money < 0 || money > MAX_VALUE) {
            logger.error("illegal parameter");
            return null;
        }
        long money1 = Math.round(money * 100); // 四舍五入到分
        if (money1 == 0)
            return "零元整";
        String strMoney = String.valueOf(money1);
        int numIndex = 0; // numIndex用于选择金额数值
        int unitIndex = UNIT.length - strMoney.length(); // unitIndex用于选择金额单位
        boolean isZero = false; // 用于判断当前为是否为零
        StringBuilder result = new StringBuilder();
        for (; numIndex < strMoney.length(); numIndex++, unitIndex++) {
            char num = strMoney.charAt(numIndex);
            if (num == '0') {
                isZero = true;
                if (UNIT[unitIndex].equals("亿") || UNIT[unitIndex].equals("万")
                        || UNIT[unitIndex] == "元") { // 如果当前位是亿、万、元，且数值为零
                    result.append(UNIT[unitIndex]); //补单位亿、万、元
                    isZero = false;
                }
            } else {
                if (isZero) {
                    result.append("零");
                    isZero = false;
                }
                result.append(NUM[Integer.parseInt(String.valueOf(num))]).append(UNIT[unitIndex]);
            }
        }
        // 不是角分结尾就加"整"字
        if (!result.toString().endsWith("角") && !result.toString().endsWith("分")) {
            result.append("整");
        }
        // 例如没有这行代码，数值"400000001101.2"，输出就是"肆千亿万壹千壹佰零壹元贰角"
        result = new StringBuilder(result.toString().replaceAll("亿万", "亿"));
        return result.toString();
    }

}
