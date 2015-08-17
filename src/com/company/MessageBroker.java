package com.company;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class MessageBroker {
    private AtomicInteger alivePublisherThreads;
    public ArrayBlockingQueue<String> messageQueue = new ArrayBlockingQueue<>(10000000);

    public MessageBroker(int publisherThreads) {
        alivePublisherThreads = new AtomicInteger(publisherThreads);
    }

    public boolean toContinue(String message) {
        if (message.equals("End"))
            alivePublisherThreads.decrementAndGet();
        return !alivePublisherThreads.equals(0);
    }
}
