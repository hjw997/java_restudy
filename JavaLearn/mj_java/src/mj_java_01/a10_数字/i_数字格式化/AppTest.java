package mj_java_01.a10_数字.i_数字格式化;

import org.junit.Test;

public class AppTest {
    public static void main(String[] args) {
        System.out.printf("My name is %d ,height is %d ",30,10);
        System.out.format("My name is %d ,height is %d",10,20);
        System.out.println("-------------");;

        //格式化拼接转为字符串:
        String str =  String.format("My name is %d ,height is %d",10,20);
        System.out.println(str);
    }

    @Test
    public void test() {
        long n = 461012;
        System.out.format("%d%n", n); //%d 十进制 %n 换行 : 461012

        System.out.format("%-+,10d%n", n); //+461,012 -左对齐,对比下面的.
        System.out.format("%+,10d%n", n); //  +461,012

        //显示分组字符:
        System.out.format("%,08d%n", n); //08 8个字符的宽度,不够的用0 补齐 0461,012

        String formatPi = String.format("The pi is %.2f", Math.PI);
        System.out.println(formatPi);

        double pi = Math.PI;
        //.3 保留小数点后几位
        System.out.format("%.2f",pi);
    }
}
