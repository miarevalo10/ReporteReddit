package com.reddit.frontpage.presentation.listing;

import com.reddit.frontpage.presentation.carousel.model.LinkCarouselCollectionPresentationModel;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\n¢\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "carouselPosition", "", "item", "Lcom/reddit/frontpage/presentation/carousel/model/LinkCarouselCollectionPresentationModel;", "idsSeen", "", "", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: FrontpageListingScreen.kt */
final class C2837x3f429cb4 extends Lambda implements Function3<Integer, LinkCarouselCollectionPresentationModel, Set<? extends String>, Unit> {
    final /* synthetic */ FrontpageLinkAdapter f36485a;
    final /* synthetic */ int f36486b;

    C2837x3f429cb4(FrontpageLinkAdapter frontpageLinkAdapter, int i) {
        this.f36485a = frontpageLinkAdapter;
        this.f36486b = i;
        super(3);
    }

    public final /* synthetic */ Object mo6509a(Object obj, Object obj2, Object obj3) {
        ((Number) obj).intValue();
        LinkCarouselCollectionPresentationModel linkCarouselCollectionPresentationModel = (LinkCarouselCollectionPresentationModel) obj2;
        Set set = (Set) obj3;
        Intrinsics.m26847b(linkCarouselCollectionPresentationModel, "item");
        Intrinsics.m26847b(set, "idsSeen");
        this.f36485a.f36509u.mo6509a(Integer.valueOf(this.f36486b), linkCarouselCollectionPresentationModel, set);
        return Unit.f25273a;
    }
}
