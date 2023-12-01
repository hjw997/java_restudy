package mj_java_01.a04_继承.g_封装_toString;

public class Person {
    private int age; /** 成员变量私有化,提供 public 的 setter 和 getter */

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * ✅:关于构造方法建议 就是 提供无参的构造方法.
     *  因为有时候对象创建后可能稍后才会给成员属性赋值.
     */

    public Person() {
        /**
         *  次处是 调用有参的构造 来初始化 age.
         *  但是不初始化 java默认就会被初始化为 0 .
         */
        this(0);
    }

    public Person(int age) {
        this.age = age;
    }


    @Override
    public String toString() { //打印调用 toString方法.
        /**
         * Object 默认的 toString 实现: getClass().getName() + "@" + Integer.toHexString(hashCode());
         *
         * Integer.toHexString(hashCode()) 十六进制的 哈希值.
         *
         */
        return "Person{" +
                "age=" + age + " " + "@" +
                Integer.toHexString(hashCode()) +
                '}';
    }
}
