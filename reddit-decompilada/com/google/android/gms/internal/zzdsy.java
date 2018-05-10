package com.google.android.gms.internal;

import com.google.android.gms.internal.zzffu.zzg;
import com.google.android.gms.internal.zzffu.zzh;
import java.io.IOException;

public final class zzdsy extends zzffu<zzdsy, zza> implements zzfhg {
    private static final zzdsy f19659d;
    private static volatile zzfhk<zzdsy> f19660e;
    String f19661a = "";
    zzfes f19662b = zzfes.f7377a;
    private int f19663c;

    public enum zzb implements zzfga {
        UNKNOWN_KEYMATERIAL(0),
        SYMMETRIC(1),
        ASYMMETRIC_PRIVATE(2),
        ASYMMETRIC_PUBLIC(3),
        REMOTE(4),
        UNRECOGNIZED(-1);
        
        private static final zzfgb<zzb> f14348g = null;
        private final int f14350h;

        static {
            f14348g = new zzdta();
        }

        private zzb(int i) {
            this.f14350h = i;
        }

        public static zzb m13671a(int i) {
            switch (i) {
                case 0:
                    return UNKNOWN_KEYMATERIAL;
                case 1:
                    return SYMMETRIC;
                case 2:
                    return ASYMMETRIC_PRIVATE;
                case 3:
                    return ASYMMETRIC_PUBLIC;
                case 4:
                    return REMOTE;
                default:
                    return null;
            }
        }

