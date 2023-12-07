package mj_java_01.a08_匿名类_lambda表达式.a_匿名类;


interface Runnable {
   public abstract void run(); //默认加了 public abstract 修饰符 ,所以 平时可以不写.
}

/**
 * 假设: 实现了Runnable 接口的 Person类只在一处使用 了.那么我们建议直接使用匿名类
 */
class Person implements Runnable {

    @Override
    public void run() {
        System.out.println("Person - run()");
    }
}

abstract class Animal {
    public abstract void eat();
}

public class AppTest {
    public static void main(String[] args) {
        //✅:比如这个:实现了Runnable 接口的 Person类只在一处使用 了.那么我们建议直接使用匿名类
        Person person = new Person();
        person.run();

        /**
         * 匿名类 怎么写呢?
         * new 接口/抽象类() { // 后面是类的定义部分✅
         *     //实现抽象方法
         * }
         *
         */

       // 接口 的匿名类
       Runnable r =  new Runnable() { /**匿名类*/
            //✅ 这里面就是 匿名类的 定义的类体
            @Override
            public void run() {
                System.out.println("Person - run()");
            }
        };
       r.run();

      //抽象类的匿名类:
     Animal animal =  new Animal() { //抽象类的匿名类.

          @Override
          public void eat() {
              System.out.println("An Animal -eat");
          }
      };
     animal.eat();

     new Runnable() {

         @Override
         public void run() {
             System.out.println("直接-run");
         }
     }.run();  //创建完直接调用.

    }
}
