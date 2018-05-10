package com.sendbird.android.shadow.okhttp3.internal.http2;

public enum ErrorCode {
    NO_ERROR(0),
    PROTOCOL_ERROR(1),
    INTERNAL_ERROR(2),
    FLOW_CONTROL_ERROR(3),
    REFUSED_STREAM(7),
    CANCEL(8);
    
    public final int f23435g;

    private ErrorCode(int i) {
        this.f23435g = i;
    }

    public static ErrorCode m25444a(int i) {
        for (ErrorCode errorCode : values()) {
            if (errorCode.f23435g == i) {
                return errorCode;
            }
        }
        return 0;
    }
}
