package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class zzcbr extends zzbfm {
    public static final Creator<zzcbr> CREATOR = new zzcbs();
    private int f17713a;
    private zzaz f17714b = null;
    private byte[] f17715c;

    zzcbr(int i, byte[] bArr) {
        this.f17713a = i;
        this.f17715c = bArr;
        m17940b();
    }

    private final void m17940b() {
        if (this.f17714b == null && this.f17715c != null) {
            return;
        }
        if (this.f17714b != null && this.f17715c == null) {
            return;
        }
        if (this.f17714b != null && this.f17715c != null) {
            throw new IllegalStateException("Invalid internal representation - full");
        } else if (this.f17714b == null && this.f17715c == null) {
            throw new IllegalStateException("Invalid internal representation - empty");
        } else {
            throw new IllegalStateException("Impossible");
        }
    }

    public final zzaz m17941a() {
        if ((this.f17714b != null ? 1 : null) == null) {
            try {
                this.f17714b = (zzaz) zzfjs.m6203a(new zzaz(), this.f17715c);
                this.f17715c = null;
            } catch (Throwable e) {
                throw new IllegalStateException(e);
            }
        }
        m17940b();
        return this.f17714b;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = zzbfp.m5536a(parcel);
        zzbfp.m5540a(parcel, 1, this.f17713a);
        zzbfp.m5548a(parcel, 2, this.f17715c != null ? this.f17715c : zzfjs.m6205a(this.f17714b));
        zzbfp.m5537a(parcel, i);
    }
}
