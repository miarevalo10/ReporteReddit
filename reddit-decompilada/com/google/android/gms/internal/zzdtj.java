package com.google.android.gms.internal;

import com.google.android.gms.internal.zzffu.zzf;
import com.google.android.gms.internal.zzffu.zzg;
import com.google.android.gms.internal.zzffu.zzh;
import java.io.IOException;

public final class zzdtj extends zzffu<zzdtj, zza> implements zzfhg {
    private static final zzdtj f19693d;
    private static volatile zzfhk<zzdtj> f19694e;
    private int f19695a;
    private int f19696b;
    private zzfgd<zzb> f19697c = zzfho.m18703d();

    public static final class zza extends com.google.android.gms.internal.zzffu.zza<zzdtj, zza> implements zzfhg {
        private zza() {
            super(zzdtj.f19693d);
        }

        public final zza m21210a(int i) {
            m20429d();
            ((zzdtj) this.a).f19696b = i;
            return this;
        }

        public final zza m21211a(zzb com_google_android_gms_internal_zzdtj_zzb) {
            m20429d();
            zzdtj.m21228a((zzdtj) this.a, com_google_android_gms_internal_zzdtj_zzb);
            return this;
        }
    }

    public static final class zzb extends zzffu<zzb, zza> implements zzfhg {
        private static final zzb f19687e;
        private static volatile zzfhk<zzb> f19688i;
        private String f19689a = "";
        private int f19690b;
        private int f19691c;
        private int f19692d;

        public static final class zza extends com.google.android.gms.internal.zzffu.zza<zzb, zza> implements zzfhg {
            private zza() {
                super(zzb.f19687e);
            }

            public final zza m21212a(int i) {
                m20429d();
                ((zzb) this.a).f19691c = i;
                return this;
            }

            public final zza m21213a(zzdtb com_google_android_gms_internal_zzdtb) {
                m20429d();
                zzb.m21218a((zzb) this.a, com_google_android_gms_internal_zzdtb);
                return this;
            }

            public final zza m21214a(zzdtt com_google_android_gms_internal_zzdtt) {
                m20429d();
                zzb.m21219a((zzb) this.a, com_google_android_gms_internal_zzdtt);
                return this;
            }

            public final zza m21215a(String str) {
                m20429d();
                zzb.m21220a((zzb) this.a, str);
                return this;
            }
        }

        private zzb() {
        }

        public static zza m21216a() {
            zzffu com_google_android_gms_internal_zzffu = f19687e;
            com.google.android.gms.internal.zzffu.zza com_google_android_gms_internal_zzffu_zza = (com.google.android.gms.internal.zzffu.zza) com_google_android_gms_internal_zzffu.mo4293a(zzg.f7410h, null, null);
            com_google_android_gms_internal_zzffu_zza.m20427a(com_google_android_gms_internal_zzffu);
            return (zza) com_google_android_gms_internal_zzffu_zza;
        }

        public static zzb m21221b() {
            return f19687e;
        }

        public final void mo4039a(zzffg com_google_android_gms_internal_zzffg) throws IOException {
            if (!this.f19689a.isEmpty()) {
                com_google_android_gms_internal_zzffg.mo3517a(1, this.f19689a);
            }
            if (this.f19690b != zzdtb.UNKNOWN_STATUS.mo1865a()) {
                com_google_android_gms_internal_zzffg.mo3525b(2, this.f19690b);
            }
            if (this.f19691c != 0) {
                com_google_android_gms_internal_zzffg.mo3532c(3, this.f19691c);
            }
            if (this.f19692d != zzdtt.UNKNOWN_PREFIX.mo1865a()) {
                com_google_android_gms_internal_zzffg.mo3525b(4, this.f19692d);
            }
            this.g.m6090a(com_google_android_gms_internal_zzffg);
        }

        public final int mo4040c() {
            int i = this.h;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if (!this.f19689a.isEmpty()) {
                i2 = 0 + zzffg.m13769b(1, this.f19689a);
            }
            if (this.f19690b != zzdtb.UNKNOWN_STATUS.mo1865a()) {
                i2 += zzffg.m13791f(2, this.f19690b);
            }
            if (this.f19691c != 0) {
                i2 += zzffg.m13787e(3, this.f19691c);
            }
            if (this.f19692d != zzdtt.UNKNOWN_PREFIX.mo1865a()) {
                i2 += zzffg.m13791f(4, this.f19692d);
            }
            i2 += this.g.m6093c();
            this.h = i2;
            return i2;
        }

