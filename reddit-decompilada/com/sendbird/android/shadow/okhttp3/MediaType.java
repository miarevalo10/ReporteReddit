package com.sendbird.android.shadow.okhttp3;

import io.fabric.sdk.android.services.network.HttpRequest;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class MediaType {
    private static final Pattern f23223a = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
    private static final Pattern f23224b = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");
    private final String f23225c;
    private final String f23226d;
    private final String f23227e;
    private final String f23228f;

    private MediaType(String str, String str2, String str3, String str4) {
        this.f23225c = str;
        this.f23226d = str2;
        this.f23227e = str3;
        this.f23228f = str4;
    }

    public static MediaType m25307a(String str) {
        Matcher matcher = f23223a.matcher(str);
        if (!matcher.lookingAt()) {
            return null;
        }
        String toLowerCase = matcher.group(1).toLowerCase(Locale.US);
        String toLowerCase2 = matcher.group(2).toLowerCase(Locale.US);
        Matcher matcher2 = f23224b.matcher(str);
        String str2 = null;
        for (int end = matcher.end(); end < str.length(); end = matcher2.end()) {
            matcher2.region(end, str.length());
            if (!matcher2.lookingAt()) {
                return null;
            }
            String group = matcher2.group(1);
            if (group != null && group.equalsIgnoreCase(HttpRequest.PARAM_CHARSET)) {
                group = matcher2.group(2);
                if (group == null) {
                    group = matcher2.group(3);
                } else if (group.startsWith("'") && group.endsWith("'") && group.length() > 2) {
                    group = group.substring(1, group.length() - 1);
                }
                if (str2 != null && !group.equalsIgnoreCase(str2)) {
                    return null;
                }
                str2 = group;
            }
        }
        return new MediaType(str, toLowerCase, toLowerCase2, str2);
    }

    public final java.nio.charset.Charset m25308a(java.nio.charset.Charset r2) {
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
        r1 = this;
        r0 = r1.f23228f;	 Catch:{ IllegalArgumentException -> 0x000c }
        if (r0 == 0) goto L_0x000b;	 Catch:{ IllegalArgumentException -> 0x000c }
    L_0x0004:
        r0 = r1.f23228f;	 Catch:{ IllegalArgumentException -> 0x000c }
        r0 = java.nio.charset.Charset.forName(r0);	 Catch:{ IllegalArgumentException -> 0x000c }
        return r0;
    L_0x000b:
        return r2;
    L_0x000c:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.okhttp3.MediaType.a(java.nio.charset.Charset):java.nio.charset.Charset");
    }

    public final String toString() {
        return this.f23225c;
    }

    public final boolean equals(Object obj) {
        return (!(obj instanceof MediaType) || ((MediaType) obj).f23225c.equals(this.f23225c) == null) ? null : true;
    }

    public final int hashCode() {
        return this.f23225c.hashCode();
    }
}
