package com.reddit.datalibrary.frontpage.data.provider;

import android.util.LruCache;
import com.android.volley.NetworkError;
import com.android.volley.Request.Priority;
import com.android.volley.VolleyError;
import com.evernote.android.state.State;
import com.reddit.datalibrary.frontpage.data.common.busevents.BaseEvent;
import com.reddit.datalibrary.frontpage.data.common.busevents.ErrorEvent;
import com.reddit.datalibrary.frontpage.data.feature.legacy.AsyncCallback;
import com.reddit.datalibrary.frontpage.data.feature.link.repo.LegacyLinkRepository;
import com.reddit.datalibrary.frontpage.data.provider.BaseOtherProvider.ProviderEvent;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.datalibrary.frontpage.redditauth.redditclient.RedditClient;
import com.reddit.datalibrary.frontpage.requests.api.v1.RequestBuilder;
import com.reddit.datalibrary.frontpage.requests.api.v1.RequestBuilder.Callbacks;
import com.reddit.datalibrary.frontpage.requests.api.v1.reddit.RedditRequestBuilder;
import com.reddit.datalibrary.frontpage.requests.models.v1.CommunityRule;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.datalibrary.frontpage.requests.models.v2.Listable;
import com.reddit.datalibrary.frontpage.requests.models.v2.Listing;
import com.reddit.datalibrary.frontpage.requests.models.v2.ParcelerBundler;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.commons.analytics.performance.ListingPerformanceTracker;
import com.reddit.frontpage.requests.models.v1.CommunityRulesWrapper;
import com.reddit.frontpage.ui.detail.LinkEditCache;
import com.reddit.frontpage.ui.detail.LinkEditCache.BodyEditCacheEntry;
import com.reddit.frontpage.ui.listener.Consumer;
import de.greenrobot.event.EventBus;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Pair;

public abstract class LinkListingProvider extends BaseListingProvider2<Listable> implements ShareableProvider {
    protected final Filter f18740c;
    @Inject
    protected LegacyLinkRepository f18741d;
    @State
    public int ignoreLinkForPagingCount;
    @State(ParcelerBundler.class)
    public List<String> linkIds;
    @State(ParcelerBundler.class)
    public List<Integer> linkPositions;
    @State
    public int sortId;
    @State
    public int sortTimeFrame;

    public interface Filter {
        boolean m9132a(Listable listable);
    }

    public static class LinkListingError extends ErrorEvent {
        public LinkListingError(Exception exception) {
            super(exception);
        }
    }

    public static class LoadCompleteListingEvent extends ProviderEvent {
        public final boolean f18739b;

        public LoadCompleteListingEvent(String str, boolean z) {
            super(str);
            this.f18739b = z;
        }
    }

    protected abstract void mo4202a(ListingRequestParams listingRequestParams, String str, AsyncCallback<Listing<? extends Listable>> asyncCallback);

    protected void mo4207a(String str, List<Pair<String, String>> list, AsyncCallback<Listing<? extends Listable>> asyncCallback) {
    }

    public LinkListingProvider(String str) {
        this(str, 2, null);
    }

    public LinkListingProvider(String str, int i, Filter filter) {
        super(str);
        this.linkPositions = new ArrayList();
        this.linkIds = new ArrayList();
        this.sortId = -1;
        this.sortTimeFrame = -1;
        this.ignoreLinkForPagingCount = null;
        this.sortId = i;
        this.f18740c = filter;
        FrontpageApplication.d().mo2971a(this);
    }

    public LinkListingProvider(String str, int i, int i2) {
        super(str);
        this.linkPositions = new ArrayList();
        this.linkIds = new ArrayList();
        this.sortId = -1;
        this.sortTimeFrame = -1;
        this.ignoreLinkForPagingCount = null;
        this.sortId = i;
        this.sortTimeFrame = i2;
        this.f18740c = null;
        FrontpageApplication.d().mo2971a(this);
    }

    public final BaseEvent mo3796a(boolean z) {
        return new LoadCompleteListingEvent(this.providerId, z);
    }

