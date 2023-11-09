package DesignPattern.l_builder.f_in_Android;


class GirlFriend {
    String name;
    String age;
    String height;
    String weight;
    String sanwei;
    boolean isBeauty;

    @Override
    public String toString() {
        return "GirlFriend{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", height='" + height + '\'' +
                ", weight='" + weight + '\'' +
                ", sanwei='" + sanwei + '\'' +
                ", isBeauty='" + isBeauty + '\'' +
                '}';
    }
    // 复杂对象的创建.设置属性,不设置就是默认值.
    // 构造方法:很多个属性,就可以 1个参数的构造 ,2个参数的 等等.


    public GirlFriend(String name, String age, String height, String weight, String sanwei, boolean isBeauty) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.sanwei = sanwei;
        this.isBeauty = isBeauty;
    }

    //Request.Builder().setxxx().build()

    /**
     * 静态内部类:
     */
    public static class Builder {
        private String name = "小乔";
        private String age = "30";
        private String height = "1.8";
        private String weight = "50kg";
        private String sanwei = "80 60 90";
        private boolean isBeauty = true;

        //注意返回值: 要一直调用 xx.setXXX()
        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setAge(String age) {
            this.age = age;
            return this;
        }

        public Builder setHeight(String height) {
            this.height = height;
            return this;
        }

        public Builder setWeight(String weight) {
            this.weight = weight;
            return this;
        }

        public Builder setBeauty(boolean beauty) {
            isBeauty = beauty;
            return this;
        }

        public Builder setSanwei(String sanwei) {
            this.sanwei = sanwei;
            return this;
        }

        public GirlFriend build() {
            ///有了所有属性 最后 创建,
            return new GirlFriend(name, age, height, weight, sanwei, isBeauty);
        }
    }
}

public class APPTest {
    public static void main(String[] args) {
        GirlFriend girlFriend = new GirlFriend.Builder()
                .setName("貂蝉")
                .setBeauty(true)
                .setAge("25岁")
                .setHeight("1.75m")
                .setSanwei("60 70 85")
                .setWeight("45kg")
                .build();
        System.out.println(girlFriend);
    }
}
