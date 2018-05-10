package com.reddit.frontpage.animation;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v7.widget.RecyclerView.ViewHolder;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.presentation.common.ResourcesUtil;
import jp.wasabeef.recyclerview.animators.BaseItemAnimator;

public class HighlightInAnimator extends BaseItemAnimator {
    private final int f36331d;
    private final int f36332e;

    public HighlightInAnimator(Context context) {
        this.f36331d = ResourcesUtil.m22740i(context, C1761R.attr.live_highlight_color);
        this.f36332e = ResourcesUtil.m22740i(context, C1761R.attr.rdt_body_color);
    }

    protected final void mo6928h(ViewHolder viewHolder) {
        viewHolder.c.animate().alpha(0.0f).setDuration(this.j).setInterpolator(this.c).setStartDelay(Math.abs((((long) viewHolder.f) * this.j) / 4)).start();
    }

    protected final void mo6929i(ViewHolder viewHolder) {
        viewHolder.c.setAlpha(0.0f);
        viewHolder.c.setBackgroundColor(this.f36331d);
    }

    protected final void mo6930j(ViewHolder viewHolder) {
        viewHolder.c.animate().alpha(1.0f).setDuration(this.i).setInterpolator(this.c).setStartDelay(m36078k(viewHolder)).start();
        ValueAnimator ofObject = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{Integer.valueOf(this.f36331d), Integer.valueOf(this.f36332e)});
        ofObject.setDuration(4000);
        ofObject.setStartDelay(m36078k(viewHolder) + this.i);
        ofObject.setInterpolator(new FastOutSlowInInterpolator());
        ofObject.addUpdateListener(new HighlightInAnimator$$Lambda$0(viewHolder));
        ofObject.start();
    }
}
