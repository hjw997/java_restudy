package com.example.android_rxjavastudy.rxjavastudy.a_core;

import com.example.android_rxjavastudy.rxjavastudy.b_observableimpl.ObservableCreate;
import com.example.android_rxjavastudy.rxjavastudy.d_operator_decorator.Function;
import com.example.android_rxjavastudy.rxjavastudy.d_operator_decorator.ObservableMap;
import com.example.android_rxjavastudy.rxjavastudy.d_operator_decorator.ObserverFlatMap;
import com.example.android_rxjavastudy.rxjavastudy.e_changeThread.ObservableSubscribeOn;
import com.example.android_rxjavastudy.rxjavastudy.e_changeThread.scheduler.Scheduler;

/***
 * 被观察者的核心抽象类
 * 也是使用框架的入口.
 */
abstract  public class Observable<T> implements ObservableSource<T> {
    @Override
    public void subscribe(Observer<T> observer) {
        /// 和谁建立订阅?
        //  怎么建立订阅?
        //  为了保证拓展性交给子类或者开发人员去实现.
        subscribeActual(observer);
    }

    protected abstract void subscribeActual(Observer<T> observer);

    /// 创建一个 create 操作符 就是被观察者。
    /// java 静态方法的泛型不能使用类的泛型，需要定义为 方法的泛型。
    /// 参数为一个 ObservableOnSubscribe 接口的实例。
    /// ObservableOnSubscribe 是调用的时候动态的实现的。
    public static <T> Observable<T> create(ObservableOnSubscribe<T> source) {
        /// 这里的source 是指的是事件的源头。和那个 调料抽象类（AbstractObservableWithUpStream）中的有source 不是一个。
        return new ObservableCreate<>(source);
    }

    /// 创建一个 map 操作符 map 操作符是个对象的实例方法 不在需要是静态方法了

    /**
     * map操作符
     * @param function 要做的具体操作的实例对象，开发中可用lambda 表达式等。
     * @return 包装了原来的被观察者的 新的被观察者
     * @param <U> map 操作符以后 返回的类
     */
    public <U> ObservableMap<T, U> map(Function<T,U> function) {
       return new ObservableMap(this, function);
    }

    /**
     * flatMap 操作符
     * @param function
     * @return
     * @param <U>
     */
    public <U> ObserverFlatMap<T, U> flatMap(Function<T,Observable<U>> function) {

        return new ObserverFlatMap(this, function);
    }

    public ObservableSubscribeOn<T> subscribeOn(Scheduler scheduler) {

        return new ObservableSubscribeOn<T>(this , scheduler);
    }


    //todo : 线程池 ？？？？
    //todo : Handler 使用？？？？


}