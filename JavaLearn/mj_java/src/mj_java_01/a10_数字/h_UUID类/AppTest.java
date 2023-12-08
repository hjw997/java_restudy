package mj_java_01.a10_数字.h_UUID类;

import java.util.UUID;

/**
 * 通用唯一标识符
 * 以后分布式开发中再说.
 */
public class AppTest {
    public static void main(String[] args) {
        //32个 16进制  32 * 4bit = 128bit 个位.
        System.out.println(UUID.randomUUID());
    }
}
