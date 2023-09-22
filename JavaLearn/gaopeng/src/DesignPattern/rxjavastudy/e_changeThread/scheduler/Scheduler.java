package DesignPattern.rxjavastudy.e_changeThread.scheduler;

public abstract class Scheduler  {
    public abstract Worker createWorker();

    public interface Worker {
        void scheduler(Runnable runnable);
    }
}
