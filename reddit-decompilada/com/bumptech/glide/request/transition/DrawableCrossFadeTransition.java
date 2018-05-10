package com.bumptech.glide.request.transition;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import com.bumptech.glide.request.transition.Transition.ViewAdapter;

public class DrawableCrossFadeTransition implements Transition<Drawable> {
    private final int f12665a;
    private final boolean f12666b;

    public final /* synthetic */ boolean mo1028a(Object obj, ViewAdapter viewAdapter) {
        Drawable drawable = (Drawable) obj;
        Drawable e = viewAdapter.mo4233e();
        if (e == null) {
            e = new ColorDrawable(0);
        }
        Drawable transitionDrawable = new TransitionDrawable(new Drawable[]{e, drawable});
        transitionDrawable.setCrossFadeEnabled(this.f12666b);
        transitionDrawable.startTransition(this.f12665a);
        viewAdapter.mo4232d(transitionDrawable);
        return true;
    }

    public DrawableCrossFadeTransition(int i, boolean z) {
        this.f12665a = i;
        this.f12666b = z;
    }
}
