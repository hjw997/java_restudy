package DesignPattern.q_strategy.a;


class Role {
    private String name;

    public Role(String name) {
        this.name = name;
    }
    public void fight() {
        /// 使用的武器写死在这里了
        System.out.println(name + "使用剑砍");
    }
}


public class AppTest {
    public static void main(String[] args) {
        Role role = new Role("骑士");
        role.fight();
    }
}
