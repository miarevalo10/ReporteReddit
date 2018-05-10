package com.reddit.frontpage.domain.usecase;

import com.reddit.datalibrary.frontpage.data.feature.common.SortTimeFrame;
import com.reddit.datalibrary.frontpage.data.feature.common.SortType;
import com.reddit.datalibrary.frontpage.data.model.Listing;
import com.reddit.frontpage.domain.model.Link;
import com.reddit.frontpage.domain.repository.LinkRepository;
import com.reddit.frontpage.presentation.listing.model.ListingViewMode;
import io.reactivex.Single;
import kotlin.Metadata;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00012\u0015\u0010\u0004\u001a\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b2\u0017\u0010\t\u001a\u0013\u0018\u00010\n¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000b2\u0017\u0010\f\u001a\u0013\u0018\u00010\r¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000e2\u0017\u0010\u000f\u001a\u0013\u0018\u00010\r¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u00102\u0015\u0010\u0011\u001a\u00110\u0012¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u00132\u0017\u0010\u0014\u001a\u0013\u0018\u00010\u0015¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0016¢\u0006\u0002\b\u0017"}, d2 = {"<anonymous>", "Lio/reactivex/Single;", "Lcom/reddit/datalibrary/frontpage/data/model/Listing;", "Lcom/reddit/frontpage/domain/model/Link;", "p1", "Lcom/reddit/datalibrary/frontpage/data/feature/common/SortType;", "Lkotlin/ParameterName;", "name", "sort", "p2", "Lcom/reddit/datalibrary/frontpage/data/feature/common/SortTimeFrame;", "sortTimeFrame", "p3", "", "after", "p4", "adDistance", "p5", "", "refresh", "p6", "Lcom/reddit/frontpage/presentation/listing/model/ListingViewMode;", "viewMode", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: LinkPagerLoadData.kt */
final class LinkPagerLoadData$getStandardResultFunction$fetch$2 extends FunctionReference implements Function6<SortType, SortTimeFrame, String, String, Boolean, ListingViewMode, Single<Listing<? extends Link>>> {
    LinkPagerLoadData$getStandardResultFunction$fetch$2(LinkRepository linkRepository) {
        super(6, linkRepository);
    }

    public final KDeclarationContainer mo6931a() {
        return Reflection.m26850a(LinkRepository.class);
    }

    public final String mo5687b() {
        return "getPopular";
    }

    public final String mo6932c() {
        return "getPopular(Lcom/reddit/datalibrary/frontpage/data/feature/common/SortType;Lcom/reddit/datalibrary/frontpage/data/feature/common/SortTimeFrame;Ljava/lang/String;Ljava/lang/String;ZLcom/reddit/frontpage/presentation/listing/model/ListingViewMode;)Lio/reactivex/Single;";
    }

    public final /* synthetic */ Object mo6933a(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        SortType sortType = (SortType) obj;
        SortTimeFrame sortTimeFrame = (SortTimeFrame) obj2;
        String str = (String) obj3;
        String str2 = (String) obj4;
        boolean booleanValue = ((Boolean) obj5).booleanValue();
        ListingViewMode listingViewMode = (ListingViewMode) obj6;
        Intrinsics.m26847b(sortType, "p1");
        return ((LinkRepository) this.b).m22422b(sortType, sortTimeFrame, str, str2, booleanValue, listingViewMode);
    }
}
