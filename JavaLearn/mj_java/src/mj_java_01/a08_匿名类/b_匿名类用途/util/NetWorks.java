package mj_java_01.a08_匿名类.b_匿名类用途.util;

/**
 * 网络请求工具类
 */
public class NetWorks {
     public interface Block {
         void success(Object json);

         void failure(Throwable throwable);
     }

    public static void get(String url, Block callback) {

         //异步线程模拟网络请求耗时操作

         //拿到结果
        boolean result = false;
        if (result) {
            Object response = null;
            callback.success(response);
        } else {
            callback.failure(new Throwable("请求错误"));
        }
    }
}
