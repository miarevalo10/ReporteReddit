package com.reddit.frontpage.ui.carousel;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: LinkCarouselItemViewHolder.kt */
final class LinkCarouselItemViewHolder$bindHeader$$inlined$apply$lambda$4 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ Boolean f37197a;
    final /* synthetic */ LinkCarouselItemViewHolder f37198b;
    final /* synthetic */ Function2 f37199c;
    final /* synthetic */ Function2 f37200d;

    LinkCarouselItemViewHolder$bindHeader$$inlined$apply$lambda$4(Boolean bool, LinkCarouselItemViewHolder linkCarouselItemViewHolder, Function2 function2, Function2 function22) {
        this.f37197a = bool;
        this.f37198b = linkCarouselItemViewHolder;
        this.f37199c = function2;
        this.f37200d = function22;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        if (this.f37198b.m29973v().f28076e == null) {
            obj = this.f37200d;
            if (obj != null) {
                obj.mo6497a(Integer.valueOf(this.f37198b.d()), this.f37198b.m29973v());
            }
        }
        return Unit.f25273a;
    }
}
