package mj_java_01.a08_匿名类_lambda表达式.d_lambda_为了简化匿名类.c_lambda使用注意事项;

/**
 * lambda 使用注意 :
 * 1. Lambda 只能访问 final 或者 有效final的局部变量
 *
 * 2. lambda 没有引入新的作用域
 */
public class OuterClass {
    private int age = 1;
    public class InnerClass {
        private int age = 2;
        void inner() {
            int abc = 22; //非有效 final
            abc = 33;  //一旦改动就不是有效final
            int fabc = 45; //有效final : java 8 开始一个局部变量如果后续没有第二次改动就认为有效 final .
            /**
             *  * 3. final 修饰的变量:
             *  *    a.局部变量  如果 final 修饰的局部变量 只能进行一次赋值.
             *  *    b.成员变量  如果 final修饰的是成员变量的话,要求这个对象创建完必须有值.
             */
            final int count = 100; //final 常量.

            /**lambda 没有产生新的作用域*/
            //int v = 40 ; 打开就是❌了 , 和 v -> 重复定义了
            TestAble t = v -> { //相当于重复定义了,但是这个v 只能在 lambda {} 的作用域中使用.
                System.out.println(v); // v是 t.test(3)  test方法传入的 : 3
                /**
                 * ✅lambda 没有引入新的作用域 所以这段代码就相当于写外面了, 所以说
                 * age 直接访问的就是 当前类对象的属性,也就是 this.age.
                 */
                System.out.println(age); // 2
                /**
                 * ✅lambda 没有引入新的作用域 所以这段代码就相当于写外面了, 所以说
                 * 此时这个 age 就是 this 指 InnerClass的 age
                 */
                System.out.println(this.age); // 2
                System.out.println(InnerClass.this.age); //2 inner 的 age
                System.out.println(OuterClass.this.age); //1 outerClass 的 age

                /**
                 *  Lambda 只能访问 final 或者 有效final的局部变量
                 */
                //System.out.println(abc);//Error 非有效final
                System.out.println(fabc);// 有效final


            };
            t.test(3);

            /**
             * ✅lambda 表达式是要取代 下面你匿名类对象的:
             * 因为 你写了下面匿名类对象的时候 , 编译器 提示 : replace with lambda.
             */
            int v = 40;
            TestAble testAble = new TestAble() {
                //自己没有 age 属性.
                @Override
                public void test(int v) {
                    System.out.println(v); //  testAble.test(3); 传入的 3
                    System.out.println(age); // 就近原则:
                    //System.out.println(this.age); //❌ error : 没有this.age this 指当前匿名类对象.
                    System.out.println(InnerClass.this.age); //2 inner 的 age
                    System.out.println(OuterClass.this.age); //1 outerClass 的 age
                }
            };
            testAble.test(3);


            /** lambda 没有产生新的作用域 相当于这些代码 写在了外面 所以和上面 int v = 40 变量冲突.:*/
//            int v = 3;
//            System.out.println(v);
//            System.out.println(age);
//            System.out.println(this.age);
//            System.out.println(InnerClass.this.age);
//            System.out.println(OuterClass.this.age);

        }
    }

    public static void main(String[] args) {
        InnerClass innerClass = new OuterClass().new InnerClass();
        innerClass.inner();
    }

}
