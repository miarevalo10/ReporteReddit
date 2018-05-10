package com.reddit.datalibrary.frontpage.data.provider;

import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteRedditApiDataSource;
import com.reddit.datalibrary.frontpage.requests.models.v1.LinkListing;
import com.reddit.datalibrary.frontpage.requests.models.v1.Listing;
import com.reddit.frontpage.commons.analytics.performance.ListingPerformanceTracker;
import com.reddit.frontpage.util.SchedulerProvider;
import de.greenrobot.event.EventBus;
import io.reactivex.observers.DisposableSingleObserver;

public class MultiredditLinkSearchListingProvider extends LinkSearchListingProvider {
    public MultiredditLinkSearchListingProvider(String str) {
        super(str);
    }

    public final void mo3790b(final boolean z, final String str) {
        RemoteRedditApiDataSource.m8921d(this.d, this.c).subscribeOn(SchedulerProvider.b()).observeOn(SchedulerProvider.c()).subscribe(new DisposableSingleObserver<LinkListing>(this) {
            final /* synthetic */ MultiredditLinkSearchListingProvider f18766c;

            public /* synthetic */ void onSuccess(Object obj) {
                LinkListing linkListing = (LinkListing) obj;
                ListingPerformanceTracker.c(str);
                ListingPerformanceTracker.d(str);
                this.f18766c.mo3801a((Listing) linkListing, z);
            }

            public void onError(Throwable th) {
                this.f18766c.a = false;
                ListingPerformanceTracker.d(str);
                th = this.f18766c.mo3789a(new Exception(th));
                if (th != null) {
                    EventBus.getDefault().post(th);
                }
            }
        });
    }
}
