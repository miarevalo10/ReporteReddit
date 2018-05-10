package com.reddit.datalibrary.frontpage.data.provider;

import android.support.v4.content.Loader;
import com.reddit.frontpage.FrontpageApplication;
import de.greenrobot.event.EventBus;

public class SubscribedSubredditProvider extends SubredditLoaderProvider {

    public static class SubscribedSubredditLoadEvent {
    }

    protected final void mo3803d() {
        EventBus.getDefault().post(new SubscribedSubredditLoadEvent());
    }

    public final /* bridge */ /* synthetic */ Loader mo1526a() {
        return this.a.f10419b.mo2933a(FrontpageApplication.a);
    }
}
