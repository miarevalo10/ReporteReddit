package com.reddit.frontpage.widgets;

import android.util.TypedValue;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: RefreshPill.kt */
final class RefreshPill$listener$1$MIN_SCROLL_THRESHOLD$2 extends Lambda implements Function0<Float> {
    final /* synthetic */ RefreshPill$listener$1 f37429a;

    RefreshPill$listener$1$MIN_SCROLL_THRESHOLD$2(RefreshPill$listener$1 refreshPill$listener$1) {
        this.f37429a = refreshPill$listener$1;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        Object resources = this.f37429a.f29481e.getResources();
        Intrinsics.m26843a(resources, "context.resources");
        return Float.valueOf(-(((float) ((int) TypedValue.applyDimension(1, 20.0f, resources.getDisplayMetrics()))) + ((Number) this.f37429a.f29485i.mo5678b()).floatValue()));
    }
}
