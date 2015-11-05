package com.liangorange.threadTwo;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by liangorange on 10/16/15.
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


public class ThreadTwo {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(5);

        // Don't do this, this is dumbed
        //Thread t1 = new Thread(new RunnerTwo());
        //Thread t2 = new Thread(new RunnerTwo());


        executor.execute(new RunnerTwo());
        executor.execute(new RunnerTwo());

        executor.shutdown();

        if (executor.isTerminated()) {
            System.out.println("All Threads are finished");
        }

        /*
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        */


        System.out.println("The end of both threads");


    }



}
