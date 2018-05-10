package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.Iterator;

public final class zzcgx extends zzbfm implements Iterable<String> {
    public static final Creator<zzcgx> CREATOR = new zzcgz();
    final Bundle f17797a;

    zzcgx(Bundle bundle) {
        this.f17797a = bundle;
    }

    public final Bundle m18052a() {
        return new Bundle(this.f17797a);
    }

    final Object m18053a(String str) {
        return this.f17797a.get(str);
    }

    final Long m18054b(String str) {
        return Long.valueOf(this.f17797a.getLong(str));
    }

    public final Iterator<String> iterator() {
        return new zzcgy(this);
    }

    public final String toString() {
        return this.f17797a.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = zzbfp.m5536a(parcel);
        zzbfp.m5542a(parcel, 2, m18052a());
        zzbfp.m5537a(parcel, i);
    }
}
