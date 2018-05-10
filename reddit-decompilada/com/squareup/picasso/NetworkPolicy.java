package com.squareup.picasso;

public enum NetworkPolicy {
    NO_CACHE(1),
    NO_STORE(2),
    OFFLINE(4);
    
    final int f23802d;

    public static boolean m25770a(int i) {
        return (i & NO_CACHE.f23802d) == 0;
    }

    public static boolean m25771b(int i) {
        return (i & NO_STORE.f23802d) == 0;
    }

    public static boolean m25772c(int i) {
        return (i & OFFLINE.f23802d) != 0;
    }

    private NetworkPolicy(int i) {
        this.f23802d = i;
    }
}
