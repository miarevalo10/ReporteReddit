package com.reddit.frontpage.video.mpdparser.core.external;

import com.reddit.frontpage.video.mpdparser.core.mapper.LocalUrlMPDMapper;
import com.reddit.frontpage.video.mpdparser.core.parser.MPDParser;
import com.reddit.frontpage.video.mpdparser.injection.DaggerWrapper;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/reddit/frontpage/video/mpdparser/core/external/SimpleManifestLocalizer;", "Lcom/reddit/frontpage/video/mpdparser/core/external/MPDLocalizer;", "parser", "Lcom/reddit/frontpage/video/mpdparser/core/parser/MPDParser;", "mapper", "Lcom/reddit/frontpage/video/mpdparser/core/mapper/LocalUrlMPDMapper;", "(Lcom/reddit/frontpage/video/mpdparser/core/parser/MPDParser;Lcom/reddit/frontpage/video/mpdparser/core/mapper/LocalUrlMPDMapper;)V", "localize", "", "uri", "Landroid/net/Uri;", "inputStream", "Ljava/io/InputStream;", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: SimpleManifestLocalizer.kt */
public final class SimpleManifestLocalizer {
    public static final Companion f21835a = new Companion();
    private static final String f21836d = "<BaseURL>";
    private static final String f21837e = "</BaseURL>";
    private final MPDParser f21838b;
    private final LocalUrlMPDMapper f21839c;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/reddit/frontpage/video/mpdparser/core/external/SimpleManifestLocalizer$Companion;", "", "()V", "BASE_URL_CLOSE", "", "getBASE_URL_CLOSE", "()Ljava/lang/String;", "BASE_URL_OPEN", "getBASE_URL_OPEN", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: SimpleManifestLocalizer.kt */
    public static final class Companion {
        private Companion() {
        }

        public static String m24111a() {
            return SimpleManifestLocalizer.f21836d;
        }

        public static String m24112b() {
            return SimpleManifestLocalizer.f21837e;
        }
    }

    @Inject
    public SimpleManifestLocalizer(MPDParser mPDParser, LocalUrlMPDMapper localUrlMPDMapper) {
        Intrinsics.m26847b(mPDParser, "parser");
        Intrinsics.m26847b(localUrlMPDMapper, "mapper");
        this.f21838b = mPDParser;
        this.f21839c = localUrlMPDMapper;
        mPDParser = DaggerWrapper.f21843a;
        com.reddit.frontpage.video.mpdparser.injection.DaggerWrapper.Companion.m24127a();
    }

