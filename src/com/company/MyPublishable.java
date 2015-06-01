package com.company;

public class MyPublishable implements Runnable {

    private final String publisherId;
    private MessageBroker messageBroker;

    public MyPublishable(String publisherId, MessageBroker messageBroker) {
        this.publisherId = publisherId;
        this.messageBroker = messageBroker;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            messageBroker.messageQueue.add("thread: "+ publisherId +", message: "+i);
        }
        messageBroker.messageQueue.add("End");
    }
}
