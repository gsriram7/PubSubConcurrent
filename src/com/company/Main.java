package com.company;

public class Main {

    public static void main(String[] args) {
        int publisherThreads = 50;
        int subscriberThreads = 50;
        MessageBroker messageBroker = new MessageBroker(publisherThreads);
        int numMessages = 5000000 / publisherThreads;
        Publisher publisher = new Publisher(messageBroker, publisherThreads, numMessages);
        Subscriber subscriber = new Subscriber(messageBroker, subscriberThreads);

        long start = System.currentTimeMillis();
        publisher.execute();
        subscriber.execute();

        System.out.println("Total "+(System.currentTimeMillis() - start));
    }
}
