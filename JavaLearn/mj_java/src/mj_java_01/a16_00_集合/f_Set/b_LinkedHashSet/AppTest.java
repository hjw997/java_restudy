package mj_java_01.a16_00_集合.f_Set.b_LinkedHashSet;

import org.junit.Test;

import java.util.LinkedHashSet;
import java.util.Set;

public class AppTest {
    public static void main(String[] args) {

    }

    /**
     * LinkedHashSet
     * 在HashSet 基础上 增加了记录元素添加顺序的功能.
     */
    @Test
    public void test() {
        Set<String> set = new LinkedHashSet<>();
        set.add("jack");
        set.add("rose");
        set.add("kate");
        set.add("jack");

        //[jack, rose, kate] 记录了添加顺序,但是还是有去重的功能.
        System.out.println(set);

        //增强for 循环. 此时出来的值也是有按照添加的顺序.
        for (String s : set) {
            System.out.println(s);
        }

        set.remove("rose");
        //[jack, kate] 删除后顺序是依然对的.
        System.out.println(set);

    }
}
