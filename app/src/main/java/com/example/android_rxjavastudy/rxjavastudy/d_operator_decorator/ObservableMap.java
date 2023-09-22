package com.example.android_rxjavastudy.rxjavastudy.d_operator_decorator;


import com.example.android_rxjavastudy.rxjavastudy.a_core.ObservableSource;
import com.example.android_rxjavastudy.rxjavastudy.a_core.Observer;

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
        /// 要创建一个新的 Observer ，持有下游的 observer ，然后处理事情后再交给下游。
        MapObserver mapObserver = new MapObserver(observer,function);
        source.subscribe(mapObserver);
    }

    /// 定义MapObserver ：命名：操作符开头 Observer结尾
    static class MapObserver<T,U> implements Observer<T> {
        /// 持有一个下游的观察者
        private final Observer<U> downStream;

        /// 持有一个 要操作的 对象
        private final Function<T,U> mapper;

        MapObserver(Observer<U> downStream, Function<T, U> function) {
            this.downStream = downStream;
            this.mapper = function;
        }


        @Override
        public void onSubscribe() {
            downStream.onSubscribe();
        }

        @Override
        public void onNext(T t) {
            /// Map的核心 就是这里 做一次转换操作。
            U u = mapper.apply(t);
            // 执行完转换后 再传给 下游的 观察者
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
