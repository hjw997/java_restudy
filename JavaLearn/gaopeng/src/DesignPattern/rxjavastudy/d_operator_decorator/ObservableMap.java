package DesignPattern.rxjavastudy.d_operator_decorator;


import DesignPattern.rxjavastudy.a_core.ObservableSource;
import DesignPattern.rxjavastudy.a_core.Observer;

/**
 * 某个调料类的具体实现
 * @param <T>
 * @param <U>
 */
public class ObservableMap<T,U> extends AbstractObservableWithUpStream<T,U>{
    private final Function<T,U> function;

    public ObservableMap(ObservableSource<T> source, Function<T, U> function) {
        super(source);
        this.function = function;
    }

    @Override
    protected void subscribeActual(Observer<U> observer) {
        //source.subscribe(observer);
        MapObserver mapObserver = new MapObserver(observer,function);
        source.subscribe(mapObserver);
    }

    /// 定义MapObserver ：命名：操作符开头 Observer结尾
    static class MapObserver<T,U> implements Observer<T> {
        /// 持有一个下游的观察者
        private final Observer<U> downStream;

        /// 持有一个 要操作的 对象
        private final Function<T,U> function;

        MapObserver(Observer<U> downStream, Function<T, U> function) {
            this.downStream = downStream;
            this.function = function;
        }


        @Override
        public void onSubscribe() {
            downStream.onSubscribe();
        }

        @Override
        public void onNext(T t) {
            /// Map的核心就是这里 执行完转换后 再传给 下游的 观察者
            U u = function.apply(t);
            downStream.onNext(u);
        }

        @Override
        public void onComplete() {
            downStream.onComplete();
        }

        @Override
        public void onError(Throwable throwable) {
            downStream.onError(throwable);
        }
    }
}
