package com.google.android.gms.internal;

import java.io.IOException;

public final class zzcmd extends zzfjm<zzcmd> {
    public zzcme[] f17971a;

    public zzcmd() {
        this.f17971a = zzcme.m18635b();
        this.X = null;
        this.Y = -1;
    }

    protected final int mo1927a() {
        int a = super.mo1927a();
        if (this.f17971a != null && this.f17971a.length > 0) {
            for (zzfjs com_google_android_gms_internal_zzfjs : this.f17971a) {
                if (com_google_android_gms_internal_zzfjs != null) {
                    a += zzfjk.m6162b(1, com_google_android_gms_internal_zzfjs);
                }
            }
        }
        return a;
    }

    public final /* synthetic */ zzfjs mo3478a(zzfjj com_google_android_gms_internal_zzfjj) throws IOException {
        while (true) {
            int a = com_google_android_gms_internal_zzfjj.m6134a();
            if (a == 0) {
                return this;
            }
            if (a == 10) {
                a = zzfjv.m6217a(com_google_android_gms_internal_zzfjj, 10);
                int length = this.f17971a == null ? 0 : this.f17971a.length;
                Object obj = new zzcme[(a + length)];
                if (length != 0) {
                    System.arraycopy(this.f17971a, 0, obj, 0, length);
                }
                while (length < obj.length - 1) {
                    obj[length] = new zzcme();
                    com_google_android_gms_internal_zzfjj.m6137a(obj[length]);
                    com_google_android_gms_internal_zzfjj.m6134a();
                    length++;
                }
                obj[length] = new zzcme();
                com_google_android_gms_internal_zzfjj.m6137a(obj[length]);
                this.f17971a = obj;
            } else if (!super.m13900a(com_google_android_gms_internal_zzfjj, a)) {
                return this;
            }
        }
    }

    public final void mo1928a(zzfjk com_google_android_gms_internal_zzfjk) throws IOException {
        if (this.f17971a != null && this.f17971a.length > 0) {
            for (zzfjs com_google_android_gms_internal_zzfjs : this.f17971a) {
                if (com_google_android_gms_internal_zzfjs != null) {
                    com_google_android_gms_internal_zzfjk.m6176a(1, com_google_android_gms_internal_zzfjs);
                }
            }
        }
        super.mo1928a(com_google_android_gms_internal_zzfjk);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzcmd)) {
            return false;
        }
        zzcmd com_google_android_gms_internal_zzcmd = (zzcmd) obj;
        if (!zzfjq.m6198a(this.f17971a, com_google_android_gms_internal_zzcmd.f17971a)) {
            return false;
        }
        if (this.X != null) {
            if (!this.X.m6188a()) {
                return this.X.equals(com_google_android_gms_internal_zzcmd.X);
            }
        }
        return com_google_android_gms_internal_zzcmd.X == null || com_google_android_gms_internal_zzcmd.X.m6188a();
    }

    public final int hashCode() {
        int hashCode;
        int hashCode2 = (((527 + getClass().getName().hashCode()) * 31) + zzfjq.m6195a(this.f17971a)) * 31;
        if (this.X != null) {
            if (!this.X.m6188a()) {
                hashCode = this.X.hashCode();
                return hashCode2 + hashCode;
            }
        }
        hashCode = 0;
        return hashCode2 + hashCode;
    }
}
