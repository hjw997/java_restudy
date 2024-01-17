package 反射_注解专题扫盲.反射.a;


import org.junit.Test;

/**
 *
 * Class 是所有字节码形成的类类型.
 */
public class AppTest {
    public static void main(String[] args)  {

    }

    /**
     * 获取类的字节码:
     */
    @Test
    public void test01() throws Exception {

        //获取字节码 因为小写的class是关键字 ,所以业内喜欢起名叫 clazz  clz  cls 等.
        // Class clazz = Person.class; //获取字节码方式1 ,会有类的加载,但是不会引起类的静态代码块执行 ⚠️

        //回引起类的加载 和 静态代码块的执行.✅
        //Class aClass = new Person().getClass(); //获取字节码方式2
        Class<?> cls = Class.forName("反射_注解专题扫盲.反射.a.Person"); //获取字节码方式3 推荐✅
    }

}