        public final int mo1865a() {
            if (this != UNRECOGNIZED) {
                return this.f14350h;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
    }

    public static final class zza extends com.google.android.gms.internal.zzffu.zza<zzdsy, zza> implements zzfhg {
        private zza() {
            super(zzdsy.f19659d);
        }

        public final zza m21162a(zzb com_google_android_gms_internal_zzdsy_zzb) {
            m20429d();
            zzdsy.m21165a((zzdsy) this.a, com_google_android_gms_internal_zzdsy_zzb);
            return this;
        }

        public final zza m21163a(zzfes com_google_android_gms_internal_zzfes) {
            m20429d();
            zzdsy.m21166a((zzdsy) this.a, com_google_android_gms_internal_zzfes);
            return this;
        }

        public final zza m21164a(String str) {
            m20429d();
            zzdsy.m21167a((zzdsy) this.a, str);
            return this;
        }
    }

    private zzdsy() {
    }

    public static zza m21168b() {
        zzffu com_google_android_gms_internal_zzffu = f19659d;
        com.google.android.gms.internal.zzffu.zza com_google_android_gms_internal_zzffu_zza = (com.google.android.gms.internal.zzffu.zza) com_google_android_gms_internal_zzffu.mo4293a(zzg.f7410h, null, null);
        com_google_android_gms_internal_zzffu_zza.m20427a(com_google_android_gms_internal_zzffu);
        return (zza) com_google_android_gms_internal_zzffu_zza;
    }

    public static zzdsy m21169d() {
        return f19659d;
    }

    public final zzb m21171a() {
        zzb a = zzb.m13671a(this.f19663c);
        return a == null ? zzb.UNRECOGNIZED : a;
    }

    public final void mo4039a(zzffg com_google_android_gms_internal_zzffg) throws IOException {
        if (!this.f19661a.isEmpty()) {
            com_google_android_gms_internal_zzffg.mo3517a(1, this.f19661a);
        }
        if (!this.f19662b.m5958b()) {
            com_google_android_gms_internal_zzffg.mo3515a(2, this.f19662b);
        }
        if (this.f19663c != zzb.UNKNOWN_KEYMATERIAL.mo1865a()) {
            com_google_android_gms_internal_zzffg.mo3525b(3, this.f19663c);
        }
        this.g.m6090a(com_google_android_gms_internal_zzffg);
    }

    public final int mo4040c() {
        int i = this.h;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if (!this.f19661a.isEmpty()) {
            i2 = 0 + zzffg.m13769b(1, this.f19661a);
        }
        if (!this.f19662b.m5958b()) {
            i2 += zzffg.m13776c(2, this.f19662b);
        }
        if (this.f19663c != zzb.UNKNOWN_KEYMATERIAL.mo1865a()) {
            i2 += zzffg.m13791f(3, this.f19663c);
        }
        i2 += this.g.m6093c();
        this.h = i2;
        return i2;
    }

    protected final Object mo4293a(int i, Object obj, Object obj2) {
        boolean z = true;
        byte b = (byte) 0;
        switch (zzdsz.f7284a[i - 1]) {
            case 1:
                return new zzdsy();
            case 2:
                return f19659d;
            case 3:
                return null;
            case 4:
                return new zza();
            case 5:
                zzh com_google_android_gms_internal_zzffu_zzh = (zzh) obj;
                zzdsy com_google_android_gms_internal_zzdsy = (zzdsy) obj2;
                this.f19661a = com_google_android_gms_internal_zzffu_zzh.mo1906a(this.f19661a.isEmpty() ^ 1, this.f19661a, com_google_android_gms_internal_zzdsy.f19661a.isEmpty() ^ true, com_google_android_gms_internal_zzdsy.f19661a);
                this.f19662b = com_google_android_gms_internal_zzffu_zzh.mo1902a(this.f19662b != zzfes.f7377a, this.f19662b, com_google_android_gms_internal_zzdsy.f19662b != zzfes.f7377a, com_google_android_gms_internal_zzdsy.f19662b);
                boolean z2 = this.f19663c != 0;
                int i2 = this.f19663c;
                if (com_google_android_gms_internal_zzdsy.f19663c == 0) {
                    z = false;
                }
                this.f19663c = com_google_android_gms_internal_zzffu_zzh.mo1901a(z2, i2, z, com_google_android_gms_internal_zzdsy.f19663c);
                return this;
            case 6:
                zzffb com_google_android_gms_internal_zzffb = (zzffb) obj;
                if (((zzffm) obj2) != null) {
                    while (b == (byte) 0) {
                        try {
                            i = com_google_android_gms_internal_zzffb.mo1878a();
                            if (i != 0) {
                                if (i == 10) {
                                    this.f19661a = com_google_android_gms_internal_zzffb.mo1887f();
                                } else if (i == 18) {
                                    this.f19662b = com_google_android_gms_internal_zzffb.mo1888g();
                                } else if (i == 24) {
                                    this.f19663c = com_google_android_gms_internal_zzffb.mo1890i();
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
                if (f19660e == 0) {
                    synchronized (zzdsy.class) {
                        if (f19660e == null) {
                            f19660e = new com.google.android.gms.internal.zzffu.zzb(f19659d);
                        }
                    }
                }
                return f19660e;
            case 9:
                return Byte.valueOf((byte) 1);
            case 10:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
        return f19659d;
    }

    static /* synthetic */ void m21167a(zzdsy com_google_android_gms_internal_zzdsy, String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        com_google_android_gms_internal_zzdsy.f19661a = str;
    }

    static /* synthetic */ void m21166a(zzdsy com_google_android_gms_internal_zzdsy, zzfes com_google_android_gms_internal_zzfes) {
        if (com_google_android_gms_internal_zzfes == null) {
            throw new NullPointerException();
        }
        com_google_android_gms_internal_zzdsy.f19662b = com_google_android_gms_internal_zzfes;
    }

    static /* synthetic */ void m21165a(zzdsy com_google_android_gms_internal_zzdsy, zzb com_google_android_gms_internal_zzdsy_zzb) {
        if (com_google_android_gms_internal_zzdsy_zzb == null) {
            throw new NullPointerException();
        }
        com_google_android_gms_internal_zzdsy.f19663c = com_google_android_gms_internal_zzdsy_zzb.mo1865a();
    }

    static {
        zzffu com_google_android_gms_internal_zzdsy = new zzdsy();
        f19659d = com_google_android_gms_internal_zzdsy;
        com_google_android_gms_internal_zzdsy.mo4293a(zzg.f7408f, null, null);
        com_google_android_gms_internal_zzdsy.f19235g.f7470e = false;
    }
}
