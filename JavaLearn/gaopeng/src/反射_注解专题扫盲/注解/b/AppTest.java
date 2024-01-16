package 反射_注解专题扫盲.注解.b;

import java.lang.annotation.Annotation;

public class AppTest {
    public static void main(String[] args) {
        Class cls = Car.class;
        Foo foo = (Foo) cls.getDeclaredAnnotation(Foo.class);
        System.out.println(foo.name());
        System.out.println(foo.age());

        Class<Dog> aClass = Dog.class;
        Bar bar = aClass.getDeclaredAnnotation(Bar.class);
        System.out.println(bar.value());
        System.out.println(bar.age());
    }
}
