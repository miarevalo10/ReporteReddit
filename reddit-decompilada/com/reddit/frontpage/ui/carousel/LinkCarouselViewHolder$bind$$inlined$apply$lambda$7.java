package com.reddit.frontpage.ui.carousel;

import com.reddit.frontpage.presentation.carousel.model.LinkCarouselCollectionPresentationModel;
import com.reddit.frontpage.presentation.carousel.model.LinkCarouselItemPresentationModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "position", "", "item", "Lcom/reddit/frontpage/presentation/carousel/model/LinkCarouselItemPresentationModel;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: LinkCarouselViewHolder.kt */
final class LinkCarouselViewHolder$bind$$inlined$apply$lambda$7 extends Lambda implements Function2<Integer, LinkCarouselItemPresentationModel, Unit> {
    final /* synthetic */ LinkCarouselViewHolder f37234a;
    final /* synthetic */ Function3 f37235b;
    final /* synthetic */ Function3 f37236c;
    final /* synthetic */ Function3 f37237d;
    final /* synthetic */ LinkCarouselCollectionPresentationModel f37238e;

    LinkCarouselViewHolder$bind$$inlined$apply$lambda$7(LinkCarouselViewHolder linkCarouselViewHolder, Function3 function3, Function3 function32, Function3 function33, LinkCarouselCollectionPresentationModel linkCarouselCollectionPresentationModel) {
        this.f37234a = linkCarouselViewHolder;
        this.f37235b = function3;
        this.f37236c = function32;
        this.f37237d = function33;
        this.f37238e = linkCarouselCollectionPresentationModel;
        super(2);
    }

    public final /* synthetic */ Object mo6497a(Object obj, Object obj2) {
        obj = ((Number) obj).intValue();
        LinkCarouselItemPresentationModel linkCarouselItemPresentationModel = (LinkCarouselItemPresentationModel) obj2;
        Intrinsics.m26847b(linkCarouselItemPresentationModel, "item");
        Function3 function3 = this.f37236c;
        if (function3 != null) {
            function3.mo6509a(Integer.valueOf(obj), linkCarouselItemPresentationModel, this.f37234a.m34939x());
        }
        return Unit.f25273a;
    }
}
