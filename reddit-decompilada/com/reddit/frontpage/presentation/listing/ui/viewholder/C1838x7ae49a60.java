package com.reddit.frontpage.presentation.listing.ui.viewholder;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 9})
/* compiled from: CrossPostCompactCardLinkViewHolder.kt */
final class C1838x7ae49a60 implements OnClickListener {
    final /* synthetic */ CrossPostCompactCardLinkViewHolder f20830a;
    final /* synthetic */ Context f20831b;

    C1838x7ae49a60(CrossPostCompactCardLinkViewHolder crossPostCompactCardLinkViewHolder, Context context) {
        this.f20830a = crossPostCompactCardLinkViewHolder;
        this.f20831b = context;
    }

    public final void onClick(View view) {
        view = this.f20830a.m34773O().am;
        if (view != null) {
            OnViewMediaListener onViewMediaListener = this.f20830a.f34045r;
            if (onViewMediaListener != null) {
                onViewMediaListener.mo4828a(view);
            }
        }
    }
}
