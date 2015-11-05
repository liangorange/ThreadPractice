package com.liangorange.threadOne;

/**
 * Created by liangorange on 10/16/15.
 */
public class Runner extends Thread {

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
