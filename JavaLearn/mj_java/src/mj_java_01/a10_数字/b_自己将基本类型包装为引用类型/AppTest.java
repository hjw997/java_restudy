package mj_java_01.a10_数字.b_自己将基本类型包装为引用类型;

public class AppTest {
    public static void main(String[] args) {
        // 使用自定义的包装int的 引用类型,
        IntObject[] data = {
                new IntObject(100),
                new IntObject(-100),
                null, new IntObject(20)
        };

        for (IntObject intObject : data) {
            if (intObject == null) {
                System.out.println("没有值");
            } else {
                System.out.println(intObject.getValue());
            }
        }
    }
}
