package DesignPattern.rxjavastudy;

import DesignPattern.rxjavastudy.a_core.Emitter;
import DesignPattern.rxjavastudy.a_core.Observable;
import DesignPattern.rxjavastudy.a_core.ObservableOnSubscribe;
import DesignPattern.rxjavastudy.a_core.Observer;
import DesignPattern.rxjavastudy.d_operator_decorator.Function;
import org.junit.Test;

public class AppTest {
    public static void main(String[] args) {
        System.out.println("直接运行测试代码~~~~~");
    }


    /// Rx中Create操作符的使用 最核心的一个方法，第一步。
    @Test
    public  void rxjavaCreateCore01() {
        System.out.println("Rxjava---Create");
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
                System.out.println("onNext---:" + o.toString());
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

    @Test
    public  void rxjavaMapCore02() { ///@Test 两点注意：1.不能是静态方法。2.类得是 public 的
        System.out.println("Rxjava---Map");
        /// create 参数就是我们动态的实现的一个接口ObservableOnSubscribe 的 实例。
        Observable.create(new ObservableOnSubscribe<String>() {
                    @Override
                    public void subscribe(Emitter<String> emitter) {
                        emitter.onNext("abc1");
                        emitter.onNext("abc2");
                        emitter.onNext("abc3");
                        emitter.onNext("abc4");
                    }
                }).map(new Function<String, String>() {
                    @Override
                    public String apply(String s) {
                        return s + "+mapped";
                    }
                }).subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe() {
                        System.out.println("onSubscribe---在订阅");
                    }

                    @Override
                    public void onNext(String o) {
                        System.out.println("onNext---:" + o);
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
