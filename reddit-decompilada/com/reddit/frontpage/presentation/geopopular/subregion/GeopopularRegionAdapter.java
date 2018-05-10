package com.reddit.frontpage.presentation.geopopular.subregion;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.domain.model.Region;
import com.reddit.frontpage.presentation.geopopular.common.GeopopularRegionViewHolder;
import com.reddit.frontpage.presentation.geopopular.common.GeopopularRegionViewHolder.Companion;
import com.reddit.frontpage.presentation.geopopular.model.GeopopularRegionPresentationModel;
import com.reddit.frontpage.util.Util;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001fB5\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010\u0014\u001a\u00020\rH\u0016J\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\rH\u0016J\u0018\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\rH\u0016J\u0018\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\rH\u0016J\u0014\u0010\u001d\u001a\u00020\u00062\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u001eR\u000e\u0010\f\u001a\u00020\rXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rXD¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0013X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/reddit/frontpage/presentation/geopopular/subregion/GeopopularRegionAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/reddit/frontpage/presentation/geopopular/common/GeopopularRegionViewHolder;", "onRegionClicked", "Lkotlin/Function1;", "Lcom/reddit/frontpage/presentation/geopopular/model/GeopopularRegionPresentationModel;", "", "onAllClicked", "Lkotlin/Function0;", "parentIsPreviouslySelected", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Z)V", "ALL_ITEM_POSITION", "", "CONTAINS_HEADER_ITEM_INSERT_POSITION", "ITEM_VIEW_TYPE_ALL", "ITEM_VIEW_TYPE_REGION", "NO_HEADER_ITEM_INSERT_POSITION", "items", "", "getItemCount", "getItemViewType", "position", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setItems", "", "AllViewHolder", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: GeopopularRegionAdapter.kt */
public final class GeopopularRegionAdapter extends Adapter<GeopopularRegionViewHolder> {
    private final int f28253a;
    private final int f28254b;
    private final int f28255c;
    private final int f28256f;
    private final int f28257g;
    private final List<GeopopularRegionPresentationModel> f28258h;
    private final Function1<GeopopularRegionPresentationModel, Unit> f28259i;
    private final Function0<Unit> f28260j;
    private final boolean f28261k;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/reddit/frontpage/presentation/geopopular/subregion/GeopopularRegionAdapter$AllViewHolder;", "Lcom/reddit/frontpage/presentation/geopopular/common/GeopopularRegionViewHolder;", "view", "Landroid/view/View;", "(Lcom/reddit/frontpage/presentation/geopopular/subregion/GeopopularRegionAdapter;Landroid/view/View;)V", "bind", "", "model", "Lcom/reddit/frontpage/presentation/geopopular/model/GeopopularRegionPresentationModel;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: GeopopularRegionAdapter.kt */
    private final class AllViewHolder extends GeopopularRegionViewHolder {
        final /* synthetic */ GeopopularRegionAdapter f33873p;

        public AllViewHolder(GeopopularRegionAdapter geopopularRegionAdapter, View view) {
            Intrinsics.m26847b(view, "view");
            this.f33873p = geopopularRegionAdapter;
            super(view);
        }

        public final void mo6459a(GeopopularRegionPresentationModel geopopularRegionPresentationModel) {
            Intrinsics.m26847b(geopopularRegionPresentationModel, "model");
            super.mo6459a(geopopularRegionPresentationModel);
            TextView v = m29532v();
            v.setText("");
            v.setCompoundDrawablesWithIntrinsicBounds(0, 0, geopopularRegionPresentationModel.f20541d != null ? C1761R.drawable.radio_checked : C1761R.drawable.radio_unchecked, 0);
            m29531a((Function1) new GeopopularRegionAdapter$AllViewHolder$bind$2(this));
        }
    }

    public final /* synthetic */ ViewHolder m29542a(ViewGroup viewGroup, int i) {
        Intrinsics.m26847b(viewGroup, "parent");
        if (i == this.f28254b) {
            i = GeopopularRegionViewHolder.f28234b;
            viewGroup = Companion.m22846a(viewGroup);
        } else if (i == this.f28253a) {
            Object inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C1761R.layout.listitem_geopopular_region_all, viewGroup, false);
            Intrinsics.m26843a(inflate, "LayoutInflater.from(pare…egion_all, parent, false)");
            viewGroup = (GeopopularRegionViewHolder) new AllViewHolder(this, inflate);
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(i);
            stringBuilder.append(" not supported");
            throw ((Throwable) new IllegalStateException(stringBuilder.toString()));
        }
        return (ViewHolder) viewGroup;
    }

    public final /* synthetic */ void m29543a(ViewHolder viewHolder, int i) {
        GeopopularRegionViewHolder geopopularRegionViewHolder = (GeopopularRegionViewHolder) viewHolder;
        Intrinsics.m26847b(geopopularRegionViewHolder, "holder");
        geopopularRegionViewHolder.m29531a((Function1) new GeopopularRegionAdapter$onBindViewHolder$$inlined$apply$lambda$1(this, i));
        geopopularRegionViewHolder.mo6459a((GeopopularRegionPresentationModel) this.f28258h.get(i));
    }

    public GeopopularRegionAdapter(Function1<? super GeopopularRegionPresentationModel, Unit> function1, Function0<Unit> function0, boolean z) {
        Intrinsics.m26847b(function1, "onRegionClicked");
        this.f28259i = function1;
        this.f28260j = function0;
        this.f28261k = z;
        this.f28253a = 1;
        this.f28254b = 2;
        this.f28257g = 1;
        this.f28258h = (List) new ArrayList();
    }

    public final void m29544a(List<GeopopularRegionPresentationModel> list) {
        int i;
        Intrinsics.m26847b(list, "items");
        List list2 = this.f28258h;
        list2.clear();
        if (this.f28260j != null) {
            Object f = Util.m24027f((int) C1761R.string.subregion_parent_title);
            Intrinsics.m26843a(f, "Util.getString(R.string.subregion_parent_title)");
            list2.add(new GeopopularRegionPresentationModel(new Region("", f, CollectionsKt__CollectionsKt.m26790a(), ""), this.f28261k));
        }
        if (this.f28260j == null) {
            i = this.f28256f;
        } else {
            i = this.f28257g;
        }
        list2.addAll(i, list);
    }

    public final int m29545b(int i) {
        if (this.f28260j == null || i != this.f28255c) {
            return this.f28254b;
        }
        return this.f28253a;
    }

    public final int m29541a() {
        return this.f28258h.size();
    }
}
