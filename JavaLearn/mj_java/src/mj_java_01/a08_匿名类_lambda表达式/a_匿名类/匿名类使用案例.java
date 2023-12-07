package mj_java_01.a08_匿名类_lambda表达式.a_匿名类;


interface Eatable { //定义一个可以吃的东西
    String name(); //可以吃的这个名字是啥

    int energy(); //能量是多少
}
class APerson {
    public void eat(Eatable e) {
        System.out.println("eat - " + e.name() + " 能量- " + e.energy() + " 卡路里");
    }
}

public class 匿名类使用案例 {
    public static void main(String[] args) {
        APerson aPerson = new APerson();
        aPerson.eat(new Eatable() { //比如这个苹果只在项目中用了这一次.
            @Override
            public String name() {
                return "苹果";
            }

            @Override
            public int energy() {
                return 200;
            }
        });

        aPerson.eat(new Eatable() {
            @Override
            public String name() {
                return "螺蛳粉";
            }
            @Override
            public int energy() {
                return 300;
            }
        });

        //可以使用变量保存这个匿名类创建的对象 以便后期可以多次使用.
        Eatable beef = new Eatable() {
            @Override
            public String name() {
                return "牛肉";
            }
            @Override
            public int energy() {
                return 500;
            }
        };

        aPerson.eat(beef);
        aPerson.eat(beef);

    }
}
