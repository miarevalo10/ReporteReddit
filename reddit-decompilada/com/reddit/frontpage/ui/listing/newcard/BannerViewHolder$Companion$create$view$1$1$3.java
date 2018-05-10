package com.reddit.frontpage.ui.listing.newcard;

import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.view.View;
import android.widget.TextView;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.util.kotlin.ContextsKt;
import com.reddit.frontpage.util.kotlin.TextViewsKt;
import com.reddit.frontpage.widgets.DrawableTextView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.anko.DimensionsKt;
import org.jetbrains.anko.Sdk21PropertiesKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/reddit/frontpage/widgets/DrawableTextView;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: BannerViewHolder.kt */
final class BannerViewHolder$Companion$create$view$1$1$3 extends Lambda implements Function1<DrawableTextView, Unit> {
    public static final BannerViewHolder$Companion$create$view$1$1$3 f37294a = new BannerViewHolder$Companion$create$view$1$1$3();

    BannerViewHolder$Companion$create$view$1$1$3() {
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        DrawableTextView drawableTextView = (DrawableTextView) obj;
        Intrinsics.m26847b(drawableTextView, "$receiver");
        TextView textView = drawableTextView;
        TextViewsKt.m24095a(textView, (int) C1761R.style.TextAppearance.RedditBase.Metadata);
        Object context = drawableTextView.getContext();
        Intrinsics.m26843a(context, "context");
        Sdk21PropertiesKt.m28412a(textView, ContextsKt.m24075a(context, C1761R.color.rdt_white));
        drawableTextView.setIncludeFontPadding(false);
        Object context2 = drawableTextView.getContext();
        Intrinsics.m26843a(context2, "context");
        Drawable b = ContextsKt.m24078b(context2);
        context = drawableTextView.getContext();
        Intrinsics.m26843a(context, "context");
        DrawableCompat.a(b, ContextsKt.m24075a(context, C1761R.color.rdt_white));
        drawableTextView.setCompoundDrawablesRelative(null, null, b, null);
        View view = drawableTextView;
        drawableTextView.setCompoundDrawableSize(DimensionsKt.m28408a(view.getContext(), C1761R.dimen.icon_ind_size));
        drawableTextView.setCompoundDrawablePadding(DimensionsKt.m28408a(view.getContext(), C1761R.dimen.half_pad));
        return Unit.f25273a;
    }
}
