package com.google.android.gms.internal;

import com.google.android.gms.internal.zzffu.zzb;
import com.google.android.gms.internal.zzffu.zzg;
import com.google.android.gms.internal.zzffu.zzh;
import java.io.IOException;

public final class zzdtd extends zzffu<zzdtd, zza> implements zzfhg {
    private static final zzdtd f19664d;
    private static volatile zzfhk<zzdtd> f19665e;
    String f19666a = "";
    zzfes f19667b = zzfes.f7377a;
    private int f19668c;

    public static final class zza extends com.google.android.gms.internal.zzffu.zza<zzdtd, zza> implements zzfhg {
        private zza() {
            super(zzdtd.f19664d);
        }
    }

    private zzdtd() {
    }

    public static zzdtd m21175a() {
        return f19664d;
    }

    public final void mo4039a(zzffg com_google_android_gms_internal_zzffg) throws IOException {
        if (!this.f19666a.isEmpty()) {
            com_google_android_gms_internal_zzffg.mo3517a(1, this.f19666a);
        }
        if (!this.f19667b.m5958b()) {
            com_google_android_gms_internal_zzffg.mo3515a(2, this.f19667b);
        }
        if (this.f19668c != zzdtt.UNKNOWN_PREFIX.mo1865a()) {
            com_google_android_gms_internal_zzffg.mo3525b(3, this.f19668c);
        }
        this.g.m6090a(com_google_android_gms_internal_zzffg);
    }

    public final int mo4040c() {
        int i = this.h;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if (!this.f19666a.isEmpty()) {
            i2 = 0 + zzffg.m13769b(1, this.f19666a);
        }
        if (!this.f19667b.m5958b()) {
            i2 += zzffg.m13776c(2, this.f19667b);
        }
        if (this.f19668c != zzdtt.UNKNOWN_PREFIX.mo1865a()) {
            i2 += zzffg.m13791f(3, this.f19668c);
        }
        i2 += this.g.m6093c();
        this.h = i2;
        return i2;
    }

    protected final Object mo4293a(int i, Object obj, Object obj2) {
        boolean z = true;
        byte b = (byte) 0;
        switch (zzdte.f7298a[i - 1]) {
            case 1:
                return new zzdtd();
            case 2:
                return f19664d;
            case 3:
                return null;
            case 4:
                return new zza();
            case 5:
                zzh com_google_android_gms_internal_zzffu_zzh = (zzh) obj;
                zzdtd com_google_android_gms_internal_zzdtd = (zzdtd) obj2;
                this.f19666a = com_google_android_gms_internal_zzffu_zzh.mo1906a(this.f19666a.isEmpty() ^ 1, this.f19666a, com_google_android_gms_internal_zzdtd.f19666a.isEmpty() ^ true, com_google_android_gms_internal_zzdtd.f19666a);
                this.f19667b = com_google_android_gms_internal_zzffu_zzh.mo1902a(this.f19667b != zzfes.f7377a, this.f19667b, com_google_android_gms_internal_zzdtd.f19667b != zzfes.f7377a, com_google_android_gms_internal_zzdtd.f19667b);
                boolean z2 = this.f19668c != 0;
                int i2 = this.f19668c;
                if (com_google_android_gms_internal_zzdtd.f19668c == 0) {
                    z = false;
                }
                this.f19668c = com_google_android_gms_internal_zzffu_zzh.mo1901a(z2, i2, z, com_google_android_gms_internal_zzdtd.f19668c);
                return this;
            case 6:
                zzffb com_google_android_gms_internal_zzffb = (zzffb) obj;
                if (((zzffm) obj2) != null) {
                    while (b == (byte) 0) {
                        try {
                            i = com_google_android_gms_internal_zzffb.mo1878a();
                            if (i != 0) {
                                if (i == 10) {
                                    this.f19666a = com_google_android_gms_internal_zzffb.mo1887f();
                                } else if (i == 18) {
                                    this.f19667b = com_google_android_gms_internal_zzffb.mo1888g();
                                } else if (i == 24) {
                                    this.f19668c = com_google_android_gms_internal_zzffb.mo1890i();
                                } else if (m20442a(i, com_google_android_gms_internal_zzffb) == 0) {
                                }
                            }
                            b = (byte) 1;
                        } catch (int i3) {
                            i3.f7422a = this;
                            throw new RuntimeException(i3);
                        } catch (int i32) {
                            obj2 = new zzfge(i32.getMessage());
                            obj2.f7422a = this;
                            throw new RuntimeException(obj2);
                        }
                    }
                    break;
                }
                throw new NullPointerException();
            case 7:
                break;
            case 8:
                if (f19665e == 0) {
                    synchronized (zzdtd.class) {
                        if (f19665e == null) {
                            f19665e = new zzb(f19664d);
                        }
                    }
                }
                return f19665e;
            case 9:
                return Byte.valueOf((byte) 1);
            case 10:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
        return f19664d;
    }

    static {
        zzffu com_google_android_gms_internal_zzdtd = new zzdtd();
        f19664d = com_google_android_gms_internal_zzdtd;
        com_google_android_gms_internal_zzdtd.mo4293a(zzg.f7408f, null, null);
        com_google_android_gms_internal_zzdtd.f19235g.f7470e = false;
    }
}
