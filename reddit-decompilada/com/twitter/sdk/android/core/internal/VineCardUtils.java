package com.twitter.sdk.android.core.internal;

import com.twitter.sdk.android.core.models.Card;
import com.twitter.sdk.android.core.models.ImageValue;
import com.twitter.sdk.android.core.models.UserValue;

public class VineCardUtils {
    public static boolean m25864a(Card card) {
        return (("player".equals(card.f24027b) || "vine".equals(card.f24027b)) && m25869f(card) != null) ? true : null;
    }

    private static boolean m25869f(com.twitter.sdk.android.core.models.Card r5) {
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
        r5 = r5.f24026a;
        r0 = "site";
        r5 = r5.m25889a(r0);
        r5 = (com.twitter.sdk.android.core.models.UserValue) r5;
        r0 = 0;
        if (r5 == 0) goto L_0x001d;
    L_0x000d:
        r5 = r5.f24110a;	 Catch:{ NumberFormatException -> 0x001c }
        r1 = java.lang.Long.parseLong(r5);	 Catch:{ NumberFormatException -> 0x001c }
        r3 = 586671909; // 0x22f7e725 float:6.719422E-18 double:2.898544356E-315;
        r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));
        if (r5 != 0) goto L_0x001d;
    L_0x001a:
        r5 = 1;
        return r5;
    L_0x001c:
        return r0;
    L_0x001d:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.twitter.sdk.android.core.internal.VineCardUtils.f(com.twitter.sdk.android.core.models.Card):boolean");
    }

    public static String m25865b(Card card) {
        return ((UserValue) card.f24026a.m25889a("site")).f24110a;
    }

    public static String m25866c(Card card) {
        return (String) card.f24026a.m25889a("player_stream_url");
    }

    public static String m25867d(Card card) {
        return (String) card.f24026a.m25889a("card_url");
    }

    public static ImageValue m25868e(Card card) {
        return (ImageValue) card.f24026a.m25889a("player_image");
    }
}
