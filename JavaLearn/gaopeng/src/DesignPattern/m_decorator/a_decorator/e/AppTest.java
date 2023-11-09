package DesignPattern.m_decorator.a_decorator.e;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/***
 * 至此已经学完了 "装饰器模式"
 *
 * 其实我们以前学习的jdk中的流,就是一种装饰器模式的体现.
 */
public class AppTest {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {

        //最原始的字节流 一个字节一个字节的 读 或者 读一个字节数组.
        InputStream inputStream = new FileInputStream("F://1.text"); //虚构的路径.

        //增加缓冲区(任然是字节流)
        BufferedInputStream bis = new BufferedInputStream(inputStream);

        //字节流->字符流 的桥梁(需要码表:几个字节为一个字符.)
        Reader reader = new InputStreamReader(bis, StandardCharsets.UTF_8);
        Reader reader1 = new InputStreamReader(bis);//默认码表
        System.out.println(Charset.defaultCharset()); //UTF-8
        //调料是谁呢?
        FilterInputStream fis = new BufferedInputStream(bis);

        /**
         * Reader
         * Reader 类是 Java IO API 中所有 Reader 子类的基类。 Reader 类似于 InputStream ，除了它是基于字符而不是基于字节的。 换句话说， Reader 用于读取文本，而 InputStream 用于读取原始字节。
         *
         * Writer
         * Writer 类是 Java IO API 中所有 Writer 子类的基类。 Writer 就像一个 OutputStream ，除了它是基于字符而不是基于字节的。 换句话说，Writer 用于写入文本，而 OutputStream 用于写入原始字节。
         * Writer 通常连接到某些数据目标，如文件，字符数组，网络套接字等。
         *
         * Unicode中的字符
         * 许多应用程序使用 UTF（UTF-8或UTF-16）来存储文本数据。 可能需要一个或多个字节来表示 UTF-8 中的单个字符。 在 UTF-16 中，每个字符需要 2 个字节来表示。 因此，在读取或写入文本数据时，数据中的单个字节可能与 UTF 中的一个字符不对应。 如果只是通过 InputStream 一次读取或写入 UTF-8 数据的一个字节，并尝试将每个字节转换为字符，可能不会得到正确的文本。
         *
         * Reader 类能够将字节解码为字符。 只需要告诉Reader 要解码的字符集。 这是在实例化 Reader 时执行的（当实例化其中一个子类时）。 通常会直接使用 Reader 子类而不是 Reader。Writer 同理。
          */
    }
}
