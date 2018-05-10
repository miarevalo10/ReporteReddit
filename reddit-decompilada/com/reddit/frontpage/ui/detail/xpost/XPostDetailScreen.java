package com.reddit.frontpage.ui.detail.xpost;

import android.os.Bundle;
import android.view.View;
import android.view.View.MeasureSpec;
import com.reddit.datalibrary.frontpage.requests.models.v2.ClientLink;
import com.reddit.frontpage.commons.analytics.events.v1.ScreenViewEvent;
import com.reddit.frontpage.commons.analytics.events.v1.ScreenViewEvent.ScreenViewPayload;
import com.reddit.frontpage.ui.detail.FlexContainerDetailScreen;
import com.reddit.frontpage.util.Util;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nR\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/reddit/frontpage/ui/detail/xpost/XPostDetailScreen;", "Lcom/reddit/frontpage/ui/detail/FlexContainerDetailScreen;", "bundle", "Landroid/os/Bundle;", "(Landroid/os/Bundle;)V", "TARGET_TYPE", "", "createV1ScreenViewEvent", "Lcom/reddit/frontpage/commons/analytics/events/v1/ScreenViewEvent;", "getMeasuredHeight", "", "view", "Landroid/view/View;", "width", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: XPostDetailScreen.kt */
public abstract class XPostDetailScreen extends FlexContainerDetailScreen {
    private final String aa = "crosspost";

    public XPostDetailScreen(Bundle bundle) {
        Intrinsics.m26847b(bundle, "bundle");
        super(bundle);
    }

    public final ScreenViewEvent mo7203N() {
        ScreenViewEvent N = super.mo7203N();
        if (N == null) {
            return null;
        }
        ((ScreenViewPayload) N.payload).target_type = this.aa;
        ClientLink b = Util.m23994b(m39099U());
        if (b != null) {
            ((ScreenViewPayload) N.payload).target_root_type = b.isSelf() ? "self" : "link";
            ((ScreenViewPayload) N.payload).target_parent_fullname = b.getName();
            ((ScreenViewPayload) N.payload).target_root_fullname = b.getName();
            ((ScreenViewPayload) N.payload).target_crosspost_depth = Integer.valueOf(1);
        }
        return N;
    }

    public static int m42217a(View view, int i) {
        Intrinsics.m26847b(view, "view");
        view.measure(MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE), MeasureSpec.makeMeasureSpec(0, 0));
        return view.getMeasuredHeight();
    }
}