        protected final Object mo4293a(int i, Object obj, Object obj2) {
            boolean z = true;
            byte b = (byte) 0;
            switch (zzdtk.f7301a[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return f19687e;
                case 3:
                    return null;
                case 4:
                    return new zza();
                case 5:
                    zzh com_google_android_gms_internal_zzffu_zzh = (zzh) obj;
                    zzb com_google_android_gms_internal_zzdtj_zzb = (zzb) obj2;
                    this.f19689a = com_google_android_gms_internal_zzffu_zzh.mo1906a(this.f19689a.isEmpty() ^ 1, this.f19689a, com_google_android_gms_internal_zzdtj_zzb.f19689a.isEmpty() ^ true, com_google_android_gms_internal_zzdtj_zzb.f19689a);
                    this.f19690b = com_google_android_gms_internal_zzffu_zzh.mo1901a(this.f19690b != 0, this.f19690b, com_google_android_gms_internal_zzdtj_zzb.f19690b != 0, com_google_android_gms_internal_zzdtj_zzb.f19690b);
                    this.f19691c = com_google_android_gms_internal_zzffu_zzh.mo1901a(this.f19691c != 0, this.f19691c, com_google_android_gms_internal_zzdtj_zzb.f19691c != 0, com_google_android_gms_internal_zzdtj_zzb.f19691c);
                    boolean z2 = this.f19692d != 0;
                    int i2 = this.f19692d;
                    if (com_google_android_gms_internal_zzdtj_zzb.f19692d == 0) {
                        z = false;
                    }
                    this.f19692d = com_google_android_gms_internal_zzffu_zzh.mo1901a(z2, i2, z, com_google_android_gms_internal_zzdtj_zzb.f19692d);
                    return this;
                case 6:
                    zzffb com_google_android_gms_internal_zzffb = (zzffb) obj;
                    if (((zzffm) obj2) != null) {
                        while (b == (byte) 0) {
                            try {
                                i = com_google_android_gms_internal_zzffb.mo1878a();
                                if (i != 0) {
                                    if (i == 10) {
                                        this.f19689a = com_google_android_gms_internal_zzffb.mo1887f();
                                    } else if (i == 16) {
                                        this.f19690b = com_google_android_gms_internal_zzffb.mo1890i();
                                    } else if (i == 24) {
                                        this.f19691c = com_google_android_gms_internal_zzffb.mo1889h();
                                    } else if (i == 32) {
                                        this.f19692d = com_google_android_gms_internal_zzffb.mo1890i();
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
                    if (f19688i == 0) {
                        synchronized (zzb.class) {
                            if (f19688i == null) {
                                f19688i = new com.google.android.gms.internal.zzffu.zzb(f19687e);
                            }
                        }
                    }
                    return f19688i;
                case 9:
                    return Byte.valueOf((byte) 1);
                case 10:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
            return f19687e;
        }

        static /* synthetic */ void m21220a(zzb com_google_android_gms_internal_zzdtj_zzb, String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            com_google_android_gms_internal_zzdtj_zzb.f19689a = str;
        }

        static /* synthetic */ void m21218a(zzb com_google_android_gms_internal_zzdtj_zzb, zzdtb com_google_android_gms_internal_zzdtb) {
            if (com_google_android_gms_internal_zzdtb == null) {
                throw new NullPointerException();
            }
            com_google_android_gms_internal_zzdtj_zzb.f19690b = com_google_android_gms_internal_zzdtb.mo1865a();
        }

        static /* synthetic */ void m21219a(zzb com_google_android_gms_internal_zzdtj_zzb, zzdtt com_google_android_gms_internal_zzdtt) {
            if (com_google_android_gms_internal_zzdtt == null) {
                throw new NullPointerException();
            }
            com_google_android_gms_internal_zzdtj_zzb.f19692d = com_google_android_gms_internal_zzdtt.mo1865a();
        }

        static {
            zzffu com_google_android_gms_internal_zzdtj_zzb = new zzb();
            f19687e = com_google_android_gms_internal_zzdtj_zzb;
            com_google_android_gms_internal_zzdtj_zzb.mo4293a(zzg.f7408f, null, null);
            com_google_android_gms_internal_zzdtj_zzb.f19235g.f7470e = false;
        }
    }

    public static zza m21226a() {
        zzffu com_google_android_gms_internal_zzffu = f19693d;
        com.google.android.gms.internal.zzffu.zza com_google_android_gms_internal_zzffu_zza = (com.google.android.gms.internal.zzffu.zza) com_google_android_gms_internal_zzffu.mo4293a(zzg.f7410h, null, null);
        com_google_android_gms_internal_zzffu_zza.m20427a(com_google_android_gms_internal_zzffu);
        return (zza) com_google_android_gms_internal_zzffu_zza;
    }

    public final void mo4039a(zzffg com_google_android_gms_internal_zzffg) throws IOException {
        if (this.f19696b != 0) {
            com_google_android_gms_internal_zzffg.mo3532c(1, this.f19696b);
        }
        for (int i = 0; i < this.f19697c.size(); i++) {
            com_google_android_gms_internal_zzffg.mo3516a(2, (zzfhe) this.f19697c.get(i));
        }
        this.g.m6090a(com_google_android_gms_internal_zzffg);
    }

    public final int mo4040c() {
        int i = this.h;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        i = this.f19696b != 0 ? zzffg.m13787e(1, this.f19696b) + 0 : 0;
        while (i2 < this.f19697c.size()) {
            i += zzffg.m13777c(2, (zzfhe) this.f19697c.get(i2));
            i2++;
        }
        i += this.g.m6093c();
        this.h = i;
        return i;
    }

    private zzdtj() {
    }

    protected final Object mo4293a(int i, Object obj, Object obj2) {
        boolean z = true;
        byte b = (byte) 0;
        int i2;
        switch (zzdtk.f7301a[i - 1]) {
            case 1:
                return new zzdtj();
            case 2:
                return f19693d;
            case 3:
                this.f19697c.mo1876b();
                return null;
            case 4:
                return new zza();
            case 5:
                zzh com_google_android_gms_internal_zzffu_zzh = (zzh) obj;
                zzdtj com_google_android_gms_internal_zzdtj = (zzdtj) obj2;
                boolean z2 = this.f19696b != 0;
                i2 = this.f19696b;
                if (com_google_android_gms_internal_zzdtj.f19696b == 0) {
                    z = false;
                }
                this.f19696b = com_google_android_gms_internal_zzffu_zzh.mo1901a(z2, i2, z, com_google_android_gms_internal_zzdtj.f19696b);
                this.f19697c = com_google_android_gms_internal_zzffu_zzh.mo1903a(this.f19697c, com_google_android_gms_internal_zzdtj.f19697c);
                if (com_google_android_gms_internal_zzffu_zzh == zzf.f14443a) {
                    this.f19695a |= com_google_android_gms_internal_zzdtj.f19695a;
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
                                if (i == 8) {
                                    this.f19696b = com_google_android_gms_internal_zzffb.mo1889h();
                                } else if (i == 18) {
                                    if (this.f19697c.mo1875a() == 0) {
                                        i = this.f19697c;
                                        i2 = i.size();
                                        this.f19697c = i.mo3535a(i2 == 0 ? 10 : i2 << 1);
                                    }
                                    this.f19697c.add((zzb) com_google_android_gms_internal_zzffb.mo1879a(zzb.m21221b(), com_google_android_gms_internal_zzffm));
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
                if (f19694e == 0) {
                    synchronized (zzdtj.class) {
                        if (f19694e == null) {
                            f19694e = new com.google.android.gms.internal.zzffu.zzb(f19693d);
                        }
                    }
                }
                return f19694e;
            case 9:
                return Byte.valueOf((byte) 1);
            case 10:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
        return f19693d;
    }

    static /* synthetic */ void m21228a(zzdtj com_google_android_gms_internal_zzdtj, zzb com_google_android_gms_internal_zzdtj_zzb) {
        if (com_google_android_gms_internal_zzdtj_zzb == null) {
            throw new NullPointerException();
        }
        if (!com_google_android_gms_internal_zzdtj.f19697c.mo1875a()) {
            zzfgd com_google_android_gms_internal_zzfgd = com_google_android_gms_internal_zzdtj.f19697c;
            int size = com_google_android_gms_internal_zzfgd.size();
            com_google_android_gms_internal_zzdtj.f19697c = com_google_android_gms_internal_zzfgd.mo3535a(size == 0 ? 10 : size << 1);
        }
        com_google_android_gms_internal_zzdtj.f19697c.add(com_google_android_gms_internal_zzdtj_zzb);
    }

    static {
        zzffu com_google_android_gms_internal_zzdtj = new zzdtj();
        f19693d = com_google_android_gms_internal_zzdtj;
        com_google_android_gms_internal_zzdtj.mo4293a(zzg.f7408f, null, null);
        com_google_android_gms_internal_zzdtj.f19235g.f7470e = false;
    }
}
