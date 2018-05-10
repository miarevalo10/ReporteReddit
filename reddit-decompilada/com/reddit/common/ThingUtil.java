package com.reddit.common;

import io.fabric.sdk.android.services.events.EventsFilesManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0004H\u0007J\u0016\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bJ\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/reddit/common/ThingUtil;", "", "()V", "COMMENT_PREFIX", "", "LINK_PREFIX", "SUBREDDIT_PREFIX", "UNKNOWN", "USER_PREFIX", "getPrefixForType", "type", "Lcom/reddit/common/ThingType;", "getTypeForPrefix", "id", "prependType", "prependTypeIfMissing", "stripPrefix", "common_release"}, k = 1, mv = {1, 1, 9})
/* compiled from: ThingUtil.kt */
public final class ThingUtil {
    public static final ThingUtil f10274a = new ThingUtil();

    @Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 9})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] f10273a;

        static {
            int[] iArr = new int[ThingType.values().length];
            f10273a = iArr;
            iArr[ThingType.f10267a.ordinal()] = 1;
            f10273a[ThingType.f10268b.ordinal()] = 2;
            f10273a[ThingType.f10269c.ordinal()] = 3;
            f10273a[ThingType.f10270d.ordinal()] = 4;
        }
    }

    private ThingUtil() {
    }

    private static String m8718a(ThingType thingType) {
        Intrinsics.b(thingType, "type");
        switch (WhenMappings.f10273a[thingType.ordinal()]) {
            case 1:
                return "t1_";
            case 2:
                return "t2_";
            case 3:
                return "t3_";
            case 4:
                return "t5_";
            default:
                return "";
        }
    }

    public static final ThingType m8717a(String str) {
        Intrinsics.b(str, "id");
        str = str.substring(0, 3);
        Intrinsics.a(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        int hashCode = str.hashCode();
        if (hashCode != 113090) {
            if (hashCode != 113121) {
                if (hashCode != 113152) {
                    if (hashCode == 113214) {
                        if (str.equals("t5_") != null) {
                            return ThingType.f10270d;
                        }
                    }
                } else if (str.equals("t3_") != null) {
                    return ThingType.f10269c;
                }
            } else if (str.equals("t2_") != null) {
                return ThingType.f10268b;
            }
        } else if (str.equals("t1_") != null) {
            return ThingType.f10267a;
        }
        return ThingType.f10271e;
    }

    public static final String m8719a(String str, ThingType thingType) {
        Intrinsics.b(str, "id");
        Intrinsics.b(thingType, "type");
        thingType = m8718a(thingType);
        if (StringsKt.a(str, thingType)) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(thingType);
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    public static final String m8720b(String str) {
        Intrinsics.b(str, "id");
        return StringsKt.d(str, EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR);
    }

    public static String m8721b(String str, ThingType thingType) {
        Intrinsics.b(str, "id");
        Intrinsics.b(thingType, "type");
        thingType = m8718a(thingType);
        if ((StringsKt.a(str, thingType) ^ 1) == 0) {
            throw ((Throwable) new IllegalArgumentException("Please provide id without type.".toString()));
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(thingType);
        stringBuilder.append(str);
        return stringBuilder.toString();
    }
}
