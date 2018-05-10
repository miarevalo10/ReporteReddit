package com.google.android.gms.internal;

import com.google.android.gms.internal.zzffu.zzb;
import com.google.android.gms.internal.zzffu.zzg;
import java.io.IOException;

public final class zzdrw extends zzffu<zzdrw, zza> implements zzfhg {
    private static final zzdrw f19613a;
    private static volatile zzfhk<zzdrw> f19614b;

    public static final class zza extends com.google.android.gms.internal.zzffu.zza<zzdrw, zza> implements zzfhg {
        private zza() {
            super(zzdrw.f19613a);
        }
    }

    private zzdrw() {
    }

    public static zzdrw m21064a() {
        return f19613a;
    }

    public final void mo4039a(zzffg com_google_android_gms_internal_zzffg) throws IOException {
        this.g.m6090a(com_google_android_gms_internal_zzffg);
    }

    public final int mo4040c() {
        int i = this.h;
        if (i != -1) {
            return i;
        }
        i = 0 + this.g.m6093c();
        this.h = i;
        return i;
    }

    protected final Object mo4293a(int i, Object obj, Object obj2) {
        byte b = (byte) 0;
        switch (zzdrx.f7273a[i - 1]) {
            case 1:
                return new zzdrw();
            case 2:
                return f19613a;
            case 3:
                return null;
            case 4:
                return new zza();
            case 5:
                return this;
            case 6:
                zzffb com_google_android_gms_internal_zzffb = (zzffb) obj;
                if (((zzffm) obj2) != null) {
                    while (b == (byte) 0) {
                        try {
                            i = com_google_android_gms_internal_zzffb.mo1878a();
                            if (i == 0 || m20442a(i, com_google_android_gms_internal_zzffb) == 0) {
                                b = (byte) 1;
                            }
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
                break;
            case 7:
                break;
            case 8:
                if (f19614b == 0) {
                    synchronized (zzdrw.class) {
                        if (f19614b == null) {
                            f19614b = new zzb(f19613a);
                        }
                    }
                }
                return f19614b;
            case 9:
                return Byte.valueOf((byte) 1);
            case 10:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
        return f19613a;
    }

    static {
        zzffu com_google_android_gms_internal_zzdrw = new zzdrw();
        f19613a = com_google_android_gms_internal_zzdrw;
        com_google_android_gms_internal_zzdrw.mo4293a(zzg.f7408f, null, null);
        com_google_android_gms_internal_zzdrw.f19235g.f7470e = false;
    }
}
