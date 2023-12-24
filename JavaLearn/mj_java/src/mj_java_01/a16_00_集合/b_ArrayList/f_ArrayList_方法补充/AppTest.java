package mj_java_01.a16_00_集合.b_ArrayList.f_ArrayList_方法补充;

import org.junit.Test;

import java.util.ArrayList;

public class AppTest {

    /**
     * trimToSize : 缩容
     * trim: 修剪 的意思.
     */
    @Test
    public void test01() {
        ArrayList<Integer> list = new ArrayList<>();
        //一下子装了 1万个元素.
        for (int i = 0; i < 10000; i++) {
            list.add(i);
        }

        //clear 内部是把所有元素置为了null,可查看源码.
        list.clear();

        //此时 如果我只用了 10个元素的空间.那么 剩下的 9千多个是多余的.
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        //此时可以优化为 和 list 的 size一样大的内存空间

        //有一段内存 暂时不用了
        //缩容--和扩容反过来. 新分配一段小点的内存,把占用大的释放回收了.
        list.trimToSize();
    }

    @Test
    public void test02() {
        /**
         * 我们都知道 ArrayList 初始的 容量是10 ,
         * 在 add 过程中如果 容量不够了,会不断地 扩容为 原来的 1.5倍.
         */
        ArrayList<Integer> list = new ArrayList<>();
        /**
         * 一下子装了 1万个元素.
         * 假设我们就知道未来 会用到多少的容量.
         * 可以优化点就是 : 不要不断地 分配空间,拷贝内容的.
         * 而是我们提前 预知 要多少,就直接给来个 多大的.
         * 我们预知 要一万个直接在构造的时候 来个 容量大小.
         */
        ArrayList<Integer> list1 = new ArrayList<>(10000);

        for (int i = 0; i < 10000; i++) {
            list.add(i);
        }

        /**
         *  或者我们再过一段时间的时候 大概知道用多少容量.
         *  在原来的基础上我还要 1000个.可以直接一次分配好.再去添加.节省了 add的时候扩容的开销.
         *  这样可以确保 一次 扩容. 提前扩容.--可做性能优化.
         */
        list.ensureCapacity(list.size() + 1000);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            list.add(i); //此处不会在不够用的时候不断地去扩容了. 节省开销 ---✅
        }

    }
}
