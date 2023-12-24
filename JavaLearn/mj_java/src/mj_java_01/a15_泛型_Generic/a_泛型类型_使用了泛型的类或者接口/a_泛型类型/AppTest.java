package mj_java_01.a15_泛型_Generic.a_泛型类型_使用了泛型的类或者接口.a_泛型类型;

import org.junit.Test;

public class AppTest {
    public static void main(String[] args) {


    }

    /**
     * 泛型基本用法
     */
    @Test
    public void test01() {
        //java 7 之前 new Student<String> 这里的泛型 <String> 也要写.
        Student<String> student3 = new Student<String>("优秀");

        //java 7 之后 后面的 泛型可以省略 只写 <>
        //<String> 这里就是把类型传入. 类型 参数化.
        Student<String> student = new Student<>("A+");
        System.out.println(student);

        Student<Double> student1 = new Student<>(88.5);
        System.out.println(student1);

        Student<Integer> student2 = new Student<>(88);
        System.out.println(student2);
    }

    /**
     * 2.多类型参数
     */
    @Test
    public void test02() {
        //多类型参数 是使用.
        Student1<Integer, String> student = new Student1<>(88, "A+");

        Student1<String, Double> student2 = new Student1<>("99", 88.5);

    }
}

/**
 * 使用泛型类
 * 什么是泛型:   将类型参数化
 *
 * 什么是泛型类: 使用了泛型的 类 或者 接口 叫做 泛型类.
 * 接口也可以使用泛型 .
 * public interface Comparable<T> {...}
 *
 * T 的专业术语: 叫 类型参数.
 * 但是为何建议只写一个大写字母.比如 你要写个Type , 别人以为是个类.
 * 所以建议 用一个大写字母 .
 * 建议的几个写法看包内课件.
 * S : Second
 * U : 第三个
 * V :第四个
 * T : Type
 * N : 数字 Number
 * V : Value
 * E : Element
 */
class Student<T> { //泛型类 : 就是 类这里有个类型参数. 占位具体什么类型以后再决定.
    /** T 称为 类型参数 (type parameter) */
    T score;
    // 如果分数是 A+ 优 等字符串 或者 double 的 99.5 ,int 的 88 都可以用泛型类型表达

    public Student(T score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "score=" + score +
                '}';
    }

}

/**
 * 多个类型参数:
 */
class Student1<N, S> { //N 表示Number  S是:Second 第二个意思
    N no;
    S score;

    public Student1(N no, S score) {
        this.no = no;
        this.score = score;
    }
}


