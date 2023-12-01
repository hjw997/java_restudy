package mj_java_01.a04_继承.e_注解_Anotation;

import java.util.ArrayList;
import java.util.List;

/**
 * 注解:Annotation
 * @ 符合开始的
 * 3 个常见的注解:
 *  1 >   @Override 表示重写自父类. 可以限制你在子类防止你写错.
 *
 *  2 > 抑制警告:⚠️  @SuppressWarnings("警告的类别") 抑制该警告类别 的警告.
 *
 *       @SuppressWarnings("unused") //未使用的警告抑制  ⚠️
 *       @SuppressWarnings({"unused","rawtypes"})     // 多个警告抑制 可以用数组 , 警告抑制  ⚠️
 *

 */
class Person {
    public void test() {}
}

class Student extends Person {
    @Override
    public void test() {
        super.test();
    }
}
//@SuppressWarnings("ALL") //抑制类的所有警告⚠️
//@SuppressWarnings("rawtypes") //为整个类抑制某一种警告 ⚠️
public class AppTest {
    // 方法级别的抑制  ⚠️
    public static void main(String[] args) {
        @SuppressWarnings("unused") // 未使用的警告抑制  ⚠️
        Student student = new Student();

        @SuppressWarnings({"unused","rawtypes"})     // 多个警告抑制 可以用数组 , 警告抑制  ⚠️
        List list = new ArrayList();

    }
}
