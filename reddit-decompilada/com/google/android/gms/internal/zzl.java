package com.google.android.gms.internal;

import android.text.TextUtils;

public final class zzl {
    final String f7777a;
    final String f7778b;

    public zzl(String str, String str2) {
        this.f7777a = str;
        this.f7778b = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzl com_google_android_gms_internal_zzl = (zzl) obj;
        return TextUtils.equals(this.f7777a, com_google_android_gms_internal_zzl.f7777a) && TextUtils.equals(this.f7778b, com_google_android_gms_internal_zzl.f7778b);
    }

    public final int hashCode() {
        return (this.f7777a.hashCode() * 31) + this.f7778b.hashCode();
    }

    public final String toString() {
        String str = this.f7777a;
        String str2 = this.f7778b;
        StringBuilder stringBuilder = new StringBuilder((20 + String.valueOf(str).length()) + String.valueOf(str2).length());
        stringBuilder.append("Header[name=");
        stringBuilder.append(str);
        stringBuilder.append(",value=");
        stringBuilder.append(str2);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
