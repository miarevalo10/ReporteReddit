package com.reddit.frontpage.ui.listing.newcard;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.reddit.frontpage.ui.listing.adapter.ListingViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/reddit/frontpage/ui/listing/newcard/BlankAdViewHolder;", "Lcom/reddit/frontpage/ui/listing/adapter/ListingViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "getCategory", "", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: BlankAdViewHolder.kt */
public final class BlankAdViewHolder extends ListingViewHolder {
    public static final Companion f34374a = new Companion();

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/reddit/frontpage/ui/listing/newcard/BlankAdViewHolder$Companion;", "", "()V", "create", "Lcom/reddit/frontpage/ui/listing/newcard/BlankAdViewHolder;", "parent", "Landroid/view/ViewGroup;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: BlankAdViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public static BlankAdViewHolder m23466a(ViewGroup viewGroup) {
            Intrinsics.m26847b(viewGroup, "parent");
            View view = new View(viewGroup.getContext());
            view.setBackgroundColor(0);
            view.setLayoutParams(new LayoutParams(-1, 1));
            return new BlankAdViewHolder(view);
        }
    }

    public static final BlankAdViewHolder m35108a(ViewGroup viewGroup) {
        return Companion.m23466a(viewGroup);
    }

    public final int mo6480Q() {
        return 13;
    }

    private BlankAdViewHolder(View view) {
        super(view);
    }
}
