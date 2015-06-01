package com.company;

public class Publisher extends Executable {
    private final int numMessages;
    private MessageBroker messageBroker;


    public Publisher(MessageBroker messageBroker, int NTHREADS, int numMessages) {
        super(NTHREADS, "Publisher");
        this.messageBroker = messageBroker;
        this.numMessages = numMessages;
    }

    public void execute() {
        executionStart = System.currentTimeMillis();
        for (int i = 0; i < threads.length; i++) {
            Runnable publish = new MyPublishable("#"+i, messageBroker, numMessages);
            threads[i] = new Thread(publish);
            threads[i].start();
        }
    }

}
