package mj_java_01.a08_匿名类_lambda表达式.b_匿名类用途.util;

import java.util.ArrayList;


/**
 * 3.文件过滤器 工具
 */
public class Files {
    public interface Filter {
        //是否接受这个文件:
        boolean accept(String fileName);
    }


    public static ArrayList<String> getAllFileNames(String dir, Filter filter) {
        //1.获取 dir 下的 所有文件
        String[] fileNameList = getFileNameList(dir);

        ArrayList<String> filteredFiles = new ArrayList<>();
        //2.遍历过滤器
        for (String filename : fileNameList) {
            //调用外部传入的 过滤器 看是否接受 这个文件.
             if (filter.accept(filename)){
                 filteredFiles.add(filename);
             }
        }
        return filteredFiles;
    }

    private static String[] getFileNameList(String dir) {
        //模拟获取了 dir 下的所有文件:
        return new String[]{"abc.txt","AppTest.java","类的概念.md"};
    }
}
