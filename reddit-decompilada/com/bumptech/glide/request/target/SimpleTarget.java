package com.bumptech.glide.request.target;

import com.bumptech.glide.util.Util;

public abstract class SimpleTarget<Z> extends BaseTarget<Z> {
    private final int f18901a;
    private final int f18902b;

    public final void mo3859b(SizeReadyCallback sizeReadyCallback) {
    }

    public SimpleTarget() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    public SimpleTarget(int i, int i2) {
        this.f18901a = i;
        this.f18902b = i2;
    }

    public final void mo3857a(SizeReadyCallback sizeReadyCallback) {
        if (Util.m3231a(this.f18901a, this.f18902b)) {
            sizeReadyCallback.onSizeReady(this.f18901a, this.f18902b);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: ");
        stringBuilder.append(this.f18901a);
        stringBuilder.append(" and height: ");
        stringBuilder.append(this.f18902b);
        stringBuilder.append(", either provide dimensions in the constructor or call override()");
        throw new IllegalArgumentException(stringBuilder.toString());
    }
}
