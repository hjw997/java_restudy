package DesignPattern.q_strategy.b;


class Role {
    private String name;

    Weapon weapon;


    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }


    public Role(String name) {
        this.name = name;
    }
    public void fight() {
//        /// 使用的武器写死在这里了
//        System.out.println(name + "使用剑砍");

        /// 如果这里使用if判断各种武器，然后用哪种武器，那么扩展不便，破坏开闭原则。

        /// 策略模式核心说的是 外面换了个策略，这里就会表现不同的形式。
        weapon.attack();
    }
}

/**
 * 剑
 */
class Sword implements Weapon {

    @Override
    public void attack() {
        System.out.println("使用剑砍....");
    }
}

class Axe implements Weapon {

    @Override
    public void attack() {
        System.out.println("使用斧头砍");
    }
}

class Bow implements Weapon {
    @Override
    public void attack() {
        System.out.println("宝雕弓射！！");
    }
}

interface  Weapon {
    void  attack();
}

///==============以上为作者写的时空分割线=============


/// 下面自己扩展一个
class Gun implements Weapon {

    @Override
    public void attack() {
        System.out.println("使用手枪🔫~~~");
    }
}

public class AppTest {
    public static void main(String[] args) {
        Role role = new Role("骑士");

        role.setWeapon(new Sword());
        role.fight();
        role.fight();

        /// 更换策略 使用 宝雕弓
        role.setWeapon(new Bow());
        role.fight();
        role.fight();


        /// 使用自己扩展的类 枪
        role.setWeapon(new Gun());
        role.fight();
    }
}
