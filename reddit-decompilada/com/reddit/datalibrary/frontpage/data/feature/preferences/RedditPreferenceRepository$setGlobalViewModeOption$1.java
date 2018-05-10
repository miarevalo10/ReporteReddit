package com.reddit.datalibrary.frontpage.data.feature.preferences;

import com.reddit.datalibrary.frontpage.data.feature.preferences.RedditPreferenceRepository.Companion;
import com.reddit.frontpage.presentation.listing.model.ListingViewMode;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.Unit;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "call"}, k = 3, mv = {1, 1, 9})
/* compiled from: RedditPreferenceRepository.kt */
final class RedditPreferenceRepository$setGlobalViewModeOption$1<V> implements Callable<Object> {
    final /* synthetic */ RedditPreferenceRepository f10744a;
    final /* synthetic */ boolean f10745b;

    RedditPreferenceRepository$setGlobalViewModeOption$1(RedditPreferenceRepository redditPreferenceRepository, boolean z) {
        this.f10744a = redditPreferenceRepository;
        this.f10745b = z;
    }

    public final /* synthetic */ Object call() {
        String name = (this.f10745b ? ListingViewMode.b : ListingViewMode.a).name();
        Companion companion = RedditPreferenceRepository.f16105a;
        for (String putString : RedditPreferenceRepository.f16110j) {
            this.f10744a.f16113d.edit().putString(putString, name).apply();
        }
        return Unit.a;
    }
}
