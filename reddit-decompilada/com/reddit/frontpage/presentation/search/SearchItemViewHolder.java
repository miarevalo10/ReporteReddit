package com.reddit.frontpage.presentation.search;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B4\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012%\u0010\u0004\u001a!\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005j\u0002`\u000b¢\u0006\u0002\u0010\fR-\u0010\u0004\u001a!\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005j\u0002`\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/reddit/frontpage/presentation/search/SearchItemViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "onItemClick", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "position", "", "Lcom/reddit/frontpage/presentation/search/ItemClickListener;", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;)V", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: CommunitySearchViewHolders.kt */
public abstract class SearchItemViewHolder extends ViewHolder {
    private final Function1<Integer, Unit> f28790a;

    public SearchItemViewHolder(View view, Function1<? super Integer, Unit> function1) {
        Intrinsics.m26847b(view, "view");
        Intrinsics.m26847b(function1, "onItemClick");
        super(view);
        this.f28790a = function1;
        view.setOnClickListener(new SearchItemViewHolder$inlined$sam$OnClickListener$i$7f478c20(new Function1<View, Unit>() {
            public final /* synthetic */ Object mo6492a(Object obj) {
                this.f28790a.mo6492a(Integer.valueOf(this.d()));
                return Unit.f25273a;
            }
        }));
    }
}
