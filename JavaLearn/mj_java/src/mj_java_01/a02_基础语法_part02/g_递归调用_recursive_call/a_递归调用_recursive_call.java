package mj_java_01.a02_基础语法_part02.g_递归调用_recursive_call;

public class a_递归调用_recursive_call {
    public static void main(String[] args) {
        int sum = sum(4);
        System.out.println(sum); //10
    }

    /**
     * 递归求n 的 和
     * @param n
     * @return
     */

    public static int sum(int n) {
        if(n <= 1) return n; // n = 1, 返回1 , n=0 返回0.
        return n + sum(n - 1);
    }
}
