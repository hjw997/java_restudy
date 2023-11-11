package DesignPattern.Proxy.n_proxy.j;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * 为了解决 i 包中的问题 , 我们先看 ABC 三个拦截器,test02 测试方法的打印.
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
        System.out.println("真实对象的 CalcImpl_add方法被调用");
        return r ;
    }

    @Override
    public int sub(int a, int b) {
        int r = a - b ;
        System.out.println("真实对象的 CalcImpl_sub方法被调用");
        return r;
    }

    @Override
    public int mul(int a, int b) {
        int r = a * b;
        System.out.println("真实对象的 CalcImpl_mul方法被调用");
        return r;
    }

    @Override
    public int div(int a, int b) {
        int r = a / b;
        System.out.println("真实对象的 CalcImpl_div方法被调用");
        return r;
    }
}

/**
 参数3:调用处理器:InvocationHandler
 */
class MyHandler implements InvocationHandler {
    private  Object target;

    private Interceptor interceptor;

    MyHandler(Object target,Interceptor interceptor) {
        this.interceptor = interceptor;
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        // 前置通知: 由用户决定.
        interceptor.before(method,args);

        // 此处是调用 真实对象的 真实方法.✅
        Object result = method.invoke(target, args);

        // 后置通知: 由用户决定.
        interceptor.after(method,result);

        return result; //这里的返回值 会返回到 代理对象调用处.
    }
}

/**
 * 改动点: 把方法 参数等传入方法中.
 */
interface Interceptor {
    void before(Method method,Object[] args);

    void after(Method method,Object result);
}


class MyProxy {
    public static Object getProxy(Object target,Interceptor interceptor) {
        ClassLoader classLoader = MyProxy.class.getClassLoader();
        Class<?>[] interfaces = target.getClass().getInterfaces();
        Object proxy = Proxy.newProxyInstance(classLoader, interfaces, new MyHandler(target,interceptor));
        return proxy;//返回生成的动态代理对象.

    }
}

//=======================时空线================================

//现在我们针对不同的情况处理定义不同的业务拦截器

/**
 * Add的只做 add相关的处理.
 */
class AddInterceptor implements Interceptor {

    @Override
    public void before(Method method, Object[] args) {
        if ("add".equals(method.getName())) {
            System.out.println(method.getName() + " begin, params are : " + Arrays.toString(args));
        }
    }

    @Override
    public void after(Method method, Object result) {
        if ("add".equals(method.getName())) {
            System.out.println(method.getName() + " end, result is : " + result);
        }
    }
}

//减法的拦截器
class SubInterceptor implements Interceptor {
    @Override
    public void before(Method method, Object[] args) {
        if ("sub".equals(method.getName())) {
            System.out.println(method.getName() + " 开始 , 参数是: " + Arrays.toString(args));
        }
    }

    @Override
    public void after(Method method, Object result) {
        if ("sub".equals(method.getName())) {
            System.out.println(method.getName() + " 结束 , 结果是: " + result);
        }
    }
}

class A implements Interceptor {
    @Override
    public void before(Method method, Object[] args) {
        System.out.println("AAAAAAAAAAAAAAA开始");
    }

    @Override
    public void after(Method method, Object result) {
        System.out.println("AAAAAAAAAAAAAAA结束");
    }
}
class B implements Interceptor {
    @Override
    public void before(Method method, Object[] args) {
        System.out.println("BBBBBBBBBBBBBBBB开始");
    }

    @Override
    public void after(Method method, Object result) {
        System.out.println("BBBBBBBBBBBBBBBB结束");
    }
}
class C implements Interceptor {
    @Override
    public void before(Method method, Object[] args) {
        System.out.println("CCCCCCCCCCCCCCC开始");
    }

    @Override
    public void after(Method method, Object result) {
        System.out.println("CCCCCCCCCCCCCCC结束");
    }
}




public class AppTest {

    /** 02
     * 关于调用顺序问题:
     * A,B C 三个拦截器 看打印
     */
    @Test
    public void test02() {
        //最原始目标对象
        ICalc calc = new CalcImpl();

        ICalc proxy1 = (ICalc) MyProxy.getProxy(calc, new A());
        //把上一个代理对象再当做一个新的目标对象.生成 B 代理
        ICalc proxy2 = (ICalc) MyProxy.getProxy(proxy1, new B());
        //再包proxy2当做目标对象 生成C拦截器
        ICalc proxy3 = (ICalc) MyProxy.getProxy(proxy2, new C());


        proxy3.add(10,10);

        /** 看打印结果,打印顺序是反的.
         CCCCCCCCCCCCCCC开始
         BBBBBBBBBBBBBBBB开始
         AAAAAAAAAAAAAAA开始
         真实对象的 CalcImpl_add方法被调用
         AAAAAAAAAAAAAAA结束
         BBBBBBBBBBBBBBBB结束
         CCCCCCCCCCCCCCC结束
         */
        /**
         * ❌:上面这种对用户还是不友好. 因为调用顺序是反的 用户想 A B C  这样的顺序调用.
         * 看下个包 k.
         */

    }

    /** 01
     * 符合单一职责,每一层代理只做单一功能.
     */
    @Test
    public void test01() {
        //这种 new的叫做真实对象,也叫 目标对象.
        ICalc calc = new CalcImpl();

        //根据目标对象calc ,动态生成一个代理对象 //新问题:如果这里用某一个拦截器,其他拦截器就用不上了. 怎么办? 套.
        ICalc proxy = (ICalc) MyProxy.getProxy(calc, new AddInterceptor());

        //我们把 proxy这个代理对象,再当做一个新的目标对象.代理对象套 代理对象 看图解:
        ICalc proxy2 = (ICalc) MyProxy.getProxy(proxy, new SubInterceptor());
        proxy2.add(1, 2);
        proxy2.sub(10, 2);
        /**
         add begin, params are : [1, 2]
         add end, result is : 3
         sub 开始 , 参数是: [10, 2]
         sub 结束 , 结果是: 8
         */
    }
}

/**
 * 目前代码问题是:
 * ❌ 添加拦截器的顺序是逆向的(添加拦截器的数序是逆向的.先当做代理的后调用) k包
 */

