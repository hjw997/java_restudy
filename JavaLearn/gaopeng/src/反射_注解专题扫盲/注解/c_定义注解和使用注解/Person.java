package 反射_注解专题扫盲.注解.c_定义注解和使用注解;


/**
 * 贴标签: 加注解.
 */
@Sleep(id = 1,msg = "类") //给标签的属性赋值.(注解的属性赋值)
public class Person {
    @Sleep(id = 1,msg = "字段")
    private String name;
}
