package mj_java_01.a07_抽象类_接口_多态.b_接口.d_接口对比抽象类;


/***
 * 1.继承: A extends D , A 是 D
 *
 * 2.接口:
 * 实现: A implement D , A 会 D 中的 行为.
 *
 * 何时选择抽象类? is-a 关系.
 * 紧密关联的类之间共享代码.
 * 需要除 public 之外的访问权限.因为 接口中的是 public ,如果想要私有的或者 protected 的权限.那么抽象类更适合.
 * 需要定义实例变量(非 final 的静态变量),也就是想抽取一些 公共的实例成员变量.
 *
 * 何时选择接口? has - a 有一种功能.
 * >不相关的类,实现相同的方法(行为).(也就是 不相关的类有相同的行为)
 * 比如 Eatable 车吃油 ,人吃饭. 吃的行为.
 * >只是定义行为,不关心具体是谁实现了行为.
 * >想实现类型的多重继承. 接口 是多继承的, 类是单继承.
 *
 *
 */
public class AppTest {
    public static void main(String[] args) {

    }
}
