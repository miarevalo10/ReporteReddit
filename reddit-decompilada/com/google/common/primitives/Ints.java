package com.google.common.primitives;

import com.google.common.base.Preconditions;
import com.reddit.datalibrary.frontpage.job.RedditJobManager;

public final class Ints {
    public static int m7284b(long j) {
        return j > 2147483647L ? RedditJobManager.f10810d : j < -2147483648L ? Integer.MIN_VALUE : (int) j;
    }

    public static int m7283a(long j) {
        int i = (int) j;
        Preconditions.m6916a(((long) i) == j, "Out of range: %s", j);
        return i;
    }
}
