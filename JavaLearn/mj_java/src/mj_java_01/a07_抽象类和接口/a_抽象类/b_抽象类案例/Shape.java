package mj_java_01.a07_抽象类和接口.a_抽象类.b_抽象类案例;
 public abstract class Shape {
     protected  double area; //面积
     protected double girth;//周长

     /**具体怎么计算交给子类
      * ⚠️注意这个protect : 本包和子类中(无论子类在不在本包中)
      * */
     protected abstract void calculate();

     /**
      * ⚠️ 如果不加访问修饰符 这里就是 package-private:
      * 只能在本包中:所以包外的Diamond类 是没法访问这个方法.
      */
     abstract void calculateTest();

     public void show() {
         /**
          * 具体怎么算交给子类实现,面积和周长.因为不同的形状 计算面积周长方式不一样.
          */
         calculate();
         //子类实现完了继续下面👇🏻复杂的运行!
         System.out.println("area:" + area + " _ "+ "girth:" + girth);
     }
}

/**
 * ⚠️:注意点:
 * 关于 protect 和 package-private 说明:
 * protect 子类中可见 (不管子类在哪里) 还有本包中.
 * package-private : 只能是本包中,
 */
