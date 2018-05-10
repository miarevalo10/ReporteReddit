package com.reddit.frontpage.presentation.common.ui.view.listoptions;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.presentation.common.ResourcesUtil;
import com.reddit.frontpage.util.kotlin.ViewsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u001eB%\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u0015\u001a\u00020\tH\u0016J\u001c\u0010\u0016\u001a\u00020\u00172\n\u0010\u0018\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0019\u001a\u00020\tH\u0016J\u001c\u0010\u001a\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\tH\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, d2 = {"Lcom/reddit/frontpage/presentation/common/ui/view/listoptions/ListOptionsDialogAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/reddit/frontpage/presentation/common/ui/view/listoptions/ListOptionsDialogAdapter$ListOptionsViewHolder;", "listActions", "", "Lcom/reddit/frontpage/presentation/common/ui/view/listoptions/ListOptionAction;", "dialogInterface", "Landroid/content/DialogInterface;", "selectedIndex", "", "(Ljava/util/List;Landroid/content/DialogInterface;I)V", "getDialogInterface", "()Landroid/content/DialogInterface;", "getListActions", "()Ljava/util/List;", "setListActions", "(Ljava/util/List;)V", "getSelectedIndex", "()I", "setSelectedIndex", "(I)V", "getItemCount", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ListOptionsViewHolder", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ListOptionsDialogAdapter.kt */
public final class ListOptionsDialogAdapter extends Adapter<ListOptionsViewHolder> {
    public List<ListOptionAction> f28087a;
    final DialogInterface f28088b;
    int f28089c;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/reddit/frontpage/presentation/common/ui/view/listoptions/ListOptionsDialogAdapter$ListOptionsViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/reddit/frontpage/presentation/common/ui/view/listoptions/ListOptionsDialogAdapter;Landroid/view/View;)V", "bindListAction", "", "action", "Lcom/reddit/frontpage/presentation/common/ui/view/listoptions/ListOptionAction;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: ListOptionsDialogAdapter.kt */
    public final class ListOptionsViewHolder extends ViewHolder {
        final /* synthetic */ ListOptionsDialogAdapter f28086a;

        public ListOptionsViewHolder(ListOptionsDialogAdapter listOptionsDialogAdapter, View view) {
            Intrinsics.m26847b(view, "itemView");
            this.f28086a = listOptionsDialogAdapter;
            super(view);
        }
    }

    public final /* synthetic */ ViewHolder m29439a(ViewGroup viewGroup, int i) {
        Intrinsics.m26847b(viewGroup, "parent");
        Object inflate = LayoutInflater.from(viewGroup.getContext()).inflate(C1761R.layout.bottomsheet_option_item, viewGroup, false);
        Intrinsics.m26843a(inflate, "it");
        return (ViewHolder) new ListOptionsViewHolder(this, inflate);
    }

    public final /* synthetic */ void m29440a(ViewHolder viewHolder, int i) {
        Object obj;
        Drawable a;
        ListOptionsViewHolder listOptionsViewHolder = (ListOptionsViewHolder) viewHolder;
        Intrinsics.m26847b(listOptionsViewHolder, "holder");
        ListOptionAction listOptionAction = (ListOptionAction) this.f28087a.get(listOptionsViewHolder.d());
        Intrinsics.m26847b(listOptionAction, "action");
        boolean z = false;
        boolean z2 = (listOptionsViewHolder.f28086a.f28089c == -1 || listOptionAction.f20391b == null) ? false : true;
        if (listOptionsViewHolder.d() == listOptionsViewHolder.f28086a.f28089c || listOptionsViewHolder.f28086a.f28089c == -1) {
            z = true;
        }
        Context context;
        if (listOptionAction.f20391b != null) {
            obj = listOptionsViewHolder.c;
            Intrinsics.m26843a(obj, "itemView");
            context = obj.getContext();
            Intrinsics.m26843a((Object) context, "itemView.context");
            a = ResourcesUtil.m22719a(context, listOptionAction.f20391b.intValue(), (int) C1761R.attr.rdt_icon_color_selector);
        } else {
            obj = listOptionsViewHolder.c;
            Intrinsics.m26843a(obj, "itemView");
            context = obj.getContext();
            Intrinsics.m26843a((Object) context, "itemView.context");
            a = ResourcesUtil.m22718a(context, (int) C1761R.drawable.radio_checkbox_selector);
        }
        View view = listOptionsViewHolder.c;
        Object obj2 = (TextView) view.findViewById(C1761R.id.option_label);
        Intrinsics.m26843a(obj2, "option_label");
        obj2.setText(listOptionAction.f20390a);
        ((ImageView) view.findViewById(C1761R.id.icon)).setImageDrawable(a);
        obj = (ImageView) view.findViewById(C1761R.id.checkmark);
        Intrinsics.m26843a(obj, "checkmark");
        ViewsKt.m24106b((View) obj, z2);
        Object obj3 = listOptionsViewHolder.c;
        Intrinsics.m26843a(obj3, "itemView");
        obj3.setSelected(z);
        obj3 = listOptionsViewHolder.c;
        Intrinsics.m26843a(obj3, "itemView");
        obj3.setOnClickListener((OnClickListener) new C1809xe0f2a66b(new ListOptionsDialogAdapter$ListOptionsViewHolder$bindListAction$2(listOptionsViewHolder, listOptionAction)));
    }

    public ListOptionsDialogAdapter(List<ListOptionAction> list, DialogInterface dialogInterface, int i) {
        Intrinsics.m26847b(list, "listActions");
        Intrinsics.m26847b(dialogInterface, "dialogInterface");
        this.f28087a = list;
        this.f28088b = dialogInterface;
        this.f28089c = i;
    }

    public final int m29438a() {
        return this.f28087a.size();
    }
}
