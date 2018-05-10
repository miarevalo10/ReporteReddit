package com.google.android.gms.internal;

import com.google.android.gms.internal.zzffu.zzb;
import com.google.android.gms.internal.zzffu.zzg;
import com.google.android.gms.internal.zzffu.zzh;
import java.io.IOException;

public final class zzdtf extends zzffu<zzdtf, zza> implements zzfhg {
    private static final zzdtf f19669i;
    private static volatile zzfhk<zzdtf> f19670j;
    String f19671a = "";
    String f19672b = "";
    int f19673c;
    boolean f19674d;
    String f19675e = "";

    public static final class zza extends com.google.android.gms.internal.zzffu.zza<zzdtf, zza> implements zzfhg {
        private zza() {
            super(zzdtf.f19669i);
        }

        public final zza m21180a() {
            m20429d();
            ((zzdtf) this.a).f19673c = 0;
            return this;
        }

        public final zza m21181a(String str) {
            m20429d();
            zzdtf.m21187a((zzdtf) this.a, str);
            return this;
        }

        public final zza m21182b() {
            m20429d();
            ((zzdtf) this.a).f19674d = true;
            return this;
        }

        public final zza m21183b(String str) {
            m20429d();
            zzdtf.m21190b((zzdtf) this.a, str);
            return this;
        }

        public final zza m21184c(String str) {
            m20429d();
            zzdtf.m21191c((zzdtf) this.a, str);
            return this;
        }
    }

    private zzdtf() {
    }

    public static zza m21185a() {
        zzffu com_google_android_gms_internal_zzffu = f19669i;
        com.google.android.gms.internal.zzffu.zza com_google_android_gms_internal_zzffu_zza = (com.google.android.gms.internal.zzffu.zza) com_google_android_gms_internal_zzffu.mo4293a(zzg.f7410h, null, null);
        com_google_android_gms_internal_zzffu_zza.m20427a(com_google_android_gms_internal_zzffu);
        return (zza) com_google_android_gms_internal_zzffu_zza;
    }

    public static zzdtf m21188b() {
        return f19669i;
    }

    public final void mo4039a(zzffg com_google_android_gms_internal_zzffg) throws IOException {
        if (!this.f19671a.isEmpty()) {
            com_google_android_gms_internal_zzffg.mo3517a(1, this.f19671a);
        }
        if (!this.f19672b.isEmpty()) {
            com_google_android_gms_internal_zzffg.mo3517a(2, this.f19672b);
        }
        if (this.f19673c != 0) {
            com_google_android_gms_internal_zzffg.mo3532c(3, this.f19673c);
        }
        if (this.f19674d) {
            com_google_android_gms_internal_zzffg.mo3522a(this.f19674d);
        }
        if (!this.f19675e.isEmpty()) {
            com_google_android_gms_internal_zzffg.mo3517a(5, this.f19675e);
        }
        this.g.m6090a(com_google_android_gms_internal_zzffg);
    }

    public final int mo4040c() {
        int i = this.h;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if (!this.f19671a.isEmpty()) {
            i2 = 0 + zzffg.m13769b(1, this.f19671a);
        }
        if (!this.f19672b.isEmpty()) {
            i2 += zzffg.m13769b(2, this.f19672b);
        }
        if (this.f19673c != 0) {
            i2 += zzffg.m13787e(3, this.f19673c);
        }
        if (this.f19674d) {
            i2 += zzffg.m13764a();
        }
        if (!this.f19675e.isEmpty()) {
            i2 += zzffg.m13769b(5, this.f19675e);
        }
        i2 += this.g.m6093c();
        this.h = i2;
        return i2;
    }

    protected final Object mo4293a(int i, Object obj, Object obj2) {
        boolean z = false;
        switch (zzdtg.f7299a[i - 1]) {
            case 1:
                return new zzdtf();
            case 2:
                return f19669i;
            case 3:
                return null;
            case 4:
                return new zza();
            case 5:
                zzh com_google_android_gms_internal_zzffu_zzh = (zzh) obj;
                zzdtf com_google_android_gms_internal_zzdtf = (zzdtf) obj2;
                this.f19671a = com_google_android_gms_internal_zzffu_zzh.mo1906a(this.f19671a.isEmpty() ^ 1, this.f19671a, com_google_android_gms_internal_zzdtf.f19671a.isEmpty() ^ true, com_google_android_gms_internal_zzdtf.f19671a);
                this.f19672b = com_google_android_gms_internal_zzffu_zzh.mo1906a(this.f19672b.isEmpty() ^ 1, this.f19672b, com_google_android_gms_internal_zzdtf.f19672b.isEmpty() ^ true, com_google_android_gms_internal_zzdtf.f19672b);
                boolean z2 = this.f19673c != 0;
                int i2 = this.f19673c;
                if (com_google_android_gms_internal_zzdtf.f19673c != 0) {
                    z = true;
                }
                this.f19673c = com_google_android_gms_internal_zzffu_zzh.mo1901a(z2, i2, z, com_google_android_gms_internal_zzdtf.f19673c);
                this.f19674d = com_google_android_gms_internal_zzffu_zzh.mo1907a(this.f19674d, this.f19674d, com_google_android_gms_internal_zzdtf.f19674d, com_google_android_gms_internal_zzdtf.f19674d);
                this.f19675e = com_google_android_gms_internal_zzffu_zzh.mo1906a(this.f19675e.isEmpty() ^ 1, this.f19675e, true ^ com_google_android_gms_internal_zzdtf.f19675e.isEmpty(), com_google_android_gms_internal_zzdtf.f19675e);
                return this;
            case 6:
                zzffb com_google_android_gms_internal_zzffb = (zzffb) obj;
                if (((zzffm) obj2) != null) {
                    while (!z) {
                        try {
                            i = com_google_android_gms_internal_zzffb.mo1878a();
                            if (i != 0) {
                                if (i == 10) {
                                    this.f19671a = com_google_android_gms_internal_zzffb.mo1887f();
                                } else if (i == 18) {
                                    this.f19672b = com_google_android_gms_internal_zzffb.mo1887f();
                                } else if (i == 24) {
                                    this.f19673c = com_google_android_gms_internal_zzffb.mo1889h();
                                } else if (i == 32) {
                                    this.f19674d = com_google_android_gms_internal_zzffb.mo1886e();
                                } else if (i == 42) {
                                    this.f19675e = com_google_android_gms_internal_zzffb.mo1887f();
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
                if (f19670j == 0) {
                    synchronized (zzdtf.class) {
                        if (f19670j == null) {
                            f19670j = new zzb(f19669i);
                        }
                    }
                }
                return f19670j;
            case 9:
                return Byte.valueOf((byte) 1);
            case 10:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
        return f19669i;
    }

    static /* synthetic */ void m21187a(zzdtf com_google_android_gms_internal_zzdtf, String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        com_google_android_gms_internal_zzdtf.f19671a = str;
    }

    static /* synthetic */ void m21190b(zzdtf com_google_android_gms_internal_zzdtf, String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        com_google_android_gms_internal_zzdtf.f19672b = str;
    }

    static /* synthetic */ void m21191c(zzdtf com_google_android_gms_internal_zzdtf, String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        com_google_android_gms_internal_zzdtf.f19675e = str;
    }

    static {
        zzffu com_google_android_gms_internal_zzdtf = new zzdtf();
        f19669i = com_google_android_gms_internal_zzdtf;
        com_google_android_gms_internal_zzdtf.mo4293a(zzg.f7408f, null, null);
        com_google_android_gms_internal_zzdtf.f19235g.f7470e = false;
    }
}
