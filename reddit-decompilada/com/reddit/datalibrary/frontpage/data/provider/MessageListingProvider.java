package com.reddit.datalibrary.frontpage.data.provider;

import android.os.Bundle;
import com.reddit.datalibrary.frontpage.data.common.busevents.BaseEvent;
import com.reddit.datalibrary.frontpage.data.common.busevents.ErrorEvent;
import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteRedditApiDataSource;
import com.reddit.datalibrary.frontpage.requests.models.v1.Listing;
import com.reddit.datalibrary.frontpage.requests.models.v1.Message;
import com.reddit.datalibrary.frontpage.requests.models.v1.MessageListing;
import com.reddit.datalibrary.frontpage.requests.models.v1.MessageWrapper;
import com.reddit.datalibrary.frontpage.requests.models.v1.ReplyableWrapper;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.ui.detail.comments.ReplyableCollapseTreeHelper;
import com.reddit.frontpage.ui.inbox.MessageThread;
import com.reddit.frontpage.util.SchedulerProvider;
import de.greenrobot.event.EventBus;
import io.reactivex.observers.DisposableSingleObserver;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import javax.inject.Inject;

public class MessageListingProvider extends BaseListingProvider<MessageThread, MessageListing> {
    String f18759e;
    LinkedHashMap<String, MessageThread> f18760f = new LinkedHashMap();
    @Inject
    RemoteRedditApiDataSource f18761g;

    public static class MessagesEvent extends BaseEvent {
        public final String f16266a;

        public MessagesEvent(String str) {
            this.f16266a = str;
        }
    }

    public static class MessageErrorEvent extends ErrorEvent {
        public final String f18758a;

        public MessageErrorEvent(String str, Exception exception) {
            super(exception);
            this.f18758a = str;
        }
    }

    public /* synthetic */ Object mo3800a(int i) {
        return mo4204b(i);
    }

    public MessageListingProvider(String str) {
        FrontpageApplication.m().a(this);
        this.f18759e = str;
    }

    public void mo3790b(final boolean z, String str) {
        RemoteRedditApiDataSource.m8896a(this.f18759e, this.mAfter, z).subscribeOn(SchedulerProvider.b()).observeOn(SchedulerProvider.c()).subscribe(new DisposableSingleObserver<MessageListing>(this) {
            final /* synthetic */ MessageListingProvider f18757b;

            public /* synthetic */ void onSuccess(Object obj) {
                this.f18757b.mo4203a((MessageListing) obj, z);
            }

            public void onError(Throwable th) {
                this.f18757b.a = false;
                th = this.f18757b.mo3789a(new Exception(th));
                if (th != null) {
                    EventBus.getDefault().post(th);
                }
            }
        });
    }

    public void mo4203a(MessageListing messageListing, boolean z) {
        if (z) {
            this.f18760f = new LinkedHashMap();
        }
        m19736a(this.f18760f, messageListing.mo3815a().mo3049b());
        super.mo3801a((Listing) messageListing, z);
    }

    public BaseEvent mo3788a() {
        return new MessagesEvent(this.f18759e);
    }

    public BaseEvent mo3789a(Exception exception) {
        return new MessageErrorEvent(this.f18759e, exception);
    }

    private static void m19736a(LinkedHashMap<String, MessageThread> linkedHashMap, List<ReplyableWrapper> list) {
        for (ReplyableWrapper replyableWrapper : list) {
            MessageWrapper messageWrapper = (MessageWrapper) replyableWrapper;
            String name = ((Message) messageWrapper.getData()).first_message_name == null ? ((Message) messageWrapper.getData()).getName() : ((Message) messageWrapper.getData()).first_message_name;
            MessageThread messageThread = (MessageThread) linkedHashMap.get(name);
            if (messageThread == null) {
                messageThread = new MessageThread(name);
                linkedHashMap.put(messageThread.a, messageThread);
            }
            messageThread.b.add(((Message) messageWrapper.getData()).author);
            ReplyableCollapseTreeHelper.a(messageThread.c, messageWrapper);
        }
    }

    public int mo3802c() {
        return this.f18760f.size();
    }

    public MessageThread mo4204b(int i) {
        return (MessageThread) this.f18760f.values().toArray()[i];
    }

    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        ArrayList arrayList = (ArrayList) bundle.getSerializable("threads");
        this.f18760f = new LinkedHashMap();
        bundle = arrayList.iterator();
        while (bundle.hasNext()) {
            MessageThread messageThread = (MessageThread) bundle.next();
            this.f18760f.put(messageThread.a, messageThread);
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Serializable arrayList = new ArrayList();
        for (Object obj : this.f18760f.values().toArray()) {
            arrayList.add((MessageThread) obj);
        }
        bundle.putSerializable("threads", arrayList);
    }
}
