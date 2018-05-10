package com.reddit.frontpage.presentation.listing.ui.view;

import android.graphics.Rect;
import android.view.TouchDelegate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 9})
/* compiled from: LinkHeaderView.kt */
final class LinkHeaderView$onFinishInflate$1 implements Runnable {
    final /* synthetic */ LinkHeaderView f20760a;

    LinkHeaderView$onFinishInflate$1(LinkHeaderView linkHeaderView) {
        this.f20760a = linkHeaderView;
    }

    public final void run() {
        Rect rect = new Rect();
        rect.left = 0;
        rect.top = 0;
        Object a = this.f20760a.b;
        Intrinsics.m26843a(a, "overflow");
        rect.right = a.getWidth();
        a = this.f20760a.b;
        Intrinsics.m26843a(a, "overflow");
        rect.bottom = a.getHeight();
        a = this.f20760a.b;
        Intrinsics.m26843a(a, "overflow");
        a.setTouchDelegate(new TouchDelegate(rect, this.f20760a.c));
    }
}
