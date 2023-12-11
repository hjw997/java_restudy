package mj_java_01.a10_数字.l_数字转字符;

/**
 * 数字 转 字符串
 * 1.使用字符串的 valueOf方法,
 * 2.包装类的 toString方法
 */
public class AppTest {
    public static void main(String[] args) {
        //  数字转为 字符串
        // 1.使用字符串的 String.valueOf(12.34)
        String s = String.valueOf(10);
        System.out.println(s);


        // 2.包装类.toString()
        String s1 = Integer.toString(10);
        System.out.println(s1);

        // 十六进制
        String toHexString = Integer.toHexString(255);
        System.out.println(toHexString);

        //radix 基数
        String s2 = Integer.toString(255, 2); //2进制方式
        System.out.println(s2);//1111 1111

        String s3 = Integer.toString(255, 16);
        System.out.println(s3); //ff

        //转为 2进制数
        String toBinaryString = Integer.toBinaryString(255);
        System.out.println(toBinaryString);

        //
        String toHexString1 = Double.toHexString(0.7);
        System.out.println(toHexString1);

        String toDoubleString = Double.toString(0.7);
        System.out.println(toDoubleString);
    }
}
