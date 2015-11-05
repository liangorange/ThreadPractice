package com.liangorange.threadThree;

/**
 * Created by liangorange on 10/16/15.
 */
public class ThreadThree {

    private int count = 0;


    public synchronized void increment() {
        count++;
    }


    public static void main(String[] args) {

        ThreadThree temp = new ThreadThree();

        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {

                for (int i = 1; i <= 1000; i++) {

                    // temp.count++;
                    temp.increment();
                }
            }
        });


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 1; i <= 1000; i++) {

                    // temp.count++;
                    temp.increment();
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



        System.out.println("Count: " + temp.count);
    }


}
