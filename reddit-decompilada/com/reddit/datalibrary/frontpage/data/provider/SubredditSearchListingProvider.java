package com.reddit.datalibrary.frontpage.data.provider;

import com.reddit.datalibrary.frontpage.data.common.busevents.BaseEvent;
import com.reddit.datalibrary.frontpage.data.common.busevents.SearchEvent;
import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteRedditApiDataSource;
import com.reddit.datalibrary.frontpage.requests.models.v1.Account;
import com.reddit.datalibrary.frontpage.requests.models.v1.AccountWrapper;
import com.reddit.datalibrary.frontpage.requests.models.v1.Listing;
import com.reddit.datalibrary.frontpage.requests.models.v1.SubredditListing;
import com.reddit.datalibrary.frontpage.requests.models.v1.ThingWrapper;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.commons.analytics.performance.ListingPerformanceTracker;
import com.reddit.frontpage.util.SchedulerProvider;
import de.greenrobot.event.EventBus;
import io.reactivex.observers.DisposableSingleObserver;
import java.util.ArrayList;
import java.util.Iterator;
import javax.inject.Inject;

public class SubredditSearchListingProvider extends BaseListingProvider<ThingWrapper, SubredditListing> {
    public String f18775c;
    @Inject
    RemoteRedditApiDataSource f18776d;

    public static class SubredditSearchEvent extends SearchEvent {
        public SubredditSearchEvent(String str) {
            super(str);
        }
    }

    public SubredditSearchListingProvider(String str, ArrayList<ThingWrapper> arrayList, String str2) {
        FrontpageApplication.m().a(this);
        this.f18775c = str;
        this.mObjects = arrayList;
        this.mAfter = str2;
    }

    public final void mo3790b(boolean z, final String str) {
        RemoteRedditApiDataSource.m8909b(this.f18775c, this.mAfter, z, str).subscribeOn(SchedulerProvider.b()).observeOn(SchedulerProvider.c()).subscribe(new DisposableSingleObserver<SubredditListing>(this) {
            final /* synthetic */ SubredditSearchListingProvider f18774b;

            public /* synthetic */ void onSuccess(Object obj) {
                SubredditListing subredditListing = (SubredditListing) obj;
                ListingPerformanceTracker.c(str);
                ListingPerformanceTracker.d(str);
                this.f18774b.mo3801a((Listing) subredditListing, false);
            }

            public void onError(Throwable th) {
                this.f18774b.a = false;
                ListingPerformanceTracker.d(str);
                th = this.f18774b.mo3789a(new Exception(th));
                if (th != null) {
                    EventBus.getDefault().post(th);
                }
            }
        });
    }

    public final void m19754e() {
        if (this.mObjects != null) {
            Iterator it = this.mObjects.iterator();
            while (it.hasNext()) {
                ThingWrapper thingWrapper = (ThingWrapper) it.next();
                if ((thingWrapper instanceof AccountWrapper) && ((Account) ((AccountWrapper) thingWrapper).getData()).subreddit == null) {
                    it.remove();
                }
            }
        }
    }

    public final /* synthetic */ BaseEvent mo3788a() {
        return new SubredditSearchEvent(this.f18775c);
    }
}
