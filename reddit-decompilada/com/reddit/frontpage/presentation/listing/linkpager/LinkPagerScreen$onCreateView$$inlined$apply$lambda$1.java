package com.reddit.frontpage.presentation.listing.linkpager;

import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import com.reddit.frontpage.widgets.ScreenPager;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"com/reddit/frontpage/presentation/listing/linkpager/LinkPagerScreen$onCreateView$1$1", "Landroid/support/v4/view/ViewPager$SimpleOnPageChangeListener;", "(Lcom/reddit/frontpage/presentation/listing/linkpager/LinkPagerScreen$onCreateView$1;Lcom/reddit/frontpage/widgets/ScreenPager;)V", "onPageSelected", "", "position", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: LinkPagerScreen.kt */
public final class LinkPagerScreen$onCreateView$$inlined$apply$lambda$1 extends SimpleOnPageChangeListener {
    final /* synthetic */ ScreenPager f33946a;
    final /* synthetic */ LinkPagerScreen f33947b;

    LinkPagerScreen$onCreateView$$inlined$apply$lambda$1(ScreenPager screenPager, LinkPagerScreen linkPagerScreen) {
        this.f33946a = screenPager;
        this.f33947b = linkPagerScreen;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m34742b(int r6) {
        /*
        r5 = this;
        r0 = r5.f33946a;
        r0 = r0.getAdapter();
        if (r0 != 0) goto L_0x000b;
    L_0x0008:
        kotlin.jvm.internal.Intrinsics.m26842a();
    L_0x000b:
        r1 = "adapter!!";
        kotlin.jvm.internal.Intrinsics.m26843a(r0, r1);
        r0 = r0.m35101c();
        r0 = r0 - r6;
        r1 = 5;
        r2 = 1;
        if (r0 > r1) goto L_0x0079;
    L_0x0019:
        r0 = r5.f33947b;
        r0 = r0.f40055w;
        if (r0 != 0) goto L_0x0024;
    L_0x001f:
        r1 = "presenter";
        kotlin.jvm.internal.Intrinsics.m26844a(r1);
    L_0x0024:
        r1 = r0.f33933b;
        r1 = r1 instanceof com.reddit.frontpage.domain.usecase.LinkPagerLoadDataParams.StandardParams.LoadData;
        if (r1 != 0) goto L_0x0079;
    L_0x002a:
        r1 = r0.f33933b;
        r1 = r1 instanceof com.reddit.frontpage.domain.usecase.LinkPagerLoadDataParams.StandardParams.LoadMore;
        if (r1 == 0) goto L_0x0042;
    L_0x0030:
        r1 = r0.f33933b;
        if (r1 != 0) goto L_0x003c;
    L_0x0034:
        r6 = new kotlin.TypeCastException;
        r0 = "null cannot be cast to non-null type com.reddit.frontpage.domain.usecase.LinkPagerLoadDataParams.StandardParams.LoadMore";
        r6.<init>(r0);
        throw r6;
    L_0x003c:
        r1 = (com.reddit.frontpage.domain.usecase.LinkPagerLoadDataParams.StandardParams.LoadMore) r1;
        r1 = r1.f36342e;
        if (r1 == 0) goto L_0x0079;
    L_0x0042:
        r1 = r0.f33933b;
        r1 = r1 instanceof com.reddit.frontpage.domain.usecase.LinkPagerLoadDataParams.HistoryParams.LoadData;
        if (r1 != 0) goto L_0x0079;
    L_0x0048:
        r1 = r0.f33933b;
        r1 = r1 instanceof com.reddit.frontpage.domain.usecase.LinkPagerLoadDataParams.HistoryParams.LoadMore;
        if (r1 == 0) goto L_0x0060;
    L_0x004e:
        r1 = r0.f33933b;
        if (r1 != 0) goto L_0x005a;
    L_0x0052:
        r6 = new kotlin.TypeCastException;
        r0 = "null cannot be cast to non-null type com.reddit.frontpage.domain.usecase.LinkPagerLoadDataParams.HistoryParams.LoadMore";
        r6.<init>(r0);
        throw r6;
    L_0x005a:
        r1 = (com.reddit.frontpage.domain.usecase.LinkPagerLoadDataParams.HistoryParams.LoadMore) r1;
        r1 = r1.f36340e;
        if (r1 == 0) goto L_0x0079;
    L_0x0060:
        r1 = r0.f33932a;
        if (r1 == 0) goto L_0x0065;
    L_0x0064:
        goto L_0x0079;
    L_0x0065:
        r0.f33932a = r2;
        r1 = 0;
        r3 = new com.reddit.frontpage.presentation.listing.linkpager.LinkPagerPresenter$loadMore$1;
        r3.<init>(r0);
        r3 = (kotlin.jvm.functions.Function1) r3;
        r4 = new com.reddit.frontpage.presentation.listing.linkpager.LinkPagerPresenter$loadMore$2;
        r4.<init>(r0);
        r4 = (kotlin.jvm.functions.Function0) r4;
        com.reddit.frontpage.presentation.listing.linkpager.LinkPagerPresenter.m34733a(r0, r1, r3, r4, r2);
    L_0x0079:
        r0 = r5.f33947b;
        r1 = r6 + -1;
        com.reddit.frontpage.presentation.listing.linkpager.LinkPagerScreen.m40640a(r0, r1);
        r0 = r5.f33947b;
        com.reddit.frontpage.presentation.listing.linkpager.LinkPagerScreen.m40641b(r0, r6);
        r0 = r5.f33947b;
        r6 = r6 + r2;
        com.reddit.frontpage.presentation.listing.linkpager.LinkPagerScreen.m40640a(r0, r6);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reddit.frontpage.presentation.listing.linkpager.LinkPagerScreen$onCreateView$$inlined$apply$lambda$1.b(int):void");
    }
}
