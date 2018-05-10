package com.google.android.gms.internal;

import com.google.android.gms.internal.zzffu.zzf;
import com.google.android.gms.internal.zzffu.zzg;
import com.google.android.gms.internal.zzffu.zzh;
import java.io.IOException;

public final class zzdth extends zzffu<zzdth, zza> implements zzfhg {
    private static final zzdth f19682d;
    private static volatile zzfhk<zzdth> f19683e;
    int f19684a;
    zzfgd<zzb> f19685b = zzfho.m18703d();
    private int f19686c;

    public static final class zza extends com.google.android.gms.internal.zzffu.zza<zzdth, zza> implements zzfhg {
        private zza() {
            super(zzdth.f19682d);
        }
    }

    public static final class zzb extends zzffu<zzb, zza> implements zzfhg {
        private static final zzb f19676e;
        private static volatile zzfhk<zzb> f19677i;
        zzdsy f19678a;
        int f19679b;
        private int f19680c;
        private int f19681d;

        public static final class zza extends com.google.android.gms.internal.zzffu.zza<zzb, zza> implements zzfhg {
            private zza() {
                super(zzb.f19676e);
            }
        }

        private zzb() {
        }

        public static zzb m21196e() {
            return f19676e;
        }

        public final zzdsy m21198a() {
            return this.f19678a == null ? zzdsy.m21169d() : this.f19678a;
        }

        public final void mo4039a(zzffg com_google_android_gms_internal_zzffg) throws IOException {
            if (this.f19678a != null) {
                com_google_android_gms_internal_zzffg.mo3516a(1, this.f19678a == null ? zzdsy.m21169d() : this.f19678a);
            }
            if (this.f19680c != zzdtb.UNKNOWN_STATUS.mo1865a()) {
                com_google_android_gms_internal_zzffg.mo3525b(2, this.f19680c);
            }
            if (this.f19679b != 0) {
                com_google_android_gms_internal_zzffg.mo3532c(3, this.f19679b);
            }
            if (this.f19681d != zzdtt.UNKNOWN_PREFIX.mo1865a()) {
                com_google_android_gms_internal_zzffg.mo3525b(4, this.f19681d);
            }
            this.g.m6090a(com_google_android_gms_internal_zzffg);
        }

        public final zzdtb m21201b() {
            zzdtb a = zzdtb.m13673a(this.f19680c);
            return a == null ? zzdtb.UNRECOGNIZED : a;
        }

        public final int mo4040c() {
            int i = this.h;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if (this.f19678a != null) {
                i2 = 0 + zzffg.m13777c(1, this.f19678a == null ? zzdsy.m21169d() : this.f19678a);
            }
            if (this.f19680c != zzdtb.UNKNOWN_STATUS.mo1865a()) {
                i2 += zzffg.m13791f(2, this.f19680c);
            }
            if (this.f19679b != 0) {
                i2 += zzffg.m13787e(3, this.f19679b);
            }
            if (this.f19681d != zzdtt.UNKNOWN_PREFIX.mo1865a()) {
                i2 += zzffg.m13791f(4, this.f19681d);
            }
            i2 += this.g.m6093c();
            this.h = i2;
            return i2;
        }

        public final zzdtt m21203d() {
            zzdtt a = zzdtt.m13675a(this.f19681d);
            return a == null ? zzdtt.UNRECOGNIZED : a;
        }

