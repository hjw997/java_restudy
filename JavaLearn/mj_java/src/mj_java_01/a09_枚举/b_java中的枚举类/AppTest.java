package mj_java_01.a09_枚举.b_java中的枚举类;


/**
 * java中已经有 枚举类型了 Enum Type
 *
 */
enum Season {
    SPRING,SUMMER,FALL,WINTER
}
public class AppTest {
    public static void main(String[] args) {
        Season season = Season.SPRING;
        /**
         * 默认的枚举类 有两个属性 :
         *   name :枚举的常量名字
         * 和 ordinal  枚举的常量值索引
         */
        System.out.println(season.name());

        System.out.println(season.ordinal());

        testEnum(season);

    }
    public static void testEnum(Season s) {

        /**
         * Switch 这里的要求类型是:
         * required: 'char, byte, short, int, Character, Byte, Short, Integer, String, or an enum'
         * 此时可以使用 switch case了. 因为 此时的 s 是java 中的枚举类了.
         */
        switch (s) { //枚举类型是可以的 ✅
            //case 后是枚举 常量值
            case SPRING : {
                System.out.println("春");
                break;
                /**
                 * ⚠️ break 是需要的 否则case 穿透了.
                 */
            }
            case SUMMER : {
                System.out.println("夏");
                break;
            }

            case FALL : {
                System.out.println("秋");
                break;
            }

            case WINTER : {
                System.out.println("冬");
                break;
            }

        }

        System.out.println("-----------if条件----------");
        if (Season.SPRING == s) {
            System.out.println("春天");
        } else if (Season.SUMMER == s) {
            System.out.println("夏天");
        } else if (Season.FALL == s) {
            System.out.println("秋天");
        } else if (Season.WINTER == s) {
            System.out.println("冬天");
        }

    }
}
