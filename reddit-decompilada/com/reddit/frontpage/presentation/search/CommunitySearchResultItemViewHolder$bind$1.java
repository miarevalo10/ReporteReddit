package com.reddit.frontpage.presentation.search;

import android.view.View;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.widgets.subscribe.SubscribeRedditView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: CommunitySearchViewHolders.kt */
final class CommunitySearchResultItemViewHolder$bind$1 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ CommunitySearchResultItemViewHolder f37047a;

    CommunitySearchResultItemViewHolder$bind$1(CommunitySearchResultItemViewHolder communitySearchResultItemViewHolder) {
        this.f37047a = communitySearchResultItemViewHolder;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        obj = this.f37047a.c;
        Intrinsics.m26843a(obj, "itemView");
        ((SubscribeRedditView) obj.findViewById(C1761R.id.community_subscribe)).m35332b();
        obj = this.f37047a.f34150a;
        if (obj != null) {
            obj.mo6492a(Integer.valueOf(this.f37047a.d()));
        }
        return Unit.f25273a;
    }
}
