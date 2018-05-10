package com.reddit.frontpage.presentation.geopopular.common;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.presentation.geopopular.model.GeopopularRegionPresentationModel;
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

@Metadata(bv = {1, 0, 2}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u001c\u0010\u0012\u001a\u00020\u000f2\u0014\u0010\u0013\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u000f0\u0014R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\u00068DX\u0002¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\f\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/reddit/frontpage/presentation/geopopular/common/GeopopularRegionViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "name", "Landroid/widget/TextView;", "getName", "()Landroid/widget/TextView;", "name$delegate", "Lkotlin/Lazy;", "selected", "getSelected", "selected$delegate", "bind", "", "model", "Lcom/reddit/frontpage/presentation/geopopular/model/GeopopularRegionPresentationModel;", "setOnClickListener", "action", "Lkotlin/Function1;", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: GeopopularRegionViewHolder.kt */
public class GeopopularRegionViewHolder extends ViewHolder {
    static final /* synthetic */ KProperty[] f28233a = new KProperty[]{Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(GeopopularRegionViewHolder.class), "name", "getName()Landroid/widget/TextView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(GeopopularRegionViewHolder.class), "selected", "getSelected()Landroid/widget/TextView;"))};
    public static final Companion f28234b = new Companion();
    private final Lazy f28235p = LazyKt.m26777a((Function0) new GeopopularRegionViewHolder$name$2(this));
    private final Lazy f28236q = LazyKt.m26777a((Function0) new GeopopularRegionViewHolder$selected$2(this));

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/reddit/frontpage/presentation/geopopular/common/GeopopularRegionViewHolder$Companion;", "", "()V", "newInstance", "Lcom/reddit/frontpage/presentation/geopopular/common/GeopopularRegionViewHolder;", "parent", "Landroid/view/ViewGroup;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: GeopopularRegionViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public static GeopopularRegionViewHolder m22846a(ViewGroup viewGroup) {
            Intrinsics.m26847b(viewGroup, "parent");
            Object inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C1761R.layout.listitem_geopopular_region, viewGroup, false);
            Intrinsics.m26843a(inflate, "view");
            return new GeopopularRegionViewHolder(inflate);
        }
    }

    protected final TextView m29532v() {
        return (TextView) this.f28236q.mo5678b();
    }

    public GeopopularRegionViewHolder(View view) {
        Intrinsics.m26847b(view, "view");
        super(view);
    }

    public final void m29531a(Function1<? super View, Unit> function1) {
        Intrinsics.m26847b(function1, "action");
        Object obj = this.c;
        Intrinsics.m26843a(obj, "itemView");
        obj.setOnClickListener(new C1815x5d73b792(function1));
    }

    public void mo6459a(GeopopularRegionPresentationModel geopopularRegionPresentationModel) {
        Intrinsics.m26847b(geopopularRegionPresentationModel, "model");
        ((TextView) this.f28235p.mo5678b()).setText(geopopularRegionPresentationModel.f20538a.getName());
        TextView v = m29532v();
        v.setText(geopopularRegionPresentationModel.f20540c);
        v.setCompoundDrawablesWithIntrinsicBounds(0, 0, geopopularRegionPresentationModel.f20539b, 0);
    }
}
