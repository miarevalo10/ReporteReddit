package com.reddit.frontpage.presentation.listing.linkpager;

import com.reddit.frontpage.presentation.listing.common.ListingType;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00060\u0001R\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/reddit/frontpage/presentation/listing/linkpager/LinkPagerScreen$PagerAdapter;", "Lcom/reddit/frontpage/presentation/listing/linkpager/LinkPagerScreen;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: LinkPagerScreen.kt */
final class LinkPagerScreen$pagerAdapter$2 extends Lambda implements Function0<PagerAdapter> {
    final /* synthetic */ LinkPagerScreen f36702a;

    LinkPagerScreen$pagerAdapter$2(LinkPagerScreen linkPagerScreen) {
        this.f36702a = linkPagerScreen;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        PagerAdapter pagerAdapter = new PagerAdapter(this.f36702a);
        ListingType listingType = this.f36702a.listingType;
        if (listingType == null) {
            Intrinsics.m26844a("listingType");
        }
        String listingType2 = listingType.toString();
        Intrinsics.m26847b(listingType2, "<set-?>");
        pagerAdapter.f36699e = listingType2;
        return pagerAdapter;
    }
}
