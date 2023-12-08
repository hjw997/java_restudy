package mj_java_01.a10_数字.k_字符串转数字;

public class AppTest {
    public static void main(String[] args) {
        //valueOf 是包装类型的
        Integer integer =  Integer.valueOf("123");
        // parse 开头的 会转为基本类型,
        int a  =  Integer.parseInt("123");
        // 注意上面两个方法 的使用细节上 Integer 和 int 基本类型 包装时候 性能损耗.

    }
}
