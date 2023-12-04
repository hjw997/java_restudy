package mj_java_01.a06_嵌套类.a_嵌套类;

/**
 * 基本概念 :嵌套类 定义在其他类中的类 教做嵌套类. 分为静态嵌套类 和 非静态嵌套类(非静态嵌套类 才真的叫 内部类)
 */
public class AppTest { //外部类 -最外层的 叫做顶级类 Top-level class
    static class StaticNestedClass {  /**静态嵌套类*/

    }

    class InnerClass { /**非静态嵌套类 -- 这个才真真叫做 内部类.*/

    }

    public static void main(String[] args) {
        new StaticNestedClass();
    }
}
