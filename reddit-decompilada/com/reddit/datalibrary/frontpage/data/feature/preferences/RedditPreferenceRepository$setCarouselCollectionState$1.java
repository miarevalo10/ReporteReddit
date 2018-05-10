package com.reddit.datalibrary.frontpage.data.feature.preferences;

import com.reddit.frontpage.domain.repository.PreferenceRepository.CarouselCollectionStateKey;
import com.reddit.frontpage.presentation.listing.carousel.CarouselCollectionState;
import com.reddit.frontpage.util.JsonUtil;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.Unit;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "call"}, k = 3, mv = {1, 1, 9})
/* compiled from: RedditPreferenceRepository.kt */
final class RedditPreferenceRepository$setCarouselCollectionState$1<V> implements Callable<Object> {
    final /* synthetic */ RedditPreferenceRepository f10739a;
    final /* synthetic */ CarouselCollectionStateKey f10740b;
    final /* synthetic */ CarouselCollectionState f10741c;

    RedditPreferenceRepository$setCarouselCollectionState$1(RedditPreferenceRepository redditPreferenceRepository, CarouselCollectionStateKey carouselCollectionStateKey, CarouselCollectionState carouselCollectionState) {
        this.f10739a = redditPreferenceRepository;
        this.f10740b = carouselCollectionStateKey;
        this.f10741c = carouselCollectionState;
    }

    public final /* synthetic */ Object call() {
        this.f10739a.f16113d.edit().putString(this.f10740b.toString(), JsonUtil.a(this.f10741c)).apply();
        return Unit.a;
    }
}
