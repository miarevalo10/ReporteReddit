package com.reddit.frontpage.ui.carousel;

import android.view.View;
import android.widget.TextView;
import com.reddit.frontpage.C1761R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: LinkCarouselItemViewHolder.kt */
final class LinkCarouselItemViewHolder$bindTextLink$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ View f37201a;

    LinkCarouselItemViewHolder$bindTextLink$1$1(View view) {
        this.f37201a = view;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        Object obj = (TextView) this.f37201a.findViewById(C1761R.id.text_link_body);
        Intrinsics.m26843a(obj, "text_link_body");
        int height = obj.getHeight();
        Object obj2 = (TextView) this.f37201a.findViewById(C1761R.id.text_link_body);
        Intrinsics.m26843a(obj2, "text_link_body");
        height /= obj2.getLineHeight();
        obj2 = (TextView) this.f37201a.findViewById(C1761R.id.text_link_body);
        Intrinsics.m26843a(obj2, "text_link_body");
        obj2.setMaxLines(height);
        return Unit.f25273a;
    }
}
