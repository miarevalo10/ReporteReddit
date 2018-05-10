package com.reddit.frontpage.presentation.common.ui.view.recyclerfastscroll;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"}, k = 3, mv = {1, 1, 9})
/* compiled from: FastScrollThumbView.kt */
final class FastScrollThumbView$setupWithFastScrollView$1 implements OnTouchListener {
    final /* synthetic */ FastScrollThumbView f20421a;

    FastScrollThumbView$setupWithFastScrollView$1(FastScrollThumbView fastScrollThumbView) {
        this.f20421a = fastScrollThumbView;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        Intrinsics.m26843a((Object) motionEvent, "event");
        if (motionEvent.getAction() == null) {
            this.f20421a.setActivated(true);
        } else if (motionEvent.getAction() == 1) {
            this.f20421a.setActivated(false);
        }
        return false;
    }
}
