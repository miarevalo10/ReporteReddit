package com.google.android.gms.internal;

import com.google.android.gms.internal.zzffu.zzb;
import com.google.android.gms.internal.zzffu.zzg;
import com.google.android.gms.internal.zzffu.zzh;
import java.io.IOException;

public final class zzdry extends zzffu<zzdry, zza> implements zzfhg {
    private static final zzdry f19615c;
    private static volatile zzfhk<zzdry> f19616d;
    int f19617a;
    zzfes f19618b = zzfes.f7377a;

    public static final class zza extends com.google.android.gms.internal.zzffu.zza<zzdry, zza> implements zzfhg {
        private zza() {
            super(zzdry.f19615c);
        }

        public final zza m21069a() {
            m20429d();
            ((zzdry) this.a).f19617a = 0;
            return this;
        }

        public final zza m21070a(zzfes com_google_android_gms_internal_zzfes) {
            m20429d();
            zzdry.m21074a((zzdry) this.a, com_google_android_gms_internal_zzfes);
            return this;
        }
    }

    private zzdry() {
    }

    public static zza m21071a() {
        zzffu com_google_android_gms_internal_zzffu = f19615c;
        com.google.android.gms.internal.zzffu.zza com_google_android_gms_internal_zzffu_zza = (com.google.android.gms.internal.zzffu.zza) com_google_android_gms_internal_zzffu.mo4293a(zzg.f7410h, null, null);
        com_google_android_gms_internal_zzffu_zza.m20427a(com_google_android_gms_internal_zzffu);
        return (zza) com_google_android_gms_internal_zzffu_zza;
    }

    public static zzdry m21072a(zzfes com_google_android_gms_internal_zzfes) throws zzfge {
        return (zzdry) zzffu.m20434a(f19615c, com_google_android_gms_internal_zzfes);
    }

    public final void mo4039a(zzffg com_google_android_gms_internal_zzffg) throws IOException {
        if (this.f19617a != 0) {
            com_google_android_gms_internal_zzffg.mo3532c(1, this.f19617a);
        }
        if (!this.f19618b.m5958b()) {
            com_google_android_gms_internal_zzffg.mo3515a(2, this.f19618b);
        }
        this.g.m6090a(com_google_android_gms_internal_zzffg);
    }

    public final int mo4040c() {
        int i = this.h;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if (this.f19617a != 0) {
            i2 = 0 + zzffg.m13787e(1, this.f19617a);
        }
        if (!this.f19618b.m5958b()) {
            i2 += zzffg.m13776c(2, this.f19618b);
        }
        i2 += this.g.m6093c();
        this.h = i2;
        return i2;
    }

    protected final Object mo4293a(int i, Object obj, Object obj2) {
        boolean z = true;
        byte b = (byte) 0;
        switch (zzdrz.f7274a[i - 1]) {
            case 1:
                return new zzdry();
            case 2:
                return f19615c;
            case 3:
                return null;
            case 4:
                return new zza();
            case 5:
                zzh com_google_android_gms_internal_zzffu_zzh = (zzh) obj;
                zzdry com_google_android_gms_internal_zzdry = (zzdry) obj2;
                this.f19617a = com_google_android_gms_internal_zzffu_zzh.mo1901a(this.f19617a != 0, this.f19617a, com_google_android_gms_internal_zzdry.f19617a != 0, com_google_android_gms_internal_zzdry.f19617a);
                boolean z2 = this.f19618b != zzfes.f7377a;
                zzfes com_google_android_gms_internal_zzfes = this.f19618b;
                if (com_google_android_gms_internal_zzdry.f19618b == zzfes.f7377a) {
                    z = false;
                }
                this.f19618b = com_google_android_gms_internal_zzffu_zzh.mo1902a(z2, com_google_android_gms_internal_zzfes, z, com_google_android_gms_internal_zzdry.f19618b);
                return this;
            case 6:
                zzffb com_google_android_gms_internal_zzffb = (zzffb) obj;
                if (((zzffm) obj2) != null) {
                    while (b == (byte) 0) {
                        try {
                            i = com_google_android_gms_internal_zzffb.mo1878a();
                            if (i != 0) {
                                if (i == 8) {
                                    this.f19617a = com_google_android_gms_internal_zzffb.mo1889h();
                                } else if (i == 18) {
                                    this.f19618b = com_google_android_gms_internal_zzffb.mo1888g();
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
                if (f19616d == 0) {
                    synchronized (zzdry.class) {
                        if (f19616d == null) {
                            f19616d = new zzb(f19615c);
                        }
                    }
                }
                return f19616d;
            case 9:
                return Byte.valueOf((byte) 1);
            case 10:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
        return f19615c;
    }

    static /* synthetic */ void m21074a(zzdry com_google_android_gms_internal_zzdry, zzfes com_google_android_gms_internal_zzfes) {
        if (com_google_android_gms_internal_zzfes == null) {
            throw new NullPointerException();
        }
        com_google_android_gms_internal_zzdry.f19618b = com_google_android_gms_internal_zzfes;
    }

    static {
        zzffu com_google_android_gms_internal_zzdry = new zzdry();
        f19615c = com_google_android_gms_internal_zzdry;
        com_google_android_gms_internal_zzdry.mo4293a(zzg.f7408f, null, null);
        com_google_android_gms_internal_zzdry.f19235g.f7470e = false;
    }
}
