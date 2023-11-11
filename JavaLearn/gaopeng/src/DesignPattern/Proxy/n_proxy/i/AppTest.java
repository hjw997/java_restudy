package DesignPattern.Proxy.n_proxy.i;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * 为了解决 h 包中的问题
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

//减发的拦截器
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



public class AppTest {
    public static void main(String[] args) {

        //这种 new的叫做真实对象,也叫目标对象.
        ICalc calc = new CalcImpl();

        //根据目标对象calc ,动态生成一个代理对象
        ICalc proxy = (ICalc) MyProxy.getProxy(calc, new AddInterceptor());

        //我们把 proxy这个代理对象,再当做一个新的目标对象.代理对象套 代理对象 看图解:
        ICalc proxy2 = (ICalc) MyProxy.getProxy(proxy, new SubInterceptor());
        proxy2.add(1, 2);

    }
}

/**
  目前代码问题是:添加拦截器的顺序是逆向的(先当做代理的后调用) ,对用户不友好 看 j包
 */

