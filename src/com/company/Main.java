package com.company;

public class Main {

    public static void main(String[] args) {

        MessageBroker messageBroker = new MessageBroker();

        Thread[] pool = new Thread[2];

        Runnable publisher = new Publisher(messageBroker, 5);
        pool[0] = new Thread(publisher);

        Runnable subscriber = new Subscriber(messageBroker, 5);
        pool[1] = new Thread(subscriber);

        pool[0].start();
        pool[1].start();

        for (Thread threadPool : pool) {
            try {
                threadPool.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
