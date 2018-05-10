package com.reddit.frontpage.ui.carousel;

import android.view.View;
import com.reddit.frontpage.presentation.carousel.model.LinkCarouselCollectionPresentationModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: LinkCarouselViewHolder.kt */
final class LinkCarouselViewHolder$bind$$inlined$apply$lambda$3 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ LinkCarouselViewHolder f37214a;
    final /* synthetic */ LinkCarouselCollectionPresentationModel f37215b;
    final /* synthetic */ Function1 f37216c;
    final /* synthetic */ Function3 f37217d;
    final /* synthetic */ Function3 f37218e;

    LinkCarouselViewHolder$bind$$inlined$apply$lambda$3(LinkCarouselViewHolder linkCarouselViewHolder, LinkCarouselCollectionPresentationModel linkCarouselCollectionPresentationModel, Function1 function1, Function3 function3, Function3 function32) {
        this.f37214a = linkCarouselViewHolder;
        this.f37215b = linkCarouselCollectionPresentationModel;
        this.f37216c = function1;
        this.f37217d = function3;
        this.f37218e = function32;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        this.f37217d.mo6509a(Integer.valueOf(this.f37214a.d()), this.f37215b, this.f37214a.m34939x());
        return Unit.f25273a;
    }
}
