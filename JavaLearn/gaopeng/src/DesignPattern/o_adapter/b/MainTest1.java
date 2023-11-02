package DesignPattern.o_adapter.b;

import java.util.Arrays;

class Processor {
    public String name() {
        /**
         * 两点说明:
         *  1. this.getClass() 获取当前对象所属的类的字节码.
         *  2. this是谁调用 这个方法,这个this就是谁.
         */
        return this.getClass().getSimpleName();
    }

    Object process(Object input) {
        return input; //假设做了处理.
    }
}

class UpCase extends Processor {

    /**
     * 截图中说的协变:
     * 协变: 入参 类型和父类一样,返回类型 不一样 . 主要旁边有 向上的 小三角 就是 重写.
     */
    String process(Object input) {
        return ((String)input).toUpperCase();
    }
}


class LowerCase extends Processor {

    /**
     * 协变 返回同样也是协变
     */
    String process(Object input) {
        return ((String)input).toLowerCase();
    }
}

class Splitter extends Processor {
    @Override
    String process(Object input) {
        //按空格 分割.
        return Arrays.toString(((String)input).split(" "));
    }
}


public class MainTest1 {

    public static void main(String[] args) {
        String s = "How are you doing?";



        /**
         * 向上转型时,调的对象只和new的对象有关
         */
        //duplicateCode();

        //以上有重复的代码,怎么办? 重构. 创建一个Apply 类 抽取代码.
        Apply.process(new UpCase(),s);
        Apply.process(new LowerCase(),s);
        Apply.process(new Splitter(),s);
    }

    /**
     * 内部有重复代码: 使用 Apply 重构
     */
    private static void duplicateCode() {
        String s = "How are you doing?";
        Processor p = new UpCase();
        System.out.println("处理器的真实名字: " + p.name()); //在本类中找不到就去父类找.
        System.out.println(p.process(s));

        System.out.println("--------------");
        Processor p1 = new LowerCase();
        System.out.println("处理器的真实名字: " + p1.name()); //在本类中找不到就去父类找.
        System.out.println(p1.process(s));

        System.out.println("------------");
        Processor p3 = new Splitter();
        System.out.println("处理器的真实名字: " + p3.name()); //在本类中找不到就去父类找.
        System.out.println(p3.process(s));
    }
}

class Apply {
    public static void process(Processor processor, Object o) {
        System.out.println("--------------");
        System.out.println("处理器的真实名字: " + processor.name()); //在本类中找不到就去父类找.
        System.out.println(processor.process(o));
    }

}


/**
 * 一个方法的参数是类,而不是接口, 那么这个参数只能使用这个类及其子类,如果这个参数传的不是这个类的子类那么就会报错.
 */