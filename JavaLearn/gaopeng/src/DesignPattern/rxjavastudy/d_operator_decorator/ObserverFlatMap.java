package DesignPattern.rxjavastudy.d_operator_decorator;

import DesignPattern.rxjavastudy.a_core.Observable;
import DesignPattern.rxjavastudy.a_core.ObservableSource;
import DesignPattern.rxjavastudy.a_core.Observer;

public class ObserverFlatMap<T, U> extends AbstractObservableWithUpStream<T, U> {

    private final Function<T, Observable<U> > function;


    public ObserverFlatMap(ObservableSource<T> source, Function<T, Observable<U>> function) {
        /// 注意这里的source是谁？在哪个被观察者的基础上，谁就是source
        /// source 是个被观察者，通过构造方法传入。
        super(source);
        this.function = function;
    }

    @Override
    protected void subscribeActual(Observer<U> observer) {
        /// 注意这里的source是谁？在哪个被观察者的基础上，谁就是source 
        /// 什么是 source ？ the place something comes from or starts at, or the cause of something
        ///source.subscribe();
        source.subscribe(new MergerObserver<>(observer,function));
    }

    static class MergerObserver<T,U> implements Observer<T> {
        /// 下游的观察者
        private  final Observer<U>  downStream;
        private final  Function<T, Observable<U>> mapper;

        public MergerObserver(Observer<U> downStream, Function<T, Observable<U> > mapper) {
            this.downStream = downStream;
            this.mapper = mapper;
        }


        @Override
        public void onSubscribe() {

        }

        @Override
        public void onNext(T t) {
            ///
            /// 调用外面的 apply 方法。
            Observable<U> observable = mapper.apply(t);
            observable.subscribe(new Observer<U>() {
                @Override
                public void onSubscribe() {
                    downStream.onSubscribe();
                }

                @Override
                public void onNext(U u) {
                    /// 这里才交给下游处理。
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
            });
        }

        @Override
        public void onComplete() {

        }

        @Override
        public void onError(Throwable throwable) {

        }
    }
}
