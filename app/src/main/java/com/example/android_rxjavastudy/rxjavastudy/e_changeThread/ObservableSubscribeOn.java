package com.example.android_rxjavastudy.rxjavastudy.e_changeThread;

import com.example.android_rxjavastudy.rxjavastudy.a_core.ObservableSource;
import com.example.android_rxjavastudy.rxjavastudy.a_core.Observer;
import com.example.android_rxjavastudy.rxjavastudy.d_operator_decorator.AbstractObservableWithUpStream;
import com.example.android_rxjavastudy.rxjavastudy.e_changeThread.scheduler.Scheduler;

/**
 * 线程切换就不做 数据类型的转换 ，给什么泛型类型 后续的 就是 什么类型
 * @param <T>
 * @param <T>
 */
public class ObservableSubscribeOn<T>  extends AbstractObservableWithUpStream<T,T> {

    final Scheduler scheduler;
    @Override
    protected void subscribeActual(Observer<T> observer) {

        Scheduler.Worker worker = scheduler.createWorker();

        worker.scheduler(new SubscribeTask(new SubscribeOnObserver<>(observer)));

    }

    public ObservableSubscribeOn(ObservableSource<T> source,  Scheduler scheduler) {
        super(source);
        this.scheduler = scheduler;
    }

   static class SubscribeOnObserver<T>  implements Observer<T> {
        final  Observer<T>  downSteam;

       SubscribeOnObserver(Observer<T> downSteam) {
           this.downSteam = downSteam;
       }

       @Override
       public void onSubscribe() {
           downSteam.onSubscribe();
       }

       @Override
       public void onNext(T t) {
           downSteam.onNext(t);
       }

       @Override
       public void onComplete() {
            downSteam.onComplete();
       }

       @Override
       public void onError(Throwable throwable) {
            downSteam.onError(throwable);
       }
   }

    final class SubscribeTask implements Runnable {

        /// 持有观察者
        final SubscribeOnObserver<T> parent;

        SubscribeTask(SubscribeOnObserver<T> parent) {
            this.parent = parent;
        }

        @Override
        public void run() {
            source.subscribe(parent);
        }
    }

}
