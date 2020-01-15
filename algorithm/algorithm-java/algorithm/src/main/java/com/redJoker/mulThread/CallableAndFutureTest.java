package com.redJoker.mulThread;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class CallableAndFutureTest {
    public static void main(String[] args) {
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return new Random().nextInt(100);
            }
        };
        FutureTask<Integer> futureTask = new FutureTask<Integer>(callable);
        new Thread(futureTask).start();
        try {
            Thread.sleep(1000);
            System.err.println(futureTask.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
