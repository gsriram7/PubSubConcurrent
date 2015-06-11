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
            try {
                messageBroker.messageQueue.put("thread: " + publisherId + ", message: " + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            messageBroker.messageQueue.put("End");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
