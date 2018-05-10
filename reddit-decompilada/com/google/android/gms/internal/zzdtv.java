package com.google.android.gms.internal;

import com.google.android.gms.internal.zzffu.zzb;
import com.google.android.gms.internal.zzffu.zzf;
import com.google.android.gms.internal.zzffu.zzg;
import com.google.android.gms.internal.zzffu.zzh;
import java.io.IOException;

public final class zzdtv extends zzffu<zzdtv, zza> implements zzfhg {
    private static final zzdtv f19713d;
    private static volatile zzfhk<zzdtv> f19714e;
    zzfgd<zzdtf> f19715a = zzfho.m18703d();
    private int f19716b;
    private String f19717c = "";

    public static final class zza extends com.google.android.gms.internal.zzffu.zza<zzdtv, zza> implements zzfhg {
        private zza() {
            super(zzdtv.f19713d);
        }

        public final zza m21267a(zzdtf com_google_android_gms_internal_zzdtf) {
            m20429d();
            zzdtv.m21270a((zzdtv) this.a, com_google_android_gms_internal_zzdtf);
            return this;
        }

        public final zza m21268a(String str) {
            m20429d();
            zzdtv.m21271a((zzdtv) this.a, str);
            return this;
        }
    }

    public static zza m21269a() {
        zzffu com_google_android_gms_internal_zzffu = f19713d;
        com.google.android.gms.internal.zzffu.zza com_google_android_gms_internal_zzffu_zza = (com.google.android.gms.internal.zzffu.zza) com_google_android_gms_internal_zzffu.mo4293a(zzg.f7410h, null, null);
        com_google_android_gms_internal_zzffu_zza.m20427a(com_google_android_gms_internal_zzffu);
        return (zza) com_google_android_gms_internal_zzffu_zza;
    }

    public final void mo4039a(zzffg com_google_android_gms_internal_zzffg) throws IOException {
        if (!this.f19717c.isEmpty()) {
            com_google_android_gms_internal_zzffg.mo3517a(1, this.f19717c);
        }
        for (int i = 0; i < this.f19715a.size(); i++) {
            com_google_android_gms_internal_zzffg.mo3516a(2, (zzfhe) this.f19715a.get(i));
        }
        this.g.m6090a(com_google_android_gms_internal_zzffg);
    }

    public final int mo4040c() {
        int i = this.h;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        i = !this.f19717c.isEmpty() ? zzffg.m13769b(1, this.f19717c) + 0 : 0;
        while (i2 < this.f19715a.size()) {
            i += zzffg.m13777c(2, (zzfhe) this.f19715a.get(i2));
            i2++;
        }
        i += this.g.m6093c();
        this.h = i;
        return i;
    }

    private zzdtv() {
    }

    protected final Object mo4293a(int i, Object obj, Object obj2) {
        byte b = (byte) 0;
        switch (zzdtw.f7306a[i - 1]) {
            case 1:
                return new zzdtv();
            case 2:
                return f19713d;
            case 3:
                this.f19715a.mo1876b();
                return null;
            case 4:
                return new zza();
            case 5:
                zzh com_google_android_gms_internal_zzffu_zzh = (zzh) obj;
                zzdtv com_google_android_gms_internal_zzdtv = (zzdtv) obj2;
                this.f19717c = com_google_android_gms_internal_zzffu_zzh.mo1906a(this.f19717c.isEmpty() ^ 1, this.f19717c, true ^ com_google_android_gms_internal_zzdtv.f19717c.isEmpty(), com_google_android_gms_internal_zzdtv.f19717c);
                this.f19715a = com_google_android_gms_internal_zzffu_zzh.mo1903a(this.f19715a, com_google_android_gms_internal_zzdtv.f19715a);
                if (com_google_android_gms_internal_zzffu_zzh == zzf.f14443a) {
                    this.f19716b |= com_google_android_gms_internal_zzdtv.f19716b;
                }
                return this;
            case 6:
                zzffb com_google_android_gms_internal_zzffb = (zzffb) obj;
                zzffm com_google_android_gms_internal_zzffm = (zzffm) obj2;
                if (com_google_android_gms_internal_zzffm != null) {
                    while (b == (byte) 0) {
                        try {
                            i = com_google_android_gms_internal_zzffb.mo1878a();
                            if (i != 0) {
                                int i2 = 10;
                                if (i == 10) {
                                    this.f19717c = com_google_android_gms_internal_zzffb.mo1887f();
                                } else if (i == 18) {
                                    if (this.f19715a.mo1875a() == 0) {
                                        i = this.f19715a;
                                        int size = i.size();
                                        if (size != 0) {
                                            i2 = size << 1;
                                        }
                                        this.f19715a = i.mo3535a(i2);
                                    }
                                    this.f19715a.add((zzdtf) com_google_android_gms_internal_zzffb.mo1879a(zzdtf.m21188b(), com_google_android_gms_internal_zzffm));
                                } else if (m20442a(i, com_google_android_gms_internal_zzffb) == 0) {
                                }
                            }
                            b = (byte) 1;
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
                if (f19714e == 0) {
                    synchronized (zzdtv.class) {
                        if (f19714e == null) {
                            f19714e = new zzb(f19713d);
                        }
                    }
                }
                return f19714e;
            case 9:
                return Byte.valueOf((byte) 1);
            case 10:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
        return f19713d;
    }

    static /* synthetic */ void m21271a(zzdtv com_google_android_gms_internal_zzdtv, String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        com_google_android_gms_internal_zzdtv.f19717c = str;
    }

    static /* synthetic */ void m21270a(zzdtv com_google_android_gms_internal_zzdtv, zzdtf com_google_android_gms_internal_zzdtf) {
        if (com_google_android_gms_internal_zzdtf == null) {
            throw new NullPointerException();
        }
        if (!com_google_android_gms_internal_zzdtv.f19715a.mo1875a()) {
            zzfgd com_google_android_gms_internal_zzfgd = com_google_android_gms_internal_zzdtv.f19715a;
            int size = com_google_android_gms_internal_zzfgd.size();
            com_google_android_gms_internal_zzdtv.f19715a = com_google_android_gms_internal_zzfgd.mo3535a(size == 0 ? 10 : size << 1);
        }
        com_google_android_gms_internal_zzdtv.f19715a.add(com_google_android_gms_internal_zzdtf);
    }

    static {
        zzffu com_google_android_gms_internal_zzdtv = new zzdtv();
        f19713d = com_google_android_gms_internal_zzdtv;
        com_google_android_gms_internal_zzdtv.mo4293a(zzg.f7408f, null, null);
        com_google_android_gms_internal_zzdtv.f19235g.f7470e = false;
    }
}
