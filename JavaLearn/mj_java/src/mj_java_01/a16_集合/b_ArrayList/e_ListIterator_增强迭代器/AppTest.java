package mj_java_01.a16_集合.b_ArrayList.e_ListIterator_增强迭代器;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class AppTest {

    @Test
    public void test01() {
        List<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(22);
        list.add(33);
        list.add(44);
        ListIterator<Integer> it = list.listIterator();
        while (it.hasNext()) {
            //it.next() 获取游标所指的元素,并且游标往下移动.
            Integer ele =  it.next() + 55;
            it.set(ele); //修改元素内容
        }
        System.out.println(list);

        //还可以从后往前遍历
        while (it.hasPrevious()) {
            System.out.println(it.previous());
        }
    }
}
