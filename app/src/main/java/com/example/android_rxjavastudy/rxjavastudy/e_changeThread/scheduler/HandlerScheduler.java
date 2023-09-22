package com.example.android_rxjavastudy.rxjavastudy.e_changeThread.scheduler;


import android.os.Handler;

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
            mapper.post(runnable);
        }
    }
}
