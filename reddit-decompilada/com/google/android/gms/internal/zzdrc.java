package com.google.android.gms.internal;

import com.google.android.gms.internal.zzffu.zzb;
import com.google.android.gms.internal.zzffu.zzg;
import com.google.android.gms.internal.zzffu.zzh;
import java.io.IOException;

public final class zzdrc extends zzffu<zzdrc, zza> implements zzfhg {
    private static final zzdrc f19571d;
    private static volatile zzfhk<zzdrc> f19572e;
    int f19573a;
    private zzdrg f19574b;
    private zzdss f19575c;

    public static final class zza extends com.google.android.gms.internal.zzffu.zza<zzdrc, zza> implements zzfhg {
        private zza() {
            super(zzdrc.f19571d);
        }

        public final zza m20976a(int i) {
            m20429d();
            ((zzdrc) this.a).f19573a = i;
            return this;
        }

        public final zza m20977a(zzdrg com_google_android_gms_internal_zzdrg) {
            m20429d();
            zzdrc.m20981a((zzdrc) this.a, com_google_android_gms_internal_zzdrg);
            return this;
        }

        public final zza m20978a(zzdss com_google_android_gms_internal_zzdss) {
            m20429d();
            zzdrc.m20982a((zzdrc) this.a, com_google_android_gms_internal_zzdss);
            return this;
        }
    }

    private zzdrc() {
    }

    public static zzdrc m20979a(zzfes com_google_android_gms_internal_zzfes) throws zzfge {
        return (zzdrc) zzffu.m20434a(f19571d, com_google_android_gms_internal_zzfes);
    }

    public static zza m20983d() {
        zzffu com_google_android_gms_internal_zzffu = f19571d;
        com.google.android.gms.internal.zzffu.zza com_google_android_gms_internal_zzffu_zza = (com.google.android.gms.internal.zzffu.zza) com_google_android_gms_internal_zzffu.mo4293a(zzg.f7410h, null, null);
        com_google_android_gms_internal_zzffu_zza.m20427a(com_google_android_gms_internal_zzffu);
        return (zza) com_google_android_gms_internal_zzffu_zza;
    }

    public final zzdrg m20985a() {
        return this.f19574b == null ? zzdrg.m21005d() : this.f19574b;
    }

    public final void mo4039a(zzffg com_google_android_gms_internal_zzffg) throws IOException {
        if (this.f19573a != 0) {
            com_google_android_gms_internal_zzffg.mo3532c(1, this.f19573a);
        }
        if (this.f19574b != null) {
            com_google_android_gms_internal_zzffg.mo3516a(2, this.f19574b == null ? zzdrg.m21005d() : this.f19574b);
        }
        if (this.f19575c != null) {
            com_google_android_gms_internal_zzffg.mo3516a(3, this.f19575c == null ? zzdss.m21143d() : this.f19575c);
        }
        this.g.m6090a(com_google_android_gms_internal_zzffg);
    }

    public final zzdss m20988b() {
        return this.f19575c == null ? zzdss.m21143d() : this.f19575c;
    }

    public final int mo4040c() {
        int i = this.h;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if (this.f19573a != 0) {
            i2 = 0 + zzffg.m13787e(1, this.f19573a);
        }
        if (this.f19574b != null) {
            i2 += zzffg.m13777c(2, this.f19574b == null ? zzdrg.m21005d() : this.f19574b);
        }
        if (this.f19575c != null) {
            i2 += zzffg.m13777c(3, this.f19575c == null ? zzdss.m21143d() : this.f19575c);
        }
        i2 += this.g.m6093c();
        this.h = i2;
        return i2;
    }

