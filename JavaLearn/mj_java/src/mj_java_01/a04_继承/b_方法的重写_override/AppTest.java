package mj_java_01.a04_继承.b_方法的重写_override;


class Animal {
    public void speak() {
        System.out.println("Animal - Speak");
    }
    public void run() {
        System.out.println("Animal - run");
    }
}

class Dog extends Animal {
    @Override
    public void speak() {
        super.speak();
        run();
        this.run();
        super.run();

        System.out.println("Dog - speak");
    }

    @Override
    public void run() {
        System.out.println("Dog - run");
    }
}

public class AppTest {
    public static void main(String[] args) {
        Dog dog = new Dog();
        /**注意这个方法内部调用的顺序*/
        dog.speak();
    }
}

