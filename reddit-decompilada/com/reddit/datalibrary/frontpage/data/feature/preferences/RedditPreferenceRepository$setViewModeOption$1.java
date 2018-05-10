package com.reddit.datalibrary.frontpage.data.feature.preferences;

import com.reddit.frontpage.presentation.listing.model.ListingViewMode;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.Unit;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "call"}, k = 3, mv = {1, 1, 9})
/* compiled from: RedditPreferenceRepository.kt */
final class RedditPreferenceRepository$setViewModeOption$1<V> implements Callable<Object> {
    final /* synthetic */ RedditPreferenceRepository f10746a;
    final /* synthetic */ String f10747b;
    final /* synthetic */ ListingViewMode f10748c;

    RedditPreferenceRepository$setViewModeOption$1(RedditPreferenceRepository redditPreferenceRepository, String str, ListingViewMode listingViewMode) {
        this.f10746a = redditPreferenceRepository;
        this.f10747b = str;
        this.f10748c = listingViewMode;
    }

    public final /* synthetic */ Object call() {
        this.f10746a.f16113d.edit().putString(this.f10747b, this.f10748c.name()).apply();
        return Unit.a;
    }
}
