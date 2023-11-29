package mj_java_01.a02_基础语法_part01;

import java.io.File;

/**
 * 此工具遍历 文件夹下 的文件 , 然后可以重新命名.
 */
public class FileRenameTools {
    public static void main(String[] args) {
        // /Users/xxx/Desktop/mj
        String path = "/Users/xxx/Desktop/MJ_java";        //要遍历的路径
        File file = new File(path);        //获取其file对象
        File[] fs = file.listFiles();    //遍历path下的文件和目录，放在File数组中
        assert fs != null;
        for (File f : fs) {                    //遍历File[]数组
            if (!f.isDirectory())    {

                String filePath = f.getAbsolutePath();
                String newName = filePath.replace("(P", "");
                newName = newName.replace(")","");
                System.out.println(filePath);
                boolean result = f.renameTo(new File(newName));
                System.out.println(result);

                // 删除掉 .xml 文件结尾的非视频文件.
//                if (filePath.endsWith("xml")) {
//                    f.delete();
//                }

            }

        }
    }
}