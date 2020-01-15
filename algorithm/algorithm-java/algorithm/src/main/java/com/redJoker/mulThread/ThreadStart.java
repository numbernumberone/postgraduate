package com.redJoker.mulThread;

public class ThreadStart {
    public static void main(String[] args) {
//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(Thread.currentThread().getName());
//            }
//        });

        MyThread myThread = new MyThread();
        myThread.start();
        System.out.println("-->" + Thread.currentThread().getName());
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}