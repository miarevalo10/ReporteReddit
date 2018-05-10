package com.google.android.gms.internal;

import com.google.android.gms.internal.zzffu.zzb;
import com.google.android.gms.internal.zzffu.zzg;
import com.google.android.gms.internal.zzffu.zzh;
import java.io.IOException;

public final class zzdtn extends zzffu<zzdtn, zza> implements zzfhg {
    private static final zzdtn f19702b;
    private static volatile zzfhk<zzdtn> f19703c;
    String f19704a = "";

    public static final class zza extends com.google.android.gms.internal.zzffu.zza<zzdtn, zza> implements zzfhg {
        private zza() {
            super(zzdtn.f19702b);
        }
    }

    private zzdtn() {
    }

    public static zzdtn m21243a() {
        return f19702b;
    }

    public static zzdtn m21244a(zzfes com_google_android_gms_internal_zzfes) throws zzfge {
        return (zzdtn) zzffu.m20434a(f19702b, com_google_android_gms_internal_zzfes);
    }

    public final void mo4039a(zzffg com_google_android_gms_internal_zzffg) throws IOException {
        if (!this.f19704a.isEmpty()) {
            com_google_android_gms_internal_zzffg.mo3517a(1, this.f19704a);
        }
        this.g.m6090a(com_google_android_gms_internal_zzffg);
    }

    public final int mo4040c() {
        int i = this.h;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if (!this.f19704a.isEmpty()) {
            i2 = 0 + zzffg.m13769b(1, this.f19704a);
        }
        i2 += this.g.m6093c();
        this.h = i2;
        return i2;
    }

    protected final Object mo4293a(int i, Object obj, Object obj2) {
        byte b = (byte) 0;
        switch (zzdto.f7303a[i - 1]) {
            case 1:
                return new zzdtn();
            case 2:
                return f19702b;
            case 3:
                return null;
            case 4:
                return new zza();
            case 5:
                zzdtn com_google_android_gms_internal_zzdtn = (zzdtn) obj2;
                this.f19704a = ((zzh) obj).mo1906a(this.f19704a.isEmpty() ^ 1, this.f19704a, true ^ com_google_android_gms_internal_zzdtn.f19704a.isEmpty(), com_google_android_gms_internal_zzdtn.f19704a);
                return this;
            case 6:
                zzffb com_google_android_gms_internal_zzffb = (zzffb) obj;
                if (((zzffm) obj2) != null) {
                    while (b == (byte) 0) {
                        try {
                            i = com_google_android_gms_internal_zzffb.mo1878a();
                            if (i != 0) {
                                if (i == 10) {
                                    this.f19704a = com_google_android_gms_internal_zzffb.mo1887f();
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
                if (f19703c == 0) {
                    synchronized (zzdtn.class) {
                        if (f19703c == null) {
                            f19703c = new zzb(f19702b);
                        }
                    }
                }
                return f19703c;
            case 9:
                return Byte.valueOf((byte) 1);
            case 10:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
        return f19702b;
    }

    static {
        zzffu com_google_android_gms_internal_zzdtn = new zzdtn();
        f19702b = com_google_android_gms_internal_zzdtn;
        com_google_android_gms_internal_zzdtn.mo4293a(zzg.f7408f, null, null);
        com_google_android_gms_internal_zzdtn.f19235g.f7470e = false;
    }
}
