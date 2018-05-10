package com.reddit.frontpage.commons.analytics;

import android.os.Handler;
import android.os.Looper;
import com.reddit.datalibrary.frontpage.requests.models.v1.CommentResponse;
import com.reddit.datalibrary.frontpage.requests.models.v1.MoreCommentResponse;
import com.reddit.datalibrary.frontpage.requests.models.v2.Listing;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u0001H\u0007¨\u0006\b"}, d2 = {"Lcom/reddit/frontpage/commons/analytics/TrackingRouter;", "", "()V", "route", "", "correlationId", "", "routingKey", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: TrackingRouter.kt */
public final class TrackingRouter {
    public static final TrackingRouter f20015a = new TrackingRouter();

    private TrackingRouter() {
    }

    public static final void m21886a(String str, Object obj) {
        Intrinsics.m26847b(obj, "routingKey");
        if (str != null) {
            if (Intrinsics.m26845a(obj, (Object) CommentResponse.class)) {
                new Handler(Looper.getMainLooper()).post(new TrackingRouter$route$1(str));
            } else if (Intrinsics.m26845a(obj, (Object) MoreCommentResponse.class)) {
                new Handler(Looper.getMainLooper()).post(new TrackingRouter$route$2(str));
            } else {
                String obj2 = obj.toString();
                Object canonicalName = Listing.class.getCanonicalName();
                Intrinsics.m26843a(canonicalName, "com.reddit.datalibrary.f…:class.java.canonicalName");
                if (StringsKt__StringsJVMKt.m41944a(obj2, (String) canonicalName)) {
                    new Handler(Looper.getMainLooper()).post(new TrackingRouter$route$3(str));
                    return;
                }
                obj = obj.toString();
                Object canonicalName2 = com.reddit.datalibrary.frontpage.requests.models.v1.Listing.class.getCanonicalName();
                Intrinsics.m26843a(canonicalName2, "com.reddit.datalibrary.f…:class.java.canonicalName");
                if (StringsKt__StringsJVMKt.m41944a((String) obj, (String) canonicalName2) != null) {
                    new Handler(Looper.getMainLooper()).post(new TrackingRouter$route$4(str));
                }
            }
        }
    }
}
