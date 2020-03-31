package com.arraystack;

import java.text.NumberFormat;

/**
 * @Pragram:Test
 * @Description:TODO 计算两个数的商,格式为保留小数点后两位的百分制形式
 * @Author:ZhuShiQiang
 * @Create:2020-03-27 15:48
 **/
public class Test {
    public static void main(String[] args) {
        System.out.println(numFormat(16, 30));
    }
    public static String numFormat(int numerator,int denominator){
        float numeratorf = (float) numerator;//转换成浮点型
        float denominatorf = (float) denominator;
        NumberFormat nt = NumberFormat.getPercentInstance();//获取百分数实例
        nt.setMinimumFractionDigits(2);
        return nt.format(numeratorf/denominatorf);//得到结果
    }
}
