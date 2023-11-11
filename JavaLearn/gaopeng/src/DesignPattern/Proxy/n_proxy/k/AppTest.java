package DesignPattern.Proxy.n_proxy.k;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 * 为了解决 j 包中的问题 , 打印顺序是反的问题.
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
        /**
         class 我是动态生成的那个类 implements ICalc {
             InvocationHandler handler = 创建时第三个参数传给它.
             //接口中的方法体大致是如下:
             add() {
               handler.invoke();
             }
             sub() {
               handler.invoke();
             }
             mul() {
               handler.invoke();
             }
             div() {
                handler.invoke();
             }
            //所以 proxy 方法调用最终都会到 调用处理器的 invoke 方法.
         }
         */
        return proxy;//返回生成的动态代理对象.

    }

    public static Object getProxyWithInterceptorList(Object target, List<Interceptor> interceptors) {
        for (int i = interceptors.size()-1; i >= 0; i--) {
            Interceptor interceptor = interceptors.get(i);
            target =  MyProxy.getProxy(target, interceptor);
        }
        return target;//返回最终包装过得代理拦截器链对象
    }

    /**
     * 通过 配置文件(interceptorsConf.properties) 来获取拦截器
     * @param target 代理的目标对象
     * @return 返回最终的代理对象
     */
    public static Object getProxyWithDefaultConfig(Object target)
            throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {

        //读取配置新建一个 interceptorsConf.properties
        Properties interceptorsConf = new Properties();
        //放入一个 input stream 任何能产生数据的东西叫 流
        InputStream resourceAsStream = MyProxy.class.getResourceAsStream("interceptorsConf.properties");
        //从流中读取:
        interceptorsConf.load(resourceAsStream);
        String propertyStr = interceptorsConf.getProperty("interceptors");//文件中写的key,读取到一串字符.
        //然后再 已 逗号分割出 每个拦截器类名
        String[] strings = propertyStr.split(",");
        List<Interceptor> interceptorList = new ArrayList<>();
        //然后遍历 通过反射机制: 通过类名生成 拦截器对象 ,装到拦截器的数组
        for (String interceptorName : strings) {
            Class<?> aClazz = Class.forName(interceptorName);
            Interceptor newInstance = (Interceptor) aClazz.newInstance();
            interceptorList.add(newInstance);
        }

        target = MyProxy.getProxyWithInterceptorList(target, interceptorList);

        return target; //返回最终包装过得代理拦截器链对象
    }
}

