package mj_java_01.a17_IO.d_io流.f_格式化输出;

import java.io.IOException;
import java.io.PrintWriter;

public class AppTest {
    public static void main(String[] args) throws IOException {
        /**
         *   PrintStream 类型  - 字节流
         *   带有 Stream 字节流
         *
         *   PrintStream 格式化的输出
         */
        System.out.println(123);
        System.err.println(1234); //打印颜色红色 不一定谁先打印.



        //区别: PrintStream PrintWriter
        /**
         * PrintStream 格式化的输出 - 标准输出到 屏幕(控制台)  . 不要写文件
         */
        int age = 18;
        String name = "mj";
        System.out.format("%d %s \n",age,name);  //标准输出到 屏幕(控制台)


        /**
         * 如果想要 写入使用格式化的输出流到文件的 PrintWriter
         */
        PrintWriter writer = new PrintWriter("F:/1.txt");
        //这个会输出到哪里呢? 因为构造方法指明了 要输入到到文件中 ("F:/1.txt").
        writer.format("My name is %s , age is %d",name,age);
        writer.println(10);
        writer.printf("My name is %s , age is %d",name,age);
        /**
         * 以上三个 方法 内部 默认是不会 刷新缓冲区到磁盘.
         * 但是构造方法 如果 autoFlush = true 的时候就会刷新.
         */
        writer.close();

        /**
         *  System.out.print  System.out.write 区别:
         *  System.out.print 把a格式化后输出显示出原来样子.
         *  System.out.write 写出一个字节,把a当做字节写出
         *  打印效果:
         *  97a
         */
        int a = 97;
        System.out.print(a);
        System.out.write(a);
        System.out.flush();

        /**
         * 所以 在使用 PrintWriter writer = new PrintWriter 的时候
         * write 和 print 是 不一样的效果
         * writer.write(a) 当做字节写入. 所以文件打开显示的是 a
         * write.print(a) 将a格式化后原封不动的写入原本的样子. 97 .
         */
        writer.write(a); //将a当做一个字节写入 所以显示 a
        writer.print(a);   // 写入的是 9和7 , 是个两个字节 是个字符串"97"

    }
}
