package mj_java_01.a05_static_final.c_初始化块;


class Person {
    /**编译器会自动为未初始化的成员变量设置初始值 基础类型为 0 ,引用类型为 null , 布尔类型的为 false */
    public static int count;
    public int age;
    public boolean isOld;

    /**
     * 如何手动给实例变量提供初始值呢?
     * 在声明中   public int age = 10;
     * 在构造方法中
     * 在初始化块中
     */
    public Person() {
        /**
         * 初始化块会拷贝到 构造方法的头部.
         */

        age = 10 ; /** 在构造方法中 */

    }

    /**
     * 初始化块:⚠️:✅
     * 编译器会将初始化块复制到没给构造方法的头部(每创建一个实例对象,就会执行一次初始化块)
     * 开发中如果有公共初始化代码 放到 参数最多的构造方法.
     */
    {
        age = 20; //这里初始化也可以.
        System.out.println("实例的初始化块1");
    }

}

public class a_成员变量的初始化 {
    public static void main(String[] args) {
        System.out.println(new Person().age);
        System.out.println(new Person().isOld);
        System.out.println(Person.count);
    }
}
