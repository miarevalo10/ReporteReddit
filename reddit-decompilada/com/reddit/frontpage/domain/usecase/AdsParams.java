package com.reddit.frontpage.domain.usecase;

import com.reddit.datalibrary.frontpage.data.feature.ads.repo.AdContext;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/reddit/frontpage/domain/usecase/AdsParams;", "Lcom/reddit/frontpage/domain/usecase/Params;", "adContext", "Lcom/reddit/datalibrary/frontpage/data/feature/ads/repo/AdContext;", "getAdContext", "()Lcom/reddit/datalibrary/frontpage/data/feature/ads/repo/AdContext;", "adsBatchSize", "", "getAdsBatchSize", "()I", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: AdsUseCase.kt */
public interface AdsParams extends Params {
    AdContext mo6430a();

    int mo6431b();
}
