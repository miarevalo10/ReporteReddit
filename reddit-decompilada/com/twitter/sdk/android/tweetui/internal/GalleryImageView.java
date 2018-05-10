package com.twitter.sdk.android.tweetui.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ProgressBar;
import com.squareup.picasso.Target;
import com.twitter.sdk.android.tweetui.internal.SwipeToDismissTouchListener.Callback;

public class GalleryImageView extends FrameLayout implements Target {
    final MultiTouchImageView f30791a;
    final ProgressBar f30792b;

    public GalleryImageView(Context context) {
        this(context, new MultiTouchImageView(context), new ProgressBar(context));
    }

    private GalleryImageView(Context context, MultiTouchImageView multiTouchImageView, ProgressBar progressBar) {
        super(context);
        this.f30791a = multiTouchImageView;
        this.f30792b = progressBar;
        progressBar.setLayoutParams(new LayoutParams(-2, -2, 17));
        addView(progressBar);
        multiTouchImageView.setLayoutParams(new LayoutParams(-1, -1, 17));
        addView(multiTouchImageView);
    }

    public void setSwipeToDismissCallback(Callback callback) {
        this.f30791a.setOnTouchListener(SwipeToDismissTouchListener.m25964a(this.f30791a, callback));
    }

    public final void mo5512a(Bitmap bitmap) {
        this.f30791a.setImageBitmap(bitmap);
        this.f30792b.setVisibility(8);
    }

    public final void mo5511a() {
        this.f30791a.setImageResource(17170445);
        this.f30792b.setVisibility(0);
    }
}
