package com.mateacademy.concurrency;

public class ForkJoinPoolApp {

    public static void main(String[] args) {
        ForkJoinPoolLogic forkJoinPoolLogic = new ForkJoinPoolLogic();
        int[] array = new int[1_000_000];
        Integer max = forkJoinPoolLogic.getForkJoinPool().invoke(new ForkJoinPoolLogic(array, 0, array.length));
        System.out.println(max);
    }
}
