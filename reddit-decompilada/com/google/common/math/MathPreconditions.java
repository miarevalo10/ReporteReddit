package com.google.common.math;

final class MathPreconditions {
    static int m7281a(String str, int i) {
        if (i > 0) {
            return i;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(" (");
        stringBuilder.append(i);
        stringBuilder.append(") must be > 0");
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    static void m7282a(boolean z) {
        if (!z) {
            throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
        }
    }
}
