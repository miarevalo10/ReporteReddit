package com.google.android.gms.internal;

import com.google.android.gms.internal.zzffu.zzb;
import com.google.android.gms.internal.zzffu.zzg;
import com.google.android.gms.internal.zzffu.zzh;
import java.io.IOException;

public final class zzdsw extends zzffu<zzdsw, zza> implements zzfhg {
    private static final zzdsw f19655c;
    private static volatile zzfhk<zzdsw> f19656d;
    int f19657a;
    private int f19658b;

    public static final class zza extends com.google.android.gms.internal.zzffu.zza<zzdsw, zza> implements zzfhg {
        private zza() {
            super(zzdsw.f19655c);
        }
    }

    private zzdsw() {
    }

    public static zzdsw m21156b() {
        return f19655c;
    }

    public final zzdsq m21158a() {
        zzdsq a = zzdsq.m13669a(this.f19658b);
        return a == null ? zzdsq.UNRECOGNIZED : a;
    }

    public final void mo4039a(zzffg com_google_android_gms_internal_zzffg) throws IOException {
        if (this.f19658b != zzdsq.UNKNOWN_HASH.mo1865a()) {
            com_google_android_gms_internal_zzffg.mo3525b(1, this.f19658b);
        }
        if (this.f19657a != 0) {
            com_google_android_gms_internal_zzffg.mo3532c(2, this.f19657a);
        }
        this.g.m6090a(com_google_android_gms_internal_zzffg);
    }

    public final int mo4040c() {
        int i = this.h;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if (this.f19658b != zzdsq.UNKNOWN_HASH.mo1865a()) {
            i2 = 0 + zzffg.m13791f(1, this.f19658b);
        }
        if (this.f19657a != 0) {
            i2 += zzffg.m13787e(2, this.f19657a);
        }
        i2 += this.g.m6093c();
        this.h = i2;
        return i2;
    }

    protected final Object mo4293a(int i, Object obj, Object obj2) {
        boolean z = true;
        byte b = (byte) 0;
        switch (zzdsx.f7283a[i - 1]) {
            case 1:
                return new zzdsw();
            case 2:
                return f19655c;
            case 3:
                return null;
            case 4:
                return new zza();
            case 5:
                zzh com_google_android_gms_internal_zzffu_zzh = (zzh) obj;
                zzdsw com_google_android_gms_internal_zzdsw = (zzdsw) obj2;
                this.f19658b = com_google_android_gms_internal_zzffu_zzh.mo1901a(this.f19658b != 0, this.f19658b, com_google_android_gms_internal_zzdsw.f19658b != 0, com_google_android_gms_internal_zzdsw.f19658b);
                boolean z2 = this.f19657a != 0;
                int i2 = this.f19657a;
                if (com_google_android_gms_internal_zzdsw.f19657a == 0) {
                    z = false;
                }
                this.f19657a = com_google_android_gms_internal_zzffu_zzh.mo1901a(z2, i2, z, com_google_android_gms_internal_zzdsw.f19657a);
                return this;
            case 6:
                zzffb com_google_android_gms_internal_zzffb = (zzffb) obj;
                if (((zzffm) obj2) != null) {
                    while (b == (byte) 0) {
                        try {
                            i = com_google_android_gms_internal_zzffb.mo1878a();
                            if (i != 0) {
                                if (i == 8) {
                                    this.f19658b = com_google_android_gms_internal_zzffb.mo1890i();
                                } else if (i == 16) {
                                    this.f19657a = com_google_android_gms_internal_zzffb.mo1889h();
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
                if (f19656d == 0) {
                    synchronized (zzdsw.class) {
                        if (f19656d == null) {
                            f19656d = new zzb(f19655c);
                        }
                    }
                }
                return f19656d;
            case 9:
                return Byte.valueOf((byte) 1);
            case 10:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
        return f19655c;
    }

    static {
        zzffu com_google_android_gms_internal_zzdsw = new zzdsw();
        f19655c = com_google_android_gms_internal_zzdsw;
        com_google_android_gms_internal_zzdsw.mo4293a(zzg.f7408f, null, null);
        com_google_android_gms_internal_zzdsw.f19235g.f7470e = false;
    }
}
