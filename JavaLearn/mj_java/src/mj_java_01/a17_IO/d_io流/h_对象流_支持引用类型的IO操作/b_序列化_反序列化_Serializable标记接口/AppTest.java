package mj_java_01.a17_IO.d_io流.h_对象流_支持引用类型的IO操作.b_序列化_反序列化_Serializable标记接口;

import mj_java_01.a17_IO.d_io流.PathConstant;
import org.junit.Test;

import java.io.*;

public class AppTest {
    private static final String ioTestPath = PathConstant.ioTestRootPath;
    public static void main(String[] args) {

    }

    /**
     * 1. 对象输出流 -  ObjectOutputStream 序列化(对象变为二进制数据)
     */
    @Test
    public void test01() throws IOException  {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ioTestPath + "Person.data"));
        Person p = new Person(20, "Rose");
        p.car = new Car(19.9, "宾利");
        p.books.add(new Book(38.8, "Java"));
        p.books.add(new Book(40.5, "C++"));
        oos.writeObject(p); //写入第一个对象 ✅

        Car car = new Car(100.0, "BMW");
        oos.writeObject(car);//写入第二个对象 ✅
        /**
         * 注意细节:这里写入了两个 对象
         */
    }

    /**
     * 2.读取文件
     * ObjectInputStream --反序列化 : 二进制文件 变为 对象.
     * @throws IOException
     */
    @Test
    public void test02() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ioTestPath + "Person.data"));
        Object o = ois.readObject();//反序列化 当初写进去的 第一个 Person 对象.
        System.out.println(o);
        /**
         Person{age=20, name='Rose', car=Car{price=19.9, band='宾利'}, books=[Book{price=38.8, name='Java'}, Book{price=40.5, name='C++'}]}
         */
        Object o2 =  ois.readObject(); //反序列化 car 对象.
        System.out.println(o2);
        /**
         * Car{price=100.0, band='BMW'}
         */

    }

    /**
     * 上么的 这个 操作 叫做 :
     * 对象的序列化  (将对象转为 二进制) ObjectOutputStream 序列化(对象变为二进制数据)
     * 可传输或者可存储的数据:就是 0101010 的二进制数据.
     * 和
     * 反序列化 (利用 二进制还原对象) ObjectInputStream --反序列化 : 二进制文件 变为 对象.
     * 看示意图.png
     * 对象的序列化 和 反序列化 要实现 标记接口 Serializable 接口
     */


}
