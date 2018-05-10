package com.reddit.frontpage.presentation.listing.ui.viewholder;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.frontpage.DetailHolderScreen;
import com.reddit.frontpage.util.DeepLinkUtil.ScreenDeepLinker;
import com.reddit.frontpage.util.IntentUtil;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 9})
/* compiled from: CrossPostCompactCardLinkViewHolder.kt */
final class C1837x7ae49a5f implements OnClickListener {
    final /* synthetic */ CrossPostCompactCardLinkViewHolder f20828a;
    final /* synthetic */ Context f20829b;

    C1837x7ae49a5f(CrossPostCompactCardLinkViewHolder crossPostCompactCardLinkViewHolder, Context context) {
        this.f20828a = crossPostCompactCardLinkViewHolder;
        this.f20829b = context;
    }

    public final void onClick(View view) {
        view = this.f20828a.m34773O().am;
        if (view != null) {
            this.f20829b.startActivity(IntentUtil.m23745a(this.f20829b, (ScreenDeepLinker) DetailHolderScreen.m38887b(view.f33977d, null, null)));
        }
    }
}
