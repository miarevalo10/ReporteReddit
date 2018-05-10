package com.reddit.datalibrary.frontpage.data.provider;

import com.reddit.datalibrary.frontpage.data.feature.legacy.AsyncCallback;
import com.reddit.datalibrary.frontpage.data.feature.legacy.LegacySubredditRepository;
import com.reddit.datalibrary.frontpage.requests.models.v2.SubredditNameInfo;
import com.reddit.frontpage.FrontpageApplication;
import io.reactivex.subjects.PublishSubject;
import java.util.List;
import javax.inject.Inject;
import timber.log.Timber;

public class SubredditNameInfoProvider {
    public final PublishSubject<List<SubredditNameInfo>> f10798a = PublishSubject.create();
    @Inject
    public LegacySubredditRepository f10799b;

    class C15471 implements AsyncCallback<List<SubredditNameInfo>> {
        final /* synthetic */ String f16273a;
        final /* synthetic */ SubredditNameInfoProvider f16274b;

        public C15471(SubredditNameInfoProvider subredditNameInfoProvider, String str) {
            this.f16274b = subredditNameInfoProvider;
            this.f16273a = str;
        }

        public final /* synthetic */ void mo3014a(Object obj) {
            this.f16274b.f10798a.onNext((List) obj);
        }

        public final void mo3013a(Exception exception) {
            Timber.c(exception, "Issue retrieving subreddit name info list for %s", new Object[]{this.f16273a});
            this.f16274b.f10798a.onError(exception);
        }
    }

    public SubredditNameInfoProvider() {
        FrontpageApplication.e().mo3000a(this);
    }
}
