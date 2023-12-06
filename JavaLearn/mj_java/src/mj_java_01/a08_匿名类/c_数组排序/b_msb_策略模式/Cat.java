package mj_java_01.a08_匿名类.c_数组排序.b_msb_策略模式;

public class Cat implements Comparable<Cat>{
    int weight,height;

    public Cat(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }

    //定义猫的比较方法 : 这种方式比较 死板 使用比较器,不同的比较器(不同的策略,就能实现不同的比较方式)
    @Override
    public int compareTo(Cat cat) { //cat 是被比较的
        if (this.weight < cat.weight) return -1; // 比较的对象this, 比较小.
        else  if (this.weight > cat.weight) return 1; //比较的this 比较大.
        else return 0 ; //两只 相等.
    }

    @Override
    public String toString() {
        return "Cat{" +
                "weight=" + weight +
                ", height=" + height +
                '}';
    }
}
