package DesignPattern.g_composite.a;

import java.util.Collection;
import java.util.HashSet;

/**
 * 需求:制作一个集合,要求该集合能记录曾经加过多少个元素.(不是统计某一时刻集合中有多少个元素)
 * 地球上曾经诞生过多少人?
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

    @Override
    public boolean addAll(Collection c) {
        count += c.size();
        return super.addAll(c);
    }
}


public class AppTest {
    public static void main(String[] args) {
        MySet set = new MySet();
        set.add("a");
        set.add("b");
        set.add("c");
        // set.addAll() ; 如何 addAll 时候 用的去统计.
        System.out.println(set.getCount());
    }
}
///❌ 问题: 上面的 addAll 里面调用了 add 造成 add 重复累加了. 父类先去子类找方法add 如果找到就调用子类的.