package mj_java_01.a08_匿名类_lambda表达式.d_lambda_为了简化匿名类.d_lambda_vs_匿名类;

/**
 * lambda 使用注意 :
 * 1. Lambda 只能访问 final 或者 有效final的局部变量
 *
 * 2. lambda 没有引入新的作用域
 *
 * lambda VS  匿名类
 */
public class OuterClass {
    private int age = 1;
    public class InnerClass {
        private int age = 2;
        void inner() {

            /**lambda 没有产生新的作用域*/
            TestAble t1 = v -> {
                System.out.println(v); // v是 t.test(3)  test方法传入的 : 3
                System.out.println(this.age); // 2 ✅ lambda 没有产生新的作用域相当于写外面了
                System.out.println(InnerClass.this.age); //2 inner 的 age
                System.out.println(OuterClass.this.age); //1 outerClass 的 age
                System.out.println(age);
            };
            t1.test(3);

            //t2 是 TestAble() {} 匿名类 的对象实例
            TestAble t2 = new TestAble() {
                //自己没有 age 属性.
                @Override
                public void test(int v) {
                    System.out.println(v); //  testAble.test(3); 传入的 3
                    /** ✅
                     *  匿名类可以直接访问外部类中的所有成员(即使 是 private)
                     *  局部类 ,可以直接方位 外部类的成员,
                     *  匿名类是局部类么? 有点像
                     */
                    System.out.println(age);//就近原则
                    //System.out.println(this.age); //❌ error : 没有this.age this 指当前匿名类对象.
                    System.out.println(InnerClass.this.age); //2 inner 的 age
                    System.out.println(OuterClass.this.age); //1 outerClass 的 age
                }
            };
            t2.test(3);

        }
    }

    public static void main(String[] args) {
        InnerClass innerClass = new OuterClass().new InnerClass();
        innerClass.inner();
    }

}
