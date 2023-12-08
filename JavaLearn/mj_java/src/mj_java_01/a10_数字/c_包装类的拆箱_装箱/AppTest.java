package mj_java_01.a10_数字.c_包装类的拆箱_装箱;

public class AppTest {
    public static void main(String[] args) {
        /**
         * 包装类 其实 里面有个 value 包装着基本类型的值.
         */
        Boolean b;
        Character c;

        Byte byt; // Byte extends Number

        /**
         * 自动装箱:java 编译器会自动调用 valueOf 方法,将基本类型包装为包装类
         */
        Integer i0 = 10; //编译器会自动调用 Integrate.valueOf(10) 👇🏻
        Integer i1 = Integer.valueOf(10); //底层实现

        Integer[] money = {
                100, //底层 Integer.valueOf(100) 包装为了包装类.
                0,
                null,
                500,
                -150
        };
        //
        int i = money[0].intValue();

        System.out.println();

        /**
         * 自动拆箱: java 编译器会自动调用 xxxValue 方法,将包装类转换为 基本类型
         */
        Integer i3 = 10; //自动装箱 Integer.valueOf(10)
        System.out.println(i3.intValue());
        int i4 = i3; //自动拆箱 : i3.intValue();

        System.out.println(i3 == 10); //i3 是引用类型的.
        //相当于:
        System.out.println(i3.intValue() == 10);

        Integer[] array = {11, 22, 33, 44};
        int result = 0;
        for (Integer integer : array) {
            if (integer % 2 == 0) { // integer.intValue() % 2 == 0  // 自动拆箱 ✅
                result += integer;  // result += integer.intValue(); // 自动拆箱 ✅
            }
        }

    }
}
