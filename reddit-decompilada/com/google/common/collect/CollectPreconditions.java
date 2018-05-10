package com.google.common.collect;

import com.google.common.base.Preconditions;

final class CollectPreconditions {
    static void m7081a(Object obj, Object obj2) {
        StringBuilder stringBuilder;
        if (obj == null) {
            stringBuilder = new StringBuilder("null key in entry: null=");
            stringBuilder.append(obj2);
            throw new NullPointerException(stringBuilder.toString());
        } else if (obj2 == null) {
            stringBuilder = new StringBuilder("null value in entry: ");
            stringBuilder.append(obj);
            stringBuilder.append("=null");
            throw new NullPointerException(stringBuilder.toString());
        }
    }

    static int m7080a(int i, String str) {
        if (i >= 0) {
            return i;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(" cannot be negative but was: ");
        stringBuilder.append(i);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    static void m7082a(boolean z) {
        Preconditions.m6922b(z, (Object) "no calls to next() since the last call to remove()");
    }
}
