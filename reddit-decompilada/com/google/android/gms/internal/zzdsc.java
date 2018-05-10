package com.google.android.gms.internal;

import com.google.android.gms.internal.zzffu.zzb;
import com.google.android.gms.internal.zzffu.zzg;
import com.google.android.gms.internal.zzffu.zzh;
import java.io.IOException;

public final class zzdsc extends zzffu<zzdsc, zza> implements zzfhg {
    private static final zzdsc f19619b;
    private static volatile zzfhk<zzdsc> f19620c;
    private zzdtd f19621a;

    public static final class zza extends com.google.android.gms.internal.zzffu.zza<zzdsc, zza> implements zzfhg {
        private zza() {
            super(zzdsc.f19619b);
        }
    }

    private zzdsc() {
    }

    public static zzdsc m21079b() {
        return f19619b;
    }

    public final zzdtd m21081a() {
        return this.f19621a == null ? zzdtd.m21175a() : this.f19621a;
    }

    public final void mo4039a(zzffg com_google_android_gms_internal_zzffg) throws IOException {
        if (this.f19621a != null) {
            com_google_android_gms_internal_zzffg.mo3516a(2, this.f19621a == null ? zzdtd.m21175a() : this.f19621a);
        }
        this.g.m6090a(com_google_android_gms_internal_zzffg);
    }

    public final int mo4040c() {
        int i = this.h;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if (this.f19621a != null) {
            i2 = 0 + zzffg.m13777c(2, this.f19621a == null ? zzdtd.m21175a() : this.f19621a);
        }
        i2 += this.g.m6093c();
        this.h = i2;
        return i2;
    }

    protected final Object mo4293a(int i, Object obj, Object obj2) {
        byte b = (byte) 0;
        switch (zzdsd.f7275a[i - 1]) {
            case 1:
                return new zzdsc();
            case 2:
                return f19619b;
            case 3:
                return null;
            case 4:
                return new zza();
            case 5:
                this.f19621a = (zzdtd) ((zzh) obj).mo1904a(this.f19621a, ((zzdsc) obj2).f19621a);
                return this;
            case 6:
                zzffb com_google_android_gms_internal_zzffb = (zzffb) obj;
                zzffm com_google_android_gms_internal_zzffm = (zzffm) obj2;
                if (com_google_android_gms_internal_zzffm != null) {
                    while (b == (byte) 0) {
                        try {
                            i = com_google_android_gms_internal_zzffb.mo1878a();
                            if (i != 0) {
                                if (i == 18) {
                                    if (this.f19621a != 0) {
                                        zzffu com_google_android_gms_internal_zzffu = this.f19621a;
                                        com.google.android.gms.internal.zzffu.zza com_google_android_gms_internal_zzffu_zza = (com.google.android.gms.internal.zzffu.zza) com_google_android_gms_internal_zzffu.mo4293a(zzg.f7410h, null, null);
                                        com_google_android_gms_internal_zzffu_zza.m20427a(com_google_android_gms_internal_zzffu);
                                        i = (com.google.android.gms.internal.zzdtd.zza) com_google_android_gms_internal_zzffu_zza;
                                    } else {
                                        i = 0;
                                    }
                                    this.f19621a = (zzdtd) com_google_android_gms_internal_zzffb.mo1879a(zzdtd.m21175a(), com_google_android_gms_internal_zzffm);
                                    if (i != 0) {
                                        i.m20427a(this.f19621a);
                                        this.f19621a = (zzdtd) i.m20430e();
                                    }
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
                if (f19620c == 0) {
                    synchronized (zzdsc.class) {
                        if (f19620c == null) {
                            f19620c = new zzb(f19619b);
                        }
                    }
                }
                return f19620c;
            case 9:
                return Byte.valueOf((byte) 1);
            case 10:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
        return f19619b;
    }

    static {
        zzffu com_google_android_gms_internal_zzdsc = new zzdsc();
        f19619b = com_google_android_gms_internal_zzdsc;
        com_google_android_gms_internal_zzdsc.mo4293a(zzg.f7408f, null, null);
        com_google_android_gms_internal_zzdsc.f19235g.f7470e = false;
    }
}
