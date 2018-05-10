package com.twitter.sdk.android.tweetui;

import com.twitter.sdk.android.core.models.Tweet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

final class Utils {
    static CharSequence m25944a(CharSequence charSequence) {
        return charSequence != null ? charSequence : "";
    }

    static String m25947b(String str) {
        return str != null ? str : "";
    }

    static java.lang.Long m25945a(java.lang.String r2) {
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
        r0 = java.lang.Long.parseLong(r2);	 Catch:{ NumberFormatException -> 0x0009 }
        r2 = java.lang.Long.valueOf(r0);	 Catch:{ NumberFormatException -> 0x0009 }
        return r2;
    L_0x0009:
        r0 = -1;
        r2 = java.lang.Long.valueOf(r0);
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.twitter.sdk.android.tweetui.Utils.a(java.lang.String):java.lang.Long");
    }

    static List<Tweet> m25946a(List<Long> list, List<Tweet> list2) {
        HashMap hashMap = new HashMap();
        List arrayList = new ArrayList();
        for (Tweet tweet : list2) {
            hashMap.put(Long.valueOf(tweet.f24051i), tweet);
        }
        for (Long l : list) {
            if (hashMap.containsKey(l)) {
                arrayList.add(hashMap.get(l));
            }
        }
        return arrayList;
    }
}
