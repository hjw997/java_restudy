package DesignPattern.p_observer.b;

import java.util.ArrayList;
import java.util.List;

/**
 * 业务场景：
 *一个游戏中，有一个角色，角色有hp血值，mp魔法值，
 * 在游戏窗口中，有一些面板来展示该游戏角色的hp，mp
 * 怪兽 袭击了角色后 就要掉血。
 *
 * 针对 a 包中的 问题: 违反单一职责,违反开闭原则. 那就-分呗
 *
 */

class Role{

    private final List<Observer> observers =new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Object observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(hp); //把🩸值通知给观察者们
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
}

interface Observer {
    void update(int hp);
}


/**
 * 三个观察者: 面板 , 球形 , 头上的血条
 */
class Panel implements Observer {

    @Override
    public void update(int hp) {
        System.out.println("面板更新数据: 🩸hp : " + hp);
    }
}
class BallPanel implements Observer{

    @Override
    public void update(int hp) {
        System.out.println("球形面板中 更新数据: 🩸hp : " + hp);
    }
}

class HeadBarPanel implements Observer{

    @Override
    public void update(int hp) {
        System.out.println("头顶血条-更新数据: 🩸hp : " + hp);
    }
}

class Monster{
    void attack(Role role) {
        //假设:受到到攻击掉血
        role.setHp(role.getHp() - 10 );
    }
}

//===========================时空线========================

/**
 * 新需求在来个 小 左下角小面板 也要显示: 也是个观察者
 */
class ReactPanel implements Observer {

    @Override
    public void update(int hp) {
        System.out.println("左下角小面板来-更新数据: 🩸hp : " + hp);
    }
}

public class AppTest {
    public static void main(String[] args) {
        Role role = new Role();

        role.setName("古天乐");
        role.setHp(100); //初始血值 100

        ///添加观察者:
        role.addObserver(new Panel());
        role.addObserver(new BallPanel());
        role.addObserver(new HeadBarPanel());


        ///新增小面板 显示血值
        role.addObserver(new ReactPanel());


        Monster monster = new Monster();
        ///怪兽攻击 角色. 角色掉血
        monster.attack(role);

    }
}
/**
    优点:
    1.当我们添加一个新的面板要显示数据时,不会违反开闭原则
    2.因为每个面板的算法都被隔离在不同的类中了,也就符合了单一职责!!!!
   缺点:
  1.目前主体只会把自己的hp广播给观察者,如果再来个 mp 也要传递过去 ,  那么就会违反开闭原则.
   而且游戏业务经常变化,经常加入新的玩法,导致Role类的属性,越来越多,每次加属性都要该 Observer的 update 方法么? 看 c 包.
 */
