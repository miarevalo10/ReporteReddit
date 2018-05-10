package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;

public final class Scope extends zzbfm implements ReflectedParcelable {
    public static final Creator<Scope> CREATOR = new zzf();
    public final String f17261a;
    private int f17262b;

    Scope(int i, String str) {
        zzbq.m4811a(str, (Object) "scopeUri must not be null or empty");
        this.f17262b = i;
        this.f17261a = str;
    }

    public Scope(String str) {
        this(1, str);
    }

    public final boolean equals(Object obj) {
        return this == obj ? true : !(obj instanceof Scope) ? false : this.f17261a.equals(((Scope) obj).f17261a);
    }

    public final int hashCode() {
        return this.f17261a.hashCode();
    }

    public final String toString() {
        return this.f17261a;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = zzbfp.m5536a(parcel);
        zzbfp.m5540a(parcel, 1, this.f17262b);
        zzbfp.m5545a(parcel, 2, this.f17261a);
        zzbfp.m5537a(parcel, i);
    }
}
