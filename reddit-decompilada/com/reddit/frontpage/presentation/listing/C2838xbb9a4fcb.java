package com.reddit.frontpage.presentation.listing;

import com.reddit.frontpage.presentation.carousel.model.LinkCarouselItemPresentationModel;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\n¢\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "carouselItemPosition", "", "item", "Lcom/reddit/frontpage/presentation/carousel/model/LinkCarouselItemPresentationModel;", "idsSeen", "", "", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: FrontpageListingScreen.kt */
final class C2838xbb9a4fcb extends Lambda implements Function3<Integer, LinkCarouselItemPresentationModel, Set<? extends String>, Unit> {
    final /* synthetic */ FrontpageLinkAdapter f36487a;
    final /* synthetic */ int f36488b;

    C2838xbb9a4fcb(FrontpageLinkAdapter frontpageLinkAdapter, int i) {
        this.f36487a = frontpageLinkAdapter;
        this.f36488b = i;
        super(3);
    }

    public final /* synthetic */ Object mo6509a(Object obj, Object obj2, Object obj3) {
        obj = ((Number) obj).intValue();
        LinkCarouselItemPresentationModel linkCarouselItemPresentationModel = (LinkCarouselItemPresentationModel) obj2;
        Set set = (Set) obj3;
        Intrinsics.m26847b(linkCarouselItemPresentationModel, "item");
        Intrinsics.m26847b(set, "idsSeen");
        this.f36487a.f36504p.mo6942a(Integer.valueOf(this.f36488b), Integer.valueOf(obj), linkCarouselItemPresentationModel, set);
        return Unit.f25273a;
    }
}
