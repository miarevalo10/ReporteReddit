package com.reddit.frontpage.presentation.geopopular.common;

import android.widget.TextView;
import com.reddit.frontpage.C1761R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: GeopopularRegionViewHolder.kt */
final class GeopopularRegionViewHolder$selected$2 extends Lambda implements Function0<TextView> {
    final /* synthetic */ GeopopularRegionViewHolder f36464a;

    GeopopularRegionViewHolder$selected$2(GeopopularRegionViewHolder geopopularRegionViewHolder) {
        this.f36464a = geopopularRegionViewHolder;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        Object obj = this.f36464a.c;
        Intrinsics.m26843a(obj, "itemView");
        return (TextView) obj.findViewById(C1761R.id.selected);
    }
}
