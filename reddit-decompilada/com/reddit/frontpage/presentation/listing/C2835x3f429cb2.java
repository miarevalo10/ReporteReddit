package com.reddit.frontpage.presentation.listing;

import android.support.v7.widget.RecyclerView.ViewHolder;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0015\u0010\u0002\u001a\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "p1", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "Lkotlin/ParameterName;", "name", "holder", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: FrontpageListingScreen.kt */
final class C2835x3f429cb2 extends FunctionReference implements Function1<ViewHolder, Integer> {
    C2835x3f429cb2(FrontpageLinkAdapter frontpageLinkAdapter) {
        super(1, frontpageLinkAdapter);
    }

    public final KDeclarationContainer mo6931a() {
        return Reflection.m26850a(FrontpageLinkAdapter.class);
    }

    public final String mo5687b() {
        return "getUnadjustedLinkPosition";
    }

    public final String mo6932c() {
        return "getUnadjustedLinkPosition(Landroid/support/v7/widget/RecyclerView$ViewHolder;)I";
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        ViewHolder viewHolder = (ViewHolder) obj;
        Intrinsics.m26847b(viewHolder, "p1");
        return Integer.valueOf(((FrontpageLinkAdapter) this.b).mo6471d(viewHolder));
    }
}
