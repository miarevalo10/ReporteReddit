package com.google.common.collect;

import java.util.ArrayDeque;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class Queues {
    public static <E> ArrayDeque<E> m7250a() {
        return new ArrayDeque();
    }

    public static <E> ConcurrentLinkedQueue<E> m7251b() {
        return new ConcurrentLinkedQueue();
    }
}
