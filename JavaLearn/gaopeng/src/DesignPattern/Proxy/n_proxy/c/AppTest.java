package DesignPattern.Proxy.n_proxy.c;

/**
 * 为了解决 b 包中的问题,修改如下:
 */
interface ICalc {
    int add(int a, int b); //加
    int sub(int a, int b); //减
    int mul(int a, int b); //乘
    int div(int a, int b); //除
}

class CalcImpl implements ICalc {

    @Override
    public int add(int a, int b) {
        int r = a + b;
        return r ;
    }

    @Override
    public int sub(int a, int b) {
        int r = a - b ;
        return r;
    }

    @Override
    public int mul(int a, int b) {
        int r = a * b;
        return r;
    }

    @Override
    public int div(int a, int b) {
        int r = a / b;
        return r;
    }
}

//=======================时空线================================

class MyCalcImpl extends CalcImpl {

    @Override
    public int add(int a, int b) {
        System.out.println("add方法开始~ 参数是:" + a +" , " + b);
        int r = super.add(a,b);
        System.out.println("add方法结束!!");
        return r ;
    }

    @Override
    public int sub(int a, int b) {
        System.out.println("sub方法开始~ 参数是:" + a +" , " + b);
        int r = super.sub(a,b) ;
        System.out.println("sub方法结束!!");
        return r;
    }

    @Override
    public int mul(int a, int b) {
        System.out.println("mul方法开始~ 参数是:" + a +" , " + b);
        int r = super.mul(a,b);
        System.out.println("mul方法结束!!");
        return r;
    }

    @Override
    public int div(int a, int b) {
        System.out.println("div方法开始~~ 参数是:" + a +" , " + b);
        int r = super.div(a,b);
        System.out.println("div方法结束!!");
        return r;
    }
}



public class AppTest {
    public static void main(String[] args) {
        ICalc calc = new MyCalcImpl();
        calc.add(1, 2);
        calc.sub(1, 2);
        calc.mul(4, 7);
        calc.div(10, 4);
    }
}
/**
    这个写法目前符合了开闭原则,毕竟我们没有修作者的代码.
    缺点:
    需求再变:还是要改动每个方法(改动面大),比如 1.3.5 中文,2,4,6 英文.
    请看d包
 */