    public final java.lang.String m24115a(android.net.Uri r7, java.io.InputStream r8) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r6 = this;
        r0 = "uri";
        kotlin.jvm.internal.Intrinsics.m26847b(r7, r0);
        r0 = "inputStream";
        kotlin.jvm.internal.Intrinsics.m26847b(r8, r0);
        r8 = com.reddit.frontpage.video.mpdparser.util.UtilIO.m24130b(r8);
        r0 = new java.io.ByteArrayInputStream;
        r0.<init>(r8);
        r0 = (java.io.InputStream) r0;
        r0 = com.reddit.frontpage.video.mpdparser.util.UtilIO.m24129a(r0);
        r1 = r6.f21838b;	 Catch:{ Exception -> 0x0122 }
        r2 = new java.io.ByteArrayInputStream;	 Catch:{ Exception -> 0x0122 }
        r2.<init>(r8);	 Catch:{ Exception -> 0x0122 }
        r2 = (java.io.InputStream) r2;	 Catch:{ Exception -> 0x0122 }
        r7 = r1.mo6533c(r7, r2);	 Catch:{ Exception -> 0x0122 }
        r8 = r6.f21839c;	 Catch:{ Exception -> 0x0122 }
        r7 = r8.m24116a(r7);	 Catch:{ Exception -> 0x0122 }
        r7 = r7.entrySet();	 Catch:{ Exception -> 0x0122 }
        r7 = r7.iterator();	 Catch:{ Exception -> 0x0122 }
        r8 = r0;	 Catch:{ Exception -> 0x0122 }
    L_0x0036:
        r1 = r7.hasNext();	 Catch:{ Exception -> 0x0122 }
        if (r1 == 0) goto L_0x0121;	 Catch:{ Exception -> 0x0122 }
    L_0x003c:
        r1 = r7.next();	 Catch:{ Exception -> 0x0122 }
        r1 = (java.util.Map.Entry) r1;	 Catch:{ Exception -> 0x0122 }
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0122 }
        r2.<init>();	 Catch:{ Exception -> 0x0122 }
        r3 = com.reddit.frontpage.video.mpdparser.core.external.SimpleManifestLocalizer.Companion.m24111a();	 Catch:{ Exception -> 0x0122 }
        r2.append(r3);	 Catch:{ Exception -> 0x0122 }
        r3 = r1.getKey();	 Catch:{ Exception -> 0x0122 }
        r3 = (java.lang.String) r3;	 Catch:{ Exception -> 0x0122 }
        r2.append(r3);	 Catch:{ Exception -> 0x0122 }
        r3 = com.reddit.frontpage.video.mpdparser.core.external.SimpleManifestLocalizer.Companion.m24112b();	 Catch:{ Exception -> 0x0122 }
        r2.append(r3);	 Catch:{ Exception -> 0x0122 }
        r2 = r2.toString();	 Catch:{ Exception -> 0x0122 }
        r3 = r1.getKey();	 Catch:{ Exception -> 0x0122 }
        r3 = (java.lang.String) r3;	 Catch:{ Exception -> 0x0122 }
        r4 = r1.getKey();	 Catch:{ Exception -> 0x0122 }
        r4 = (java.lang.CharSequence) r4;	 Catch:{ Exception -> 0x0122 }
        r5 = 47;	 Catch:{ Exception -> 0x0122 }
        r4 = kotlin.text.StringsKt__StringsKt.m42438a(r4, r5);	 Catch:{ Exception -> 0x0122 }
        r4 = r4 + 1;	 Catch:{ Exception -> 0x0122 }
        if (r3 != 0) goto L_0x0080;	 Catch:{ Exception -> 0x0122 }
    L_0x0078:
        r7 = new kotlin.TypeCastException;	 Catch:{ Exception -> 0x0122 }
        r8 = "null cannot be cast to non-null type java.lang.String";	 Catch:{ Exception -> 0x0122 }
        r7.<init>(r8);	 Catch:{ Exception -> 0x0122 }
        throw r7;	 Catch:{ Exception -> 0x0122 }
    L_0x0080:
        r3 = r3.substring(r4);	 Catch:{ Exception -> 0x0122 }
        r4 = "(this as java.lang.String).substring(startIndex)";	 Catch:{ Exception -> 0x0122 }
        kotlin.jvm.internal.Intrinsics.m26843a(r3, r4);	 Catch:{ Exception -> 0x0122 }
        r4 = r8;	 Catch:{ Exception -> 0x0122 }
        r4 = (java.lang.CharSequence) r4;	 Catch:{ Exception -> 0x0122 }
        r5 = r3;	 Catch:{ Exception -> 0x0122 }
        r5 = (java.lang.CharSequence) r5;	 Catch:{ Exception -> 0x0122 }
        r4 = kotlin.text.StringsKt__StringsKt.m42452a(r4, r5);	 Catch:{ Exception -> 0x0122 }
        if (r4 == 0) goto L_0x00d5;	 Catch:{ Exception -> 0x0122 }
    L_0x0095:
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0122 }
        r2.<init>();	 Catch:{ Exception -> 0x0122 }
        r4 = com.reddit.frontpage.video.mpdparser.core.external.SimpleManifestLocalizer.Companion.m24111a();	 Catch:{ Exception -> 0x0122 }
        r2.append(r4);	 Catch:{ Exception -> 0x0122 }
        r2.append(r3);	 Catch:{ Exception -> 0x0122 }
        r3 = com.reddit.frontpage.video.mpdparser.core.external.SimpleManifestLocalizer.Companion.m24112b();	 Catch:{ Exception -> 0x0122 }
        r2.append(r3);	 Catch:{ Exception -> 0x0122 }
        r2 = r2.toString();	 Catch:{ Exception -> 0x0122 }
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0122 }
        r3.<init>();	 Catch:{ Exception -> 0x0122 }
        r4 = com.reddit.frontpage.video.mpdparser.core.external.SimpleManifestLocalizer.Companion.m24111a();	 Catch:{ Exception -> 0x0122 }
        r3.append(r4);	 Catch:{ Exception -> 0x0122 }
        r1 = r1.getValue();	 Catch:{ Exception -> 0x0122 }
        r1 = (java.lang.String) r1;	 Catch:{ Exception -> 0x0122 }
        r3.append(r1);	 Catch:{ Exception -> 0x0122 }
        r1 = com.reddit.frontpage.video.mpdparser.core.external.SimpleManifestLocalizer.Companion.m24112b();	 Catch:{ Exception -> 0x0122 }
        r3.append(r1);	 Catch:{ Exception -> 0x0122 }
        r1 = r3.toString();	 Catch:{ Exception -> 0x0122 }
        r8 = kotlin.text.StringsKt__StringsJVMKt.m41947b(r8, r2, r1);	 Catch:{ Exception -> 0x0122 }
        goto L_0x0036;	 Catch:{ Exception -> 0x0122 }
    L_0x00d5:
        r4 = r8;	 Catch:{ Exception -> 0x0122 }
        r4 = (java.lang.CharSequence) r4;	 Catch:{ Exception -> 0x0122 }
        r3 = (java.lang.CharSequence) r3;	 Catch:{ Exception -> 0x0122 }
        r3 = kotlin.text.StringsKt__StringsKt.m42452a(r4, r3);	 Catch:{ Exception -> 0x0122 }
        if (r3 == 0) goto L_0x0120;	 Catch:{ Exception -> 0x0122 }
    L_0x00e0:
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0122 }
        r3.<init>();	 Catch:{ Exception -> 0x0122 }
        r4 = com.reddit.frontpage.video.mpdparser.core.external.SimpleManifestLocalizer.Companion.m24111a();	 Catch:{ Exception -> 0x0122 }
        r3.append(r4);	 Catch:{ Exception -> 0x0122 }
        r3.append(r2);	 Catch:{ Exception -> 0x0122 }
        r2 = com.reddit.frontpage.video.mpdparser.core.external.SimpleManifestLocalizer.Companion.m24112b();	 Catch:{ Exception -> 0x0122 }
        r3.append(r2);	 Catch:{ Exception -> 0x0122 }
        r2 = r3.toString();	 Catch:{ Exception -> 0x0122 }
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0122 }
        r3.<init>();	 Catch:{ Exception -> 0x0122 }
        r4 = com.reddit.frontpage.video.mpdparser.core.external.SimpleManifestLocalizer.Companion.m24111a();	 Catch:{ Exception -> 0x0122 }
        r3.append(r4);	 Catch:{ Exception -> 0x0122 }
        r1 = r1.getValue();	 Catch:{ Exception -> 0x0122 }
        r1 = (java.lang.String) r1;	 Catch:{ Exception -> 0x0122 }
        r3.append(r1);	 Catch:{ Exception -> 0x0122 }
        r1 = com.reddit.frontpage.video.mpdparser.core.external.SimpleManifestLocalizer.Companion.m24112b();	 Catch:{ Exception -> 0x0122 }
        r3.append(r1);	 Catch:{ Exception -> 0x0122 }
        r1 = r3.toString();	 Catch:{ Exception -> 0x0122 }
        r8 = kotlin.text.StringsKt__StringsJVMKt.m41947b(r8, r2, r1);	 Catch:{ Exception -> 0x0122 }
        goto L_0x0036;
    L_0x0120:
        return r0;
    L_0x0121:
        return r8;
    L_0x0122:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reddit.frontpage.video.mpdparser.core.external.SimpleManifestLocalizer.a(android.net.Uri, java.io.InputStream):java.lang.String");
    }
}
