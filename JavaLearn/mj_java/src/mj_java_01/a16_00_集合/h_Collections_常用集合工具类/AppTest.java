package mj_java_01.a16_00_集合.h_Collections_常用集合工具类;

import org.junit.Test;

import java.util.*;

public class AppTest {
    /**
     * java.util.Collections 是个常用的集合工具类,提供了很多实用的静态方法.
     * 一般以 s 结尾 在JDK中就是工具类.
     */
    @Test
    public void test01() {
        List<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(89);
        list.add(109);
        list.add(34);
        System.out.println(list);

        //泛型方法完整写法复习:
        Collections.<Integer>sort(list);
        System.out.println(list);

        Integer max = Collections.max(list);
        System.out.println(max);

        //可变参数, 往 list 中添加元素
        Collections.addAll(list, 102, 101, 100);
        System.out.println(list); //[11, 34, 89, 109, 102, 101, 100]
        //翻转:
        Collections.reverse(list); //翻转:[100, 101, 102, 109, 89, 34, 11]
        System.out.println(list);

        //shuffle 随机 打乱 list 中的元素.
        Collections.shuffle(list);
        System.out.println(list); //[34, 102, 101, 109, 89, 11, 100]

        //交换位置
        Collections.swap(list,0,1);
        System.out.println(list); //[102, 34, 101, 109, 89, 11, 100]

        //把list的所有元素用 666 填充.
        Collections.fill(list, 666);
        System.out.println(list);

        //拷贝:把一个源src集合拷贝到另一个目标dest集合中.
        //jdk 1.8 ， new 一个 arraylist ，初始化的容量是  0  .????
        //  List<Integer> desList = new ArrayList<>( 20);
        /**
         *  //❌异常:java.lang.IndexOutOfBoundsException: Source does not fit in dest
         *  解决方案: https://blog.csdn.net/weixin_43570367/article/details/102969344
         */
        List<Integer> desList = Arrays.asList(new Integer[list.size()]);

        Collections.copy(desList, list);
        System.out.println(desList);

        // 替换集合中 是 oldVal 的值为 newVal :
        Collections.replaceAll(list, 666, 777);
        System.out.println(list);

        //逆序比较器:
        Collections.sort(list);
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        //可以直接传入一个 逆序比较器
        Collections.sort(list,Collections.reverseOrder());

        /**
         *  Arrays 值针对 数组 的集合类
         *  数组 : 类型[]  这样的叫数组.
         *  Collections:是针对集合的 List Set Map Queue  Stack Vector 等 的.
         */

    }
}
