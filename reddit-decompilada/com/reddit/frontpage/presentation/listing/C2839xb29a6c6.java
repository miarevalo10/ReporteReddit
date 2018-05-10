package com.reddit.frontpage.presentation.listing;

import com.reddit.frontpage.presentation.carousel.model.LinkCarouselCollectionPresentationModel;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "idsSeen", "", "", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: FrontpageListingScreen.kt */
final class C2839xb29a6c6 extends Lambda implements Function1<Set<? extends String>, Unit> {
    final /* synthetic */ FrontpageLinkAdapter f36489a;
    final /* synthetic */ int f36490b;
    final /* synthetic */ LinkCarouselCollectionPresentationModel f36491c;

    C2839xb29a6c6(FrontpageLinkAdapter frontpageLinkAdapter, int i, LinkCarouselCollectionPresentationModel linkCarouselCollectionPresentationModel) {
        this.f36489a = frontpageLinkAdapter;
        this.f36490b = i;
        this.f36491c = linkCarouselCollectionPresentationModel;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        Set set = (Set) obj;
        Intrinsics.m26847b(set, "idsSeen");
        this.f36489a.f36507s.mo6509a(Integer.valueOf(this.f36490b), this.f36491c, set);
        return Unit.f25273a;
    }
}
