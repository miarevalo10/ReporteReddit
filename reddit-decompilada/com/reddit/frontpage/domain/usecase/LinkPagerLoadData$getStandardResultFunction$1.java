package com.reddit.frontpage.domain.usecase;

import com.reddit.datalibrary.frontpage.data.model.Listing;
import com.reddit.frontpage.domain.model.Link;
import com.reddit.frontpage.domain.usecase.LinkPagerLoadDataParams.StandardParams;
import com.reddit.frontpage.presentation.listing.model.ListingViewMode;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KFunction;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0000\u001a>\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002 \u0004*\u001e\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\n¢\u0006\u0002\b\t"}, d2 = {"<anonymous>", "Lio/reactivex/Single;", "Lcom/reddit/datalibrary/frontpage/data/model/Listing;", "Lcom/reddit/frontpage/domain/model/Link;", "kotlin.jvm.PlatformType", "after", "", "adDistance", "<anonymous parameter 2>", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: LinkPagerLoadData.kt */
final class LinkPagerLoadData$getStandardResultFunction$1 extends Lambda implements Function3<String, String, String, Single<Listing<? extends Link>>> {
    final /* synthetic */ KFunction f36337a;
    final /* synthetic */ StandardParams f36338b;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u0001H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lcom/reddit/datalibrary/frontpage/data/model/Listing;", "Lcom/reddit/frontpage/domain/model/Link;", "it", "Lcom/reddit/frontpage/domain/model/ILink;", "apply"}, k = 3, mv = {1, 1, 9})
    /* compiled from: LinkPagerLoadData.kt */
    static final class C22911<T, R> implements Function<T, R> {
        public static final C22911 f28009a = new C22911();

        C22911() {
        }

        public final /* synthetic */ Object apply(Object obj) {
            Listing listing = (Listing) obj;
            Intrinsics.m26847b(listing, "it");
            return new Listing(CollectionsKt___CollectionsKt.m41416a((Iterable) listing.getChildren(), Link.class), listing.getAfter(), listing.getBefore(), null, 8, null);
        }
    }

    LinkPagerLoadData$getStandardResultFunction$1(KFunction kFunction, StandardParams standardParams) {
        this.f36337a = kFunction;
        this.f36338b = standardParams;
        super(3);
    }

    public final /* synthetic */ Object mo6509a(Object obj, Object obj2, Object obj3) {
        obj = ((Single) ((Function6) this.f36337a).mo6933a(this.f36338b.f33746c, this.f36338b.f33747d, (String) obj, (String) obj2, Boolean.valueOf(null), ListingViewMode.f20612a)).map((Function) C22911.f28009a);
        Intrinsics.m26843a(obj, "fetch(\n          params.….before\n        )\n      }");
        return obj;
    }
}
