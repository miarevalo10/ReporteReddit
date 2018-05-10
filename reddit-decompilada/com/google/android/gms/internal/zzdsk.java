package com.google.android.gms.internal;

import com.google.android.gms.internal.zzffu.zzb;
import com.google.android.gms.internal.zzffu.zzg;
import com.google.android.gms.internal.zzffu.zzh;
import java.io.IOException;

public final class zzdsk extends zzffu<zzdsk, zza> implements zzfhg {
    private static final zzdsk f19635e;
    private static volatile zzfhk<zzdsk> f19636i;
    int f19637a;
    zzfes f19638b = zzfes.f7377a;
    zzfes f19639c = zzfes.f7377a;
    private zzdsg f19640d;

    public static final class zza extends com.google.android.gms.internal.zzffu.zza<zzdsk, zza> implements zzfhg {
        private zza() {
            super(zzdsk.f19635e);
        }

        public final zza m21112a() {
            m20429d();
            ((zzdsk) this.a).f19637a = 0;
            return this;
        }

        public final zza m21113a(zzdsg com_google_android_gms_internal_zzdsg) {
            m20429d();
            zzdsk.m21118a((zzdsk) this.a, com_google_android_gms_internal_zzdsg);
            return this;
        }

        public final zza m21114a(zzfes com_google_android_gms_internal_zzfes) {
            m20429d();
            zzdsk.m21119a((zzdsk) this.a, com_google_android_gms_internal_zzfes);
            return this;
        }

        public final zza m21115b(zzfes com_google_android_gms_internal_zzfes) {
            m20429d();
            zzdsk.m21121b((zzdsk) this.a, com_google_android_gms_internal_zzfes);
            return this;
        }
    }

    private zzdsk() {
    }

    public static zzdsk m21116a(zzfes com_google_android_gms_internal_zzfes) throws zzfge {
        return (zzdsk) zzffu.m20434a(f19635e, com_google_android_gms_internal_zzfes);
    }

    public static zza m21120b() {
        zzffu com_google_android_gms_internal_zzffu = f19635e;
        com.google.android.gms.internal.zzffu.zza com_google_android_gms_internal_zzffu_zza = (com.google.android.gms.internal.zzffu.zza) com_google_android_gms_internal_zzffu.mo4293a(zzg.f7410h, null, null);
        com_google_android_gms_internal_zzffu_zza.m20427a(com_google_android_gms_internal_zzffu);
        return (zza) com_google_android_gms_internal_zzffu_zza;
    }

    public static zzdsk m21122d() {
        return f19635e;
    }

    public final zzdsg m21124a() {
        return this.f19640d == null ? zzdsg.m21091e() : this.f19640d;
    }

    public final void mo4039a(zzffg com_google_android_gms_internal_zzffg) throws IOException {
        if (this.f19637a != 0) {
            com_google_android_gms_internal_zzffg.mo3532c(1, this.f19637a);
        }
        if (this.f19640d != null) {
            com_google_android_gms_internal_zzffg.mo3516a(2, this.f19640d == null ? zzdsg.m21091e() : this.f19640d);
        }
        if (!this.f19638b.m5958b()) {
            com_google_android_gms_internal_zzffg.mo3515a(3, this.f19638b);
        }
        if (!this.f19639c.m5958b()) {
            com_google_android_gms_internal_zzffg.mo3515a(4, this.f19639c);
        }
        this.g.m6090a(com_google_android_gms_internal_zzffg);
    }

    public final int mo4040c() {
        int i = this.h;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if (this.f19637a != 0) {
            i2 = 0 + zzffg.m13787e(1, this.f19637a);
        }
        if (this.f19640d != null) {
            i2 += zzffg.m13777c(2, this.f19640d == null ? zzdsg.m21091e() : this.f19640d);
        }
        if (!this.f19638b.m5958b()) {
            i2 += zzffg.m13776c(3, this.f19638b);
        }
        if (!this.f19639c.m5958b()) {
            i2 += zzffg.m13776c(4, this.f19639c);
        }
        i2 += this.g.m6093c();
        this.h = i2;
        return i2;
    }

