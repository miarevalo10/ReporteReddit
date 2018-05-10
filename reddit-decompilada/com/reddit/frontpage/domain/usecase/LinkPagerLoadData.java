package com.reddit.frontpage.domain.usecase;

import com.reddit.datalibrary.frontpage.data.model.Listing;
import com.reddit.frontpage.domain.model.Link;
import com.reddit.frontpage.domain.repository.LinkRepository;
import com.reddit.frontpage.domain.repository.PreferenceRepository;
import com.reddit.frontpage.domain.usecase.LinkPagerLoadDataParams.HistoryParams;
import com.reddit.frontpage.domain.usecase.LinkPagerLoadDataParams.StandardParams;
import com.reddit.frontpage.domain.usecase.LinkPagerLoadDataParams.StandardParams.LoadData;
import com.reddit.frontpage.domain.usecase.LinkPagerLoadDataParams.StandardParams.LoadMore;
import com.reddit.frontpage.presentation.listing.common.ListingType;
import com.reddit.frontpage.presentation.listing.history.HistorySortType;
import io.reactivex.Single;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u001e2 \u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0004\u0012\u00020\u00050\u0002\u0012\u0004\u0012\u00020\u00060\u0001:\u0001\u001eB\u0017\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ(\u0010\f\u001a\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0004\u0012\u00020\u00050\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006H\u0014J:\u0010\u000f\u001a,\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\r0\u00102\u0006\u0010\u000e\u001a\u00020\u0012H\u0002J\u0001\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\r20\u0010\u0014\u001a,\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\r0\u00102\b\b\u0002\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u001a\u001a\u00020\u001bH\u0002J:\u0010\u001c\u001a,\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\r0\u00102\u0006\u0010\u000e\u001a\u00020\u001dH\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/reddit/frontpage/domain/usecase/LinkPagerLoadData;", "Lcom/reddit/frontpage/domain/usecase/SingleUseCase;", "Lkotlin/Pair;", "Lcom/reddit/datalibrary/frontpage/data/model/Listing;", "Lcom/reddit/frontpage/domain/model/Link;", "", "Lcom/reddit/frontpage/domain/usecase/LinkPagerLoadDataParams;", "linkRepository", "Lcom/reddit/frontpage/domain/repository/LinkRepository;", "preferenceRepository", "Lcom/reddit/frontpage/domain/repository/PreferenceRepository;", "(Lcom/reddit/frontpage/domain/repository/LinkRepository;Lcom/reddit/frontpage/domain/repository/PreferenceRepository;)V", "build", "Lio/reactivex/Single;", "params", "getHistoryResultFunction", "Lkotlin/Function3;", "", "Lcom/reddit/frontpage/domain/usecase/LinkPagerLoadDataParams$HistoryParams;", "getLinks", "resultFunction", "position", "totalNumLinks", "after", "adDistance", "recentIds", "loadSinglePage", "", "getStandardResultFunction", "Lcom/reddit/frontpage/domain/usecase/LinkPagerLoadDataParams$StandardParams;", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: LinkPagerLoadData.kt */
public final class LinkPagerLoadData extends SingleUseCase<Pair<? extends Listing<? extends Link>, ? extends Integer>, LinkPagerLoadDataParams> {
    public static final Companion f28010a = new Companion();
    private final LinkRepository f28011b;
    private final PreferenceRepository f28012c;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/reddit/frontpage/domain/usecase/LinkPagerLoadData$Companion;", "", "()V", "UNDEFINED_POSITION", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: LinkPagerLoadData.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    @Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 9})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] f20279a;

        static {
            int[] iArr = new int[ListingType.values().length];
            f20279a = iArr;
            iArr[ListingType.f20574a.ordinal()] = 1;
            f20279a[ListingType.f20575b.ordinal()] = 2;
        }
    }

    public final /* synthetic */ Single mo4760a(Params params) {
        LinkPagerLoadDataParams linkPagerLoadDataParams = (LinkPagerLoadDataParams) params;
        Intrinsics.m26847b(linkPagerLoadDataParams, "params");
        if (Intrinsics.m26845a(linkPagerLoadDataParams.f28013a, ListingType.f20576c)) {
            throw ((Throwable) new UnsupportedOperationException("Paging user submitted posts not supported."));
        }
        Single a;
        if (linkPagerLoadDataParams instanceof LoadData) {
            a = m29325a(this, m29328a((StandardParams) linkPagerLoadDataParams), ((LoadData) linkPagerLoadDataParams).f36341e, 0, null, null, null, false, 124);
        } else if (linkPagerLoadDataParams instanceof LoadMore) {
            LoadMore loadMore = (LoadMore) linkPagerLoadDataParams;
            a = m29325a(this, m29328a((StandardParams) linkPagerLoadDataParams), 0, 0, loadMore.f36342e, loadMore.f36343f, null, true, 38);
        } else if (linkPagerLoadDataParams instanceof HistoryParams.LoadData) {
            HistoryParams.LoadData loadData = (HistoryParams.LoadData) linkPagerLoadDataParams;
            if (Intrinsics.m26845a(loadData.f33744d, HistorySortType.f28408a)) {
                a = this.f28012c.m22474b().flatMap(new LinkPagerLoadData$build$1(this, linkPagerLoadDataParams));
            } else {
                a = m29325a(this, m29327a((HistoryParams) linkPagerLoadDataParams), loadData.f36339e, 0, null, null, null, false, 124);
            }
        } else if (linkPagerLoadDataParams instanceof HistoryParams.LoadMore) {
            a = m29325a(this, m29327a((HistoryParams) linkPagerLoadDataParams), 0, 0, ((HistoryParams.LoadMore) linkPagerLoadDataParams).f36340e, null, null, true, 54);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        Object map = a.map(new LinkPagerLoadData$build$2(linkPagerLoadDataParams));
        Intrinsics.m26843a(map, "when (params) {\n      //… filtered) to index\n    }");
        return map;
    }

    @Inject
    public LinkPagerLoadData(LinkRepository linkRepository, PreferenceRepository preferenceRepository) {
        Intrinsics.m26847b(linkRepository, "linkRepository");
        Intrinsics.m26847b(preferenceRepository, "preferenceRepository");
        this.f28011b = linkRepository;
        this.f28012c = preferenceRepository;
    }

    private final Function3<String, String, String, Single<Listing<Link>>> m29327a(HistoryParams historyParams) {
        return new LinkPagerLoadData$getHistoryResultFunction$1(this, historyParams);
    }

    private final Function3<String, String, String, Single<Listing<Link>>> m29328a(StandardParams standardParams) {
        KFunction linkPagerLoadData$getStandardResultFunction$fetch$1;
        switch (WhenMappings.f20279a[standardParams.f28013a.ordinal()]) {
            case 1:
                linkPagerLoadData$getStandardResultFunction$fetch$1 = new LinkPagerLoadData$getStandardResultFunction$fetch$1(this.f28011b);
                break;
            case 2:
                linkPagerLoadData$getStandardResultFunction$fetch$1 = new LinkPagerLoadData$getStandardResultFunction$fetch$2(this.f28011b);
                break;
            default:
                StringBuilder stringBuilder = new StringBuilder("Standard paging not supported for ");
                stringBuilder.append(standardParams.f28013a.name());
                throw new UnsupportedOperationException(stringBuilder.toString());
        }
        return new LinkPagerLoadData$getStandardResultFunction$1(linkPagerLoadData$getStandardResultFunction$fetch$1, standardParams);
    }

    static /* synthetic */ Single m29325a(LinkPagerLoadData linkPagerLoadData, Function3 function3, int i, int i2, String str, String str2, String str3, boolean z, int i3) {
        Function3 function32;
        boolean z2;
        int i4 = (i3 & 2) != 0 ? -1 : i;
        int i5 = (i3 & 4) != 0 ? 0 : i2;
        Object obj = (i3 & 8) != 0 ? null : str;
        String str4 = (i3 & 16) != 0 ? null : str2;
        String str5 = (i3 & 32) != 0 ? null : str3;
        if ((i3 & 64) != 0) {
            function32 = function3;
            z2 = false;
        } else {
            function32 = function3;
            z2 = z;
        }
        Object flatMap = ((Single) function32.mo6509a(obj, str4, str5)).flatMap(new LinkPagerLoadData$getLinks$1(linkPagerLoadData, i5, z2, i4, function32, str4, str5));
        Intrinsics.m26843a(flatMap, "resultFunction(after, ad…)\n        }\n      }\n    }");
        return flatMap;
    }
}
