package com.reddit.data.events;

import android.content.Context;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0006\u001a\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\u0006\u0010\f\u001a\u00020\u0001H\u0000\u001a\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003H\u0000\u001a\u0010\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0001H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0011"}, d2 = {"ACCOUNT_TYPE", "", "MAX_UNNORMALIZED", "", "applicationContext", "Landroid/content/Context;", "getApplicationContext", "()Landroid/content/Context;", "setApplicationContext", "(Landroid/content/Context;)V", "getLoIdComponents", "", "loId", "normalizeToMillis", "time", "prependUserTypeIfMissing", "userId", "events_release"}, k = 2, mv = {1, 1, 9})
/* compiled from: AnalyticsUtil.kt */
public final class AnalyticsUtilKt {
    private static Context f10284a;

    public static final long m8737a(long j) {
        return j < 9999999999L ? j * 1000 : j;
    }

    public static final Context m8738a() {
        return f10284a;
    }

    public static final void m8740a(Context context) {
        f10284a = context;
    }

    public static final String m8739a(String str) {
        Intrinsics.b(str, "userId");
        if (StringsKt.a(str, "t2_")) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder("t2_");
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    public static final List<String> m8741b(String str) {
        Intrinsics.b(str, "loId");
        return StringsKt.b(str, new String[]{"."});
    }
}
