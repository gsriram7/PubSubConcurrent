package com.company;

public class Publisher implements Runnable {

    private final int NTHREADS;
    private MessageBroker messageBroker;

    public Publisher(MessageBroker messageBroker, int NTHREADS) {
        this.messageBroker = messageBroker;
        this.NTHREADS = NTHREADS;
    }

    @Override
    public void run() {
        Thread[] threads = new Thread[NTHREADS];

        for (int i = 0; i < NTHREADS; i++) {
            Runnable publish = new MyPublishable("#"+i, messageBroker);
            threads[i] = new Thread(publish);
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
