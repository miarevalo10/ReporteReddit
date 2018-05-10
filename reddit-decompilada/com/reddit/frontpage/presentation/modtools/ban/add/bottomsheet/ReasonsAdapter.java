package com.reddit.frontpage.presentation.modtools.ban.add.bottomsheet;

import android.support.v7.widget.RecyclerView.Adapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.util.kotlin.ViewGroupsKt;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0017B'\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u001c\u0010\u0010\u001a\u00020\b2\n\u0010\u0011\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J\u001c\u0010\u0013\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000fH\u0016R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/reddit/frontpage/presentation/modtools/ban/add/bottomsheet/ReasonsAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/reddit/frontpage/presentation/modtools/ban/add/bottomsheet/ReasonsAdapter$ViewHolder;", "banReasons", "", "", "onItemClick", "Lkotlin/Function1;", "", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "getBanReasons", "()Ljava/util/List;", "getOnItemClick", "()Lkotlin/jvm/functions/Function1;", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ReasonsAdapter.kt */
public final class ReasonsAdapter extends Adapter<ViewHolder> {
    final List<String> f28592a;
    final Function1<String, Unit> f28593b;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/reddit/frontpage/presentation/modtools/ban/add/bottomsheet/ReasonsAdapter$ViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/reddit/frontpage/presentation/modtools/ban/add/bottomsheet/ReasonsAdapter;Landroid/view/View;)V", "reasonText", "Landroid/widget/TextView;", "getReasonText", "()Landroid/widget/TextView;", "reasonText$delegate", "Lkotlin/Lazy;", "bind", "", "position", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: ReasonsAdapter.kt */
    public final class ViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder {
        static final /* synthetic */ KProperty[] f28589a = new KProperty[]{Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(ViewHolder.class), "reasonText", "getReasonText()Landroid/widget/TextView;"))};
        final Lazy f28590b;
        final /* synthetic */ ReasonsAdapter f28591p;

        public ViewHolder(ReasonsAdapter reasonsAdapter, View view) {
            Intrinsics.m26847b(view, "itemView");
            this.f28591p = reasonsAdapter;
            super(view);
            this.f28590b = LazyKt.m26777a((Function0) new ReasonsAdapter$ViewHolder$reasonText$2(view));
        }
    }

    public final /* synthetic */ android.support.v7.widget.RecyclerView.ViewHolder m29754a(ViewGroup viewGroup, int i) {
        Intrinsics.m26847b(viewGroup, "parent");
        return (android.support.v7.widget.RecyclerView.ViewHolder) new ViewHolder(this, ViewGroupsKt.m24100a(viewGroup, C1761R.layout.listitem_ban_reason, false));
    }

    public final /* synthetic */ void m29755a(android.support.v7.widget.RecyclerView.ViewHolder viewHolder, int i) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        Intrinsics.m26847b(viewHolder2, "holder");
        ((TextView) viewHolder2.f28590b.mo5678b()).setText((CharSequence) viewHolder2.f28591p.f28592a.get(i));
        viewHolder2.c.setOnClickListener(new ReasonsAdapter$ViewHolder$bind$1(viewHolder2, i));
    }

    public ReasonsAdapter(List<String> list, Function1<? super String, Unit> function1) {
        Intrinsics.m26847b(list, "banReasons");
        Intrinsics.m26847b(function1, "onItemClick");
        this.f28592a = list;
        this.f28593b = function1;
    }

    public final int m29753a() {
        return this.f28592a.size();
    }
}
