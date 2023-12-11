package mj_java_01.a11_字符串;

public class AppTest {
    public static void main(String[] args) {
        String s1 = "mj";
        String s2 = new String("mj");
        System.out.println(s1);
        System.out.println(s2);

        StringBuilder sb = new StringBuilder();
        //性能差异:

        //出了常量意外  大量的拼接和替换等字符串操作 最好都用StringBuilder

        CharSequence c ;
    }
}
