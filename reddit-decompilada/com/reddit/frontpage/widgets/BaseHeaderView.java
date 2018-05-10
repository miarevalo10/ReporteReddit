package com.reddit.frontpage.widgets;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.v7.widget.PopupMenu;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.presentation.common.ResourcesUtil;

public abstract class BaseHeaderView extends RelativeLayout {
    protected FrameLayout f21848b;
    protected ImageView f21849c;
    protected PopupMenu f21850d;

    public final void m24132a() {
        this.f21849c.setVisibility(8);
    }

    public BaseHeaderView(Context context) {
        super(context);
        mo5055d();
    }

    public BaseHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        mo5055d();
    }

    public BaseHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        mo5055d();
    }

    @TargetApi(21)
    public BaseHeaderView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        mo5055d();
    }

    private void mo5055d() {
        inflate(getContext(), C1761R.layout.linkheader_view, this);
        this.f21848b = (FrameLayout) findViewById(C1761R.id.overflow_layout);
        this.f21849c = (ImageView) findViewById(C1761R.id.overflow_icon);
        this.f21849c.setImageDrawable(ResourcesUtil.m22733e(getContext(), this.f21849c.getDrawable()));
        this.f21850d = new PopupMenu(getContext(), this.f21849c);
        this.f21849c.setOnClickListener(new BaseHeaderView$$Lambda$0(this));
    }

    final /* synthetic */ void m24136c() {
        this.f21850d.b.a();
    }

    public final void m24133a(Runnable runnable) {
        this.f21849c.setOnClickListener(new BaseHeaderView$$Lambda$1(this, runnable));
    }

    final /* synthetic */ void m24135b(Runnable runnable) {
        runnable.run();
        this.f21850d.b.a();
    }

    public final void m24134b() {
        this.f21850d.b.a();
    }
}
