package mj_java_01.a17_IO.a_File.c_练习_搜索_删除_剪切;

import org.junit.Test;

import java.io.File;
import java.util.function.Consumer;

public class AppTest {
    private static final String ioTestRootPath  = "/Users/whj/Desktop/io_test";
    public static void main(String[] args) {
        /**
         * 请看工具类 Files 里面 的方法封装.
         * 和下面的测试方法.
         */
    }

    @Test
    public void testSearch() {
        Files.search(new File(ioTestRootPath + "/ing"), new Consumer<File>() {
            @Override
            public void accept(File file) {
                System.out.println(file);
            }
        });
    }

    @Test
    public void testMove() {
        Files.move(new File(ioTestRootPath +"/ing"),new File(ioTestRootPath + "/a/b/c/d"));
    }

    @Test
    public void testDelete() {
        Files.delete(new File(ioTestRootPath));
    }
    @Test
    public void testClean() {
        Files.clean(new File(ioTestRootPath));
    }
}
