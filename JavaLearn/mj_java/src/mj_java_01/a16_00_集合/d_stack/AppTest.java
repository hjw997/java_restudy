package mj_java_01.a16_00_集合.d_stack;

import java.util.Stack;

public class AppTest {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(11);
        stack.push(22);
        stack.push(33);
        Integer peek = stack.peek();//peek 偷偷看一眼, 返回栈顶元素.
        System.out.println(peek); //查看栈顶元素

        int index = stack.search(11);//返回 11 的索引 . 3
        System.out.println(index);

        //不断地弹出栈顶元素.
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
        //往一端操作.
    }
}
