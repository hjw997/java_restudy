package mj_java_01.a16_00_集合.f_Set.c_TreeSet;

import org.junit.Test;
import sun.management.Agent;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class AppTest {
    public static void main(String[] args) {

    }

    /**
     * TreeSet 也是 Set
     * 要求元素必须具备可比较性,默认按照从小到大的顺序便利元素.
     */
    @Test
    public void test01() {
        Set<Person> set = new TreeSet<>();
        set.add(new Person(10));
        set.add(new Person(11));
        set.add(new Person(10));
        System.out.println(set);
    }

    @Test
    public void test02() {
        //String 默认实现了 Comparable 接口.
        Set<String> set = new TreeSet<>();
        set.add("Jack");
        set.add("Rose");
        set.add("Jim");
        set.add("Kate");
        set.add("Rose");
        set.add("Larry");
        //去重 + 排序 ✅: [Jack, Jim, Kate, Larry, Rose]:
        System.out.println(set);
        for (String s : set) {
            System.out.println(s);
            // ✅[Jack, Jim, Kate, Larry, Rose]
        }
    }

    /**
     * 3.TreeSet : 也可以传入一个比较器, 自定义比较方式
     */
    @Test
    public void test03() {
        //默认升序.没有比较器的话.
        Set<Integer> set = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1; // 自定义为:降序排列.
            }
        });

        //lambda 简化: 当只有一个参数的时候 () 可以省略.
        Set<Integer> set1 = new TreeSet<>((o1, o2) -> {
            return o2 - o1; // 自定义为:降序排列.
        });

        set.add(11);
        set.add(22);
        set.add(33);
        set.add(44);
        //[44, 33, 22, 11]
        System.out.println(set);
    }

}

/**
 * 要求元素必须具备可比较性: 也就是 实现 Comparable 接口
 * java.lang.ClassCastException: a16_00_集合.f_Set.c_TreeSet.
 * Person cannot be cast to java.lang.Comparable
 */
class Person {
    private final int age;

    public Person(int age) {
        this.age = age;
    }
}
