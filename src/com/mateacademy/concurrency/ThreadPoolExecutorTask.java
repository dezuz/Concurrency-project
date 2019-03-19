package com.mateacademy.concurrency;

import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorTask implements Runnable {
    private String name;

    public ThreadPoolExecutorTask(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void run() {
        try {
            long duration = (long) (Math.random() * 10);
            System.out.println("Executing : " + name);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
