package com.company;

import java.util.concurrent.ArrayBlockingQueue;

public class MessageBroker {
    private int alivePublisherThreads;
    public ArrayBlockingQueue<String> messageQueue = new ArrayBlockingQueue<>(10000000);

    public MessageBroker(int publisherThreads) {
        alivePublisherThreads = publisherThreads;
    }

    synchronized public boolean toContinue(String message) {
        if (message.equals("End"))
            --alivePublisherThreads;
        return alivePublisherThreads != 0;
    }
}
