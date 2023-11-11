package DesignPattern.Proxy.n_proxy.d;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * 为了解决 c 包中的问题,我们必须学习一个 jdk 中的 api: 动态代理.
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


public class AppTest {
    public static void main(String[] args) {
        /** 动态代理:这个视频的16分钟开始:
         https://www.bilibili.com/video/BV1Qx411o7tN?p=38&spm_id_from=pageDriver&vd_source=b386945edbef32fc1df7d8a419f8de78
         */

        /**
         * 如何创建一个动态代理:
         * Proxy.newProxyInstance() 需要几个参数:
         * 1.ClassLoader loader, 类加载器
         * 2.Class<?>[] interfaces, 字节码数组.
         * 3.InvocationHandler h
      参数1:类加载器: 通过当前类的字节码:获取到加载这个类的字节码的类加载器.
         * 为何要获取类加载器:我们知道要实例化一个对象,就必须调用类的构造器,
         * 在构造器调用之前,jvm 就会加载该类的字节码!
         * jvm 恰恰就是用 "类加载器" 来加载类的字节码的. 这一步是jvm自动完成的.
         * 以下代码是动态创建一个代理对象的代码,可以说是一种不太正常的创建对象的方式,就算不正常,毕竟也是要创建对象的嘛~.
         * 但凡创建对象,势必要加载字节码,势必就要使用类的类加载器,
         * 和构造器实例化不同的是:使用构造器实例化对象时,jvm会自动找到类的加载器,而以下代码,必须我们手动传入类的加载器.
         *
      参数2: 2.Class<?>[] interfaces, 字节码数组.
         我们都知道,要创建一个类的对象,必须要先加载类的字节码,那么动态代理也不例外,所以我们才传入第一个参数:类加载器!
         问题是:这个传入的类加载器,加载的是哪个类的字节码??
         对比:
         我们平时使用 new 构造器 的方式创建对象:
         new String();      jvm 就会加载String.class
         new Date();        jvm 就会加载Date.class
         new ArrayList();   jvm 就会加载ArrayList.class
         通过 new XXX() 是能明确知道要加载那个类的字节码的.
         使用动态代理api创建对象时,加载哪个字节码呢? - 看JVM图解释 和 反编译查看字节码里是什么?
         静态获得字节码:源码-编译-生成字节码.
         动态:
         如果现在用动态代理方式创建,那么要加载的字节码在哪里么? 就是通过第二个参数传入.
         使用动态代理api创建对象时加载的字节码就会在运行期动态生成的字节码,这动态生成的字节码是不需要源代码的.
         问题是:字节码确实可以自动生成,那么动态代理api动态生成的字节码的内容,是根据什么生成呢?
         这恰恰就是根据第二个参数生成的!!字节码数组.
         动态代理,会生成一个实现了目标接口的类的字节码,在本例中,就是生成一个实现了ICalc接口的类 的字节码!

         PS:反射是在运行期根据字节码文件 来反推出类的 字段属性 方法,构造器 等等. 通过反编译字节码可以看出类结构信息.

     参数3:调用处理器,InvocationHandler
         我们已经知道,动态代理会加载自己动态生成的字节码,且这个字节码是根据某个接口生成的,
         在本例中就是根据ICalc接口生成的实现了ICalc接口的类的字节码.
         问题是:实现了一个接口,就要实现其中的抽象方法,那么动态代理生成的字节码,实现了ICalc接口,势必就要实现其中的 add sub mul div 方法!
         这些方法被实现的方法体都是什么内容呢? 这恰恰是由第3个参数决定的.MyHandler 类的 invoke 就是方法体的内容,可以这样理解:
         伪代码大致如下:
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
         }

         */

        //这种new的叫做真实对象,也叫目标对象.
        ICalc calc = new CalcImpl();

        //参数1:
        ClassLoader classLoader = AppTest.class.getClassLoader();

        //参数2:要生成字节码的依据.
        Class[] interfaces = {ICalc.class};
        // 其实也是:目标对象实现的接口 :可以调用API  目标对象.getClass().getInterfaces()
        Class<?>[] interfaces1 = calc.getClass().getInterfaces();

        // 参数3 决定生成的代理对象的方法体.伪代码如下 class 我是动态生成的那个类 ...

        //生成代理对象: 为什么能转成 ICalc 接口对象? 因为我们代理是根据 第二个参数目标对象实现的接口 来生成代理对象.
        ICalc  proxy = (ICalc) Proxy.newProxyInstance(classLoader, interfaces, new MyHandler(calc));
        //对代理对象的方法调用,都会统统进入到调用处理器中的invoke方法中.而不会直接进入真实的方法
        proxy.add(1, 2);
        proxy.sub(1, 2);
        proxy.mul(2, 2);
        proxy.div(100, 25);

    }
}
/**
参数3
 */
class MyHandler implements InvocationHandler {

    private  ICalc target;

    MyHandler(ICalc target) {
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

        // testParameterFunction(proxy,method,args);

        System.out.println(method.getName() + " 方法开始,参数是: " + Arrays.toString(args));
        /// 这里才是真实的调用了真实对象的业务方法:
        // 利用反射机制,调用真实的方法!!!
        // 把method所代表的方法,当做是 calc是真实对象的方法调用,参数是args.
        // ps:参数proxy❌ 在这里没用,真实对象是需要外面传入的 所以需要在构造器中传入保存住.真实的业务逻辑在 真实对象的 加减乘除中的.
        Object result = method.invoke(target, args);

        System.out.println(method.getName() + " 方法结束,结果是 " + result);

        //PS:这里的返回值要和 接口中的方法返回一致,
        return result; //这里的返回值 会返回到 代理对象调用处.
    }

    /**
     * 测试 invoke 参数的作用的.
     */
    private void testParameterFunction(Object proxy, Method method, Object[] args) {
        System.out.println("MyHandler 呵呵呵🙂");
        String name = method.getName();
        System.out.println("方法名: " + name + " 参数: " + Arrays.toString(args));
    }
}

/**
 * 优点:
 * 克服了上个包中缺点.
 * 需求变更 只需要该一个地方,比如英文写日志. 135中文 246 英文 配合策略模式 很好改动.
 *
 * 缺点:
 * 使用复杂! 我们最好把这个代码封装下,对使用者更友好.看 e 包封装
 *
 */
