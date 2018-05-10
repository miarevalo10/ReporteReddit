package com.reddit.frontpage.ui.submit.adapter;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import com.raizlabs.android.dbflow.structure.Model;
import com.reddit.datalibrary.frontpage.data.provider.LoaderProvider;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00010\u00042\b\u0012\u0004\u0012\u0002H\u00030\u0005B\u0007\b\u0016¢\u0006\u0002\u0010\u0006B\u001b\u0012\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0002\u0010\nJ\u0014\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\fJ\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0011H\u0016J\u001d\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00028\u00012\u0006\u0010\u0013\u001a\u00020\u0011H&¢\u0006\u0002\u0010\u0016J\u001d\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00028\u00012\u0006\u0010\u0013\u001a\u00020\u0011H\u0016¢\u0006\u0002\u0010\u0016J\u001e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\fH\u0002R\u001c\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/reddit/frontpage/ui/submit/adapter/LoaderProviderRecyclerViewAdapter;", "M", "Lcom/raizlabs/android/dbflow/structure/Model;", "V", "Lcom/reddit/frontpage/ui/submit/adapter/LoaderProviderViewHolder;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "()V", "idProperty", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;)V", "provider", "Lcom/reddit/datalibrary/frontpage/data/provider/LoaderProvider;", "changeLoader", "", "newProvider", "getItemCount", "", "getItemId", "position", "onBindLoaderViewHolder", "holder", "(Lcom/reddit/frontpage/ui/submit/adapter/LoaderProviderViewHolder;I)V", "onBindViewHolder", "swapProvider", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: LoaderProviderRecyclerViewAdapter.kt */
public abstract class LoaderProviderRecyclerViewAdapter<M extends Model, V extends LoaderProviderViewHolder<M>> extends Adapter<V> {
    private final Function1<M, Long> f29344a;
    public LoaderProvider<M> f29345b;

    public abstract void mo6529a(V v);

    public final /* synthetic */ void m30405a(ViewHolder viewHolder, int i) {
        LoaderProviderViewHolder loaderProviderViewHolder = (LoaderProviderViewHolder) viewHolder;
        Intrinsics.m26847b(loaderProviderViewHolder, "holder");
        LoaderProvider loaderProvider = this.f29345b;
        if (loaderProvider != null) {
            i = loaderProvider.a(i);
            if (i != 0) {
                Intrinsics.m26847b(i, "<set-?>");
                loaderProviderViewHolder.f29346a = i;
                mo6529a(loaderProviderViewHolder);
                return;
            }
        }
        throw ((Throwable) new IllegalStateException("Should be only called when provider valid"));
    }

    public final int m30403a() {
        LoaderProvider loaderProvider = this.f29345b;
        return loaderProvider != null ? loaderProvider.c() : 0;
    }

    public final long m30404a(int i) {
        if (!d()) {
            return super.a(i);
        }
        LoaderProvider loaderProvider = this.f29345b;
        if (loaderProvider != null) {
            i = loaderProvider.a(i);
            if (i != 0) {
                Function1 function1 = this.f29344a;
                i = function1 != null ? (Long) function1.mo6492a(i) : 0;
                if (i != 0) {
                    return i.longValue();
                }
            }
        }
        return -1;
    }
}
