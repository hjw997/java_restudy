package DesignPattern.Proxy.n_proxy.b;

/**
 * 为了满足 a 包中的需求,修改如下:
 */
interface ICalc {
    int add(int a, int b); //加
    int sub(int a, int b); //减
    int mul(int a, int b); //乘
    int div(int a, int b); //除
}

//最简单粗暴 直接在实现类的每个方法添加 日志:
class CalcImpl implements ICalc {

    @Override
    public int add(int a, int b) {
        System.out.println("add方法开始~ 参数是:" + a +" , " + b);
        int r = a + b;
        System.out.println("add方法结束!!");
        return r ;
    }

    @Override
    public int sub(int a, int b) {
        System.out.println("sub方法开始~ 参数是:" + a +" , " + b);
        int r = a - b ;
        System.out.println("sub方法结束!!");
        return r;
    }

    @Override
    public int mul(int a, int b) {
        System.out.println("mul方法开始~ 参数是:" + a +" , " + b);
        int r = a * b;
        System.out.println("mul方法结束!!");
        return r;
    }

    @Override
    public int div(int a, int b) {
        System.out.println("div方法开始~~ 参数是:" + a +" , " + b);
        int r = a / b;
        System.out.println("div方法结束!!");
        return r;
    }
}


public class AppTest {
    public static void main(String[] args) {
        ICalc calc = new CalcImpl();
        calc.add(1, 2);
        calc.sub(1, 2);
        calc.mul(4, 7);
        calc.div(10, 4);
    }
}
/**
 * 上面的问题:缺点:有很大的缺点:
 * 1. 工作量太大,要为每个方法添加日志功能,
 * 2.如果ICalc 和 CalcImpl 不是我们自己创建的,是被发现的,手头没有源代码, 我们不能直接修改源代码.
 * 3.需求如果在变,比如客户要求我们使用英文写日志.那么修改面也很大. 过了一段时间又改为中文,客户觉得是举手之劳.
 * 
 */
