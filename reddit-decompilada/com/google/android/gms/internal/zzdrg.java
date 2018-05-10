package com.google.android.gms.internal;

import com.google.android.gms.internal.zzffu.zzb;
import com.google.android.gms.internal.zzffu.zzg;
import com.google.android.gms.internal.zzffu.zzh;
import java.io.IOException;

public final class zzdrg extends zzffu<zzdrg, zza> implements zzfhg {
    private static final zzdrg f19580d;
    private static volatile zzfhk<zzdrg> f19581e;
    int f19582a;
    zzfes f19583b = zzfes.f7377a;
    private zzdrk f19584c;

    public static final class zza extends com.google.android.gms.internal.zzffu.zza<zzdrg, zza> implements zzfhg {
        private zza() {
            super(zzdrg.f19580d);
        }

        public final zza m20997a() {
            m20429d();
            ((zzdrg) this.a).f19582a = 0;
            return this;
        }

        public final zza m20998a(zzdrk com_google_android_gms_internal_zzdrk) {
            m20429d();
            zzdrg.m21002a((zzdrg) this.a, com_google_android_gms_internal_zzdrk);
            return this;
        }

        public final zza m20999a(zzfes com_google_android_gms_internal_zzfes) {
            m20429d();
            zzdrg.m21003a((zzdrg) this.a, com_google_android_gms_internal_zzfes);
            return this;
        }
    }

    private zzdrg() {
    }

    public static zzdrg m21000a(zzfes com_google_android_gms_internal_zzfes) throws zzfge {
        return (zzdrg) zzffu.m20434a(f19580d, com_google_android_gms_internal_zzfes);
    }

    public static zza m21004b() {
        zzffu com_google_android_gms_internal_zzffu = f19580d;
        com.google.android.gms.internal.zzffu.zza com_google_android_gms_internal_zzffu_zza = (com.google.android.gms.internal.zzffu.zza) com_google_android_gms_internal_zzffu.mo4293a(zzg.f7410h, null, null);
        com_google_android_gms_internal_zzffu_zza.m20427a(com_google_android_gms_internal_zzffu);
        return (zza) com_google_android_gms_internal_zzffu_zza;
    }

    public static zzdrg m21005d() {
        return f19580d;
    }

    public final zzdrk m21007a() {
        return this.f19584c == null ? zzdrk.m21018a() : this.f19584c;
    }

    public final void mo4039a(zzffg com_google_android_gms_internal_zzffg) throws IOException {
        if (this.f19582a != 0) {
            com_google_android_gms_internal_zzffg.mo3532c(1, this.f19582a);
        }
        if (this.f19584c != null) {
            com_google_android_gms_internal_zzffg.mo3516a(2, this.f19584c == null ? zzdrk.m21018a() : this.f19584c);
        }
        if (!this.f19583b.m5958b()) {
            com_google_android_gms_internal_zzffg.mo3515a(3, this.f19583b);
        }
        this.g.m6090a(com_google_android_gms_internal_zzffg);
    }

    public final int mo4040c() {
        int i = this.h;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if (this.f19582a != 0) {
            i2 = 0 + zzffg.m13787e(1, this.f19582a);
        }
        if (this.f19584c != null) {
            i2 += zzffg.m13777c(2, this.f19584c == null ? zzdrk.m21018a() : this.f19584c);
        }
        if (!this.f19583b.m5958b()) {
            i2 += zzffg.m13776c(3, this.f19583b);
        }
        i2 += this.g.m6093c();
        this.h = i2;
        return i2;
    }

    protected final Object mo4293a(int i, Object obj, Object obj2) {
        boolean z = true;
        byte b = (byte) 0;
        switch (zzdrh.f7265a[i - 1]) {
            case 1:
                return new zzdrg();
            case 2:
                return f19580d;
            case 3:
                return null;
            case 4:
                return new zza();
            case 5:
                zzh com_google_android_gms_internal_zzffu_zzh = (zzh) obj;
                zzdrg com_google_android_gms_internal_zzdrg = (zzdrg) obj2;
                this.f19582a = com_google_android_gms_internal_zzffu_zzh.mo1901a(this.f19582a != 0, this.f19582a, com_google_android_gms_internal_zzdrg.f19582a != 0, com_google_android_gms_internal_zzdrg.f19582a);
                this.f19584c = (zzdrk) com_google_android_gms_internal_zzffu_zzh.mo1904a(this.f19584c, com_google_android_gms_internal_zzdrg.f19584c);
                boolean z2 = this.f19583b != zzfes.f7377a;
                zzfes com_google_android_gms_internal_zzfes = this.f19583b;
                if (com_google_android_gms_internal_zzdrg.f19583b == zzfes.f7377a) {
                    z = false;
                }
                this.f19583b = com_google_android_gms_internal_zzffu_zzh.mo1902a(z2, com_google_android_gms_internal_zzfes, z, com_google_android_gms_internal_zzdrg.f19583b);
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
                                    this.f19582a = com_google_android_gms_internal_zzffb.mo1889h();
                                } else if (i == 18) {
                                    if (this.f19584c != 0) {
                                        zzffu com_google_android_gms_internal_zzffu = this.f19584c;
                                        com.google.android.gms.internal.zzffu.zza com_google_android_gms_internal_zzffu_zza = (com.google.android.gms.internal.zzffu.zza) com_google_android_gms_internal_zzffu.mo4293a(zzg.f7410h, null, null);
                                        com_google_android_gms_internal_zzffu_zza.m20427a(com_google_android_gms_internal_zzffu);
                                        i = (com.google.android.gms.internal.zzdrk.zza) com_google_android_gms_internal_zzffu_zza;
                                    } else {
                                        i = 0;
                                    }
                                    this.f19584c = (zzdrk) com_google_android_gms_internal_zzffb.mo1879a(zzdrk.m21018a(), com_google_android_gms_internal_zzffm);
                                    if (i != 0) {
                                        i.m20427a(this.f19584c);
                                        this.f19584c = (zzdrk) i.m20430e();
                                    }
                                } else if (i == 26) {
                                    this.f19583b = com_google_android_gms_internal_zzffb.mo1888g();
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
                if (f19581e == 0) {
                    synchronized (zzdrg.class) {
                        if (f19581e == null) {
                            f19581e = new zzb(f19580d);
                        }
                    }
                }
                return f19581e;
            case 9:
                return Byte.valueOf((byte) 1);
            case 10:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
        return f19580d;
    }

    static /* synthetic */ void m21002a(zzdrg com_google_android_gms_internal_zzdrg, zzdrk com_google_android_gms_internal_zzdrk) {
        if (com_google_android_gms_internal_zzdrk == null) {
            throw new NullPointerException();
        }
        com_google_android_gms_internal_zzdrg.f19584c = com_google_android_gms_internal_zzdrk;
    }

    static /* synthetic */ void m21003a(zzdrg com_google_android_gms_internal_zzdrg, zzfes com_google_android_gms_internal_zzfes) {
        if (com_google_android_gms_internal_zzfes == null) {
            throw new NullPointerException();
        }
        com_google_android_gms_internal_zzdrg.f19583b = com_google_android_gms_internal_zzfes;
    }

    static {
        zzffu com_google_android_gms_internal_zzdrg = new zzdrg();
        f19580d = com_google_android_gms_internal_zzdrg;
        com_google_android_gms_internal_zzdrg.mo4293a(zzg.f7408f, null, null);
        com_google_android_gms_internal_zzdrg.f19235g.f7470e = false;
    }
}
