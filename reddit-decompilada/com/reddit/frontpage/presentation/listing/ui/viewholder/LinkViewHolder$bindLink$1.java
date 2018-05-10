package com.reddit.frontpage.presentation.listing.ui.viewholder;

import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.frontpage.presentation.listing.model.LinkPresentationModel;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 9})
/* compiled from: LinkViewHolder.kt */
final class LinkViewHolder$bindLink$1 implements OnClickListener {
    final /* synthetic */ LinkViewHolder f20844a;
    final /* synthetic */ LinkPresentationModel f20845b;

    LinkViewHolder$bindLink$1(LinkViewHolder linkViewHolder, LinkPresentationModel linkPresentationModel) {
        this.f20844a = linkViewHolder;
        this.f20845b = linkPresentationModel;
    }

    public final void onClick(View view) {
        view = this.f20844a.f34045r;
        if (view != null) {
            view.mo4829b(this.f20845b);
        }
    }
}
