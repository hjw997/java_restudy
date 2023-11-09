package DesignPattern.Proxy.n_proxy.a;

interface ICalc {
    int add(int a, int b); //加
    int sub(int a, int b); //减
    int mul(int a, int b); //乘
    int div(int a, int b); //除
}

class CalcImpl implements ICalc {

    @Override
    public int add(int a, int b) {
        return a + b ;
    }

    @Override
    public int sub(int a, int b) {
        return a - b ;
    }

    @Override
    public int mul(int a, int b) {
        return a * b ;
    }

    @Override
    public int div(int a, int b) {
        return a / b;
    }
}


public class AppTest {
    public static void main(String[] args) {
        ICalc calc = new CalcImpl();
        System.out.println(calc.add(1, 2));
        System.out.println(calc.sub(1, 2));
        System.out.println(calc.mul(4, 7));
        System.out.println(calc.div(10, 4));
    }
}
/**
 * 变化来了:
 * 客户现在有个需求,往ICalc接口中的每个方法中增加一个日志,记录方法 开始 和 结束 的时机
 *
 */
