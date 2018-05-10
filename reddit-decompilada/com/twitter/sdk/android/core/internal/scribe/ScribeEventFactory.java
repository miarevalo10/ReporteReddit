package com.twitter.sdk.android.core.internal.scribe;

import java.util.List;

public class ScribeEventFactory {
    public static ScribeEvent m25880a(EventNamespace eventNamespace, String str, long j, String str2, String str3, List<ScribeItem> list) {
        Object obj;
        String str4 = eventNamespace.f23975a;
        if (str4.hashCode() == 114757) {
            if (str4.equals("tfw")) {
                obj = null;
                if (obj == null) {
                    return new SyndicatedSdkImpressionEvent(eventNamespace, j, str2, str3, list);
                }
                return new SyndicationClientEvent(eventNamespace, str, j, str2, str3, list);
            }
        }
        obj = -1;
        if (obj == null) {
            return new SyndicationClientEvent(eventNamespace, str, j, str2, str3, list);
        }
        return new SyndicatedSdkImpressionEvent(eventNamespace, j, str2, str3, list);
    }
}
