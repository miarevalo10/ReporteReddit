package com.google.android.gms.internal;

import com.google.android.gms.internal.zzffu.zzb;
import com.google.android.gms.internal.zzffu.zzg;
import com.google.android.gms.internal.zzffu.zzh;
import java.io.IOException;

public final class zzdtr extends zzffu<zzdtr, zza> implements zzfhg {
    private static final zzdtr f19709c;
    private static volatile zzfhk<zzdtr> f19710d;
    String f19711a = "";
    private zzdtd f19712b;

    public static final class zza extends com.google.android.gms.internal.zzffu.zza<zzdtr, zza> implements zzfhg {
        private zza() {
            super(zzdtr.f19709c);
        }
    }

    private zzdtr() {
    }

    public static zzdtr m21260a(zzfes com_google_android_gms_internal_zzfes) throws zzfge {
        return (zzdtr) zzffu.m20434a(f19709c, com_google_android_gms_internal_zzfes);
    }

    public static zzdtr m21261b() {
        return f19709c;
    }

    public final zzdtd m21263a() {
        return this.f19712b == null ? zzdtd.m21175a() : this.f19712b;
    }

    public final void mo4039a(zzffg com_google_android_gms_internal_zzffg) throws IOException {
        if (!this.f19711a.isEmpty()) {
            com_google_android_gms_internal_zzffg.mo3517a(1, this.f19711a);
        }
        if (this.f19712b != null) {
            com_google_android_gms_internal_zzffg.mo3516a(2, this.f19712b == null ? zzdtd.m21175a() : this.f19712b);
        }
        this.g.m6090a(com_google_android_gms_internal_zzffg);
    }

    public final int mo4040c() {
        int i = this.h;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if (!this.f19711a.isEmpty()) {
            i2 = 0 + zzffg.m13769b(1, this.f19711a);
        }
        if (this.f19712b != null) {
            i2 += zzffg.m13777c(2, this.f19712b == null ? zzdtd.m21175a() : this.f19712b);
        }
        i2 += this.g.m6093c();
        this.h = i2;
        return i2;
    }

    protected final Object mo4293a(int i, Object obj, Object obj2) {
        byte b = (byte) 0;
        switch (zzdts.f7305a[i - 1]) {
            case 1:
                return new zzdtr();
            case 2:
                return f19709c;
            case 3:
                return null;
            case 4:
                return new zza();
            case 5:
                zzh com_google_android_gms_internal_zzffu_zzh = (zzh) obj;
                zzdtr com_google_android_gms_internal_zzdtr = (zzdtr) obj2;
                this.f19711a = com_google_android_gms_internal_zzffu_zzh.mo1906a(this.f19711a.isEmpty() ^ 1, this.f19711a, true ^ com_google_android_gms_internal_zzdtr.f19711a.isEmpty(), com_google_android_gms_internal_zzdtr.f19711a);
                this.f19712b = (zzdtd) com_google_android_gms_internal_zzffu_zzh.mo1904a(this.f19712b, com_google_android_gms_internal_zzdtr.f19712b);
                return this;
            case 6:
                zzffb com_google_android_gms_internal_zzffb = (zzffb) obj;
                zzffm com_google_android_gms_internal_zzffm = (zzffm) obj2;
                if (com_google_android_gms_internal_zzffm != null) {
                    while (b == (byte) 0) {
                        try {
                            i = com_google_android_gms_internal_zzffb.mo1878a();
                            if (i != 0) {
                                if (i == 10) {
                                    this.f19711a = com_google_android_gms_internal_zzffb.mo1887f();
                                } else if (i == 18) {
                                    if (this.f19712b != 0) {
                                        zzffu com_google_android_gms_internal_zzffu = this.f19712b;
                                        com.google.android.gms.internal.zzffu.zza com_google_android_gms_internal_zzffu_zza = (com.google.android.gms.internal.zzffu.zza) com_google_android_gms_internal_zzffu.mo4293a(zzg.f7410h, null, null);
                                        com_google_android_gms_internal_zzffu_zza.m20427a(com_google_android_gms_internal_zzffu);
                                        i = (com.google.android.gms.internal.zzdtd.zza) com_google_android_gms_internal_zzffu_zza;
                                    } else {
                                        i = 0;
                                    }
                                    this.f19712b = (zzdtd) com_google_android_gms_internal_zzffb.mo1879a(zzdtd.m21175a(), com_google_android_gms_internal_zzffm);
                                    if (i != 0) {
                                        i.m20427a(this.f19712b);
                                        this.f19712b = (zzdtd) i.m20430e();
                                    }
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
                if (f19710d == 0) {
                    synchronized (zzdtr.class) {
                        if (f19710d == null) {
                            f19710d = new zzb(f19709c);
                        }
                    }
                }
                return f19710d;
            case 9:
                return Byte.valueOf((byte) 1);
            case 10:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
        return f19709c;
    }

    static {
        zzffu com_google_android_gms_internal_zzdtr = new zzdtr();
        f19709c = com_google_android_gms_internal_zzdtr;
        com_google_android_gms_internal_zzdtr.mo4293a(zzg.f7408f, null, null);
        com_google_android_gms_internal_zzdtr.f19235g.f7470e = false;
    }
}
