package mj_java_01.a15_泛型_Generic.c_限制类型参数.b_限制类型参数_示例.c;

public class AppTest {

    public static void main(String[] args) {

        Person[] people = {
                new Person(15),
                new Person(18),
                new Person(19),
                new Person(11),
        };
        //可以比较 哪个人大,
        System.out.println(getMax(people));
    }

    static <T extends Comparable<T>> T getMax(T[] array) {
        if (array == null || array.length == 0) return null;
        T max = array[0];
        for (int i = 1; i < array.length; i++) {
            /**
              获取最大值的逻辑:
              array[i] 大于 max 交换记录下 最大值
              if (array[i] > max) {
                  max = array[i]
              }
             */

            /**
             * array[i] 大于 max 交换记录下 最大值
             * 你认为的最大? 为什么
             *  if (array[i] - max > 0 ) { // 条件满足就交换  array[i] 大 求出了最大
             *       max = array[i]
             *   }
             *  if ( max - array[i] > 0 ) { // 条件满足就交换  array[i] 小 求出了最小的.
             *       max = array[i]
             *   }
             *   所以最终把这个条件的方法 谁减去谁的这个不分 抽象出来一个 接口,
             *   可以外部传入 匿名对象 . 调用匿名类对象的 o1.compareTo(o2) 方法.
             *   具体方法内部 :
             *   是 array[i] - max > 0    求出最大
             *   是 max - array[i] > 0    求出最小.
             */
            // 万一array[i]为null 严谨判断
            if (array[i] == null) continue;
            if (array[i].compareTo(max) > 0) {
                max = array[i];
            }

            /**
             * array[i].compareTo(max) <=  0
             * 理解: max 大于 array[i] 不用换.
             */
            //✅ 也可以写为如下: 代码上少个 {} 简洁.
//            if (array[i].compareTo(max) <=  0) continue;
//            // <= 0 表示:max大.就不用交换.
//            max = array[i];

        }
        return max;
    }
}

class Person implements Comparable<Person> {
    int age;

    public Person(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Person o) {
        if (o == null) return 1; //没什么可比性.只要是大于1 的值就可以. 100 200 都行.


        return age - o.age; //你认为的大 的交换条件
        //return o.age - age; //你认为的大 的交换条件
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                '}';
    }
}
