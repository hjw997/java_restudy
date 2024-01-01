package mj_java_01.a16_00_集合.g_Map.a_HashMap;

import org.junit.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;

public class AppTest {
    /**
     * 首先看下 Map 有啥特点:
     * 1.不可以存储重复的 key, 可以存储重复的 value
     * 2. 不可以通过索引访问.  而是 key-value
     * 3. 没有实现迭代器接口,所以不能使用 迭代器访问.
     */

    @Test
    public void test01() {
        Map<String, Integer> map = new HashMap<>();
        map.put("Jack", 11);
        map.put("Rose", 22);
        map.put("Jim", 33);
        map.put("Jack", 44); //key 不可重复
        map.put("Kate",11); //元素可重复

        //4 对 key-value.
        System.out.println(map.size());
        //通过key 获取值
        System.out.println(map.get("Jack"));

        //{Kate=11, Rose=22, Jack=44, Jim=33} key不可以重复
        System.out.println(map);
        map.remove("Rose");
        System.out.println(map);

    }

    /**
     * Map的遍历--推荐方式: ✅
     */
    @Test
    public void test02() {
        Map<String, Integer> map = new HashMap<>();
        map.put("Jack", 11);
        map.put("Rose", 22);
        map.put("Jim", 33);
        map.put("Jack", 44);
        map.put("Kate",11);


        // ✅方式1  map.entrySet()
        // 首先知道什么是Entry .
        // 什么叫Entry? 就是一个键值对 对象. 看图解.
        Map.Entry<String,Integer> entry;

        //现在要遍历所有的map 就是拿出所有的 Entry对象.
        //map.entrySet 会把所有的 Entry 放入到 一个Set中.
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String, Integer> anEntry : entries) {
            System.out.print(anEntry.getKey() + " : " + anEntry.getValue() + " ");
            /**
             Kate : 11 Rose : 22 Jack : 44 Jim : 33 Kate:11
             */
        }

        //✅ 方式2 使用 接口 BiConsumer 接口
        map.forEach(new BiConsumer<String, Integer>() {
            @Override
            public void accept(String key, Integer value) {
                System.out.println(key + ":" + value);
            }
        });

        // lambda 简化: 两个参数时候 () 不可以省略, 一个的时候是可以省略的.
        map.forEach((key, value) -> System.out.println(key + " =  " + value));

    }

    /**
     * 另一种遍历:
     * map.keySet() -- 获取所有的key
     * map.values() -- 获取到所有的 value
     * 如果在遍历的时候想要直接拿到 key-value 使用上面推荐的方式.
     */
    @Test
    public void test03() {
        Map<String, Integer> map = new HashMap<>();
        map.put("Jack", 11);
        map.put("Rose", 22);
        map.put("Jim", 33);

        //获取到所有的Key.
        Set<String> keys = map.keySet();
        for (String key : keys) {
            //先遍历key,再通过key 去找 value(效率低)
            System.out.println(key + "=" + map.get(key));
        }
        //只能 遍历 value.
        Collection<Integer> values = map.values();
        for (Integer value : values) {
            System.out.println(value);
            //只要是 hash map 顺序也是乱的. 跟添加没关系.
        }
    }



}
