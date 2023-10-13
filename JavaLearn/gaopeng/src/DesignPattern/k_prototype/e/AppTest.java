package DesignPattern.k_prototype.e;

import java.util.Date;

/**
 *针对 d包 的问题 序列化写到内存中, 在从内存中读取
 * 不用盘符
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

        /// 内部的 clone 方法是通过序列化来实现的.
        WeekReport weekReport3 = (WeekReport) weekReport.clone();
        //克隆方法不会引起构造方法的调用.
        weekReport3.setSummary("讲解数据库");
        weekReport3.setPlain("讲完MySql");

        /**
         WeekReport{id=0, emp='张珊珊', summary='讲解完7大原则', plain='讲解完设计模式', suggestion='无', time=Sat Oct 14 01:05:19 CST 2023}
         WeekReport{id=0, emp='张珊珊', summary='讲解数据库', plain='讲完MySql', suggestion='无', time=Thu Jan 01 08:00:00 CST 1970}
         */

        weekReport3.getTime().setTime(0);
        System.out.println(weekReport);
        System.out.println(weekReport3);
        /**
          现在解决了克隆时候的对象层级深的问题.
          现在才是完美的克隆对象的方法.

         */


    }
}
