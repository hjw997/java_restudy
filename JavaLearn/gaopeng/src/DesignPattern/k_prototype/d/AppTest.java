package DesignPattern.k_prototype.d;

import java.util.Date;

/**
 *针对 c 包的问题 使用深克隆
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
          但是问题是: clone 方法里面的代码要写到磁盘上, 像个办法不写到磁盘. 直接写到内存上,再从内存上序列化:

          /// 程序中永远不要写 盘符: 跨平台 , 不要砸牌子.

         */


    }
}
