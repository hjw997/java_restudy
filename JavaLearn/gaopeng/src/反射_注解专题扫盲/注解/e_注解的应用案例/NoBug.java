package 反射_注解专题扫盲.注解.e_注解的应用案例;

import java.beans.JavaBean;

public class NoBug {

    @JianCha
    public void test01(int a, int b) {
        System.out.println(a + b);
    }

    @JianCha
    public void test02(int a, int b) {
        System.out.println(a - b);
    }

    @JianCha
    public void test03(int a, int b) {
        System.out.println(a * b);
    }
    @JianCha
    public void test04(int a, int b) {
        System.out.println(a / b);
    }

    //下面的没加注解:不参与检查
    public void test05(int a, int b) {
        System.out.println(a % b);
    }
}
