package com.reddit.frontpage.presentation.search;

import android.view.View;
import android.widget.TextView;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.presentation.communities.model.CommunityPresentationModel;
import com.reddit.frontpage.util.AccountPrefsUtil;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.util.kotlin.ViewsKt;
import com.reddit.frontpage.widgets.ShapedIconView;
import com.reddit.frontpage.widgets.subscribe.SubscribeRedditView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001Ba\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012%\u0010\u0004\u001a!\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005j\u0002`\u000b\u0012+\b\u0002\u0010\f\u001a%\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005j\u0004\u0018\u0001`\r¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u000e\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0014J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002R1\u0010\f\u001a%\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005j\u0004\u0018\u0001`\rX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/reddit/frontpage/presentation/search/CommunitySearchResultItemViewHolder;", "Lcom/reddit/frontpage/presentation/search/SearchItemViewHolder;", "view", "Landroid/view/View;", "onItemClick", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "position", "", "Lcom/reddit/frontpage/presentation/search/ItemClickListener;", "onItemSubscribe", "Lcom/reddit/frontpage/presentation/search/ItemSubscribeListener;", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "bind", "model", "Lcom/reddit/frontpage/presentation/communities/model/CommunityPresentationModel;", "item", "Lcom/reddit/frontpage/presentation/search/CommunitySearchResultItem;", "Lcom/reddit/frontpage/presentation/search/CommunitySearchTypeAheadItem;", "setupIcon", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: CommunitySearchViewHolders.kt */
public final class CommunitySearchResultItemViewHolder extends SearchItemViewHolder {
    private final Function1<Integer, Unit> f34150a;

    public CommunitySearchResultItemViewHolder(View view, Function1<? super Integer, Unit> function1, Function1<? super Integer, Unit> function12) {
        Intrinsics.m26847b(view, "view");
        Intrinsics.m26847b(function1, "onItemClick");
        super(view, function1);
        this.f34150a = function12;
    }

    final void m34871a(CommunityPresentationModel communityPresentationModel) {
        Object obj = this.c;
        Intrinsics.m26843a(obj, "itemView");
        obj = (TextView) obj.findViewById(C1761R.id.community_name);
        Intrinsics.m26843a(obj, "itemView.community_name");
        obj.setText(communityPresentationModel.f20472d);
        obj = this.c;
        Intrinsics.m26843a(obj, "itemView");
        obj = (SubscribeRedditView) obj.findViewById(C1761R.id.community_subscribe);
        Intrinsics.m26843a(obj, "itemView.community_subscribe");
        ((View) obj).setOnClickListener(new C1869xaa29f4d(new CommunitySearchResultItemViewHolder$bind$1(this)));
        obj = this.c;
        Intrinsics.m26843a(obj, "itemView");
        obj = (SubscribeRedditView) obj.findViewById(C1761R.id.community_subscribe);
        Intrinsics.m26843a(obj, "itemView.community_subscribe");
        ViewsKt.m24107c((View) obj);
        String str = communityPresentationModel.f20474f;
        String str2 = communityPresentationModel.f20475g;
        Integer num = communityPresentationModel.f20478j;
        Integer num2 = communityPresentationModel.f20479k;
        Integer num3 = communityPresentationModel.f20477i;
        boolean z = communityPresentationModel.f20480l;
        boolean a = AccountPrefsUtil.m23629a(Boolean.valueOf(communityPresentationModel.f20482n));
        Object obj2 = this.c;
        Intrinsics.m26843a(obj2, "itemView");
        Util.m23983a((ShapedIconView) obj2.findViewById(C1761R.id.community_icon), str, str2, null, num, num2, num3, z, a);
    }
}
