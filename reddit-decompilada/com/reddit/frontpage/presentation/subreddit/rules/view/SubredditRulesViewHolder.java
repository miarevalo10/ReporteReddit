package com.reddit.frontpage.presentation.subreddit.rules.view;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.reddit.frontpage.widgets.BaseHtmlTextView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000e¨\u0006\u0016"}, d2 = {"Lcom/reddit/frontpage/presentation/subreddit/rules/view/SubredditRulesViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "descriptionView", "Lcom/reddit/frontpage/widgets/BaseHtmlTextView;", "getDescriptionView", "()Lcom/reddit/frontpage/widgets/BaseHtmlTextView;", "descriptionView$delegate", "Lkotlin/Lazy;", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "title$delegate", "bind", "", "subredditRule", "Lcom/reddit/datalibrary/frontpage/data/model/SubredditRule;", "number", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: SubredditRulesViewHolder.kt */
public final class SubredditRulesViewHolder extends ViewHolder {
    static final /* synthetic */ KProperty[] f28800a = new KProperty[]{Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(SubredditRulesViewHolder.class), "title", "getTitle()Landroid/widget/TextView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(SubredditRulesViewHolder.class), "descriptionView", "getDescriptionView()Lcom/reddit/frontpage/widgets/BaseHtmlTextView;"))};
    final Lazy f28801b;
    private final Lazy f28802p;

    final BaseHtmlTextView m29879v() {
        return (BaseHtmlTextView) this.f28802p.mo5678b();
    }

    public SubredditRulesViewHolder(View view) {
        Intrinsics.m26847b(view, "view");
        super(view);
        this.f28801b = LazyKt.m26777a(new SubredditRulesViewHolder$title$2(view));
        this.f28802p = LazyKt.m26777a(new SubredditRulesViewHolder$descriptionView$2(view));
    }
}
