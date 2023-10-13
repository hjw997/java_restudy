package DesignPattern.k_prototype.c;

import java.util.Date;

/**
 *针对 a 包的问题 使用深克隆
 *  修改 clone 方法中 克隆的方法. 引用的对象再克隆一份.

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


        WeekReport weekReport3 = (WeekReport) weekReport.clone();
        //克隆方法不会引起构造方法的调用.

        weekReport3.setSummary("讲解数据库");
        weekReport3.setPlain("讲完MySql");

        /**
         WeekReport{id=0, emp='张珊珊', summary='讲解完7大原则', plain='讲解完设计模式', suggestion='无', time=Sat Oct 14 00:04:56 CST 2023}
         WeekReport{id=0, emp='张珊珊', summary='讲解数据库', plain='讲完MySql', suggestion='无', time=Thu Jan 01 08:00:00 CST 1970}
         */

        weekReport3.getTime().setTime(0);
        System.out.println(weekReport);
        System.out.println(weekReport3);
        /**
         * 目前已经达到了深拷贝的目的,也就是修改副本对象的任何属性,都对原有的对象没有任何影响的.
         *
         * 问题 这个对象 有很多个 对象属性, 在克隆方法 实现起来太麻烦.
         * 看 d 包
         */


    }
}
