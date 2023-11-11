package DesignPattern.Proxy.n_proxy.f_supplement_reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 简单回顾一下反射机制
 */

class Person {
    public void eat() {
        System.out.println("我吃");
    }
    public void eat(String food) {
        System.out.println("我吃: " + food);
    }

}
public class AppTest {
    public static void main(String[] args) throws ClassNotFoundException,
            InstantiationException, IllegalAccessException,
            NoSuchMethodException, InvocationTargetException {

        //利用反射机制调用类的方法:

        /**
         * 1.获取类的字节码:字节码是根据源代码生成的,所以源代码中的信息,字节码中也有!.(泛型擦出也会记住到某个地方)
         */

        Class<?> clazz = Class.forName("dp.n_proxy.f_supplement_reflect.Person");

        /**
         * 2.利用反射机制创建一个对象,以下api,就是利用反射机制,调用类的无参构造器来实例化对象的!
         */
        Object obj = clazz.newInstance();
        System.out.println(obj); //.Person@6d6f6e28真是对象是Person对象

        /**
         * 3.反射出字节码中的某个方法:
         */
        Method m = clazz.getDeclaredMethod("eat");

        /**
         * 4.利用反射机制调用方法
         * 怎么理解:✅✅✅✅✅✅✅✅✅✅✅✅✅
         * 把m所代表的方法,当做 obj 对象的方法来调用.
         * 也就是 把 eat方法,当做obj对象的方法来调用.
         */
        m.invoke(obj);

        //反射参数方法 eat(food) ,第二个参数就传什么类型的字节码.
        Method eatFood =clazz.getDeclaredMethod("eat", String.class);
        eatFood.invoke(obj, "苹果");

        //天下大事必做于细,天下难事必作于易 有些点不理解.就去搞明白.
    }
}
