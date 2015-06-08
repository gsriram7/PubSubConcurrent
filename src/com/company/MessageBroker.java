package com.company;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class MessageBroker {
    private int alivePublisherThreads;
    public Queue<String> messageQueue = new ConcurrentLinkedQueue<>();

    public MessageBroker(int publisherThreads) {
        alivePublisherThreads = publisherThreads;
    }

    synchronized public boolean toContinue(String message) {
        if (message.equals("End"))
            --alivePublisherThreads;
        return alivePublisherThreads != 0;
    }
}
