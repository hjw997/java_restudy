package mj_java_01.a17_IO.d_io流.c_字符流.a_字符流;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.function.Consumer;

public class Files {
    /**
     * 给顶一个目录,然后 遍历搜索, 把搜索到的传出到 外面传入的  Consumer 接口方法 方法
     *
     * @param dir       外界传入进来的一个文件目录
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
                search(subFile, operation);
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
     *
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
     *
     * @param bytes 要写入的数据
     * @param file  要写入的文件
     */
    public static void write(byte[] bytes, File file) {
        if (bytes == null || file == null) return;
        if (file.exists()) return; //文件存在
        makeParentDir(file); //如果不创建父路径 会报错.

        //使用 try-with-resource Java 7 开始 ✅
        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 从文件读取内容到 内存. 无论文件是什么 读到内存中是 二进制数据,也就是 byte[] 字节数组.
     * 不管是什么文件 都可以读字节来. 文件里面就是 0101001 . 的二进制.
     */
    public static byte[] read(File file) {
        if (file == null || !file.exists()) return null;
        if (file.isDirectory()) return null; //如果是个目录也是没法读的.

        try (FileInputStream fis = new FileInputStream(file)) {
            //分配文件长度的字节数组.
            byte[] bytes = new byte[(int) file.length()];
            /**
             * 读取字节的过程中是不需要考虑 编码的问题.
             * 只有在 把字节转为 字符 , 或者 字符 转为 字节的时候才考虑编码方式 问题.
             */
            fis.read(bytes); //把文件读到这个数组中.
            return bytes;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    /**
     * 复制文件:原理 从文件 读 一段, 然后 写 一段到 文件 .
     */
    public static void copy(File src, File dest) {
        if (src == null || dest == null) return;
        if (dest.exists()) return; //目标文件存在也不拷贝
        if (src.isDirectory()) return; //暂时 只拷贝 文件.
        //还要考虑 目标文件中父路径问题.
        makeParentDir(dest);

        // 使用 try-with-resource 简化代码 ✅
        try (
                /**
                 * ⚠️PS 问下 这里如果使用 字符流 是否可以呢?
                 * 如果是拷贝文 本文件是 可以的 ✅
                 * 但是 如果拷贝的是非文本文件 如 mp3,视频等文件 那么使用字符流 是有问题的.❌
                 * 字符流 只用在 文件上. 只要文件内容不是 字符集编码 那么就 不能用字符流 ⚠️ .
                 */
                FileInputStream fis = new FileInputStream(src);
                FileOutputStream fos = new FileOutputStream(dest);
        ) {
            byte[] caches = new byte[8192];//8kb 的字节数组 当个缓存小桶
            int len;
            while ((len = fis.read(caches)) != -1) {
                //注意 只要是同一个fos对象,写的时候不管写多少都会追加到后面.
                fos.write(caches, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //好处不用再在finally 中 写 close 代码了.

    }
}

















