package com.reddit.datalibrary.frontpage.data.feature.preferences;

import com.reddit.frontpage.domain.repository.PreferenceRepository.CarouselCollectionStateKey;
import com.reddit.frontpage.presentation.listing.carousel.CarouselCollectionState;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lio/reactivex/Completable;", "it", "Lcom/reddit/frontpage/presentation/listing/carousel/CarouselCollectionState;", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: RedditPreferenceRepository.kt */
final class RedditPreferenceRepository$updateCarouselCollectionState$1<T, R> implements Function<CarouselCollectionState, CompletableSource> {
    final /* synthetic */ RedditPreferenceRepository f16102a;
    final /* synthetic */ CarouselCollectionStateKey f16103b;
    final /* synthetic */ Function1 f16104c;

    RedditPreferenceRepository$updateCarouselCollectionState$1(RedditPreferenceRepository redditPreferenceRepository, CarouselCollectionStateKey carouselCollectionStateKey, Function1 function1) {
        this.f16102a = redditPreferenceRepository;
        this.f16103b = carouselCollectionStateKey;
        this.f16104c = function1;
    }

    public final /* synthetic */ Object apply(Object obj) {
        CarouselCollectionState carouselCollectionState = (CarouselCollectionState) obj;
        Intrinsics.b(carouselCollectionState, "it");
        RedditPreferenceRepository redditPreferenceRepository = this.f16102a;
        CarouselCollectionStateKey carouselCollectionStateKey = this.f16103b;
        carouselCollectionState = (CarouselCollectionState) this.f16104c.a(carouselCollectionState);
        Intrinsics.b(carouselCollectionStateKey, "key");
        Intrinsics.b(carouselCollectionState, "state");
        obj = Completable.fromCallable(new RedditPreferenceRepository$setCarouselCollectionState$1(redditPreferenceRepository, carouselCollectionStateKey, carouselCollectionState));
        Intrinsics.a(obj, "Completable.fromCallable…son(state)).apply()\n    }");
        return obj;
    }
}
