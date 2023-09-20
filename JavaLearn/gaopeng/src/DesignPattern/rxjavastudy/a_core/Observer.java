package DesignPattern.rxjavastudy.a_core;

/**
 * 观察者的顶层接口
 * @param <T>
 */
public interface Observer<T> {

    void onSubscribe(); /// 建立订阅时候的回调.

    void onNext(T t);
    //为何叫onNext 因为.像流一下 一步一步往下
    //有点像 update() 不知具体发送什么数据类型 泛型

    void onComplete();

    void  onError(Throwable throwable);

}
