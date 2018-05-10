package com.reddit.frontpage.presentation.listing.common;

import android.content.Context;
import android.net.Uri;
import com.reddit.datalibrary.frontpage.data.feature.common.LinkSortType;
import com.reddit.datalibrary.frontpage.data.feature.common.SortTimeFrame;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.datalibrary.frontpage.requests.models.v2.ClientLink;
import com.reddit.frontpage.commons.analytics.events.v2.ShareEventBuilder;
import com.reddit.frontpage.commons.analytics.events.v2.ShareEventBuilder.Action;
import com.reddit.frontpage.commons.analytics.events.v2.ShareEventBuilder.Noun;
import com.reddit.frontpage.commons.analytics.events.v2.ShareEventBuilder.Source;
import com.reddit.frontpage.domain.model.Image;
import com.reddit.frontpage.domain.model.ImageResolution;
import com.reddit.frontpage.domain.model.Link;
import com.reddit.frontpage.domain.model.Preview;
import com.reddit.frontpage.domain.model.SubredditDetail;
import com.reddit.frontpage.nav.Nav;
import com.reddit.frontpage.nav.Routing;
import com.reddit.frontpage.presentation.analytics.RedditAdsAnalytics;
import com.reddit.frontpage.ui.listing.adapter.ads.AdsNavigator;
import com.reddit.frontpage.util.IntentUtil;
import com.reddit.frontpage.util.LinkUtil;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.util.kotlin.ContextsKt;
import java.util.List;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B/\b\u0007\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J2\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u001e\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u001f\u001a\u00020\rH\u0016J\u0010\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\u0006H\u0016J\u0010\u0010\"\u001a\u00020\r2\u0006\u0010#\u001a\u00020\u0006H\u0016J\u0010\u0010$\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010%\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/reddit/frontpage/presentation/listing/common/RedditListingNavigator;", "Lcom/reddit/frontpage/presentation/listing/common/ListingNavigator;", "context", "Lkotlin/Lazy;", "Landroid/content/Context;", "sourcePage", "", "sessionManager", "Lcom/reddit/datalibrary/frontpage/redditauth/account/SessionManager;", "adsNavigator", "Lcom/reddit/frontpage/ui/listing/adapter/ads/AdsNavigator;", "(Lkotlin/Lazy;Ljava/lang/String;Lcom/reddit/datalibrary/frontpage/redditauth/account/SessionManager;Lcom/reddit/frontpage/ui/listing/adapter/ads/AdsNavigator;)V", "navigateToAd", "", "link", "Lcom/reddit/frontpage/domain/model/Link;", "navigateToCrossPost", "navigateToImage", "navigateToLinkDetail", "navigateToLinkDetailPager", "selectedLinkId", "linkPosition", "", "listingType", "Lcom/reddit/frontpage/presentation/listing/common/ListingType;", "sort", "Lcom/reddit/datalibrary/frontpage/data/feature/common/LinkSortType;", "sortTimeFrame", "Lcom/reddit/datalibrary/frontpage/data/feature/common/SortTimeFrame;", "navigateToModerate", "navigateToShare", "navigateToSignUp", "navigateToSubredditDetail", "subredditName", "navigateToUserProfile", "username", "navigateToVideo", "navigateToWebsite", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ListingNavigator.kt */
public final class RedditListingNavigator implements ListingNavigator {
    private final Lazy<Context> f28284a;
    private final String f28285b;
    private final SessionManager f28286c;
    private final AdsNavigator f28287d;

    @Inject
    public RedditListingNavigator(Lazy<? extends Context> lazy, String str, SessionManager sessionManager, AdsNavigator adsNavigator) {
        Intrinsics.m26847b(lazy, "context");
        Intrinsics.m26847b(str, "sourcePage");
        Intrinsics.m26847b(sessionManager, "sessionManager");
        Intrinsics.m26847b(adsNavigator, "adsNavigator");
        this.f28284a = lazy;
        this.f28285b = str;
        this.f28286c = sessionManager;
        this.f28287d = adsNavigator;
    }

    public final void mo4845a(String str) {
        Intrinsics.m26847b(str, "username");
        Routing.m22619a((Context) this.f28284a.mo5678b(), Nav.m22594j(str));
    }

    public final void mo4848b(String str) {
        Intrinsics.m26847b(str, "subredditName");
        Routing.m22619a((Context) this.f28284a.mo5678b(), Nav.m22566b(str));
    }

