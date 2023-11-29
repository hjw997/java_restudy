package mj_java_01.a02_基础语法_part01.g_运算符_Operator;

import org.junit.Test;

public class 位运算 {

    /**
     * 位运算 >>  和 >>>
     * 正数的符号位 0
     * 负数的符号位 1
     */
   @Test
    public void testBitOperation01() {
        // 0b1101 右移
        // 0b 110 右移后后面的一位被挤掉
        // 所以 >> 和 >>> 区别在于:
        //

        //二进制形式打出 Integer.toBinaryString(-128);
        System.out.println("-128      :" + Integer.toBinaryString(-128));
        System.out.println("-128 >>  2:" + Integer.toBinaryString(-128 >> 2));
        System.out.println("-128 >>> 2:" + Integer.toBinaryString(-128 >>> 2));

        System.out.println("-------正数的时候-----");
        System.out.println(Integer.toBinaryString(128));
        System.out.println(Integer.toBinaryString(128 >> 2));
        System.out.println(Integer.toBinaryString(128 >>> 2));

    }

    /**
     * java中的布尔值: boolean 和短路
     * & | ^ 三个位运算
     */
    @Test
    public  void testBitOperation02() {
        /**
          & | ^  三个位运算 用在整数上:
           & 按位 与  两个为 1 才为1
         */
        int age1 = 0b10010;
        int age2 = 0b11111;
        int age3 = age1 & age2;
        System.out.println(Integer.toBinaryString(age3));
        /**
         *      0b10010
         *   &  0b11111
         *   ------------  & 按位 与  两个为 1 才为1
         *      0b10010
         */

        /**
         * 布尔值也可 用 & | ^ 三个 位运算:
         */
        boolean flag1 = true;
        boolean flag2 = false;

        System.out.println(flag1 & flag2);
        System.out.println(flag1 | flag2);
        System.out.println(flag1 ^ flag2);


        /**
         *  && 和 ||  和 & | 少了短路功能.
         */
        boolean reult1 = false && getBoolean(); //发生短路.前面的为 false 后面就不执行了.
        boolean result2 = true || getBoolean(); //发生短路.前面的为 true 后面就不用判断了.
        System.out.println(reult1);
        System.out.println(result2);


    }

    public boolean getBoolean() {
        System.out.println("--getBoolean---");
        return true;
    }


}
