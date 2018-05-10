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
final class LinkCarouselViewHolder$bind$$inlined$apply$lambda$2 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ LinkCarouselViewHolder f37209a;
    final /* synthetic */ LinkCarouselCollectionPresentationModel f37210b;
    final /* synthetic */ Function1 f37211c;
    final /* synthetic */ Function3 f37212d;
    final /* synthetic */ Function3 f37213e;

    LinkCarouselViewHolder$bind$$inlined$apply$lambda$2(LinkCarouselViewHolder linkCarouselViewHolder, LinkCarouselCollectionPresentationModel linkCarouselCollectionPresentationModel, Function1 function1, Function3 function3, Function3 function32) {
        this.f37209a = linkCarouselViewHolder;
        this.f37210b = linkCarouselCollectionPresentationModel;
        this.f37211c = function1;
        this.f37212d = function3;
        this.f37213e = function32;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        this.f37212d.mo6509a(Integer.valueOf(this.f37209a.d()), this.f37210b, this.f37209a.m34939x());
        return Unit.f25273a;
    }
}
