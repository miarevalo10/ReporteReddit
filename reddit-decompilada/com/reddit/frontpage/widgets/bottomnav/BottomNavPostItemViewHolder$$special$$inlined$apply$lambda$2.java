package com.reddit.frontpage.widgets.bottomnav;

import android.graphics.drawable.LayerDrawable;
import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: BottomNavPostItemViewHolder.kt */
final class BottomNavPostItemViewHolder$$special$$inlined$apply$lambda$2 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ BottomNavPostItemViewHolder f37439a;
    final /* synthetic */ LayerDrawable f37440b;

    BottomNavPostItemViewHolder$$special$$inlined$apply$lambda$2(BottomNavPostItemViewHolder bottomNavPostItemViewHolder, LayerDrawable layerDrawable) {
        this.f37439a = bottomNavPostItemViewHolder;
        this.f37440b = layerDrawable;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        obj = this.f37439a.f21971g.getOnItemSelectedListener();
        if (obj != null) {
            obj.mo4942a(this.f37439a.f21968d, this.f37439a.f21971g.getSelectedItem());
        }
        return Unit.f25273a;
    }
}