    protected final Object mo4293a(int i, Object obj, Object obj2) {
        boolean z = false;
        switch (zzdrd.f7263a[i - 1]) {
            case 1:
                return new zzdrc();
            case 2:
                return f19571d;
            case 3:
                return null;
            case 4:
                return new zza();
            case 5:
                zzh com_google_android_gms_internal_zzffu_zzh = (zzh) obj;
                zzdrc com_google_android_gms_internal_zzdrc = (zzdrc) obj2;
                boolean z2 = this.f19573a != 0;
                int i2 = this.f19573a;
                if (com_google_android_gms_internal_zzdrc.f19573a != 0) {
                    z = true;
                }
                this.f19573a = com_google_android_gms_internal_zzffu_zzh.mo1901a(z2, i2, z, com_google_android_gms_internal_zzdrc.f19573a);
                this.f19574b = (zzdrg) com_google_android_gms_internal_zzffu_zzh.mo1904a(this.f19574b, com_google_android_gms_internal_zzdrc.f19574b);
                this.f19575c = (zzdss) com_google_android_gms_internal_zzffu_zzh.mo1904a(this.f19575c, com_google_android_gms_internal_zzdrc.f19575c);
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
                                    this.f19573a = com_google_android_gms_internal_zzffb.mo1889h();
                                } else if (i == 18) {
                                    if (this.f19574b != 0) {
                                        r5 = this.f19574b;
                                        r3 = (com.google.android.gms.internal.zzffu.zza) r5.mo4293a(zzg.f7410h, null, null);
                                        r3.m20427a(r5);
                                        i = (com.google.android.gms.internal.zzdrg.zza) r3;
                                    } else {
                                        i = 0;
                                    }
                                    this.f19574b = (zzdrg) com_google_android_gms_internal_zzffb.mo1879a(zzdrg.m21005d(), com_google_android_gms_internal_zzffm);
                                    if (i != 0) {
                                        i.m20427a(this.f19574b);
                                        this.f19574b = (zzdrg) i.m20430e();
                                    }
                                } else if (i == 26) {
                                    if (this.f19575c != 0) {
                                        r5 = this.f19575c;
                                        r3 = (com.google.android.gms.internal.zzffu.zza) r5.mo4293a(zzg.f7410h, null, null);
                                        r3.m20427a(r5);
                                        i = (com.google.android.gms.internal.zzdss.zza) r3;
                                    } else {
                                        i = 0;
                                    }
                                    this.f19575c = (zzdss) com_google_android_gms_internal_zzffb.mo1879a(zzdss.m21143d(), com_google_android_gms_internal_zzffm);
                                    if (i != 0) {
                                        i.m20427a(this.f19575c);
                                        this.f19575c = (zzdss) i.m20430e();
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
                if (f19572e == 0) {
                    synchronized (zzdrc.class) {
                        if (f19572e == null) {
                            f19572e = new zzb(f19571d);
                        }
                    }
                }
                return f19572e;
            case 9:
                return Byte.valueOf((byte) 1);
            case 10:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
        return f19571d;
    }

    static /* synthetic */ void m20981a(zzdrc com_google_android_gms_internal_zzdrc, zzdrg com_google_android_gms_internal_zzdrg) {
        if (com_google_android_gms_internal_zzdrg == null) {
            throw new NullPointerException();
        }
        com_google_android_gms_internal_zzdrc.f19574b = com_google_android_gms_internal_zzdrg;
    }

    static /* synthetic */ void m20982a(zzdrc com_google_android_gms_internal_zzdrc, zzdss com_google_android_gms_internal_zzdss) {
        if (com_google_android_gms_internal_zzdss == null) {
            throw new NullPointerException();
        }
        com_google_android_gms_internal_zzdrc.f19575c = com_google_android_gms_internal_zzdss;
    }

    static {
        zzffu com_google_android_gms_internal_zzdrc = new zzdrc();
        f19571d = com_google_android_gms_internal_zzdrc;
        com_google_android_gms_internal_zzdrc.mo4293a(zzg.f7408f, null, null);
        com_google_android_gms_internal_zzdrc.f19235g.f7470e = false;
    }
}
