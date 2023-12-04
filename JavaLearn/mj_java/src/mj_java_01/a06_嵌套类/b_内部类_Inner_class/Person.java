package mj_java_01.a06_嵌套类.b_内部类_Inner_class;

public class Person {
    private int age; //实例变量
    private String name; //人的名字

    public Person(String name) {
        this.name = name;
    }

    public int getAge() { //实例方法
        return age;
    }
    //实例方法 实例变量都是和 实例对象挂钩的 也就是必须有实例对象存在才能访问实例变量和实例方法.

    /**1.内部类和 实例方法 和 实例变量一样.内部类和外部类的实例对象相关联.*/
    // class InnerClass {}
    public void showHandInfo(Hand hand) {
        /**
         * 4.外部类 可以直接访问内部类实例的成员变量.方法(即使被声明 为 private)
         */
        System.out.println("My hand weight is " + hand.weight  + " kg"); //不能直接访问 weight
        //可不可以 通过 内部类.实例.weight 访问呢?
        //System.out.println(Hand.this.weight); //❌不可以
    }


    //内部嵌套类也可以看做是 外部类的一个成员(外部类对象存在才有意义),所以可以设置访问权限.为了方便 先设置 public
    public class Hand {
        //实例变量是可以的:
        private int weight = 1; //手的重量.

        //内部类不可以定义static类变量.和 方法都不可以,这是内部类的限制.
        //public static int count = 1; //❌修饰符 'static' 仅允许在常量变量声明中使用
        //✅除非是编译时常量: static final 编译时确定的.
        public static final int COUNT = 1;

        /**
         * 3.内部类是可以直接访问外部类中的所有成员(即使被声明为 private)
         * */
        public void show() {
            //name 是外部类的 实例变量.尽管是 private的,因为从内存角度,是可以找到 外部类实例对象的.
            //name还有一点是外部类实例对象的,因为只有外部类存在实例对象,内部类才有意义.
            System.out.println(name + "的手" );
        }
    }
}
