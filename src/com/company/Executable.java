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
}
