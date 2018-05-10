package com.reddit.frontpage.ui.layout;

import android.content.Context;
import android.support.v7.widget.LinearSmoothScroller;
import io.fabric.sdk.android.services.common.AbstractSpiCall;

public class SmoothScroller extends LinearSmoothScroller {
    private final float f34301f;
    private final float f34302m;

    public SmoothScroller(Context context, int i) {
        super(context);
        this.f34301f = (float) i;
        this.f34302m = i < AbstractSpiCall.DEFAULT_TIMEOUT ? (float) ((int) (((float) Math.abs(i)) * a(context.getResources().getDisplayMetrics()))) : 1140457472;
    }

    protected final int m35005b(int i) {
        return (int) (this.f34302m * (((float) i) / this.f34301f));
    }
}
