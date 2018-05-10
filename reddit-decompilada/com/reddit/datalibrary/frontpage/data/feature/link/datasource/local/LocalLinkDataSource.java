package com.reddit.datalibrary.frontpage.data.feature.link.datasource.local;

import com.reddit.datalibrary.frontpage.data.feature.common.SortTimeFrame;
import com.reddit.datalibrary.frontpage.data.feature.common.SortType;
import com.reddit.datalibrary.frontpage.data.model.Listing;
import com.reddit.frontpage.domain.model.Link;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Single;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001c\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0006H&J,\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&J,\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&J8\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0006H&J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\n2\u0006\u0010\b\u001a\u00020\u0006H&J\u001c\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n2\u0006\u0010\u0016\u001a\u00020\u0006H&J8\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0006H&J\u0014\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u0019H&J>\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n2\u0006\u0010\u001b\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0006H&J\u0010\u0010\u001d\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0006H&J\u0010\u0010\u001e\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0006H&J@\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u00192\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0006H&J$\u0010\"\u001a\b\u0012\u0004\u0012\u00020 0\u00192\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u0016\u001a\u00020\u0006H&J@\u0010#\u001a\b\u0012\u0004\u0012\u00020 0\u00192\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0006H&JF\u0010$\u001a\b\u0012\u0004\u0012\u00020 0\u00192\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u001b\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&J\u0010\u0010%\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0006H&J\u0010\u0010&\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0006H&J\u0010\u0010'\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\fH&¨\u0006)"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/feature/link/datasource/local/LocalLinkDataSource;", "", "clearReadLinks", "Lio/reactivex/Completable;", "linkIds", "", "", "delete", "linkId", "getAllFrontpageLinks", "Lio/reactivex/Maybe;", "Lcom/reddit/datalibrary/frontpage/data/model/Listing;", "Lcom/reddit/frontpage/domain/model/Link;", "sort", "Lcom/reddit/datalibrary/frontpage/data/feature/common/SortType;", "sortTimeFrame", "Lcom/reddit/datalibrary/frontpage/data/feature/common/SortTimeFrame;", "getAllPopularLinks", "getFrontpageLinks", "after", "getLinkById", "getLinkListing", "path", "getPopularLinks", "getReadLinks", "Lio/reactivex/Single;", "getUserSubmittedPosts", "username", "hide", "markLinkAsRead", "save", "saveFrontpageLinks", "", "links", "saveLinkListing", "savePopularLinks", "saveUserSubmittedPosts", "unhide", "unsave", "updateLink", "link", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: LocalLinkDataSource.kt */
public interface LocalLinkDataSource {
    Completable mo2953a(Link link);

    Completable mo2954a(Iterable<String> iterable);

    Maybe<Listing<Link>> mo2955a(SortType sortType, SortTimeFrame sortTimeFrame);

    Maybe<Listing<Link>> mo2956a(SortType sortType, SortTimeFrame sortTimeFrame, String str);

    Maybe<Listing<Link>> mo2957a(String str);

    Maybe<Listing<Link>> mo2958a(String str, SortType sortType, String str2, SortTimeFrame sortTimeFrame);

    Single<Listing<Link>> mo2959a();

    Single<Boolean> mo2960a(Listing<Link> listing, SortType sortType, SortTimeFrame sortTimeFrame, String str);

    Single<Boolean> mo2961a(Listing<Link> listing, String str);

    Single<Boolean> mo2962a(Listing<Link> listing, String str, SortType sortType, String str2, SortTimeFrame sortTimeFrame);

    Completable mo2963b(String str);

    Maybe<Listing<Link>> mo2964b(SortType sortType, SortTimeFrame sortTimeFrame);

    Maybe<Listing<Link>> mo2965b(SortType sortType, SortTimeFrame sortTimeFrame, String str);

    Single<Boolean> mo2966b(Listing<Link> listing, SortType sortType, SortTimeFrame sortTimeFrame, String str);

    Completable mo2967c(String str);

    Completable mo2968d(String str);

    Maybe<Link> mo2969e(String str);

    Completable mo2970f(String str);
}
