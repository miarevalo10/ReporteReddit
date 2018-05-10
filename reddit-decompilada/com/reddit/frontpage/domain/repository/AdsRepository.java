package com.reddit.frontpage.domain.repository;

import com.reddit.datalibrary.frontpage.data.feature.ads.repo.AdContext;
import com.reddit.datalibrary.frontpage.data.feature.ads.repo.NativeAdInfo;
import io.reactivex.Observable;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, d2 = {"Lcom/reddit/frontpage/domain/repository/AdsRepository;", "", "loadAdsBatch", "Lio/reactivex/Observable;", "Lcom/reddit/datalibrary/frontpage/data/feature/ads/repo/NativeAdInfo;", "adContext", "Lcom/reddit/datalibrary/frontpage/data/feature/ads/repo/AdContext;", "batchSize", "", "restart", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: AdsRepository.kt */
public interface AdsRepository {
    Observable<NativeAdInfo<?>> m22402a(AdContext adContext, int i);

    void m22403a();
}
