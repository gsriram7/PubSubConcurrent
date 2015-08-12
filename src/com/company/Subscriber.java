package com.company;

public class Subscriber extends Executable {
    private MessageBroker messageBroker;

    public Subscriber(MessageBroker messageBroker, int NTHREADS) {
        super(NTHREADS, "Subscriber");
        this.messageBroker = messageBroker;
    }

    public void execute() {
        executionStart = System.currentTimeMillis();
        for (int i = 0; i < threads.length; i++) {
            Runnable subscriber = new MySubscribable(""+i, messageBroker);
            threads[i] = new Thread(subscriber);
            threads[i].start();
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("["+this.name+"] Time taken for execution: "+(System.currentTimeMillis()-executionStart));;
    }


}
