package com.reddit.frontpage.presentation.listing.ui.view;

import android.view.View;
import android.widget.ImageView;
import com.reddit.frontpage.C1761R;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/widget/ImageView;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: LinkThumbnailView.kt */
final class LinkThumbnailView$indicatorView$2 extends Lambda implements Function0<ImageView> {
    final /* synthetic */ LinkThumbnailView f36863a;

    LinkThumbnailView$indicatorView$2(LinkThumbnailView linkThumbnailView) {
        this.f36863a = linkThumbnailView;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        View findViewById = this.f36863a.findViewById(C1761R.id.link_thumbnail_indicator);
        if (findViewById != null) {
            return (ImageView) findViewById;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.widget.ImageView");
    }
}