    public final BaseEvent mo3795a(Exception exception) {
        return new LinkListingError(exception);
    }

    public final int m19724b() {
        return this.sortId;
    }

    public final int m19726c() {
        return this.sortTimeFrame;
    }

    public final void mo3798c(final boolean z, final String str) {
        String str2 = null;
        String after = (this.listing == null || z) ? null : this.listing.getAfter();
        if (!(this.listing == null || z)) {
            str2 = this.listing.getAdDistance();
        }
        mo4202a(new ListingRequestParams(after, this.sortId, this.sortTimeFrame, str2), str, new AsyncCallback<Listing<? extends Listable>>(this) {
            final /* synthetic */ LinkListingProvider f16247c;

            public final /* synthetic */ void mo3014a(Object obj) {
                Listing listing = (Listing) obj;
                ListingPerformanceTracker.c(str);
                ListingPerformanceTracker.d(str);
                LinkListingProvider.m19714a(this.f16247c, listing, z);
            }

            public final void mo3013a(Exception exception) {
                ListingPerformanceTracker.d(str);
                this.f16247c.mo3797a(new NetworkError(exception));
            }
        });
    }

    public final void mo3799d(final boolean z, String str) {
        String after = (this.listing == null || z) ? null : this.listing.getAfter();
        List arrayList = new ArrayList();
        arrayList.add(new Pair("only", str));
        mo4207a(after, arrayList, new AsyncCallback<Listing<? extends Listable>>(this) {
            final /* synthetic */ LinkListingProvider f16249b;

            public final void mo3013a(Exception exception) {
                this.f16249b.mo3797a(new NetworkError(exception));
            }
        });
    }

    public final void mo3797a(VolleyError volleyError) {
        super.mo3797a(volleyError);
        volleyError = mo3795a((Exception) volleyError);
        if (volleyError != null) {
            EventBus.getDefault().post(volleyError);
        }
    }

    public final void m19720a(int i) {
        if (this.listing.size() >= i) {
            this.listing.remove(i);
            i = this.linkPositions.indexOf(Integer.valueOf(i));
            this.linkPositions.remove(i);
            this.linkIds.remove(i);
            while (i < this.linkPositions.size()) {
                this.linkPositions.set(i, Integer.valueOf(((Integer) this.linkPositions.get(i)).intValue() - 1));
                i++;
            }
        }
    }

    @Deprecated
    public final void m19725b(int i) {
        i = m19716d(i);
        if (m19717e(i)) {
            while (i < this.linkPositions.size()) {
                this.linkPositions.set(i, Integer.valueOf(((Integer) this.linkPositions.get(i)).intValue() + 1));
                i++;
            }
        }
    }

    @Deprecated
    private int m19716d(int i) {
        int intValue = ((Integer) this.linkPositions.get(this.linkPositions.size() - 1)).intValue();
        while (i <= intValue && this.linkPositions.indexOf(Integer.valueOf(i)) == -1) {
            i++;
        }
        return this.linkPositions.indexOf(Integer.valueOf(i));
    }

    private boolean m19717e(int i) {
        return i >= 0 && i <= this.linkPositions.size() - 1;
    }

    public static void m19715a(String str, final Consumer<List<CommunityRule>> consumer) {
        RequestBuilder redditRequestBuilder = new RedditRequestBuilder(RedditClient.m9217a(SessionManager.m9191b()).f10880a, CommunityRulesWrapper.class);
        redditRequestBuilder.f16333l = true;
        ((RedditRequestBuilder) redditRequestBuilder.m9323a(Priority.HIGH).m9325a("r").m9325a(str).m9325a("about").m9325a("rules")).m9331a(new Callbacks<CommunityRulesWrapper>() {
            public final void mo3015a(VolleyError volleyError) {
            }

            public final /* synthetic */ void mo3016a(Object obj) {
                consumer.a(((CommunityRulesWrapper) obj).getRules());
            }
        });
    }

