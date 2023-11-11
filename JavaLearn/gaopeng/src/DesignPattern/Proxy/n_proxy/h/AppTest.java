package DesignPattern.Proxy.n_proxy.h;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * 为了解决 g 包中的问题 无法在拦截器中获取到 Method 和  参数等 重构代码如下:
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

/**
 * 用户制作拦截器: 其实就是策略模式.
 * 现在的拦截器就可以拿到 具体参数等.
 */
class LogInterceptor implements Interceptor {
    //add 方法使用英文日志,sub方法使用中文日志.mul方法不要日志,div要日文日志.
    @Override
    public void before(Method method, Object[] args) {
        String name = method.getName();
        if ("add".equals(name)) {
            System.out.println(method.getName() + "begin, params are : " + Arrays.toString(args));
        } else if ("sub".equals(name)) {
            System.out.println(method.getName() + "开始 , 参数是: " + Arrays.toString(args));
        } else if ("mul".equals(name)) {
           //不要日志
        } else if ("div".equals(name)) {
            System.out.println(method.getName() + ": ファだ" + Arrays.toString(args));
        }

    }

    @Override
    public void after(Method method, Object result) {
        String name = method.getName();

        if ("add".equals(name)) {
            System.out.println(method.getName() + "end, results is : " + result);
        } else if ("sub".equals(name)) {
            System.out.println(method.getName() + "结束 ,结果是: " + result);
        } else if ("mul".equals(name)) {
            //不要日志
        } else if ("div".equals(name)) {
            System.out.println(method.getName() + ": ファだ : " + result);
        }
    }
}

public class AppTest {
    public static void main(String[] args) {

        //这种 new的叫做真实对象,也叫目标对象.
        ICalc calc = new CalcImpl();
        //生成代理对象:封装后使用简单了✅ 把要拦截的具体的内容交给用户传入 匿名类接口实现的.
        ICalc proxy = (ICalc) MyProxy.getProxy(calc, new LogInterceptor());
        //对代理对象的方法调用,都会统统进入到调用处理器中的invoke方法中.而不会直接进入真实的方法
        proxy.add(1, 2);
        proxy.sub(1, 2);

    }
}


/**
 目前,用户能够自己决定目标方法执行前后,也就是前置通知 和  后置通知了,针对与日志功能,也能细化了.
 针对 ICalc这个接口的日志功能,add 方法使用英文日志,sub方法使用中文日志.mul方法不要日志,div要日文日志.
 然后修改 拦截器中 添加各种 if-else 判断代码 , 违反了 单一职责. 下个包 h 中解决问题.
 */

