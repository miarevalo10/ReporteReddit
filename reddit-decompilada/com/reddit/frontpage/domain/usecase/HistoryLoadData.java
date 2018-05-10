package com.reddit.frontpage.domain.usecase;

import com.reddit.datalibrary.frontpage.data.model.Listing;
import com.reddit.frontpage.domain.model.Link;
import com.reddit.frontpage.domain.repository.LinkRepository;
import com.reddit.frontpage.domain.repository.PreferenceRepository;
import com.reddit.frontpage.presentation.listing.history.HistorySortType;
import io.reactivex.Single;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u001c\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004H\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/reddit/frontpage/domain/usecase/HistoryLoadData;", "Lcom/reddit/frontpage/domain/usecase/SingleUseCase;", "Lcom/reddit/datalibrary/frontpage/data/model/Listing;", "Lcom/reddit/frontpage/domain/model/Link;", "Lcom/reddit/frontpage/domain/usecase/HistoryLoadDataParams;", "linkRepository", "Lcom/reddit/frontpage/domain/repository/LinkRepository;", "preferenceRepository", "Lcom/reddit/frontpage/domain/repository/PreferenceRepository;", "(Lcom/reddit/frontpage/domain/repository/LinkRepository;Lcom/reddit/frontpage/domain/repository/PreferenceRepository;)V", "build", "Lio/reactivex/Single;", "params", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: HistoryLoadData.kt */
public final class HistoryLoadData extends SingleUseCase<Listing<? extends Link>, HistoryLoadDataParams> {
    private final LinkRepository f27991a;
    private final PreferenceRepository f27992b;

    public final /* synthetic */ Single mo4760a(Params params) {
        Single just;
        HistoryLoadDataParams historyLoadDataParams = (HistoryLoadDataParams) params;
        Intrinsics.m26847b(historyLoadDataParams, "params");
        if (!Intrinsics.m26845a(historyLoadDataParams.f27994b, HistorySortType.f28408a) || historyLoadDataParams.f27996d) {
            just = Single.just(new RecentIds());
        } else {
            just = this.f27992b.m22474b().map(HistoryLoadData$build$getRecentIds$1.f27990a);
        }
        Object flatMap = just.flatMap(new HistoryLoadData$build$1(this, historyLoadDataParams));
        Intrinsics.m26843a(flatMap, "getRecentIds.flatMap { r…e\n        )\n      }\n    }");
        return flatMap;
    }

    @Inject
    public HistoryLoadData(LinkRepository linkRepository, PreferenceRepository preferenceRepository) {
        Intrinsics.m26847b(linkRepository, "linkRepository");
        Intrinsics.m26847b(preferenceRepository, "preferenceRepository");
        this.f27991a = linkRepository;
        this.f27992b = preferenceRepository;
    }
}
