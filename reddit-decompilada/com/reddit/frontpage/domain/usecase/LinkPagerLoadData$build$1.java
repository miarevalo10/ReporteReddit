package com.reddit.frontpage.domain.usecase;

import com.reddit.frontpage.domain.usecase.LinkPagerLoadDataParams.HistoryParams;
import com.reddit.frontpage.domain.usecase.LinkPagerLoadDataParams.HistoryParams.LoadData;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lio/reactivex/Single;", "Lcom/reddit/datalibrary/frontpage/data/model/Listing;", "Lcom/reddit/frontpage/domain/model/Link;", "recentIds", "", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: LinkPagerLoadData.kt */
final class LinkPagerLoadData$build$1<T, R> implements Function<T, SingleSource<? extends R>> {
    final /* synthetic */ LinkPagerLoadData f27997a;
    final /* synthetic */ LinkPagerLoadDataParams f27998b;

    LinkPagerLoadData$build$1(LinkPagerLoadData linkPagerLoadData, LinkPagerLoadDataParams linkPagerLoadDataParams) {
        this.f27997a = linkPagerLoadData;
        this.f27998b = linkPagerLoadDataParams;
    }

    public final /* synthetic */ Object apply(Object obj) {
        String str = (String) obj;
        Intrinsics.m26847b(str, "recentIds");
        return LinkPagerLoadData.m29325a(this.f27997a, this.f27997a.m29327a((HistoryParams) this.f27998b), ((LoadData) this.f27998b).f36339e, 0, null, null, str, false, 92);
    }
}
