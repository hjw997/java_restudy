package mj_java_01.a08_匿名类_lambda表达式.e_几个常用的函数式接口_补充.b_Consumer;

import org.junit.Test;

import java.util.function.Consumer;

public class AppTest {
    public static void main(String[] args) {

    }

    @Test
    public void test01() {
        int[] nums = {11, 22, 33};

        //比如说 做的事情 每次不一样. 每次类似这样的 重复代码做个封装.
        for (int i = 0; i < nums.length; i++) {
            System.out.println(i);
        }

        for (int i = 0; i < nums.length; i++) {
            System.out.println(i + 100);
        }
    }

    /**
     * 使用 Consumer
     */
    @Test
    public void test02() {
        int[] nums = {11, 22, 33};

        forEach(nums, new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                // 要做的事
                System.out.println(integer);
            }
        });

        /****************做不同的事********************/

        forEach(nums, new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer + 100);
            }
        });

    }

    /**
     * 简化 test02 方法中的 lambda
     */
    @Test
    public void test03() {
        int[] nums = {11, 22, 33};

        // lambda 简化
        forEach(nums, integer -> {
            // 要做的事
            System.out.println(integer);
        });

        //lambda 是个方法调用 : 使用方法引用
        forEach(nums, System.out::println);

        /****************做不同的事********************/

        forEach(nums, new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer + 100);
            }
        });
        forEach(nums, integer -> System.out.println(integer + 100));

    }

    @Test
    public void test04() {
        //Consumer
        //int[] nums = {11, 22, 33};
        Integer[] nums = {11, 22, 33};
        //使用泛型的方法, 泛型不支持基本数据类型的 int[] 改为 Integer[]
        //调用 泛型方法:
        forEach(nums, new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer + 10);
            }
        });
    }

    /**
     * Consumer-andThen
     */
    @Test
    public void test05() {
        Integer[] nums = {11, 22, 33};
        forEach(nums, new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println("consumer-1 " + integer);
            }
        }, new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println("consumer-2 " + integer);
            }
        });
    }

    static void forEach(int[] nums, Consumer<Integer> consumer) {
        if (nums == null || consumer == null) return;
        for (int num : nums) {
            consumer.accept(num);
        }
    }

    //通用的泛型:
    static <T> void forEach(T[] array, Consumer<T> consumer) {
        if (array == null || consumer == null) return;
        for (T t : array) {
            consumer.accept(t);
        }
    }

    static <T> void forEach(T[] array, Consumer<T> consumer1 , Consumer<T> consumer2) {
        if (array == null || consumer1 == null || consumer2 == null) return;
        for (T t : array) {
            // Consumer<T> tConsumer = consumer1.andThen(consumer2);
            // tConsumer.accept(t);
            /**
             * consumer1 拿着 accept(t) 做事
             * 然后 :
             * consumer2 拿着  accept(t) 的 t 做事.
             * 函数式编程的思想>
             */
            consumer1.andThen(consumer2).accept(t);
        }
    }
}
