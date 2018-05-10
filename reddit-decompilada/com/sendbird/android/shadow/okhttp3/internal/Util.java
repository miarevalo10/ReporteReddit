package com.sendbird.android.shadow.okhttp3.internal;

import com.sendbird.android.shadow.okhttp3.HttpUrl;
import com.sendbird.android.shadow.okhttp3.RequestBody;
import com.sendbird.android.shadow.okhttp3.ResponseBody;
import com.sendbird.android.shadow.okio.BufferedSource;
import com.sendbird.android.shadow.okio.ByteString;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public final class Util {
    public static final byte[] f23334a = new byte[0];
    public static final String[] f23335b = new String[0];
    public static final ResponseBody f23336c = ResponseBody.m25335a(f23334a);
    public static final RequestBody f23337d = RequestBody.m25322a(null, f23334a);
    public static final Charset f23338e = Charset.forName("UTF-8");
    public static final Charset f23339f = Charset.forName("ISO-8859-1");
    public static final TimeZone f23340g = TimeZone.getTimeZone("GMT");
    public static final Comparator<String> f23341h = new C20391();
    private static final ByteString f23342i = ByteString.m25598c("efbbbf");
    private static final ByteString f23343j = ByteString.m25598c("feff");
    private static final ByteString f23344k = ByteString.m25598c("fffe");
    private static final ByteString f23345l = ByteString.m25598c("0000ffff");
    private static final ByteString f23346m = ByteString.m25598c("ffff0000");
    private static final Charset f23347n = Charset.forName("UTF-16BE");
    private static final Charset f23348o = Charset.forName("UTF-16LE");
    private static final Charset f23349p = Charset.forName("UTF-32BE");
    private static final Charset f23350q = Charset.forName("UTF-32LE");
    private static final Pattern f23351r = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

    class C20391 implements Comparator<String> {
        C20391() {
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            return ((String) obj).compareTo((String) obj2);
        }
    }

    class C20402 implements ThreadFactory {
        final /* synthetic */ String f23332a;
        final /* synthetic */ boolean f23333b;

        C20402(String str, boolean z) {
            this.f23332a = str;
            this.f23333b = z;
        }

        public final Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, this.f23332a);
            thread.setDaemon(this.f23333b);
            return thread;
        }
    }

    public static int m25351a(char c) {
        return (c < '0' || c > '9') ? (c < 'a' || c > 'f') ? (c < 'A' || c > 'F') ? -1 : (c - 65) + 10 : (c - 97) + 10 : c - 48;
    }

    public static void m25365a(long j, long j2) {
        if ((0 | j2) >= 0 && 0 <= j) {
            if (j - 0 >= j2) {
                return;
            }
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public static boolean m25371a(Object obj, Object obj2) {
        if (obj != obj2) {
            if (obj == null || obj.equals(obj2) == null) {
                return null;
            }
        }
        return true;
    }

    public static void m25366a(java.io.Closeable r0) {
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
        if (r0 == 0) goto L_0x0008;
    L_0x0002:
        r0.close();	 Catch:{ RuntimeException -> 0x0006, Exception -> 0x0008 }
        return;
    L_0x0006:
        r0 = move-exception;
        throw r0;
    L_0x0008:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.okhttp3.internal.Util.a(java.io.Closeable):void");
    }

    public static void m25367a(java.net.Socket r1) {
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
        if (r1 == 0) goto L_0x0011;
    L_0x0002:
        r1.close();	 Catch:{ AssertionError -> 0x0008, RuntimeException -> 0x0006, Exception -> 0x0011 }
        return;
    L_0x0006:
        r1 = move-exception;
        throw r1;
    L_0x0008:
        r1 = move-exception;
        r0 = m25370a(r1);
        if (r0 != 0) goto L_0x0010;
    L_0x000f:
        throw r1;
    L_0x0010:
        return;
    L_0x0011:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.okhttp3.internal.Util.a(java.net.Socket):void");
    }

    public static boolean m25369a(com.sendbird.android.shadow.okio.Source r1, java.util.concurrent.TimeUnit r2) {
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
        r0 = 100;
        r1 = m25368a(r1, r0, r2);	 Catch:{ IOException -> 0x0007 }
        return r1;
    L_0x0007:
        r1 = 0;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.okhttp3.internal.Util.a(com.sendbird.android.shadow.okio.Source, java.util.concurrent.TimeUnit):boolean");
    }

    public static boolean m25368a(com.sendbird.android.shadow.okio.Source r11, int r12, java.util.concurrent.TimeUnit r13) throws java.io.IOException {
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
        r0 = java.lang.System.nanoTime();
        r2 = r11.mo5323a();
        r2 = r2.aw_();
        r3 = 9223372036854775807; // 0x7fffffffffffffff float:NaN double:NaN;
        if (r2 == 0) goto L_0x001d;
    L_0x0013:
        r2 = r11.mo5323a();
        r5 = r2.mo5389c();
        r5 = r5 - r0;
        goto L_0x001e;
    L_0x001d:
        r5 = r3;
    L_0x001e:
        r2 = r11.mo5323a();
        r7 = (long) r12;
        r12 = r13.toNanos(r7);
        r12 = java.lang.Math.min(r5, r12);
        r12 = r12 + r0;
        r2.mo5384a(r12);
        r12 = new com.sendbird.android.shadow.okio.Buffer;	 Catch:{ InterruptedIOException -> 0x0070, all -> 0x005a }
        r12.<init>();	 Catch:{ InterruptedIOException -> 0x0070, all -> 0x005a }
    L_0x0034:
        r7 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;	 Catch:{ InterruptedIOException -> 0x0070, all -> 0x005a }
        r7 = r11.mo5322a(r12, r7);	 Catch:{ InterruptedIOException -> 0x0070, all -> 0x005a }
        r9 = -1;	 Catch:{ InterruptedIOException -> 0x0070, all -> 0x005a }
        r13 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1));	 Catch:{ InterruptedIOException -> 0x0070, all -> 0x005a }
        if (r13 == 0) goto L_0x0044;	 Catch:{ InterruptedIOException -> 0x0070, all -> 0x005a }
    L_0x0040:
        r12.m35504r();	 Catch:{ InterruptedIOException -> 0x0070, all -> 0x005a }
        goto L_0x0034;
    L_0x0044:
        r12 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1));
        if (r12 != 0) goto L_0x0050;
    L_0x0048:
        r11 = r11.mo5323a();
        r11.ax_();
        goto L_0x0058;
    L_0x0050:
        r11 = r11.mo5323a();
        r0 = r0 + r5;
        r11.mo5384a(r0);
    L_0x0058:
        r11 = 1;
        return r11;
    L_0x005a:
        r12 = move-exception;
        r13 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1));
        if (r13 != 0) goto L_0x0067;
    L_0x005f:
        r11 = r11.mo5323a();
        r11.ax_();
        goto L_0x006f;
    L_0x0067:
        r11 = r11.mo5323a();
        r0 = r0 + r5;
        r11.mo5384a(r0);
    L_0x006f:
        throw r12;
    L_0x0070:
        r12 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1));
        if (r12 != 0) goto L_0x007c;
    L_0x0074:
        r11 = r11.mo5323a();
        r11.ax_();
        goto L_0x0084;
    L_0x007c:
        r11 = r11.mo5323a();
        r0 = r0 + r5;
        r11.mo5384a(r0);
    L_0x0084:
        r11 = 0;
        return r11;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.okhttp3.internal.Util.a(com.sendbird.android.shadow.okio.Source, int, java.util.concurrent.TimeUnit):boolean");
    }

    public static <T> List<T> m25362a(List<T> list) {
        return Collections.unmodifiableList(new ArrayList(list));
    }

    public static <T> List<T> m25363a(T... tArr) {
        return Collections.unmodifiableList(Arrays.asList((Object[]) tArr.clone()));
    }

    public static ThreadFactory m25364a(String str, boolean z) {
        return new C20402(str, z);
    }

    public static String[] m25372a(Comparator<? super String> comparator, String[] strArr, String[] strArr2) {
        List arrayList = new ArrayList();
        for (Object obj : strArr) {
            for (Object compare : strArr2) {
                if (comparator.compare(obj, compare) == 0) {
                    arrayList.add(obj);
                    break;
                }
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static boolean m25376b(Comparator<String> comparator, String[] strArr, String[] strArr2) {
        if (!(strArr == null || strArr2 == null || strArr.length == 0)) {
            if (strArr2.length != 0) {
                for (Object obj : strArr) {
                    for (Object compare : strArr2) {
                        if (comparator.compare(obj, compare) == 0) {
                            return true;
                        }
                    }
                }
                return false;
            }
        }
        return false;
    }

    public static boolean m25370a(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || assertionError.getMessage().contains("getsockname failed") == null) ? null : true;
    }

    public static int m25356a(Comparator<String> comparator, String[] strArr, String str) {
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            if (comparator.compare(strArr[i], str) == 0) {
                return i;
            }
        }
        return -1;
    }

    public static String[] m25373a(String[] strArr, String str) {
        Object obj = new String[(strArr.length + 1)];
        System.arraycopy(strArr, 0, obj, 0, strArr.length);
        obj[obj.length - 1] = str;
        return obj;
    }

    public static int m25352a(String str, int i, int i2) {
        while (i < i2) {
            switch (str.charAt(i)) {
                case '\t':
                case '\n':
                case '\f':
                case '\r':
                case ' ':
                    i++;
                default:
                    return i;
            }
        }
        return i2;
    }

    public static int m25375b(String str, int i, int i2) {
        i2--;
        while (i2 >= i) {
            switch (str.charAt(i2)) {
                case '\t':
                case '\n':
                case '\f':
                case '\r':
                case ' ':
                    i2--;
                default:
                    return i2 + 1;
            }
        }
        return i;
    }

    public static String m25377c(String str, int i, int i2) {
        i = m25352a(str, i, i2);
        return str.substring(i, m25375b(str, i, i2));
    }

    public static int m25354a(String str, int i, int i2, String str2) {
        while (i < i2) {
            if (str2.indexOf(str.charAt(i)) != -1) {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static int m25353a(String str, int i, int i2, char c) {
        while (i < i2) {
            if (str.charAt(i) == c) {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static java.lang.String m25359a(java.lang.String r8) {
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
        r0 = ":";
        r0 = r8.contains(r0);
        r1 = 0;
        if (r0 == 0) goto L_0x00a9;
    L_0x0009:
        r0 = "[";
        r0 = r8.startsWith(r0);
        r2 = 0;
        if (r0 == 0) goto L_0x0025;
    L_0x0012:
        r0 = "]";
        r0 = r8.endsWith(r0);
        if (r0 == 0) goto L_0x0025;
    L_0x001a:
        r0 = r8.length();
        r3 = 1;
        r0 = r0 - r3;
        r0 = m25379d(r8, r3, r0);
        goto L_0x002d;
    L_0x0025:
        r0 = r8.length();
        r0 = m25379d(r8, r2, r0);
    L_0x002d:
        if (r0 != 0) goto L_0x0030;
    L_0x002f:
        return r1;
    L_0x0030:
        r0 = r0.getAddress();
        r1 = 16;
        r3 = r0.length;
        if (r3 != r1) goto L_0x0090;
    L_0x0039:
        r8 = -1;
        r4 = r8;
        r8 = r2;
        r3 = r8;
    L_0x003d:
        r5 = r0.length;
        if (r8 >= r5) goto L_0x005c;
    L_0x0040:
        r5 = r8;
    L_0x0041:
        if (r5 >= r1) goto L_0x0050;
    L_0x0043:
        r6 = r0[r5];
        if (r6 != 0) goto L_0x0050;
    L_0x0047:
        r6 = r5 + 1;
        r6 = r0[r6];
        if (r6 != 0) goto L_0x0050;
    L_0x004d:
        r5 = r5 + 2;
        goto L_0x0041;
    L_0x0050:
        r6 = r5 - r8;
        if (r6 <= r3) goto L_0x0059;
    L_0x0054:
        r7 = 4;
        if (r6 < r7) goto L_0x0059;
    L_0x0057:
        r4 = r8;
        r3 = r6;
    L_0x0059:
        r8 = r5 + 2;
        goto L_0x003d;
    L_0x005c:
        r8 = new com.sendbird.android.shadow.okio.Buffer;
        r8.<init>();
    L_0x0061:
        r5 = r0.length;
        if (r2 >= r5) goto L_0x008b;
    L_0x0064:
        r5 = 58;
        if (r2 != r4) goto L_0x0072;
    L_0x0068:
        r8.m35463b(r5);
        r2 = r2 + r3;
        if (r2 != r1) goto L_0x0061;
    L_0x006e:
        r8.m35463b(r5);
        goto L_0x0061;
    L_0x0072:
        if (r2 <= 0) goto L_0x0077;
    L_0x0074:
        r8.m35463b(r5);
    L_0x0077:
        r5 = r0[r2];
        r5 = r5 & 255;
        r5 = r5 << 8;
        r6 = r2 + 1;
        r6 = r0[r6];
        r6 = r6 & 255;
        r5 = r5 | r6;
        r5 = (long) r5;
        r8.m35492j(r5);
        r2 = r2 + 2;
        goto L_0x0061;
    L_0x008b:
        r8 = r8.m35501o();
        return r8;
    L_0x0090:
        r0 = new java.lang.AssertionError;
        r1 = new java.lang.StringBuilder;
        r2 = "Invalid IPv6 address: '";
        r1.<init>(r2);
        r1.append(r8);
        r8 = "'";
        r1.append(r8);
        r8 = r1.toString();
        r0.<init>(r8);
        throw r0;
    L_0x00a9:
        r8 = java.net.IDN.toASCII(r8);	 Catch:{ IllegalArgumentException -> 0x00c2 }
        r0 = java.util.Locale.US;	 Catch:{ IllegalArgumentException -> 0x00c2 }
        r8 = r8.toLowerCase(r0);	 Catch:{ IllegalArgumentException -> 0x00c2 }
        r0 = r8.isEmpty();	 Catch:{ IllegalArgumentException -> 0x00c2 }
        if (r0 == 0) goto L_0x00ba;	 Catch:{ IllegalArgumentException -> 0x00c2 }
    L_0x00b9:
        return r1;	 Catch:{ IllegalArgumentException -> 0x00c2 }
    L_0x00ba:
        r0 = m25380d(r8);	 Catch:{ IllegalArgumentException -> 0x00c2 }
        if (r0 == 0) goto L_0x00c1;
    L_0x00c0:
        return r1;
    L_0x00c1:
        return r8;
    L_0x00c2:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.okhttp3.internal.Util.a(java.lang.String):java.lang.String");
    }

    private static boolean m25380d(String str) {
        int i = 0;
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (charAt > '\u001f') {
                if (charAt < '') {
                    if (" #%/:?@[\\]".indexOf(charAt) != -1) {
                        return true;
                    }
                    i++;
                }
            }
            return true;
        }
        return false;
    }

    public static int m25374b(String str) {
        int length = str.length();
        int i = 0;
        while (i < length) {
            char charAt = str.charAt(i);
            if (charAt > '\u001f') {
                if (charAt < '') {
                    i++;
                }
            }
            return i;
        }
        return -1;
    }

    public static boolean m25378c(String str) {
        return f23351r.matcher(str).matches();
    }

    public static String m25360a(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public static Charset m25361a(BufferedSource bufferedSource, Charset charset) throws IOException {
        if (bufferedSource.mo6555b(f23342i)) {
            bufferedSource.mo6568g((long) f23342i.mo5405h());
            return f23338e;
        } else if (bufferedSource.mo6555b(f23343j)) {
            bufferedSource.mo6568g((long) f23343j.mo5405h());
            return f23347n;
        } else if (bufferedSource.mo6555b(f23344k)) {
            bufferedSource.mo6568g((long) f23344k.mo5405h());
            return f23348o;
        } else if (bufferedSource.mo6555b(f23345l)) {
            bufferedSource.mo6568g((long) f23345l.mo5405h());
            return f23349p;
        } else if (!bufferedSource.mo6555b(f23346m)) {
            return charset;
        } else {
            bufferedSource.mo6568g((long) f23346m.mo5405h());
            return f23350q;
        }
    }

    public static int m25355a(String str, long j, TimeUnit timeUnit) {
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        StringBuilder stringBuilder;
        if (i < 0) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(" < 0");
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (timeUnit == null) {
            throw new NullPointerException("unit == null");
        } else {
            j = timeUnit.toMillis(j);
            if (j > 2147483647L) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append(" too large.");
                throw new IllegalArgumentException(stringBuilder.toString());
            } else if (j != 0 || i <= 0) {
                return (int) j;
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append(" too small.");
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
    }

    public static AssertionError m25357a(String str, Exception exception) {
        return (AssertionError) new AssertionError(str).initCause(exception);
    }

    private static java.net.InetAddress m25379d(java.lang.String r17, int r18, int r19) {
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
        r0 = r17;
        r1 = r19;
        r2 = 16;
        r3 = new byte[r2];
        r4 = -1;
        r5 = 0;
        r6 = r18;
        r8 = r4;
        r9 = r8;
        r7 = r5;
    L_0x000f:
        r10 = 0;
        if (r6 >= r1) goto L_0x00d7;
    L_0x0012:
        if (r7 != r2) goto L_0x0015;
    L_0x0014:
        return r10;
    L_0x0015:
        r11 = r6 + 2;
        r12 = 4;
        r13 = 255; // 0xff float:3.57E-43 double:1.26E-321;
        if (r11 > r1) goto L_0x0034;
    L_0x001c:
        r14 = "::";
        r15 = 2;
        r14 = r0.regionMatches(r6, r14, r5, r15);
        if (r14 == 0) goto L_0x0034;
    L_0x0025:
        if (r8 == r4) goto L_0x0028;
    L_0x0027:
        return r10;
    L_0x0028:
        r7 = r7 + 2;
        if (r11 != r1) goto L_0x0030;
    L_0x002c:
        r0 = r2;
        r8 = r7;
        goto L_0x00d8;
    L_0x0030:
        r8 = r7;
        r9 = r11;
        goto L_0x00a5;
    L_0x0034:
        if (r7 == 0) goto L_0x00a4;
    L_0x0036:
        r11 = ":";
        r14 = 1;
        r11 = r0.regionMatches(r6, r11, r5, r14);
        if (r11 == 0) goto L_0x0043;
    L_0x003f:
        r6 = r6 + 1;
        goto L_0x00a4;
    L_0x0043:
        r11 = ".";
        r6 = r0.regionMatches(r6, r11, r5, r14);
        if (r6 == 0) goto L_0x00a3;
    L_0x004b:
        r6 = r7 + -2;
        r11 = r6;
    L_0x004e:
        if (r9 >= r1) goto L_0x0095;
    L_0x0050:
        if (r11 != r2) goto L_0x0053;
    L_0x0052:
        goto L_0x009b;
    L_0x0053:
        if (r11 == r6) goto L_0x0060;
    L_0x0055:
        r15 = r0.charAt(r9);
        r14 = 46;
        if (r15 == r14) goto L_0x005e;
    L_0x005d:
        goto L_0x009b;
    L_0x005e:
        r9 = r9 + 1;
    L_0x0060:
        r15 = r5;
        r14 = r9;
    L_0x0062:
        if (r14 >= r1) goto L_0x0083;
    L_0x0064:
        r5 = r0.charAt(r14);
        r2 = 48;
        if (r5 < r2) goto L_0x0083;
    L_0x006c:
        r4 = 57;
        if (r5 > r4) goto L_0x0083;
    L_0x0070:
        if (r15 != 0) goto L_0x0075;
    L_0x0072:
        if (r9 == r14) goto L_0x0075;
    L_0x0074:
        goto L_0x0098;
    L_0x0075:
        r15 = r15 * 10;
        r15 = r15 + r5;
        r15 = r15 - r2;
        if (r15 <= r13) goto L_0x007c;
    L_0x007b:
        goto L_0x0098;
    L_0x007c:
        r14 = r14 + 1;
        r2 = 16;
        r4 = -1;
        r5 = 0;
        goto L_0x0062;
    L_0x0083:
        r2 = r14 - r9;
        if (r2 != 0) goto L_0x0088;
    L_0x0087:
        goto L_0x0098;
    L_0x0088:
        r2 = r11 + 1;
        r4 = (byte) r15;
        r3[r11] = r4;
        r11 = r2;
        r9 = r14;
        r2 = 16;
        r4 = -1;
        r5 = 0;
        r14 = 1;
        goto L_0x004e;
    L_0x0095:
        r6 = r6 + r12;
        if (r11 == r6) goto L_0x009a;
    L_0x0098:
        r5 = 0;
        goto L_0x009b;
    L_0x009a:
        r5 = 1;
    L_0x009b:
        if (r5 != 0) goto L_0x009e;
    L_0x009d:
        return r10;
    L_0x009e:
        r7 = r7 + 2;
        r0 = 16;
        goto L_0x00d8;
    L_0x00a3:
        return r10;
    L_0x00a4:
        r9 = r6;
    L_0x00a5:
        r6 = r9;
        r2 = 0;
    L_0x00a7:
        if (r6 >= r1) goto L_0x00ba;
    L_0x00a9:
        r4 = r0.charAt(r6);
        r4 = m25351a(r4);
        r5 = -1;
        if (r4 == r5) goto L_0x00ba;
    L_0x00b4:
        r2 = r2 << 4;
        r2 = r2 + r4;
        r6 = r6 + 1;
        goto L_0x00a7;
    L_0x00ba:
        r4 = r6 - r9;
        if (r4 == 0) goto L_0x00d6;
    L_0x00be:
        if (r4 <= r12) goto L_0x00c1;
    L_0x00c0:
        goto L_0x00d6;
    L_0x00c1:
        r4 = r7 + 1;
        r5 = r2 >>> 8;
        r5 = r5 & r13;
        r5 = (byte) r5;
        r3[r7] = r5;
        r7 = r4 + 1;
        r2 = r2 & 255;
        r2 = (byte) r2;
        r3[r4] = r2;
        r2 = 16;
        r4 = -1;
        r5 = 0;
        goto L_0x000f;
    L_0x00d6:
        return r10;
    L_0x00d7:
        r0 = r2;
    L_0x00d8:
        if (r7 == r0) goto L_0x00ec;
    L_0x00da:
        r1 = -1;
        if (r8 != r1) goto L_0x00de;
    L_0x00dd:
        return r10;
    L_0x00de:
        r1 = r7 - r8;
        r2 = 16 - r1;
        java.lang.System.arraycopy(r3, r8, r3, r2, r1);
        r2 = 16 - r7;
        r2 = r2 + r8;
        r0 = 0;
        java.util.Arrays.fill(r3, r8, r2, r0);
    L_0x00ec:
        r0 = java.net.InetAddress.getByAddress(r3);	 Catch:{ UnknownHostException -> 0x00f1 }
        return r0;
    L_0x00f1:
        r0 = new java.lang.AssertionError;
        r0.<init>();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.okhttp3.internal.Util.d(java.lang.String, int, int):java.net.InetAddress");
    }

    public static String m25358a(HttpUrl httpUrl, boolean z) {
        String stringBuilder;
        if (httpUrl.f23215b.contains(":")) {
            StringBuilder stringBuilder2 = new StringBuilder("[");
            stringBuilder2.append(httpUrl.f23215b);
            stringBuilder2.append("]");
            stringBuilder = stringBuilder2.toString();
        } else {
            stringBuilder = httpUrl.f23215b;
        }
        if (!z) {
            if (httpUrl.f23216c == HttpUrl.m25280a(httpUrl.f23214a)) {
                return stringBuilder;
            }
        }
        z = new StringBuilder();
        z.append(stringBuilder);
        z.append(":");
        z.append(httpUrl.f23216c);
        return z.toString();
    }
}
