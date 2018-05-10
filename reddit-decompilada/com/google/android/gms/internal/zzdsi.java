package com.google.android.gms.internal;

import com.google.android.gms.internal.zzffu.zzb;
import com.google.android.gms.internal.zzffu.zzg;
import com.google.android.gms.internal.zzffu.zzh;
import java.io.IOException;

public final class zzdsi extends zzffu<zzdsi, zza> implements zzfhg {
    private static final zzdsi f19630d;
    private static volatile zzfhk<zzdsi> f19631e;
    int f19632a;
    zzfes f19633b = zzfes.f7377a;
    private zzdsk f19634c;

    public static final class zza extends com.google.android.gms.internal.zzffu.zza<zzdsi, zza> implements zzfhg {
        private zza() {
            super(zzdsi.f19630d);
        }

        public final zza m21099a() {
            m20429d();
            ((zzdsi) this.a).f19632a = 0;
            return this;
        }

        public final zza m21100a(zzdsk com_google_android_gms_internal_zzdsk) {
            m20429d();
            zzdsi.m21104a((zzdsi) this.a, com_google_android_gms_internal_zzdsk);
            return this;
        }

        public final zza m21101a(zzfes com_google_android_gms_internal_zzfes) {
            m20429d();
            zzdsi.m21105a((zzdsi) this.a, com_google_android_gms_internal_zzfes);
            return this;
        }
    }

    private zzdsi() {
    }

    public static zzdsi m21102a(zzfes com_google_android_gms_internal_zzfes) throws zzfge {
        return (zzdsi) zzffu.m20434a(f19630d, com_google_android_gms_internal_zzfes);
    }

    public static zza m21106b() {
        zzffu com_google_android_gms_internal_zzffu = f19630d;
        com.google.android.gms.internal.zzffu.zza com_google_android_gms_internal_zzffu_zza = (com.google.android.gms.internal.zzffu.zza) com_google_android_gms_internal_zzffu.mo4293a(zzg.f7410h, null, null);
        com_google_android_gms_internal_zzffu_zza.m20427a(com_google_android_gms_internal_zzffu);
        return (zza) com_google_android_gms_internal_zzffu_zza;
    }

    public final zzdsk m21108a() {
        return this.f19634c == null ? zzdsk.m21122d() : this.f19634c;
    }

    public final void mo4039a(zzffg com_google_android_gms_internal_zzffg) throws IOException {
        if (this.f19632a != 0) {
            com_google_android_gms_internal_zzffg.mo3532c(1, this.f19632a);
        }
        if (this.f19634c != null) {
            com_google_android_gms_internal_zzffg.mo3516a(2, this.f19634c == null ? zzdsk.m21122d() : this.f19634c);
        }
        if (!this.f19633b.m5958b()) {
            com_google_android_gms_internal_zzffg.mo3515a(3, this.f19633b);
        }
        this.g.m6090a(com_google_android_gms_internal_zzffg);
    }

    public final int mo4040c() {
        int i = this.h;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if (this.f19632a != 0) {
            i2 = 0 + zzffg.m13787e(1, this.f19632a);
        }
        if (this.f19634c != null) {
            i2 += zzffg.m13777c(2, this.f19634c == null ? zzdsk.m21122d() : this.f19634c);
        }
        if (!this.f19633b.m5958b()) {
            i2 += zzffg.m13776c(3, this.f19633b);
        }
        i2 += this.g.m6093c();
        this.h = i2;
        return i2;
    }

    protected final Object mo4293a(int i, Object obj, Object obj2) {
        boolean z = true;
        byte b = (byte) 0;
        switch (zzdsj.f7278a[i - 1]) {
            case 1:
                return new zzdsi();
            case 2:
                return f19630d;
            case 3:
                return null;
            case 4:
                return new zza();
            case 5:
                zzh com_google_android_gms_internal_zzffu_zzh = (zzh) obj;
                zzdsi com_google_android_gms_internal_zzdsi = (zzdsi) obj2;
                this.f19632a = com_google_android_gms_internal_zzffu_zzh.mo1901a(this.f19632a != 0, this.f19632a, com_google_android_gms_internal_zzdsi.f19632a != 0, com_google_android_gms_internal_zzdsi.f19632a);
                this.f19634c = (zzdsk) com_google_android_gms_internal_zzffu_zzh.mo1904a(this.f19634c, com_google_android_gms_internal_zzdsi.f19634c);
                boolean z2 = this.f19633b != zzfes.f7377a;
                zzfes com_google_android_gms_internal_zzfes = this.f19633b;
                if (com_google_android_gms_internal_zzdsi.f19633b == zzfes.f7377a) {
                    z = false;
                }
                this.f19633b = com_google_android_gms_internal_zzffu_zzh.mo1902a(z2, com_google_android_gms_internal_zzfes, z, com_google_android_gms_internal_zzdsi.f19633b);
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
                                    this.f19632a = com_google_android_gms_internal_zzffb.mo1889h();
                                } else if (i == 18) {
                                    if (this.f19634c != 0) {
                                        zzffu com_google_android_gms_internal_zzffu = this.f19634c;
                                        com.google.android.gms.internal.zzffu.zza com_google_android_gms_internal_zzffu_zza = (com.google.android.gms.internal.zzffu.zza) com_google_android_gms_internal_zzffu.mo4293a(zzg.f7410h, null, null);
                                        com_google_android_gms_internal_zzffu_zza.m20427a(com_google_android_gms_internal_zzffu);
                                        i = (com.google.android.gms.internal.zzdsk.zza) com_google_android_gms_internal_zzffu_zza;
                                    } else {
                                        i = 0;
                                    }
                                    this.f19634c = (zzdsk) com_google_android_gms_internal_zzffb.mo1879a(zzdsk.m21122d(), com_google_android_gms_internal_zzffm);
                                    if (i != 0) {
                                        i.m20427a(this.f19634c);
                                        this.f19634c = (zzdsk) i.m20430e();
                                    }
                                } else if (i == 26) {
                                    this.f19633b = com_google_android_gms_internal_zzffb.mo1888g();
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
                if (f19631e == 0) {
                    synchronized (zzdsi.class) {
                        if (f19631e == null) {
                            f19631e = new zzb(f19630d);
                        }
                    }
                }
                return f19631e;
            case 9:
                return Byte.valueOf((byte) 1);
            case 10:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
        return f19630d;
    }

    static /* synthetic */ void m21104a(zzdsi com_google_android_gms_internal_zzdsi, zzdsk com_google_android_gms_internal_zzdsk) {
        if (com_google_android_gms_internal_zzdsk == null) {
            throw new NullPointerException();
        }
        com_google_android_gms_internal_zzdsi.f19634c = com_google_android_gms_internal_zzdsk;
    }

    static /* synthetic */ void m21105a(zzdsi com_google_android_gms_internal_zzdsi, zzfes com_google_android_gms_internal_zzfes) {
        if (com_google_android_gms_internal_zzfes == null) {
            throw new NullPointerException();
        }
        com_google_android_gms_internal_zzdsi.f19633b = com_google_android_gms_internal_zzfes;
    }

    static {
        zzffu com_google_android_gms_internal_zzdsi = new zzdsi();
        f19630d = com_google_android_gms_internal_zzdsi;
        com_google_android_gms_internal_zzdsi.mo4293a(zzg.f7408f, null, null);
        com_google_android_gms_internal_zzdsi.f19235g.f7470e = false;
    }
}
