package com.mateacademy.concurrency;

public class ScheduledFutureApp {

    public static void main(String[] args) {
        ScheduledFutureHelper scheduledFutureHelper = new ScheduledFutureHelper();

        Thread myThread2 = new Thread(scheduledFutureHelper);
        myThread2.start();
    }
}
