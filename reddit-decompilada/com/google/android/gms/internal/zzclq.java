package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.util.zzd;
import com.google.android.gms.measurement.AppMeasurement.Event;
import com.google.android.gms.measurement.AppMeasurement.UserProperty;
import io.fabric.sdk.android.services.events.EventsFilesManager;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.security.auth.x500.X500Principal;
import org.jcodec.codecs.mpeg12.MPEGConst;

public final class zzclq extends zzcjl {
    private static String[] f17908a = new String[]{"firebase_"};
    private SecureRandom f17909b;
    private final AtomicLong f17910c = new AtomicLong(0);
    private int f17911d;

    zzclq(zzcim com_google_android_gms_internal_zzcim) {
        super(com_google_android_gms_internal_zzcim);
    }

    private static Object m18503a(int i, Object obj, boolean z) {
        if (obj == null) {
            return null;
        }
        if ((obj instanceof Long) || (obj instanceof Double)) {
            return obj;
        }
        if (obj instanceof Integer) {
            return Long.valueOf((long) ((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return Long.valueOf((long) ((Byte) obj).byteValue());
        }
        if (obj instanceof Short) {
            return Long.valueOf((long) ((Short) obj).shortValue());
        }
        if (obj instanceof Boolean) {
            return Long.valueOf(((Boolean) obj).booleanValue() ? 1 : 0);
        } else if (obj instanceof Float) {
            return Double.valueOf(((Float) obj).doubleValue());
        } else {
            if (!((obj instanceof String) || (obj instanceof Character))) {
                if (!(obj instanceof CharSequence)) {
                    return null;
                }
            }
            return m18506a(String.valueOf(obj), i, z);
        }
    }

    public static Object m18504a(zzcmb com_google_android_gms_internal_zzcmb, String str) {
        for (zzcmc com_google_android_gms_internal_zzcmc : com_google_android_gms_internal_zzcmb.f17960a) {
            if (com_google_android_gms_internal_zzcmc.f17966a.equals(str)) {
                if (com_google_android_gms_internal_zzcmc.f17967b != null) {
                    return com_google_android_gms_internal_zzcmc.f17967b;
                }
                if (com_google_android_gms_internal_zzcmc.f17968c != null) {
                    return com_google_android_gms_internal_zzcmc.f17968c;
                }
                if (com_google_android_gms_internal_zzcmc.f17969d != null) {
                    return com_google_android_gms_internal_zzcmc.f17969d;
                }
            }
        }
        return null;
    }

    public static Object m18505a(String str, Object obj) {
        boolean z;
        int i = 256;
        if ("_ev".equals(str)) {
            z = true;
        } else {
            if (!m18527h(str)) {
                i = 100;
            }
            z = false;
        }
        return m18503a(i, obj, z);
    }

    public static String m18506a(String str, int i, boolean z) {
        if (str.codePointCount(0, str.length()) > i) {
            if (z) {
                return String.valueOf(str.substring(0, str.offsetByCodePoints(0, i))).concat("...");
            }
            str = null;
        }
        return str;
    }

    public static String m18507a(String str, String[] strArr, String[] strArr2) {
        zzbq.m4808a((Object) strArr);
        zzbq.m4808a((Object) strArr2);
        int min = Math.min(strArr.length, strArr2.length);
        for (int i = 0; i < min; i++) {
            if (m18521b(str, strArr[i])) {
                return strArr2[i];
            }
        }
        return null;
    }

    private static void m18508a(Bundle bundle, Object obj) {
        zzbq.m4808a((Object) bundle);
        if (obj == null) {
            return;
        }
        if ((obj instanceof String) || (obj instanceof CharSequence)) {
            bundle.putLong("_el", (long) String.valueOf(obj).length());
        }
    }

    public static boolean m18509a(android.content.Context r3, java.lang.String r4) {
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
        r0 = 0;
        r1 = r3.getPackageManager();	 Catch:{ NameNotFoundException -> 0x001a }
        if (r1 != 0) goto L_0x0008;	 Catch:{ NameNotFoundException -> 0x001a }
    L_0x0007:
        return r0;	 Catch:{ NameNotFoundException -> 0x001a }
    L_0x0008:
        r2 = new android.content.ComponentName;	 Catch:{ NameNotFoundException -> 0x001a }
        r2.<init>(r3, r4);	 Catch:{ NameNotFoundException -> 0x001a }
        r3 = 4;	 Catch:{ NameNotFoundException -> 0x001a }
        r3 = r1.getServiceInfo(r2, r3);	 Catch:{ NameNotFoundException -> 0x001a }
        if (r3 == 0) goto L_0x001a;	 Catch:{ NameNotFoundException -> 0x001a }
    L_0x0014:
        r3 = r3.enabled;	 Catch:{ NameNotFoundException -> 0x001a }
        if (r3 == 0) goto L_0x001a;
    L_0x0018:
        r3 = 1;
        return r3;
    L_0x001a:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzclq.a(android.content.Context, java.lang.String):boolean");
    }

    public static boolean m18510a(Intent intent) {
        String stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
        if (!("android-app://com.google.android.googlequicksearchbox/https/www.google.com".equals(stringExtra) || "https://www.google.com".equals(stringExtra))) {
            if (!"android-app://com.google.appcrawler".equals(stringExtra)) {
                return false;
            }
        }
        return true;
    }

    private static boolean m18511a(Bundle bundle, int i) {
        if (bundle.getLong("_err") != 0) {
            return false;
        }
        bundle.putLong("_err", (long) i);
        return true;
    }

    static boolean m18512a(zzcha com_google_android_gms_internal_zzcha, zzcgi com_google_android_gms_internal_zzcgi) {
        zzbq.m4808a((Object) com_google_android_gms_internal_zzcha);
        zzbq.m4808a((Object) com_google_android_gms_internal_zzcgi);
        return !TextUtils.isEmpty(com_google_android_gms_internal_zzcgi.f17760b);
    }

    static boolean m18513a(String str) {
        zzbq.m4810a(str);
        if (str.charAt(0) == '_') {
            if (!str.equals("_ep")) {
                return false;
            }
        }
        return true;
    }

    public static boolean m18515a(long[] jArr, int i) {
        if (i >= (jArr.length << 6)) {
            return false;
        }
        return ((1 << (i % 64)) & jArr[i / 64]) != 0;
    }

    static byte[] m18516a(Parcelable parcelable) {
        if (parcelable == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        try {
            parcelable.writeToParcel(obtain, 0);
            byte[] marshall = obtain.marshall();
            return marshall;
        } finally {
            obtain.recycle();
        }
    }

    public static long[] m18517a(BitSet bitSet) {
        int length = (bitSet.length() + 63) / 64;
        long[] jArr = new long[length];
        for (int i = 0; i < length; i++) {
            jArr[i] = 0;
            for (int i2 = 0; i2 < 64; i2++) {
                int i3 = (i << 6) + i2;
                if (i3 >= bitSet.length()) {
                    break;
                }
                if (bitSet.get(i3)) {
                    jArr[i] = jArr[i] | (1 << i2);
                }
            }
        }
        return jArr;
    }

    public static Bundle[] m18518a(Object obj) {
        if (obj instanceof Bundle) {
            return new Bundle[]{(Bundle) obj};
        }
        Object[] copyOf;
        if (obj instanceof Parcelable[]) {
            Parcelable[] parcelableArr = (Parcelable[]) obj;
            copyOf = Arrays.copyOf(parcelableArr, parcelableArr.length, Bundle[].class);
        } else if (!(obj instanceof ArrayList)) {
            return null;
        } else {
            ArrayList arrayList = (ArrayList) obj;
            copyOf = arrayList.toArray(new Bundle[arrayList.size()]);
        }
        return (Bundle[]) copyOf;
    }

    static zzcmc[] m18519a(zzcmc[] com_google_android_gms_internal_zzcmcArr, String str, Object obj) {
        for (zzcmc com_google_android_gms_internal_zzcmc : com_google_android_gms_internal_zzcmcArr) {
            if (Objects.equals(com_google_android_gms_internal_zzcmc.f17966a, str)) {
                com_google_android_gms_internal_zzcmc.f17968c = null;
                com_google_android_gms_internal_zzcmc.f17967b = null;
                com_google_android_gms_internal_zzcmc.f17969d = null;
                if (obj instanceof Long) {
                    com_google_android_gms_internal_zzcmc.f17968c = (Long) obj;
                    return com_google_android_gms_internal_zzcmcArr;
                } else if (obj instanceof String) {
                    com_google_android_gms_internal_zzcmc.f17967b = (String) obj;
                    return com_google_android_gms_internal_zzcmcArr;
                } else {
                    if (obj instanceof Double) {
                        com_google_android_gms_internal_zzcmc.f17969d = (Double) obj;
                    }
                    return com_google_android_gms_internal_zzcmcArr;
                }
            }
        }
        Object obj2 = new zzcmc[(com_google_android_gms_internal_zzcmcArr.length + 1)];
        System.arraycopy(com_google_android_gms_internal_zzcmcArr, 0, obj2, 0, com_google_android_gms_internal_zzcmcArr.length);
        zzcmc com_google_android_gms_internal_zzcmc2 = new zzcmc();
        com_google_android_gms_internal_zzcmc2.f17966a = str;
        if (obj instanceof Long) {
            com_google_android_gms_internal_zzcmc2.f17968c = (Long) obj;
        } else if (obj instanceof String) {
            com_google_android_gms_internal_zzcmc2.f17967b = (String) obj;
        } else if (obj instanceof Double) {
            com_google_android_gms_internal_zzcmc2.f17969d = (Double) obj;
        }
        obj2[com_google_android_gms_internal_zzcmcArr.length] = com_google_android_gms_internal_zzcmc2;
        return obj2;
    }

    public static java.lang.Object m18520b(java.lang.Object r4) {
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
        r0 = 0;
        if (r4 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = new java.io.ByteArrayOutputStream;	 Catch:{ all -> 0x0032 }
        r1.<init>();	 Catch:{ all -> 0x0032 }
        r2 = new java.io.ObjectOutputStream;	 Catch:{ all -> 0x0032 }
        r2.<init>(r1);	 Catch:{ all -> 0x0032 }
        r2.writeObject(r4);	 Catch:{ all -> 0x002f }
        r2.flush();	 Catch:{ all -> 0x002f }
        r4 = new java.io.ObjectInputStream;	 Catch:{ all -> 0x002f }
        r3 = new java.io.ByteArrayInputStream;	 Catch:{ all -> 0x002f }
        r1 = r1.toByteArray();	 Catch:{ all -> 0x002f }
        r3.<init>(r1);	 Catch:{ all -> 0x002f }
        r4.<init>(r3);	 Catch:{ all -> 0x002f }
        r1 = r4.readObject();	 Catch:{ all -> 0x002d }
        r2.close();	 Catch:{ IOException -> 0x0040, IOException -> 0x0040 }
        r4.close();	 Catch:{ IOException -> 0x0040, IOException -> 0x0040 }
        return r1;	 Catch:{ IOException -> 0x0040, IOException -> 0x0040 }
    L_0x002d:
        r1 = move-exception;	 Catch:{ IOException -> 0x0040, IOException -> 0x0040 }
        goto L_0x0035;	 Catch:{ IOException -> 0x0040, IOException -> 0x0040 }
    L_0x002f:
        r1 = move-exception;	 Catch:{ IOException -> 0x0040, IOException -> 0x0040 }
        r4 = r0;	 Catch:{ IOException -> 0x0040, IOException -> 0x0040 }
        goto L_0x0035;	 Catch:{ IOException -> 0x0040, IOException -> 0x0040 }
    L_0x0032:
        r1 = move-exception;	 Catch:{ IOException -> 0x0040, IOException -> 0x0040 }
        r4 = r0;	 Catch:{ IOException -> 0x0040, IOException -> 0x0040 }
        r2 = r4;	 Catch:{ IOException -> 0x0040, IOException -> 0x0040 }
    L_0x0035:
        if (r2 == 0) goto L_0x003a;	 Catch:{ IOException -> 0x0040, IOException -> 0x0040 }
    L_0x0037:
        r2.close();	 Catch:{ IOException -> 0x0040, IOException -> 0x0040 }
    L_0x003a:
        if (r4 == 0) goto L_0x003f;	 Catch:{ IOException -> 0x0040, IOException -> 0x0040 }
    L_0x003c:
        r4.close();	 Catch:{ IOException -> 0x0040, IOException -> 0x0040 }
    L_0x003f:
        throw r1;	 Catch:{ IOException -> 0x0040, IOException -> 0x0040 }
    L_0x0040:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzclq.b(java.lang.Object):java.lang.Object");
    }

    public static boolean m18521b(String str, String str2) {
        return (str == null && str2 == null) ? true : str == null ? false : str.equals(str2);
    }

    static long m18522c(byte[] bArr) {
        zzbq.m4808a((Object) bArr);
        long j = null;
        zzbq.m4813a(bArr.length > 0);
        long j2 = 0;
        int length = bArr.length - 1;
        while (length >= 0 && length >= bArr.length - 8) {
            j2 += (((long) bArr[length]) & 255) << j;
            j += 8;
            length--;
        }
        return j2;
    }

    public static Object m18523c(String str, Object obj) {
        int p;
        boolean z;
        if ("_ldl".equals(str)) {
            p = m18532p(str);
            z = true;
        } else {
            p = m18532p(str);
            z = false;
        }
        return m18503a(p, obj, z);
    }

    static java.security.MessageDigest m18526f(java.lang.String r2) {
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
        r0 = 0;
    L_0x0001:
        r1 = 2;
        if (r0 >= r1) goto L_0x000e;
    L_0x0004:
        r1 = java.security.MessageDigest.getInstance(r2);	 Catch:{ NoSuchAlgorithmException -> 0x000b }
        if (r1 == 0) goto L_0x000b;
    L_0x000a:
        return r1;
    L_0x000b:
        r0 = r0 + 1;
        goto L_0x0001;
    L_0x000e:
        r2 = 0;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzclq.f(java.lang.String):java.security.MessageDigest");
    }

    public static boolean m18527h(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith(EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR);
    }

    static boolean m18528j(String str) {
        return str != null && str.matches("(\\+|-)?([0-9]+\\.?[0-9]*|[0-9]*\\.?[0-9]+)") && str.length() <= 310;
    }

    static boolean m18529m(String str) {
        boolean z;
        zzbq.m4810a(str);
        int hashCode = str.hashCode();
        if (hashCode != 94660) {
            if (hashCode != 95025) {
                if (hashCode == 95027) {
                    if (str.equals("_ui")) {
                        z = true;
                        switch (z) {
                            case false:
                            case true:
                            case true:
                                return true;
                            default:
                                return false;
                        }
                    }
                }
            } else if (str.equals("_ug")) {
                z = true;
                switch (z) {
                    case false:
                    case true:
                    case true:
                        return true;
                    default:
                        return false;
                }
            }
        } else if (str.equals("_in")) {
            z = false;
            switch (z) {
                case false:
                case true:
                case true:
                    return true;
                default:
                    return false;
            }
        }
        z = true;
        switch (z) {
            case false:
            case true:
            case true:
                return true;
            default:
                return false;
        }
    }

    private final int m18530n(String str) {
        return !m18545a("event param", str) ? 3 : !m18546a("event param", null, str) ? 14 : !m18544a("event param", 40, str) ? 3 : 0;
    }

    private final int m18531o(String str) {
        return !m18525c("event param", str) ? 3 : !m18546a("event param", null, str) ? 14 : !m18544a("event param", 40, str) ? 3 : 0;
    }

    private static int m18532p(String str) {
        return "_ldl".equals(str) ? MPEGConst.CODE_END : 36;
    }

    public final /* bridge */ /* synthetic */ void mo1809a() {
        super.mo1809a();
    }

    public final void m18539a(int i, String str, String str2, int i2) {
        m18553b(i, str, str2, i2);
    }

    public final boolean m18543a(long j, long j2) {
        return j == 0 || j2 <= 0 || Math.abs(mo1819k().mo1632a() - j) > j2;
    }

    public final int m18549b(String str) {
        return !m18545a("event", str) ? 2 : !m18546a("event", Event.f14802a, str) ? 13 : !m18544a("event", 40, str) ? 2 : 0;
    }

    public final int m18550b(String str, Object obj) {
        return "_ldl".equals(str) ? m18514a("user property referrer", str, m18532p(str), obj, false) : m18514a("user property", str, m18532p(str), obj, false) ? 0 : 7;
    }

    public final /* bridge */ /* synthetic */ void mo1810b() {
        super.mo1810b();
    }

    public final void m18553b(int i, String str, String str2, int i2) {
        Bundle bundle = new Bundle();
        m18511a(bundle, i);
        if (!TextUtils.isEmpty(str)) {
            bundle.putString(str, str2);
        }
        if (i == 6 || i == 7 || i == 2) {
            bundle.putLong("_el", (long) i2);
        }
        this.s.m5757h().m18332a("auto", "_err", bundle);
    }

    public final int m18555c(String str) {
        return !m18525c("event", str) ? 2 : !m18546a("event", Event.f14802a, str) ? 13 : !m18544a("event", 40, str) ? 2 : 0;
    }

    public final /* bridge */ /* synthetic */ void mo1811c() {
        super.mo1811c();
    }

    public final int m18557d(String str) {
        return !m18525c("user property", str) ? 6 : !m18546a("user property", UserProperty.f14806a, str) ? 15 : !m18544a("user property", 24, str) ? 6 : 0;
    }

    public final /* bridge */ /* synthetic */ zzcgd mo1812d() {
        return super.mo1812d();
    }

    public final /* bridge */ /* synthetic */ zzcgk mo1813e() {
        return super.mo1813e();
    }

    public final /* bridge */ /* synthetic */ zzcjn mo1814f() {
        return super.mo1814f();
    }

    public final /* bridge */ /* synthetic */ zzchh mo1815g() {
        return super.mo1815g();
    }

    public final /* bridge */ /* synthetic */ zzcgu mo1816h() {
        return super.mo1816h();
    }

    public final /* bridge */ /* synthetic */ zzckg mo1817i() {
        return super.mo1817i();
    }

    public final boolean m18566i(String str) {
        return TextUtils.isEmpty(str) ? false : mo1830v().m13487A().equals(str);
    }

    public final /* bridge */ /* synthetic */ zzckc mo1818j() {
        return super.mo1818j();
    }

    public final /* bridge */ /* synthetic */ zzd mo1819k() {
        return super.mo1819k();
    }

    final boolean m18569k(String str) {
        return "1".equals(mo1825q().m18230a(str, "measurement.upload.blacklist_internal"));
    }

    public final /* bridge */ /* synthetic */ Context mo1820l() {
        return super.mo1820l();
    }

    final boolean m18571l(String str) {
        return "1".equals(mo1825q().m18230a(str, "measurement.upload.blacklist_public"));
    }

    public final /* bridge */ /* synthetic */ zzchi mo1821m() {
        return super.mo1821m();
    }

    public final /* bridge */ /* synthetic */ zzcgo mo1822n() {
        return super.mo1822n();
    }

    public final /* bridge */ /* synthetic */ zzchk mo1823o() {
        return super.mo1823o();
    }

    public final /* bridge */ /* synthetic */ zzclq mo1824p() {
        return super.mo1824p();
    }

    public final /* bridge */ /* synthetic */ zzcig mo1825q() {
        return super.mo1825q();
    }

    public final /* bridge */ /* synthetic */ zzclf mo1826r() {
        return super.mo1826r();
    }

    public final /* bridge */ /* synthetic */ zzcih mo1827s() {
        return super.mo1827s();
    }

    public final /* bridge */ /* synthetic */ zzchm mo1828t() {
        return super.mo1828t();
    }

    public final /* bridge */ /* synthetic */ zzchx mo1829u() {
        return super.mo1829u();
    }

    public final /* bridge */ /* synthetic */ zzcgn mo1830v() {
        return super.mo1830v();
    }

    protected final boolean mo3490w() {
        return true;
    }

    public final long m18583y() {
        long nextLong;
        if (this.f17910c.get() == 0) {
            synchronized (this.f17910c) {
                nextLong = new Random(System.nanoTime() ^ mo1819k().mo1632a()).nextLong();
                int i = this.f17911d + 1;
                this.f17911d = i;
                nextLong += (long) i;
            }
            return nextLong;
        }
        synchronized (this.f17910c) {
            this.f17910c.compareAndSet(-1, 1);
            nextLong = this.f17910c.getAndIncrement();
        }
        return nextLong;
    }

    final SecureRandom m18584z() {
        mo1811c();
        if (this.f17909b == null) {
            this.f17909b = new SecureRandom();
        }
        return this.f17909b;
    }

    protected final void l_() {
        mo1811c();
        SecureRandom secureRandom = new SecureRandom();
        long nextLong = secureRandom.nextLong();
        if (nextLong == 0) {
            nextLong = secureRandom.nextLong();
            if (nextLong == 0) {
                mo1828t().f17818c.m5693a("Utils falling back to Random for random id");
            }
        }
        this.f17910c.set(nextLong);
    }

    public final Bundle m18533a(Uri uri) {
        if (uri == null) {
            return null;
        }
        try {
            Object queryParameter;
            Object queryParameter2;
            Object queryParameter3;
            Object queryParameter4;
            if (uri.isHierarchical()) {
                queryParameter = uri.getQueryParameter("utm_campaign");
                queryParameter2 = uri.getQueryParameter("utm_source");
                queryParameter3 = uri.getQueryParameter("utm_medium");
                queryParameter4 = uri.getQueryParameter("gclid");
            } else {
                queryParameter = null;
                queryParameter2 = queryParameter;
                queryParameter3 = queryParameter2;
                queryParameter4 = queryParameter3;
            }
            if (TextUtils.isEmpty(queryParameter) && TextUtils.isEmpty(queryParameter2) && TextUtils.isEmpty(queryParameter3)) {
                if (TextUtils.isEmpty(queryParameter4)) {
                    return null;
                }
            }
            Bundle bundle = new Bundle();
            if (!TextUtils.isEmpty(queryParameter)) {
                bundle.putString("campaign", queryParameter);
            }
            if (!TextUtils.isEmpty(queryParameter2)) {
                bundle.putString("source", queryParameter2);
            }
            if (!TextUtils.isEmpty(queryParameter3)) {
                bundle.putString("medium", queryParameter3);
            }
            if (!TextUtils.isEmpty(queryParameter4)) {
                bundle.putString("gclid", queryParameter4);
            }
            queryParameter = uri.getQueryParameter("utm_term");
            if (!TextUtils.isEmpty(queryParameter)) {
                bundle.putString("term", queryParameter);
            }
            queryParameter = uri.getQueryParameter("utm_content");
            if (!TextUtils.isEmpty(queryParameter)) {
                bundle.putString("content", queryParameter);
            }
            queryParameter = uri.getQueryParameter("aclid");
            if (!TextUtils.isEmpty(queryParameter)) {
                bundle.putString("aclid", queryParameter);
            }
            queryParameter = uri.getQueryParameter("cp1");
            if (!TextUtils.isEmpty(queryParameter)) {
                bundle.putString("cp1", queryParameter);
            }
            uri = uri.getQueryParameter("anid");
            if (!TextUtils.isEmpty(uri)) {
                bundle.putString("anid", uri);
            }
            return bundle;
        } catch (Uri uri2) {
            mo1828t().f17818c.m5694a("Install referrer url isn't a hierarchical URI", uri2);
            return null;
        }
    }

    public final boolean m18545a(String str, String str2) {
        if (str2 == null) {
            mo1828t().f17816a.m5694a("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() == 0) {
            mo1828t().f17816a.m5694a("Name is required and can't be empty. Type", str);
            return false;
        } else {
            int codePointAt = str2.codePointAt(0);
            if (Character.isLetter(codePointAt)) {
                int length = str2.length();
                codePointAt = Character.charCount(codePointAt);
                while (codePointAt < length) {
                    int codePointAt2 = str2.codePointAt(codePointAt);
                    if (codePointAt2 == 95 || Character.isLetterOrDigit(codePointAt2)) {
                        codePointAt += Character.charCount(codePointAt2);
                    } else {
                        mo1828t().f17816a.m5695a("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                        return false;
                    }
                }
                return true;
            }
            mo1828t().f17816a.m5695a("Name must start with a letter. Type, name", str, str2);
            return false;
        }
    }

    private final boolean m18525c(String str, String str2) {
        if (str2 == null) {
            mo1828t().f17816a.m5694a("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() == 0) {
            mo1828t().f17816a.m5694a("Name is required and can't be empty. Type", str);
            return false;
        } else {
            int codePointAt = str2.codePointAt(0);
            if (Character.isLetter(codePointAt) || codePointAt == 95) {
                int length = str2.length();
                codePointAt = Character.charCount(codePointAt);
                while (codePointAt < length) {
                    int codePointAt2 = str2.codePointAt(codePointAt);
                    if (codePointAt2 == 95 || Character.isLetterOrDigit(codePointAt2)) {
                        codePointAt += Character.charCount(codePointAt2);
                    } else {
                        mo1828t().f17816a.m5695a("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                        return false;
                    }
                }
                return true;
            }
            mo1828t().f17816a.m5695a("Name must start with a letter or _ (underscore). Type, name", str, str2);
            return false;
        }
    }

    public final boolean m18546a(String str, String[] strArr, String str2) {
        if (str2 == null) {
            mo1828t().f17816a.m5694a("Name is required and can't be null. Type", str);
            return false;
        }
        boolean z;
        zzbq.m4808a((Object) str2);
        for (String startsWith : f17908a) {
            if (str2.startsWith(startsWith)) {
                z = true;
                break;
            }
        }
        z = false;
        if (z) {
            mo1828t().f17816a.m5695a("Name starts with reserved prefix. Type, name", str, str2);
            return false;
        }
        if (strArr != null) {
            zzbq.m4808a((Object) strArr);
            for (String startsWith2 : strArr) {
                if (m18521b(str2, startsWith2)) {
                    strArr = 1;
                    break;
                }
            }
            strArr = null;
            if (strArr != null) {
                mo1828t().f17816a.m5695a("Name is reserved. Type, name", str, str2);
                return false;
            }
        }
        return true;
    }

    public final boolean m18544a(String str, int i, String str2) {
        if (str2 == null) {
            mo1828t().f17816a.m5694a("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.codePointCount(0, str2.length()) <= i) {
            return true;
        } else {
            mo1828t().f17816a.m5696a("Name is too long. Type, maximum supported length, name", str, Integer.valueOf(i), str2);
            return false;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean m18514a(java.lang.String r4, java.lang.String r5, int r6, java.lang.Object r7, boolean r8) {
        /*
        r3 = this;
        r0 = 1;
        if (r7 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = r7 instanceof java.lang.Long;
        if (r1 != 0) goto L_0x00aa;
    L_0x0008:
        r1 = r7 instanceof java.lang.Float;
        if (r1 != 0) goto L_0x00aa;
    L_0x000c:
        r1 = r7 instanceof java.lang.Integer;
        if (r1 != 0) goto L_0x00aa;
    L_0x0010:
        r1 = r7 instanceof java.lang.Byte;
        if (r1 != 0) goto L_0x00aa;
    L_0x0014:
        r1 = r7 instanceof java.lang.Short;
        if (r1 != 0) goto L_0x00aa;
    L_0x0018:
        r1 = r7 instanceof java.lang.Boolean;
        if (r1 != 0) goto L_0x00aa;
    L_0x001c:
        r1 = r7 instanceof java.lang.Double;
        if (r1 == 0) goto L_0x0021;
    L_0x0020:
        return r0;
    L_0x0021:
        r1 = r7 instanceof java.lang.String;
        r2 = 0;
        if (r1 != 0) goto L_0x0087;
    L_0x0026:
        r1 = r7 instanceof java.lang.Character;
        if (r1 != 0) goto L_0x0087;
    L_0x002a:
        r1 = r7 instanceof java.lang.CharSequence;
        if (r1 == 0) goto L_0x002f;
    L_0x002e:
        goto L_0x0087;
    L_0x002f:
        r4 = r7 instanceof android.os.Bundle;
        if (r4 == 0) goto L_0x0036;
    L_0x0033:
        if (r8 == 0) goto L_0x0036;
    L_0x0035:
        return r0;
    L_0x0036:
        r4 = r7 instanceof android.os.Parcelable[];
        if (r4 == 0) goto L_0x005c;
    L_0x003a:
        if (r8 == 0) goto L_0x005c;
    L_0x003c:
        r7 = (android.os.Parcelable[]) r7;
        r4 = r7.length;
        r6 = r2;
    L_0x0040:
        if (r6 >= r4) goto L_0x005b;
    L_0x0042:
        r8 = r7[r6];
        r1 = r8 instanceof android.os.Bundle;
        if (r1 != 0) goto L_0x0058;
    L_0x0048:
        r4 = r3.mo1828t();
        r4 = r4.f17818c;
        r6 = "All Parcelable[] elements must be of type Bundle. Value type, name";
        r7 = r8.getClass();
        r4.m5695a(r6, r7, r5);
        return r2;
    L_0x0058:
        r6 = r6 + 1;
        goto L_0x0040;
    L_0x005b:
        return r0;
    L_0x005c:
        r4 = r7 instanceof java.util.ArrayList;
        if (r4 == 0) goto L_0x0086;
    L_0x0060:
        if (r8 == 0) goto L_0x0086;
    L_0x0062:
        r7 = (java.util.ArrayList) r7;
        r4 = r7.size();
        r6 = r2;
    L_0x0069:
        if (r6 >= r4) goto L_0x0085;
    L_0x006b:
        r8 = r7.get(r6);
        r6 = r6 + 1;
        r1 = r8 instanceof android.os.Bundle;
        if (r1 != 0) goto L_0x0069;
    L_0x0075:
        r4 = r3.mo1828t();
        r4 = r4.f17818c;
        r6 = "All ArrayList elements must be of type Bundle. Value type, name";
        r7 = r8.getClass();
        r4.m5695a(r6, r7, r5);
        return r2;
    L_0x0085:
        return r0;
    L_0x0086:
        return r2;
    L_0x0087:
        r7 = java.lang.String.valueOf(r7);
        r8 = r7.length();
        r8 = r7.codePointCount(r2, r8);
        if (r8 <= r6) goto L_0x00a9;
    L_0x0095:
        r6 = r3.mo1828t();
        r6 = r6.f17818c;
        r8 = "Value is too long; discarded. Value kind, name, value length";
        r7 = r7.length();
        r7 = java.lang.Integer.valueOf(r7);
        r6.m5696a(r8, r4, r5, r7);
        return r2;
    L_0x00a9:
        return r0;
    L_0x00aa:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzclq.a(java.lang.String, java.lang.String, int, java.lang.Object, boolean):boolean");
    }

    public final boolean m18560e(String str) {
        if (TextUtils.isEmpty(str)) {
            mo1828t().f17816a.m5693a("Missing google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI");
            return false;
        }
        zzbq.m4808a((Object) str);
        if (str.matches("^1:\\d+:android:[a-f0-9]+$")) {
            return true;
        }
        mo1828t().f17816a.m5694a("Invalid google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI. provided id", str);
        return false;
    }

    private final int m18502a(String str, Object obj, boolean z) {
        if (z) {
            int length;
            String str2 = "param";
            int i = 1;
            if (obj instanceof Parcelable[]) {
                length = ((Parcelable[]) obj).length;
            } else {
                if (obj instanceof ArrayList) {
                    length = ((ArrayList) obj).size();
                }
                if (i == 0) {
                    return 17;
                }
            }
            if (length > 1000) {
                mo1828t().f17818c.m5696a("Parameter array is too long; discarded. Value kind, name, array length", str2, str, Integer.valueOf(length));
                i = 0;
            }
            if (i == 0) {
                return 17;
            }
        }
        return (m18527h(str) ? m18514a("param", str, 256, obj, z) : m18514a("param", str, 100, obj, z)) != null ? 0 : 4;
    }

    public final Bundle m18535a(String str, Bundle bundle, List<String> list, boolean z, boolean z2) {
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = new Bundle(bundle);
        int i = 0;
        for (String str2 : bundle.keySet()) {
            int i2;
            if (list != null) {
                if (list.contains(str2)) {
                    i2 = 0;
                    if (i2 != 0) {
                        i2 = m18502a(str2, bundle.get(str2), z2);
                        if (i2 != 0 || "_ev".equals(str2)) {
                            if (m18513a(str2)) {
                                i++;
                                if (i > 25) {
                                    StringBuilder stringBuilder = new StringBuilder(48);
                                    stringBuilder.append("Event can't contain more then 25 params");
                                    mo1828t().f17816a.m5695a(stringBuilder.toString(), mo1823o().m18128a(str), mo1823o().m18122a(bundle));
                                    m18511a(bundle2, 5);
                                    bundle2.remove(str2);
                                }
                            }
                        } else if (m18511a(bundle2, i2)) {
                            bundle2.putString("_ev", m18506a(str2, 40, true));
                            m18508a(bundle2, bundle.get(str2));
                        }
                    } else if (m18511a(bundle2, i2)) {
                        bundle2.putString("_ev", m18506a(str2, 40, true));
                        if (i2 == 3) {
                            m18508a(bundle2, (Object) str2);
                        }
                    }
                    bundle2.remove(str2);
                }
            }
            i2 = z ? m18530n(str2) : 0;
            if (i2 == 0) {
                i2 = m18531o(str2);
            }
            if (i2 != 0) {
                i2 = m18502a(str2, bundle.get(str2), z2);
                if (i2 != 0) {
                }
                if (m18513a(str2)) {
                    i++;
                    if (i > 25) {
                        StringBuilder stringBuilder2 = new StringBuilder(48);
                        stringBuilder2.append("Event can't contain more then 25 params");
                        mo1828t().f17816a.m5695a(stringBuilder2.toString(), mo1823o().m18128a(str), mo1823o().m18122a(bundle));
                        m18511a(bundle2, 5);
                        bundle2.remove(str2);
                    }
                }
            } else if (m18511a(bundle2, i2)) {
                bundle2.putString("_ev", m18506a(str2, 40, true));
                if (i2 == 3) {
                    m18508a(bundle2, (Object) str2);
                }
            }
            bundle2.remove(str2);
        }
        return bundle2;
    }

    public final void m18542a(zzcmg com_google_android_gms_internal_zzcmg, Object obj) {
        zzbq.m4808a(obj);
        com_google_android_gms_internal_zzcmg.f18013c = null;
        com_google_android_gms_internal_zzcmg.f18014d = null;
        com_google_android_gms_internal_zzcmg.f18015e = null;
        if (obj instanceof String) {
            com_google_android_gms_internal_zzcmg.f18013c = (String) obj;
        } else if (obj instanceof Long) {
            com_google_android_gms_internal_zzcmg.f18014d = (Long) obj;
        } else if (obj instanceof Double) {
            com_google_android_gms_internal_zzcmg.f18015e = (Double) obj;
        } else {
            mo1828t().f17816a.m5694a("Ignoring invalid (type) user attribute value", obj);
        }
    }

    public final void m18541a(zzcmc com_google_android_gms_internal_zzcmc, Object obj) {
        zzbq.m4808a(obj);
        com_google_android_gms_internal_zzcmc.f17967b = null;
        com_google_android_gms_internal_zzcmc.f17968c = null;
        com_google_android_gms_internal_zzcmc.f17969d = null;
        if (obj instanceof String) {
            com_google_android_gms_internal_zzcmc.f17967b = (String) obj;
        } else if (obj instanceof Long) {
            com_google_android_gms_internal_zzcmc.f17968c = (Long) obj;
        } else if (obj instanceof Double) {
            com_google_android_gms_internal_zzcmc.f17969d = (Double) obj;
        } else {
            mo1828t().f17816a.m5694a("Ignoring invalid (type) event param value", obj);
        }
    }

    public final void m18540a(Bundle bundle, String str, Object obj) {
        if (bundle != null) {
            if (obj instanceof Long) {
                bundle.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof String) {
                bundle.putString(str, String.valueOf(obj));
            } else if (obj instanceof Double) {
                bundle.putDouble(str, ((Double) obj).doubleValue());
            } else {
                if (str != null) {
                    mo1828t().f17819d.m5695a("Not putting event parameter. Invalid value type. name, type", mo1823o().m18130b(str), obj != null ? obj.getClass().getSimpleName() : null);
                }
            }
        }
    }

    public final byte[] m18548a(byte[] bArr) throws IOException {
        try {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (byte[] bArr2) {
            mo1828t().f17816a.m5694a("Failed to gzip content", bArr2);
            throw bArr2;
        }
    }

    public final byte[] m18554b(byte[] bArr) throws IOException {
        try {
            InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            bArr = new GZIPInputStream(byteArrayInputStream);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr2 = new byte[1024];
            while (true) {
                int read = bArr.read(bArr2);
                if (read > 0) {
                    byteArrayOutputStream.write(bArr2, 0, read);
                } else {
                    bArr.close();
                    byteArrayInputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (byte[] bArr3) {
            mo1828t().f17816a.m5694a("Failed to ungzip content", bArr3);
            throw bArr3;
        }
    }

    public final byte[] m18547a(zzcmd com_google_android_gms_internal_zzcmd) {
        try {
            byte[] bArr = new byte[com_google_android_gms_internal_zzcmd.m6211e()];
            zzfjk a = zzfjk.m6158a(bArr, bArr.length);
            com_google_android_gms_internal_zzcmd.mo1928a(a);
            a.m6171a();
            return bArr;
        } catch (zzcmd com_google_android_gms_internal_zzcmd2) {
            mo1828t().f17816a.m5694a("Data loss. Failed to serialize batch", com_google_android_gms_internal_zzcmd2);
            return null;
        }
    }

    public final boolean m18563g(String str) {
        mo1811c();
        if (zzbhf.m5574a(mo1820l()).m5568a(str) == 0) {
            return true;
        }
        mo1828t().f17821f.m5694a("Permission not granted", str);
        return null;
    }

    final Bundle m18534a(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                Object a = m18505a(str, bundle.get(str));
                if (a == null) {
                    mo1828t().f17818c.m5694a("Param value can't be null", mo1823o().m18130b(str));
                } else {
                    m18540a(bundle2, str, a);
                }
            }
        }
        return bundle2;
    }

    final zzcha m18537a(String str, Bundle bundle, String str2, long j) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (m18555c(str) != 0) {
            mo1828t().f17816a.m5694a("Invalid conditional property event name", mo1823o().m18132c(str));
            throw new IllegalArgumentException();
        }
        Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
        bundle2.putString("_o", str2);
        return new zzcha(str, new zzcgx(m18534a(m18535a(str, bundle2, Collections.singletonList("_o"), false, false))), str2, j);
    }

    final long m18551b(Context context, String str) {
        mo1811c();
        zzbq.m4808a((Object) context);
        zzbq.m4810a(str);
        PackageManager packageManager = context.getPackageManager();
        MessageDigest f = m18526f("MD5");
        if (f == null) {
            mo1828t().f17816a.m5693a("Could not get MD5 instance");
            return -1;
        }
        if (packageManager != null) {
            try {
                if (m18524c(context, str) == null) {
                    context = zzbhf.m5574a(context).m5572b(mo1820l().getPackageName(), 64);
                    if (context.signatures != null && context.signatures.length > null) {
                        return m18522c(f.digest(context.signatures[null].toByteArray()));
                    }
                    mo1828t().f17818c.m5693a("Could not get signatures");
                    return -1;
                }
            } catch (Context context2) {
                mo1828t().f17816a.m5694a("Package name not found", context2);
            }
        }
        return 0;
    }

    private final boolean m18524c(Context context, String str) {
        X500Principal x500Principal = new X500Principal("CN=Android Debug,O=Android,C=US");
        try {
            context = zzbhf.m5574a(context).m5572b(str, 64);
            if (!(context == null || context.signatures == null || context.signatures.length <= null)) {
                return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(context.signatures[null].toByteArray()))).getSubjectX500Principal().equals(x500Principal);
            }
        } catch (Context context2) {
            mo1828t().f17816a.m5694a("Error obtaining certificate", context2);
        } catch (Context context22) {
            mo1828t().f17816a.m5694a("Package name not found", context22);
        }
        return true;
    }

    final <T extends android.os.Parcelable> T m18536a(byte[] r5, android.os.Parcelable.Creator<T> r6) {
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
        r0 = 0;
        if (r5 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = android.os.Parcel.obtain();
        r2 = r5.length;	 Catch:{ zzbfo -> 0x001c }
        r3 = 0;	 Catch:{ zzbfo -> 0x001c }
        r1.unmarshall(r5, r3, r2);	 Catch:{ zzbfo -> 0x001c }
        r1.setDataPosition(r3);	 Catch:{ zzbfo -> 0x001c }
        r5 = r6.createFromParcel(r1);	 Catch:{ zzbfo -> 0x001c }
        r5 = (android.os.Parcelable) r5;	 Catch:{ zzbfo -> 0x001c }
        r1.recycle();
        return r5;
    L_0x001a:
        r5 = move-exception;
        goto L_0x002b;
    L_0x001c:
        r5 = r4.mo1828t();	 Catch:{ all -> 0x001a }
        r5 = r5.f17816a;	 Catch:{ all -> 0x001a }
        r6 = "Failed to load parcelable from buffer";	 Catch:{ all -> 0x001a }
        r5.m5693a(r6);	 Catch:{ all -> 0x001a }
        r1.recycle();
        return r0;
    L_0x002b:
        r1.recycle();
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzclq.a(byte[], android.os.Parcelable$Creator):T");
    }
}
