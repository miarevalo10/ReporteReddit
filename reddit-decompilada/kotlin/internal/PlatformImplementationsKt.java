package kotlin.internal;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u001a \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0001\u001a\b\u0010\b\u001a\u00020\u0005H\u0002\"\u0010\u0010\u0000\u001a\u00020\u00018\u0000X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"IMPLEMENTATIONS", "Lkotlin/internal/PlatformImplementations;", "apiVersionIsAtLeast", "", "major", "", "minor", "patch", "getJavaVersion", "kotlin-stdlib"}, k = 2, mv = {1, 1, 9})
/* compiled from: PlatformImplementations.kt */
public final class PlatformImplementationsKt {
    public static final PlatformImplementations f25285a;

    static {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = m26819a();
        r1 = 65544; // 0x10008 float:9.1847E-41 double:3.2383E-319;
        if (r0 < r1) goto L_0x0037;
    L_0x0009:
        r1 = "kotlin.internal.jdk8.JDK8PlatformImplementations";	 Catch:{ ClassNotFoundException -> 0x0020 }
        r1 = java.lang.Class.forName(r1);	 Catch:{ ClassNotFoundException -> 0x0020 }
        r1 = r1.newInstance();	 Catch:{ ClassNotFoundException -> 0x0020 }
        if (r1 != 0) goto L_0x001d;	 Catch:{ ClassNotFoundException -> 0x0020 }
    L_0x0015:
        r1 = new kotlin.TypeCastException;	 Catch:{ ClassNotFoundException -> 0x0020 }
        r2 = "null cannot be cast to non-null type kotlin.internal.PlatformImplementations";	 Catch:{ ClassNotFoundException -> 0x0020 }
        r1.<init>(r2);	 Catch:{ ClassNotFoundException -> 0x0020 }
        throw r1;	 Catch:{ ClassNotFoundException -> 0x0020 }
    L_0x001d:
        r1 = (kotlin.internal.PlatformImplementations) r1;	 Catch:{ ClassNotFoundException -> 0x0020 }
        goto L_0x0071;
    L_0x0020:
        r1 = "kotlin.internal.JRE8PlatformImplementations";	 Catch:{ ClassNotFoundException -> 0x0037 }
        r1 = java.lang.Class.forName(r1);	 Catch:{ ClassNotFoundException -> 0x0037 }
        r1 = r1.newInstance();	 Catch:{ ClassNotFoundException -> 0x0037 }
        if (r1 != 0) goto L_0x0034;	 Catch:{ ClassNotFoundException -> 0x0037 }
    L_0x002c:
        r1 = new kotlin.TypeCastException;	 Catch:{ ClassNotFoundException -> 0x0037 }
        r2 = "null cannot be cast to non-null type kotlin.internal.PlatformImplementations";	 Catch:{ ClassNotFoundException -> 0x0037 }
        r1.<init>(r2);	 Catch:{ ClassNotFoundException -> 0x0037 }
        throw r1;	 Catch:{ ClassNotFoundException -> 0x0037 }
    L_0x0034:
        r1 = (kotlin.internal.PlatformImplementations) r1;	 Catch:{ ClassNotFoundException -> 0x0037 }
        goto L_0x0071;
    L_0x0037:
        r1 = 65543; // 0x10007 float:9.1845E-41 double:3.23825E-319;
        if (r0 < r1) goto L_0x006c;
    L_0x003c:
        r0 = "kotlin.internal.jdk7.JDK7PlatformImplementations";	 Catch:{ ClassNotFoundException -> 0x0054 }
        r0 = java.lang.Class.forName(r0);	 Catch:{ ClassNotFoundException -> 0x0054 }
        r0 = r0.newInstance();	 Catch:{ ClassNotFoundException -> 0x0054 }
        if (r0 != 0) goto L_0x0050;	 Catch:{ ClassNotFoundException -> 0x0054 }
    L_0x0048:
        r0 = new kotlin.TypeCastException;	 Catch:{ ClassNotFoundException -> 0x0054 }
        r1 = "null cannot be cast to non-null type kotlin.internal.PlatformImplementations";	 Catch:{ ClassNotFoundException -> 0x0054 }
        r0.<init>(r1);	 Catch:{ ClassNotFoundException -> 0x0054 }
        throw r0;	 Catch:{ ClassNotFoundException -> 0x0054 }
    L_0x0050:
        r1 = r0;	 Catch:{ ClassNotFoundException -> 0x0054 }
        r1 = (kotlin.internal.PlatformImplementations) r1;	 Catch:{ ClassNotFoundException -> 0x0054 }
        goto L_0x0071;
    L_0x0054:
        r0 = "kotlin.internal.JRE7PlatformImplementations";	 Catch:{ ClassNotFoundException -> 0x006c }
        r0 = java.lang.Class.forName(r0);	 Catch:{ ClassNotFoundException -> 0x006c }
        r0 = r0.newInstance();	 Catch:{ ClassNotFoundException -> 0x006c }
        if (r0 != 0) goto L_0x0068;	 Catch:{ ClassNotFoundException -> 0x006c }
    L_0x0060:
        r0 = new kotlin.TypeCastException;	 Catch:{ ClassNotFoundException -> 0x006c }
        r1 = "null cannot be cast to non-null type kotlin.internal.PlatformImplementations";	 Catch:{ ClassNotFoundException -> 0x006c }
        r0.<init>(r1);	 Catch:{ ClassNotFoundException -> 0x006c }
        throw r0;	 Catch:{ ClassNotFoundException -> 0x006c }
    L_0x0068:
        r1 = r0;	 Catch:{ ClassNotFoundException -> 0x006c }
        r1 = (kotlin.internal.PlatformImplementations) r1;	 Catch:{ ClassNotFoundException -> 0x006c }
        goto L_0x0071;
    L_0x006c:
        r1 = new kotlin.internal.PlatformImplementations;
        r1.<init>();
    L_0x0071:
        f25285a = r1;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.internal.PlatformImplementationsKt.<clinit>():void");
    }

