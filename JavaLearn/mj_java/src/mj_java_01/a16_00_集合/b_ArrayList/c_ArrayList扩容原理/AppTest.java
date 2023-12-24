package mj_java_01.a16_00_集合.b_ArrayList.c_ArrayList扩容原理;

import java.util.ArrayList;

public class AppTest {
    public static void main(String[] args) {
        ArrayList list = null;
        //list.add()
        /**
         * 内部有个  transient Object[] elementData;
         * 数组 Object[] elementData就是用来存储元素的.
         * 起初 容量是 10 , 不够了 再申请新的空间是原来的1.5倍
         * 然后再把 旧的里面的拷贝过去.
         private void grow(int minCapacity) {
             // overflow-conscious code
             int oldCapacity = elementData.length;
            // oldCapacity >> 1 右移一位 就是除 2 . 所以就是 1 + 0.5 = 1.5
             int newCapacity = oldCapacity + (oldCapacity >> 1);
             if (newCapacity - minCapacity < 0)
             newCapacity = minCapacity;
             if (newCapacity - MAX_ARRAY_SIZE > 0)
             newCapacity = hugeCapacity(minCapacity);
             // minCapacity is usually close to size, so this is a win:
             elementData = Arrays.copyOf(elementData, newCapacity);
         }

         */
    }
}
