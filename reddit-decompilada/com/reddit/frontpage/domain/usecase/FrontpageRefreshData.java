package com.reddit.frontpage.domain.usecase;

import com.reddit.common.rx.BackgroundThread;
import com.reddit.common.rx.Thread;
import com.reddit.datalibrary.frontpage.data.feature.ads.repo.NativeAdInfo;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.datalibrary.frontpage.data.model.Listing;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.frontpage.domain.model.ILink;
import com.reddit.frontpage.domain.repository.AdsRepository;
import com.reddit.frontpage.domain.repository.LinkRepository;
import com.reddit.frontpage.domain.repository.LinkRepository.DefaultImpls;
import com.reddit.frontpage.util.kotlin.ObservablesKt;
import com.reddit.frontpage.util.kotlin.SinglesKt;
import io.reactivex.Observable;
import io.reactivex.Single;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u000020\u0012&\u0012$\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u00060\u0002\u0012\u0004\u0012\u00020\b0\u0001B/\b\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0002\u0010\u0013J2\u0010\u0014\u001a$\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u00060\u00022\u0006\u0010\u0015\u001a\u00020\bH\u0016R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/reddit/frontpage/domain/usecase/FrontpageRefreshData;", "Lcom/reddit/frontpage/domain/usecase/AdsUseCase;", "Lkotlin/Pair;", "Lio/reactivex/Single;", "Lcom/reddit/datalibrary/frontpage/data/model/Listing;", "Lcom/reddit/frontpage/domain/model/ILink;", "Lio/reactivex/Observable;", "Lcom/reddit/datalibrary/frontpage/data/feature/ads/repo/NativeAdInfo;", "Lcom/reddit/frontpage/domain/usecase/FrontpageRefreshDataParams;", "linkRepository", "Lcom/reddit/frontpage/domain/repository/LinkRepository;", "adsRepository", "Lcom/reddit/frontpage/domain/repository/AdsRepository;", "backgroundThread", "Lcom/reddit/common/rx/BackgroundThread;", "settings", "Lcom/reddit/datalibrary/frontpage/data/feature/settings/FrontpageSettings;", "sessionManager", "Lcom/reddit/datalibrary/frontpage/redditauth/account/SessionManager;", "(Lcom/reddit/frontpage/domain/repository/LinkRepository;Lcom/reddit/frontpage/domain/repository/AdsRepository;Lcom/reddit/common/rx/BackgroundThread;Lcom/reddit/datalibrary/frontpage/data/feature/settings/FrontpageSettings;Lcom/reddit/datalibrary/frontpage/redditauth/account/SessionManager;)V", "execute", "params", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: FrontpageRefreshData.kt */
public final class FrontpageRefreshData extends AdsUseCase<Pair<? extends Single<Listing<? extends ILink>>, ? extends Observable<NativeAdInfo<?>>>, FrontpageRefreshDataParams> {
    private final LinkRepository f27984a;
    private final AdsRepository f27985b;
    private final BackgroundThread f27986c;

    @Inject
    public FrontpageRefreshData(LinkRepository linkRepository, AdsRepository adsRepository, BackgroundThread backgroundThread, FrontpageSettings frontpageSettings, SessionManager sessionManager) {
        Intrinsics.m26847b(linkRepository, "linkRepository");
        Intrinsics.m26847b(adsRepository, "adsRepository");
        Intrinsics.m26847b(backgroundThread, "backgroundThread");
        Intrinsics.m26847b(frontpageSettings, "settings");
        Intrinsics.m26847b(sessionManager, "sessionManager");
        super(frontpageSettings, sessionManager, adsRepository);
        this.f27984a = linkRepository;
        this.f27985b = adsRepository;
        this.f27986c = backgroundThread;
    }

    public final Pair<Single<Listing<ILink>>, Observable<NativeAdInfo<?>>> m29321a(FrontpageRefreshDataParams frontpageRefreshDataParams) {
        Intrinsics.m26847b(frontpageRefreshDataParams, "params");
        this.f27985b.m22403a();
        return TuplesKt.m26780a(SinglesKt.m24093a(DefaultImpls.m22407a(this.f27984a, frontpageRefreshDataParams.f33730a, frontpageRefreshDataParams.f33731b, null, null, true, frontpageRefreshDataParams.f33732c, 12), this.f27986c), ObservablesKt.m24090a(m22513a((AdsParams) frontpageRefreshDataParams), (Thread) this.f27986c));
    }
}
