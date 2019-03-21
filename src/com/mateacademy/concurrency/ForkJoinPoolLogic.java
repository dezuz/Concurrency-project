package com.mateacademy.concurrency;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class ForkJoinPoolLogic extends RecursiveTask<Integer> {
    private static ForkJoinPool forkJoinPool = new ForkJoinPool();
    private int[] array;
    private int start;
    private int end;

    public ForkJoinPoolLogic() {
    }

    public ForkJoinPoolLogic(int[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
            arrayInit(array);
    }

    public ForkJoinPool getForkJoinPool() {
        return  forkJoinPool;
    }
    private int[] arrayInit(int[] array) {
        for (int i = 0; i < this.end; i++) {
            array[i] = i;
        }
        return array;
    }

    @Override
    protected Integer compute() {
        if (end - start <= 3000) {
            int max = -99;
            for (int i = start; i < end; i++) {
                max = Integer.max(max, array[i]);
            }
            return max;

        } else {
            int mid = (end - start) / 2 + start;
            ForkJoinPoolLogic left = new ForkJoinPoolLogic(array, start, mid);
            ForkJoinPoolLogic right = new ForkJoinPoolLogic(array, mid + 1, end);

            ForkJoinTask.invokeAll(right, left);
            int leftRes = left.getRawResult();
            int rightRes = right.getRawResult();

            return Integer.max(leftRes, rightRes);
        }
    }

    public static void main(String[] args) {
        int[] array = new int[1_000_000];
        Integer max = forkJoinPool.invoke(new ForkJoinPoolLogic(array, 0, array.length));
        System.out.println(max);

    }
}
