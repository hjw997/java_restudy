package mj_java_01.a02_基础语法_part02.e_方法签名_重载;

public class b_方法的重载_overload {
    public static void main(String[] args) {
        sumDouble(10, 20, 30);


        /// 调用的 函数签名是:sum(double, double, double)
        double result = sum(10d, 20d, 30d);

        //调用的是 函数签名为 : sum(int, int ,int)
        sum(1, 2, 3);

    }

    /**
     * 什么是方法重载:Overload
     * java的方法支持重载: 方法名相同,方法签名不同:
     * > 参数个数不同
     * > 参数类型不同
     *
     * 重载于返回值类型,参数名称无关
     * 假如我们 要写一个求和 方法 一个接受 double 一个 是int
     * sumDouble 和 sumInt 两个方法.其实大可不必 这样. 直接用函数的重载
     */
    public static double sumDouble(double a, double b, double c) {
        return a + b + c;
    }

    public static int sumInt(int a, int b ,int c) {
        return a + b + c;
    }

    /**
     * ---------使用函数重载:----------
     */
    public static double sum(double a, double b, double c) {
        return a + b + c;
    }
    public static double sum(int e, int f ,int g) {
        return e + f + g;
    }

}
