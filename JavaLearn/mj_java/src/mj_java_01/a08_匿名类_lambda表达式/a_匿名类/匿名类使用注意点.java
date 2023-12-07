package mj_java_01.a08_匿名类_lambda表达式.a_匿名类;

public class 匿名类使用注意点 {

    private static int count = 10;
    private String name = "abac";
    private int  myAge = 5;

    public static void main(String[] args) {

        /**
         * 也是在 代码块中 定义的 用法和局部类 优点像
         */
        int abc = 10; //有效final
        Runnable runnable = new Runnable() { //它的外部类 是 上面的 public class 匿名类使用注意点 {

            /**
             * 匿名类 的类体:
             * 匿名类中不能定义 除 编译时常量以外的 任何 static 成员
             */
            static final int age = 10; //✅ 可以
            private int  name ;

            /** ❌
             * 匿名类中不能定义 除 编译时常量以外的 任何 static 成员
             内部类 <匿名mj_java_01.a08_匿名类_lambda表达式.a_匿名类.匿名类使用注意点$1> 中的静态声明非法
             修饰符 'static' 仅允许在常量变量声明中使用
             */
            // static int count = 10; //❌ 匿名类中不能定义 除 编译时常量以外的 任何 static 成员
            @Override
            public void run() {
                System.out.println(abc); //访问的 有效final
                System.out.println(count); //可以访问外部类的所有成员 但是注意 static方法 不能访问实例的,也好理解.
                // System.out.println(myAge); //静态中不能访问实例属性字段和方法不行(因为static 是类对象,实例对象不是一个内存空间)
            }

            /**
             * 匿名类不能有 构造方法  ❌
             * 但是 可以 有 实例初始化块 ✅
             */
//            static {  //❌匿名类中不能定义 除 编译时常量以外的 任何 static 成员
//                System.out.println("static -初始化块.");
//            }

            //实例初始化块 ✅
            {
                System.out.println("匿名类的实例 -初始化块.是可以定义的✅");
            }

        };
        runnable.run();


    }

    private void test() {
        /**
         * 匿名类 只有在 实例相关 的代码快中使用, 才能直接访问外部类中的实例成员( 实例变量, 实例方法 )
         */
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(count); // 1. 可以访问外部类的所有成员
                System.out.println(name); // 2. 匿名类 只有在 实例相关 的代码快中使用, 才能直接访问外部类中的实例成员( 实例变量, 实例方法 )
            }
        };
        runnable.run();
    }
}
