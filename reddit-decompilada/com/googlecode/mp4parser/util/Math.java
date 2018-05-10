package com.googlecode.mp4parser.util;

public class Math {
    public static long m7712a(long j, long j2) {
        long j3 = j;
        long j4 = j2;
        while (j4 > 0) {
            long j5 = j4;
            j4 = j3 % j4;
            j3 = j5;
        }
        return j * (j2 / j3);
    }
}
