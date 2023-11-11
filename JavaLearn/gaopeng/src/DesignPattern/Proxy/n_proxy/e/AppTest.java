package DesignPattern.Proxy.n_proxy.e;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * 为了解决 d 包中的问题,将代码的使用封装一下
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

/**
 参数3:调用处理器:InvocationHandler
 */
class MyHandler implements InvocationHandler {

    /**
     * 要代理的目标对象
     */
    private  Object target;

    MyHandler(Object target) {
        this.target = target;
    }

    /** invoke 方法的三个参数是什么呢?
     *  proxy.add(1, 2);
     *  参数1:proxy
     *  参数2:通过反射机制传入 add方法对象
     *  参数3,方法的参数.

     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println(method.getName() + " 开始,参数是: " + Arrays.toString(args));
        //次处是调用 真实对象的 真实方法.✅
        Object result = method.invoke(target, args);

        System.out.println(method.getName() + " 结束,结果是 " + result);
        System.out.println("------------------------------------");
        return result; //这里的返回值 会返回到 代理对象调用处.
    }
}


class MyProxy {
    /**
     * 封装:对外隐藏复杂的实现细节,暴露出简单的使用方法.
     *     封装要有所隐藏,有所暴露.
     * 根据目标对象生成动态的代理对象
     * @param target 是要代理的目标对象
     * @return 返回根据目标对象实现的接口的代理对象.
     */
    public static Object getProxy(Object target) {
        //参数1:类加载器
        ClassLoader classLoader = MyProxy.class.getClassLoader();
        //参数2 就不能写死了 要根据目标对象来获取实现的接口数组.
        //Class[] interfaces = {ICalc.class};
        //参数2:调用API来获取这个类实现的接口. 看 API讲解.
        Class<?>[] interfaces = target.getClass().getInterfaces();

        Object proxy = Proxy.newProxyInstance(classLoader, interfaces, new MyHandler(target));
        return proxy;//返回生成的动态代理对象.

    }
}

//=======================时空线================================

interface Vampire {
    void drinkBlood();
}

class YoungVampire implements Vampire {

    @Override
    public void drinkBlood() {
        System.out.println("我吸!!!!");
    }
}


public class AppTest {
    public static void main(String[] args) {

        //这种 new的叫做真实对象,也叫目标对象.
        ICalc calc = new CalcImpl();
        //生成代理对象:封装后使用简单了✅
        ICalc proxy = (ICalc) MyProxy.getProxy(calc);
        //对代理对象的方法调用,都会统统进入到调用处理器中的invoke方法中.而不会直接进入真实的方法
        proxy.add(1, 2);
        proxy.sub(1, 2);

        ///我想监听吸血鬼什么时候开始吸,什么时候结束
        Vampire vampire = new YoungVampire();
        Vampire proxyVampire = (Vampire) MyProxy.getProxy(vampire);
        //对代理对象的调用,并不会去真实对象方法,而是去 第三个参数 调用处理器的 invoke 方法.
        proxyVampire.drinkBlood();

    }

    @Test
    public void testAPIGetInterfaces() {
        Foo foo = new Foo();
        Class<?>[] interfaces = foo.getClass().getInterfaces();
        System.out.println(Arrays.toString(interfaces));
        // 打印结果 : [interface dp.n_proxy.e.A] 实现A接口
    }
}

/**
 * API 讲解 : target.getClass().getInterfaces();
 */
interface A {
    void f1();
    void f2();
}
class Foo implements A {

    @Override
    public void f1() {

    }

    @Override
    public void f2() {

    }
}


/**
 * 代理对象要与目标对象要有相同的接口方法.
 *
 * 目前看起来挺好,但是任然有问题.
 * 1.目前我们创建的代理对象,只能在真实对象的真实方法调用前后,加上日志,无法加其他功能!!!
 * 比如:用户不想加日志功能,而是想加缓存功能,或者加权限控制,或者延迟加载...等等. 现在是写死的
 * 看 g包.

 */

