package com.reddit.frontpage.widgets.vote;

import android.graphics.Rect;
import com.reddit.android.view.TouchDelegate;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 9})
/* compiled from: VoteView.kt */
final class VoteView$onFinishInflate$1 implements Runnable {
    final /* synthetic */ VoteView f22259a;

    VoteView$onFinishInflate$1(VoteView voteView) {
        this.f22259a = voteView;
    }

    public final void run() {
        Rect rect = new Rect();
        VoteView.m24412g(this.f22259a).getHitRect(rect);
        rect.left = rect.right;
        rect.right = this.f22259a.getWidth();
        rect.top = 0;
        rect.bottom = this.f22259a.getHeight();
        this.f22259a.setTouchDelegate(new TouchDelegate(rect, VoteView.m24413h(this.f22259a)));
    }
}
