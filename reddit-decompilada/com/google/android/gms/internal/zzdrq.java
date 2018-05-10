package com.google.android.gms.internal;

import com.google.android.gms.internal.zzffu.zzb;
import com.google.android.gms.internal.zzffu.zzg;
import com.google.android.gms.internal.zzffu.zzh;
import java.io.IOException;

public final class zzdrq extends zzffu<zzdrq, zza> implements zzfhg {
    private static final zzdrq f19601b;
    private static volatile zzfhk<zzdrq> f19602c;
    int f19603a;

    public static final class zza extends com.google.android.gms.internal.zzffu.zza<zzdrq, zza> implements zzfhg {
        private zza() {
            super(zzdrq.f19601b);
        }
    }

    private zzdrq() {
    }

    public static zzdrq m21042a() {
        return f19601b;
    }

    public final void mo4039a(zzffg com_google_android_gms_internal_zzffg) throws IOException {
        if (this.f19603a != 0) {
            com_google_android_gms_internal_zzffg.mo3532c(1, this.f19603a);
        }
        this.g.m6090a(com_google_android_gms_internal_zzffg);
    }

    public final int mo4040c() {
        int i = this.h;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if (this.f19603a != 0) {
            i2 = 0 + zzffg.m13787e(1, this.f19603a);
        }
        i2 += this.g.m6093c();
        this.h = i2;
        return i2;
    }

    protected final Object mo4293a(int i, Object obj, Object obj2) {
        boolean z = true;
        byte b = (byte) 0;
        switch (zzdrr.f7270a[i - 1]) {
            case 1:
                return new zzdrq();
            case 2:
                return f19601b;
            case 3:
                return null;
            case 4:
                return new zza();
            case 5:
                zzh com_google_android_gms_internal_zzffu_zzh = (zzh) obj;
                zzdrq com_google_android_gms_internal_zzdrq = (zzdrq) obj2;
                boolean z2 = this.f19603a != 0;
                int i2 = this.f19603a;
                if (com_google_android_gms_internal_zzdrq.f19603a == 0) {
                    z = false;
                }
                this.f19603a = com_google_android_gms_internal_zzffu_zzh.mo1901a(z2, i2, z, com_google_android_gms_internal_zzdrq.f19603a);
                return this;
            case 6:
                zzffb com_google_android_gms_internal_zzffb = (zzffb) obj;
                if (((zzffm) obj2) != null) {
                    while (b == (byte) 0) {
                        try {
                            i = com_google_android_gms_internal_zzffb.mo1878a();
                            if (i != 0) {
                                if (i == 8) {
                                    this.f19603a = com_google_android_gms_internal_zzffb.mo1889h();
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
                if (f19602c == 0) {
                    synchronized (zzdrq.class) {
                        if (f19602c == null) {
                            f19602c = new zzb(f19601b);
                        }
                    }
                }
                return f19602c;
            case 9:
                return Byte.valueOf((byte) 1);
            case 10:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
        return f19601b;
    }

    static {
        zzffu com_google_android_gms_internal_zzdrq = new zzdrq();
        f19601b = com_google_android_gms_internal_zzdrq;
        com_google_android_gms_internal_zzdrq.mo4293a(zzg.f7408f, null, null);
        com_google_android_gms_internal_zzdrq.f19235g.f7470e = false;
    }
}
