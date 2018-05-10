package com.reddit.datalibrary.frontpage.data.provider;

import com.reddit.datalibrary.frontpage.data.common.busevents.BaseEvent;
import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteRedditApiDataSource;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.datalibrary.frontpage.requests.models.v1.Listing;
import com.reddit.datalibrary.frontpage.requests.models.v1.ThingWrapper;
import com.reddit.datalibrary.frontpage.requests.models.v1.ThingWrapperListing;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.commons.analytics.performance.ListingPerformanceTracker;
import com.reddit.frontpage.util.SchedulerProvider;
import de.greenrobot.event.EventBus;
import io.reactivex.Single;
import io.reactivex.observers.DisposableSingleObserver;
import javax.inject.Inject;

public abstract class SavedListingProvider extends BaseListingProvider<ThingWrapper, ThingWrapperListing> {
    @Inject
    RemoteRedditApiDataSource f18770c;

    public static class SavedFetchCompleteEvent extends BaseEvent {
    }

    public static class SavedFetchFailedEvent extends BaseEvent {
    }

    protected abstract Single<ThingWrapperListing> mo4206a(String str, boolean z);

    public SavedListingProvider() {
        FrontpageApplication.m().a(this);
    }

    public final void mo3790b(final boolean z, final String str) {
        mo4206a(SessionManager.m9191b().f10840c.getUsername(), z).subscribeOn(SchedulerProvider.b()).observeOn(SchedulerProvider.c()).subscribe(new DisposableSingleObserver<ThingWrapperListing>(this) {
            final /* synthetic */ SavedListingProvider f18769c;

            public /* synthetic */ void onSuccess(Object obj) {
                ThingWrapperListing thingWrapperListing = (ThingWrapperListing) obj;
                ListingPerformanceTracker.c(str);
                ListingPerformanceTracker.d(str);
                this.f18769c.mo3801a((Listing) thingWrapperListing, z);
            }

            public void onError(Throwable th) {
                ListingPerformanceTracker.d(str);
                EventBus.getDefault().post(new SavedFetchFailedEvent());
            }
        });
    }

    public final BaseEvent mo3788a() {
        return new SavedFetchCompleteEvent();
    }
}
