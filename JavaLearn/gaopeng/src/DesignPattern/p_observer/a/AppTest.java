package DesignPattern.p_observer.a;

/**
 * 业务场景：
 *一个游戏中，有一个角色，角色有hp血值，mp魔法值，
 * 在游戏窗口中，有一些面板来展示该游戏角色的hp，mp
 * 怪兽 袭击了角色后 就要掉血。
 */

class Role {
    private String name;
    private Integer hp;//hp血值
    private Integer mp;//mp魔法值

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
        //粗暴的写法:
        /** 参考游戏业务场景 图:
         * 就是在这个地方,当hp发生变化时,一定要 "通知" 3个地方:1.血条,2.球,3.面板.
         */
        System.out.println("血条更新为hp为:" + hp);
        System.out.println("球更新为hp为:" + hp);
        System.out.println("面板更新为hp为:" + hp);

        //  在更新到报表中.
        /// 注意这里 打印语句模拟为 界面控件.
        System.out.println("报表-更新为hp为:" + hp);
        ///再来个远程 监控 这里的代码就在不断的增加. 违反开闭原则,违反单一职责.
        System.out.println("Socket 远程 更新为hp为:" + hp);
    }

    public Integer getMp() {
        return mp;
    }

    public void setMp(Integer mp) {
        this.mp = mp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

        Monster monster = new Monster();
        ///怪兽攻击 角色. 角色掉血
        monster.attack(role);

    }
}
/**
 * 上面刚开始 感觉没啥问题 怎么爽怎么写
 * 但是 变化来了:
 * 游戏产品经理 来个需求,突然多了一个报表(组件界面)中也要显示 魔法值和血值 .
 * 那么就要在以前的代码中继续添加新的代码,这样的不好,不应该这样
 * 1.违反开闭原则.(看代码比写代码恶心)
 * 2.违反单一职责.(里面显示的是控制逻辑太多)
 *
 * b包:
 */
