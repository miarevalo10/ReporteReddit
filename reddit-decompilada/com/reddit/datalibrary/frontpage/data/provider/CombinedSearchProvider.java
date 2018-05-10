package com.reddit.datalibrary.frontpage.data.provider;

import com.evernote.android.state.State;
import com.google.common.collect.Iterables;
import com.reddit.datalibrary.frontpage.data.common.busevents.ErrorEvent;
import com.reddit.datalibrary.frontpage.data.common.busevents.SearchEvent;
import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteRedditApiDataSource;
import com.reddit.datalibrary.frontpage.requests.models.v1.Account;
import com.reddit.datalibrary.frontpage.requests.models.v1.AccountWrapper;
import com.reddit.datalibrary.frontpage.requests.models.v1.LinkListing;
import com.reddit.datalibrary.frontpage.requests.models.v1.LinkWrapper;
import com.reddit.datalibrary.frontpage.requests.models.v1.SearchResponse;
import com.reddit.datalibrary.frontpage.requests.models.v1.ThingWrapper;
import com.reddit.frontpage.FrontpageApplication;
import de.greenrobot.event.EventBus;
import io.reactivex.observers.DisposableSingleObserver;
import java.util.ArrayList;
import javax.inject.Inject;

public class CombinedSearchProvider extends BaseOtherProvider {
    @Inject
    RemoteRedditApiDataSource f16224a;
    public boolean f16225b;
    @State
    public ArrayList<LinkWrapper> mLinks = new ArrayList();
    @State
    public String mLinksAfter;
    @State
    public String mQuery;
    @State
    public int mSortId;
    @State
    public ArrayList<ThingWrapper> mSubreddits = new ArrayList();
    @State
    public String mSubredditsAfter;
    @State
    public int mTimeframeId;

    class C16901 extends DisposableSingleObserver<SearchResponse> {
        final /* synthetic */ String f18718a;
        final /* synthetic */ CombinedSearchProvider f18719b;

        public C16901(CombinedSearchProvider combinedSearchProvider, String str) {
            this.f18719b = combinedSearchProvider;
            this.f18718a = str;
        }

        public /* synthetic */ void onSuccess(Object obj) {
            SearchResponse searchResponse = (SearchResponse) obj;
            this.f18719b.mLinks.clear();
            this.f18719b.mLinksAfter = null;
            if (searchResponse.mLinks.mo3815a() != null) {
                this.f18719b.mLinks.addAll(searchResponse.mLinks.mo3815a().mo3049b());
                this.f18719b.mLinksAfter = searchResponse.mLinks.mo3815a().mo3048a();
            }
            this.f18719b.mSubreddits.clear();
            this.f18719b.mSubredditsAfter = null;
            if (searchResponse.mSubreddits.mo3815a() != null) {
                this.f18719b.mSubreddits.addAll(searchResponse.mSubreddits.mo3815a().mo3049b());
                Iterables.m7138a(this.f18719b.mSubreddits, CombinedSearchProvider$1$$Lambda$0.f16223a);
                this.f18719b.mSubredditsAfter = searchResponse.mSubreddits.mo3815a().mo3048a();
            }
            EventBus.getDefault().postSticky(new CombinedSearchEvent(this.f18718a));
            this.f18719b.f16225b = false;
        }

        static final /* synthetic */ boolean m19699a(ThingWrapper thingWrapper) {
            return ((thingWrapper instanceof AccountWrapper) && ((Account) ((AccountWrapper) thingWrapper).getData()).subreddit == null) ? true : null;
        }

        public void onError(Throwable th) {
            EventBus.getDefault().post(new CombinedSearchErrorEvent(this.f18719b.mQuery, new Exception(th)));
            this.f18719b.f16225b = false;
        }
    }

    class C16912 extends DisposableSingleObserver<LinkListing> {
        final /* synthetic */ CombinedSearchProvider f18720a;

        public C16912(CombinedSearchProvider combinedSearchProvider) {
            this.f18720a = combinedSearchProvider;
        }

        public /* synthetic */ void onSuccess(Object obj) {
            LinkListing linkListing = (LinkListing) obj;
            this.f18720a.mLinks.addAll(linkListing.mo3815a().mo3049b());
            this.f18720a.mLinksAfter = linkListing.mo3815a().mo3048a();
            EventBus.getDefault().postSticky(new CombinedSearchEvent(this.f18720a.mQuery));
            this.f18720a.f16225b = false;
        }

        public void onError(Throwable th) {
            EventBus.getDefault().post(new CombinedSearchErrorEvent(this.f18720a.mQuery, new Exception(th)));
        }
    }

    public static class CombinedSearchErrorEvent extends ErrorEvent {
        public final String f18721a;

        public CombinedSearchErrorEvent(String str, Exception exception) {
            super(exception);
            this.f18721a = str;
        }
    }

    public static class CombinedSearchEvent extends SearchEvent {
        public CombinedSearchEvent(String str) {
            super(str);
        }
    }

    public CombinedSearchProvider() {
        FrontpageApplication.m().a(this);
    }

    public void onError(Exception exception) {
        EventBus.getDefault().post(new CombinedSearchErrorEvent(this.mQuery, exception));
    }

    public final LinkWrapper m16215a(int i) {
        return (LinkWrapper) this.mLinks.get(i);
    }
}
