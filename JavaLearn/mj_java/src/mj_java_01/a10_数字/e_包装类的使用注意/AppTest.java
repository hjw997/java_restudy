package mj_java_01.a10_数字.e_包装类的使用注意;

public class AppTest {
    public static void main(String[] args) {
        /**
         * 基本类型数组 编译器不会 包装为  包装类型数组
         */

        int[] nums1 = {11, 22};
        //Integer[] nums3 = nums1; //❌  基本类型数组 编译器不会 包装为  包装类型数组

        //如果真想包装 需要编译器 做如下: 但是编译器不会做的.
        Integer[] nums2 = new Integer[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            nums2[i] = Integer.valueOf(nums1[i]);
        }
    }
}
