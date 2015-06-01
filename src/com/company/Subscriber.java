package com.company;

public class Subscriber implements Runnable {

    private final int NTHREADS;
    private MessageBroker messageBroker;

    public Subscriber(MessageBroker messageBroker, int NTHREADS) {
        this.NTHREADS = NTHREADS;
        this.messageBroker = messageBroker;
    }

    @Override
    public void run() {
        Thread[] threads = new Thread[NTHREADS];

        for (int i = 0; i < NTHREADS; i++) {
            Runnable subscriber = new MySubrcibable(""+i, messageBroker);
            threads[i] = new Thread(subscriber);
            threads[i].start();
        }

        for (Thread thread : threads) {
            if (thread.isAlive())
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
    }
}
