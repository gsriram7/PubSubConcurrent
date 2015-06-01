package com.company;

abstract public class Executable {

    protected final String name;
    protected long executionStart;
    Thread[] threads;

    public Executable(int N, String name) {
        this.threads = new Thread[N];
        this.name = name;
    }

    abstract public void execute();

    public void waitForCompletion() {
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("["+this.name+"] Time taken for execution: "+(System.currentTimeMillis()-executionStart));
    }
}
