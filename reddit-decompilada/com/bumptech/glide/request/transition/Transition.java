package com.bumptech.glide.request.transition;

import android.graphics.drawable.Drawable;

public interface Transition<R> {

    public interface ViewAdapter {
        void mo4232d(Drawable drawable);

        Drawable mo4233e();
    }

    boolean mo1028a(R r, ViewAdapter viewAdapter);
}
