package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

final class zzffq<FieldDescriptorType extends zzffs<FieldDescriptorType>> {
    private static final zzffq f7397d = new zzffq((byte) 0);
    final zzfhy<FieldDescriptorType, Object> f7398a = zzfhy.m6061a(16);
    private boolean f7399b;
    private boolean f7400c = false;

    private zzffq() {
    }

    private zzffq(byte b) {
        if (!this.f7399b) {
            this.f7398a.mo1917a();
            this.f7399b = true;
        }
    }

    private static int m5991a(zzfiy com_google_android_gms_internal_zzfiy, int i, Object obj) {
        i = zzffg.m13790f(i);
        if (com_google_android_gms_internal_zzfiy == zzfiy.GROUP) {
            zzffz.m6015a();
            i <<= 1;
        }
        return i + m5996b(com_google_android_gms_internal_zzfiy, obj);
    }

    public static <T extends zzffs<T>> zzffq<T> m5993a() {
        return new zzffq();
    }

    private void m5994a(FieldDescriptorType fieldDescriptorType, Object obj) {
        if (!fieldDescriptorType.m6001d()) {
            m5995a(fieldDescriptorType.m5999b(), obj);
        } else if (obj instanceof List) {
            List arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            ArrayList arrayList2 = (ArrayList) arrayList;
            int size = arrayList2.size();
            int i = 0;
            while (i < size) {
                Object obj2 = arrayList2.get(i);
                i++;
                m5995a(fieldDescriptorType.m5999b(), obj2);
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof zzfgg) {
            this.f7400c = true;
        }
        this.f7398a.m6069a((Comparable) fieldDescriptorType, obj);
    }

    private static int m5996b(zzfiy com_google_android_gms_internal_zzfiy, Object obj) {
        switch (zzffr.f7402b[com_google_android_gms_internal_zzfiy.ordinal()]) {
            case 1:
                ((Double) obj).doubleValue();
                return zzffg.m13792g();
            case 2:
                ((Float) obj).floatValue();
                return zzffg.m13789f();
            case 3:
                return zzffg.m13778c(((Long) obj).longValue());
            case 4:
                return zzffg.m13784d(((Long) obj).longValue());
            case 5:
                return zzffg.m13793g(((Integer) obj).intValue());
            case 6:
                ((Long) obj).longValue();
                return zzffg.m13780d();
            case 7:
                ((Integer) obj).intValue();
                return zzffg.m13768b();
            case 8:
                ((Boolean) obj).booleanValue();
                return zzffg.m13794h();
            case 9:
                return zzffg.m13779c((zzfhe) obj);
            case 10:
                return obj instanceof zzfgg ? zzffg.m13766a((zzfgg) obj) : zzffg.m13771b((zzfhe) obj);
            case 11:
                return obj instanceof zzfes ? zzffg.m13770b((zzfes) obj) : zzffg.m13772b((String) obj);
            case 12:
                return obj instanceof zzfes ? zzffg.m13770b((zzfes) obj) : zzffg.m13773b((byte[]) obj);
            case 13:
                return zzffg.m13795h(((Integer) obj).intValue());
            case 14:
                ((Integer) obj).intValue();
                return zzffg.m13774c();
            case 15:
                ((Long) obj).longValue();
                return zzffg.m13785e();
            case 16:
                return zzffg.m13796i(((Integer) obj).intValue());
            case 17:
                return zzffg.m13788e(((Long) obj).longValue());
            case 18:
                return obj instanceof zzfga ? zzffg.m13797j(((zzfga) obj).mo1865a()) : zzffg.m13797j(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public final Iterator<Entry<FieldDescriptorType, Object>> m5997b() {
        return this.f7400c ? new zzfgj(this.f7398a.entrySet().iterator()) : this.f7398a.entrySet().iterator();
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzffq com_google_android_gms_internal_zzffq = new zzffq();
        for (int i = 0; i < this.f7398a.m6071b(); i++) {
            Entry b = this.f7398a.m6072b(i);
            com_google_android_gms_internal_zzffq.m5994a((zzffs) b.getKey(), b.getValue());
        }
        for (Entry b2 : this.f7398a.m6073c()) {
            com_google_android_gms_internal_zzffq.m5994a((zzffs) b2.getKey(), b2.getValue());
        }
        com_google_android_gms_internal_zzffq.f7400c = this.f7400c;
        return com_google_android_gms_internal_zzffq;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzffq)) {
            return false;
        }
        return this.f7398a.equals(((zzffq) obj).f7398a);
    }

    public final int hashCode() {
        return this.f7398a.hashCode();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void m5995a(com.google.android.gms.internal.zzfiy r2, java.lang.Object r3) {
        /*
        com.google.android.gms.internal.zzffz.m6013a(r3);
        r0 = com.google.android.gms.internal.zzffr.f7401a;
        r2 = r2.f7516s;
        r2 = r2.ordinal();
        r2 = r0[r2];
        r0 = 1;
        r1 = 0;
        switch(r2) {
            case 1: goto L_0x003e;
            case 2: goto L_0x003b;
            case 3: goto L_0x0038;
            case 4: goto L_0x0035;
            case 5: goto L_0x0032;
            case 6: goto L_0x002f;
            case 7: goto L_0x0026;
            case 8: goto L_0x001c;
            case 9: goto L_0x0013;
            default: goto L_0x0012;
        };
    L_0x0012:
        goto L_0x0041;
    L_0x0013:
        r2 = r3 instanceof com.google.android.gms.internal.zzfhe;
        if (r2 != 0) goto L_0x0024;
    L_0x0017:
        r2 = r3 instanceof com.google.android.gms.internal.zzfgg;
        if (r2 == 0) goto L_0x0041;
    L_0x001b:
        goto L_0x0024;
    L_0x001c:
        r2 = r3 instanceof java.lang.Integer;
        if (r2 != 0) goto L_0x0024;
    L_0x0020:
        r2 = r3 instanceof com.google.android.gms.internal.zzfga;
        if (r2 == 0) goto L_0x0041;
    L_0x0024:
        r1 = r0;
        goto L_0x0041;
    L_0x0026:
        r2 = r3 instanceof com.google.android.gms.internal.zzfes;
        if (r2 != 0) goto L_0x0024;
    L_0x002a:
        r2 = r3 instanceof byte[];
        if (r2 == 0) goto L_0x0041;
    L_0x002e:
        goto L_0x0024;
    L_0x002f:
        r0 = r3 instanceof java.lang.String;
        goto L_0x0024;
    L_0x0032:
        r0 = r3 instanceof java.lang.Boolean;
        goto L_0x0024;
    L_0x0035:
        r0 = r3 instanceof java.lang.Double;
        goto L_0x0024;
    L_0x0038:
        r0 = r3 instanceof java.lang.Float;
        goto L_0x0024;
    L_0x003b:
        r0 = r3 instanceof java.lang.Long;
        goto L_0x0024;
    L_0x003e:
        r0 = r3 instanceof java.lang.Integer;
        goto L_0x0024;
    L_0x0041:
        if (r1 != 0) goto L_0x004b;
    L_0x0043:
        r2 = new java.lang.IllegalArgumentException;
        r3 = "Wrong object type used with protocol message reflection.";
        r2.<init>(r3);
        throw r2;
    L_0x004b:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzffq.a(com.google.android.gms.internal.zzfiy, java.lang.Object):void");
    }

    static int m5992a(Entry<FieldDescriptorType, Object> entry) {
        zzffs com_google_android_gms_internal_zzffs = (zzffs) entry.getKey();
        Object value = entry.getValue();
        if (com_google_android_gms_internal_zzffs.m6000c() == zzfjd.MESSAGE && !com_google_android_gms_internal_zzffs.m6001d() && !com_google_android_gms_internal_zzffs.m6002e()) {
            return value instanceof zzfgg ? zzffg.m13765a(((zzffs) entry.getKey()).m5998a(), (zzfgg) value) : zzffg.m13783d(((zzffs) entry.getKey()).m5998a(), (zzfhe) value);
        } else {
            entry = com_google_android_gms_internal_zzffs.m5999b();
            int a = com_google_android_gms_internal_zzffs.m5998a();
            if (!com_google_android_gms_internal_zzffs.m6001d()) {
                return m5991a(entry, a, value);
            }
            int i = 0;
            if (com_google_android_gms_internal_zzffs.m6002e()) {
                for (Object value2 : (List) value2) {
                    i += m5996b(entry, value2);
                }
                return (zzffg.m13790f(a) + i) + zzffg.m13798k(i);
            }
            for (Object value22 : (List) value22) {
                i += m5991a(entry, a, value22);
            }
            return i;
        }
    }
}
