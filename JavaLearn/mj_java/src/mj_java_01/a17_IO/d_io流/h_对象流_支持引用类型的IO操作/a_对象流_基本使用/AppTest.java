package mj_java_01.a17_IO.d_io流.h_对象流_支持引用类型的IO操作.a_对象流_基本使用;

/**
 * 如果存对象对象的属性非常多
 * 那么使用数据流一个一个读写会很麻烦.
 * 所以 引出对象流 对象流式可以 直接写入的 但是要实现一个标记接口
 *
 * 对象的序列化(将对象转为二进制)  和 反序列化( 利用二进制还原对象)
 */

import mj_java_01.a17_IO.d_io流.PathConstant;
import org.junit.Test;

import java.io.*;

/**
 * 有个主角: 游戏中的 想要保存 用户的信息.
 */
class Person { //为了测试代码简洁 不写setter getter 方法.
    int age;
    String name;
    int level;

    public Person(int age, String name, int level) {
        this.age = age;
        this.name = name;
        this.level = level;
    }
}

/**
 * Serializable 实现接口 , 但是不用实现任何方法,那么就是
 * 标记接口  (Maker Interface) ✅
 */
class Student implements Serializable { //为了测试代码简洁 不写setter getter 方法.
    int age;
    String name;
    int level;

    public Student(int age, String name, int level) {
        this.age = age;
        this.name = name;
        this.level = level;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", level=" + level +
                '}';
    }
}


public class AppTest {
    private static final String ioTestPath = PathConstant.ioTestRootPath;
    public static void main(String[] args) {

    }

    @Test
    public void test01() throws IOException {
        Person p = new Person(20, "jack", 2);
        //想要保存这个对象呢? 使用数据流 的一个一个的字段属性写入:
        DataOutputStream dos = new DataOutputStream(new FileOutputStream(ioTestPath + "person.txt"));
        dos.writeInt(p.age);
        dos.writeUTF(p.name);
        dos.writeInt(p.level);
        dos.close();
        /**
         * 确定如果属性很多很多,然后又有嵌套的引用属性等等.
         * 那么就会 出现 很复杂的代码.
         * 读出来的话也是 一个一个按照顺序组装出来. 麻烦.
         */
    }

    /**
     * 引出对象流:
     * ObjectOutputStream 写一个引用对象 到文件
     * 这个对象必须 实现接口 Serializable
     * 否则报异常: ❌
     * java.io.NotSerializableException:
     */
    @Test
    public void test02() throws IOException {
        Student stu = new Student(20, "jack", 2);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ioTestPath + "person1.txt"));
        //写一个对象出去 这个对象要实现  java.io.NotSerializableException: 接口.
        oos.writeObject(stu);
        oos.close();
    }

    @Test
    public void test03() throws IOException, ClassNotFoundException {

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ioTestPath + "person1.txt"));
        //断点看到: 真实类型为 Student
        //Object o = ois.readObject();
        /**
         * java.io.InvalidClassException:  ❌ 看d包 序列号 号问题.
         * a17_IO.d_io流.h_对象流_支持引用类型的IO操作.a_对象流_基本使用.Student;
         * local class incompatible: stream classdesc serialVersionUID = -2985110487786631943,
         * local class serialVersionUID = 7842205364924867402
         * PS : 一旦对象被改动后没有重新写入 就会报错. 因为序列化版本变化了.
         */
        Student o = (Student) ois.readObject();
        System.out.println(o);
        ois.close();

        /**
         * ArrayList String 都实现了 Serializable 接口.
         * 如果 一个对象能通过对象流写入文件,那么所有的成员变量都是实现了 Serializable 接口的.
         */
    }




}


