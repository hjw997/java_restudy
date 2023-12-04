package mj_java_01.a07_抽象类和接口.b_接口.b_接口可定义内容;

public class AppTest {
    public static void main(String[] args) {
        Child child = new Child("Jack");

        child.setTeacher(new Student());

        child.study();

        //换个能教学的 AI 机器人教
        child.setTeacher(new AIRobot());
        child.study();

    }

    /**
     * 有个小孩,需要招聘一个家教/保姆 来照顾
     * 应聘家教 需要 什么标准呢? 比如在校学生,在校老师,出租车司机(隐藏学霸🤓),
     */
}

/**
 * 接口 是用来方法的声明,定义行为准则.
 * 接口一般用 xxxAble 能做xxx
 */
interface Teachable {
    /**
     * 对家教的要求:
     * 1.教编程,
     * 2.教英语
     */
    public abstract void teachProgramming(Child child); //❌不符合设计模式,接口中不要依赖具体.依赖接口.

    public abstract void teachEnglish(Child child);

}
class Child {
    public String getName() {
        return name;
    }
    private final String name; //小孩的名字
    private Teachable teacher; //能教学的人: 能教学的人

    public Child(String name) {
        this.name = name;
    }

    public void setTeacher(Teachable teacher) {
        this.teacher = teacher;
    }

    /**
     * 小孩学习: 老师教编程,教英语
     */
    public void study() {
        teacher.teachProgramming(this);
        teacher.teachEnglish(this);
    }
}

class Student implements Teachable {

    @Override
    public void teachProgramming(Child child) {
        System.out.println("学生教" + child.getName() + "学编程");
    }

    @Override
    public void teachEnglish(Child child) {
        System.out.println("学生教" + child.getName() + "学英语");
    }
}

/**
 * AI 机器人 也能 教:
 */
class AIRobot implements Teachable {

    @Override
    public void teachProgramming(Child child) {
        System.out.println("AI机器人 教" + child.getName() + "学编程");
    }

    @Override
    public void teachEnglish(Child child) {
        System.out.println("AI机器人 教" + child.getName() + "学英语");
    }
}