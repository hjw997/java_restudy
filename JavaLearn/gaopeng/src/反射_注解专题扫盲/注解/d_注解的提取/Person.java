package 反射_注解专题扫盲.注解.d_注解的提取;

/**
 * 标签可以贴多个---注解可以加多个
 * 比如能吃能睡
 */
@Sleep(id = 1, msg = "类") //给标签的属性赋值.(注解的属性赋值)
//@Eat(value = "能吃") //只有一个属性 且名字 叫做 value  ,使用的时候 value 可以省略
@Eat("能吃的东西") //属性如果是value 可以省略value.
//@Eat({"能吃的东西","能喝的东西"}) // value 如果是数组形式, 也是可以赋值就用{} 数组的形式
public class Person {
    @Sleep(id = 2, msg = "字段")
    private String userName;

    @Sleep(id = 3, msg = "方法上的注解", name = "这个是一个测试注解方法msg")
    public void testAnnotation(@Sleep(id = 4, msg = "方法参数注解msg") int a, int b) {
        //参数的注解: 上面只是给第一个参数加了注解. 如果给第二个参数加如下:
        //public void testAnnotation(@Sleep(id = 4,msg = "第一个方法参数注解msg") int a, @Sleep(id = 5,msg = "第二个方法参数注解msg") int b) {

    }

    /**
     * 参数的注解: 上面只是给第一个参数加了注解. 如果给第二个参数加如下:
     *
     * @param a
     * @param b
     */
    public void testAnnotation01(@Sleep(id = 4, msg = "第一个方法参数注解msg") int a, @Sleep(id = 5, msg = "第二个方法参数注解msg") int b) {

    }
}
