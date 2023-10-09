package DesignPattern.g_composite.b;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * 需求:制作一个集合,要求该集合能记录曾经加过多少个元素.(不是统计某一时刻集合中有多少个元素)
 * 地球上曾经诞生过多少人?
 * <p>
 * 针对 a 包中的问题:addAll 会调用 add方法,我们修改代码如下:把 addAll 删除掉,不要重写父类的HashSet的addAll 了.
 * 反正父类的 addAll 会去调用 add 方法.
 */

class MySet extends HashSet {
    public int getCount() {
        return count;
    }

    private int count = 0;

    @Override
    public boolean add(Object o) {
        count++;
        return super.add(o);
    }
}


public class AppTest {
    public static void main(String[] args) {
        MySet mySet = new MySet();

        Set set = new HashSet();
        set.add("a");
        set.add("b");
        set.add("c");
        mySet.addAll(set);
        mySet.add("e");
        System.out.println(mySet.getCount());
    }
}
/**
 * 此时,这个代码看起来没有问题, 能满足需求,
 * 问题是:目前这个代码必须依赖一个这样的事实,就是HasSet的addAll 方法必须去调用 add 方法.
 * 万一 addAll 方法内部在将来的jdk 版本 升级 , 不在调用中 add方法,我们自定义的MySet就被 "撼动" .
 * 比如 HashMap 在 jdk  1.6 1.7 1.8 (红黑树) 底层结构发生了三次变化.
 */