package com.google.android.gms.location;

import com.google.android.gms.common.api.Status;

@Deprecated
public final class LocationStatusCodes {
    public static int m6841a(int i) {
        return ((i < 0 || i > 1) && (1000 > i || i > 1002)) ? 1 : i;
    }

    public static Status m6842b(int i) {
        if (i == 1) {
            i = 13;
        }
        return new Status(i);
    }
}
