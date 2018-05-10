package com.google.common.collect;

final class Hashing {
    static int m7112a(int i) {
        return (int) (461845907 * ((long) Integer.rotateLeft((int) (((long) i) * -862048943), 15)));
    }

    static int m7113a(Object obj) {
        return m7112a(obj == null ? null : obj.hashCode());
    }

    static int m7114b(int i) {
        i = Math.max(i, 2);
        int highestOneBit = Integer.highestOneBit(i);
        if (i <= ((int) (1.0d * ((double) highestOneBit)))) {
            return highestOneBit;
        }
        i = highestOneBit << 1;
        return i > 0 ? i : 1073741824;
    }
}
