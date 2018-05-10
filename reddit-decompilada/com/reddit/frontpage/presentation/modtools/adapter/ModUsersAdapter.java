package com.reddit.frontpage.presentation.modtools.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.reddit.datalibrary.frontpage.data.model.ModToolsUserModel;
import com.reddit.datalibrary.frontpage.data.model.Moderator;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.presentation.common.DateUtil;
import com.reddit.frontpage.presentation.common.ResourcesUtil;
import com.reddit.frontpage.util.AvatarUtilKt;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.util.kotlin.ViewGroupsKt;
import com.reddit.frontpage.util.kotlin.ViewsKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001&B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0014\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\u0014J\u0014\u0010\u0015\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\u0014J\u0006\u0010\u0016\u001a\u00020\u0012J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u001c\u0010\u0019\u001a\u00020\u00122\n\u0010\u001a\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u0018H\u0016J\u001c\u0010\u001c\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0018H\u0016J\u000e\u0010 \u001a\u00020\u00122\u0006\u0010!\u001a\u00020\"J\u0006\u0010#\u001a\u00020\u0012J\u0006\u0010$\u001a\u00020\u0012J\u0006\u0010%\u001a\u00020\u0012R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/reddit/frontpage/presentation/modtools/adapter/ModUsersAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/reddit/frontpage/presentation/modtools/adapter/ModUsersAdapter$ViewHolder;", "modUsersAdapterAction", "Lcom/reddit/frontpage/presentation/modtools/adapter/ModUsersAdapterAction;", "modAdapterMode", "Lcom/reddit/frontpage/presentation/modtools/adapter/ModAdapterMode;", "(Lcom/reddit/frontpage/presentation/modtools/adapter/ModUsersAdapterAction;Lcom/reddit/frontpage/presentation/modtools/adapter/ModAdapterMode;)V", "currList", "", "Lcom/reddit/datalibrary/frontpage/data/model/ModToolsUserModel;", "getModAdapterMode", "()Lcom/reddit/frontpage/presentation/modtools/adapter/ModAdapterMode;", "getModUsersAdapterAction", "()Lcom/reddit/frontpage/presentation/modtools/adapter/ModUsersAdapterAction;", "primaryList", "searchList", "addToPrimaryList", "", "modUsersList", "", "addToSearchList", "clearSearchList", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "removeUser", "user", "Lcom/reddit/frontpage/presentation/modtools/ModToolsListItemModel;", "resetAdapter", "selectMainList", "selectSearchList", "ViewHolder", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ModUsersAdapter.kt */
public final class ModUsersAdapter extends Adapter<ViewHolder> {
    public List<ModToolsUserModel> f28543a = this.f28544b;
    public final List<ModToolsUserModel> f28544b = ((List) new ArrayList());
    public final List<ModToolsUserModel> f28545c = ((List) new ArrayList());
    final ModUsersAdapterAction f28546f;
    final ModAdapterMode f28547g;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001b\u0010\r\u001a\u00020\u000e8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0012\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\f\u001a\u0004\b\u0013\u0010\nR\u001b\u0010\u0015\u001a\u00020\u000e8BX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\f\u001a\u0004\b\u0016\u0010\u0010¨\u0006\u001e"}, d2 = {"Lcom/reddit/frontpage/presentation/modtools/adapter/ModUsersAdapter$ViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/reddit/frontpage/presentation/modtools/adapter/ModUsersAdapter;Landroid/view/View;)V", "DELIMITER", "", "icon", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "icon$delegate", "Lkotlin/Lazy;", "info", "Landroid/widget/TextView;", "getInfo", "()Landroid/widget/TextView;", "info$delegate", "overflow", "getOverflow", "overflow$delegate", "username", "getUsername", "username$delegate", "bind", "", "modUser", "Lcom/reddit/datalibrary/frontpage/data/model/ModToolsUserModel;", "position", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: ModUsersAdapter.kt */
    public final class ViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder {
        static final /* synthetic */ KProperty[] f28536a = new KProperty[]{Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(ViewHolder.class), "icon", "getIcon()Landroid/widget/ImageView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(ViewHolder.class), "username", "getUsername()Landroid/widget/TextView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(ViewHolder.class), "info", "getInfo()Landroid/widget/TextView;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(ViewHolder.class), "overflow", "getOverflow()Landroid/widget/ImageView;"))};
        final String f28537b = Util.m24027f((int) C1761R.string.unicode_delimiter);
        final Lazy f28538p;
        final Lazy f28539q;
        final /* synthetic */ ModUsersAdapter f28540r;
        private final Lazy f28541s;
        private final Lazy f28542t;

        final TextView m29736v() {
            return (TextView) this.f28541s.mo5678b();
        }

        final ImageView m29737w() {
            return (ImageView) this.f28542t.mo5678b();
        }

        public ViewHolder(ModUsersAdapter modUsersAdapter, View view) {
            Intrinsics.m26847b(view, "itemView");
            this.f28540r = modUsersAdapter;
            super(view);
            this.f28538p = LazyKt.m26777a((Function0) new ModUsersAdapter$ViewHolder$icon$2(view));
            this.f28539q = LazyKt.m26777a((Function0) new ModUsersAdapter$ViewHolder$username$2(view));
            this.f28541s = LazyKt.m26777a((Function0) new ModUsersAdapter$ViewHolder$info$2(view));
            this.f28542t = LazyKt.m26777a((Function0) new ModUsersAdapter$ViewHolder$overflow$2(view));
        }
    }

    public final /* synthetic */ android.support.v7.widget.RecyclerView.ViewHolder m29739a(ViewGroup viewGroup, int i) {
        Intrinsics.m26847b(viewGroup, "parent");
        return (android.support.v7.widget.RecyclerView.ViewHolder) new ViewHolder(this, ViewGroupsKt.m24100a(viewGroup, C1761R.layout.listitem_modtools_user, false));
    }

    public final /* synthetic */ void m29740a(android.support.v7.widget.RecyclerView.ViewHolder viewHolder, int i) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        Intrinsics.m26847b(viewHolder2, "holder");
        ModToolsUserModel modToolsUserModel = (ModToolsUserModel) this.f28543a.get(i);
        Intrinsics.m26847b(modToolsUserModel, "modUser");
        AvatarUtilKt.m23659a((ImageView) viewHolder2.f28538p.mo5678b(), modToolsUserModel.getAccountIcon(), null, null);
        TextView textView = (TextView) viewHolder2.f28539q.mo5678b();
        Object[] objArr = new Object[1];
        int i2 = 0;
        objArr[0] = modToolsUserModel.getUsername();
        textView.setText(Util.m23960a((int) C1761R.string.fmt_u_name, objArr));
        viewHolder2.c.setOnClickListener(new ModUsersAdapter$ViewHolder$bind$1(viewHolder2, i, modToolsUserModel));
        StringBuilder stringBuilder;
        if (Intrinsics.m26845a(viewHolder2.f28540r.f28547g, ModAdapterMode.f20863a)) {
            String str;
            textView = viewHolder2.m29736v();
            StringBuilder stringBuilder2 = new StringBuilder();
            DateUtil dateUtil = DateUtil.f20370a;
            stringBuilder2.append(DateUtil.m22706b(modToolsUserModel.getAtUtc()).toString());
            CharSequence reason = modToolsUserModel.getReason();
            if (reason == null || reason.length() == 0) {
                i2 = 1;
            }
            if (i2 != 0) {
                str = "";
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append(viewHolder2.f28537b);
                stringBuilder.append(modToolsUserModel.getReason());
                str = stringBuilder.toString();
            }
            stringBuilder2.append(str);
            textView.setText(stringBuilder2.toString());
        } else {
            Moderator moderator = (Moderator) modToolsUserModel;
            TextView v = viewHolder2.m29736v();
            stringBuilder = new StringBuilder();
            DateUtil dateUtil2 = DateUtil.f20370a;
            stringBuilder.append(DateUtil.m22706b(modToolsUserModel.getAtUtc()).toString());
            stringBuilder.append(viewHolder2.f28537b);
            stringBuilder.append(moderator.getPermissionsString());
            v.setText(stringBuilder.toString());
        }
        ImageView w = viewHolder2.m29737w();
        Object obj = viewHolder2.c;
        Intrinsics.m26843a(obj, "itemView");
        Context context = obj.getContext();
        Intrinsics.m26843a((Object) context, "itemView.context");
        Drawable drawable = viewHolder2.m29737w().getDrawable();
        Intrinsics.m26843a((Object) drawable, "overflow.drawable");
        w.setImageDrawable(ResourcesUtil.m22733e(context, drawable));
        ViewsKt.m24106b(w, Intrinsics.m26845a(viewHolder2.f28540r.f28547g, ModAdapterMode.f20864b) ^ true);
        if ((Intrinsics.m26845a(viewHolder2.f28540r.f28547g, ModAdapterMode.f20864b) ^ 1) != 0) {
            viewHolder2.m29737w().setOnClickListener(new ModUsersAdapter$ViewHolder$bind$4(viewHolder2, i, modToolsUserModel));
        }
    }

    public ModUsersAdapter(ModUsersAdapterAction modUsersAdapterAction, ModAdapterMode modAdapterMode) {
        Intrinsics.m26847b(modUsersAdapterAction, "modUsersAdapterAction");
        Intrinsics.m26847b(modAdapterMode, "modAdapterMode");
        this.f28546f = modUsersAdapterAction;
        this.f28547g = modAdapterMode;
    }

    public final void m29741b() {
        this.f28545c.clear();
        this.f28543a = this.f28544b;
        e();
    }

    public final int m29738a() {
        return this.f28543a.size();
    }
}
