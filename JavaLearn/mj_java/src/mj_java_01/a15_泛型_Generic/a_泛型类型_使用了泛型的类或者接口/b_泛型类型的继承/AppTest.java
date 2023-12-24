package mj_java_01.a15_泛型_Generic.a_泛型类型_使用了泛型的类或者接口.b_泛型类型的继承;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

class Box<E> {
    private E element;
    public E getElement() {
        return element;
    }
    public void setElement(E element) {
        this.element = element;
    }
}
public class AppTest {
    public static void main(String[] args) {
    }

    @Test
    public void test02() {

        List<String>  list;
        MyList<String,Integer> ml01 = null;
        MyList<String,Double> ml02 = null;
        MyList<String,String> ml03 = null;
        list = ml01;
        list = ml02;
        list = ml03;
        /**
         * 只要 第一个类型参数 和 父类的一样 那就算继承 .
         * 搞清楚 那些 对象可以 父类指针指向子类引用.
         */

    }

    @Test
    public void test01() {
        //父类指针 可以指向子类引用
        Integer i = 10;
        Number number = i;
        Object o = number;

        //那么下面的是否是继承关系
        Box<Integer> box1 = new Box<>();
        Box<Number> box2 ;
        // box2 = box1; //不可以算继承.❌
        /**
         * 看左边 Box 大家主体上都是 Box 类型,当然不算继承.
         * 1.泛型类型的 类型参数是不存在继承, 条件:如果 类型参数相同的时候 ,类之间是可以看有没有继承关系.
         * 2.如果参数类型不一致 就不能说存在继承.
         */
        //1.条件:如果 类型参数相同的时候 ,类之间是可以看有没有继承关系.
        List<String> listStr = null;
        ArrayList<String> alStr = new ArrayList<>();
        listStr = alStr;  //✅ 可以存在继承关系.

        //2.
        List<Object> list = null;
        ArrayList<String> al = null;
        //list = al //不存在继承关系 ❌
    }
}


/**
 * 如果 父类有泛型类型,子类可以增加自己的泛型类型
 * 比如 List<E>
 *     public interface List<E> extends Collection<E>
 * 增加自己的泛型 N
 */
interface MyList<E , N > extends List<E> { //增加自己的泛型 N
    void setNo(N no);
}




