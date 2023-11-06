package DesignPattern.p_observer.d;

import java.util.ArrayList;
import java.util.List;

/**
 * 业务场景：
 *一个游戏中，有一个角色，角色有hp血值，mp魔法值，
 * 在游戏窗口中，有一些面板来展示该游戏角色的hp，mp
 * 怪兽 袭击了角色后 就要掉血。
 *
 * 针对 c 包中的 问题: update 只能观察 Role , 接口中出现具体的类名, 那么现在 去掉 这个Role 参数
 * update() 直接一个空方法.
 * 具体的观察者自己在构造的时候 传入 要观察的对象 . 这样就把 Observer 接口 彻底的解耦了.
 * 只要 被观察者 发生了变化那么 就 只告诉 观察者: 我变了. 剩下的观察者自己去看到底哪里变了.
 * 这个巧妙的设计来自 Head First 设计模式.
 *
 */

class Role {
    private final List<Observer> observers =new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Object observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(); // 对象(被观察者) 通知给观察者们 : 我变了.
        }
    }
    private String name;
    private Integer hp;//hp血值
    private Integer mp;//mp魔法值

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
        //血值发生的时候 通知观察者
        notifyObservers();
    }

    public Integer getMp() {
        return mp;
    }

    public void setMp(Integer mp) {
        this.mp = mp;
        //魔法值掉的时候 通知观察者
        notifyObservers();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Role{" +
                ", name='" + name + '\'' +
                ", hp=" + hp +
                ", mp=" + mp +
                '}';
    }
}

interface Observer {
    // 需要一个方法,来接受主体Subject发来的新数据.
    void update(); //✅ 现在完全解耦了
}
//英: [əbˈzɜː(r)vəb(ə)l]  Something that is observable can be seen.
//interface Observable {
//}

//abstract class Subject { //被观察的主题的抽象类:
//    private final List<Observer> observers =new ArrayList<>();
//
//    //private List<Observer> observers =new ArrayList<>();
//
//    public void addObserver(Observer observer) {
//        observers.add(observer);
//    }
//
//    public void removeObserver(Object observer) {
//        observers.remove(observer);
//    }
//
//    abstract void notifyObservers() {
//        for (Observer observer : observers) {
//            observer.update();
//        }
//    }
//
//}

/**
 * 三个观察者: 面板 , 球形 , 头上的血条
 */
class Panel implements Observer {

    private final Role role;

    Panel(Role role) {
        this.role = role;
    }

    @Override
    public void update() {
        System.out.println("面板更新数据: 🩸hp : " + role.getHp());
    }
}
class BallPanel implements Observer{
    private final Role role;

    BallPanel(Role role) {
        this.role = role;
    }
    @Override
    public void update() {
        System.out.println("球形面板中 更新数据: 🩸hp : " + role.getHp());
    }
}

class HeadBarPanel implements Observer{

    private final Role role;

    HeadBarPanel(Role role) {
        this.role = role;
    }
    @Override
    public void update() {
        System.out.println("头顶血条-更新数据: 🩸hp : " + role.getHp());
    }
}

class Monster{
    void attack(Role role) {
        //假设:受到到攻击掉血
        role.setHp(role.getHp() - 10 );
    }
}


public class AppTest {
    public static void main(String[] args) {
        Role role = new Role();

        role.setName("古天乐");
        role.setHp(100); //初始血值 100

        ///添加观察者:
        role.addObserver(new Panel(role));
        role.addObserver(new BallPanel(role));
        role.addObserver(new HeadBarPanel(role));



        Monster monster = new Monster();
        ///怪兽攻击 角色. 角色掉血
        monster.attack(role);

    }
}
/**
    优点:
    1.目前每当主体的状态发生变化,就会把主体整个对象囫囵的广播给所有观察者,就算主体有很多个属性也不会影响代码!!!

    缺点:
      ❌:1.你有没有发现,作为一个接口,Observer 接口中的 update方法,居然出现了具体的类名,如此违反了????? 依赖倒置原则.
        如此 Observer 只能观察 Role 角色的 被观察者了. 看d包

 */
