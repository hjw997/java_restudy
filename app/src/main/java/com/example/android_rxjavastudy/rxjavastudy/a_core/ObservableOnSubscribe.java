package com.example.android_rxjavastudy.rxjavastudy.a_core;

/**
 * 被观察者 和 发射器 建立关系的. 通过接口定义以后扩展性更好.
 * 相当于一个被观察者 只有一个 这个 ObservableOnSubscribe 接口对象。然后，这个方法会传入一个发射器的实现类。
 * @param <T>
 */
public interface ObservableOnSubscribe<T> {
    void subscribe(Emitter<T> emitter); /// 其实个人觉得如果这里起个名字叫 setEmitter 更好理解。 就是设置传入一个 发射器。
    /**
     * 发射器 的最终实现 是会持有一个观察者的引用.
     *
     */
}
