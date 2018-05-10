package com.reddit.frontpage.presentation.listing.ui.view;

import android.view.View;
import android.widget.ImageView;
import com.reddit.frontpage.ui.listener.RemoteImageAttachStateListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"com/reddit/frontpage/presentation/listing/ui/view/LinkThumbnailView$onFinishInflate$1", "Lcom/reddit/frontpage/ui/listener/RemoteImageAttachStateListener;", "(Lcom/reddit/frontpage/presentation/listing/ui/view/LinkThumbnailView;Landroid/widget/ImageView;)V", "onViewAttachedToWindow", "", "v", "Landroid/view/View;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: LinkThumbnailView.kt */
public final class LinkThumbnailView$onFinishInflate$1 extends RemoteImageAttachStateListener {
    final /* synthetic */ LinkThumbnailView f28493a;

    LinkThumbnailView$onFinishInflate$1(LinkThumbnailView linkThumbnailView, ImageView imageView) {
        this.f28493a = linkThumbnailView;
        super(imageView);
    }

    public final void onViewAttachedToWindow(View view) {
        Intrinsics.m26847b(view, "v");
        view = this.f28493a.f20769f;
        if (view != null) {
            this.f28493a.m23026a(view, this.f28493a.f20770g, this.f28493a.f20771h);
        }
    }
}
