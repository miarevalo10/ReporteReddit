package com.google.android.gms.internal;

import com.google.android.gms.internal.zzffu.zzb;
import com.google.android.gms.internal.zzffu.zzg;
import com.google.android.gms.internal.zzffu.zzh;
import java.io.IOException;

public final class zzdrs extends zzffu<zzdrs, zza> implements zzfhg {
    private static final zzdrs f19604d;
    private static volatile zzfhk<zzdrs> f19605e;
    int f19606a;
    zzfes f19607b = zzfes.f7377a;
    private zzdrw f19608c;

    public static final class zza extends com.google.android.gms.internal.zzffu.zza<zzdrs, zza> implements zzfhg {
        private zza() {
            super(zzdrs.f19604d);
        }

        public final zza m21047a() {
            m20429d();
            ((zzdrs) this.a).f19606a = 0;
            return this;
        }

        public final zza m21048a(zzdrw com_google_android_gms_internal_zzdrw) {
            m20429d();
            zzdrs.m21053a((zzdrs) this.a, com_google_android_gms_internal_zzdrw);
            return this;
        }

        public final zza m21049a(zzfes com_google_android_gms_internal_zzfes) {
            m20429d();
            zzdrs.m21054a((zzdrs) this.a, com_google_android_gms_internal_zzfes);
            return this;
        }
    }

    private zzdrs() {
    }

    public static zza m21050a() {
        zzffu com_google_android_gms_internal_zzffu = f19604d;
        com.google.android.gms.internal.zzffu.zza com_google_android_gms_internal_zzffu_zza = (com.google.android.gms.internal.zzffu.zza) com_google_android_gms_internal_zzffu.mo4293a(zzg.f7410h, null, null);
        com_google_android_gms_internal_zzffu_zza.m20427a(com_google_android_gms_internal_zzffu);
        return (zza) com_google_android_gms_internal_zzffu_zza;
    }

    public static zzdrs m21051a(zzfes com_google_android_gms_internal_zzfes) throws zzfge {
        return (zzdrs) zzffu.m20434a(f19604d, com_google_android_gms_internal_zzfes);
    }

    public final void mo4039a(zzffg com_google_android_gms_internal_zzffg) throws IOException {
        if (this.f19606a != 0) {
            com_google_android_gms_internal_zzffg.mo3532c(1, this.f19606a);
        }
        if (this.f19608c != null) {
            com_google_android_gms_internal_zzffg.mo3516a(2, this.f19608c == null ? zzdrw.m21064a() : this.f19608c);
        }
        if (!this.f19607b.m5958b()) {
            com_google_android_gms_internal_zzffg.mo3515a(3, this.f19607b);
        }
        this.g.m6090a(com_google_android_gms_internal_zzffg);
    }

    public final int mo4040c() {
        int i = this.h;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if (this.f19606a != 0) {
            i2 = 0 + zzffg.m13787e(1, this.f19606a);
        }
        if (this.f19608c != null) {
            i2 += zzffg.m13777c(2, this.f19608c == null ? zzdrw.m21064a() : this.f19608c);
        }
        if (!this.f19607b.m5958b()) {
            i2 += zzffg.m13776c(3, this.f19607b);
        }
        i2 += this.g.m6093c();
        this.h = i2;
        return i2;
    }

    protected final Object mo4293a(int i, Object obj, Object obj2) {
        boolean z = true;
        byte b = (byte) 0;
        switch (zzdrt.f7271a[i - 1]) {
            case 1:
                return new zzdrs();
            case 2:
                return f19604d;
            case 3:
                return null;
            case 4:
                return new zza();
            case 5:
                zzh com_google_android_gms_internal_zzffu_zzh = (zzh) obj;
                zzdrs com_google_android_gms_internal_zzdrs = (zzdrs) obj2;
                this.f19606a = com_google_android_gms_internal_zzffu_zzh.mo1901a(this.f19606a != 0, this.f19606a, com_google_android_gms_internal_zzdrs.f19606a != 0, com_google_android_gms_internal_zzdrs.f19606a);
                this.f19608c = (zzdrw) com_google_android_gms_internal_zzffu_zzh.mo1904a(this.f19608c, com_google_android_gms_internal_zzdrs.f19608c);
                boolean z2 = this.f19607b != zzfes.f7377a;
                zzfes com_google_android_gms_internal_zzfes = this.f19607b;
                if (com_google_android_gms_internal_zzdrs.f19607b == zzfes.f7377a) {
                    z = false;
                }
                this.f19607b = com_google_android_gms_internal_zzffu_zzh.mo1902a(z2, com_google_android_gms_internal_zzfes, z, com_google_android_gms_internal_zzdrs.f19607b);
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
                                    this.f19606a = com_google_android_gms_internal_zzffb.mo1889h();
                                } else if (i == 18) {
                                    if (this.f19608c != 0) {
                                        zzffu com_google_android_gms_internal_zzffu = this.f19608c;
                                        com.google.android.gms.internal.zzffu.zza com_google_android_gms_internal_zzffu_zza = (com.google.android.gms.internal.zzffu.zza) com_google_android_gms_internal_zzffu.mo4293a(zzg.f7410h, null, null);
                                        com_google_android_gms_internal_zzffu_zza.m20427a(com_google_android_gms_internal_zzffu);
                                        i = (com.google.android.gms.internal.zzdrw.zza) com_google_android_gms_internal_zzffu_zza;
                                    } else {
                                        i = 0;
                                    }
                                    this.f19608c = (zzdrw) com_google_android_gms_internal_zzffb.mo1879a(zzdrw.m21064a(), com_google_android_gms_internal_zzffm);
                                    if (i != 0) {
                                        i.m20427a(this.f19608c);
                                        this.f19608c = (zzdrw) i.m20430e();
                                    }
                                } else if (i == 26) {
                                    this.f19607b = com_google_android_gms_internal_zzffb.mo1888g();
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
                if (f19605e == 0) {
                    synchronized (zzdrs.class) {
                        if (f19605e == null) {
                            f19605e = new zzb(f19604d);
                        }
                    }
                }
                return f19605e;
            case 9:
                return Byte.valueOf((byte) 1);
            case 10:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
        return f19604d;
    }

    static /* synthetic */ void m21053a(zzdrs com_google_android_gms_internal_zzdrs, zzdrw com_google_android_gms_internal_zzdrw) {
        if (com_google_android_gms_internal_zzdrw == null) {
            throw new NullPointerException();
        }
        com_google_android_gms_internal_zzdrs.f19608c = com_google_android_gms_internal_zzdrw;
    }

    static /* synthetic */ void m21054a(zzdrs com_google_android_gms_internal_zzdrs, zzfes com_google_android_gms_internal_zzfes) {
        if (com_google_android_gms_internal_zzfes == null) {
            throw new NullPointerException();
        }
        com_google_android_gms_internal_zzdrs.f19607b = com_google_android_gms_internal_zzfes;
    }

    static {
        zzffu com_google_android_gms_internal_zzdrs = new zzdrs();
        f19604d = com_google_android_gms_internal_zzdrs;
        com_google_android_gms_internal_zzdrs.mo4293a(zzg.f7408f, null, null);
        com_google_android_gms_internal_zzdrs.f19235g.f7470e = false;
    }
}
