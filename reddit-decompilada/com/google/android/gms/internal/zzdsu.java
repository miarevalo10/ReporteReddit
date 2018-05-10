package com.google.android.gms.internal;

import com.google.android.gms.internal.zzffu.zzb;
import com.google.android.gms.internal.zzffu.zzg;
import com.google.android.gms.internal.zzffu.zzh;
import java.io.IOException;

public final class zzdsu extends zzffu<zzdsu, zza> implements zzfhg {
    private static final zzdsu f19651c;
    private static volatile zzfhk<zzdsu> f19652d;
    int f19653a;
    private zzdsw f19654b;

    public static final class zza extends com.google.android.gms.internal.zzffu.zza<zzdsu, zza> implements zzfhg {
        private zza() {
            super(zzdsu.f19651c);
        }
    }

    private zzdsu() {
    }

    public static zzdsu m21149a(zzfes com_google_android_gms_internal_zzfes) throws zzfge {
        return (zzdsu) zzffu.m20434a(f19651c, com_google_android_gms_internal_zzfes);
    }

    public static zzdsu m21150b() {
        return f19651c;
    }

    public final zzdsw m21152a() {
        return this.f19654b == null ? zzdsw.m21156b() : this.f19654b;
    }

    public final void mo4039a(zzffg com_google_android_gms_internal_zzffg) throws IOException {
        if (this.f19654b != null) {
            com_google_android_gms_internal_zzffg.mo3516a(1, this.f19654b == null ? zzdsw.m21156b() : this.f19654b);
        }
        if (this.f19653a != 0) {
            com_google_android_gms_internal_zzffg.mo3532c(2, this.f19653a);
        }
        this.g.m6090a(com_google_android_gms_internal_zzffg);
    }

    public final int mo4040c() {
        int i = this.h;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if (this.f19654b != null) {
            i2 = 0 + zzffg.m13777c(1, this.f19654b == null ? zzdsw.m21156b() : this.f19654b);
        }
        if (this.f19653a != 0) {
            i2 += zzffg.m13787e(2, this.f19653a);
        }
        i2 += this.g.m6093c();
        this.h = i2;
        return i2;
    }

    protected final Object mo4293a(int i, Object obj, Object obj2) {
        boolean z = false;
        switch (zzdsv.f7282a[i - 1]) {
            case 1:
                return new zzdsu();
            case 2:
                return f19651c;
            case 3:
                return null;
            case 4:
                return new zza();
            case 5:
                zzh com_google_android_gms_internal_zzffu_zzh = (zzh) obj;
                zzdsu com_google_android_gms_internal_zzdsu = (zzdsu) obj2;
                this.f19654b = (zzdsw) com_google_android_gms_internal_zzffu_zzh.mo1904a(this.f19654b, com_google_android_gms_internal_zzdsu.f19654b);
                boolean z2 = this.f19653a != 0;
                int i2 = this.f19653a;
                if (com_google_android_gms_internal_zzdsu.f19653a != 0) {
                    z = true;
                }
                this.f19653a = com_google_android_gms_internal_zzffu_zzh.mo1901a(z2, i2, z, com_google_android_gms_internal_zzdsu.f19653a);
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
                                    if (this.f19654b != 0) {
                                        zzffu com_google_android_gms_internal_zzffu = this.f19654b;
                                        com.google.android.gms.internal.zzffu.zza com_google_android_gms_internal_zzffu_zza = (com.google.android.gms.internal.zzffu.zza) com_google_android_gms_internal_zzffu.mo4293a(zzg.f7410h, null, null);
                                        com_google_android_gms_internal_zzffu_zza.m20427a(com_google_android_gms_internal_zzffu);
                                        i = (com.google.android.gms.internal.zzdsw.zza) com_google_android_gms_internal_zzffu_zza;
                                    } else {
                                        i = 0;
                                    }
                                    this.f19654b = (zzdsw) com_google_android_gms_internal_zzffb.mo1879a(zzdsw.m21156b(), com_google_android_gms_internal_zzffm);
                                    if (i != 0) {
                                        i.m20427a(this.f19654b);
                                        this.f19654b = (zzdsw) i.m20430e();
                                    }
                                } else if (i == 16) {
                                    this.f19653a = com_google_android_gms_internal_zzffb.mo1889h();
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
                if (f19652d == 0) {
                    synchronized (zzdsu.class) {
                        if (f19652d == null) {
                            f19652d = new zzb(f19651c);
                        }
                    }
                }
                return f19652d;
            case 9:
                return Byte.valueOf((byte) 1);
            case 10:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
        return f19651c;
    }

    static {
        zzffu com_google_android_gms_internal_zzdsu = new zzdsu();
        f19651c = com_google_android_gms_internal_zzdsu;
        com_google_android_gms_internal_zzdsu.mo4293a(zzg.f7408f, null, null);
        com_google_android_gms_internal_zzdsu.f19235g.f7470e = false;
    }
}
