package mj_java_01.a16_00_集合.g_Map.c_TreeMap;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class AppTest {
    /**
     * TreeMap
     * 必须要求 Key 必须要求具备可比较性 .默认按照从小到大的顺序遍历 key.
     */
    @Test
    public void test01() {
        // key必须要求 具备可比较性
        Map<String, Integer> map = new TreeMap<>();
        map.put("Jack", 11);
        map.put("Rose", 22);
        map.put("Jim", 33);
        map.put("Kate", 23);
        map.put("Larry", 33);

        //按照key从小到大: {Jack=11, Jim=33, Kate=23, Larry=33, Rose=22}
        System.out.println(map);

        map.forEach((key,value) ->{
            System.out.println(key + " = " +  value);
            /**
             Jack = 11
             Jim = 33
             Kate = 23
             Larry = 33
             Rose = 22
             */
        } );




    }


}
