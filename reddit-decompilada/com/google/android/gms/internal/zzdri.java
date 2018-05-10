package com.google.android.gms.internal;

import com.google.android.gms.internal.zzffu.zzb;
import com.google.android.gms.internal.zzffu.zzg;
import com.google.android.gms.internal.zzffu.zzh;
import java.io.IOException;

public final class zzdri extends zzffu<zzdri, zza> implements zzfhg {
    private static final zzdri f19585c;
    private static volatile zzfhk<zzdri> f19586d;
    int f19587a;
    private zzdrk f19588b;

    public static final class zza extends com.google.android.gms.internal.zzffu.zza<zzdri, zza> implements zzfhg {
        private zza() {
            super(zzdri.f19585c);
        }
    }

    private zzdri() {
    }

    public static zzdri m21011a(zzfes com_google_android_gms_internal_zzfes) throws zzfge {
        return (zzdri) zzffu.m20434a(f19585c, com_google_android_gms_internal_zzfes);
    }

    public static zzdri m21012b() {
        return f19585c;
    }

    public final zzdrk m21014a() {
        return this.f19588b == null ? zzdrk.m21018a() : this.f19588b;
    }

    public final void mo4039a(zzffg com_google_android_gms_internal_zzffg) throws IOException {
        if (this.f19588b != null) {
            com_google_android_gms_internal_zzffg.mo3516a(1, this.f19588b == null ? zzdrk.m21018a() : this.f19588b);
        }
        if (this.f19587a != 0) {
            com_google_android_gms_internal_zzffg.mo3532c(2, this.f19587a);
        }
        this.g.m6090a(com_google_android_gms_internal_zzffg);
    }

    public final int mo4040c() {
        int i = this.h;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if (this.f19588b != null) {
            i2 = 0 + zzffg.m13777c(1, this.f19588b == null ? zzdrk.m21018a() : this.f19588b);
        }
        if (this.f19587a != 0) {
            i2 += zzffg.m13787e(2, this.f19587a);
        }
        i2 += this.g.m6093c();
        this.h = i2;
        return i2;
    }

    protected final Object mo4293a(int i, Object obj, Object obj2) {
        boolean z = false;
        switch (zzdrj.f7266a[i - 1]) {
            case 1:
                return new zzdri();
            case 2:
                return f19585c;
            case 3:
                return null;
            case 4:
                return new zza();
            case 5:
                zzh com_google_android_gms_internal_zzffu_zzh = (zzh) obj;
                zzdri com_google_android_gms_internal_zzdri = (zzdri) obj2;
                this.f19588b = (zzdrk) com_google_android_gms_internal_zzffu_zzh.mo1904a(this.f19588b, com_google_android_gms_internal_zzdri.f19588b);
                boolean z2 = this.f19587a != 0;
                int i2 = this.f19587a;
                if (com_google_android_gms_internal_zzdri.f19587a != 0) {
                    z = true;
                }
                this.f19587a = com_google_android_gms_internal_zzffu_zzh.mo1901a(z2, i2, z, com_google_android_gms_internal_zzdri.f19587a);
                return this;
            case 6:
                zzffb com_google_android_gms_internal_zzffb = (zzffb) obj;
                zzffm com_google_android_gms_internal_zzffm = (zzffm) obj2;
                if (com_google_android_gms_internal_zzffm != null) {
                    while (!z) {
                        try {
                            i = com_google_android_gms_internal_zzffb.mo1878a();
                            if (i != 0) {
                                if (i == 10) {
                                    if (this.f19588b != 0) {
                                        zzffu com_google_android_gms_internal_zzffu = this.f19588b;
                                        com.google.android.gms.internal.zzffu.zza com_google_android_gms_internal_zzffu_zza = (com.google.android.gms.internal.zzffu.zza) com_google_android_gms_internal_zzffu.mo4293a(zzg.f7410h, null, null);
                                        com_google_android_gms_internal_zzffu_zza.m20427a(com_google_android_gms_internal_zzffu);
                                        i = (com.google.android.gms.internal.zzdrk.zza) com_google_android_gms_internal_zzffu_zza;
                                    } else {
                                        i = 0;
                                    }
                                    this.f19588b = (zzdrk) com_google_android_gms_internal_zzffb.mo1879a(zzdrk.m21018a(), com_google_android_gms_internal_zzffm);
                                    if (i != 0) {
                                        i.m20427a(this.f19588b);
                                        this.f19588b = (zzdrk) i.m20430e();
                                    }
                                } else if (i == 16) {
                                    this.f19587a = com_google_android_gms_internal_zzffb.mo1889h();
                                } else if (m20442a(i, com_google_android_gms_internal_zzffb) == 0) {
                                }
                            }
                            z = true;
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
                if (f19586d == 0) {
                    synchronized (zzdri.class) {
                        if (f19586d == null) {
                            f19586d = new zzb(f19585c);
                        }
                    }
                }
                return f19586d;
            case 9:
                return Byte.valueOf((byte) 1);
            case 10:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
        return f19585c;
    }

    static {
        zzffu com_google_android_gms_internal_zzdri = new zzdri();
        f19585c = com_google_android_gms_internal_zzdri;
        com_google_android_gms_internal_zzdri.mo4293a(zzg.f7408f, null, null);
        com_google_android_gms_internal_zzdri.f19235g.f7470e = false;
    }
}
