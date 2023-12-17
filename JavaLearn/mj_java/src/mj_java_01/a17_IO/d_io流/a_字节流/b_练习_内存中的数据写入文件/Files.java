package mj_java_01.a17_IO.d_io流.a_字节流.b_练习_内存中的数据写入文件;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.function.Consumer;

public class Files {
    /**
     * 给顶一个目录,然后 遍历搜索, 把搜索到的传出到 外面传入的  Consumer 接口方法 方法
     * @param dir 外界传入进来的一个文件目录
     * @param operation 传出给外界
     */
    public static void search(File dir, Consumer<File> operation) {
        if (dir == null || operation == null) return;
        // 目录不存在, 或者 是个 文件. 也退出
        if (!dir.exists()) return;
        // 递归结束条件
        if (dir.isFile()) return;

        // 来到下面是个目录
        File[] subFiles = dir.listFiles();
        for (File subFile : subFiles) {
            //把遍历到的东西传出去.
            operation.accept(subFile);
            if (subFile.isDirectory()) {
                search(subFile,operation);
            }
        }

    }

    /**
     * 剪切: src 源路径  dest:目标路径
     */
    public static void move(File src, File dest) {
        if (src == null || dest == null) return;
        // 来源不存在 或者  目标已存在 也不做事
        if (!src.exists() || dest.exists()) return;

        //PS renameTo ❌注意这个有个坑, 就是如果dest 的父路径不存在就不会成功.
        //src.renameTo(dest);
        makeParentDir(dest);
        src.renameTo(dest);
    }

    private static void makeParentDir(File file) {
        //因为私有方法,内部调用 不再对 null 做判断
        File parentFile = file.getParentFile();
        //注意 这个理这个父路径 有可能是空的 比如 来个"H:" 盘,如果没有H盘
        //调用 null.xxx方法 会报 空指针异常
        if (parentFile == null) return; //严谨起见 加个 判空.

        if (parentFile.exists()) return;
        //比如父路径  /User/xxx/a/b/c/ 就会沿着路径把不存在的的目录都给创建了.
        parentFile.mkdirs(); //其实这个方法内部做了存在与否的判断. 所以上面的判断存在可以去了.
    }

    public static void delete(File file) {
        if (file == null || !file.exists()) return;
        /**
         * delete() 是删除文件 或者空目录
         */
        //if (file.isFile()) { file.delete(); return; }
        //其实👆🏻 这个不写也可以,最后一行的 delete 如果是文件或者空目录都会删除

        //清空文件夹
        clean(file);
        file.delete(); // 此时的是文件夹空的,才能删除
    }

    /**
     * clean 清空文件夹中的内容
     * 对外提供一个清空文件夹的方法, 所以内部最好判空.
     * @param dir
     */
    public static void clean(File dir) {
        if (dir == null || !dir.exists()) return;
        // 如果是个文件 ,不是文件夹,也直接返回.
        if (dir.isFile()) return;  //如果是个文件啥也不做,clean方法里面会有file.delete删除.

        //目录: 拿出遍历删除
        File[] subFiles = dir.listFiles();
        for (File subFile : subFiles) {
            delete(subFile);
        }
    }

    /**
     * 将内存中的数据写入文件
     * @param bytes 要写入的数据
     * @param file 要写入的文件
     */
    public static void write(byte[] bytes, File file) {
        if (bytes == null || file == null) return;
        if (file.exists()) return; //文件存在
        makeParentDir(file); //如果不创建父路径 会报错.

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            fos.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
