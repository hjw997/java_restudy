package 反射_注解专题扫盲.注解.d_注解的提取;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * 注解的提取:
 * 主要三个方法:
 * 1.判断某个 对象上面是否使用了某个注解 类型对象.isAnnotationPresent
 * 2.获取注解: getAnnotation(某个注解的类对象)
 * 3.
 */

public class AppTest {

    /**
     * 1. 提取类型上的注解:
     */
    @Test
    public void test01() {
        //提取哪个类的上面的注解就先获取哪个类的 Class对象实例
        Class<Person> clazz = Person.class;

        //判断某个类上有没有使用某个注解
        //boolean annotationPresent = clazz.isAnnotationPresent(Sleep.class);
        if (clazz.isAnnotationPresent(Sleep.class)) { //Present 存在的意思
            System.out.println("贴了```");
            //得到那个注解对象实例 Annotation 类型 是注解的父类
            Sleep sleep = clazz.getAnnotation(Sleep.class);
            //得到注解的属性值.
            System.out.println(sleep.id());
            System.out.println(sleep.msg());
            System.out.println(sleep.name());
        }
    }


    /**
     * 2. 提取属性上的注解:
     */
    @Test
    public void test02() throws Exception {
        //得到属性上的注解 先要得到属性字段对象 Field 对象
        Class<Person> clazz = Person.class;
        Field field = clazz.getDeclaredField("userName");
        //判断字段是否使用了某个注解:
        if (field.isAnnotationPresent(Sleep.class)) {
            //如果使用了注解那么就从这个字段对象提取该指定的注解. 以为注解可以是多个.
            Sleep sleepAnnotation = field.getAnnotation(Sleep.class);
            System.out.println(sleepAnnotation.id());
            System.out.println(sleepAnnotation.msg());
        }
    }

    /**
     * 3. 提取方法上的注解:
     */
    @Test
    public void test03() throws Exception {
        Class<Person> clazz = Person.class;
        Method m = clazz.getDeclaredMethod("testAnnotation", int.class, int.class);
        if (m.isAnnotationPresent(Sleep.class)) {

            Sleep annotation = m.getAnnotation(Sleep.class);
            System.out.println(annotation.id());
            System.out.println(annotation.msg());
            System.out.println(annotation.name());
        }
    }


    /**
     * 4. 提取方法参数上的注解:
     */
    @Test
    public void test04() throws Exception {
        Class<Person> clazz = Person.class;
        Method m = clazz.getDeclaredMethod("testAnnotation", int.class, int.class);

        //反射获取方法参数对象
        Parameter[] parameters = m.getParameters();
        Parameter p = parameters[0]; //获取第一个参数
        if (p.isAnnotationPresent(Sleep.class)) {
            Sleep sleep = p.getAnnotation(Sleep.class);
            System.out.println(sleep.name());
            System.out.println(sleep.msg());
            System.out.println(sleep.id());
        }
    }

}
