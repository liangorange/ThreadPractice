package com.liangorange.threadPracticeOne;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by liangorange on 10/16/15.
 */
public class ThreadPracticeOne {

    Random random = new Random();

    // Two object can have two intransit locks for two different kitchens
    private Object lockOne = new Object();
    private Object lockTwo = new Object();


    List<Integer> prepareList = new ArrayList<>();
    List<Integer> cookList = new ArrayList<>();


    public void prepareIngredience() {

        synchronized(lockOne) {

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            prepareList.add(random.nextInt(100));
            System.out.println("Waiting to be able to cook tacos");

            synchronized (lockTwo) {
                System.out.println("Start cooking taco process");
            }
        }
    }

    public void cookTacos() {

        synchronized (lockTwo) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            cookList.add(random.nextInt(100));
            System.out.println("Waiting for people to prepare for more tacos");

            synchronized (lockOne) {
                System.out.println("Starting preparing taco process");
            }
        }
    }


    public void process() {
        for (int i = 0; i < 20; i++) {
            prepareIngredience();
            cookTacos();
        }
    }


    public static void main(String[] args) {

        ThreadPracticeOne temp = new ThreadPracticeOne();

        System.out.println("Start Process Time: " );


        long start = System.currentTimeMillis();

        // temp.process();


        Thread kitchenOne = new Thread(new Runnable() {

            @Override
            public void run() {

                temp.process();

            }
        });

        Thread kitchenTwo = new Thread(new Runnable() {

            @Override
            public void run() {

                temp.process();

            }
        });

        kitchenOne.start();
        kitchenTwo.start();


        try {
            kitchenOne.join();
            kitchenTwo.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        long end = System.currentTimeMillis();

        System.out.println("Time takes: " + (end - start));

        System.out.println("Number of taco prepared: " + temp.getPrepareList().size());
        System.out.println("Number of taco cooked: " + temp.getCookList().size());
    }



    public List<Integer> getPrepareList() {
        return prepareList;
    }

    public void setPrepareList(List<Integer> prepareIngredience) {
        this.prepareList = prepareIngredience;
    }

    public List<Integer> getCookList() {
        return cookList;
    }

    public void setCookList(List<Integer> cookTaco) {
        this.cookList = cookTaco;
    }


}

/*
// In order to run this method, you have to acquired the lockOne object
// If someone already using it, you can't use it until someone finished it
synchronized(lockOne) {

    try {
        Thread.sleep(100);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }

    prepareList.add(random.nextInt(100));
}
 */