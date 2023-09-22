package com.example.android_rxjavastudy.rxjavastudy.a_core;

/**
 * 被观察者 的顶层 接口.
 */
public interface ObservableSource<T> {

    /***
     * 和观察者 建立订阅关系的.
     * 就跟标准观察者模式中的 addObserver 一样
     */
    void subscribe(Observer<T> observer); //标准模式中的 addObserver
}
