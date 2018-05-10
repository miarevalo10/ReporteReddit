package com.danikula.videocache;

public class SourceInfo {
    public final String f3771a;
    public final long f3772b;
    public final String f3773c;

    public SourceInfo(String str, long j, String str2) {
        this.f3771a = str;
        this.f3772b = j;
        this.f3773c = str2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("SourceInfo{url='");
        stringBuilder.append(this.f3771a);
        stringBuilder.append('\'');
        stringBuilder.append(", length=");
        stringBuilder.append(this.f3772b);
        stringBuilder.append(", mime='");
        stringBuilder.append(this.f3773c);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
