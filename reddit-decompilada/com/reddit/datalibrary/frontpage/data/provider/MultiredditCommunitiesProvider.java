package com.reddit.datalibrary.frontpage.data.provider;

import bolts.Task;
import com.evernote.android.state.State;
import com.reddit.datalibrary.frontpage.data.common.busevents.BaseEvent;
import com.reddit.datalibrary.frontpage.data.common.busevents.ErrorEvent;
import com.reddit.datalibrary.frontpage.data.feature.legacy.AsyncCallback;
import com.reddit.datalibrary.frontpage.data.feature.legacy.AsyncCallbackContinuation;
import com.reddit.datalibrary.frontpage.data.feature.legacy.LegacySubredditRepository;
import com.reddit.datalibrary.frontpage.data.feature.legacy.LegacySubredditRepository$$Lambda$3;
import com.reddit.datalibrary.frontpage.redditauth.account.Session;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.datalibrary.frontpage.requests.models.v2.Multireddit;
import com.reddit.datalibrary.frontpage.requests.models.v2.ParcelerBundler;
import com.reddit.datalibrary.frontpage.requests.models.v2.SubredditInfo;
import com.reddit.frontpage.FrontpageApplication;
import de.greenrobot.event.EventBus;
import java.util.List;
import javax.inject.Inject;

public class MultiredditCommunitiesProvider extends BaseOtherProvider {
    @Inject
    LegacySubredditRepository f16271a;
    @State(ParcelerBundler.class)
    public List<SubredditInfo> communities;
    @State
    String multiredditName;

    class C15441 implements AsyncCallback<Multireddit> {
        final /* synthetic */ MultiredditCommunitiesProvider f16270a;

        C15441(MultiredditCommunitiesProvider multiredditCommunitiesProvider) {
            this.f16270a = multiredditCommunitiesProvider;
        }

        public final /* synthetic */ void mo3014a(Object obj) {
            Multireddit multireddit = (Multireddit) obj;
            this.f16270a.communities = multireddit.getSubreddits();
            MultiredditCommunitiesProvider.m16284c();
        }

        public final void mo3013a(Exception exception) {
            MultiredditCommunitiesProvider.m16283a(exception);
        }
    }

    public static class MultiredditCommunityLoadEvent extends BaseEvent {
    }

    public static class MultiredditCommunityErrorEvent extends ErrorEvent {
        public MultiredditCommunityErrorEvent(Exception exception) {
            super(exception);
        }
    }

    public MultiredditCommunitiesProvider(String str) {
        this.multiredditName = str;
        FrontpageApplication.e().mo2998a(this);
    }

    public final void m16285a() {
        if (this.communities != null) {
            m16284c();
            return;
        }
        Session session = SessionManager.m9191b().f10840c;
        Task.m2407a(new LegacySubredditRepository$$Lambda$3(this.f16271a, session.getUsername(), this.multiredditName)).m2414a(AsyncCallbackContinuation.m15917a(new C15441(this)), Task.f2715b);
    }

    public final int m16286b() {
        return this.communities != null ? this.communities.size() : 0;
    }

    public static void m16284c() {
        EventBus.getDefault().post(new MultiredditCommunityLoadEvent());
    }

    public static void m16283a(Exception exception) {
        EventBus.getDefault().post(new MultiredditCommunityErrorEvent(exception));
    }
}
