package mj_java_01.a15_泛型_Generic.b_泛型方法.a_泛型方法基本概念;

import java.util.Arrays;
import java.util.Comparator;

public class AppTest {
    public static <setStu> void main(String[] args) {
        Integer[] list = new Integer[10];
        Arrays.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });

        Student<String, Integer> student = new Student<>("1", 45);
        //现在想把 下面的 设置 分数和学号 封 装到一个方法中
//        student.setScore(90);
//        student.setNo("2");

        //不通用 类型写死了
        setStudentNoAndScore(student, "3", 99);

        //✅ 通用的做法 泛型方法:
        setStu(student,"3",99);


        Student<Integer,Integer > student1 = new Student<>(0, 0);
        /**
         * 泛型方法的 完整的写法: 因为 setStu 是 静态方法 所以用 类型.xxx 方式调用
         * 调用泛型方法的时候就要说明 这个泛型参数是什么类型.
         */
        AppTest.<Integer, Integer>setStu(student1, 1, 100); //完整版
        AppTest.setStu(student1, 1, 100); //编译器可以根据参数 自动推断出来.

    }

    //不通用.
    private static void setStudentNoAndScore(Student<String, Integer> stu, String no, Integer score) {
        stu.setNo(no);
        stu.setScore(score);
    }

    /**
     * 泛型方法:
     * 在返回值 前面 加上 泛型类型
     * 泛型的标志 <> 出现<> 就是泛型.
     */
     static <T1, T2> void setStu(Student<T1, T2> stu, T1 no, T2 score) {
        stu.setNo(no);
        stu.setScore(score);
    }

}

class Box<E> {
    private E element;
    public E getElement() {
        return element;
    }
    public void setElement(E element) {
        this.element = element;
    }
    /**
     * 1: 虽然上面的方法中 有泛型参数E 但是不是泛型方法,而是泛型类型的一部分.
     * 带 E 泛型的方法是数据泛型类型的一部分,不是泛型方法.
     */

    /**
     * 2.什么是泛型方法:
     * 使用了泛型的方法(实例方法,静态方法,构造方法)
     */

}


/**
 * 多个类型参数:
 */
class Student<N, S> { //N 表示Number  S是:Second 第二个意思
    private N no;
    private S score;

    public Student(N no, S score) {
        this.no = no;
        this.score = score;
    }

    public N getNo() {
        return no;
    }

    public void setNo(N no) {
        this.no = no;
    }

    public S getScore() {
        return score;
    }

    public void setScore(S score) {
        this.score = score;
    }
}

