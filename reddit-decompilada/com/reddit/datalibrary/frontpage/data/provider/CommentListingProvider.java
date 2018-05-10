package com.reddit.datalibrary.frontpage.data.provider;

import com.evernote.android.state.State;
import com.reddit.datalibrary.frontpage.data.common.busevents.BaseEvent;
import com.reddit.datalibrary.frontpage.data.common.busevents.ErrorEvent;
import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteRedditApiDataSource;
import com.reddit.datalibrary.frontpage.requests.models.v1.CommentListing;
import com.reddit.datalibrary.frontpage.requests.models.v1.CommentWrapper;
import com.reddit.datalibrary.frontpage.requests.models.v1.Listing;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.commons.analytics.performance.ListingPerformanceTracker;
import com.reddit.frontpage.util.SchedulerProvider;
import de.greenrobot.event.EventBus;
import io.reactivex.observers.DisposableSingleObserver;
import javax.inject.Inject;

public class CommentListingProvider extends BaseListingProvider<CommentWrapper, CommentListing> {
    @Inject
    RemoteRedditApiDataSource f18725c;
    @State
    String username;

    public static class CommentListingEvent extends BaseEvent {
    }

    public static class CommentListingErrorEvent extends ErrorEvent {
        public CommentListingErrorEvent(Exception exception) {
            super(exception);
        }
    }

    public CommentListingProvider(String str) {
        FrontpageApplication.m().a(this);
        this.username = str;
    }

    public final BaseEvent mo3788a() {
        return new CommentListingEvent();
    }

    public final BaseEvent mo3789a(Exception exception) {
        return new CommentListingErrorEvent(exception);
    }

    public final void mo3790b(final boolean z, final String str) {
        RemoteRedditApiDataSource.m8897a(this.username, this.mAfter, z, str).subscribeOn(SchedulerProvider.b()).observeOn(SchedulerProvider.c()).subscribe(new DisposableSingleObserver<CommentListing>(this) {
            final /* synthetic */ CommentListingProvider f18724c;

            public /* synthetic */ void onSuccess(Object obj) {
                CommentListing commentListing = (CommentListing) obj;
                ListingPerformanceTracker.c(str);
                ListingPerformanceTracker.d(str);
                this.f18724c.mo3801a((Listing) commentListing, z);
            }

            public void onError(Throwable th) {
                this.f18724c.a = false;
                th = this.f18724c.mo3789a(new Exception(th));
                if (th != null) {
                    EventBus.getDefault().post(th);
                }
                ListingPerformanceTracker.d(str);
            }
        });
    }
}