    public final void mo4846a(String str, int i, ListingType listingType, LinkSortType linkSortType, SortTimeFrame sortTimeFrame) {
        Intrinsics.m26847b(str, "selectedLinkId");
        Intrinsics.m26847b(listingType, "listingType");
        Intrinsics.m26847b(linkSortType, "sort");
        Routing.m22619a((Context) this.f28284a.mo5678b(), Nav.m22548a(str, i, listingType, linkSortType, sortTimeFrame));
    }

    public final void mo4844a(Link link) {
        Intrinsics.m26847b(link, "link");
        Routing.m22619a((Context) this.f28284a.mo5678b(), Nav.m22541a((com.reddit.datalibrary.frontpage.requests.models.v2.Link) new ClientLink(link)));
    }

    public final void mo4847b(Link link) {
        Intrinsics.m26847b(link, "link");
        link = link.getCrossPostParentList();
        if (link != null) {
            link = (Link) CollectionsKt___CollectionsKt.m41434e((List) link);
            if (link != null) {
                Routing.m22627b(Routing.m22617a((Context) this.f28284a.mo5678b()), Nav.m22541a((com.reddit.datalibrary.frontpage.requests.models.v2.Link) new ClientLink(link)));
            }
        }
    }

    public final void mo4849c(Link link) {
        Intrinsics.m26847b(link, "link");
        IntentUtil.m23757a((Context) this.f28284a.mo5678b(), (com.reddit.datalibrary.frontpage.requests.models.v2.Link) new ClientLink(link), this.f28285b);
    }

    public final void mo4850d(Link link) {
        ImageResolution source;
        Intrinsics.m26847b(link, "link");
        Preview preview = link.getPreview();
        if (preview != null) {
            List images = preview.getImages();
            if (images != null) {
                Image image = (Image) CollectionsKt___CollectionsKt.m41430d(images);
                if (image != null) {
                    source = image.getSource();
                    if (source != null) {
                        Timber.b(" Loading image thumbnailView URL: %s", new Object[]{source.getUrl()});
                        ((Context) this.f28284a.mo5678b()).startActivity(IntentUtil.m23760b((Context) this.f28284a.mo5678b(), (com.reddit.datalibrary.frontpage.requests.models.v2.Link) new ClientLink(link), this.f28285b));
                    }
                }
            }
        }
        source = null;
        if (source != null) {
            Timber.b(" Loading image thumbnailView URL: %s", new Object[]{source.getUrl()});
            ((Context) this.f28284a.mo5678b()).startActivity(IntentUtil.m23760b((Context) this.f28284a.mo5678b(), (com.reddit.datalibrary.frontpage.requests.models.v2.Link) new ClientLink(link), this.f28285b));
        }
    }

    public final void mo4851e(Link link) {
        Intrinsics.m26847b(link, "link");
        SubredditDetail subredditDetail = link.getSubredditDetail();
        Util.m23967a(Util.m24014d((Context) this.f28284a.mo5678b()), Uri.parse(link.getUrl()), Util.m23951a((Context) this.f28284a.mo5678b(), subredditDetail != null ? subredditDetail.getKeyColor() : null), link.getKindWithId(), this.f28285b);
    }

    public final void mo4852f(Link link) {
        Intrinsics.m26847b(link, "link");
        new ShareEventBuilder().m21941a(Source.PostListing).m21939a(Action.Clicked).m21940a(Noun.Share).m21942a(link).m21943a(link.getSubredditId(), link.getSubreddit()).m21944a();
        new ShareEventBuilder().m21941a(Source.PostShareComplete).m21939a(Action.ShareComplete).m21940a(Noun.ShareSuccess).m21942a(link).m21943a(link.getSubredditId(), link.getSubreddit()).m21945b();
        Context context = (Context) this.f28284a.mo5678b();
        link.getTitle();
        LinkUtil.m23780a(context, link.getPermalink());
    }

    public final void mo4843a() {
        this.f28286c.a(ContextsKt.m24080d((Context) this.f28284a.mo5678b()), true);
    }

    public final void mo4853g(Link link) {
        Intrinsics.m26847b(link, "link");
        Context context = (Context) this.f28284a.mo5678b();
        String str = this.f28285b;
        Intrinsics.m26847b(context, "context");
        Intrinsics.m26847b(link, "link");
        if (link.getPromoted()) {
            RedditAdsAnalytics.m22652a(context, link);
            String a = AdsNavigator.m23453a(link);
            if (a != null) {
                SubredditDetail subredditDetail = link.getSubredditDetail();
                Util.m23967a(Util.m24014d(context), Uri.parse(a), Util.m23951a(context, subredditDetail != null ? subredditDetail.getKeyColor() : null), link.getKindWithId(), str);
            }
        }
    }
}
