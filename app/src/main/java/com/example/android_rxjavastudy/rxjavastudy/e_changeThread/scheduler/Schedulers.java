package com.example.android_rxjavastudy.rxjavastudy.e_changeThread.scheduler;

import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.Executors;
import java.util.logging.Logger;

/**
 * 用来提供线程：
 */
public class Schedulers {
    private static Scheduler MAIN_THREAD;
    private static Scheduler NEW_THREAD;

    static {
        MAIN_THREAD = new HandlerScheduler(new Handler(Looper.getMainLooper()));

        NEW_THREAD = new NewThreadScheduler(Executors.newScheduledThreadPool(2));
    }

    public static Scheduler mainThread() {
        return MAIN_THREAD;
    }

    public static Scheduler newThread() {
        return NEW_THREAD;
    }

}
