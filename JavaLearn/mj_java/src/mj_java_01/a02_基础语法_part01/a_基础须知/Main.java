package mj_java_01.a02_基础语法_part01.a_基础须知;

/**
 * 基础 语法须知:
 * main 方法(函数->方法) 程序的入口.
 * java 中的方法,就是其他编程语言中的函数
 * 程序的入口是main方法:
 *    没有main方法,Java程序是无法启动的.
 *    方法必须包含在class内部, 先有class,再有方法
 *
 * public class 修饰的类 的名称必须要和文件名保持一致.
 *
 * 左大括号在 方法结尾.
 *
 * 有多个 main 方法 只能选择其中的一个 去运行.
 *
 * 注释 :
 *     单行注释
 *     多行注释
 *     文档注释:解释方法 类的用途. / + 两个 ** 就可以生成
 *
 */
public class Main {

    public static void main(String[] args) { //左大括号推荐.
        System.out.println("Hello world!");
    }
}