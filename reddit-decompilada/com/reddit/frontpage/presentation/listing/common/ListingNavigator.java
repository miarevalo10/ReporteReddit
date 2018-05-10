package com.reddit.frontpage.presentation.listing.common;

import com.reddit.datalibrary.frontpage.data.feature.common.LinkSortType;
import com.reddit.datalibrary.frontpage.data.feature.common.SortTimeFrame;
import com.reddit.frontpage.domain.model.Link;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J2\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H&J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0016\u001a\u00020\u0003H&J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u000bH&J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u000bH&J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u001d"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/common/ListingNavigator;", "", "navigateToAd", "", "link", "Lcom/reddit/frontpage/domain/model/Link;", "navigateToCrossPost", "navigateToImage", "navigateToLinkDetail", "navigateToLinkDetailPager", "selectedLinkId", "", "linkPosition", "", "listingType", "Lcom/reddit/frontpage/presentation/listing/common/ListingType;", "sort", "Lcom/reddit/datalibrary/frontpage/data/feature/common/LinkSortType;", "sortTimeFrame", "Lcom/reddit/datalibrary/frontpage/data/feature/common/SortTimeFrame;", "navigateToModerate", "navigateToShare", "navigateToSignUp", "navigateToSubredditDetail", "subredditName", "navigateToUserProfile", "username", "navigateToVideo", "navigateToWebsite", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ListingNavigator.kt */
public interface ListingNavigator {
    void mo4843a();

    void mo4844a(Link link);

    void mo4845a(String str);

    void mo4846a(String str, int i, ListingType listingType, LinkSortType linkSortType, SortTimeFrame sortTimeFrame);

    void mo4847b(Link link);

    void mo4848b(String str);

    void mo4849c(Link link);

    void mo4850d(Link link);

    void mo4851e(Link link);

    void mo4852f(Link link);

    void mo4853g(Link link);
}