        protected final Object mo4293a(int i, Object obj, Object obj2) {
            boolean z = true;
            byte b = (byte) 0;
            switch (zzdti.f7300a[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return f19676e;
                case 3:
                    return null;
                case 4:
                    return new zza();
                case 5:
                    zzh com_google_android_gms_internal_zzffu_zzh = (zzh) obj;
                    zzb com_google_android_gms_internal_zzdth_zzb = (zzb) obj2;
                    this.f19678a = (zzdsy) com_google_android_gms_internal_zzffu_zzh.mo1904a(this.f19678a, com_google_android_gms_internal_zzdth_zzb.f19678a);
                    this.f19680c = com_google_android_gms_internal_zzffu_zzh.mo1901a(this.f19680c != 0, this.f19680c, com_google_android_gms_internal_zzdth_zzb.f19680c != 0, com_google_android_gms_internal_zzdth_zzb.f19680c);
                    this.f19679b = com_google_android_gms_internal_zzffu_zzh.mo1901a(this.f19679b != 0, this.f19679b, com_google_android_gms_internal_zzdth_zzb.f19679b != 0, com_google_android_gms_internal_zzdth_zzb.f19679b);
                    boolean z2 = this.f19681d != 0;
                    int i2 = this.f19681d;
                    if (com_google_android_gms_internal_zzdth_zzb.f19681d == 0) {
                        z = false;
                    }
                    this.f19681d = com_google_android_gms_internal_zzffu_zzh.mo1901a(z2, i2, z, com_google_android_gms_internal_zzdth_zzb.f19681d);
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
                                        if (this.f19678a != 0) {
                                            zzffu com_google_android_gms_internal_zzffu = this.f19678a;
                                            com.google.android.gms.internal.zzffu.zza com_google_android_gms_internal_zzffu_zza = (com.google.android.gms.internal.zzffu.zza) com_google_android_gms_internal_zzffu.mo4293a(zzg.f7410h, null, null);
                                            com_google_android_gms_internal_zzffu_zza.m20427a(com_google_android_gms_internal_zzffu);
                                            i = (com.google.android.gms.internal.zzdsy.zza) com_google_android_gms_internal_zzffu_zza;
                                        } else {
                                            i = 0;
                                        }
                                        this.f19678a = (zzdsy) com_google_android_gms_internal_zzffb.mo1879a(zzdsy.m21169d(), com_google_android_gms_internal_zzffm);
                                        if (i != 0) {
                                            i.m20427a(this.f19678a);
                                            this.f19678a = (zzdsy) i.m20430e();
                                        }
                                    } else if (i == 16) {
                                        this.f19680c = com_google_android_gms_internal_zzffb.mo1890i();
                                    } else if (i == 24) {
                                        this.f19679b = com_google_android_gms_internal_zzffb.mo1889h();
                                    } else if (i == 32) {
                                        this.f19681d = com_google_android_gms_internal_zzffb.mo1890i();
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
                    if (f19677i == 0) {
                        synchronized (zzb.class) {
                            if (f19677i == null) {
                                f19677i = new com.google.android.gms.internal.zzffu.zzb(f19676e);
                            }
                        }
                    }
                    return f19677i;
                case 9:
                    return Byte.valueOf((byte) 1);
                case 10:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
            return f19676e;
        }

        static {
            zzffu com_google_android_gms_internal_zzdth_zzb = new zzb();
            f19676e = com_google_android_gms_internal_zzdth_zzb;
            com_google_android_gms_internal_zzdth_zzb.mo4293a(zzg.f7408f, null, null);
            com_google_android_gms_internal_zzdth_zzb.f19235g.f7470e = false;
        }
    }

    public static zzdth m21204a(byte[] bArr) throws zzfge {
        return (zzdth) zzffu.m20437a(f19682d, bArr);
    }

    public final int m21206a() {
        return this.f19685b.size();
    }

    public final void mo4039a(zzffg com_google_android_gms_internal_zzffg) throws IOException {
        if (this.f19684a != 0) {
            com_google_android_gms_internal_zzffg.mo3532c(1, this.f19684a);
        }
        for (int i = 0; i < this.f19685b.size(); i++) {
            com_google_android_gms_internal_zzffg.mo3516a(2, (zzfhe) this.f19685b.get(i));
        }
        this.g.m6090a(com_google_android_gms_internal_zzffg);
    }

    public final int mo4040c() {
        int i = this.h;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        i = this.f19684a != 0 ? zzffg.m13787e(1, this.f19684a) + 0 : 0;
        while (i2 < this.f19685b.size()) {
            i += zzffg.m13777c(2, (zzfhe) this.f19685b.get(i2));
            i2++;
        }
        i += this.g.m6093c();
        this.h = i;
        return i;
    }

    private zzdth() {
    }

    protected final Object mo4293a(int i, Object obj, Object obj2) {
        boolean z = true;
        byte b = (byte) 0;
        int i2;
        switch (zzdti.f7300a[i - 1]) {
            case 1:
                return new zzdth();
            case 2:
                return f19682d;
            case 3:
                this.f19685b.mo1876b();
                return null;
            case 4:
                return new zza();
            case 5:
                zzh com_google_android_gms_internal_zzffu_zzh = (zzh) obj;
                zzdth com_google_android_gms_internal_zzdth = (zzdth) obj2;
                boolean z2 = this.f19684a != 0;
                i2 = this.f19684a;
                if (com_google_android_gms_internal_zzdth.f19684a == 0) {
                    z = false;
                }
                this.f19684a = com_google_android_gms_internal_zzffu_zzh.mo1901a(z2, i2, z, com_google_android_gms_internal_zzdth.f19684a);
                this.f19685b = com_google_android_gms_internal_zzffu_zzh.mo1903a(this.f19685b, com_google_android_gms_internal_zzdth.f19685b);
                if (com_google_android_gms_internal_zzffu_zzh == zzf.f14443a) {
                    this.f19686c |= com_google_android_gms_internal_zzdth.f19686c;
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
                                    this.f19684a = com_google_android_gms_internal_zzffb.mo1889h();
                                } else if (i == 18) {
                                    if (this.f19685b.mo1875a() == 0) {
                                        i = this.f19685b;
                                        i2 = i.size();
                                        this.f19685b = i.mo3535a(i2 == 0 ? 10 : i2 << 1);
                                    }
                                    this.f19685b.add((zzb) com_google_android_gms_internal_zzffb.mo1879a(zzb.m21196e(), com_google_android_gms_internal_zzffm));
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
                if (f19683e == 0) {
                    synchronized (zzdth.class) {
                        if (f19683e == null) {
                            f19683e = new com.google.android.gms.internal.zzffu.zzb(f19682d);
                        }
                    }
                }
                return f19683e;
            case 9:
                return Byte.valueOf((byte) 1);
            case 10:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
        return f19682d;
    }

    static {
        zzffu com_google_android_gms_internal_zzdth = new zzdth();
        f19682d = com_google_android_gms_internal_zzdth;
        com_google_android_gms_internal_zzdth.mo4293a(zzg.f7408f, null, null);
        com_google_android_gms_internal_zzdth.f19235g.f7470e = false;
    }
}
