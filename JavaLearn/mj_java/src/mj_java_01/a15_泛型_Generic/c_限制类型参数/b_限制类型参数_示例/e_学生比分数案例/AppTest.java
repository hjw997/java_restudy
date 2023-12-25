package mj_java_01.a15_泛型_Generic.c_限制类型参数.b_限制类型参数_示例.e_学生比分数案例;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class AppTest {

    public static void main(String[] args) {

        Student[] students = {
                new Student<>(20),
                new Student<>(50),
                new Student<>(90),
                new Student<>(15),
        };
        System.out.println(getMax(students));

    }
    static <T extends Comparable<T>> T getMax(T[] array) {
        if (array == null || array.length == 0) return null;
        T max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i].compareTo(max) <=  0) continue;
            //<= 0 表示:max大.就不用交换.
            max = array[i];
        }
        return max;
    }

}

/**
 * 注意这里的
 * 1. Student<T extends Comparable<T>> 是 score 是 可比较的限制
 *      Comparable<T> 内部要对这个类型 对比.
 *
 * 2. implements Comparable<Student<T>>  是学生是可比较的.
 *    Comparable<Student<T>> 的 Student<T> 是Student score 类型,是个可比较的类型.
 * @param <T>
 */
class Student<T extends Comparable<T>> implements Comparable<Student<T>> {
    private final T score; //分数是可比较的 .

    public Student(T score) {
        this.score = score;
    }

    @Override
    public int compareTo(Student<T> o) {
        // 学生的比较怎么比? 学生是个可比较的 , 转移 到 score 上比.
        // 所以  <T extends Comparable<T>> T是要可比较的
        // 分数 类型 T 是实现了 Comparable接口的.
        // return this.score.compareTo(o.score) ; 最大值
        //return o.score.compareTo(this.score) ; //最小值

        // 对null检测 更健壮
        if (o == null) return 1; //自己大
        // 如果是 score 是final 就不是空的
        return this.score.compareTo(o.score);
    }

    @Override
    public String toString() {
        return "Student{" +
                "score=" + score +
                '}';
    }
}
