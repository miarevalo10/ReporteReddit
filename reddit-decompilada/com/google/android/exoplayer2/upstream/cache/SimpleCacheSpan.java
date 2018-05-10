package com.google.android.exoplayer2.upstream.cache;

import java.io.File;
import java.util.regex.Pattern;

final class SimpleCacheSpan extends CacheSpan {
    private static final Pattern f13707g = Pattern.compile("^(.+)\\.(\\d+)\\.(\\d+)\\.v1\\.exo$", 32);
    private static final Pattern f13708h = Pattern.compile("^(.+)\\.(\\d+)\\.(\\d+)\\.v2\\.exo$", 32);
    private static final Pattern f13709i = Pattern.compile("^(\\d+)\\.(\\d+)\\.(\\d+)\\.v3\\.exo$", 32);

    public static File m12712a(File file, int i, long j, long j2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(i);
        stringBuilder.append(".");
        stringBuilder.append(j);
        stringBuilder.append(".");
        stringBuilder.append(j2);
        stringBuilder.append(".v3.exo");
        return new File(file, stringBuilder.toString());
    }

    public static SimpleCacheSpan m12710a(String str, long j) {
        return new SimpleCacheSpan(str, j, -1, -9223372036854775807L, null);
    }

    public static SimpleCacheSpan m12713b(String str, long j) {
        return new SimpleCacheSpan(str, j, -1, -9223372036854775807L, null);
    }

    public static SimpleCacheSpan m12711a(String str, long j, long j2) {
        return new SimpleCacheSpan(str, j, j2, -9223372036854775807L, null);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.exoplayer2.upstream.cache.SimpleCacheSpan m12709a(java.io.File r16, com.google.android.exoplayer2.upstream.cache.CachedContentIndex r17) {
        /*
        r0 = r17;
        r1 = r16.getName();
        r2 = ".v3.exo";
        r2 = r1.endsWith(r2);
        r3 = 3;
        r4 = 2;
        r5 = 1;
        r6 = 0;
        if (r2 != 0) goto L_0x006e;
    L_0x0012:
        r1 = r16.getName();
        r2 = f13708h;
        r2 = r2.matcher(r1);
        r7 = r2.matches();
        if (r7 == 0) goto L_0x002e;
    L_0x0022:
        r1 = r2.group(r5);
        r1 = com.google.android.exoplayer2.util.Util.m4329j(r1);
        if (r1 != 0) goto L_0x003f;
    L_0x002c:
        r1 = r6;
        goto L_0x0064;
    L_0x002e:
        r2 = f13707g;
        r2 = r2.matcher(r1);
        r1 = r2.matches();
        if (r1 != 0) goto L_0x003b;
    L_0x003a:
        goto L_0x002c;
    L_0x003b:
        r1 = r2.group(r5);
    L_0x003f:
        r7 = r16.getParentFile();
        r8 = r0.m4178c(r1);
        r1 = r2.group(r4);
        r9 = java.lang.Long.parseLong(r1);
        r1 = r2.group(r3);
        r11 = java.lang.Long.parseLong(r1);
        r1 = m12712a(r7, r8, r9, r11);
        r2 = r16;
        r2 = r2.renameTo(r1);
        if (r2 != 0) goto L_0x0064;
    L_0x0063:
        goto L_0x002c;
    L_0x0064:
        if (r1 != 0) goto L_0x0067;
    L_0x0066:
        return r6;
    L_0x0067:
        r2 = r1.getName();
        r15 = r1;
        r1 = r2;
        goto L_0x0071;
    L_0x006e:
        r2 = r16;
        r15 = r2;
    L_0x0071:
        r2 = f13709i;
        r1 = r2.matcher(r1);
        r2 = r1.matches();
        if (r2 != 0) goto L_0x007e;
    L_0x007d:
        return r6;
    L_0x007e:
        r11 = r15.length();
        r2 = r1.group(r5);
        r2 = java.lang.Integer.parseInt(r2);
        r0 = r0.f5203b;
        r0 = r0.get(r2);
        r8 = r0;
        r8 = (java.lang.String) r8;
        if (r8 != 0) goto L_0x0096;
    L_0x0095:
        return r6;
    L_0x0096:
        r0 = new com.google.android.exoplayer2.upstream.cache.SimpleCacheSpan;
        r2 = r1.group(r4);
        r9 = java.lang.Long.parseLong(r2);
        r1 = r1.group(r3);
        r13 = java.lang.Long.parseLong(r1);
        r7 = r0;
        r7.<init>(r8, r9, r11, r13, r15);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.upstream.cache.SimpleCacheSpan.a(java.io.File, com.google.android.exoplayer2.upstream.cache.CachedContentIndex):com.google.android.exoplayer2.upstream.cache.SimpleCacheSpan");
    }

    SimpleCacheSpan(String str, long j, long j2, long j3, File file) {
        super(str, j, j2, j3, file);
    }
}
