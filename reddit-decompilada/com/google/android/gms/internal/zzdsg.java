package com.google.android.gms.internal;

import com.google.android.gms.internal.zzffu.zzb;
import com.google.android.gms.internal.zzffu.zzg;
import com.google.android.gms.internal.zzffu.zzh;
import java.io.IOException;

public final class zzdsg extends zzffu<zzdsg, zza> implements zzfhg {
    private static final zzdsg f19625d;
    private static volatile zzfhk<zzdsg> f19626e;
    private zzdsm f19627a;
    private zzdsc f19628b;
    private int f19629c;

    public static final class zza extends com.google.android.gms.internal.zzffu.zza<zzdsg, zza> implements zzfhg {
        private zza() {
            super(zzdsg.f19625d);
        }
    }

    private zzdsg() {
    }

    public static zzdsg m21091e() {
        return f19625d;
    }

    public final zzdsm m21093a() {
        return this.f19627a == null ? zzdsm.m21128d() : this.f19627a;
    }

    public final void mo4039a(zzffg com_google_android_gms_internal_zzffg) throws IOException {
        if (this.f19627a != null) {
            com_google_android_gms_internal_zzffg.mo3516a(1, this.f19627a == null ? zzdsm.m21128d() : this.f19627a);
        }
        if (this.f19628b != null) {
            com_google_android_gms_internal_zzffg.mo3516a(2, this.f19628b == null ? zzdsc.m21079b() : this.f19628b);
        }
        if (this.f19629c != zzdsa.UNKNOWN_FORMAT.mo1865a()) {
            com_google_android_gms_internal_zzffg.mo3525b(3, this.f19629c);
        }
        this.g.m6090a(com_google_android_gms_internal_zzffg);
    }

    public final zzdsc m21096b() {
        return this.f19628b == null ? zzdsc.m21079b() : this.f19628b;
    }

    public final int mo4040c() {
        int i = this.h;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if (this.f19627a != null) {
            i2 = 0 + zzffg.m13777c(1, this.f19627a == null ? zzdsm.m21128d() : this.f19627a);
        }
        if (this.f19628b != null) {
            i2 += zzffg.m13777c(2, this.f19628b == null ? zzdsc.m21079b() : this.f19628b);
        }
        if (this.f19629c != zzdsa.UNKNOWN_FORMAT.mo1865a()) {
            i2 += zzffg.m13791f(3, this.f19629c);
        }
        i2 += this.g.m6093c();
        this.h = i2;
        return i2;
    }

    public final zzdsa m21098d() {
        zzdsa a = zzdsa.m13665a(this.f19629c);
        return a == null ? zzdsa.UNRECOGNIZED : a;
    }

    protected final Object mo4293a(int i, Object obj, Object obj2) {
        boolean z = false;
        switch (zzdsh.f7277a[i - 1]) {
            case 1:
                return new zzdsg();
            case 2:
                return f19625d;
            case 3:
                return null;
            case 4:
                return new zza();
            case 5:
                zzh com_google_android_gms_internal_zzffu_zzh = (zzh) obj;
                zzdsg com_google_android_gms_internal_zzdsg = (zzdsg) obj2;
                this.f19627a = (zzdsm) com_google_android_gms_internal_zzffu_zzh.mo1904a(this.f19627a, com_google_android_gms_internal_zzdsg.f19627a);
                this.f19628b = (zzdsc) com_google_android_gms_internal_zzffu_zzh.mo1904a(this.f19628b, com_google_android_gms_internal_zzdsg.f19628b);
                boolean z2 = this.f19629c != 0;
                int i2 = this.f19629c;
                if (com_google_android_gms_internal_zzdsg.f19629c != 0) {
                    z = true;
                }
                this.f19629c = com_google_android_gms_internal_zzffu_zzh.mo1901a(z2, i2, z, com_google_android_gms_internal_zzdsg.f19629c);
                return this;
            case 6:
                zzffb com_google_android_gms_internal_zzffb = (zzffb) obj;
                zzffm com_google_android_gms_internal_zzffm = (zzffm) obj2;
                if (com_google_android_gms_internal_zzffm != null) {
                    while (!z) {
                        try {
                            i = com_google_android_gms_internal_zzffb.mo1878a();
                            if (i != 0) {
                                zzffu com_google_android_gms_internal_zzffu;
                                com.google.android.gms.internal.zzffu.zza com_google_android_gms_internal_zzffu_zza;
                                if (i == 10) {
                                    if (this.f19627a != 0) {
                                        com_google_android_gms_internal_zzffu = this.f19627a;
                                        com_google_android_gms_internal_zzffu_zza = (com.google.android.gms.internal.zzffu.zza) com_google_android_gms_internal_zzffu.mo4293a(zzg.f7410h, null, null);
                                        com_google_android_gms_internal_zzffu_zza.m20427a(com_google_android_gms_internal_zzffu);
                                        i = (com.google.android.gms.internal.zzdsm.zza) com_google_android_gms_internal_zzffu_zza;
                                    } else {
                                        i = 0;
                                    }
                                    this.f19627a = (zzdsm) com_google_android_gms_internal_zzffb.mo1879a(zzdsm.m21128d(), com_google_android_gms_internal_zzffm);
                                    if (i != 0) {
                                        i.m20427a(this.f19627a);
                                        this.f19627a = (zzdsm) i.m20430e();
                                    }
                                } else if (i == 18) {
                                    if (this.f19628b != 0) {
                                        com_google_android_gms_internal_zzffu = this.f19628b;
                                        com_google_android_gms_internal_zzffu_zza = (com.google.android.gms.internal.zzffu.zza) com_google_android_gms_internal_zzffu.mo4293a(zzg.f7410h, null, null);
                                        com_google_android_gms_internal_zzffu_zza.m20427a(com_google_android_gms_internal_zzffu);
                                        i = (com.google.android.gms.internal.zzdsc.zza) com_google_android_gms_internal_zzffu_zza;
                                    } else {
                                        i = 0;
                                    }
                                    this.f19628b = (zzdsc) com_google_android_gms_internal_zzffb.mo1879a(zzdsc.m21079b(), com_google_android_gms_internal_zzffm);
                                    if (i != 0) {
                                        i.m20427a(this.f19628b);
                                        this.f19628b = (zzdsc) i.m20430e();
                                    }
                                } else if (i == 24) {
                                    this.f19629c = com_google_android_gms_internal_zzffb.mo1890i();
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
                if (f19626e == 0) {
                    synchronized (zzdsg.class) {
                        if (f19626e == null) {
                            f19626e = new zzb(f19625d);
                        }
                    }
                }
                return f19626e;
            case 9:
                return Byte.valueOf((byte) 1);
            case 10:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
        return f19625d;
    }

    static {
        zzffu com_google_android_gms_internal_zzdsg = new zzdsg();
        f19625d = com_google_android_gms_internal_zzdsg;
        com_google_android_gms_internal_zzdsg.mo4293a(zzg.f7408f, null, null);
        com_google_android_gms_internal_zzdsg.f19235g.f7470e = false;
    }
}
