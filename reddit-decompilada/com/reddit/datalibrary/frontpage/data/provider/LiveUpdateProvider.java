package com.reddit.datalibrary.frontpage.data.provider;

import com.reddit.datalibrary.frontpage.data.common.busevents.BaseEvent;
import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteRedditApiDataSource;
import com.reddit.datalibrary.frontpage.requests.models.v2.Listing;
import com.reddit.datalibrary.frontpage.requests.models.v2.LiveUpdate;
import com.reddit.frontpage.FrontpageApplication;
import de.greenrobot.event.EventBus;
import io.reactivex.observers.DisposableSingleObserver;
import javax.inject.Inject;

public class LiveUpdateProvider extends BaseListingProvider2<LiveUpdate> {
    public long f18753b;
    @Inject
    RemoteRedditApiDataSource f18754c;
    private final String f18755d;

    public static class LiveUpdateLoadEvent extends BaseEvent {
        public final boolean f16259a;

        public LiveUpdateLoadEvent(boolean z) {
            this.f16259a = z;
        }
    }

    public LiveUpdateProvider(String str) {
        FrontpageApplication.m().a(this);
        this.f18755d = str;
    }

    public final void mo3798c(final boolean z, String str) {
        str = (this.listing == null || z) ? null : this.listing.getAfter();
        this.f18753b = System.currentTimeMillis();
        RemoteRedditApiDataSource.m8914c(this.f18755d, str).subscribeOn(FrontpageApplication.k().t().mo3777a()).subscribe(new DisposableSingleObserver<Listing<LiveUpdate>>(this) {
            final /* synthetic */ LiveUpdateProvider f18752b;

            public /* synthetic */ void onSuccess(Object obj) {
                this.f18752b.m16195a((Listing) obj, z);
            }

            public void onError(Throwable th) {
                th = this.f18752b.mo3795a(new Exception(th));
                if (th != null) {
                    EventBus.getDefault().post(th);
                }
            }
        });
    }

    public final BaseEvent mo3796a(boolean z) {
        return new LiveUpdateLoadEvent(z);
    }
}
