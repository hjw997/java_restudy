package mj_java_01.a08_匿名类_lambda表达式.b_匿名类用途.util;

/**
 * JDK 中的工具类一般 使用 s结尾  比如Times Utils 等. 建议模仿
 */
public class Times {
    public interface Block { //这个接口如果不是public 的只能当前包中使用,包外是用不了的.
        void execute();
    }

    /**
     * 计算一段代码的执行时间:
     * @param code 要执行的代码块. 就是传入一个匿名类对象
     */
    //public static void test(传入一段代码进来) {
    public static void test(Block code) {
        System.out.println("开始执行........");
        long begin = System.currentTimeMillis();
        code.execute();
        long end = System.currentTimeMillis();
        //毫秒 / 1000   -> 秒
        double result = (end - begin) / 1000.0;
        System.out.println("执行结束");
        System.out.println("耗时:" + result + "s");
    }
}
