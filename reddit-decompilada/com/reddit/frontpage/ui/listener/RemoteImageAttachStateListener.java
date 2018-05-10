package com.reddit.frontpage.ui.listener;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.widget.ImageView;
import com.reddit.config.GlideApp;
import com.reddit.frontpage.util.Util;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/reddit/frontpage/ui/listener/RemoteImageAttachStateListener;", "Landroid/view/View$OnAttachStateChangeListener;", "imageView", "Landroid/widget/ImageView;", "(Landroid/widget/ImageView;)V", "onViewDetachedFromWindow", "", "v", "Landroid/view/View;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: RemoteImageAttachStateListener.kt */
public abstract class RemoteImageAttachStateListener implements OnAttachStateChangeListener {
    private final ImageView f21249a;

    public RemoteImageAttachStateListener(ImageView imageView) {
        Intrinsics.m26847b(imageView, "imageView");
        this.f21249a = imageView;
    }

    public void onViewDetachedFromWindow(View view) {
        Intrinsics.m26847b(view, "v");
        view = Util.m23954a(view.getContext());
        if (view != null && view.isDestroyed() == null) {
            GlideApp.a(this.f21249a).a(this.f21249a);
        }
    }
}
