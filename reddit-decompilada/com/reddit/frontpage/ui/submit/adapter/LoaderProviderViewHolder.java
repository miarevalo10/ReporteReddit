package com.reddit.frontpage.ui.submit.adapter;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.raizlabs.android.dbflow.structure.Model;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00028\u0000¢\u0006\u0002\u0010\u0007R\u001c\u0010\u0006\u001a\u00028\u0000X\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/reddit/frontpage/ui/submit/adapter/LoaderProviderViewHolder;", "T", "Lcom/raizlabs/android/dbflow/structure/Model;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "item", "(Landroid/view/View;Lcom/raizlabs/android/dbflow/structure/Model;)V", "getItem", "()Lcom/raizlabs/android/dbflow/structure/Model;", "setItem", "(Lcom/raizlabs/android/dbflow/structure/Model;)V", "Lcom/raizlabs/android/dbflow/structure/Model;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: LoaderProviderViewHolder.kt */
public abstract class LoaderProviderViewHolder<T extends Model> extends ViewHolder {
    public T f29346a;

    public LoaderProviderViewHolder(View view, T t) {
        Intrinsics.m26847b(view, "itemView");
        Intrinsics.m26847b(t, "item");
        super(view);
        this.f29346a = t;
    }
}
