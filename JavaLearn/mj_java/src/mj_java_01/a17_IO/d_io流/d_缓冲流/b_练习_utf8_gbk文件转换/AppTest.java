package mj_java_01.a17_IO.d_io流.d_缓冲流.b_练习_utf8_gbk文件转换;


import mj_java_01.a17_IO.d_io流.PathConstant;
import org.junit.Test;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * gbk.txt     gbk 方式存储
 * utf-8.txt   utf-8 方式存储
 * 相同的字符展示内容, 但是是不同的 字节.
 *
 * 先用gbk把里面的内容读出来, 转为字符串,然后 再把字符串以utf-8 形式写进去.
 *
 * 我是MJ
 * 小码哥教育
 * GBK字节:  [-50, -46, -54, -57, 77, 74, 10, -48, -95, -62, -21, -72, -25, -67, -52, -45, -3]   17个字节.
 *
 */
public class AppTest {
    private static final String ioTestPath = PathConstant.ioTestRootPath;

    @Test
    public void test01() {
        /**
         * 生成一个gbk文件 因为是 文本文件 . 所以可以用字符流, 也可以使用 字节流
         * 有个误区 小心就是 不能直接把gbk字节写成utf8文件的字节. 因为只要是转为了字符,就要考虑 一个字符是 几个字节.
         * 所以不能简单的 读出gbk字节 写入 utf8 中. 这样只是简单的 字节拷贝了. ❌
         */
        File gbkFile = new File(ioTestPath + "gbk.txt");
        String content = "我是MJ" + "\n" + "小码哥教育";
        byte[] data = content.getBytes(Charset.forName("GBK"));
        System.out.println(Arrays.toString(data));
        System.out.println(content);
        try (
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(gbkFile));
        ) {
            //写字节数组 到 文件.
            bos.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test02() {
        File gbkFile = new File(ioTestPath + "gbk.txt");
        File utf8File = new File(ioTestPath + "utf8.txt");

        /**
         * 读出 gbk 放到 utf-8 文件.
         * 思路: 先读出字节:转为gbk编码 转为字符串(解码)
         * 字符串 -> utf8 的字节再写入(编码)
         */
        try (
               BufferedInputStream bis  = new BufferedInputStream(new FileInputStream(gbkFile)); //输入流 缓冲字节输入流
               BufferedOutputStream bos = new BufferedOutputStream( new FileOutputStream(utf8File)) //输出流 : 缓冲输出流

        ) {
            byte[] gbkData = new byte[((int) gbkFile.length())];
            bis.read(gbkData);
            System.out.println("读出的 GBK 编码的字节是: " + Arrays.toString(gbkData));
            //先把这些字节转为 字符串.
            String content = new String(gbkData, Charset.forName("GBK"));
            System.out.println("GBK文件中的字符显示内容是: \n" + content);

            byte[] utf8Bytes = content.getBytes(StandardCharsets.UTF_8);
            System.out.println("写入的UTF-8编码的字节是: " + Arrays.toString(utf8Bytes));
            bos.write(utf8Bytes);
            /**
             读出的 GBK 编码的字节是: [-50, -46, -54, -57, 77, 74, 10, -48, -95, -62, -21, -72, -25, -67, -52, -45, -3]
             GBK文件中的字符显示内容是:
             我是MJ
             小码哥教育
             写入的UTF-8编码的字节是: [-26, -120, -111, -26, -104, -81, 77, 74, 10, -27, -80, -113, -25, -96, -127, -27, -109, -91, -26, -107, -103, -24, -126, -78]
             */

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 讲解: ✅: InputStreamReader 字节流 转为 字符流 (字节转字符就要编码) 几个字节是 一个字符 ? 所以必须传编码
     * @throws IOException
     */
    @Test
    public void test03() throws IOException {
        File gbkFile = new File(ioTestPath + "gbk.txt");
        File utf8File = new File(ioTestPath + "utf8.txt");
        // ✅: InputStreamReader 字节流 转为 字符流 (字节转字符就要编码) 几个字节是 一个字符 ? 所以必须传编码
        Reader inputStreamReader = new InputStreamReader(new FileInputStream(gbkFile), Charset.forName("GBK"));
        // 这个方法 是可以把 字节流 转为指定的 编码的 字符. 然后再通过字符缓冲流继续包装.
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        bufferedReader.readLine(); //就可以把字符一行一行读出. 然后可以把这一行 有转为 utf 写入 看 test04 方法
    }

    /**
     * 高效的 读 然后 写:
     *
     */
    @Test
    public void test04()  {
        File gbkFile = new File(ioTestPath + "gbk.txt");
        File utf8File = new File(ioTestPath + "utf8.txt");
        try (
                // ✅: InputStreamReader 字节流 转为 字符流 (字节转字符就要编码) 几个字节是 一个字符 ? 所以必须传编码
                BufferedReader reader = new BufferedReader( //缓冲字符流 . 就可以高效读取, 比如 一行 一行的读.
                        new InputStreamReader( //字节流包装为字符 就要告诉 则怎么去编码, 这些字节是几个字节一个字符呀?
                        new FileInputStream(gbkFile), Charset.forName("GBK")
                        )
                );
                // OutputStreamWriter 输出字符流 字节转为字符 都是要编码
                BufferedWriter writer = new BufferedWriter( //然后可以高效的 写入 , 比如写一行
                        new OutputStreamWriter( //字节变字符就要告诉编码.
                                new FileOutputStream(utf8File), StandardCharsets.UTF_8)
                )
        ) {

            String line;
            while ((line = reader.readLine()) != null) {
                //读一行 , 写一行.
                writer.write(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 读字符 写 字符的形式
     */
    @Test
    public void test05()  {
        File gbkFile = new File(ioTestPath + "gbk.txt");
        File utf8File = new File(ioTestPath + "utf8.txt");
        try (
                // ✅: InputStreamReader 字节流 转为 字符流 (字节转字符就要编码) 几个字节是 一个字符 ? 所以必须传编码
                BufferedReader reader = new BufferedReader( //缓冲字符流 . 就可以高效读取, 比如 一行 一行的读.
                        new InputStreamReader( //字节流包装为字符 就要告诉 则怎么去编码, 这些字节是几个字节一个字符呀?
                                new FileInputStream(gbkFile), Charset.forName("GBK")
                        )
                );
                // OutputStreamWriter 输出字符流 字节转为字符 都是要编码
                BufferedWriter writer = new BufferedWriter( //然后可以高效的 写入 , 比如写一行
                        new OutputStreamWriter( //字节变字符就要告诉编码.
                                new FileOutputStream(utf8File), StandardCharsets.UTF_8)
                )
        ) {

            //缓存大小:
            char[] chars = new char[5];
            // reader.read(chars) 读字符. read 返回实际读的字符个数
            int len ;
            while (( len = reader.read(chars)) != -1) {
                System.out.println(len);
                System.out.println(Arrays.toString(chars));
                //读到多少个字符就写入多少个字符
                writer.write(chars, 0 ,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * ✅: 重点 搞清楚 字节 和  字符的转换.
     */
}
