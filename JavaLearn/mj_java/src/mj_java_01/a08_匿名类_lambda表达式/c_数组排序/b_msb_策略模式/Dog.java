package mj_java_01.a08_匿名类_lambda表达式.c_数组排序.b_msb_策略模式;

/**
 * 比起 Cat 更通用的写法 :
 */
public class Dog implements Comparable<Dog> { // 接口需要泛型参数好传给里面的方法: public interface Comparable<T> {  public int compareTo(T o); }
    private int food; //狗的食量:
    public Dog(int food) {
        this.food = food;
    }
    @Override
    public int compareTo(Dog o) {
        //Returns:
        //               a negative integer(负数),   zero(零), or a positive integer (正数)
        //分别代表 as this object is less than(小于), equal to, or greater than the specified object.
        if (this.food < o.food) return -1; // a negative integer(负数) 代表: this object is less than the specified object;
        else if (this.food > o.food) return 1; //this object is greater than the specified object;
        else return 0;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "food=" + food +
                '}';
    }
}
