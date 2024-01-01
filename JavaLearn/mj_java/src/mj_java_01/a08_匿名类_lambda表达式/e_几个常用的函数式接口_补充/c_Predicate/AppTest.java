package mj_java_01.a08_匿名类_lambda表达式.e_几个常用的函数式接口_补充.c_Predicate;

import org.junit.Test;

import java.util.function.Predicate;

/**
 * Predicate 可做过滤条件;
 * test就是一个过滤条件
 * and : 就是且
 * or : 就是 或者
 * negate: 就是test()的取反.
 */
public class AppTest {


    @Test
    public void test01() {

        int[] nums = {11, 22, 33, 44, 55, 66, 77, 88, 99};
        //1.拼接偶数 用 _ 拼接
        String join1 = join(nums, new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return (integer & 1) == 0; //二进制最后一位 是 0 就是 偶数.
            }
        });
        System.out.println(join1);

        //int[] nums1 = {11, 22, 33, 44, 66, 55, 77, 88, 99};
        int[] nums1 = {11, 22, 33, 44 , 55, 77, 88, 99};
        //2.是偶数,并且能被3整除,那就是能被3整除的偶数 过滤条件.
        String joinAnd = joinAnd(nums1, new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return (integer & 1) == 0; //是偶数
            }
        }, new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return (integer % 3) == 0; //能被 3 整除
            }
        });
        System.out.println(joinAnd);

    }

    @Test
    public void test02() {
        int[] nums = {11, 22, 33, 44, 55, 66, 77, 88, 99};
        String joinOr = joinOr(nums, new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return (integer & 1) == 0; //偶数
            }
        }, new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer % 3 == 0;
            }
        });
        System.out.println(joinOr);
    }

    @Test
    public void test03() {
        int[] nums = {11, 22, 33, 44, 55, 66, 77, 88, 99};
        String joinNegate = joinNegate(nums, new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return (integer & 1) == 0; //取偶数 -- 内部 joinNegate 取反了
            }
        });
        //11_33_55_77_99
        System.out.println(joinNegate);
    }


    /**
     * Predict 的 test 作用:就是过滤
     * 把偶数的 数字 22_44_66 这样 拼接起来
     */
    static String join(int[] nums, Predicate<Integer> p) {
        if (nums == null || p == null) return null;
        StringBuilder sb = new StringBuilder();
        boolean isOnceTest = false;
        for (int num : nums) {
            //test 作用:就是过滤
            if (p.test(num)) {
                sb.append(num).append("_");
                isOnceTest = true;
            }
        }
        //把 最后一个拼接的 _ 删掉.✅ PS 如果最后一次没有这个会奔溃.要加判断条件
        if (isOnceTest) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }


    /**
     * Predicate - and :  同时 满足
     * @param nums
     * @param p1
     * @param p2
     * @return
     */
    static String joinAnd(int[] nums, Predicate<Integer> p1,  Predicate<Integer> p2) {
        if (nums == null || p1 == null || p2 == null) return null;
        StringBuilder sb = new StringBuilder();
        boolean isOnceTest = false;
        for (int num : nums) {
            // p1.and(p2).test(num) 等价与 且 ==== p1.test(n) && p2.test(n)
            if (p1.and(p2).test(num)) {
                sb.append(num).append("_");
                isOnceTest = true;
            }
        }
        //把 最后一个拼接的 _ 删掉.✅
        if (isOnceTest) {
            sb.deleteCharAt(sb.length() - 1);
        }

        return sb.toString();
    }

    static String joinOr(int[] nums, Predicate<Integer> p1,  Predicate<Integer> p2) {
        if (nums == null || p1 == null || p2 == null) return null;
        StringBuilder sb = new StringBuilder();
        boolean isOnceTest = false;
        for (int num : nums) {
            // p1.or(p2).test(num) 等价与 或 ==== p1.test(n) ||  p2.test(n)
            if (p1.or(p2).test(num)) {
                sb.append(num).append("_");
                isOnceTest = true;
            }
        }
        //把 最后一个拼接的 _ 删掉.✅
        if (isOnceTest) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    /**
     * Predicate - negate() 方法: 对 test取反.
     * @param nums
     * @param p
     * @return
     */
    static String joinNegate(int[] nums, Predicate<Integer> p) {
        if (nums == null || p == null) return null;
        StringBuilder sb = new StringBuilder();
        boolean isOnceTest = false;
        for (int num : nums) {
            //negate 是对 test的取反.
            if (p.negate().test(num)) {
                sb.append(num).append("_");
                isOnceTest = true;
            }
        }
        //把 最后一个拼接的 _ 删掉.✅ PS 如果最后一次没有这个会奔溃.要加判断条件
        if (isOnceTest) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

}
