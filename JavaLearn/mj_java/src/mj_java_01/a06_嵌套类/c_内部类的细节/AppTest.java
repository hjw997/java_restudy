package mj_java_01.a06_嵌套类.c_内部类的细节;

class OuterClass {
    private int x = 1;

    public void showOuter() {
        // System.out.println(InnerClass.this.y); 不可以❌.
    }

    public class InnerClass {
        private int x = 2;
        private int y = 10;

        public void show() {
            System.out.println(x);
            System.out.println(this.x);
            System.out.println(OuterClass.this.x); //访问外面实例的x 为何?
        }
    }
}

public class AppTest {
    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        OuterClass.InnerClass innerClass = outerClass.new InnerClass();
        innerClass.show();

        //上面的代码简写:
        new OuterClass().new InnerClass().show();
    }
}
