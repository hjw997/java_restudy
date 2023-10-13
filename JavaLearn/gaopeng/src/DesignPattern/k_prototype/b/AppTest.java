package DesignPattern.k_prototype.b;

import java.util.Date;

/**
 *针对 a 包的问题
 * 使用"原型"模式
 * 1.必须让 目标类实现 Cloneable  接口.
 * 该接口没有任何抽象方法,这样的接口仅仅是个标记接口,
 * 作用是:告诉jvm,任何实现了该Cloneable接口的类的对象,可以被克隆.
 * 2.必须重写 java.lang.Object 的 clone 方法, 一定要把该方法修饰符改为 public ,可以让外界调用.
 */


public class AppTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        //模拟第一周周报
        WeekReport weekReport = new WeekReport();
        weekReport.setEmp("张珊珊");
        weekReport.setSummary("讲解完7大原则");
        weekReport.setPlain("讲解完设计模式");
        weekReport.setSuggestion("无");
        weekReport.setTime(new Date());
        //模拟入库保存
        //System.out.println(weekReport);


        ///下一周的时候 写周报 第二周大部分内容与第一周周报内容一致,仍然要重复设置.
        // 等同于在表单中重复填写和上周一样的内容. 所以直接克隆
        /**
         * 思考1
         *      clone 方法,会不会引起构造器的调用? 不会, 那么这个clone 方法是 如何实现克隆对象的效果呢?
         * clone 方法是直接复制内存中的2进制. 效率更高.
         *
         * 思考2:
         *      既然clone方法没有引起构造器的调用,那么克隆的对象,和原先的对象地址是否一致呢? 不一致.
         *
         */
        System.out.println("-------------");
        //我们的希望是不变的就不填了,只设置变化的部分. 所以直接克隆
        WeekReport weekReport3 = (WeekReport) weekReport.clone();
        //克隆方法不会引起构造方法的调用.

        weekReport3.setSummary("讲解数据库");
        weekReport3.setPlain("讲完MySql");
        //System.out.println(weekReport3);
        //这样在以前的基础上 就少写很多代码. ---------原型设计模式
        /** 打印结果:
         -------------
         WeekReport{id=0, emp='张珊珊', summary='讲解完7大原则', plain='讲解完设计模式', suggestion='无', time=Thu Jan 01 08:00:00 CST 1970}
         WeekReport{id=0, emp='张珊珊', summary='讲解数据库', plain='讲完MySql', suggestion='无', time=Thu Jan 01 08:00:00 CST 1970}
         */

        ///克隆又有没有调用 构造方法么 ? 不会调用 构造方法. 克隆不会调用构造函数.
        weekReport3.getTime().setTime(0); //setTime 是毫秒,是从1970年开始的毫秒. 设置为 0 就是 Thu Jan 01 08:00:00 CST 1970
        System.out.println(weekReport);
        System.out.println(weekReport3);

        /**
         * 问题所在 : 上面日期是 同一个对象,修改了 其中一个日期.两个都被修改了. 为什么呢? 因为目前这种克隆的方式是 "浅拷贝"
         * 所谓的浅拷贝,就是把原来的对象的 2 进制 原样复制.
         */

        /**
         * 我们希望:克隆出来的副本对象,无论怎么修改它,都不会影响原来的对象.
         *
         * 看 C 包
         */
    }
}
