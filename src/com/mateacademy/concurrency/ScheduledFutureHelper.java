package com.mateacademy.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledFutureHelper implements Runnable {
    private static ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
    private static ExecutorService executorService = Executors.newFixedThreadPool(1);

    @Override
    public void run() {
        System.out.println("Thread " + Thread.currentThread().getName() + " started.");

        System.out.println("Thread has been finished his work.");

        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("Executor Service is working.");
            }
        });

        executorService.shutdown();

        scheduledExecutorService.schedule(new ScheduledFutureHelper(),3, TimeUnit.SECONDS);

        scheduledExecutorService.shutdown();
    }
}
