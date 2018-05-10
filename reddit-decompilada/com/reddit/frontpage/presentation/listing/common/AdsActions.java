package com.reddit.frontpage.presentation.listing.common;

import com.reddit.datalibrary.frontpage.data.feature.ads.repo.NativeAdInfo;
import com.reddit.datalibrary.frontpage.requests.models.v2.Listable;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J.\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0010\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH&J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H&¨\u0006\u000f"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/common/AdsActions;", "", "destroyAds", "", "insertAds", "", "", "ads", "", "Lcom/reddit/datalibrary/frontpage/data/feature/ads/repo/NativeAdInfo;", "models", "", "Lcom/reddit/datalibrary/frontpage/requests/models/v2/Listable;", "nextBatchSize", "currentListingSize", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: AdsActions.kt */
public interface AdsActions {
    int mo4840a(int i);

    Set<Integer> mo4841a(List<? extends NativeAdInfo<?>> list, List<Listable> list2);

    void mo4842a();
}
