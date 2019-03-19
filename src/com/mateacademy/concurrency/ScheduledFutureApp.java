package com.mateacademy.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledFutureApp extends Thread{
    private ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
    private ExecutorService executorService = Executors.newFixedThreadPool(1);

    public static void main(String[] args) {
        ScheduledFutureApp scheduledFutureApp = new ScheduledFutureApp();
        ScheduledFutureHelper scheduledFutureHelper = new ScheduledFutureHelper();
        ScheduledFutureHelper scheduledFutureHelper2 = new ScheduledFutureHelper();

        Thread myThread2 = new Thread(scheduledFutureHelper2);
        myThread2.start();

        scheduledFutureApp.executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("Executor Service is working.");
            }
        });

        scheduledFutureApp.executorService.shutdown();

        scheduledFutureApp.scheduledExecutorService.schedule(scheduledFutureHelper,3, TimeUnit.SECONDS);

        scheduledFutureApp.scheduledExecutorService.shutdown();
    }
}
