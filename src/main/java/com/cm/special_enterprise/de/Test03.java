package com.cm.special_enterprise.de;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Test03 {
    public static void main(String[] args) {



        DecimalFormat df = new DecimalFormat("0.00");
        df.setRoundingMode(RoundingMode.HALF_UP);
        int a = 20;
        int b = 1;
        int count = a + b;

        double aa = 2.249;
        System.out.println(new DecimalFormat("0.00").format(new Double((a*100+50)/count)));
        System.out.println(new DecimalFormat("0.00").format(new Double((b*100+50)/count)));
        DecimalFormat d = new DecimalFormat("0.00");
        System.out.println(d.format(new Double(aa)));

        double num1 = 7;
        int num2 = 9;
        System.out.println(num1 / num2);
// 创建一个数值格式化对象
        NumberFormat numberFormat = NumberFormat.getInstance();
// 设置精确到小数点后2位
        numberFormat.setMaximumFractionDigits(2);
        String result = numberFormat.format((double)num1 / num2 * 100);
        System.out.println("num1和num2的百分比为:" + result + "%");

    }
}
