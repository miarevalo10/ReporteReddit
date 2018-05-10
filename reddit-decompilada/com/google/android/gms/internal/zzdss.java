package com.google.android.gms.internal;

import com.google.android.gms.internal.zzffu.zzb;
import com.google.android.gms.internal.zzffu.zzg;
import com.google.android.gms.internal.zzffu.zzh;
import java.io.IOException;

public final class zzdss extends zzffu<zzdss, zza> implements zzfhg {
    private static final zzdss f19646d;
    private static volatile zzfhk<zzdss> f19647e;
    int f19648a;
    zzfes f19649b = zzfes.f7377a;
    private zzdsw f19650c;

    public static final class zza extends com.google.android.gms.internal.zzffu.zza<zzdss, zza> implements zzfhg {
        private zza() {
            super(zzdss.f19646d);
        }

        public final zza m21135a() {
            m20429d();
            ((zzdss) this.a).f19648a = 0;
            return this;
        }

        public final zza m21136a(zzdsw com_google_android_gms_internal_zzdsw) {
            m20429d();
            zzdss.m21140a((zzdss) this.a, com_google_android_gms_internal_zzdsw);
            return this;
        }

        public final zza m21137a(zzfes com_google_android_gms_internal_zzfes) {
            m20429d();
            zzdss.m21141a((zzdss) this.a, com_google_android_gms_internal_zzfes);
            return this;
        }
    }

    private zzdss() {
    }

    public static zzdss m21138a(zzfes com_google_android_gms_internal_zzfes) throws zzfge {
        return (zzdss) zzffu.m20434a(f19646d, com_google_android_gms_internal_zzfes);
    }

    public static zza m21142b() {
        zzffu com_google_android_gms_internal_zzffu = f19646d;
        com.google.android.gms.internal.zzffu.zza com_google_android_gms_internal_zzffu_zza = (com.google.android.gms.internal.zzffu.zza) com_google_android_gms_internal_zzffu.mo4293a(zzg.f7410h, null, null);
        com_google_android_gms_internal_zzffu_zza.m20427a(com_google_android_gms_internal_zzffu);
        return (zza) com_google_android_gms_internal_zzffu_zza;
    }

    public static zzdss m21143d() {
        return f19646d;
    }

    public final zzdsw m21145a() {
        return this.f19650c == null ? zzdsw.m21156b() : this.f19650c;
    }

    public final void mo4039a(zzffg com_google_android_gms_internal_zzffg) throws IOException {
        if (this.f19648a != 0) {
            com_google_android_gms_internal_zzffg.mo3532c(1, this.f19648a);
        }
        if (this.f19650c != null) {
            com_google_android_gms_internal_zzffg.mo3516a(2, this.f19650c == null ? zzdsw.m21156b() : this.f19650c);
        }
        if (!this.f19649b.m5958b()) {
            com_google_android_gms_internal_zzffg.mo3515a(3, this.f19649b);
        }
        this.g.m6090a(com_google_android_gms_internal_zzffg);
    }

    public final int mo4040c() {
        int i = this.h;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if (this.f19648a != 0) {
            i2 = 0 + zzffg.m13787e(1, this.f19648a);
        }
        if (this.f19650c != null) {
            i2 += zzffg.m13777c(2, this.f19650c == null ? zzdsw.m21156b() : this.f19650c);
        }
        if (!this.f19649b.m5958b()) {
            i2 += zzffg.m13776c(3, this.f19649b);
        }
        i2 += this.g.m6093c();
        this.h = i2;
        return i2;
    }

