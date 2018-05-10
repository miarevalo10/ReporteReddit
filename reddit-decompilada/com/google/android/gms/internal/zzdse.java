package com.google.android.gms.internal;

import com.google.android.gms.internal.zzffu.zzb;
import com.google.android.gms.internal.zzffu.zzg;
import com.google.android.gms.internal.zzffu.zzh;
import java.io.IOException;

public final class zzdse extends zzffu<zzdse, zza> implements zzfhg {
    private static final zzdse f19622b;
    private static volatile zzfhk<zzdse> f19623c;
    private zzdsg f19624a;

    public static final class zza extends com.google.android.gms.internal.zzffu.zza<zzdse, zza> implements zzfhg {
        private zza() {
            super(zzdse.f19622b);
        }
    }

    private zzdse() {
    }

    public static zzdse m21085a(zzfes com_google_android_gms_internal_zzfes) throws zzfge {
        return (zzdse) zzffu.m20434a(f19622b, com_google_android_gms_internal_zzfes);
    }

    public final zzdsg m21087a() {
        return this.f19624a == null ? zzdsg.m21091e() : this.f19624a;
    }

    public final void mo4039a(zzffg com_google_android_gms_internal_zzffg) throws IOException {
        if (this.f19624a != null) {
            com_google_android_gms_internal_zzffg.mo3516a(1, this.f19624a == null ? zzdsg.m21091e() : this.f19624a);
        }
        this.g.m6090a(com_google_android_gms_internal_zzffg);
    }

    public final int mo4040c() {
        int i = this.h;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if (this.f19624a != null) {
            i2 = 0 + zzffg.m13777c(1, this.f19624a == null ? zzdsg.m21091e() : this.f19624a);
        }
        i2 += this.g.m6093c();
        this.h = i2;
        return i2;
    }

    protected final Object mo4293a(int i, Object obj, Object obj2) {
        byte b = (byte) 0;
        switch (zzdsf.f7276a[i - 1]) {
            case 1:
                return new zzdse();
            case 2:
                return f19622b;
            case 3:
                return null;
            case 4:
                return new zza();
            case 5:
                this.f19624a = (zzdsg) ((zzh) obj).mo1904a(this.f19624a, ((zzdse) obj2).f19624a);
                return this;
            case 6:
                zzffb com_google_android_gms_internal_zzffb = (zzffb) obj;
                zzffm com_google_android_gms_internal_zzffm = (zzffm) obj2;
                if (com_google_android_gms_internal_zzffm != null) {
                    while (b == (byte) 0) {
                        try {
                            i = com_google_android_gms_internal_zzffb.mo1878a();
                            if (i != 0) {
                                if (i == 10) {
                                    if (this.f19624a != 0) {
                                        zzffu com_google_android_gms_internal_zzffu = this.f19624a;
                                        com.google.android.gms.internal.zzffu.zza com_google_android_gms_internal_zzffu_zza = (com.google.android.gms.internal.zzffu.zza) com_google_android_gms_internal_zzffu.mo4293a(zzg.f7410h, null, null);
                                        com_google_android_gms_internal_zzffu_zza.m20427a(com_google_android_gms_internal_zzffu);
                                        i = (com.google.android.gms.internal.zzdsg.zza) com_google_android_gms_internal_zzffu_zza;
                                    } else {
                                        i = 0;
                                    }
                                    this.f19624a = (zzdsg) com_google_android_gms_internal_zzffb.mo1879a(zzdsg.m21091e(), com_google_android_gms_internal_zzffm);
                                    if (i != 0) {
                                        i.m20427a(this.f19624a);
                                        this.f19624a = (zzdsg) i.m20430e();
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
                if (f19623c == 0) {
                    synchronized (zzdse.class) {
                        if (f19623c == null) {
                            f19623c = new zzb(f19622b);
                        }
                    }
                }
                return f19623c;
            case 9:
                return Byte.valueOf((byte) 1);
            case 10:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
        return f19622b;
    }

    static {
        zzffu com_google_android_gms_internal_zzdse = new zzdse();
        f19622b = com_google_android_gms_internal_zzdse;
        com_google_android_gms_internal_zzdse.mo4293a(zzg.f7408f, null, null);
        com_google_android_gms_internal_zzdse.f19235g.f7470e = false;
    }
}
