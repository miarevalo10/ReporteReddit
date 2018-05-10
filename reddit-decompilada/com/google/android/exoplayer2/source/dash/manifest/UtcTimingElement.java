package com.google.android.exoplayer2.source.dash.manifest;

public final class UtcTimingElement {
    public final String f4853a;
    public final String f4854b;

    public UtcTimingElement(String str, String str2) {
        this.f4853a = str;
        this.f4854b = str2;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f4853a);
        stringBuilder.append(", ");
        stringBuilder.append(this.f4854b);
        return stringBuilder.toString();
    }
}
