package DesignPattern.rxjavastudy.b_observableimpl;


import DesignPattern.rxjavastudy.a_core.Emitter;
import DesignPattern.rxjavastudy.a_core.Observable;
import DesignPattern.rxjavastudy.a_core.ObservableOnSubscribe;
import DesignPattern.rxjavastudy.a_core.Observer;

/**
 * 被观察者 的具体实现. 命名方式: ObservableXXXX 如 ObservableMap,ObservableCreate
 */
public class ObservableCreate<T> extends Observable<T> {

    /// 被观察者要持有一个发射器，但是这个发射器哪里来呢？这里持有一个 ObservableOnSubscribe 对象。
    /// ObservableOnSubscribe 的 接口中定义的方法
    final ObservableOnSubscribe<T> source; /// final 修饰只能初始化一次.

    public ObservableCreate(ObservableOnSubscribe<T> source) {
        /// 该被观察者 持有一个 source 对象， 在创建的时候。 在和 观察者 订阅的时候 走 subscribeActual
        this.source = source;
    }


    @Override
    protected void subscribeActual(Observer<T> observer) {
        ///  记住这个方法就是 标准观察者中的 addObserver.
        ///  建立关系: 观察者 和 被观察者 还有事件发射源之间的关系的.

        ///  建立订阅 调用 observer的 onSubscribe方法.
        observer.onSubscribe();

        ///  创建发射器 发射器持有 一个观察者。
        CreateEmitter<T> emitter = new CreateEmitter<T>(observer);
        ///  source 哪里来的构造方法传入的一个，通过这个source.subscribe 设置一个发射器。
        source.subscribe(emitter);

    }

    /// 具体的事件发射器:
    /// 为何使用 static class 看知识点补充: 静态嵌套类-知识点.

    /**
     * 具体的事件发射器:名称以事件名称开头(具体的被观察者的实现名字) ObservableCreate的 Create
     * @param <T>
     */
    static class CreateEmitter<T> implements Emitter<T> {
        final Observer<T> observer; ///发射器要持有一个 观察者,调用观察者的 update()通知更新数据 ,此处就是onNext.

        boolean done; /// 标记事件是不是完成 所以 onComplete 和 onError 互斥.

        CreateEmitter(Observer<T> observer) {
            this.observer = observer;
        }

        @Override
        public void onNext(T t) {
            if (done) return;
            //事件产生的时候,直接调用观察者的update()方法.
            observer.onNext(t);
        }

        @Override
        public void onComplete() {
            if (done) return;
            observer.onComplete();
            done = true;
        }

        @Override
        public void onError(Throwable throwable) {
            if (done) return;
            observer.onError(throwable);
            done = true;
        }

    }


}
