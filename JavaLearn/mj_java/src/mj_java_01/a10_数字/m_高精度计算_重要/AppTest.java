package mj_java_01.a10_数字.m_高精度计算_重要;

import java.math.BigDecimal;

/**
 * 11分:开始
 * 适合任何编程语言:
 */
public class AppTest {
    public static void main(String[] args) {
        /**
         * 因为 浮点数 子计算机中存储是会丢失精度的,存储的只是近似值.
         */
        double d1 = 0.7; //小数在计算机中是的二进制是怎么表示的呢? 看课件.
        double d2 = 0.7;
        double d3 = d1 * d2;
        //丢失精度了: 0.49
        System.out.println(d3); //计算结果是 0.48999999999999994

        /**
         * 使用高精度计算:
         */
        BigDecimal decimal1 = new BigDecimal("0.7");
        BigDecimal decimal2 = new BigDecimal("0.7");
        BigDecimal multiply = decimal2.multiply(decimal2);
        System.out.println(multiply); //0.49

    }
}
