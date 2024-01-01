package mj_java_01.a16_00_集合.f_Set;

import java.util.*;

public class AppTest {
    public static void main(String[] args) {
        /**
         * 学完 Map 包内容 总结:
         *  Set 的底层是 用 map 实现的
         *  HashSet 底层用了 HashMap
         *  LinkedHashSet 底层用了LinkedHashMap
         *  TreeSet 底层用了TreeMap
         */
        Set<String> set = new HashSet<>();



        Map<String,Integer> map = new HashMap<>();

        set.add("java");
        /**
         * HashSet 底层就是 HashMap
         * Set 重要特点:元素不能重复 . Map 重要特点Key不能重复.
         *
         * HashSet中直接 创建了一个HashMap : 所以说: HashSet 底层用了 HashMap
             public HashSet() {
                    map = new HashMap<>();
             }
         *  HashSet 的 add方法实现:
         *  public boolean add(E e) {
         *         ✅ : set的元素当做 HashMap 的key.
         *         Map是key 唯一, 所以就做到了 Set 元素去重.
         *         return map.put(e, PRESENT)==null;
         *     }
         */

        set.remove("Jack");
        /**
         * HashSet 的 remove 方法:
         * public boolean remove(Object o) {
         *         //就是从 map 中来 remove 内容.
         *         return map.remove(o)==PRESENT;
         *         HashMap 底层又是用了-红黑树 链表 - 哈希表 等等  算法课中有
         *     }
         */

    }
}
