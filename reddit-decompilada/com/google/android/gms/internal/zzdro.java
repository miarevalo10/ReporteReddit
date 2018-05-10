package com.google.android.gms.internal;

import com.google.android.gms.internal.zzffu.zzb;
import com.google.android.gms.internal.zzffu.zzg;
import com.google.android.gms.internal.zzffu.zzh;
import java.io.IOException;

public final class zzdro extends zzffu<zzdro, zza> implements zzfhg {
    private static final zzdro f19597c;
    private static volatile zzfhk<zzdro> f19598d;
    int f19599a;
    private zzdrq f19600b;

    public static final class zza extends com.google.android.gms.internal.zzffu.zza<zzdro, zza> implements zzfhg {
        private zza() {
            super(zzdro.f19597c);
        }
    }

    private zzdro() {
    }

    public static zzdro m21036a(zzfes com_google_android_gms_internal_zzfes) throws zzfge {
        return (zzdro) zzffu.m20434a(f19597c, com_google_android_gms_internal_zzfes);
    }

    public final zzdrq m21038a() {
        return this.f19600b == null ? zzdrq.m21042a() : this.f19600b;
    }

    public final void mo4039a(zzffg com_google_android_gms_internal_zzffg) throws IOException {
        if (this.f19600b != null) {
            com_google_android_gms_internal_zzffg.mo3516a(1, this.f19600b == null ? zzdrq.m21042a() : this.f19600b);
        }
        if (this.f19599a != 0) {
            com_google_android_gms_internal_zzffg.mo3532c(2, this.f19599a);
        }
        this.g.m6090a(com_google_android_gms_internal_zzffg);
    }

    public final int mo4040c() {
        int i = this.h;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if (this.f19600b != null) {
            i2 = 0 + zzffg.m13777c(1, this.f19600b == null ? zzdrq.m21042a() : this.f19600b);
        }
        if (this.f19599a != 0) {
            i2 += zzffg.m13787e(2, this.f19599a);
        }
        i2 += this.g.m6093c();
        this.h = i2;
        return i2;
    }

    protected final Object mo4293a(int i, Object obj, Object obj2) {
        boolean z = false;
        switch (zzdrp.f7269a[i - 1]) {
            case 1:
                return new zzdro();
            case 2:
                return f19597c;
            case 3:
                return null;
            case 4:
                return new zza();
            case 5:
                zzh com_google_android_gms_internal_zzffu_zzh = (zzh) obj;
                zzdro com_google_android_gms_internal_zzdro = (zzdro) obj2;
                this.f19600b = (zzdrq) com_google_android_gms_internal_zzffu_zzh.mo1904a(this.f19600b, com_google_android_gms_internal_zzdro.f19600b);
                boolean z2 = this.f19599a != 0;
                int i2 = this.f19599a;
                if (com_google_android_gms_internal_zzdro.f19599a != 0) {
                    z = true;
                }
                this.f19599a = com_google_android_gms_internal_zzffu_zzh.mo1901a(z2, i2, z, com_google_android_gms_internal_zzdro.f19599a);
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
                                    if (this.f19600b != 0) {
                                        zzffu com_google_android_gms_internal_zzffu = this.f19600b;
                                        com.google.android.gms.internal.zzffu.zza com_google_android_gms_internal_zzffu_zza = (com.google.android.gms.internal.zzffu.zza) com_google_android_gms_internal_zzffu.mo4293a(zzg.f7410h, null, null);
                                        com_google_android_gms_internal_zzffu_zza.m20427a(com_google_android_gms_internal_zzffu);
                                        i = (com.google.android.gms.internal.zzdrq.zza) com_google_android_gms_internal_zzffu_zza;
                                    } else {
                                        i = 0;
                                    }
                                    this.f19600b = (zzdrq) com_google_android_gms_internal_zzffb.mo1879a(zzdrq.m21042a(), com_google_android_gms_internal_zzffm);
                                    if (i != 0) {
                                        i.m20427a(this.f19600b);
                                        this.f19600b = (zzdrq) i.m20430e();
                                    }
                                } else if (i == 16) {
                                    this.f19599a = com_google_android_gms_internal_zzffb.mo1889h();
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
                if (f19598d == 0) {
                    synchronized (zzdro.class) {
                        if (f19598d == null) {
                            f19598d = new zzb(f19597c);
                        }
                    }
                }
                return f19598d;
            case 9:
                return Byte.valueOf((byte) 1);
            case 10:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
        return f19597c;
    }

    static {
        zzffu com_google_android_gms_internal_zzdro = new zzdro();
        f19597c = com_google_android_gms_internal_zzdro;
        com_google_android_gms_internal_zzdro.mo4293a(zzg.f7408f, null, null);
        com_google_android_gms_internal_zzdro.f19235g.f7470e = false;
    }
}