    private static final int m26819a() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "java.specification.version";
        r0 = java.lang.System.getProperty(r0);
        r1 = 65542; // 0x10006 float:9.1844E-41 double:3.2382E-319;
        if (r0 != 0) goto L_0x000c;
    L_0x000b:
        return r1;
    L_0x000c:
        r2 = r0;
        r2 = (java.lang.CharSequence) r2;
        r3 = 6;
        r4 = 0;
        r5 = 46;
        r3 = kotlin.text.StringsKt__StringsKt.m42439a(r2, r5, r4, r3);
        r6 = 65536; // 0x10000 float:9.18355E-41 double:3.2379E-319;
        if (r3 >= 0) goto L_0x0022;
    L_0x001b:
        r0 = java.lang.Integer.parseInt(r0);	 Catch:{ NumberFormatException -> 0x0021 }
        r1 = r0 * r6;
    L_0x0021:
        return r1;
    L_0x0022:
        r7 = r3 + 1;
        r8 = 4;
        r2 = kotlin.text.StringsKt__StringsKt.m42439a(r2, r5, r7, r8);
        if (r2 >= 0) goto L_0x002f;
    L_0x002b:
        r2 = r0.length();
    L_0x002f:
        if (r0 != 0) goto L_0x0039;
    L_0x0031:
        r0 = new kotlin.TypeCastException;
        r1 = "null cannot be cast to non-null type java.lang.String";
        r0.<init>(r1);
        throw r0;
    L_0x0039:
        r3 = r0.substring(r4, r3);
        r4 = "(this as java.lang.Strin…ing(startIndex, endIndex)";
        kotlin.jvm.internal.Intrinsics.m26843a(r3, r4);
        if (r0 != 0) goto L_0x004c;
    L_0x0044:
        r0 = new kotlin.TypeCastException;
        r1 = "null cannot be cast to non-null type java.lang.String";
        r0.<init>(r1);
        throw r0;
    L_0x004c:
        r0 = r0.substring(r7, r2);
        r2 = "(this as java.lang.Strin…ing(startIndex, endIndex)";
        kotlin.jvm.internal.Intrinsics.m26843a(r0, r2);
        r2 = java.lang.Integer.parseInt(r3);	 Catch:{ NumberFormatException -> 0x0060 }
        r2 = r2 * r6;	 Catch:{ NumberFormatException -> 0x0060 }
        r0 = java.lang.Integer.parseInt(r0);	 Catch:{ NumberFormatException -> 0x0060 }
        r1 = r2 + r0;
    L_0x0060:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.internal.PlatformImplementationsKt.a():int");
    }
}
