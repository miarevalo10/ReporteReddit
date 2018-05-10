package com.google.android.gms.internal;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class zzffu<MessageType extends zzffu<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzfek<MessageType, BuilderType> {
    private static Map<Object, zzffu<?, ?>> f19234a = new ConcurrentHashMap();
    protected zzfio f19235g = zzfio.m6085a();
    protected int f19236h = -1;

    public enum zzg {
        public static final int f7403a = 1;
        public static final int f7404b = 2;
        public static final int f7405c = 3;
        public static final int f7406d = 4;
        public static final int f7407e = 5;
        public static final int f7408f = 6;
        public static final int f7409g = 7;
        public static final int f7410h = 8;
        public static final int f7411i = 9;
        public static final int f7412j = 10;
        public static final int f7413k = 1;
        public static final int f7414l = 2;
        private static final /* synthetic */ int[] f7415m = new int[]{f7403a, f7404b, f7405c, f7406d, f7407e, f7408f, f7409g, f7410h, f7411i, f7412j};
        private static final /* synthetic */ int[] f7416n = new int[]{f7413k, f7414l};

        public static int[] m6003a() {
            return (int[]) f7415m.clone();
        }
    }

    public interface zzh {
        int mo1901a(boolean z, int i, boolean z2, int i2);

        zzfes mo1902a(boolean z, zzfes com_google_android_gms_internal_zzfes, boolean z2, zzfes com_google_android_gms_internal_zzfes2);

        <T> zzfgd<T> mo1903a(zzfgd<T> com_google_android_gms_internal_zzfgd_T, zzfgd<T> com_google_android_gms_internal_zzfgd_T2);

        <T extends zzfhe> T mo1904a(T t, T t2);

        zzfio mo1905a(zzfio com_google_android_gms_internal_zzfio, zzfio com_google_android_gms_internal_zzfio2);

        String mo1906a(boolean z, String str, boolean z2, String str2);

        boolean mo1907a(boolean z, boolean z2, boolean z3, boolean z4);
    }

    static class zzc implements zzh {
        static final zzc f14440a = new zzc();
        private static zzffv f14441b = new zzffv();

        private zzc() {
        }

        public final int mo1901a(boolean z, int i, boolean z2, int i2) {
            if (z == z2) {
                if (i == i2) {
                    return i;
                }
            }
            throw f14441b;
        }

        public final zzfes mo1902a(boolean z, zzfes com_google_android_gms_internal_zzfes, boolean z2, zzfes com_google_android_gms_internal_zzfes2) {
            if (z == z2) {
                if (com_google_android_gms_internal_zzfes.equals(com_google_android_gms_internal_zzfes2)) {
                    return com_google_android_gms_internal_zzfes;
                }
            }
            throw f14441b;
        }

        public final <T> zzfgd<T> mo1903a(zzfgd<T> com_google_android_gms_internal_zzfgd_T, zzfgd<T> com_google_android_gms_internal_zzfgd_T2) {
            if (com_google_android_gms_internal_zzfgd_T.equals(com_google_android_gms_internal_zzfgd_T2)) {
                return com_google_android_gms_internal_zzfgd_T;
            }
            throw f14441b;
        }

        public final <T extends zzfhe> T mo1904a(T t, T t2) {
            if (t == null && t2 == null) {
                return null;
            }
            if (t != null) {
                if (t2 != null) {
                    T t3 = (zzffu) t;
                    if (t3 != t2 && ((zzffu) t3.mo4293a(zzg.f7411i, null, null)).getClass().isInstance(t2)) {
                        Object obj = (zzffu) t2;
                        t3.mo4293a(zzg.f7404b, (Object) this, obj);
                        t3.f19235g = mo1905a(t3.f19235g, obj.f19235g);
                    }
                    return t;
                }
            }
            throw f14441b;
        }

        public final zzfio mo1905a(zzfio com_google_android_gms_internal_zzfio, zzfio com_google_android_gms_internal_zzfio2) {
            if (com_google_android_gms_internal_zzfio.equals(com_google_android_gms_internal_zzfio2)) {
                return com_google_android_gms_internal_zzfio;
            }
            throw f14441b;
        }

        public final String mo1906a(boolean z, String str, boolean z2, String str2) {
            if (z == z2) {
                if (str.equals(str2)) {
                    return str;
                }
            }
            throw f14441b;
        }

        public final boolean mo1907a(boolean z, boolean z2, boolean z3, boolean z4) {
            if (z == z3) {
                if (z2 == z4) {
                    return z2;
                }
            }
            throw f14441b;
        }
    }

    static class zze implements zzh {
        int f14442a = 0;

        zze() {
        }

        public final int mo1901a(boolean z, int i, boolean z2, int i2) {
            this.f14442a = (53 * this.f14442a) + i;
            return i;
        }

        public final zzfes mo1902a(boolean z, zzfes com_google_android_gms_internal_zzfes, boolean z2, zzfes com_google_android_gms_internal_zzfes2) {
            this.f14442a = (53 * this.f14442a) + com_google_android_gms_internal_zzfes.hashCode();
            return com_google_android_gms_internal_zzfes;
        }

        public final <T> zzfgd<T> mo1903a(zzfgd<T> com_google_android_gms_internal_zzfgd_T, zzfgd<T> com_google_android_gms_internal_zzfgd_T2) {
            this.f14442a = (53 * this.f14442a) + com_google_android_gms_internal_zzfgd_T.hashCode();
            return com_google_android_gms_internal_zzfgd_T;
        }

        public final <T extends zzfhe> T mo1904a(T t, T t2) {
            int i;
            if (t == null) {
                i = 37;
            } else if (t instanceof zzffu) {
                Object obj = (zzffu) t;
                if (obj.f == 0) {
                    int i2 = this.f14442a;
                    this.f14442a = 0;
                    obj.mo4293a(zzg.f7404b, (Object) this, obj);
                    obj.f19235g = mo1905a(obj.f19235g, obj.f19235g);
                    obj.f = this.f14442a;
                    this.f14442a = i2;
                }
                i = obj.f;
            } else {
                i = t.hashCode();
            }
            this.f14442a = (53 * this.f14442a) + i;
            return t;
        }

        public final zzfio mo1905a(zzfio com_google_android_gms_internal_zzfio, zzfio com_google_android_gms_internal_zzfio2) {
            this.f14442a = (53 * this.f14442a) + com_google_android_gms_internal_zzfio.hashCode();
            return com_google_android_gms_internal_zzfio;
        }

        public final String mo1906a(boolean z, String str, boolean z2, String str2) {
            this.f14442a = (53 * this.f14442a) + str.hashCode();
            return str;
        }

        public final boolean mo1907a(boolean z, boolean z2, boolean z3, boolean z4) {
            this.f14442a = (53 * this.f14442a) + zzffz.m6012a(z2);
            return z2;
        }
    }

    public static class zzf implements zzh {
        public static final zzf f14443a = new zzf();

        private zzf() {
        }

        public final int mo1901a(boolean z, int i, boolean z2, int i2) {
            return z2 ? i2 : i;
        }

        public final zzfes mo1902a(boolean z, zzfes com_google_android_gms_internal_zzfes, boolean z2, zzfes com_google_android_gms_internal_zzfes2) {
            return z2 ? com_google_android_gms_internal_zzfes2 : com_google_android_gms_internal_zzfes;
        }

        public final <T> zzfgd<T> mo1903a(zzfgd<T> com_google_android_gms_internal_zzfgd_T, zzfgd<T> com_google_android_gms_internal_zzfgd_T2) {
            int size = com_google_android_gms_internal_zzfgd_T.size();
            int size2 = com_google_android_gms_internal_zzfgd_T2.size();
            if (size > 0 && size2 > 0) {
                if (!com_google_android_gms_internal_zzfgd_T.mo1875a()) {
                    com_google_android_gms_internal_zzfgd_T = com_google_android_gms_internal_zzfgd_T.mo3535a(size2 + size);
                }
                com_google_android_gms_internal_zzfgd_T.addAll(com_google_android_gms_internal_zzfgd_T2);
            }
            return size > 0 ? com_google_android_gms_internal_zzfgd_T : com_google_android_gms_internal_zzfgd_T2;
        }

        public final <T extends zzfhe> T mo1904a(T t, T t2) {
            return (t == null || t2 == null) ? t != null ? t : t2 : t.mo4041i().mo3501a(t2).mo4037g();
        }

        public final zzfio mo1905a(zzfio com_google_android_gms_internal_zzfio, zzfio com_google_android_gms_internal_zzfio2) {
            return com_google_android_gms_internal_zzfio2 == zzfio.m6085a() ? com_google_android_gms_internal_zzfio : zzfio.m6086a(com_google_android_gms_internal_zzfio, com_google_android_gms_internal_zzfio2);
        }

        public final String mo1906a(boolean z, String str, boolean z2, String str2) {
            return z2 ? str2 : str;
        }

        public final boolean mo1907a(boolean z, boolean z2, boolean z3, boolean z4) {
            return z3 ? z4 : z2;
        }
    }

    public static class zzb<T extends zzffu<T, ?>> extends zzfen<T> {
        private T f18042a;

        public zzb(T t) {
            this.f18042a = t;
        }
    }

    public static abstract class zza<MessageType extends zzffu<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzfel<MessageType, BuilderType> {
        protected MessageType f19231a;
        private final MessageType f19232b;
        private boolean f19233c = false;

        protected zza(MessageType messageType) {
            this.f19232b = messageType;
            this.f19231a = (zzffu) messageType.mo4293a(zzg.f7409g, null, null);
        }

        private static void m20425a(MessageType messageType, MessageType messageType2) {
            Object obj = zzf.f14443a;
            messageType.mo4293a(zzg.f7404b, obj, (Object) messageType2);
            messageType.f19235g = obj.mo1905a(messageType.f19235g, messageType2.f19235g);
        }

        protected final /* synthetic */ zzfel mo4034a(zzfek com_google_android_gms_internal_zzfek) {
            return m20427a((zzffu) com_google_android_gms_internal_zzfek);
        }

        public final BuilderType m20427a(MessageType messageType) {
            m20429d();
            m20425a(this.f19231a, messageType);
            return this;
        }

        public final /* synthetic */ zzfel mo4035c() {
            return (zza) clone();
        }

        protected final void m20429d() {
            if (this.f19233c) {
                zzffu com_google_android_gms_internal_zzffu = (zzffu) this.f19231a.mo4293a(zzg.f7409g, null, null);
                m20425a(com_google_android_gms_internal_zzffu, this.f19231a);
                this.f19231a = com_google_android_gms_internal_zzffu;
                this.f19233c = false;
            }
        }

        public final /* synthetic */ zzfhe mo4038j() {
            return this.f19232b;
        }

        public final MessageType m20430e() {
            if (this.f19233c) {
                return this.f19231a;
            }
            zzffu com_google_android_gms_internal_zzffu = this.f19231a;
            com_google_android_gms_internal_zzffu.mo4293a(zzg.f7408f, null, null);
            com_google_android_gms_internal_zzffu.f19235g.f7470e = false;
            this.f19233c = true;
            return this.f19231a;
        }

        public final MessageType m20431f() {
            zzffu com_google_android_gms_internal_zzffu;
            boolean z = false;
            if (this.f19233c) {
                com_google_android_gms_internal_zzffu = this.f19231a;
            } else {
                com_google_android_gms_internal_zzffu = this.f19231a;
                com_google_android_gms_internal_zzffu.mo4293a(zzg.f7408f, null, null);
                com_google_android_gms_internal_zzffu.f19235g.f7470e = false;
                this.f19233c = true;
                com_google_android_gms_internal_zzffu = this.f19231a;
            }
            com_google_android_gms_internal_zzffu = com_google_android_gms_internal_zzffu;
            boolean booleanValue = Boolean.TRUE.booleanValue();
            byte byteValue = ((Byte) com_google_android_gms_internal_zzffu.mo4293a(zzg.f7405c, null, null)).byteValue();
            if (byteValue == (byte) 1) {
                z = true;
            } else if (byteValue != (byte) 0) {
                if (com_google_android_gms_internal_zzffu.mo4293a(zzg.f7403a, Boolean.FALSE, null) != null) {
                    z = true;
                }
                if (booleanValue) {
                    com_google_android_gms_internal_zzffu.mo4293a(zzg.f7406d, z ? com_google_android_gms_internal_zzffu : null, null);
                }
            }
            if (z) {
                return com_google_android_gms_internal_zzffu;
            }
            throw new zzfim();
        }

        public final /* synthetic */ zzfhe mo4037g() {
            zzffu com_google_android_gms_internal_zzffu;
            boolean z = false;
            if (this.f19233c) {
                com_google_android_gms_internal_zzffu = this.f19231a;
            } else {
                com_google_android_gms_internal_zzffu = this.f19231a;
                com_google_android_gms_internal_zzffu.mo4293a(zzg.f7408f, null, null);
                com_google_android_gms_internal_zzffu.f19235g.f7470e = false;
                this.f19233c = true;
                com_google_android_gms_internal_zzffu = this.f19231a;
            }
            com_google_android_gms_internal_zzffu = com_google_android_gms_internal_zzffu;
            boolean booleanValue = Boolean.TRUE.booleanValue();
            byte byteValue = ((Byte) com_google_android_gms_internal_zzffu.mo4293a(zzg.f7405c, null, null)).byteValue();
            if (byteValue == (byte) 1) {
                z = true;
            } else if (byteValue != (byte) 0) {
                if (com_google_android_gms_internal_zzffu.mo4293a(zzg.f7403a, Boolean.FALSE, null) != null) {
                    z = true;
                }
                if (booleanValue) {
                    com_google_android_gms_internal_zzffu.mo4293a(zzg.f7406d, z ? com_google_android_gms_internal_zzffu : null, null);
                }
            }
            if (z) {
                return com_google_android_gms_internal_zzffu;
            }
            throw new zzfim();
        }

        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            zzffu com_google_android_gms_internal_zzffu;
            zza com_google_android_gms_internal_zzffu_zza = (zza) this.f19232b.mo4293a(zzg.f7410h, null, null);
            if (this.f19233c) {
                com_google_android_gms_internal_zzffu = this.f19231a;
            } else {
                com_google_android_gms_internal_zzffu = this.f19231a;
                com_google_android_gms_internal_zzffu.mo4293a(zzg.f7408f, null, null);
                com_google_android_gms_internal_zzffu.f19235g.f7470e = false;
                this.f19233c = true;
                com_google_android_gms_internal_zzffu = this.f19231a;
            }
            com_google_android_gms_internal_zzffu_zza.m20427a(com_google_android_gms_internal_zzffu);
            return com_google_android_gms_internal_zzffu_zza;
        }
    }

    public static abstract class zzd<MessageType extends zzd<MessageType, BuilderType>, BuilderType> extends zzffu<MessageType, BuilderType> implements zzfhg {
        protected zzffq<Object> f19718a = zzffq.m5993a();
    }

    static Object m20439a(Method method, Object obj, Object... objArr) {
        Throwable e;
        try {
            return method.invoke(obj, objArr);
        } catch (Throwable e2) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e2);
        } catch (InvocationTargetException e3) {
            e2 = e3.getCause();
            if (e2 instanceof RuntimeException) {
                throw ((RuntimeException) e2);
            } else if (e2 instanceof Error) {
                throw ((Error) e2);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", e2);
            }
        }
    }

    protected abstract Object mo4293a(int i, Object obj, Object obj2);

    public void mo4039a(zzffg com_google_android_gms_internal_zzffg) throws IOException {
        zzfhn.m6047a().m6049a(getClass()).mo1912a(this, zzffi.m13823a(com_google_android_gms_internal_zzffg));
    }

    protected final boolean m20442a(int i, zzffb com_google_android_gms_internal_zzffb) throws IOException {
        if ((i & 7) == 4) {
            return false;
        }
        if (this.f19235g == zzfio.m6085a()) {
            this.f19235g = zzfio.m6088b();
        }
        return this.f19235g.m6092a(i, com_google_android_gms_internal_zzffb);
    }

    public int mo4040c() {
        if (this.f19236h == -1) {
            this.f19236h = zzfhn.m6047a().m6049a(getClass()).mo1911a(this);
        }
        return this.f19236h;
    }

    public boolean equals(java.lang.Object r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r4 = this;
        r0 = 1;
        if (r4 != r5) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = com.google.android.gms.internal.zzffu.zzg.f7411i;
        r2 = 0;
        r1 = r4.mo4293a(r1, r2, r2);
        r1 = (com.google.android.gms.internal.zzffu) r1;
        r1 = r1.getClass();
        r1 = r1.isInstance(r5);
        r2 = 0;
        if (r1 != 0) goto L_0x0019;
    L_0x0018:
        return r2;
    L_0x0019:
        r1 = com.google.android.gms.internal.zzffu.zzc.f14440a;	 Catch:{ zzffv -> 0x002d }
        r5 = (com.google.android.gms.internal.zzffu) r5;	 Catch:{ zzffv -> 0x002d }
        r3 = com.google.android.gms.internal.zzffu.zzg.f7404b;	 Catch:{ zzffv -> 0x002d }
        r4.mo4293a(r3, r1, r5);	 Catch:{ zzffv -> 0x002d }
        r3 = r4.f19235g;	 Catch:{ zzffv -> 0x002d }
        r5 = r5.f19235g;	 Catch:{ zzffv -> 0x002d }
        r5 = r1.mo1905a(r3, r5);	 Catch:{ zzffv -> 0x002d }
        r4.f19235g = r5;	 Catch:{ zzffv -> 0x002d }
        return r0;
    L_0x002d:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzffu.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        if (this.f != 0) {
            return this.f;
        }
        Object com_google_android_gms_internal_zzffu_zze = new zze();
        mo4293a(zzg.f7404b, com_google_android_gms_internal_zzffu_zze, (Object) this);
        this.f19235g = com_google_android_gms_internal_zzffu_zze.mo1905a(this.f19235g, this.f19235g);
        this.f = com_google_android_gms_internal_zzffu_zze.f14442a;
        return this.f;
    }

    public final /* synthetic */ zzfhf mo4041i() {
        zza com_google_android_gms_internal_zzffu_zza = (zza) mo4293a(zzg.f7410h, null, null);
        com_google_android_gms_internal_zzffu_zza.m20427a(this);
        return com_google_android_gms_internal_zzffu_zza;
    }

    public final /* synthetic */ zzfhe mo4038j() {
        return (zzffu) mo4293a(zzg.f7411i, null, null);
    }

    public String toString() {
        return zzfhh.m6043a(this, super.toString());
    }

    static <T extends zzffu<T, ?>> T m20436a(T t, zzffb com_google_android_gms_internal_zzffb, zzffm com_google_android_gms_internal_zzffm) throws zzfge {
        zzffu com_google_android_gms_internal_zzffu = (zzffu) t.mo4293a(zzg.f7409g, null, null);
        try {
            com_google_android_gms_internal_zzffu.mo4293a(zzg.f7407e, (Object) com_google_android_gms_internal_zzffb, (Object) com_google_android_gms_internal_zzffm);
            com_google_android_gms_internal_zzffu.mo4293a(zzg.f7408f, null, null);
            com_google_android_gms_internal_zzffu.f19235g.f7470e = null;
            return com_google_android_gms_internal_zzffu;
        } catch (T t2) {
            if ((t2.getCause() instanceof zzfge) != null) {
                throw ((zzfge) t2.getCause());
            }
            throw t2;
        }
    }

    protected static <T extends zzffu<T, ?>> T m20434a(T t, zzfes com_google_android_gms_internal_zzfes) throws zzfge {
        boolean booleanValue;
        byte byteValue;
        t = m20435a((zzffu) t, com_google_android_gms_internal_zzfes, zzffm.m5984a());
        com_google_android_gms_internal_zzfes = null;
        if (t != null) {
            zzfes com_google_android_gms_internal_zzfes2;
            booleanValue = Boolean.TRUE.booleanValue();
            byteValue = ((Byte) t.mo4293a(zzg.f7405c, null, null)).byteValue();
            if (byteValue == (byte) 1) {
                com_google_android_gms_internal_zzfes2 = 1;
            } else if (byteValue == (byte) 0) {
                com_google_android_gms_internal_zzfes2 = null;
            } else {
                com_google_android_gms_internal_zzfes2 = t.mo4293a(zzg.f7403a, Boolean.FALSE, null) != null ? 1 : null;
                if (booleanValue) {
                    t.mo4293a(zzg.f7406d, com_google_android_gms_internal_zzfes2 != null ? t : null, null);
                }
            }
            if (com_google_android_gms_internal_zzfes2 == null) {
                com_google_android_gms_internal_zzfes = new zzfim().m6081a();
                com_google_android_gms_internal_zzfes.f7422a = t;
                throw com_google_android_gms_internal_zzfes;
            }
        }
        if (t != null) {
            booleanValue = Boolean.TRUE.booleanValue();
            byteValue = ((Byte) t.mo4293a(zzg.f7405c, null, null)).byteValue();
            if (byteValue == (byte) 1) {
                com_google_android_gms_internal_zzfes = 1;
            } else if (byteValue != (byte) 0) {
                if (t.mo4293a(zzg.f7403a, Boolean.FALSE, null) != null) {
                    com_google_android_gms_internal_zzfes = 1;
                }
                if (booleanValue) {
                    t.mo4293a(zzg.f7406d, com_google_android_gms_internal_zzfes != null ? t : null, null);
                }
            }
            if (com_google_android_gms_internal_zzfes == null) {
                com_google_android_gms_internal_zzfes = new zzfim().m6081a();
                com_google_android_gms_internal_zzfes.f7422a = t;
                throw com_google_android_gms_internal_zzfes;
            }
        }
        return t;
    }

    private static <T extends zzffu<T, ?>> T m20435a(T t, zzfes com_google_android_gms_internal_zzfes, zzffm com_google_android_gms_internal_zzffm) throws zzfge {
        try {
            zzffb d = com_google_android_gms_internal_zzfes.mo3509d();
            t = m20436a((zzffu) t, d, com_google_android_gms_internal_zzffm);
            d.mo1880a((int) null);
            return t;
        } catch (zzfes com_google_android_gms_internal_zzfes2) {
            com_google_android_gms_internal_zzfes2.f7422a = t;
            throw com_google_android_gms_internal_zzfes2;
        } catch (T t2) {
            throw t2;
        }
    }

    private static <T extends zzffu<T, ?>> T m20438a(T t, byte[] bArr, zzffm com_google_android_gms_internal_zzffm) throws zzfge {
        try {
            zzffb a = zzffb.m5963a(bArr);
            t = m20436a((zzffu) t, a, com_google_android_gms_internal_zzffm);
            a.mo1880a((int) null);
            return t;
        } catch (byte[] bArr2) {
            bArr2.f7422a = t;
            throw bArr2;
        } catch (T t2) {
            throw t2;
        }
    }

    protected static <T extends zzffu<T, ?>> T m20437a(T t, byte[] bArr) throws zzfge {
        t = m20438a((zzffu) t, bArr, zzffm.m5984a());
        if (t != null) {
            bArr = Boolean.TRUE.booleanValue();
            byte byteValue = ((Byte) t.mo4293a(zzg.f7405c, null, null)).byteValue();
            Object obj = null;
            if (byteValue == (byte) 1) {
                obj = 1;
            } else if (byteValue != (byte) 0) {
                if (t.mo4293a(zzg.f7403a, Boolean.FALSE, null) != null) {
                    obj = 1;
                }
                if (bArr != null) {
                    t.mo4293a(zzg.f7406d, obj != null ? t : null, null);
                }
            }
            if (obj == null) {
                bArr = new zzfim().m6081a();
                bArr.f7422a = t;
                throw bArr;
            }
        }
        return t;
    }
}
