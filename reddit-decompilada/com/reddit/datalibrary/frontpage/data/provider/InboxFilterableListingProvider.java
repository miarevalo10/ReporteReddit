package com.reddit.datalibrary.frontpage.data.provider;

import android.os.Bundle;
import com.reddit.datalibrary.frontpage.data.common.busevents.BaseEvent;
import com.reddit.datalibrary.frontpage.data.feature.common.NotificationSortType;
import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteRedditApiDataSource;
import com.reddit.datalibrary.frontpage.data.provider.MessageListingProvider.MessageErrorEvent;
import com.reddit.datalibrary.frontpage.data.provider.MessageListingProvider.MessagesEvent;
import com.reddit.datalibrary.frontpage.requests.models.v1.ListChildren.Pagination;
import com.reddit.datalibrary.frontpage.requests.models.v1.Message;
import com.reddit.datalibrary.frontpage.requests.models.v1.MessageListing;
import com.reddit.datalibrary.frontpage.requests.models.v1.MessageWrapper;
import com.reddit.datalibrary.frontpage.requests.models.v1.Notification;
import com.reddit.datalibrary.frontpage.requests.models.v1.NotificationWrapper;
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
import timber.log.Timber;

public class InboxFilterableListingProvider extends MessageListingProvider {
    public NotificationSortType f19434c = NotificationSortType.f10370a;
    @Inject
    RemoteRedditApiDataSource f19435d;
    private LinkedHashMap<String, MessageThread> f19436h = new LinkedHashMap();
    private Pagination f19437i;

    public final /* synthetic */ Object mo3800a(int i) {
        return mo4204b(i);
    }

    public InboxFilterableListingProvider(String str) {
        super(str);
        FrontpageApplication.m().a(this);
    }

    public final boolean m20690a(NotificationSortType notificationSortType) {
        if (notificationSortType == this.f19434c) {
            return null;
        }
        this.f19434c = notificationSortType;
        this.mAfter = null;
        this.f19437i = null;
        mo3790b(true, null);
        return true;
    }

    public final void mo3790b(final boolean z, String str) {
        this.a = true;
        String str2 = null;
        if (this.f19434c == NotificationSortType.f10375f) {
            String str3;
            str = this.f19434c == NotificationSortType.f10375f ? this.f19434c.toString() : null;
            if (z || this.f19437i == null || this.f19437i.after == null) {
                str3 = null;
            } else {
                str2 = this.f19437i.after.trending;
                str3 = this.f19437i.after.inbox;
            }
            str = RemoteRedditApiDataSource.m8891a(str, str2, str3);
        } else if (this.f19434c == NotificationSortType.f10370a) {
            str = RemoteRedditApiDataSource.m8899a(this.mAfter, z);
        } else {
            if (this.f19434c != NotificationSortType.f10370a) {
                str2 = this.f19434c.toString();
            }
            str = RemoteRedditApiDataSource.m8896a(str2, this.mAfter, z);
        }
        str.subscribeOn(SchedulerProvider.b()).observeOn(SchedulerProvider.c()).subscribe(new DisposableSingleObserver<MessageListing>(this) {
            final /* synthetic */ InboxFilterableListingProvider f18738b;

            public /* synthetic */ void onSuccess(Object obj) {
                this.f18738b.mo4203a((MessageListing) obj, z);
            }

            public void onError(Throwable th) {
                this.f18738b.a = false;
                th = this.f18738b.mo3789a(new Exception(th));
                if (th != null) {
                    EventBus.getDefault().post(th);
                }
            }
        });
    }

    public final void mo4203a(MessageListing messageListing, boolean z) {
        if (z) {
            this.f19436h = new LinkedHashMap();
        }
        m20684a(this.f19436h, messageListing.mo3815a().mo3049b());
        if (this.mObjects == null || z) {
            this.mObjects = new ArrayList();
        }
        this.mAfter = messageListing.mo3815a().mo3048a();
        this.f19437i = messageListing.mo3815a().mo3050c();
        m16209b();
        this.a = null;
    }

    public final BaseEvent mo3788a() {
        return new MessagesEvent(this.e);
    }

    public final BaseEvent mo3789a(Exception exception) {
        return new MessageErrorEvent(this.e, exception);
    }

    private static void m20684a(LinkedHashMap<String, MessageThread> linkedHashMap, List<ReplyableWrapper> list) {
        for (ReplyableWrapper replyableWrapper : list) {
            String name;
            MessageThread messageThread;
            if (replyableWrapper instanceof MessageWrapper) {
                MessageWrapper messageWrapper = (MessageWrapper) replyableWrapper;
                name = ((Message) messageWrapper.getData()).first_message_name == null ? ((Message) messageWrapper.getData()).getName() : ((Message) messageWrapper.getData()).first_message_name;
                messageThread = (MessageThread) linkedHashMap.get(name);
                if (messageThread == null) {
                    messageThread = new MessageThread(name);
                    linkedHashMap.put(messageThread.a, messageThread);
                }
                messageThread.b.add(((Message) messageWrapper.getData()).author);
                ReplyableCollapseTreeHelper.a(messageThread.c, messageWrapper);
            } else if (replyableWrapper instanceof NotificationWrapper) {
                NotificationWrapper notificationWrapper = (NotificationWrapper) replyableWrapper;
                name = ((Notification) notificationWrapper.getData()).getId();
                messageThread = new MessageThread(name);
                linkedHashMap.put(name, messageThread);
                ReplyableCollapseTreeHelper.a(messageThread.c, notificationWrapper);
            } else {
                Timber.e("Wrapper is not of type MessageWrapper or NotificationWrapper", new Object[0]);
            }
        }
    }

    public final int mo3802c() {
        return this.f19436h.size();
    }

    public final boolean mo4205d() {
        if (this.mAfter == null) {
            if (this.f19437i == null) {
                return false;
            }
        }
        return true;
    }

    public final MessageThread mo4204b(int i) {
        return (MessageThread) this.f19436h.values().toArray()[i];
    }

    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        ArrayList arrayList = (ArrayList) bundle.getSerializable("threads");
        bundle = bundle.getSerializable("filter");
        if (bundle != null) {
            bundle = (NotificationSortType) bundle;
        } else {
            bundle = NotificationSortType.f10370a;
        }
        this.f19434c = bundle;
        this.f19436h = new LinkedHashMap();
        bundle = arrayList.iterator();
        while (bundle.hasNext()) {
            MessageThread messageThread = (MessageThread) bundle.next();
            this.f19436h.put(messageThread.a, messageThread);
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Serializable arrayList = new ArrayList();
        for (Object obj : this.f19436h.values().toArray()) {
            arrayList.add((MessageThread) obj);
        }
        bundle.putSerializable("threads", arrayList);
        bundle.putSerializable("filter", this.f19434c);
    }
}
