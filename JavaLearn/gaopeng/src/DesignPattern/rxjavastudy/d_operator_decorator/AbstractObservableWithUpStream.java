package DesignPattern.rxjavastudy.d_operator_decorator;

import DesignPattern.rxjavastudy.a_core.Observable;
import DesignPattern.rxjavastudy.a_core.ObservableSource;

/**
 * 装饰类的顶层类：也就是调料类，调料类也是一种饮料
 * 泛型参数：T 进入的，U 操作后的给下游的。
 * @param <T> 入参
 * @param <U> 处理完以后得类型
 */
abstract class AbstractObservableWithUpStream<T,U> extends Observable<U> {
    ///调料类持有一个饮料（被修饰的类）。
    /// 注意这里的source是谁？在哪个被观察者的基础上，谁就是 source
    /// 什么是 source ？ the place something comes from or starts at, or the cause of something
   protected final  ObservableSource<T> source; ///protected 让所有子类能访问。

    AbstractObservableWithUpStream(ObservableSource<T> source) {
        this.source = source;
    }
}
