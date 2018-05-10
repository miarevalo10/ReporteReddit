package com.google.android.gms.internal;

import com.google.android.gms.internal.zzffu.zzb;
import com.google.android.gms.internal.zzffu.zzg;
import com.google.android.gms.internal.zzffu.zzh;
import java.io.IOException;

public final class zzdrm extends zzffu<zzdrm, zza> implements zzfhg {
    private static final zzdrm f19592d;
    private static volatile zzfhk<zzdrm> f19593e;
    int f19594a;
    zzfes f19595b = zzfes.f7377a;
    private zzdrq f19596c;

    public static final class zza extends com.google.android.gms.internal.zzffu.zza<zzdrm, zza> implements zzfhg {
        private zza() {
            super(zzdrm.f19592d);
        }

        public final zza m21023a() {
            m20429d();
            ((zzdrm) this.a).f19594a = 0;
            return this;
        }

        public final zza m21024a(zzdrq com_google_android_gms_internal_zzdrq) {
            m20429d();
            zzdrm.m21028a((zzdrm) this.a, com_google_android_gms_internal_zzdrq);
            return this;
        }

        public final zza m21025a(zzfes com_google_android_gms_internal_zzfes) {
            m20429d();
            zzdrm.m21029a((zzdrm) this.a, com_google_android_gms_internal_zzfes);
            return this;
        }
    }

    private zzdrm() {
    }

    public static zzdrm m21026a(zzfes com_google_android_gms_internal_zzfes) throws zzfge {
        return (zzdrm) zzffu.m20434a(f19592d, com_google_android_gms_internal_zzfes);
    }

    public static zza m21030b() {
        zzffu com_google_android_gms_internal_zzffu = f19592d;
        com.google.android.gms.internal.zzffu.zza com_google_android_gms_internal_zzffu_zza = (com.google.android.gms.internal.zzffu.zza) com_google_android_gms_internal_zzffu.mo4293a(zzg.f7410h, null, null);
        com_google_android_gms_internal_zzffu_zza.m20427a(com_google_android_gms_internal_zzffu);
        return (zza) com_google_android_gms_internal_zzffu_zza;
    }

    public final zzdrq m21032a() {
        return this.f19596c == null ? zzdrq.m21042a() : this.f19596c;
    }

    public final void mo4039a(zzffg com_google_android_gms_internal_zzffg) throws IOException {
        if (this.f19594a != 0) {
            com_google_android_gms_internal_zzffg.mo3532c(1, this.f19594a);
        }
        if (this.f19596c != null) {
            com_google_android_gms_internal_zzffg.mo3516a(2, this.f19596c == null ? zzdrq.m21042a() : this.f19596c);
        }
        if (!this.f19595b.m5958b()) {
            com_google_android_gms_internal_zzffg.mo3515a(3, this.f19595b);
        }
        this.g.m6090a(com_google_android_gms_internal_zzffg);
    }

    public final int mo4040c() {
        int i = this.h;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if (this.f19594a != 0) {
            i2 = 0 + zzffg.m13787e(1, this.f19594a);
        }
        if (this.f19596c != null) {
            i2 += zzffg.m13777c(2, this.f19596c == null ? zzdrq.m21042a() : this.f19596c);
        }
        if (!this.f19595b.m5958b()) {
            i2 += zzffg.m13776c(3, this.f19595b);
        }
        i2 += this.g.m6093c();
        this.h = i2;
        return i2;
    }

    protected final Object mo4293a(int i, Object obj, Object obj2) {
        boolean z = true;
        byte b = (byte) 0;
        switch (zzdrn.f7268a[i - 1]) {
            case 1:
                return new zzdrm();
            case 2:
                return f19592d;
            case 3:
                return null;
            case 4:
                return new zza();
            case 5:
                zzh com_google_android_gms_internal_zzffu_zzh = (zzh) obj;
                zzdrm com_google_android_gms_internal_zzdrm = (zzdrm) obj2;
                this.f19594a = com_google_android_gms_internal_zzffu_zzh.mo1901a(this.f19594a != 0, this.f19594a, com_google_android_gms_internal_zzdrm.f19594a != 0, com_google_android_gms_internal_zzdrm.f19594a);
                this.f19596c = (zzdrq) com_google_android_gms_internal_zzffu_zzh.mo1904a(this.f19596c, com_google_android_gms_internal_zzdrm.f19596c);
                boolean z2 = this.f19595b != zzfes.f7377a;
                zzfes com_google_android_gms_internal_zzfes = this.f19595b;
                if (com_google_android_gms_internal_zzdrm.f19595b == zzfes.f7377a) {
                    z = false;
                }
                this.f19595b = com_google_android_gms_internal_zzffu_zzh.mo1902a(z2, com_google_android_gms_internal_zzfes, z, com_google_android_gms_internal_zzdrm.f19595b);
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
                                    this.f19594a = com_google_android_gms_internal_zzffb.mo1889h();
                                } else if (i == 18) {
                                    if (this.f19596c != 0) {
                                        zzffu com_google_android_gms_internal_zzffu = this.f19596c;
                                        com.google.android.gms.internal.zzffu.zza com_google_android_gms_internal_zzffu_zza = (com.google.android.gms.internal.zzffu.zza) com_google_android_gms_internal_zzffu.mo4293a(zzg.f7410h, null, null);
                                        com_google_android_gms_internal_zzffu_zza.m20427a(com_google_android_gms_internal_zzffu);
                                        i = (com.google.android.gms.internal.zzdrq.zza) com_google_android_gms_internal_zzffu_zza;
                                    } else {
                                        i = 0;
                                    }
                                    this.f19596c = (zzdrq) com_google_android_gms_internal_zzffb.mo1879a(zzdrq.m21042a(), com_google_android_gms_internal_zzffm);
                                    if (i != 0) {
                                        i.m20427a(this.f19596c);
                                        this.f19596c = (zzdrq) i.m20430e();
                                    }
                                } else if (i == 26) {
                                    this.f19595b = com_google_android_gms_internal_zzffb.mo1888g();
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
                if (f19593e == 0) {
                    synchronized (zzdrm.class) {
                        if (f19593e == null) {
                            f19593e = new zzb(f19592d);
                        }
                    }
                }
                return f19593e;
            case 9:
                return Byte.valueOf((byte) 1);
            case 10:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
        return f19592d;
    }

    static /* synthetic */ void m21028a(zzdrm com_google_android_gms_internal_zzdrm, zzdrq com_google_android_gms_internal_zzdrq) {
        if (com_google_android_gms_internal_zzdrq == null) {
            throw new NullPointerException();
        }
        com_google_android_gms_internal_zzdrm.f19596c = com_google_android_gms_internal_zzdrq;
    }

    static /* synthetic */ void m21029a(zzdrm com_google_android_gms_internal_zzdrm, zzfes com_google_android_gms_internal_zzfes) {
        if (com_google_android_gms_internal_zzfes == null) {
            throw new NullPointerException();
        }
        com_google_android_gms_internal_zzdrm.f19595b = com_google_android_gms_internal_zzfes;
    }

    static {
        zzffu com_google_android_gms_internal_zzdrm = new zzdrm();
        f19592d = com_google_android_gms_internal_zzdrm;
        com_google_android_gms_internal_zzdrm.mo4293a(zzg.f7408f, null, null);
        com_google_android_gms_internal_zzdrm.f19235g.f7470e = false;
    }
}
