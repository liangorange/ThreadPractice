package com.liangorange.threadOne;

public class Main {

    public static void main(String[] args) {

        Runner runnerOne = new Runner();
        runnerOne.start();

        Runner runnerTwo = new Runner();
        runnerTwo.start();


        /*
        try {
            runnerOne.join();
            runnerTwo.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        */
    }
}
