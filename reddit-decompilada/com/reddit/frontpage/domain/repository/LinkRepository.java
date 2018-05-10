package com.reddit.frontpage.domain.repository;

import com.reddit.datalibrary.frontpage.data.feature.common.SortTimeFrame;
import com.reddit.datalibrary.frontpage.data.feature.common.SortType;
import com.reddit.datalibrary.frontpage.data.feature.link.datasource.remote.DistinguishType;
import com.reddit.datalibrary.frontpage.data.model.DiscoveryUnitListingDataModel;
import com.reddit.datalibrary.frontpage.data.model.Listing;
import com.reddit.frontpage.domain.model.ILink;
import com.reddit.frontpage.domain.model.Link;
import com.reddit.frontpage.domain.model.Result;
import com.reddit.frontpage.presentation.listing.history.HistorySortType;
import com.reddit.frontpage.presentation.listing.model.ListingViewMode;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Single;
import java.util.Collection;
import java.util.Map;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0014\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0016\u0010\u0006\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0005H&J \u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH&J$\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u00112\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0005H&J,\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00170\u00162\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001bH&J,\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00170\u00162\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001bH&J*\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00112\u0006\u0010\u001f\u001a\u00020\u00052\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050!H&JZ\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u00170\u00112\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010&\u001a\u00020\u000f2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(H&J>\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00170\u00112\u0006\u0010*\u001a\u00020\u00052\b\b\u0002\u0010\u0018\u001a\u00020+2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0005H&J>\u0010-\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00170\u00112\u0006\u0010\u001f\u001a\u00020\u00052\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010&\u001a\u00020\u000fH&J>\u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130/0\u00112\u0006\u0010\u001f\u001a\u00020\u00052\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010&\u001a\u00020\u000fH&J\"\u00100\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00170\u00112\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00050/H&JX\u00102\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00170\u00112\b\b\u0002\u0010\u0018\u001a\u00020\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010&\u001a\u00020\u000f2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(H&J(\u00103\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00170\u00112\u0006\u0010*\u001a\u00020\u00052\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0005H&J\u0010\u00104\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0005H&J\u0010\u00105\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u00106\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0005H&J\u0010\u00107\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u00108\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u00109\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010:\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010;\u001a\u00020\u000fH&J\u0010\u0010<\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0005H&J\u0010\u0010=\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010>\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010?\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0005H&J\u0010\u0010@\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010A\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010B\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0005H&¨\u0006C"}, d2 = {"Lcom/reddit/frontpage/domain/repository/LinkRepository;", "", "approve", "Lio/reactivex/Completable;", "id", "", "clearRecentHistory", "linkIds", "", "delete", "linkId", "distinguish", "how", "Lcom/reddit/datalibrary/frontpage/data/feature/link/datasource/remote/DistinguishType;", "sticky", "", "edit", "Lio/reactivex/Single;", "Lcom/reddit/frontpage/domain/model/Result;", "Lcom/reddit/frontpage/domain/model/Link;", "text", "getAllLocalFrontpageLinks", "Lio/reactivex/Maybe;", "Lcom/reddit/datalibrary/frontpage/data/model/Listing;", "sort", "Lcom/reddit/datalibrary/frontpage/data/feature/common/SortType;", "sortTimeFrame", "Lcom/reddit/datalibrary/frontpage/data/feature/common/SortTimeFrame;", "getAllLocalPopularLinks", "getDiscoveryUnitListing", "Lcom/reddit/datalibrary/frontpage/data/model/DiscoveryUnitListingDataModel;", "path", "parameters", "", "getFrontpage", "Lcom/reddit/frontpage/domain/model/ILink;", "after", "adDistance", "refresh", "viewMode", "Lcom/reddit/frontpage/presentation/listing/model/ListingViewMode;", "getHistory", "username", "Lcom/reddit/frontpage/presentation/listing/history/HistorySortType;", "recentIds", "getLinkListing", "getLinks", "", "getLinksByIds", "ids", "getPopular", "getSubmitted", "hide", "lockComments", "markLinkAsRead", "markNsfw", "markSpoiler", "pinAnnouncement", "remove", "isSpam", "save", "unMarkNsfw", "unMarkSpoiler", "unhide", "unlockComments", "unpinAnnouncement", "unsave", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: LinkRepository.kt */
public interface LinkRepository {

    @Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 9})
    /* compiled from: LinkRepository.kt */
    public static final class DefaultImpls {
        public static /* bridge */ /* synthetic */ Single m22407a(LinkRepository linkRepository, SortType sortType, SortTimeFrame sortTimeFrame, String str, String str2, boolean z, ListingViewMode listingViewMode, int i) {
            if ((i & 1) != 0) {
                sortType = null;
            }
            if ((i & 2) != 0) {
                sortTimeFrame = null;
            }
            if ((i & 4) != 0) {
                str = null;
            }
            if ((i & 8) != 0) {
                str2 = null;
            }
            if ((i & 16) != 0) {
                z = false;
            }
            if ((i & 32) != 0) {
                listingViewMode = null;
            }
            return linkRepository.m22415a(sortType, sortTimeFrame, str, str2, z, listingViewMode);
        }

        public static /* bridge */ /* synthetic */ Single m22409b(LinkRepository linkRepository, SortType sortType, SortTimeFrame sortTimeFrame, String str, String str2, boolean z, ListingViewMode listingViewMode, int i) {
            if ((i & 1) != 0) {
                sortType = SortType.c;
            }
            SortType sortType2 = sortType;
            SortTimeFrame sortTimeFrame2 = (i & 2) != null ? null : sortTimeFrame;
            String str3 = (i & 4) != null ? null : str;
            String str4 = (i & 8) != null ? null : str2;
            if ((i & 16) != null) {
                z = false;
            }
            return linkRepository.m22422b(sortType2, sortTimeFrame2, str3, str4, z, (i & 32) != null ? null : listingViewMode);
        }
    }

    Completable m22410a(String str);

    Completable m22411a(String str, DistinguishType distinguishType, boolean z);

    Completable m22412a(String str, boolean z);

    Completable m22413a(Collection<String> collection);

    Maybe<Listing<Link>> m22414a(SortType sortType, SortTimeFrame sortTimeFrame);

    Single<Listing<ILink>> m22415a(SortType sortType, SortTimeFrame sortTimeFrame, String str, String str2, boolean z, ListingViewMode listingViewMode);

    Single<Listing<Link>> m22416a(String str, HistorySortType historySortType, String str2, String str3);

    Single<Listing<Link>> m22417a(String str, String str2);

    Single<Listing<Link>> m22418a(String str, String str2, boolean z);

    Single<DiscoveryUnitListingDataModel> m22419a(String str, Map<String, String> map);

    Completable m22420b(String str);

    Maybe<Listing<Link>> m22421b(SortType sortType, SortTimeFrame sortTimeFrame);

    Single<Listing<Link>> m22422b(SortType sortType, SortTimeFrame sortTimeFrame, String str, String str2, boolean z, ListingViewMode listingViewMode);

    Single<Result<Link>> m22423b(String str, String str2);

    Completable m22424c(String str);

    Completable m22425d(String str);

    Completable m22426e(String str);

    Completable m22427f(String str);

    Completable m22428g(String str);

    Completable m22429h(String str);

    Completable m22430i(String str);

    Completable m22431j(String str);

    Completable m22432k(String str);

    Completable m22433l(String str);

    Completable m22434m(String str);
}
