package com.company;

public class MyPublishable implements Runnable {

    private final String publisherId;
    private MessageBroker messageBroker;
    private int numMessages = 10;

    public MyPublishable(String publisherId, MessageBroker messageBroker, int numMessages) {
        this.publisherId = publisherId;
        this.messageBroker = messageBroker;
        this.numMessages = numMessages;
    }

    @Override
    public void run() {
        for (int i = 0; i < numMessages; i++) {
            messageBroker.messageQueue.add("thread: " + publisherId + ", message: " + i);
        }
        messageBroker.messageQueue.add("End");
    }
}
