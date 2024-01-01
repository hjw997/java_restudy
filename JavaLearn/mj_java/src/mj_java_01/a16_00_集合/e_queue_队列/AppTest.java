package mj_java_01.a16_00_集合.e_queue_队列;

import java.util.LinkedList;
import java.util.Queue;

public class AppTest {
    public static void main(String[] args) {

        /**
         * public interface Queue<E> extends Collection<E>
         * Queue 是个接口,它的常用实现是 LinkedList
         * 为何要用LinkedList 因为 队列是对  队头 对尾的操作 .
         * 对 队头队尾的操作 使用双向链表.
         *
         */
        Queue<Integer> queue = new LinkedList<>();

        //入队.
        queue.add(11);
        queue.add(22);
        queue.add(33);
        queue.add(44);
        // 入队:
        queue.offer(55);

        //查看 队头的元素. element 和 peek 方法.
        Integer element = queue.element();
        System.out.println(element);

        //出队: poll :  poll削头 . remove 也是出队
        Integer poll = queue.poll();
        System.out.println(poll);
        while (!queue.isEmpty()) {
            System.out.println(queue.remove());
        }

    }
}
