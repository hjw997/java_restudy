package 反射_注解专题扫盲.注解.c_定义注解和使用注解;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 注解就像一个标签:比如如下就是定义一个睡觉的标签,给上课那些睡觉的同学贴上标签一样.
 * 注解也是一种特殊的类型,
 * 注解 关键字: @interface
 * PS 跟接口是没有关系的 .
 * 一种特殊的类 -- 作为标签
 * 标签有效期 Retention
 * 使用场景
 *
 * 元数据: 描述数据的数据 叫做元数据. 如果一个孤零零的数据 说明不了什么,对这个数据说明就是 元数据
 *
 * 元注解: 对注解进行说明的注解 就是元注解  比如
 * 下面两个注解 :
  @Retention(RetentionPolicy.RUNTIME) //有效期 --- SOURCE CLASS RUNTIME 三个阶段
  @Target(ElementType.TYPE) //标签要贴到哪里??ElementType 里面的枚举决定
 * 是对 注解 Sleep 进行说明的注解,叫做元注解.
 *
 *
 * 贴了标签 如何使用?
 */

@Retention(RetentionPolicy.RUNTIME) //有效期 --- SOURCE CLASS RUNTIME 三个阶段
//@Target(ElementType.TYPE) 注解使用到类上, 如果没有 target 就是说明没有限制.
@Target({ElementType.TYPE,ElementType.FIELD}) //标签要贴到哪里(注解用到哪里) ??ElementType 里面的枚举决定
public @interface Sleep {
    //标签里面 要说明信息项(注解的属性)  没有就像贴了一个空标签.

    /**
     * 注解的属性也叫做成员变量.
     * 注解只有成员变量,没有方法.
     * 注解的属性看似方法,实际是属性
     */

    /**
     * int 类型的属性,名称叫 id
     */
    int id();

    String msg();

    //定义一个有默认值的 标签属性
    String name() default "阳过";

}
