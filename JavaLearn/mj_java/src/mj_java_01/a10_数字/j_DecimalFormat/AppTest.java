package mj_java_01.a10_数字.j_DecimalFormat;

import java.text.DecimalFormat;


/**
 * java.text.DecimalFormat 可以更好的 控制 前0 后0 ,前缀,后缀,分组分隔符,十进制分隔符等.
 * Decimal 数字.
 */
public class AppTest {
    public static void main(String[] args) {
        //用某种指定的格式 来格式化一个字符串.
        DecimalFormat df = new DecimalFormat();
        // .### 保留小数3为
        testDecimalFormat("###,###.###",123456.789);

    }

    public static void testDecimalFormat(String pattern, double value) {
        DecimalFormat fmt = new DecimalFormat(pattern);
        System.out.println(fmt.format(value));
    }
}
