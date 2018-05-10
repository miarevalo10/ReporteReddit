package com.reddit.frontpage.presentation.listing.submitted;

import android.support.v7.widget.RecyclerView.ViewHolder;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: UserSubmittedListingScreen.kt */
final class C2879x43ed6dc7 extends FunctionReference implements Function1<ViewHolder, Integer> {
    public static final C2879x43ed6dc7 f36753a = new C2879x43ed6dc7();

    C2879x43ed6dc7() {
        super(1);
    }

    public final KDeclarationContainer mo6931a() {
        return Reflection.m26850a(ViewHolder.class);
    }

    public final String mo5687b() {
        return "getAdapterPosition";
    }

    public final String mo6932c() {
        return "getAdapterPosition()I";
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        ViewHolder viewHolder = (ViewHolder) obj;
        Intrinsics.m26847b(viewHolder, "p1");
        return Integer.valueOf(viewHolder.d());
    }
}
