package mj_java_01.a17_IO.d_io流.h_对象流_支持引用类型的IO操作.c_不需要序列化修饰_transient;

import java.io.Serializable;

public class AppTest {
    public static void main(String[] args) {

    }

}

class Dog implements Serializable {
    /**
     * transient: /ˈtræn.zi.ənt/
     * lasting for only a short time; temporary
     */
    transient int age; //被transient修饰 不序列化(不存到文件)
    String name;
}
