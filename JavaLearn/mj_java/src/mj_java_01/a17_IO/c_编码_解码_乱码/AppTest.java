package mj_java_01.a17_IO.c_编码_解码_乱码;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * 一般将 "字符串" 转为 [二进制] 的过程 : 编码(Encode)
 *
 * 一般将 [二进制] 转为  "字符串" 的过程 : 解码(Decode)
 */
public class AppTest {
    public static void main(String[] args) {
        String str = "AaMJ码哥";
        // 编码 就是 转为 二进制:
        byte[] byt = str.getBytes(StandardCharsets.UTF_8);
        // [65, 97, 77, 74, -25, -96, -127, -27, -109, -91]
        System.out.println(Arrays.toString(byt));

        //解码: 转成字符 你的告诉怎么解码 : 几个字节 变为一个字符? 要使用 编码方式:
        //utf-8 三个字节一个汉字:
        byte[] bytes = { 65, 97, 77, 74, -25, -96, -127, -27, -109, -91 };
        //使用字节数组,你要告诉 怎么解码?
        String s = new String(bytes, StandardCharsets.UTF_8);
        System.out.println(s);

        /**
         * 乱码的由来: 就是 使用错误的 编码方式去解析 二进制文件 就出现了乱码
         * 这里 GBK  用两个字节去转为一个汉字,
         * [65, 97, 77, 74, -25, -96, -127, -27, -109, -91]
         * AaMJ鐮佸摜 ❌出现了乱码.
         */
        String s1 = new String(bytes, Charset.forName("GBk"));
        System.out.println(s1);

        /**
         * 有个疑问: 怎么知道 单字节 双字节 三字节.
         * 0-127 : 就用单字节处理  是ASCII码表中的
         */
    }
}
