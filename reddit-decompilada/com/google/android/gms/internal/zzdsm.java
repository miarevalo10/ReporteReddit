package com.google.android.gms.internal;

import com.google.android.gms.internal.zzffu.zzb;
import com.google.android.gms.internal.zzffu.zzg;
import com.google.android.gms.internal.zzffu.zzh;
import java.io.IOException;

public final class zzdsm extends zzffu<zzdsm, zza> implements zzfhg {
    private static final zzdsm f19641d;
    private static volatile zzfhk<zzdsm> f19642e;
    zzfes f19643a = zzfes.f7377a;
    private int f19644b;
    private int f19645c;

    public static final class zza extends com.google.android.gms.internal.zzffu.zza<zzdsm, zza> implements zzfhg {
        private zza() {
            super(zzdsm.f19641d);
        }
    }

    private zzdsm() {
    }

    public static zzdsm m21128d() {
        return f19641d;
    }

    public final zzdso m21130a() {
        zzdso a = zzdso.m13667a(this.f19644b);
        return a == null ? zzdso.UNRECOGNIZED : a;
    }

    public final void mo4039a(zzffg com_google_android_gms_internal_zzffg) throws IOException {
        if (this.f19644b != zzdso.UNKNOWN_CURVE.mo1865a()) {
            com_google_android_gms_internal_zzffg.mo3525b(1, this.f19644b);
        }
        if (this.f19645c != zzdsq.UNKNOWN_HASH.mo1865a()) {
            com_google_android_gms_internal_zzffg.mo3525b(2, this.f19645c);
        }
        if (!this.f19643a.m5958b()) {
            com_google_android_gms_internal_zzffg.mo3515a(11, this.f19643a);
        }
        this.g.m6090a(com_google_android_gms_internal_zzffg);
    }

    public final zzdsq m21133b() {
        zzdsq a = zzdsq.m13669a(this.f19645c);
        return a == null ? zzdsq.UNRECOGNIZED : a;
    }

    public final int mo4040c() {
        int i = this.h;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if (this.f19644b != zzdso.UNKNOWN_CURVE.mo1865a()) {
            i2 = 0 + zzffg.m13791f(1, this.f19644b);
        }
        if (this.f19645c != zzdsq.UNKNOWN_HASH.mo1865a()) {
            i2 += zzffg.m13791f(2, this.f19645c);
        }
        if (!this.f19643a.m5958b()) {
            i2 += zzffg.m13776c(11, this.f19643a);
        }
        i2 += this.g.m6093c();
        this.h = i2;
        return i2;
    }

    protected final Object mo4293a(int i, Object obj, Object obj2) {
        boolean z = true;
        byte b = (byte) 0;
        switch (zzdsn.f7280a[i - 1]) {
            case 1:
                return new zzdsm();
            case 2:
                return f19641d;
            case 3:
                return null;
            case 4:
                return new zza();
            case 5:
                zzh com_google_android_gms_internal_zzffu_zzh = (zzh) obj;
                zzdsm com_google_android_gms_internal_zzdsm = (zzdsm) obj2;
                this.f19644b = com_google_android_gms_internal_zzffu_zzh.mo1901a(this.f19644b != 0, this.f19644b, com_google_android_gms_internal_zzdsm.f19644b != 0, com_google_android_gms_internal_zzdsm.f19644b);
                this.f19645c = com_google_android_gms_internal_zzffu_zzh.mo1901a(this.f19645c != 0, this.f19645c, com_google_android_gms_internal_zzdsm.f19645c != 0, com_google_android_gms_internal_zzdsm.f19645c);
                boolean z2 = this.f19643a != zzfes.f7377a;
                zzfes com_google_android_gms_internal_zzfes = this.f19643a;
                if (com_google_android_gms_internal_zzdsm.f19643a == zzfes.f7377a) {
                    z = false;
                }
                this.f19643a = com_google_android_gms_internal_zzffu_zzh.mo1902a(z2, com_google_android_gms_internal_zzfes, z, com_google_android_gms_internal_zzdsm.f19643a);
                return this;
            case 6:
                zzffb com_google_android_gms_internal_zzffb = (zzffb) obj;
                if (((zzffm) obj2) != null) {
                    while (b == (byte) 0) {
                        try {
                            i = com_google_android_gms_internal_zzffb.mo1878a();
                            if (i != 0) {
                                if (i == 8) {
                                    this.f19644b = com_google_android_gms_internal_zzffb.mo1890i();
                                } else if (i == 16) {
                                    this.f19645c = com_google_android_gms_internal_zzffb.mo1890i();
                                } else if (i == 90) {
                                    this.f19643a = com_google_android_gms_internal_zzffb.mo1888g();
                                } else if (m20442a(i, com_google_android_gms_internal_zzffb) == 0) {
                                }
                            }
                            b = (byte) 1;
                        } catch (int i2) {
                            i2.f7422a = this;
                            throw new RuntimeException(i2);
                        } catch (int i22) {
                            obj2 = new zzfge(i22.getMessage());
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
                if (f19642e == 0) {
                    synchronized (zzdsm.class) {
                        if (f19642e == null) {
                            f19642e = new zzb(f19641d);
                        }
                    }
                }
                return f19642e;
            case 9:
                return Byte.valueOf((byte) 1);
            case 10:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
        return f19641d;
    }

    static {
        zzffu com_google_android_gms_internal_zzdsm = new zzdsm();
        f19641d = com_google_android_gms_internal_zzdsm;
        com_google_android_gms_internal_zzdsm.mo4293a(zzg.f7408f, null, null);
        com_google_android_gms_internal_zzdsm.f19235g.f7470e = false;
    }
}
