package DesignPattern.rxjavastudy;

import DesignPattern.rxjavastudy.core.Emitter;
import DesignPattern.rxjavastudy.core.Observable;
import DesignPattern.rxjavastudy.core.ObservableOnSubscribe;
import DesignPattern.rxjavastudy.core.Observer;

public class AppTest {
    public static void main(String[] args) {
        rxjavaCore01();

    }
    /// Rx中Create操作符的使用 最核心的一个方法，第一步。
    public static void rxjavaCore01() {
        System.out.println("Rxjava---Core");
        /// create 参数就是我们动态的实现的一个接口ObservableOnSubscribe 的 实例。
        Observable.create(new ObservableOnSubscribe<Object>() {
            @Override
            public void subscribe(Emitter<Object> emitter) {
                emitter.onNext("abc1");
                emitter.onNext("abc2");
                emitter.onNext("abc3");
                emitter.onNext("abc4");
            }
        }).subscribe(new Observer<Object>() {
            @Override
            public void onSubscribe() {
                System.out.println("onSubscribe---在订阅");
            }

            @Override
            public void onNext(Object o) {
                System.out.println("onNext---:"+o.toString());
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete---");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("onError---");
            }
        });
    }
}
