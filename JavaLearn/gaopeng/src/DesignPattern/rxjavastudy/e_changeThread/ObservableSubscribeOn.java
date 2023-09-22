package DesignPattern.rxjavastudy.e_changeThread;

import DesignPattern.rxjavastudy.a_core.Observer;
import DesignPattern.rxjavastudy.d_operator_decorator.AbstractObservableWithUpStream;

/**
 * 线程切换就不做 数据类型的转换 ，给什么泛型类型 后续的 就是 什么类型
 * @param <T>
 * @param <T>
 */
public class ObservableSubscribeOn<T,T>  extends AbstractObservableWithUpStream<T,T> {


    @Override
    protected void subscribeActual(Observer<T> observer) {

    }
}
