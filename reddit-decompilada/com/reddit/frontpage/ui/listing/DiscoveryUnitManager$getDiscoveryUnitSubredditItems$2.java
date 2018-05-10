package com.reddit.frontpage.ui.listing;

import com.reddit.datalibrary.frontpage.requests.models.config.discoveryunit.DiscoveryUnit;
import com.reddit.frontpage.debug.RedditLogger;
import com.reddit.frontpage.ui.listing.DiscoveryUnitManager.DiscoveryUnitLoadResult.Error;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/reddit/frontpage/ui/listing/DiscoveryUnitManager$DiscoveryUnitLoadResult$Error;", "it", "", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: DiscoveryUnitManager.kt */
final class DiscoveryUnitManager$getDiscoveryUnitSubredditItems$2<T, R> implements Function<Throwable, DiscoveryUnitLoadResult> {
    final /* synthetic */ DiscoveryUnitManager f29037a;
    final /* synthetic */ DiscoveryUnit f29038b;

    DiscoveryUnitManager$getDiscoveryUnitSubredditItems$2(DiscoveryUnitManager discoveryUnitManager, DiscoveryUnit discoveryUnit) {
        this.f29037a = discoveryUnitManager;
        this.f29038b = discoveryUnit;
    }

    public final /* synthetic */ Object apply(Object obj) {
        Throwable th = (Throwable) obj;
        Intrinsics.m26847b(th, "it");
        StringBuilder stringBuilder = new StringBuilder("getDiscoveryUnitSubredditItems(...) error ");
        stringBuilder.append(th.getMessage());
        RedditLogger.m21982a(stringBuilder.toString());
        return new Error(this.f29038b);
    }
}
