package mj_java_01.a16_00_集合.c_LinkedList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AppTest {
    public static void main(String[] args) {
        //ArrayList 动态数组-数组元素是连续的.
        /**
         * LinkedList 是双向链表. size获取链表大小  first指针 last 指针.
         * 每 add() 创建一个Node 节点. 元素存到 item中
         * 链表也能 通过 下标去找到元素( list.get(index) )  . 就是 first 开始去第一个节点 next 去找.
         * 怎么找更近呢 ? 从 last 的 prev 去找,
         * 为何搞成双向就是为了提高查找的效率.
         */

        //面向接口编程
        //List<Integer> list = new ArrayList<>();
        List<Integer> list = new LinkedList<>();
        list.add(22);
        list.add(33);

        list.get(2);


    }
}
