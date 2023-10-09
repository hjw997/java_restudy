package DesignPattern.g_composite.e;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * 需求:制作一个集合,要求该集合能记录曾经加过多少个元素.(不是统计某一时刻集合中有多少个元素)
 * 地球上曾经诞生过多少人?
 * <p>
 * 针对 d 包中2个问题:
 *
 * 修改代码如下:
 * 1.我们的MySet 再也不要继承HashSet了.
 * 2.取而代之,我们让MySet 和 HashSet 发生 关联关系(组合)
 */

class MySet {
    /// 组合关系:一个类作为另一个类的字段.
    private Set set = new HashSet();

    private int count = 0;

    public int getCount() {
        return count;
    }

    /**
     * 现在这里面 add 和 addAll 不是重写, 和 HashSet 内部方法破坏依赖关系的风险.
     */
    public boolean add(Object o) {
        count++;
        return set.add(o);
    }

    public boolean addAll(Collection c) {
        count += c.size();
        return set.addAll(c);
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


        /**
        jdk 中的反例 Stack 为了重用 Vector 中的 增删 功能.结果 多出了 不要的方法.
         把 vector 中用 的着的 用不着的 全部继承了过来. 我本来只是 选择父类中 某些方法用 . 结果多出了不必要的方法.
         这个就是 jDK 中的反例.
         大神出现: ConcurrentHashMap作者. Doug Lea . 并发包.
         jdk 中的栈 不如自己写个呢.
         */

    }
}
/**
 * 此时,这个代码看起来没有问题, 能满足需求,
 * 就算以后 HashSet 扩展了 新添加元素的方法 addSome, 但是 MySet 对外根本调用不到 HastSet 的 addSome 方法.
   完美解决.

 组合的问题:
 1. 难道以后就不用重写了么?
 2. 难道以后 就不能进行方法重写了吗?

 就一个原则:
 如果父类的作者,和 子类作者,不是同一个人,就别继承.
 那么父类作者,不知道未来的子类,会重写哪个方法.
 那么子类作者,不知道,未来的父类,会加入什么新方法.

 父类和子类 作者是同一个人,那就可以放开手脚使用继承了. 作者当然知道每个方法的作用. 作者可以同时控制父类和子类.
 如我我们仅仅是 复用代码,而继承别人的类,难免出现 " 沟通" 上的问题.
 所以组合优于继承.
 jdk 中的反例, Stack .


 */