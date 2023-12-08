package mj_java_01.a10_数字.g_Random随机类;

import java.util.Random;

public class AppTest {
    public static void main(String[] args) {
        Random random = new Random();
        //生成随机数: 不能指定范围
        random.nextDouble();
        random.nextInt();
        random.nextInt(100); //jdk 注释: 0 - 指定的值 [0,指定的值]
        random.nextFloat();

        //生成 0-99 即: [0,99) 随机数:
        int r0 = random.nextInt(100); // 推荐 ✅ : jdk 注释: 0 - 指定的值 [0,指定的值]
        int r1 = (int) (Math.random() * 100) ; //Math.random() 是 [0.0,1.0) 乘以 100 就是 [0,99)
        System.out.println(r0);
        System.out.println(r1);

        //生成 10 - 99 范围随机数
        //[0,89] + 10 [0.0 - 1.0) * 89 就是 => [0.0 - 89.0]
        int r2 = (int) (Math.random() * 89 ) + 10 ;
        int r3 = random.nextInt(89) + 10; ;
        System.out.println(r2);

        /**
         * 随机输出 4位 大写验证码:
         */

        //char c  = (char) (random.nextInt(32) + 'A');
        char[] chars = new char[4];
        for (int i = 0; i < 4; i++) {
            //A-Z 是 : 65 - 90 : 65 + [0~25)  //0-25 就是26个字母
            char c  = (char) (random.nextInt(25) + 'A');
            System.out.println(c);
            chars[i] = c;
        }
        System.out.println(chars);

        System.out.println("-------");
        for (int i = 0; i < 4; i++) {
            char c  = (char) (random.nextInt(25) + 'A');
            System.out.print(c); //这个直接打印出了.不换行.
        }
        System.out.println();


        char a = 'A';
        System.out.println(+a); // char 转 int 直接 搞个+ 就是 int 了


    }
}
