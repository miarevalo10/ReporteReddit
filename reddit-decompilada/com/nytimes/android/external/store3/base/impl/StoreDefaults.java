package com.nytimes.android.external.store3.base.impl;

import java.util.concurrent.TimeUnit;

final class StoreDefaults {
    private StoreDefaults() {
    }

    static long m8710a() {
        return TimeUnit.HOURS.toSeconds(24);
    }

    static TimeUnit m8711b() {
        return TimeUnit.SECONDS;
    }
}
