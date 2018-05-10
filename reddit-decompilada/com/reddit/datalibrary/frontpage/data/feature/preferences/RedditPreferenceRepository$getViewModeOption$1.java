package com.reddit.datalibrary.frontpage.data.feature.preferences;

import com.reddit.frontpage.presentation.listing.model.ListingViewMode;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/reddit/frontpage/presentation/listing/model/ListingViewMode;", "call"}, k = 3, mv = {1, 1, 9})
/* compiled from: RedditPreferenceRepository.kt */
final class RedditPreferenceRepository$getViewModeOption$1<V> implements Callable<T> {
    final /* synthetic */ RedditPreferenceRepository f10730a;
    final /* synthetic */ String f10731b;
    final /* synthetic */ ListingViewMode f10732c;

    RedditPreferenceRepository$getViewModeOption$1(RedditPreferenceRepository redditPreferenceRepository, String str, ListingViewMode listingViewMode) {
        this.f10730a = redditPreferenceRepository;
        this.f10731b = str;
        this.f10732c = listingViewMode;
    }

    public final /* synthetic */ Object call() {
        String string = this.f10730a.f16113d.getString(this.f10731b, this.f10732c.name());
        Intrinsics.a(string, "pref");
        return ListingViewMode.valueOf(string);
    }
}