    protected final Object mo4293a(int i, Object obj, Object obj2) {
        boolean z = true;
        byte b = (byte) 0;
        switch (zzdst.f7281a[i - 1]) {
            case 1:
                return new zzdss();
            case 2:
                return f19646d;
            case 3:
                return null;
            case 4:
                return new zza();
            case 5:
                zzh com_google_android_gms_internal_zzffu_zzh = (zzh) obj;
                zzdss com_google_android_gms_internal_zzdss = (zzdss) obj2;
                this.f19648a = com_google_android_gms_internal_zzffu_zzh.mo1901a(this.f19648a != 0, this.f19648a, com_google_android_gms_internal_zzdss.f19648a != 0, com_google_android_gms_internal_zzdss.f19648a);
                this.f19650c = (zzdsw) com_google_android_gms_internal_zzffu_zzh.mo1904a(this.f19650c, com_google_android_gms_internal_zzdss.f19650c);
                boolean z2 = this.f19649b != zzfes.f7377a;
                zzfes com_google_android_gms_internal_zzfes = this.f19649b;
                if (com_google_android_gms_internal_zzdss.f19649b == zzfes.f7377a) {
                    z = false;
                }
                this.f19649b = com_google_android_gms_internal_zzffu_zzh.mo1902a(z2, com_google_android_gms_internal_zzfes, z, com_google_android_gms_internal_zzdss.f19649b);
                return this;
            case 6:
                zzffb com_google_android_gms_internal_zzffb = (zzffb) obj;
                zzffm com_google_android_gms_internal_zzffm = (zzffm) obj2;
                if (com_google_android_gms_internal_zzffm != null) {
                    while (b == (byte) 0) {
                        try {
                            i = com_google_android_gms_internal_zzffb.mo1878a();
                            if (i != 0) {
                                if (i == 8) {
                                    this.f19648a = com_google_android_gms_internal_zzffb.mo1889h();
                                } else if (i == 18) {
                                    if (this.f19650c != 0) {
                                        zzffu com_google_android_gms_internal_zzffu = this.f19650c;
                                        com.google.android.gms.internal.zzffu.zza com_google_android_gms_internal_zzffu_zza = (com.google.android.gms.internal.zzffu.zza) com_google_android_gms_internal_zzffu.mo4293a(zzg.f7410h, null, null);
                                        com_google_android_gms_internal_zzffu_zza.m20427a(com_google_android_gms_internal_zzffu);
                                        i = (com.google.android.gms.internal.zzdsw.zza) com_google_android_gms_internal_zzffu_zza;
                                    } else {
                                        i = 0;
                                    }
                                    this.f19650c = (zzdsw) com_google_android_gms_internal_zzffb.mo1879a(zzdsw.m21156b(), com_google_android_gms_internal_zzffm);
                                    if (i != 0) {
                                        i.m20427a(this.f19650c);
                                        this.f19650c = (zzdsw) i.m20430e();
                                    }
                                } else if (i == 26) {
                                    this.f19649b = com_google_android_gms_internal_zzffb.mo1888g();
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
                if (f19647e == 0) {
                    synchronized (zzdss.class) {
                        if (f19647e == null) {
                            f19647e = new zzb(f19646d);
                        }
                    }
                }
                return f19647e;
            case 9:
                return Byte.valueOf((byte) 1);
            case 10:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
        return f19646d;
    }

    static /* synthetic */ void m21140a(zzdss com_google_android_gms_internal_zzdss, zzdsw com_google_android_gms_internal_zzdsw) {
        if (com_google_android_gms_internal_zzdsw == null) {
            throw new NullPointerException();
        }
        com_google_android_gms_internal_zzdss.f19650c = com_google_android_gms_internal_zzdsw;
    }

    static /* synthetic */ void m21141a(zzdss com_google_android_gms_internal_zzdss, zzfes com_google_android_gms_internal_zzfes) {
        if (com_google_android_gms_internal_zzfes == null) {
            throw new NullPointerException();
        }
        com_google_android_gms_internal_zzdss.f19649b = com_google_android_gms_internal_zzfes;
    }

    static {
        zzffu com_google_android_gms_internal_zzdss = new zzdss();
        f19646d = com_google_android_gms_internal_zzdss;
        com_google_android_gms_internal_zzdss.mo4293a(zzg.f7408f, null, null);
        com_google_android_gms_internal_zzdss.f19235g.f7470e = false;
    }
}
