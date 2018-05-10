package com.crashlytics.android.core;

import java.util.HashMap;
import java.util.Map;

class RemoveRepeatsStrategy implements StackTraceTrimmingStrategy {
    private final int maxRepetitions;

    public RemoveRepeatsStrategy() {
        this(1);
    }

    public RemoveRepeatsStrategy(int i) {
        this.maxRepetitions = i;
    }

    public StackTraceElement[] getTrimmedStackTrace(StackTraceElement[] stackTraceElementArr) {
        StackTraceElement[] trimRepeats = trimRepeats(stackTraceElementArr, this.maxRepetitions);
        return trimRepeats.length < stackTraceElementArr.length ? trimRepeats : stackTraceElementArr;
    }

    private static StackTraceElement[] trimRepeats(StackTraceElement[] stackTraceElementArr, int i) {
        Map hashMap = new HashMap();
        Object obj = new StackTraceElement[stackTraceElementArr.length];
        int i2 = 0;
        int i3 = i2;
        int i4 = 1;
        while (i2 < stackTraceElementArr.length) {
            int intValue;
            Object obj2 = stackTraceElementArr[i2];
            Integer num = (Integer) hashMap.get(obj2);
            if (num != null) {
                if (isRepeatingSequence(stackTraceElementArr, num.intValue(), i2)) {
                    intValue = i2 - num.intValue();
                    if (i4 < i) {
                        System.arraycopy(stackTraceElementArr, i2, obj, i3, intValue);
                        i3 += intValue;
                        i4++;
                    }
                    intValue = (intValue - 1) + i2;
                    hashMap.put(obj2, Integer.valueOf(i2));
                    i2 = intValue + 1;
                }
            }
            obj[i3] = stackTraceElementArr[i2];
            i3++;
            i4 = 1;
            intValue = i2;
            hashMap.put(obj2, Integer.valueOf(i2));
            i2 = intValue + 1;
        }
        stackTraceElementArr = new StackTraceElement[i3];
        System.arraycopy(obj, 0, stackTraceElementArr, 0, stackTraceElementArr.length);
        return stackTraceElementArr;
    }

    private static boolean isRepeatingSequence(StackTraceElement[] stackTraceElementArr, int i, int i2) {
        int i3 = i2 - i;
        if (i2 + i3 > stackTraceElementArr.length) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (!stackTraceElementArr[i + i4].equals(stackTraceElementArr[i2 + i4])) {
                return false;
            }
        }
        return 1;
    }
}
