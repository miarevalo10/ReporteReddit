package com.google.android.gms.internal;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class zzfjp implements Cloneable {
    List<zzfju> f7550a = new ArrayList();
    private zzfjn<?, ?> f7551b;
    private Object f7552c;

    zzfjp() {
    }

    private final byte[] m6190b() throws IOException {
        byte[] bArr = new byte[m6192a()];
        m6193a(zzfjk.m6157a(bArr));
        return bArr;
    }

    private zzfjp m6191c() {
        zzfjp com_google_android_gms_internal_zzfjp = new zzfjp();
        try {
            com_google_android_gms_internal_zzfjp.f7551b = this.f7551b;
            if (this.f7550a == null) {
                com_google_android_gms_internal_zzfjp.f7550a = null;
            } else {
                com_google_android_gms_internal_zzfjp.f7550a.addAll(this.f7550a);
            }
            if (this.f7552c != null) {
                Object obj;
                if (this.f7552c instanceof zzfjs) {
                    obj = (zzfjs) ((zzfjs) this.f7552c).clone();
                } else if (this.f7552c instanceof byte[]) {
                    obj = ((byte[]) this.f7552c).clone();
                } else {
                    int i = 0;
                    Object obj2;
                    if (this.f7552c instanceof byte[][]) {
                        byte[][] bArr = (byte[][]) this.f7552c;
                        obj2 = new byte[bArr.length][];
                        com_google_android_gms_internal_zzfjp.f7552c = obj2;
                        while (i < bArr.length) {
                            obj2[i] = (byte[]) bArr[i].clone();
                            i++;
                        }
                    } else if (this.f7552c instanceof boolean[]) {
                        obj = ((boolean[]) this.f7552c).clone();
                    } else if (this.f7552c instanceof int[]) {
                        obj = ((int[]) this.f7552c).clone();
                    } else if (this.f7552c instanceof long[]) {
                        obj = ((long[]) this.f7552c).clone();
                    } else if (this.f7552c instanceof float[]) {
                        obj = ((float[]) this.f7552c).clone();
                    } else if (this.f7552c instanceof double[]) {
                        obj = ((double[]) this.f7552c).clone();
                    } else if (this.f7552c instanceof zzfjs[]) {
                        zzfjs[] com_google_android_gms_internal_zzfjsArr = (zzfjs[]) this.f7552c;
                        obj2 = new zzfjs[com_google_android_gms_internal_zzfjsArr.length];
                        com_google_android_gms_internal_zzfjp.f7552c = obj2;
                        while (i < com_google_android_gms_internal_zzfjsArr.length) {
                            obj2[i] = (zzfjs) com_google_android_gms_internal_zzfjsArr[i].clone();
                            i++;
                        }
                    }
                }
                com_google_android_gms_internal_zzfjp.f7552c = obj;
                return com_google_android_gms_internal_zzfjp;
            }
            return com_google_android_gms_internal_zzfjp;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    final int m6192a() {
        int i;
        int i2 = 0;
        if (this.f7552c != null) {
            zzfjn com_google_android_gms_internal_zzfjn = this.f7551b;
            Object obj = this.f7552c;
            if (!com_google_android_gms_internal_zzfjn.f7543c) {
                return com_google_android_gms_internal_zzfjn.m6185a(obj);
            }
            int length = Array.getLength(obj);
            i = 0;
            while (i2 < length) {
                if (Array.get(obj, i2) != null) {
                    i += com_google_android_gms_internal_zzfjn.m6185a(Array.get(obj, i2));
                }
                i2++;
            }
        } else {
            i = 0;
            for (zzfju com_google_android_gms_internal_zzfju : this.f7550a) {
                i += (zzfjk.m6169d(com_google_android_gms_internal_zzfju.f7557a) + 0) + com_google_android_gms_internal_zzfju.f7558b.length;
            }
        }
        return i;
    }

    final void m6193a(zzfjk com_google_android_gms_internal_zzfjk) throws IOException {
        if (this.f7552c != null) {
            zzfjn com_google_android_gms_internal_zzfjn = this.f7551b;
            Object obj = this.f7552c;
            if (com_google_android_gms_internal_zzfjn.f7543c) {
                int length = Array.getLength(obj);
                for (int i = 0; i < length; i++) {
                    Object obj2 = Array.get(obj, i);
                    if (obj2 != null) {
                        com_google_android_gms_internal_zzfjn.m6186a(obj2, com_google_android_gms_internal_zzfjk);
                    }
                }
                return;
            }
            com_google_android_gms_internal_zzfjn.m6186a(obj, com_google_android_gms_internal_zzfjk);
            return;
        }
        for (zzfju com_google_android_gms_internal_zzfju : this.f7550a) {
            com_google_android_gms_internal_zzfjk.m6182c(com_google_android_gms_internal_zzfju.f7557a);
            com_google_android_gms_internal_zzfjk.m6184c(com_google_android_gms_internal_zzfju.f7558b);
        }
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        return m6191c();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfjp)) {
            return false;
        }
        zzfjp com_google_android_gms_internal_zzfjp = (zzfjp) obj;
        if (this.f7552c != null && com_google_android_gms_internal_zzfjp.f7552c != null) {
            return this.f7551b != com_google_android_gms_internal_zzfjp.f7551b ? false : !this.f7551b.f7541a.isArray() ? this.f7552c.equals(com_google_android_gms_internal_zzfjp.f7552c) : this.f7552c instanceof byte[] ? Arrays.equals((byte[]) this.f7552c, (byte[]) com_google_android_gms_internal_zzfjp.f7552c) : this.f7552c instanceof int[] ? Arrays.equals((int[]) this.f7552c, (int[]) com_google_android_gms_internal_zzfjp.f7552c) : this.f7552c instanceof long[] ? Arrays.equals((long[]) this.f7552c, (long[]) com_google_android_gms_internal_zzfjp.f7552c) : this.f7552c instanceof float[] ? Arrays.equals((float[]) this.f7552c, (float[]) com_google_android_gms_internal_zzfjp.f7552c) : this.f7552c instanceof double[] ? Arrays.equals((double[]) this.f7552c, (double[]) com_google_android_gms_internal_zzfjp.f7552c) : this.f7552c instanceof boolean[] ? Arrays.equals((boolean[]) this.f7552c, (boolean[]) com_google_android_gms_internal_zzfjp.f7552c) : Arrays.deepEquals((Object[]) this.f7552c, (Object[]) com_google_android_gms_internal_zzfjp.f7552c);
        } else {
            if (this.f7550a != null && com_google_android_gms_internal_zzfjp.f7550a != null) {
                return this.f7550a.equals(com_google_android_gms_internal_zzfjp.f7550a);
            }
            try {
                return Arrays.equals(m6190b(), com_google_android_gms_internal_zzfjp.m6190b());
            } catch (Throwable e) {
                throw new IllegalStateException(e);
            }
        }
    }

    public final int hashCode() {
        try {
            return 527 + Arrays.hashCode(m6190b());
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }
}
