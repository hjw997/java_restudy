package 反射_注解专题扫盲.注解.d_注解的提取;


//能吃能睡的标签 哈哈

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Eat {
    //只有一个属性 且名字 叫做 value ,使用的时候 value 可以省略
    String value();

    //如果value是数组也是可以的. 赋值的时候 就要数组形式
    //String[] value();
}
