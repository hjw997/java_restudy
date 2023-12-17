package mj_java_01.a17_IO.b_字符集_字符编码;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppTest {
    public static void main(String[] args) {
        /**
         * 字符集:Charset
         *
         * 不同的字符集 编码方式不一样.
         * 每个字符集都有对应的字符编码,它(编码) 决定了每个字符如何转为二进制存储在计算机中.
         */

    }

    @Test
    public void test01() {
        String str = "MJ码哥";
        try {
            byte[] gbks = str.getBytes("UTF-8");
            System.out.println(Arrays.toString(gbks));

            for (byte gbk : gbks) {
                System.out.format("%d = %s hex=%s \n",gbk, Integer.toString(gbk, 2),Integer.toString(gbk, 16));
                //System.out.format("" , Integer.toBinaryString(gbk));

            }


        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }


    }
}
