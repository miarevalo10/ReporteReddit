package io.fabric.sdk.android.services.common;

public abstract class Crash {
    public final String f24737a;
    public final String f24738b;

    public static class FatalException extends Crash {
        public FatalException(String str, String str2) {
            super(str, str2);
        }
    }

    public static class LoggedException extends Crash {
        public LoggedException(String str, String str2) {
            super(str, str2);
        }
    }

    public Crash(String str, String str2) {
        this.f24737a = str;
        this.f24738b = str2;
    }
}
