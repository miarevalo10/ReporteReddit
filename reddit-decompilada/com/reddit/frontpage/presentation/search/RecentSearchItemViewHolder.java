package com.reddit.frontpage.presentation.search;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B[\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012%\u0010\u0004\u001a!\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005j\u0002`\u000b\u0012%\u0010\f\u001a!\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005j\u0002`\r¢\u0006\u0002\u0010\u000eJ\u000e\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011R-\u0010\f\u001a!\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005j\u0002`\rX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/reddit/frontpage/presentation/search/RecentSearchItemViewHolder;", "Lcom/reddit/frontpage/presentation/search/SearchItemViewHolder;", "view", "Landroid/view/View;", "onItemClick", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "position", "", "Lcom/reddit/frontpage/presentation/search/ItemClickListener;", "onItemDismiss", "Lcom/reddit/frontpage/presentation/search/ItemDismissListener;", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "bind", "item", "Lcom/reddit/frontpage/presentation/search/RecentSearchItem;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: CommunitySearchViewHolders.kt */
public final class RecentSearchItemViewHolder extends SearchItemViewHolder {
    private final Function1<Integer, Unit> f34167a;

    public RecentSearchItemViewHolder(View view, Function1<? super Integer, Unit> function1, Function1<? super Integer, Unit> function12) {
        Intrinsics.m26847b(view, "view");
        Intrinsics.m26847b(function1, "onItemClick");
        Intrinsics.m26847b(function12, "onItemDismiss");
        super(view, function1);
        this.f34167a = function12;
    }
}
