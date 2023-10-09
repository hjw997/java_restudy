package DesignPattern.g_composite.c;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * 需求:制作一个集合,要求该集合能记录曾经加过多少个元素.(不是统计某一时刻集合中有多少个元素)
 * 地球上曾经诞生过多少人?
 * <p>
 * 针对 b 包中问题,MySet 必须依赖于这样一个事实,addAll 必须回调 add,但是jdk未来版本不会做这个保证.
 * 我们自己亲自去重写 addAll ,不在让 count 累加 c.size()了, 而是保证addAll 一定会调用 add
 *
 * 修改代码如下:
 *
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
        boolean success = false;
        for (Object obj : c) {
            /// 这里我亲自重写 addAll
            if (add(obj)) {
                success = true; //只要有一次添加成功 返回值就是 ture.
            }
        }
        /// 只要这里重写了覆盖了作者上层方法,万一作者依赖这个方法,这一下就有撼动上层的依赖关系. ❌.
        return success;
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
 * 问题是:
 *  1. 如果在新的 jdk 版本中,HashSet 多了一个元素加入集合的入口的方法,
 *     addSome, 这个addSome 是我们始料未及的 我们的MySet 根本没有重写新版本中出现的addSome方法.
 *     这样在新版本中 我们的MySet也继承了addSome方法, 当使用addSome方法添加元素时,根本不会去统计元素的数量.
 *  2. 问题我们重写了addAll 方法 和 add 方法, 要知道在整个Hashset的所有方法中,难免有一些方法依赖这俩方法,
 *      你重写了别人类中的某些方法,破坏了原来的 内部的方法之间的依赖的关系. 因为你不清楚里面的具体业务逻辑.
 *      这样就会造成原来作者本来写好的各种关系被破坏的风险. 从而撼动上层作者的代码.
 *   -----这就是继承惹的祸.
 */