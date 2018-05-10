package com.google.android.gms.internal;

import com.google.android.gms.internal.zzffu.zzb;
import com.google.android.gms.internal.zzffu.zzg;
import com.google.android.gms.internal.zzffu.zzh;
import java.io.IOException;

public final class zzdtp extends zzffu<zzdtp, zza> implements zzfhg {
    private static final zzdtp f19705c;
    private static volatile zzfhk<zzdtp> f19706d;
    int f19707a;
    private zzdtr f19708b;

    public static final class zza extends com.google.android.gms.internal.zzffu.zza<zzdtp, zza> implements zzfhg {
        private zza() {
            super(zzdtp.f19705c);
        }

        public final zza m21249a() {
            m20429d();
            ((zzdtp) this.a).f19707a = 0;
            return this;
        }

        public final zza m21250a(zzdtr com_google_android_gms_internal_zzdtr) {
            m20429d();
            zzdtp.m21253a((zzdtp) this.a, com_google_android_gms_internal_zzdtr);
            return this;
        }
    }

    private zzdtp() {
    }

    public static zzdtp m21251a(zzfes com_google_android_gms_internal_zzfes) throws zzfge {
        return (zzdtp) zzffu.m20434a(f19705c, com_google_android_gms_internal_zzfes);
    }

    public static zza m21254b() {
        zzffu com_google_android_gms_internal_zzffu = f19705c;
        com.google.android.gms.internal.zzffu.zza com_google_android_gms_internal_zzffu_zza = (com.google.android.gms.internal.zzffu.zza) com_google_android_gms_internal_zzffu.mo4293a(zzg.f7410h, null, null);
        com_google_android_gms_internal_zzffu_zza.m20427a(com_google_android_gms_internal_zzffu);
        return (zza) com_google_android_gms_internal_zzffu_zza;
    }

    public final zzdtr m21256a() {
        return this.f19708b == null ? zzdtr.m21261b() : this.f19708b;
    }

    public final void mo4039a(zzffg com_google_android_gms_internal_zzffg) throws IOException {
        if (this.f19707a != 0) {
            com_google_android_gms_internal_zzffg.mo3532c(1, this.f19707a);
        }
        if (this.f19708b != null) {
            com_google_android_gms_internal_zzffg.mo3516a(2, this.f19708b == null ? zzdtr.m21261b() : this.f19708b);
        }
        this.g.m6090a(com_google_android_gms_internal_zzffg);
    }

    public final int mo4040c() {
        int i = this.h;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if (this.f19707a != 0) {
            i2 = 0 + zzffg.m13787e(1, this.f19707a);
        }
        if (this.f19708b != null) {
            i2 += zzffg.m13777c(2, this.f19708b == null ? zzdtr.m21261b() : this.f19708b);
        }
        i2 += this.g.m6093c();
        this.h = i2;
        return i2;
    }

    protected final Object mo4293a(int i, Object obj, Object obj2) {
        boolean z = false;
        switch (zzdtq.f7304a[i - 1]) {
            case 1:
                return new zzdtp();
            case 2:
                return f19705c;
            case 3:
                return null;
            case 4:
                return new zza();
            case 5:
                zzh com_google_android_gms_internal_zzffu_zzh = (zzh) obj;
                zzdtp com_google_android_gms_internal_zzdtp = (zzdtp) obj2;
                boolean z2 = this.f19707a != 0;
                int i2 = this.f19707a;
                if (com_google_android_gms_internal_zzdtp.f19707a != 0) {
                    z = true;
                }
                this.f19707a = com_google_android_gms_internal_zzffu_zzh.mo1901a(z2, i2, z, com_google_android_gms_internal_zzdtp.f19707a);
                this.f19708b = (zzdtr) com_google_android_gms_internal_zzffu_zzh.mo1904a(this.f19708b, com_google_android_gms_internal_zzdtp.f19708b);
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
                                    this.f19707a = com_google_android_gms_internal_zzffb.mo1889h();
                                } else if (i == 18) {
                                    if (this.f19708b != 0) {
                                        zzffu com_google_android_gms_internal_zzffu = this.f19708b;
                                        com.google.android.gms.internal.zzffu.zza com_google_android_gms_internal_zzffu_zza = (com.google.android.gms.internal.zzffu.zza) com_google_android_gms_internal_zzffu.mo4293a(zzg.f7410h, null, null);
                                        com_google_android_gms_internal_zzffu_zza.m20427a(com_google_android_gms_internal_zzffu);
                                        i = (com.google.android.gms.internal.zzdtr.zza) com_google_android_gms_internal_zzffu_zza;
                                    } else {
                                        i = 0;
                                    }
                                    this.f19708b = (zzdtr) com_google_android_gms_internal_zzffb.mo1879a(zzdtr.m21261b(), com_google_android_gms_internal_zzffm);
                                    if (i != 0) {
                                        i.m20427a(this.f19708b);
                                        this.f19708b = (zzdtr) i.m20430e();
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
                if (f19706d == 0) {
                    synchronized (zzdtp.class) {
                        if (f19706d == null) {
                            f19706d = new zzb(f19705c);
                        }
                    }
                }
                return f19706d;
            case 9:
                return Byte.valueOf((byte) 1);
            case 10:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
        return f19705c;
    }

    static /* synthetic */ void m21253a(zzdtp com_google_android_gms_internal_zzdtp, zzdtr com_google_android_gms_internal_zzdtr) {
        if (com_google_android_gms_internal_zzdtr == null) {
            throw new NullPointerException();
        }
        com_google_android_gms_internal_zzdtp.f19708b = com_google_android_gms_internal_zzdtr;
    }

    static {
        zzffu com_google_android_gms_internal_zzdtp = new zzdtp();
        f19705c = com_google_android_gms_internal_zzdtp;
        com_google_android_gms_internal_zzdtp.mo4293a(zzg.f7408f, null, null);
        com_google_android_gms_internal_zzdtp.f19235g.f7470e = false;
    }
}
