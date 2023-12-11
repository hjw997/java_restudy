package mj_java_01.a12_日期类Date;

import java.util.Date;

public class AppTest {
    public static void main(String[] args) {
        Date date1 = new Date();
        //✅当前时间: Sat Dec 09 14:02:46 PST 2023
        //PST 太平洋标准时间 Pacific Standard Time
        //CST China Standard Time
        System.out.println(date1);


        // 2000 +  : date – the milliseconds since January 1, 1970, 00:00:00 GMT.
        // GMT: 格林威治 Greenwich
        Date date2 = new Date(2000);
        System.out.println(date2);

        // 返回的是 1970-01-01 00:00:00 GMT 到现在的毫秒数
        // System.currentTimeMillis();
        Date date3 = new Date(System.currentTimeMillis());
        System.out.println(date3);// == date1


        //常用方法

        //日期格式:SimpleDateFormat:

    }
}
