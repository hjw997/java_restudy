package mj_java_01.a16_集合.b_ArrayList.b_自定义迭代器;

import java.util.Iterator;

/**
 * 说明:自定义迭代器说明
 * 如果想让我的 ClassRoom 也能使用 for-each 那样的遍历.
 * 那么就要自定义迭代器了.
 */
public class AppTest {
    public static void main(String[] args) {
        ClassRoom room = new ClassRoom("jack", "rose", "lucy");
        //for-each : 是语法糖:
        for (String stuName : room) {
            System.out.println(stuName);
        }
        System.out.println("====================");
        //for-each 本质是迭代器.上面的代码的本质.
        Iterator<String> iterator = room.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
}

class ClassRoom implements Iterable<String> {
    private final String[] students; //所有学生的名字

    public ClassRoom(String... students) { //可变参数构造方法是传入学生们的名字.
        //这里不用担心 null . 可变这个最少也会给传一个空数组(长度为0 的数组)
        this.students = students;
    }

    @Override
    public Iterator<String> iterator() { //for-each 就是 迭代器的证明
        return new ClassRoomIterator();
    }

    //自定义的迭代器:
    private class ClassRoomIterator implements Iterator<String> {
        private int cursor = 0;
        @Override
        public boolean hasNext() {
            //有没有下一个:就是看游标到最后的位置没有
            return cursor < students.length;
            /**
             * 为何 这里能访问 外部类的 students 数组呢?
             * 因为 ClassRoomIterator 是个内部类,内部类必须是要先有外面的实例才能创建 内部的实例.
             */
        }

        @Override
        public String next() {
            // next 要做的事情是:取出游标所指, 然后游标向下一个走
            // String student = students[cursor++];
            // return student;
            return students[cursor++]; //不做游标越界的判断.
        }
        /**
         * 有个问题就是 外界 一直next() 越界怎么办? 因为内部设计了 hasNext() 来判断刹车.一套完整方案.
         * 那就只能怪 使用者 不会用.😭
         */
    }

}