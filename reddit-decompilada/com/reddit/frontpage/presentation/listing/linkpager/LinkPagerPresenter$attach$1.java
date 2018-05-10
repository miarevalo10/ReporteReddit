package com.reddit.frontpage.presentation.listing.linkpager;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "selectedIndex", "", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: LinkPagerPresenter.kt */
final class LinkPagerPresenter$attach$1 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ LinkPagerPresenter f36688a;

    LinkPagerPresenter$attach$1(LinkPagerPresenter linkPagerPresenter) {
        this.f36688a = linkPagerPresenter;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        int intValue = ((Number) obj).intValue();
        this.f36688a.f33935d = true;
        this.f36688a.f33936e = intValue;
        this.f36688a.f33937f.mo7364d();
        this.f36688a.f33937f.mo7360a(this.f36688a.f33936e);
        return Unit.f25273a;
    }
}
