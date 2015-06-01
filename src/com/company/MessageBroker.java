package com.company;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class MessageBroker {
    public Queue<String> messageQueue = new ArrayBlockingQueue<>(5000000);
}
