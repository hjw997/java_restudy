package DesignPattern.k_prototype.a;

import java.util.Date;

/**
 * 在OA系统中,有一个提交员工提交周报功能,每个周五 员工都需要 总结本周工作内容,
 * 以及写出下周工作计划:
 * 问题是:每周的周报,内容基本上都是大同小异,出现特殊情况的几率很小...看01图
 */


public class AppTest {
    public static void main(String[] args) {
        //模拟第一周周报
        WeekReport weekReport = new WeekReport();
        weekReport.setEmp("张珊珊");
        weekReport.setSummary("讲解完7大原则");
        weekReport.setPlain("讲解完设计模式");
        weekReport.setSuggestion("无");
        weekReport.setTime(new Date());
        //模拟入库保存
        System.out.println(weekReport);


        ///下一周的时候 写周报 第二周大部分内容与第一周周报内容一致,仍然要重复设置.
        // 等同于在表单中重复填写和上周一样的内容.
        WeekReport weekReport1 = new WeekReport();
        weekReport1.setEmp("张珊珊");
        //只有这样两个地方 发生改变,最好克隆出一个对象.
        weekReport1.setSummary("讲解HTML");
        weekReport1.setPlain("讲解CSS");

        weekReport1.setSuggestion("无");
        weekReport1.setTime(new Date());

        //我们的希望是不变的就不填了,只设置变化的部分.
    }
}
