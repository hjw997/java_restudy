package 反射_注解专题扫盲.注解.d_注解的提取;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 贴了标签 如何使用?
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.FIELD,ElementType.METHOD,ElementType.PARAMETER}) //常用的四个目标类型.
public @interface Sleep {

    int id();

    String msg();

    //定义一个有默认值的 标签属性
    String name() default "阳过";

}
