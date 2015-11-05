package com.liangorange.threadFour;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by liangorange on 10/20/15.
 */

class RunnerTwo implements Runnable {

    @Override
    public void run() {

        for (int i = 1; i <= 10; i++) {

            System.out.println("Count: " + i);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


public class ThreadFour {

    private int count = 0;

    public static void main(String[] args) {

        ThreadFour threadFour = new ThreadFour();



        // Race condition: when two threads try to access the same instance
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    threadFour.count++;
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    threadFour.count++;
                }
            }
        });



        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



        System.out.println("The end of both threads");
        System.out.println("Count Number: " + threadFour.count);
    }
}

