package mj_java_01.a08_匿名类.c_数组排序.a_msb_策略模式补充;

public class Cat {
    int weight,height;

    public Cat(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }

    //定义猫的比较方法
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
