package mj_java_01.a06_嵌套类.b_内部类_Inner_class;


public class AppTest {
    public static void main(String[] args) {
        Person person = new Person("杰克");
        //现在想创建个手 怎么创建呢?
        //Person.Hand hand = new Person.Hand(); //❌

        //必须先创建外部类实例,然后再用外部类实例创建内部类实例.
        //person.Hand hand = new person.Hand(); ❌
        Person.Hand hand = person.new Hand(); //✅必须先创建外部类实例,然后再用外部类实例创建内部类实例.
        //看内存图分析

        //show中访问外部类的实例属性内部:
        hand.show();
        person.showHandInfo(hand);

    }
}
