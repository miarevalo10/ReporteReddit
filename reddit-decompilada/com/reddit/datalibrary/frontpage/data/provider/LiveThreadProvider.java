package com.reddit.datalibrary.frontpage.data.provider;

import com.evernote.android.state.State;
import com.reddit.datalibrary.frontpage.data.common.busevents.BaseEvent;
import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteRedditApiDataSource;
import com.reddit.datalibrary.frontpage.requests.models.v2.LiveThread;
import com.reddit.datalibrary.frontpage.requests.models.v2.ParcelerBundler;
import com.reddit.frontpage.FrontpageApplication;
import de.greenrobot.event.EventBus;
import io.reactivex.observers.DisposableSingleObserver;
import org.parceler.Parcel;
import timber.log.Timber;

@Parcel
public class LiveThreadProvider extends BaseOtherProvider {
    @State(ParcelerBundler.class)
    LiveThread liveThread;
    @State
    String liveThreadId;

    public static class LiveThreadLoadEvent extends BaseEvent {
        public final String f16258a;

        public LiveThreadLoadEvent(String str) {
            this.f16258a = str;
        }
    }

    class C16951 extends DisposableSingleObserver<LiveThread> {
        final /* synthetic */ LiveThreadProvider f18750a;

        C16951(LiveThreadProvider liveThreadProvider) {
            this.f18750a = liveThreadProvider;
        }

        public /* synthetic */ void onSuccess(Object obj) {
            this.f18750a.liveThread = (LiveThread) obj;
            this.f18750a.publishEvent();
        }

        public void onError(Throwable th) {
            Timber.e(th.getMessage(), new Object[0]);
        }
    }

    LiveThreadProvider() {
    }

    public LiveThreadProvider(String str) {
        this.liveThreadId = str;
    }

    public LiveThreadProvider(LiveThread liveThread) {
        this.liveThread = liveThread;
        this.liveThreadId = liveThread.getId();
    }

    public void load() {
        load(false);
    }

    public void refresh() {
        load(true);
    }

    public LiveThread getLiveThread() {
        return this.liveThread;
    }

    private void load(boolean z) {
        if (z || !this.liveThread) {
            z = new RemoteRedditApiDataSource();
            RemoteRedditApiDataSource.m8920d(this.liveThreadId).subscribeOn(FrontpageApplication.k().t().mo3777a()).subscribe(new C16951(this));
            return;
        }
        publishEvent();
    }

    private void publishEvent() {
        EventBus.getDefault().post(new LiveThreadLoadEvent(this.liveThreadId));
    }
}
