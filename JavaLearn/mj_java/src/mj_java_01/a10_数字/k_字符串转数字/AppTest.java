package mj_java_01.a10_数字.k_字符串转数字;

public class AppTest {
    public static void main(String[] args) {
        // valueOf 是包装类型的
        Integer integer =  Integer.valueOf("123");
        // parse 开头的 会转为基本类型,
        int a  =  Integer.parseInt("123");
        // 注意上面两个方法 的使用细节上 Integer 和 int 基本类型 包装时候 性能损耗.
        // 比如 Integer.parseInt() 默认返回的是 int 如果,使用 Integer 去接收 int 又会包装为Integrate

       Integer value =  Integer.parseInt("123"); //多个自动装箱, 消耗更多性能.
        // Integer.valueOf("123"); 返回 Integer
        int aValue = Integer.valueOf("123"); //多个自动拆箱

        /**
         * 总结: ✅
         *  parse 开头的 会转为基本类型,
         *  valueOf 是包装类型的(引用类型的)
         */

    }
}
