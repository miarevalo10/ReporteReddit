package com.google.android.gms.internal;

import com.google.android.gms.internal.zzffu.zzb;
import com.google.android.gms.internal.zzffu.zzg;
import com.google.android.gms.internal.zzffu.zzh;
import java.io.IOException;

public final class zzdru extends zzffu<zzdru, zza> implements zzfhg {
    private static final zzdru f19609c;
    private static volatile zzfhk<zzdru> f19610d;
    zzdrw f19611a;
    int f19612b;

    public static final class zza extends com.google.android.gms.internal.zzffu.zza<zzdru, zza> implements zzfhg {
        private zza() {
            super(zzdru.f19609c);
        }
    }

    private zzdru() {
    }

    public static zzdru m21060a(zzfes com_google_android_gms_internal_zzfes) throws zzfge {
        return (zzdru) zzffu.m20434a(f19609c, com_google_android_gms_internal_zzfes);
    }

    public final void mo4039a(zzffg com_google_android_gms_internal_zzffg) throws IOException {
        if (this.f19611a != null) {
            com_google_android_gms_internal_zzffg.mo3516a(1, this.f19611a == null ? zzdrw.m21064a() : this.f19611a);
        }
        if (this.f19612b != 0) {
            com_google_android_gms_internal_zzffg.mo3532c(2, this.f19612b);
        }
        this.g.m6090a(com_google_android_gms_internal_zzffg);
    }

    public final int mo4040c() {
        int i = this.h;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if (this.f19611a != null) {
            i2 = 0 + zzffg.m13777c(1, this.f19611a == null ? zzdrw.m21064a() : this.f19611a);
        }
        if (this.f19612b != 0) {
            i2 += zzffg.m13787e(2, this.f19612b);
        }
        i2 += this.g.m6093c();
        this.h = i2;
        return i2;
    }

    protected final Object mo4293a(int i, Object obj, Object obj2) {
        boolean z = false;
        switch (zzdrv.f7272a[i - 1]) {
            case 1:
                return new zzdru();
            case 2:
                return f19609c;
            case 3:
                return null;
            case 4:
                return new zza();
            case 5:
                zzh com_google_android_gms_internal_zzffu_zzh = (zzh) obj;
                zzdru com_google_android_gms_internal_zzdru = (zzdru) obj2;
                this.f19611a = (zzdrw) com_google_android_gms_internal_zzffu_zzh.mo1904a(this.f19611a, com_google_android_gms_internal_zzdru.f19611a);
                boolean z2 = this.f19612b != 0;
                int i2 = this.f19612b;
                if (com_google_android_gms_internal_zzdru.f19612b != 0) {
                    z = true;
                }
                this.f19612b = com_google_android_gms_internal_zzffu_zzh.mo1901a(z2, i2, z, com_google_android_gms_internal_zzdru.f19612b);
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
                                    if (this.f19611a != 0) {
                                        zzffu com_google_android_gms_internal_zzffu = this.f19611a;
                                        com.google.android.gms.internal.zzffu.zza com_google_android_gms_internal_zzffu_zza = (com.google.android.gms.internal.zzffu.zza) com_google_android_gms_internal_zzffu.mo4293a(zzg.f7410h, null, null);
                                        com_google_android_gms_internal_zzffu_zza.m20427a(com_google_android_gms_internal_zzffu);
                                        i = (com.google.android.gms.internal.zzdrw.zza) com_google_android_gms_internal_zzffu_zza;
                                    } else {
                                        i = 0;
                                    }
                                    this.f19611a = (zzdrw) com_google_android_gms_internal_zzffb.mo1879a(zzdrw.m21064a(), com_google_android_gms_internal_zzffm);
                                    if (i != 0) {
                                        i.m20427a(this.f19611a);
                                        this.f19611a = (zzdrw) i.m20430e();
                                    }
                                } else if (i == 16) {
                                    this.f19612b = com_google_android_gms_internal_zzffb.mo1889h();
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
                if (f19610d == 0) {
                    synchronized (zzdru.class) {
                        if (f19610d == null) {
                            f19610d = new zzb(f19609c);
                        }
                    }
                }
                return f19610d;
            case 9:
                return Byte.valueOf((byte) 1);
            case 10:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
        return f19609c;
    }

    static {
        zzffu com_google_android_gms_internal_zzdru = new zzdru();
        f19609c = com_google_android_gms_internal_zzdru;
        com_google_android_gms_internal_zzdru.mo4293a(zzg.f7408f, null, null);
        com_google_android_gms_internal_zzdru.f19235g.f7470e = false;
    }
}
