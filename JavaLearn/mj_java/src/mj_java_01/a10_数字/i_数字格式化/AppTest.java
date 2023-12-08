package mj_java_01.a10_数字.i_数字格式化;

public class AppTest {
    public static void main(String[] args) {
        System.out.printf("My name is %d ,height is %d ",30,10);
        System.out.format("My name is %d ,height is %d",10,20);
        System.out.println("-------------");;

        //格式化拼接转为字符串:
        String str =  String.format("My name is %d ,height is %d",10,20);
        System.out.println(str);
    }
}
