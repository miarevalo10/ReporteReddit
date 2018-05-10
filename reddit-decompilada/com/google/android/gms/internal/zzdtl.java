package com.google.android.gms.internal;

import com.google.android.gms.internal.zzffu.zzb;
import com.google.android.gms.internal.zzffu.zzg;
import com.google.android.gms.internal.zzffu.zzh;
import java.io.IOException;

public final class zzdtl extends zzffu<zzdtl, zza> implements zzfhg {
    private static final zzdtl f19698c;
    private static volatile zzfhk<zzdtl> f19699d;
    int f19700a;
    zzdtn f19701b;

    public static final class zza extends com.google.android.gms.internal.zzffu.zza<zzdtl, zza> implements zzfhg {
        private zza() {
            super(zzdtl.f19698c);
        }

        public final zza m21233a() {
            m20429d();
            ((zzdtl) this.a).f19700a = 0;
            return this;
        }

        public final zza m21234a(zzdtn com_google_android_gms_internal_zzdtn) {
            m20429d();
            zzdtl.m21238a((zzdtl) this.a, com_google_android_gms_internal_zzdtn);
            return this;
        }
    }

    private zzdtl() {
    }

    public static zza m21235a() {
        zzffu com_google_android_gms_internal_zzffu = f19698c;
        com.google.android.gms.internal.zzffu.zza com_google_android_gms_internal_zzffu_zza = (com.google.android.gms.internal.zzffu.zza) com_google_android_gms_internal_zzffu.mo4293a(zzg.f7410h, null, null);
        com_google_android_gms_internal_zzffu_zza.m20427a(com_google_android_gms_internal_zzffu);
        return (zza) com_google_android_gms_internal_zzffu_zza;
    }

    public static zzdtl m21236a(zzfes com_google_android_gms_internal_zzfes) throws zzfge {
        return (zzdtl) zzffu.m20434a(f19698c, com_google_android_gms_internal_zzfes);
    }

    public final void mo4039a(zzffg com_google_android_gms_internal_zzffg) throws IOException {
        if (this.f19700a != 0) {
            com_google_android_gms_internal_zzffg.mo3532c(1, this.f19700a);
        }
        if (this.f19701b != null) {
            com_google_android_gms_internal_zzffg.mo3516a(2, this.f19701b == null ? zzdtn.m21243a() : this.f19701b);
        }
        this.g.m6090a(com_google_android_gms_internal_zzffg);
    }

    public final int mo4040c() {
        int i = this.h;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if (this.f19700a != 0) {
            i2 = 0 + zzffg.m13787e(1, this.f19700a);
        }
        if (this.f19701b != null) {
            i2 += zzffg.m13777c(2, this.f19701b == null ? zzdtn.m21243a() : this.f19701b);
        }
        i2 += this.g.m6093c();
        this.h = i2;
        return i2;
    }

    protected final Object mo4293a(int i, Object obj, Object obj2) {
        boolean z = false;
        switch (zzdtm.f7302a[i - 1]) {
            case 1:
                return new zzdtl();
            case 2:
                return f19698c;
            case 3:
                return null;
            case 4:
                return new zza();
            case 5:
                zzh com_google_android_gms_internal_zzffu_zzh = (zzh) obj;
                zzdtl com_google_android_gms_internal_zzdtl = (zzdtl) obj2;
                boolean z2 = this.f19700a != 0;
                int i2 = this.f19700a;
                if (com_google_android_gms_internal_zzdtl.f19700a != 0) {
                    z = true;
                }
                this.f19700a = com_google_android_gms_internal_zzffu_zzh.mo1901a(z2, i2, z, com_google_android_gms_internal_zzdtl.f19700a);
                this.f19701b = (zzdtn) com_google_android_gms_internal_zzffu_zzh.mo1904a(this.f19701b, com_google_android_gms_internal_zzdtl.f19701b);
                return this;
            case 6:
                zzffb com_google_android_gms_internal_zzffb = (zzffb) obj;
                zzffm com_google_android_gms_internal_zzffm = (zzffm) obj2;
                if (com_google_android_gms_internal_zzffm != null) {
                    while (!z) {
                        try {
                            i = com_google_android_gms_internal_zzffb.mo1878a();
                            if (i != 0) {
                                if (i == 8) {
                                    this.f19700a = com_google_android_gms_internal_zzffb.mo1889h();
                                } else if (i == 18) {
                                    if (this.f19701b != 0) {
                                        zzffu com_google_android_gms_internal_zzffu = this.f19701b;
                                        com.google.android.gms.internal.zzffu.zza com_google_android_gms_internal_zzffu_zza = (com.google.android.gms.internal.zzffu.zza) com_google_android_gms_internal_zzffu.mo4293a(zzg.f7410h, null, null);
                                        com_google_android_gms_internal_zzffu_zza.m20427a(com_google_android_gms_internal_zzffu);
                                        i = (com.google.android.gms.internal.zzdtn.zza) com_google_android_gms_internal_zzffu_zza;
                                    } else {
                                        i = 0;
                                    }
                                    this.f19701b = (zzdtn) com_google_android_gms_internal_zzffb.mo1879a(zzdtn.m21243a(), com_google_android_gms_internal_zzffm);
                                    if (i != 0) {
                                        i.m20427a(this.f19701b);
                                        this.f19701b = (zzdtn) i.m20430e();
                                    }
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
                if (f19699d == 0) {
                    synchronized (zzdtl.class) {
                        if (f19699d == null) {
                            f19699d = new zzb(f19698c);
                        }
                    }
                }
                return f19699d;
            case 9:
                return Byte.valueOf((byte) 1);
            case 10:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
        return f19698c;
    }

    static /* synthetic */ void m21238a(zzdtl com_google_android_gms_internal_zzdtl, zzdtn com_google_android_gms_internal_zzdtn) {
        if (com_google_android_gms_internal_zzdtn == null) {
            throw new NullPointerException();
        }
        com_google_android_gms_internal_zzdtl.f19701b = com_google_android_gms_internal_zzdtn;
    }

    static {
        zzffu com_google_android_gms_internal_zzdtl = new zzdtl();
        f19698c = com_google_android_gms_internal_zzdtl;
        com_google_android_gms_internal_zzdtl.mo4293a(zzg.f7408f, null, null);
        com_google_android_gms_internal_zzdtl.f19235g.f7470e = false;
    }
}
