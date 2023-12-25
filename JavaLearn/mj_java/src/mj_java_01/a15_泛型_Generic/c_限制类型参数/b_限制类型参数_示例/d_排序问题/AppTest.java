package mj_java_01.a15_泛型_Generic.c_限制类型参数.b_限制类型参数_示例.d_排序问题;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class AppTest {

    public static void main(String[] args) {




    }

    /**
     * 比较器:
     */
    @Test
    public void test03() {
        Person[] people = {
                new  Person(15),
                new  Person(18),
                new  Person(19),
                new  Person(11),
        };

        /**
         * 如果Person 实现了接口 Comparable 接口,又传入比较器. 会以比较器的优先级来比较.
         * 传入比较器 优点 符合开闭原则.
         *
         */
        Arrays.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                /**
                 * 在比较器中说清楚 谁大 谁小.
                 */
                //return o1.age - o2.age; //升序
                return o2.age - o1.age;  //降序
            }
        });

        System.out.println(Arrays.toString(people));
    }

    @Test
    public void test02() {
        Person[] people = {
                new  Person(15),
                new  Person(18),
                new  Person(19),
                new  Person(11),
        };
        // 人可排序么 数组的 sort 如果实现了Comparable接口的 compareTo方法 可以排 .
        // Arrays.sort 内部会调用 Comparable 的 compareTo方法. 没实现会抛异常
        Arrays.sort(people);
        System.out.println(Arrays.toString(people));
    }

    @Test
    public void test01() {
        Double[] doubles = {5.6, 7.3, 8.8, 9.5,1.1};
        Arrays.sort(doubles); //默认排序是升序
        System.out.println(Arrays.toString(doubles));

        Integer[] integers = {9, 11, 8, 6, 13, 10};
        //降序排 Comparator 函数是接口 可以用labmda 简化
        Arrays.sort(integers, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1; //降序
            }
        });

        //lambda简化:
        Arrays.sort(integers, (Integer o1, Integer o2) -> {
                return o2 - o1; //降序
            }
        );
        //只有一行更简洁: lambda简化:
        Arrays.sort(integers, (Integer o1, Integer o2) ->  o2 - o1);
    }

}

//class Person implements Comparable<Person> {
class Person {
    int age;

    public Person(int age) {
        this.age = age;
    }

//    @Override
//    public int compareTo(Person o) {
//        if (o == null) return 1; //没什么可比性.只要是大于1 的值就可以. 100 200 都行.
//
//
//        return age - o.age;   // 你认为的大 的交换条件
//        //return o.age - age; // 你认为的大 的交换条件
//    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                '}';
    }
}
