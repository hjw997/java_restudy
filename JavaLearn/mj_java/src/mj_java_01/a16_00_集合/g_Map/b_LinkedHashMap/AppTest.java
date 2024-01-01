package mj_java_01.a16_00_集合.g_Map.b_LinkedHashMap;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class AppTest {
    /**
     * LinkedHashMap 在 HashMap基础上,记录了元素添加的顺序.
     */

    @Test
    public void test01() {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("Jack", 11);
        map1.put("Rose", 22);
        map1.put("Jim", 33);
        System.out.println(map1);

        Map<String, Integer> map2 = new LinkedHashMap<>();
        map2.put("Jack", 11);
        map2.put("Rose", 22);
        map2.put("Jim", 33);
        System.out.println(map2);
        /** 对比打印的顺序:
         {Rose=22, Jack=11, Jim=33} 顺序还是乱的.
         {Jack=11, Rose=22, Jim=33} 记录了添加的顺序
         */

        /**
         * 所以遍历的时候 LinkedHashMap是有顺序的.
         */
        map2.forEach((key, value) -> {
            System.out.println(key + " = " + value);
            /** 看出按照添加顺序作了打印.
             * Jack = 11
             * Rose = 22
             * Jim = 33
             */
        });



    }
}
