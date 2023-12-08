package mj_java_01.a09_枚举.a_自定义实现枚举类;


/**
 * 自定义实现枚举类:
 */

class Season {
    private Season() { } //构造方法私有化不让外界调用
    public static final Season SPRING = new Season();
    public static final Season SUMMER = new Season();
    public static final Season FALL = new Season();
    public static final Season WINTER = new Season();

    /**
     * 上面的 这种写法 其实也是 枚举底层的实现.
     */

}

public class AppTest {

    public static void main(String[] args) {
        //Season season = new Season(); 外界无法 new 的
        Season season = Season.SPRING;
        testEnum(season);
    }

    public static void testEnum(Season s) {

        /**
         * Switch 这里的要求类型是:
         * required: 'char, byte, short, int, Character, Byte, Short, Integer, String, or an enum'
         */
//        switch (s) { //❌:不能是引用类型
//            case Season.SPRING -> System.out.println("春");
//            case Season.SUMMER -> System.out.println("夏");
//        }

         if (s == Season.SPRING) {
             System.out.println("春天");
        } else if (s == Season.SUMMER) {
             System.out.println("夏天");
         } else if (s == Season.FALL) {
             System.out.println("秋天");
         } else if (s == Season.WINTER) {
             System.out.println("冬天");
         }
    }

}
