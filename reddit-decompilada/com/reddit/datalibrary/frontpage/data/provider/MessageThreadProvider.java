package com.reddit.datalibrary.frontpage.data.provider;

import com.evernote.android.state.State;
import com.reddit.datalibrary.frontpage.data.common.busevents.BaseEvent;
import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteRedditApiDataSource;
import com.reddit.datalibrary.frontpage.requests.models.v1.MessageListing;
import com.reddit.datalibrary.frontpage.requests.models.v1.ReplyableWrapper;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.ui.detail.comments.ReplyableCollapseTreeHelper;
import com.reddit.frontpage.ui.detail.comments.collapsetree.CollapseTree;
import de.greenrobot.event.EventBus;
import io.reactivex.observers.DisposableSingleObserver;
import javax.inject.Inject;
import timber.log.Timber;

public class MessageThreadProvider extends BaseOtherProvider {
    @Inject
    RemoteRedditApiDataSource f16268a;
    private MessageThreadEvent f16269b;
    @State
    public CollapseTree mMessageTree;
    @State
    public String threadId;

    public static class MessageThreadEvent extends BaseEvent {
        public final String f16267a;

        public MessageThreadEvent(String str) {
            this.f16267a = str;
        }
    }

    class C16981 extends DisposableSingleObserver<MessageListing> {
        final /* synthetic */ String f18762a;
        final /* synthetic */ MessageThreadProvider f18763b;

        public C16981(MessageThreadProvider messageThreadProvider, String str) {
            this.f18763b = messageThreadProvider;
            this.f18762a = str;
        }

        public /* synthetic */ void onSuccess(Object obj) {
            ReplyableCollapseTreeHelper.a(this.f18763b.mMessageTree, ((MessageListing) obj).mo3815a().mo3049b());
            this.f18763b.f16269b = new MessageThreadEvent(this.f18762a);
            EventBus.getDefault().postSticky(this.f18763b.f16269b);
        }

        public void onError(Throwable th) {
            Timber.e(th.getMessage(), new Object[0]);
        }
    }

    public MessageThreadProvider(String str) {
        FrontpageApplication.m().a(this);
        this.threadId = str;
    }

    public final int m16278a() {
        if (this.mMessageTree == null) {
            return 0;
        }
        return this.mMessageTree.b.size();
    }

    public final ReplyableWrapper m16279a(int i) {
        return this.mMessageTree.a(i).a;
    }
}
