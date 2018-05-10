package com.squareup.picasso;

public enum MemoryPolicy {
    NO_CACHE(1),
    NO_STORE(2);
    
    final int f23797c;

    public static boolean m25768a(int i) {
        return (i & NO_CACHE.f23797c) == 0;
    }

    static boolean m25769b(int i) {
        return (i & NO_STORE.f23797c) == 0;
    }

    private MemoryPolicy(int i) {
        this.f23797c = i;
    }
}
