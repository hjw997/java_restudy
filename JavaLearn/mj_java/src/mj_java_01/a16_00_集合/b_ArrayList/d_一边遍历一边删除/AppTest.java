package mj_java_01.a16_00_集合.b_ArrayList.d_一边遍历一边删除;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AppTest {


    /**
     * 1.一边遍历一边删除 不可以的.
     *
     * 在每次 add remove 等修改长度的地方 做了 modCount++ 操作.
     * 在迭代器 和 for-each, forEach方法内部做了 modCount 修改的检测,
     * 发现修改了就抛出异常.
     * 其他的 经典的 for-i 循环中 是不会检测 modeCount 的变更.
     */
    @Test
    public void test01() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(22);
        list.add(33);
        list.add(44);
        list.add(55);

        int size = list.size();
        //for (int i = 0; i < list.size(); i++) {
//        for (int i = 0; i < size; i++) {
//            //java.lang.IndexOutOfBoundsException: Index: 2, Size: 2
//            list.remove(i);
//        }
//          System.out.println(list);


//        for (Integer integer : list) {
//            //❌:java.util.ConcurrentModificationException 并发修改异常.
//            list.remove(integer);
//        }
//        System.out.println(list);

        //等价:❌:java.util.ConcurrentModificationException 并发修改异常.
//        Iterator<Integer> iterator = list.iterator();
//        while (iterator.hasNext()) {
//            Integer ele = iterator.next();
//            list.remove(ele);
//        }
//        System.out.println(list);

        Iterator<Integer> iterator = list.iterator();
        //✅姿势:
        while (iterator.hasNext()) { //iterator.hasNext() 去判断游标 是不是 到了 数组尾部.
            iterator.next(); //没有这句也会报错.只有next()才会去拿东西, 并吧把游标指向下一个位置.
            //✅ remove 是删除 刚拿出来的 东西.
            iterator.remove();
        }
        System.out.println(list);

        List<Integer> list2 = new ArrayList<>();
        list2.add(11);
        list2.add(22);
        list2.add(33);
        list2.add(44);
        list2.add(55);
        Iterator<Integer> iterator2 = list2.iterator();
        //✅姿势:
        while (iterator2.hasNext()) {
            iterator2.next();
            iterator2.remove();
        }
        System.out.println(list2);
        /**
         * 如何监控到 ArrayList 在遍历的时候监控到 ArrayList 长度被变更了.
         * 只要修改长度就会 修改 modCount : Increments modCount!!
         * 在遍历之前先备份 modCount ,如果在遍历过程中修改了 modCount就会抛出异常.
         * 遍历过程中 判断
         * int oldCount = modCount;
         * if (modCount != oldCount) 就抛出异常
         *
         * 查看 ArrayList 中的迭代器的遍历.
         *
         *   private class Itr implements Iterator<E> {
         *         int cursor;       // index of next element to return
         *         int lastRet = -1; // index of last element returned; -1 if no such
         *         int expectedModCount = modCount;
         *         ...
         *         }
         *
         *  final void checkForComodification() { //迭代器中 遍历过程中的next方法中 调用 checkForComodification() .
         *             if (modCount != expectedModCount)
         *                 throw new ConcurrentModificationException();
         *         }
         */
        System.out.println("++++++++++++++++++");
        /**
         * 遍历的过程中删除东西 这种需求是有的 . 比如删除里面的偶数
         */
        List<Integer> list3 = new ArrayList<>();
        list3.add(11);
        list3.add(22);
        list3.add(33);
        list3.add(44);
        list3.add(55);
        list3.add(66);
        Iterator<Integer> it = list3.iterator();
        while (it.hasNext()) {
            /**
             * 需求 : 如果是偶数就删除掉.
             */
            //if (it.next() % 2 == 0) {
            if ((it.next() & 1) == 0) {
                //✅ 判断是不是 偶数技巧 按位与 上 1 ,就是获取到 二进制位的最后一位是 0 的话就是偶数
                /**
                用求模算 == 0 是偶数   二进制    最后一位如果是 0 就是偶数.
                 1 % 2 == 1         0b0001
                 2 % 2 == 0         0b0010
                 3 % 2 == 1         0b0011
                 4 % 2 == 0         0b0100
                 5 % 2 == 1         0b0101
                 那么如何取出 最后一位呢?
                    0b0100
                 &  0b0001  按位与(相同才为1)  就是取出对应的位的二进制数据,那么 按位与 1 就是取出最后一个位的二进制数.
                 ----------
                    0b0000
                 */
                it.remove();
            }
        }
        System.out.println(list3);

        /**
         * 如果我想在 遍历的时候 再加入一个元素. 现有的 迭代器 是不支持的.
         * 而且 也说了 变量的时候 只要修改了 集合的长度,就会抛出异常.
         * 那么请看下个包:e_ListIterator
         */
    }
}
