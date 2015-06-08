package com.company;

public class Main {

    public static void main(String[] args) {
        int publisherThreads = 5;
        int subscriberThreads = 5;
        MessageBroker messageBroker = new MessageBroker(publisherThreads);
        int numMessages = 70 / publisherThreads;
        Publisher publisher = new Publisher(messageBroker, publisherThreads, numMessages);
        Subscriber subscriber = new Subscriber(messageBroker, subscriberThreads);

        long start = System.currentTimeMillis();
        publisher.execute();
        subscriber.execute();

        publisher.waitForCompletion();
        subscriber.waitForCompletion();
        System.out.println("Total "+(System.currentTimeMillis() - start));
    }
}
