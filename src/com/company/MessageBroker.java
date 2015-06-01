package com.company;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class MessageBroker {
    public Queue<String> messageQueue = new ConcurrentLinkedQueue<>();
}
