package 反射_注解专题扫盲.注解.e_注解的应用案例;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AppTest {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        Class<NoBug> noBugClass = NoBug.class;
        NoBug noBug = noBugClass.newInstance();
        // 获取NoBug类的 所有的方法.
        Method[] methods = noBugClass.getDeclaredMethods();
        int count = 0;
        //然后判断哪些方法加了注解
        for (Method method : methods) {
            //判断方法上有没有注解:
            if (method.isAnnotationPresent(JianCha.class)) {
                try {
                    method.invoke(noBug, 2, 0);
                } catch (InvocationTargetException e) {
                    System.out.println("有bug");
                    count ++;
                    e.printStackTrace();
                }
            }
        }
        System.out.println("你的错误个数 " + count);

        /**
         * 测试框架的底层大概也是这个套路.
         * 本课程的 第9分钟 讲解了如果数据库中读取了数据转模型 字段不一致对应不上的时候如何使用注解来映射
         * https://www.bilibili.com/video/BV1hY411p7HR?p=23&spm_id_from=pageDriver&vd_source=b386945edbef32fc1df7d8a419f8de78
         */


    }
}
