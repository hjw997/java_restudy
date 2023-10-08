package com.example.android_rxjavastudy.rxjavastudy.e_changeThread.scheduler;

import java.util.concurrent.ExecutorService;

public class NewThreadScheduler extends Scheduler {
    final ExecutorService executorService;

    public NewThreadScheduler(ExecutorService executorService) {
        this.executorService = executorService;
    }

    @Override
    public Worker createWorker() {
        return new NewThreaWorker(executorService);
    }

    static final class NewThreaWorker implements  Worker {
        final ExecutorService mapper ;

        NewThreaWorker(ExecutorService mapper) {
            this.mapper = mapper;
        }

        @Override
        public void scheduler(Runnable runnable) {
            mapper.execute(runnable);
        }
    }
}
