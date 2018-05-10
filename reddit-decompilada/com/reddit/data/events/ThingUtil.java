package com.reddit.data.events;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0004J\u0016\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/reddit/data/events/ThingUtil;", "", "()V", "COMMENT_PREFIX", "", "LINK_PREFIX", "SUBREDDIT_PREFIX", "UNKNOWN", "USER_PREFIX", "getPrefixForType", "type", "Lcom/reddit/data/events/ThingUtil$ThingType;", "getTypeForPrefix", "id", "prependTypeIfMissing", "ThingType", "events_release"}, k = 1, mv = {1, 1, 9})
/* compiled from: ThingUtil.kt */
public final class ThingUtil {
    public static final ThingUtil f10296a = new ThingUtil();

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/reddit/data/events/ThingUtil$ThingType;", "", "(Ljava/lang/String;I)V", "COMMENT", "USER", "LINK", "SUBREDDIT", "UNKNOWN", "events_release"}, k = 1, mv = {1, 1, 9})
    /* compiled from: ThingUtil.kt */
    public enum ThingType {
    }

    @Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 9})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] f10295a;

        static {
            int[] iArr = new int[ThingType.values().length];
            f10295a = iArr;
            iArr[ThingType.f10289a.ordinal()] = 1;
            f10295a[ThingType.f10290b.ordinal()] = 2;
            f10295a[ThingType.f10291c.ordinal()] = 3;
            f10295a[ThingType.f10292d.ordinal()] = 4;
        }
    }

    private ThingUtil() {
    }

    public static String m8744a(ThingType thingType) {
        Intrinsics.b(thingType, "type");
        switch (WhenMappings.f10295a[thingType.ordinal()]) {
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
}
