package com.reddit.datalibrary.frontpage.data.provider;

import com.reddit.datalibrary.frontpage.data.common.busevents.BaseEvent;
import com.reddit.datalibrary.frontpage.data.feature.legacy.AsyncCallback;
import com.reddit.datalibrary.frontpage.data.feature.link.repo.LegacyLinkRepository;
import com.reddit.datalibrary.frontpage.requests.models.v1.CommentResponse;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.commons.analytics.performance.CommentsPerformanceTracker;
import de.greenrobot.event.EventBus;

public class LinkProvider extends BaseOtherProvider {
    public final LegacyLinkRepository f16254a;
    public final String f16255b;
    private Link f16256c;

    class C15431 implements AsyncCallback<CommentResponse> {
        final /* synthetic */ String f16251a;
        final /* synthetic */ LinkProvider f16252b;

        public C15431(LinkProvider linkProvider, String str) {
            this.f16252b = linkProvider;
            this.f16251a = str;
        }

        public final /* synthetic */ void mo3014a(Object obj) {
            this.f16252b.f16256c = ((CommentResponse) obj).link;
            CommentsPerformanceTracker.e(this.f16251a);
            EventBus.getDefault().postSticky(new LinkEvent(this.f16252b.f16256c));
            CommentsPerformanceTracker.f(this.f16251a);
        }

        public final void mo3013a(Exception exception) {
            CommentsPerformanceTracker.f(this.f16251a);
        }
    }

    public static class LinkEvent extends BaseEvent {
        public Link f16253a;

        public LinkEvent(Link link) {
            this.f16253a = link;
        }
    }

    public LinkProvider(LegacyLinkRepository legacyLinkRepository, String str) {
        this.f16254a = legacyLinkRepository;
        this.f16255b = str;
    }

    public void finish() {
        EventBus.getDefault().removeStickyEvent(LinkEvent.class);
    }
}
