package com.reddit.frontpage.presentation.modtools.actions;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.presentation.common.ResourcesUtil;
import com.reddit.frontpage.presentation.modtools.util.ModToolsAction;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.util.kotlin.ViewGroupsKt;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0017B)\b\u0016\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\b¢\u0006\u0002\u0010\tB\u0019\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\u0010\nJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u001c\u0010\u0010\u001a\u00020\u00062\n\u0010\u0011\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J\u001c\u0010\u0013\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000fH\u0016R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\bX\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/reddit/frontpage/presentation/modtools/actions/ModToolsAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/reddit/frontpage/presentation/modtools/actions/ModToolsAdapter$ViewHolder;", "onItemClick", "Lkotlin/Function1;", "Lcom/reddit/frontpage/presentation/modtools/util/ModToolsAction;", "", "menuItems", "", "(Lkotlin/jvm/functions/Function1;Ljava/util/List;)V", "(Lkotlin/jvm/functions/Function1;)V", "modToolsActions", "getOnItemClick", "()Lkotlin/jvm/functions/Function1;", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ModToolsActionsAdapter.kt */
public final class ModToolsAdapter extends Adapter<ViewHolder> {
    final Function1<ModToolsAction, Unit> f28534a;
    private List<? extends ModToolsAction> f28535b;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcom/reddit/frontpage/presentation/modtools/actions/ModToolsAdapter$ViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/reddit/frontpage/presentation/modtools/actions/ModToolsAdapter;Landroid/view/View;)V", "icon", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "icon$delegate", "Lkotlin/Lazy;", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "title$delegate", "bind", "", "modToolsActionItem", "Lcom/reddit/frontpage/presentation/modtools/util/ModToolsAction;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: ModToolsActionsAdapter.kt */
    public final class ViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder {
        static final /* synthetic */ KProperty[] f28530a = new KProperty[]{Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(ViewHolder.class), "icon", "getIcon()Landroid/widget/ImageView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(ViewHolder.class), "title", "getTitle()Landroid/widget/TextView;"))};
        final Lazy f28531b;
        final Lazy f28532p;
        final /* synthetic */ ModToolsAdapter f28533q;

        public ViewHolder(ModToolsAdapter modToolsAdapter, View view) {
            Intrinsics.m26847b(view, "itemView");
            this.f28533q = modToolsAdapter;
            super(view);
            this.f28531b = LazyKt.m26777a((Function0) new ModToolsAdapter$ViewHolder$icon$2(view));
            this.f28532p = LazyKt.m26777a((Function0) new ModToolsAdapter$ViewHolder$title$2(view));
        }
    }

    public final /* synthetic */ android.support.v7.widget.RecyclerView.ViewHolder m29734a(ViewGroup viewGroup, int i) {
        Intrinsics.m26847b(viewGroup, "parent");
        return (android.support.v7.widget.RecyclerView.ViewHolder) new ViewHolder(this, ViewGroupsKt.m24100a(viewGroup, C1761R.layout.listitem_modtool_action, false));
    }

    public final /* synthetic */ void m29735a(android.support.v7.widget.RecyclerView.ViewHolder viewHolder, int i) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        Intrinsics.m26847b(viewHolder2, "holder");
        ModToolsAction modToolsAction = (ModToolsAction) this.f28535b.get(i);
        Intrinsics.m26847b(modToolsAction, "modToolsActionItem");
        ImageView imageView = (ImageView) viewHolder2.f28531b.mo5678b();
        Object obj = viewHolder2.c;
        Intrinsics.m26843a(obj, "itemView");
        Context context = obj.getContext();
        Intrinsics.m26843a((Object) context, "itemView.context");
        imageView.setImageDrawable(ResourcesUtil.m22732e(context, modToolsAction.mo4914b()));
        ((TextView) viewHolder2.f28532p.mo5678b()).setText(Util.m24027f(modToolsAction.mo4912a()));
        viewHolder2.c.setOnClickListener(new ModToolsAdapter$ViewHolder$bind$1(viewHolder2, modToolsAction));
    }

    private ModToolsAdapter(Function1<? super ModToolsAction, Unit> function1) {
        Intrinsics.m26847b(function1, "onItemClick");
        this.f28534a = function1;
        this.f28535b = ArraysKt___ArraysKt.m36109i((Object[]) ModToolsAction.values());
    }

    public ModToolsAdapter(Function1<? super ModToolsAction, Unit> function1, List<? extends ModToolsAction> list) {
        Intrinsics.m26847b(function1, "onItemClick");
        Intrinsics.m26847b(list, "menuItems");
        this(function1);
        this.f28535b = list;
    }

    public final int m29733a() {
        return this.f28535b.size();
    }
}
