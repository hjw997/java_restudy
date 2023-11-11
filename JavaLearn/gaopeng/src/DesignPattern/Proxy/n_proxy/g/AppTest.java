package DesignPattern.Proxy.n_proxy.g;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * 为了解决 e 包中的问题,日志功能是死的. 怎么让作者代码活起来
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
        interceptor.before();
        // 此处是调用 真实对象的 真实方法.✅
        Object result = method.invoke(target, args);

        // 后置通知: 由用户决定.
        interceptor.after();

        return result; //这里的返回值 会返回到 代理对象调用处.
    }
}

interface Interceptor {
    void before();

    void after();
}


class MyProxy {
    public static Object getProxy(Object target,Interceptor interceptor) {
        //参数1:类加载器
        ClassLoader classLoader = MyProxy.class.getClassLoader();
        //参数2 就不能写死了 要根据目标对象来获取实现的接口数组.
        //Class[] interfaces = {ICalc.class};
        //参数2:调用API来获取这个类实现的接口. 看 API讲解.
        Class<?>[] interfaces = target.getClass().getInterfaces();

        Object proxy = Proxy.newProxyInstance(classLoader, interfaces, new MyHandler(target,interceptor));
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

/**
 * 用户制作拦截器: 其实就是策略模式.
 */
class AInterceptor implements Interceptor {
    @Override
    public void before() {
        System.out.println("before--111111");
    }

    @Override
    public void after() {
        System.out.println("after--222222");
    }
}

class LogInterceptor implements Interceptor {

    @Override
    public void before() {
        System.out.println("方法开始");
    }

    @Override
    public void after() {
        System.out.println("方法结束");
    }
}

public class AppTest {
    public static void main(String[] args) {

        //这种 new的叫做真实对象,也叫目标对象.
        ICalc calc = new CalcImpl();
        //生成代理对象:封装后使用简单了✅ 把要拦截的具体的内容交给用户传入 匿名类接口实现的.
        ICalc proxy = (ICalc) MyProxy.getProxy(calc, new AInterceptor());
        //对代理对象的方法调用,都会统统进入到调用处理器中的invoke方法中.而不会直接进入真实的方法
        proxy.add(1, 2);
        proxy.sub(1, 2);

        ///我想监听吸血鬼什么时候开始吸,什么时候结束
        Vampire vampire = new YoungVampire();
        Vampire proxyVampire = (Vampire) MyProxy.getProxy(vampire, new Interceptor() {
            @Override
            public void before() {
                System.out.println("before--vampire--111111");
            }

            @Override
            public void after() {
                System.out.println("after --vampire--222222");
            }
        });
        //对代理对象的调用,并不会去真实对象方法,而是去 第三个参数 调用处理器的 invoke 方法.
        proxyVampire.drinkBlood();

    }
}


/**
   上面已经 可以由用户可以自己决定 前置通知 和 后置通知了. 运行时相互替换 策略模式.
   但是,针对日志功能无法细化,毕竟在拦截器中不能访问到 Method 对象. 参数等问题.
   看 k 包
 */

