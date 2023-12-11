package mj_java_01.a10_数字.d_包装类的判等;

public class AppTest {
    public static void main(String[] args) {
        Integer i1 = 88;
        Integer i2 = 88; //本质是: Integer.valueOf(88);
        Integer.valueOf(88);// ⚠️ private static class IntegerCache 类 内部是从缓存中获取的 . [-128,127 ] 之间的小整数已经缓存成了对象.

        Integer i3 = 888;
        Integer i4 = 888;

        //❌ 不推荐: [-128,127 ] 内部是有缓存的 . == 对比的是 对象地址.
        System.out.println(i1 == i2); //true
        System.out.println(i3 == i4); //false

        //✅ equals 内对比的是要先拆箱. xxxValue, 此处就是 Integer对象的.intValue()
        // 比较的是 里面的 Value 值
        System.out.println(i1.equals(i2)); //true
        System.out.println(i3.equals(i4)); //true




    }
}