    @Deprecated
    public final void m19727c(int i) {
        if (this.linkPositions.indexOf(Integer.valueOf(i)) != -1) {
            throw new IllegalArgumentException(String.format("Position %1$d points to valid link!", new Object[]{Integer.valueOf(i)}));
        }
        i = m19716d(i);
        if (m19717e(i)) {
            while (i < this.linkPositions.size()) {
                this.linkPositions.set(i, Integer.valueOf(((Integer) this.linkPositions.get(i)).intValue() - 1));
                i++;
            }
        }
    }

    static /* synthetic */ void m19714a(LinkListingProvider linkListingProvider, Listing listing, boolean z) {
        int size;
        Iterator it;
        Listable listable;
        int i;
        Link link;
        LruCache linkBodyEditCache;
        listing.size();
        if (z) {
            linkListingProvider.linkPositions.clear();
            linkListingProvider.linkIds.clear();
            linkListingProvider.ignoreLinkForPagingCount = 0;
        }
        if (!z) {
            if (linkListingProvider.listing != null) {
                size = linkListingProvider.listing.size();
                it = listing.iterator();
                while (it.hasNext()) {
                    listable = (Listable) it.next();
                    if (listable.getMinAndroidVersion() <= 209200) {
                        it.remove();
                    } else if (linkListingProvider.f18740c != null || linkListingProvider.f18740c.m9132a(listable)) {
                        i = 1;
                        if (listable instanceof Link) {
                            link = (Link) listable;
                            if (link.getName() != null) {
                                linkBodyEditCache = LinkEditCache.getLinkBodyEditCache();
                                if (linkBodyEditCache.get(link.getName()) != null) {
                                    linkBodyEditCache.put(link.getName(), new BodyEditCacheEntry(link.getSelfText(), link.getSelfTextHtml()));
                                }
                                if (LinkEditCache.getLinkFlairEditCache().get(link.getName()) != null) {
                                    LinkEditCache.getLinkFlairEditCache().put(link.getName(), link.getLinkFlairRichText());
                                }
                            }
                            if (link.isBlankAd()) {
                                linkListingProvider.ignoreLinkForPagingCount++;
                            }
                            linkListingProvider.linkIds.add(link.getName());
                        }
                        if (listable.getListableType() == 1 && !((Link) listable).isBlankAd()) {
                            if (!z) {
                                if (linkListingProvider.listing != null) {
                                    if (!linkListingProvider.listing.contains(listable)) {
                                        i = 0;
                                    }
                                }
                                if (i == 0) {
                                }
                            }
                            linkListingProvider.linkPositions.add(Integer.valueOf(size));
                        }
                        size++;
                    } else {
                        it.remove();
                    }
                }
                linkListingProvider.m16195a(listing, z);
            }
        }
        size = 0;
        it = listing.iterator();
        while (it.hasNext()) {
            listable = (Listable) it.next();
            if (listable.getMinAndroidVersion() <= 209200) {
                if (linkListingProvider.f18740c != null) {
                }
                i = 1;
                if (listable instanceof Link) {
                    link = (Link) listable;
                    if (link.getName() != null) {
                        linkBodyEditCache = LinkEditCache.getLinkBodyEditCache();
                        if (linkBodyEditCache.get(link.getName()) != null) {
                            linkBodyEditCache.put(link.getName(), new BodyEditCacheEntry(link.getSelfText(), link.getSelfTextHtml()));
                        }
                        if (LinkEditCache.getLinkFlairEditCache().get(link.getName()) != null) {
                            LinkEditCache.getLinkFlairEditCache().put(link.getName(), link.getLinkFlairRichText());
                        }
                    }
                    if (link.isBlankAd()) {
                        linkListingProvider.ignoreLinkForPagingCount++;
                    }
                    linkListingProvider.linkIds.add(link.getName());
                }
                if (z) {
                    if (linkListingProvider.listing != null) {
                        if (!linkListingProvider.listing.contains(listable)) {
                            i = 0;
                        }
                    }
                    if (i == 0) {
                    }
                }
                linkListingProvider.linkPositions.add(Integer.valueOf(size));
                size++;
            } else {
                it.remove();
            }
        }
        linkListingProvider.m16195a(listing, z);
    }
}
