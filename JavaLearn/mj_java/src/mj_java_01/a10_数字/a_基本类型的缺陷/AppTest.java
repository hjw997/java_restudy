package mj_java_01.a10_数字.a_基本类型的缺陷;

public class AppTest {
    public static void main(String[] args) {

        // 比如营业额 无法表示 没有,虽然有 0 但是意思不够明确 是营业额 0 呢还是 没有?
        int[] moneyCount= {100, 50, 0, 600, 200};

        //用 null 就可以表示 没有.
        String[] money = {"100", "50", null, "0", "600", "200"};


    }
}
