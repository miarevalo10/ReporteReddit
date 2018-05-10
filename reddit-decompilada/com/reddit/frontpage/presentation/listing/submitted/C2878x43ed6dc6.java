package com.reddit.frontpage.presentation.listing.submitted;

import android.content.Context;
import com.reddit.frontpage.nav.Nav;
import com.reddit.frontpage.nav.Routing;
import com.reddit.frontpage.presentation.carousel.model.ICarouselItemPresentationModel;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\n¢\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "itemPosition", "", "item", "Lcom/reddit/frontpage/presentation/carousel/model/ICarouselItemPresentationModel;", "positionsSeen", "", "", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: UserSubmittedListingScreen.kt */
final class C2878x43ed6dc6 extends Lambda implements Function3<Integer, ICarouselItemPresentationModel, Set<? extends String>, Unit> {
    final /* synthetic */ Adapter f36752a;

    C2878x43ed6dc6(Adapter adapter) {
        this.f36752a = adapter;
        super(3);
    }

    public final /* synthetic */ Object mo6509a(Object obj, Object obj2, Object obj3) {
        ((Number) obj).intValue();
        ICarouselItemPresentationModel iCarouselItemPresentationModel = (ICarouselItemPresentationModel) obj2;
        Set set = (Set) obj3;
        Intrinsics.m26847b(iCarouselItemPresentationModel, "item");
        Intrinsics.m26847b(set, "positionsSeen");
        Routing.m22619a((Context) this.f36752a.f34032c.am_(), Nav.m22566b(iCarouselItemPresentationModel.mo6435b()));
        return Unit.f25273a;
    }
}
