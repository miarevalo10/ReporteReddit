package com.reddit.frontpage.presentation.common.ui.view.recyclerfastscroll;

import android.support.v7.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 9})
/* compiled from: FastScrollView.kt */
final class FastScrollView$postUpdateItemIndicators$1 implements Runnable {
    final /* synthetic */ FastScrollView f20422a;

    FastScrollView$postUpdateItemIndicators$1(FastScrollView fastScrollView) {
        this.f20422a = fastScrollView;
    }

    public final void run() {
        RecyclerView b = this.f20422a.f20428f;
        if (b == null) {
            Intrinsics.m26842a();
        }
        if (b.isAttachedToWindow()) {
            this.f20422a.m22779b();
        }
        this.f20422a.f20432j = false;
    }
}
