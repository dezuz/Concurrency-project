package com.mateacademy.concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureAndCallableApp {
    private FutureTask<String> futureTask;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable task = () -> {
            return "I am Callable, i am doing smth";
        };

        FutureAndCallableApp futureAndCallableApp = new FutureAndCallableApp();
        futureAndCallableApp.futureTask = new FutureTask<>(task);
        new Thread(futureAndCallableApp.futureTask).start();
        System.out.println(futureAndCallableApp.futureTask.get());
    }
}
