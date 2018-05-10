package io.fabric.sdk.android.services.common;

public enum DeliveryMechanism {
    DEVELOPER(1),
    USER_SIDELOAD(2),
    TEST_DISTRIBUTION(3),
    APP_STORE(4);
    
    public final int f24744e;

    private DeliveryMechanism(int i) {
        this.f24744e = i;
    }

    public final String toString() {
        return Integer.toString(this.f24744e);
    }

    public static DeliveryMechanism m26319a(String str) {
        if ("io.crash.air".equals(str)) {
            return TEST_DISTRIBUTION;
        }
        if (str != null) {
            return APP_STORE;
        }
        return DEVELOPER;
    }
}
