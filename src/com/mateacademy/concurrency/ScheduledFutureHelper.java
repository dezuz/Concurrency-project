package com.mateacademy.concurrency;

public class ScheduledFutureHelper implements Runnable {

    @Override
    public void run() {
        System.out.println("Thread " + Thread.currentThread().getName() + " started.");

        System.out.println("Thread has been finished his work.");
    }
}
