package com.birbit.android.jobqueue;

import java.util.Set;

public enum TagConstraint {
    ALL,
    ANY;

    public final boolean m2545a(String[] strArr, Set<String> set) {
        if (this == ANY) {
            for (Object contains : strArr) {
                if (set.contains(contains)) {
                    return true;
                }
            }
            return false;
        }
        for (Object contains2 : strArr) {
            if (!set.contains(contains2)) {
                return false;
            }
        }
        return true;
    }
}
