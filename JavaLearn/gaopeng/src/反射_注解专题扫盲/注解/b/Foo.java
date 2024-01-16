package 反射_注解专题扫盲.注解.b;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 注解也是一种特殊的类.
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.TYPE}) //类和字段上使用.
public @interface Foo {

    /**
     * 定义注解的属性  ps 方法的外观 ,其实是属性
     */
//    String name();
//    int age();

    /**
     * 上面的写法 :注解的属性默认 没有默认值
     */

    //下面就是给默认值
    String name() default "成龙";
    int age() default 0;

    //注解没有方法.
}

@Foo(name ="my_name",age = 10) //给注解默认值.
class Car {
    @Foo(name = "字段", age = 22)
    double price;
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Bar{
    String value();
    int age() default 100;
}

@Bar("abc") //属性为value的时候,且只使用了value一个属性的时候,value属性名可可以省略.
class Dog {

}

