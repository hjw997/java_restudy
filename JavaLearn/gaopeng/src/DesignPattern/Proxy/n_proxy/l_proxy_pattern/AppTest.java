package DesignPattern.Proxy.n_proxy.l_proxy_pattern;

/**
 * 代理设计模式: 不一定非要使用 jdk 动态代理.
 * 不要把jdk动态代理 等价于 代理模式.
 * 代理模式 是一个设计模式,代码不固定. 动态代理只是代理的一种 jdk api 来实现动态代理.
 * 代理对象与目标对象实现了相同的接口, 代理对象的方法调用会到调用处理器(调用处理器中持有一个目标对象的引用)的invoke 方法.
 */

import org.junit.Test;

/**
 * 图书解析器:
 */
class BookParser {
    //接受一整本书的内容,字符串的值,是很大的!
    private String content = "天下大势,合久必分,分久必合,.....三国归晋";

    public int numberOfSentence() {
        //每次解析,都有很高的执行代价.
        //用睡眠-假装执行了很多逻辑耗时操作
        sleep(1000);
        return content.split("[.!?]").length;
    }

    public int numberOfVerb() { //查动词.
        //用睡眠-假装执行了很多逻辑耗时操作
        sleep(1000);
        return 1980;
    }
    public int numberOfAdverb() { //查副词
        //用睡眠-假装执行了很多逻辑耗时操作
        sleep(2000);
        return 2990;
    }

    //睡两秒.为了好看封装到一个方法.
    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

/**
 * 但是 代理模式的 UML类图上 不是说有相同的接口方法么? 则么办? 继承呗.(管它叫声爹就有了)
 * 目的是为了让 代理对象和 目标对象有 想通的 接口. 管它叫爹.也行.
 * 这种代理模式叫静态代理,自己手写出来的类. 对比 动态代理是在运行的时候动态生成字节码.
 */
class BookParserProxy extends BookParser {

    /**
     * 还有个问题 代理不是有个 目标对象么? 这就是设计模式的变通. 不一定非要给目标,只要接口能一样.
     * 当然还可以 用组合,继承只是为了有相同的方法. -设计模式要灵活.
     */
    private BookParser target; //这里可以可以持有目标对象.看自己灵活引用.

    //3个缓存属性: 不用int 用Integer 可以为null .
    private Integer numberOfSentence;
    private Integer numberOfVerb;
    private Integer numberOfAdverb;

    @Override
    public int numberOfSentence() {
        if (numberOfSentence == null) {
            numberOfSentence = super.numberOfSentence();
        }
        return numberOfSentence;
    }

    @Override
    public int numberOfVerb() {
        if (numberOfVerb == null) {
            numberOfVerb = super.numberOfVerb();
        }
        return numberOfVerb;
    }

    @Override
    public int numberOfAdverb() {
        if (numberOfAdverb == null) {
            numberOfAdverb = super.numberOfAdverb();
        }
        return numberOfAdverb;
    }
}

public class AppTest {

    @Test
    public void test01() {
        BookParser bookParser = new BookParser();
        System.out.println("---------------开始执行-------------------");
        System.out.println("查到副词: " + bookParser.numberOfAdverb());
        System.out.println("查到句子: " + bookParser.numberOfSentence());
        System.out.println("查到动词: " + bookParser.numberOfVerb());
        /**
         * 上面代码的问题所在每次查 副词 , 句子 , 动词 都会耗时很久. 怎么办? 可以用代理. 创建一个 BookParserProxy 类.看 test02 方法
         *
         */
    }

    @Test
    public void test02() {
        BookParser bookParser = new BookParserProxy();
        System.out.println("---------------开始执行1-------------------");
        System.out.println("查到副词: " + bookParser.numberOfAdverb());
        System.out.println("查到句子: " + bookParser.numberOfSentence());
        System.out.println("查到动词: " + bookParser.numberOfVerb());

        System.out.println("---------------开始执行2-------------------");
        //有了缓存就和快了再查询的时候
        System.out.println("查到副词: " + bookParser.numberOfAdverb());
        System.out.println("查到句子: " + bookParser.numberOfSentence());
        System.out.println("查到动词: " + bookParser.numberOfVerb());
        /**
         * 上面通过代理做了一层缓存, 有了缓存以后使用就更高效.这种叫做静态代理.
         *
         */

    }
}

/**
 * 注意点:1.代理对象的字节码 是 $Proxy 这样的.
 *
 * 我们学习的代理模式和之前学习的适配器模式是感觉上是很相似的
 * 毕竟它们是不同的设计模式,有什么区别呢?
 *
 * 1.代理模式中,代理对象和他所包裹的目标对象,必须实现相同的接口; 适配器模式中,适配器包裹的对象不用实现相同的接口 (通过UML类图可以对比出)
 * 2.代理模式中,代理对象可以控制它所包裹的目标对象的方法是否执行! 适配器模式中,适配器总是会调用目标对象的方法!无法控制.
 *
 * HeadFirst中给的说法:看你的意图,你的目的,实现的目标,如果是访问控制就是代理, 一个接口适配另一个接口是适配器模式.
 */