//=======================时空线================================

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

    /**
     * 01.代码演变:数组里装上拦截器.
     */
    @Test
    public void test01() {
        //最原始目标对象
        ICalc calc = new CalcImpl();
        /** 为了解决上个包中,打印顺序是反的问题 我们用个List把拦截器先装起来,然后倒序遍历来生成拦截器链
         CCCCCCCCCCCCCCC开始
         BBBBBBBBBBBBBBBB开始
         AAAAAAAAAAAAAAA开始
         真实对象的 CalcImpl_add方法被调用
         AAAAAAAAAAAAAAA结束
         BBBBBBBBBBBBBBBB结束
         CCCCCCCCCCCCCCC结束
         */

        /**
         * PS:这些知识点其实也是SpringMVC 底层的大致原理. 开发中用不到.但是对于理解原理很有帮助
         * 还有在面试中喷的
         */
        List<Interceptor> interceptors = new ArrayList<>();
        interceptors.add(new A());
        interceptors.add(new B());
        interceptors.add(new C());
        for (int i = 0; i < interceptors.size(); i++) {
            Interceptor interceptor = interceptors.get(i);
            /**注意这里
             * 刚开始第一次的时候calc是目标对象,包完一层代理后 , 再当做下一个的目标对象.以此类推.
             * 实现的效果其实就是如下:
             *        ICalc proxy1 = (ICalc) MyProxy.getProxy(calc, new A());
             *         //把上一个代理对象再当做一个新的目标对象.生成 B 代理
             *         ICalc proxy2 = (ICalc) MyProxy.getProxy(proxy1, new B());
             *         //再包proxy2当做目标对象 生成C拦截器
             *         ICalc proxy3 = (ICalc) MyProxy.getProxy(proxy2, new C());
             */
            calc = (ICalc) MyProxy.getProxy(calc, interceptor);
        }
        //最终包出一个代理对象.
        calc.add(1, 2);
        /**
         * 现在还未解决上面说的倒序问题: 继续看 test02
         */
    }

    /**
     * 02:test01中未净化的继续:
     */
    @Test
    public void test02() {
        //最原始目标对象
        ICalc calc = new CalcImpl();

        List<Interceptor> interceptors = new ArrayList<>();
        interceptors.add(new A());
        interceptors.add(new B());
        interceptors.add(new C());
        //开始倒序遍历: 其实就是 从 C 开始包 目标对象最终生成代理链条: a( b( c(calc) ))
        for (int i = interceptors.size()-1; i >= 0; i--) {
            Interceptor interceptor = interceptors.get(i);
            calc = (ICalc) MyProxy.getProxy(calc, interceptor);
        }
        //最终包出一个代理对象.
        calc.add(1, 2);
        /** 最终打印结果: 目前相对于 比较 友好了.可以按照 A - B -C 去调用.
         * ❌ 虽然 变为了顺序打印 A B C ,但是代码使用又变为比较复杂.
         *    循环的倒序添加拦截器不应该让用户知道.再次封装 看 test03() 方法
         但是:这种倒序循环的代码不应该 由用户去加. 在 MyProxy 中封装一个方法.看 test02 的用法.
         AAAAAAAAAAAAAAA开始
         BBBBBBBBBBBBBBBB开始
         CCCCCCCCCCCCCCC开始
         真实对象的 CalcImpl_add方法被调用
         CCCCCCCCCCCCCCC结束
         BBBBBBBBBBBBBBBB结束
         AAAAAAAAAAAAAAA结束

         */
    }
    @Test
    public void test03() {
        //最原始目标对象
        ICalc calc = new CalcImpl();

        List<Interceptor> interceptors = new ArrayList<>();
        interceptors.add(new A());
        interceptors.add(new B());
        interceptors.add(new C());

        /**
         * 倒序循环封装以后,得使用更加简单:
         */
        ICalc proxy = (ICalc) MyProxy.getProxyWithInterceptorList(calc, interceptors);
        proxy.add(1, 2);

        /**
         * 目前代码问题是: ❌ 在test03中:以后要添加拦截器,删除拦截器,势必要修改拦截器数组的 代码.
         * 我们平时使用的框架中都是通过读取配置文件来读取拦截器的.
         * 那么下面就来用一个配置文件来读取拦截器配置 看 test04()
         *
         */

    }

    @Test
    public void test04() throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        //最原始目标对象
        ICalc calc = new CalcImpl();

        //读取配置新建一个 interceptorsConf.properties
        Properties interceptorsConf = new Properties();
        //放入一个 input stream 任何能产生数据的东西叫 流
        InputStream resourceAsStream = MyProxy.class.getResourceAsStream("interceptorsConf.properties");
        //从流中读取:
        interceptorsConf.load(resourceAsStream);
        String propertyStr = interceptorsConf.getProperty("interceptors");//文件中写的key,读取到一串字符.
        //然后再 已 逗号分割出 每个拦截器类名
        String[] strings = propertyStr.split(",");
        List<Interceptor> interceptorList = new ArrayList<>();
        //然后遍历 通过反射机制: 通过类名生成 对象
        for (String interceptorName : strings) {
            Class<?> aClazz = Class.forName(interceptorName);
            Interceptor newInstance = (Interceptor) aClazz.newInstance();
            interceptorList.add(newInstance);
        }

        /** 这段代码就可以通过上面👆🏻的读取 配置文件来做配置.更加灵活.
         List<Interceptor> interceptors = new ArrayList<>();
         interceptors.add(new A());
         interceptors.add(new B());
         interceptors.add(new C());
         */
        /**
         * 倒序循环封装以后,得使用更加简单:
         */
        ICalc proxy = (ICalc) MyProxy.getProxyWithInterceptorList(calc, interceptorList);
        proxy.add(1, 2);

        /**
         * 上面的代码,已经可以灵活配置了,现在就是 读取配置文件的代码也不应该让用户来处理,
         * 可以进一步封装. 将读取配置的也封装起来.这样用户只管去配置,然后传入一个目标对象即可.
         * 看test05() 方法.
         */

    }


    /**
     * 05:进一步封装读取配置文件的代码
     */
    @Test
    public void test05() throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        //最原始目标对象
        ICalc calc = new CalcImpl();
        //读取配置的封装,使用更加简洁,再往后演变就是切面编程了.
        ICalc proxy = (ICalc) MyProxy.getProxyWithDefaultConfig(calc);
        proxy.add(1, 2);
        //看下代理的自己码是啥样?
        System.out.println(proxy.getClass());
        /** 打印结果:
         class dp.n_proxy.k.$Proxy4
         */
    }
}

