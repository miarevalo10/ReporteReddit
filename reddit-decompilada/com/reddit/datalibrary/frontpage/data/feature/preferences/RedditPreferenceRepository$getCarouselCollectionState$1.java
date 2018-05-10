package com.reddit.datalibrary.frontpage.data.feature.preferences;

import com.reddit.frontpage.domain.repository.PreferenceRepository.CarouselCollectionStateKey;
import com.reddit.frontpage.presentation.listing.carousel.CarouselCollectionState;
import com.reddit.frontpage.presentation.listing.carousel.CarouselCollectionState.Companion;
import com.reddit.frontpage.util.JsonUtil;
import java.util.concurrent.Callable;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/reddit/frontpage/presentation/listing/carousel/CarouselCollectionState;", "kotlin.jvm.PlatformType", "call"}, k = 3, mv = {1, 1, 9})
/* compiled from: RedditPreferenceRepository.kt */
final class RedditPreferenceRepository$getCarouselCollectionState$1<V> implements Callable<T> {
    final /* synthetic */ RedditPreferenceRepository f10726a;
    final /* synthetic */ CarouselCollectionStateKey f10727b;

    RedditPreferenceRepository$getCarouselCollectionState$1(RedditPreferenceRepository redditPreferenceRepository, CarouselCollectionStateKey carouselCollectionStateKey) {
        this.f10726a = redditPreferenceRepository;
        this.f10727b = carouselCollectionStateKey;
    }

    public final /* synthetic */ Object call() {
        String string = this.f10726a.f16113d.getString(this.f10727b.toString(), null);
        if (string != null) {
            return (CarouselCollectionState) JsonUtil.a(string, CarouselCollectionState.class);
        }
        Companion companion = CarouselCollectionState.Companion;
        return Companion.a();
    }
}
