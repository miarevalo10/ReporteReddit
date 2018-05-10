package com.reddit.frontpage.ui.listener;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.AppBarLayout.OnOffsetChangedListener;
import android.support.design.widget.CollapsingToolbarLayout;
import android.widget.TextView;

public class ProfileToolbarOffsetChangedListener implements OnOffsetChangedListener {
    private final CollapsingToolbarLayout f29011a;
    private final TextView f29012b;
    private boolean f29013c = false;

    public ProfileToolbarOffsetChangedListener(CollapsingToolbarLayout collapsingToolbarLayout, TextView textView) {
        this.f29011a = collapsingToolbarLayout;
        this.f29012b = textView;
    }

    public final void m30075a(AppBarLayout appBarLayout, int i) {
        appBarLayout = this.f29011a.getScrimVisibleHeightTrigger() < (-i) ? true : null;
        if (appBarLayout != this.f29013c) {
            if (appBarLayout != null) {
                this.f29012b.animate().alpha(1.0f).setDuration(this.f29011a.getScrimAnimationDuration());
            } else {
                this.f29012b.animate().alpha(0.0f).setDuration(this.f29011a.getScrimAnimationDuration());
            }
        }
        this.f29013c = appBarLayout;
    }
}
