package com.reddit.datalibrary.frontpage.data.provider;

import com.reddit.datalibrary.frontpage.data.common.busevents.BaseEvent;
import com.reddit.datalibrary.frontpage.data.common.busevents.ErrorEvent;
import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteRedditApiDataSource;
import com.reddit.datalibrary.frontpage.requests.models.v1.LinkListing;
import com.reddit.datalibrary.frontpage.requests.models.v1.LinkWrapper;
import com.reddit.datalibrary.frontpage.requests.models.v1.Listing;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.commons.Sorting;
import com.reddit.frontpage.commons.analytics.performance.ListingPerformanceTracker;
import com.reddit.frontpage.util.SchedulerProvider;
import de.greenrobot.event.EventBus;
import io.reactivex.observers.DisposableSingleObserver;
import javax.inject.Inject;

public class LinkSearchListingProvider extends BaseListingProvider<LinkWrapper, LinkListing> {
    protected String f18745c;
    protected final String f18746d;
    public int f18747e;
    public int f18748f;
    @Inject
    RemoteRedditApiDataSource f18749g;

    public static class LinkSearchEvent extends BaseEvent {
        public final String f16257a;

        public LinkSearchEvent(String str) {
            this.f16257a = str;
        }
    }

    public static class LinkSearchErrorEvent extends ErrorEvent {
        public LinkSearchErrorEvent(Exception exception) {
            super(exception);
        }
    }

    public LinkSearchListingProvider(String str) {
        FrontpageApplication.m().a(this);
        this.f18746d = str;
    }

    public void mo3790b(final boolean z, final String str) {
        RemoteRedditApiDataSource.m8893a(this.f18746d, this.f18745c, this.mAfter, Sorting.a(this.f18747e), Sorting.d(this.f18748f), str).subscribeOn(SchedulerProvider.b()).observeOn(SchedulerProvider.c()).subscribe(new DisposableSingleObserver<LinkListing>(this) {
            final /* synthetic */ LinkSearchListingProvider f18744c;

            public /* synthetic */ void onSuccess(Object obj) {
                LinkListing linkListing = (LinkListing) obj;
                ListingPerformanceTracker.c(str);
                ListingPerformanceTracker.d(str);
                this.f18744c.mo3801a((Listing) linkListing, z);
            }

            public void onError(Throwable th) {
                this.f18744c.a = false;
                ListingPerformanceTracker.d(str);
                th = this.f18744c.mo3789a(new Exception(th));
                if (th != null) {
                    EventBus.getDefault().post(th);
                }
            }
        });
    }

    public final BaseEvent mo3788a() {
        return new LinkSearchEvent(this.f18745c);
    }

    public final BaseEvent mo3789a(Exception exception) {
        return new LinkSearchErrorEvent(exception);
    }

    public final void m19732a(String str, int i, int i2, String str2) {
        this.f18745c = str;
        this.f18747e = i;
        this.f18748f = i2;
        this.mAfter = null;
        m16208a(true, str2);
    }
}
