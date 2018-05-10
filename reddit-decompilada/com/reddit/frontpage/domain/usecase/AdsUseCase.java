package com.reddit.frontpage.domain.usecase;

import com.reddit.datalibrary.frontpage.data.feature.ads.repo.NativeAdInfo;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.frontpage.domain.repository.AdsRepository;
import io.reactivex.Observable;
import io.reactivex.Single;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0001*\n\b\u0001\u0010\u0002 \u0000*\u00020\u00032\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0004B\u001d\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u001a\u0010\f\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u0003H\u0004R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/reddit/frontpage/domain/usecase/AdsUseCase;", "T", "P", "Lcom/reddit/frontpage/domain/usecase/AdsParams;", "Lcom/reddit/frontpage/domain/usecase/UseCase;", "settings", "Lcom/reddit/datalibrary/frontpage/data/feature/settings/FrontpageSettings;", "sessionManager", "Lcom/reddit/datalibrary/frontpage/redditauth/account/SessionManager;", "adsRepository", "Lcom/reddit/frontpage/domain/repository/AdsRepository;", "(Lcom/reddit/datalibrary/frontpage/data/feature/settings/FrontpageSettings;Lcom/reddit/datalibrary/frontpage/redditauth/account/SessionManager;Lcom/reddit/frontpage/domain/repository/AdsRepository;)V", "getAds", "Lio/reactivex/Observable;", "Lcom/reddit/datalibrary/frontpage/data/feature/ads/repo/NativeAdInfo;", "params", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: AdsUseCase.kt */
public abstract class AdsUseCase<T, P extends AdsParams> {
    private final FrontpageSettings f20269a;
    private final SessionManager f20270b;
    private final AdsRepository f20271c;

    public AdsUseCase(FrontpageSettings frontpageSettings, SessionManager sessionManager, AdsRepository adsRepository) {
        Intrinsics.m26847b(frontpageSettings, "settings");
        Intrinsics.m26847b(sessionManager, "sessionManager");
        Intrinsics.m26847b(adsRepository, "adsRepository");
        this.f20269a = frontpageSettings;
        this.f20270b = sessionManager;
        this.f20271c = adsRepository;
    }

    protected final Observable<NativeAdInfo<?>> m22513a(AdsParams adsParams) {
        Intrinsics.m26847b(adsParams, "params");
        Object flatMapObservable = Single.fromCallable(new AdsUseCase$getAds$1(this)).flatMapObservable(new AdsUseCase$getAds$2(this, adsParams));
        Intrinsics.m26843a(flatMapObservable, "Single.fromCallable {\n  …)\n            }\n        }");
        return flatMapObservable;
    }
}
