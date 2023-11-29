package mj_java_01.a02_基础语法_part02.e_方法签名_重载;

public class a_方法签名_method_signature {
    public static void main(String[] args) {

    }

    /**
     * 方法签名:
     * 组成 由2 不分组成: 方法名 ,参数类型
     */
    public static void test01() {
        /**
         * 如下方法:签名是:
         * sum(int, long, double)
         * 📢注意:方法签名 不包括返回值 和 修饰符, 还有 参数名称.
         * 只看 函数右边部分 也不看 函数参数名.
         */
        sum(10, 20, 30);
    }

    public static double sum(int i, long l, double d) {
        return i + l + d;
    }

    /**
     *  在同一个类中,不能定义 2 个 方法签名一样的方法.
     *  如下就是 方法签名 重名了.所以会拨错
     *  方法签名不包含 返回值 参数名称.
     */
//    private void sum(int a, long b, double c) {
//        return a + b + c;
//    }
}
