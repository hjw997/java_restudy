package mj_java_01.a17_IO.a_File.b_File常用方法;

import java.io.File;
import java.io.FilenameFilter;
import java.lang.reflect.Array;
import java.util.Arrays;

public class AppTest {
    public static void main(String[] args) {

        //项目里根目录下:
        File file = new File("1.txt"); //相对路劲
        System.out.println(file.getPath());
        System.out.println(file.getAbsolutePath());
        // ps 注意 坑:file.getParent()
        //System.out.println(file.getParent()); //❌ 坑:null
        System.out.println(file.getAbsoluteFile().getParent());

        File pFile = file.getAbsoluteFile().getParentFile();
        String[] list = pFile.list(); //
        System.out.println(Arrays.toString(list));

        //FilenameFilter
        String[] list1 = pFile.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                System.out.println(dir);
                System.out.println(name);
                return name.contains("java");
            }
        });
        System.out.println("=============================");
        System.out.println(Arrays.toString(list1));

        //renameTo 重命名 剪切:

    }
}