    protected final Object mo4293a(int i, Object obj, Object obj2) {
        boolean z = true;
        byte b = (byte) 0;
        switch (zzdsl.f7279a[i - 1]) {
            case 1:
                return new zzdsk();
            case 2:
                return f19635e;
            case 3:
                return null;
            case 4:
                return new zza();
            case 5:
                zzh com_google_android_gms_internal_zzffu_zzh = (zzh) obj;
                zzdsk com_google_android_gms_internal_zzdsk = (zzdsk) obj2;
                this.f19637a = com_google_android_gms_internal_zzffu_zzh.mo1901a(this.f19637a != 0, this.f19637a, com_google_android_gms_internal_zzdsk.f19637a != 0, com_google_android_gms_internal_zzdsk.f19637a);
                this.f19640d = (zzdsg) com_google_android_gms_internal_zzffu_zzh.mo1904a(this.f19640d, com_google_android_gms_internal_zzdsk.f19640d);
                this.f19638b = com_google_android_gms_internal_zzffu_zzh.mo1902a(this.f19638b != zzfes.f7377a, this.f19638b, com_google_android_gms_internal_zzdsk.f19638b != zzfes.f7377a, com_google_android_gms_internal_zzdsk.f19638b);
                boolean z2 = this.f19639c != zzfes.f7377a;
                zzfes com_google_android_gms_internal_zzfes = this.f19639c;
                if (com_google_android_gms_internal_zzdsk.f19639c == zzfes.f7377a) {
                    z = false;
                }
                this.f19639c = com_google_android_gms_internal_zzffu_zzh.mo1902a(z2, com_google_android_gms_internal_zzfes, z, com_google_android_gms_internal_zzdsk.f19639c);
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
                                    this.f19637a = com_google_android_gms_internal_zzffb.mo1889h();
                                } else if (i == 18) {
                                    if (this.f19640d != 0) {
                                        zzffu com_google_android_gms_internal_zzffu = this.f19640d;
                                        com.google.android.gms.internal.zzffu.zza com_google_android_gms_internal_zzffu_zza = (com.google.android.gms.internal.zzffu.zza) com_google_android_gms_internal_zzffu.mo4293a(zzg.f7410h, null, null);
                                        com_google_android_gms_internal_zzffu_zza.m20427a(com_google_android_gms_internal_zzffu);
                                        i = (com.google.android.gms.internal.zzdsg.zza) com_google_android_gms_internal_zzffu_zza;
                                    } else {
                                        i = 0;
                                    }
                                    this.f19640d = (zzdsg) com_google_android_gms_internal_zzffb.mo1879a(zzdsg.m21091e(), com_google_android_gms_internal_zzffm);
                                    if (i != 0) {
                                        i.m20427a(this.f19640d);
                                        this.f19640d = (zzdsg) i.m20430e();
                                    }
                                } else if (i == 26) {
                                    this.f19638b = com_google_android_gms_internal_zzffb.mo1888g();
                                } else if (i == 34) {
                                    this.f19639c = com_google_android_gms_internal_zzffb.mo1888g();
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
                if (f19636i == 0) {
                    synchronized (zzdsk.class) {
                        if (f19636i == null) {
                            f19636i = new zzb(f19635e);
                        }
                    }
                }
                return f19636i;
            case 9:
                return Byte.valueOf((byte) 1);
            case 10:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
        return f19635e;
    }

    static /* synthetic */ void m21118a(zzdsk com_google_android_gms_internal_zzdsk, zzdsg com_google_android_gms_internal_zzdsg) {
        if (com_google_android_gms_internal_zzdsg == null) {
            throw new NullPointerException();
        }
        com_google_android_gms_internal_zzdsk.f19640d = com_google_android_gms_internal_zzdsg;
    }

    static /* synthetic */ void m21119a(zzdsk com_google_android_gms_internal_zzdsk, zzfes com_google_android_gms_internal_zzfes) {
        if (com_google_android_gms_internal_zzfes == null) {
            throw new NullPointerException();
        }
        com_google_android_gms_internal_zzdsk.f19638b = com_google_android_gms_internal_zzfes;
    }

    static /* synthetic */ void m21121b(zzdsk com_google_android_gms_internal_zzdsk, zzfes com_google_android_gms_internal_zzfes) {
        if (com_google_android_gms_internal_zzfes == null) {
            throw new NullPointerException();
        }
        com_google_android_gms_internal_zzdsk.f19639c = com_google_android_gms_internal_zzfes;
    }

    static {
        zzffu com_google_android_gms_internal_zzdsk = new zzdsk();
        f19635e = com_google_android_gms_internal_zzdsk;
        com_google_android_gms_internal_zzdsk.mo4293a(zzg.f7408f, null, null);
        com_google_android_gms_internal_zzdsk.f19235g.f7470e = false;
    }
}
