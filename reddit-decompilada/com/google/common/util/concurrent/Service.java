package com.google.common.util.concurrent;

public interface Service {

    public enum State {
        ;

        abstract boolean isTerminal();
    }
}
