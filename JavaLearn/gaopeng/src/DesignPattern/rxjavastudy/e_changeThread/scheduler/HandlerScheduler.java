package DesignPattern.rxjavastudy.e_changeThread.scheduler;

import java.util.logging.Handler;

public class HandlerScheduler extends Scheduler{
    private  final Handler handler;

    public HandlerScheduler(Handler handler) {
        this.handler = handler;
    }

    @Override
    public Worker createWorker() {
        return null;
    }

    static final class HnadlerWorker implements Worker {
        final Handler mapper;

        HnadlerWorker(Handler mapper) {
            this.mapper = mapper;
        }

        @Override
        public void scheduler(Runnable runnable) {
            /// 这部分请看安卓 rxjava study 因为 这个handler 的post是 安卓os 中的。
            //mapper.post
        }
    }
}
