package com.google.android.gms.internal;

import com.google.android.gms.internal.zzffu.zzb;
import com.google.android.gms.internal.zzffu.zzg;
import com.google.android.gms.internal.zzffu.zzh;
import java.io.IOException;

public final class zzdre extends zzffu<zzdre, zza> implements zzfhg {
    private static final zzdre f19576c;
    private static volatile zzfhk<zzdre> f19577d;
    private zzdri f19578a;
    private zzdsu f19579b;

    public static final class zza extends com.google.android.gms.internal.zzffu.zza<zzdre, zza> implements zzfhg {
        private zza() {
            super(zzdre.f19576c);
        }
    }

    private zzdre() {
    }

    public static zzdre m20990a(zzfes com_google_android_gms_internal_zzfes) throws zzfge {
        return (zzdre) zzffu.m20434a(f19576c, com_google_android_gms_internal_zzfes);
    }

    public final zzdri m20992a() {
        return this.f19578a == null ? zzdri.m21012b() : this.f19578a;
    }

    public final void mo4039a(zzffg com_google_android_gms_internal_zzffg) throws IOException {
        if (this.f19578a != null) {
            com_google_android_gms_internal_zzffg.mo3516a(1, this.f19578a == null ? zzdri.m21012b() : this.f19578a);
        }
        if (this.f19579b != null) {
            com_google_android_gms_internal_zzffg.mo3516a(2, this.f19579b == null ? zzdsu.m21150b() : this.f19579b);
        }
        this.g.m6090a(com_google_android_gms_internal_zzffg);
    }

    public final zzdsu m20995b() {
        return this.f19579b == null ? zzdsu.m21150b() : this.f19579b;
    }

    public final int mo4040c() {
        int i = this.h;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if (this.f19578a != null) {
            i2 = 0 + zzffg.m13777c(1, this.f19578a == null ? zzdri.m21012b() : this.f19578a);
        }
        if (this.f19579b != null) {
            i2 += zzffg.m13777c(2, this.f19579b == null ? zzdsu.m21150b() : this.f19579b);
        }
        i2 += this.g.m6093c();
        this.h = i2;
        return i2;
    }

    protected final Object mo4293a(int i, Object obj, Object obj2) {
        byte b = (byte) 0;
        switch (zzdrf.f7264a[i - 1]) {
            case 1:
                return new zzdre();
            case 2:
                return f19576c;
            case 3:
                return null;
            case 4:
                return new zza();
            case 5:
                zzh com_google_android_gms_internal_zzffu_zzh = (zzh) obj;
                zzdre com_google_android_gms_internal_zzdre = (zzdre) obj2;
                this.f19578a = (zzdri) com_google_android_gms_internal_zzffu_zzh.mo1904a(this.f19578a, com_google_android_gms_internal_zzdre.f19578a);
                this.f19579b = (zzdsu) com_google_android_gms_internal_zzffu_zzh.mo1904a(this.f19579b, com_google_android_gms_internal_zzdre.f19579b);
                return this;
            case 6:
                zzffb com_google_android_gms_internal_zzffb = (zzffb) obj;
                zzffm com_google_android_gms_internal_zzffm = (zzffm) obj2;
                if (com_google_android_gms_internal_zzffm != null) {
                    while (b == (byte) 0) {
                        try {
                            i = com_google_android_gms_internal_zzffb.mo1878a();
                            if (i != 0) {
                                zzffu com_google_android_gms_internal_zzffu;
                                com.google.android.gms.internal.zzffu.zza com_google_android_gms_internal_zzffu_zza;
                                if (i == 10) {
                                    if (this.f19578a != 0) {
                                        com_google_android_gms_internal_zzffu = this.f19578a;
                                        com_google_android_gms_internal_zzffu_zza = (com.google.android.gms.internal.zzffu.zza) com_google_android_gms_internal_zzffu.mo4293a(zzg.f7410h, null, null);
                                        com_google_android_gms_internal_zzffu_zza.m20427a(com_google_android_gms_internal_zzffu);
                                        i = (com.google.android.gms.internal.zzdri.zza) com_google_android_gms_internal_zzffu_zza;
                                    } else {
                                        i = 0;
                                    }
                                    this.f19578a = (zzdri) com_google_android_gms_internal_zzffb.mo1879a(zzdri.m21012b(), com_google_android_gms_internal_zzffm);
                                    if (i != 0) {
                                        i.m20427a(this.f19578a);
                                        this.f19578a = (zzdri) i.m20430e();
                                    }
                                } else if (i == 18) {
                                    if (this.f19579b != 0) {
                                        com_google_android_gms_internal_zzffu = this.f19579b;
                                        com_google_android_gms_internal_zzffu_zza = (com.google.android.gms.internal.zzffu.zza) com_google_android_gms_internal_zzffu.mo4293a(zzg.f7410h, null, null);
                                        com_google_android_gms_internal_zzffu_zza.m20427a(com_google_android_gms_internal_zzffu);
                                        i = (com.google.android.gms.internal.zzdsu.zza) com_google_android_gms_internal_zzffu_zza;
                                    } else {
                                        i = 0;
                                    }
                                    this.f19579b = (zzdsu) com_google_android_gms_internal_zzffb.mo1879a(zzdsu.m21150b(), com_google_android_gms_internal_zzffm);
                                    if (i != 0) {
                                        i.m20427a(this.f19579b);
                                        this.f19579b = (zzdsu) i.m20430e();
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
                if (f19577d == 0) {
                    synchronized (zzdre.class) {
                        if (f19577d == null) {
                            f19577d = new zzb(f19576c);
                        }
                    }
                }
                return f19577d;
            case 9:
                return Byte.valueOf((byte) 1);
            case 10:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
        return f19576c;
    }

    static {
        zzffu com_google_android_gms_internal_zzdre = new zzdre();
        f19576c = com_google_android_gms_internal_zzdre;
        com_google_android_gms_internal_zzdre.mo4293a(zzg.f7408f, null, null);
        com_google_android_gms_internal_zzdre.f19235g.f7470e = false;
    }
}
