package com.google.android.gms.common.api;

public class ApiException extends Exception {
    protected final Status f5737a;

    public ApiException(Status status) {
        int i = status.f17270g;
        String str = status.f17271h != null ? status.f17271h : "";
        StringBuilder stringBuilder = new StringBuilder(13 + String.valueOf(str).length());
        stringBuilder.append(i);
        stringBuilder.append(": ");
        stringBuilder.append(str);
        super(stringBuilder.toString());
        this.f5737a = status;
    }
}
