package mj_java_01.a17_IO.d_io流.h_对象流_支持引用类型的IO操作.d_序列化_serialVersionUID;

import mj_java_01.a17_IO.d_io流.PathConstant;
import org.junit.Test;

import java.io.*;

class Person implements Serializable {
    //为了测试代码简洁 不写setter getter 方法.
    int age;
    String name;
    int level;

    /**
     * 只要一个类 实现了 Serializable 接口,每次编译后 就会给类生成一个版本号
     * 版本号是根据类的信息来生成地. 所以类变化就会 值不一致.
     * ✅✅ 强烈建议 每个可以序列化的类都自定义 serialVersionUID
     * static final long 必须是这个类型 ]
     * private 是不必要外界访问.
     *
     */
    private static final long serialVersionUID = 1L;

    public Person(int age, String name, int level) {
        this.age = age;
        this.name = name;
        this.level = level;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", level=" + level +
                '}';
    }
}

public class AppTest {
    private static final String ioTestPath = PathConstant.ioTestRootPath;

    private static final String testData = ioTestPath + "Sperson.data";

    public static void main(String[] args) {
        //将一个对象序列化后, 存入文件. 如果再改代码 就会 报错 ❌:
        /**
         *  java.io.InvalidClassException
         *  local class incompatible: stream classdesc serialVersionUID = 8216736617797095851,
         *  local class serialVersionUID = -3116416659393041490
         */
    }

    @Test
    public void test01() throws IOException  {
        Person p = new Person(20, "Jack", 3);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(testData));
        oos.writeObject(p);
        oos.close();
    }

    @Test
    public void test02() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(testData));
        Object o = ois.readObject();
        System.out.println(o);
    }
    /**
     * 有了自定义的 序列化的版本号后, 那么就不会再出现改动类 序列化和反序列化后报错的问题了 ✅
     */


}

