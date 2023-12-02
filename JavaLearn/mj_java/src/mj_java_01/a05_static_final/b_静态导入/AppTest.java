package mj_java_01.a05_static_final.b_静态导入;

import static mj_java_01.a05_static_final.b_静态导入.Person.name; /** 只导入某一个静态属性 */
import static mj_java_01.a05_static_final.b_静态导入.Person.run;  /** 导入一个静态的方法. */
import static mj_java_01.a05_static_final.b_静态导入.Person.Hand; /** 导入一个静态类*/

import static mj_java_01.a05_static_final.b_静态导入.Student.*; /** *表示 导入Student下的 所有的静态成员*/

import static java.lang.Math.PI; /** 建议用谁导谁 全部导入会降低可读性.分不清访问的是哪个类中的. */

/**
 * 静态导入的经典场景: 2πr
 * 静态导入 Math类 的 PI
 *
 */

public class AppTest {
    public static void main(String[] args) {
        //访问Person中的静态字段
        System.out.println( Person.count); //没有使用静态导入:
        System.out.println(name);
        run(); //调用的是Person.run()

        System.out.println(count); //使用的是静态导入的Student 的静态属性.

        Hand hand = new Hand(); // 这个Hand是Person 静态导入的 Hand类.


        /**
         * 静态导入的经典场景:
         */
        System.out.println(2* Math.PI * 10); //2πr 前面加个 Math 比较繁琐 使用静态导入
        System.out.println(2 * PI * 10); //这样子是不是更简洁呢~~~
    }
}
