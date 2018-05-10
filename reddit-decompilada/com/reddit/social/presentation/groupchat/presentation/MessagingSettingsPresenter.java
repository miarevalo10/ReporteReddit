package com.reddit.social.presentation.groupchat.presentation;

import com.reddit.datalibrary.social.data.common.StateStorageContract;
import com.reddit.datalibrary.social.data.repo.ChatDataRepositoryContract;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.util.NotificationUtil;
import com.reddit.frontpage.util.SchedulerProvider;
import com.reddit.frontpage.util.SessionUtil;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.util.kotlin.ObservablesKt;
import com.reddit.social.analytics.ChatAnalytics;
import com.reddit.social.analytics.ChatAnalytics.Source;
import com.reddit.social.presentation.groupchat.ChatSettingsContract.Presenter;
import com.reddit.social.presentation.groupchat.ChatSettingsContract.View;
import com.reddit.social.presentation.presentationobjects.ContactData;
import com.reddit.social.presentation.presentationobjects.UserData;
import com.sendbird.android.SendBird;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function3;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jcodec.codecs.mjpeg.JpegConst;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u0004H\u0016J\u0010\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010!\u001a\u00020\u001aH\u0016J\u0010\u0010\"\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\u001fH\u0016J\b\u0010$\u001a\u00020\u001aH\u0016J\u0010\u0010%\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020\u001fH\u0002J\b\u0010'\u001a\u00020\u001aH\u0002J\u0010\u0010(\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020\u0004H\u0016J&\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+2\u0006\u0010-\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u0004H\u0017J\b\u0010/\u001a\u00020\u001aH\u0016J\b\u00100\u001a\u00020\u001aH\u0016J\u0018\u00101\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u0004H\u0016J\u0010\u00102\u001a\u00020\u001a2\u0006\u00103\u001a\u000204H\u0016J\u0010\u00105\u001a\u00020\u001a2\u0006\u00103\u001a\u000204H\u0016J\u0010\u00106\u001a\u00020\u001a2\u0006\u00107\u001a\u00020\u001fH\u0016J\b\u00108\u001a\u00020\u001aH\u0016J\u0010\u00109\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010:\u001a\u00020\u001aH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X.¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X.¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/reddit/social/presentation/groupchat/presentation/MessagingSettingsPresenter;", "Lcom/reddit/social/presentation/groupchat/ChatSettingsContract$Presenter;", "()V", "URL_KEY", "", "channelUrl", "chatAnalytics", "Lcom/reddit/social/analytics/ChatAnalytics;", "getChatAnalytics", "()Lcom/reddit/social/analytics/ChatAnalytics;", "setChatAnalytics", "(Lcom/reddit/social/analytics/ChatAnalytics;)V", "chatDataRepository", "Lcom/reddit/datalibrary/social/data/repo/ChatDataRepositoryContract;", "getChatDataRepository", "()Lcom/reddit/datalibrary/social/data/repo/ChatDataRepositoryContract;", "setChatDataRepository", "(Lcom/reddit/datalibrary/social/data/repo/ChatDataRepositoryContract;)V", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "members", "", "Lcom/reddit/social/presentation/presentationobjects/UserData;", "view", "Lcom/reddit/social/presentation/groupchat/ChatSettingsContract$View;", "addToGroupClicked", "", "blockUser", "userId", "groupNameFocusChanged", "hasFocus", "", "init", "leaveGroup", "load", "refresh", "membersCountClicked", "networkConnectionChange", "isConnected", "reconnect", "renameChannel", "name", "reportUser", "Lio/reactivex/Observable;", "", "userName", "reason", "requestLeaveGroup", "requestStartGroupChat", "requestUserBlock", "restore", "stateStorage", "Lcom/reddit/datalibrary/social/data/common/StateStorageContract;", "save", "setChannelMuted", "mute", "viewAttached", "viewCreated", "viewDestroyed", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: MessagingSettingsPresenter.kt */
public final class MessagingSettingsPresenter implements Presenter {
    @Inject
    public ChatDataRepositoryContract f29839a;
    @Inject
    public ChatAnalytics f29840b;
    private final String f29841c = "URL_KEY";
    private String f29842d;
    private View f29843e;
    private List<UserData> f29844f;
    private CompositeDisposable f29845g;

    public MessagingSettingsPresenter() {
        FrontpageApplication.m28878n().mo5096a(this);
    }

    public static final /* synthetic */ List m30827a(MessagingSettingsPresenter messagingSettingsPresenter) {
        messagingSettingsPresenter = messagingSettingsPresenter.f29844f;
        if (messagingSettingsPresenter == null) {
            Intrinsics.m26844a("members");
        }
        return messagingSettingsPresenter;
    }

    public static final /* synthetic */ View m30830b(MessagingSettingsPresenter messagingSettingsPresenter) {
        messagingSettingsPresenter = messagingSettingsPresenter.f29843e;
        if (messagingSettingsPresenter == null) {
            Intrinsics.m26844a("view");
        }
        return messagingSettingsPresenter;
    }

    public static final /* synthetic */ String m30831c(MessagingSettingsPresenter messagingSettingsPresenter) {
        messagingSettingsPresenter = messagingSettingsPresenter.f29842d;
        if (messagingSettingsPresenter == null) {
            Intrinsics.m26844a("channelUrl");
        }
        return messagingSettingsPresenter;
    }

    public final void mo5181a(View view) {
        Intrinsics.m26847b(view, "view");
        this.f29843e = view;
        this.f29845g = new CompositeDisposable();
        CompositeDisposable compositeDisposable = this.f29845g;
        if (compositeDisposable == null) {
            Intrinsics.m26844a("disposables");
        }
        ChatDataRepositoryContract chatDataRepositoryContract = this.f29839a;
        if (chatDataRepositoryContract == null) {
            Intrinsics.m26844a("chatDataRepository");
        }
        DisposableKt.m26766a(compositeDisposable, chatDataRepositoryContract.mo4516a((Function1) new MessagingSettingsPresenter$viewCreated$1(view), (Function1) new MessagingSettingsPresenter$viewCreated$2(this)));
        view = this.f29840b;
        if (view == null) {
            Intrinsics.m26844a("chatAnalytics");
        }
        String str = this.f29842d;
        if (str == null) {
            Intrinsics.m26844a("channelUrl");
        }
        Intrinsics.m26847b(str, "channelUrl");
        view = view.f22291a;
        if (view == null) {
            Intrinsics.m26844a("chatDataRepository");
        }
        ObservablesKt.m24091a(view.mo4506a(str), (Function1) new ChatAnalytics$chatSettings$1(str));
    }

    public final void mo5182a(String str) {
        Intrinsics.m26847b(str, "channelUrl");
        this.f29842d = str;
    }

    public final void mo5179a() {
        boolean a = NotificationUtil.m23854a();
        if (a) {
            View view;
            view = this.f29843e;
            if (view == null) {
                Intrinsics.m26844a("view");
            }
            view.as_();
            return;
        }
        if (!a) {
            view = this.f29843e;
            if (view == null) {
                Intrinsics.m26844a("view");
            }
            view.ar_();
        }
    }

    public final void mo5184a(boolean z) {
        CompositeDisposable compositeDisposable = this.f29845g;
        if (compositeDisposable == null) {
            Intrinsics.m26844a("disposables");
        }
        ChatDataRepositoryContract chatDataRepositoryContract = this.f29839a;
        if (chatDataRepositoryContract == null) {
            Intrinsics.m26844a("chatDataRepository");
        }
        String str = this.f29842d;
        if (str == null) {
            Intrinsics.m26844a("channelUrl");
        }
        ObservableSource a = chatDataRepositoryContract.mo4506a(str);
        ChatDataRepositoryContract chatDataRepositoryContract2 = this.f29839a;
        if (chatDataRepositoryContract2 == null) {
            Intrinsics.m26844a("chatDataRepository");
        }
        String str2 = this.f29842d;
        if (str2 == null) {
            Intrinsics.m26844a("channelUrl");
        }
        Observable observeOn = Observable.combineLatest(a, (ObservableSource) chatDataRepositoryContract2.mo4529e(str2, z), (BiFunction) MessagingSettingsPresenter$load$1.f29829a).observeOn(SchedulerProvider.m23887c());
        Intrinsics.m26843a((Object) observeOn, "Observable.combineLatest…n(SchedulerProvider.ui())");
        DisposableKt.m26766a(compositeDisposable, ObservablesKt.m24091a(observeOn, (Function1) new MessagingSettingsPresenter$load$2(this)));
        z = this.f29845g;
        if (!z) {
            Intrinsics.m26844a("disposables");
        }
        ChatDataRepositoryContract chatDataRepositoryContract3 = this.f29839a;
        if (chatDataRepositoryContract3 == null) {
            Intrinsics.m26844a("chatDataRepository");
        }
        String str3 = this.f29842d;
        if (str3 == null) {
            Intrinsics.m26844a("channelUrl");
        }
        ObservableSource m = chatDataRepositoryContract3.mo4542m(str3);
        chatDataRepositoryContract = this.f29839a;
        if (chatDataRepositoryContract == null) {
            Intrinsics.m26844a("chatDataRepository");
        }
        str = this.f29842d;
        if (str == null) {
            Intrinsics.m26844a("channelUrl");
        }
        Object subscribe = Observable.zip(m, chatDataRepositoryContract.mo4551v(str).subscribeOn(SchedulerProvider.m23886b()), MessagingSettingsPresenter$load$3.f29830a).observeOn(SchedulerProvider.m23887c()).subscribe(new MessagingSettingsPresenter$load$4(this), new MessagingSettingsPresenter$load$5(this));
        Intrinsics.m26843a(subscribe, "Observable.zip(\n        …nelMuteToggle()\n        }");
        DisposableKt.m26766a(z, subscribe);
    }

    public final void mo5189c() {
        ChatAnalytics chatAnalytics = this.f29840b;
        if (chatAnalytics == null) {
            Intrinsics.m26844a("chatAnalytics");
        }
        String str = this.f29842d;
        if (str == null) {
            Intrinsics.m26844a("channelUrl");
        }
        Intrinsics.m26847b(str, "channelUrl");
        ChatDataRepositoryContract chatDataRepositoryContract = chatAnalytics.f22291a;
        if (chatDataRepositoryContract == null) {
            Intrinsics.m26844a("chatDataRepository");
        }
        ObservablesKt.m24091a(chatDataRepositoryContract.mo4506a(str), (Function1) new ChatAnalytics$chatLeaveGroup$1(str));
        CompositeDisposable compositeDisposable = this.f29845g;
        if (compositeDisposable == null) {
            Intrinsics.m26844a("disposables");
        }
        ChatDataRepositoryContract chatDataRepositoryContract2 = this.f29839a;
        if (chatDataRepositoryContract2 == null) {
            Intrinsics.m26844a("chatDataRepository");
        }
        String str2 = this.f29842d;
        if (str2 == null) {
            Intrinsics.m26844a("channelUrl");
        }
        Object subscribe = chatDataRepositoryContract2.mo4545p(str2).observeOn(SchedulerProvider.m23887c()).subscribe(new MessagingSettingsPresenter$leaveGroup$1(this), new MessagingSettingsPresenter$leaveGroup$2(this));
        Intrinsics.m26843a(subscribe, "chatDataRepository.leave…e you from this group\") }");
        DisposableKt.m26766a(compositeDisposable, subscribe);
    }

    public final void mo5188b(boolean z) {
        Observable w;
        ChatDataRepositoryContract chatDataRepositoryContract;
        String str;
        if (z) {
            chatDataRepositoryContract = this.f29839a;
            if (chatDataRepositoryContract == null) {
                Intrinsics.m26844a("chatDataRepository");
            }
            str = this.f29842d;
            if (str == null) {
                Intrinsics.m26844a("channelUrl");
            }
            w = chatDataRepositoryContract.mo4552w(str);
        } else {
            chatDataRepositoryContract = this.f29839a;
            if (chatDataRepositoryContract == null) {
                Intrinsics.m26844a("chatDataRepository");
            }
            str = this.f29842d;
            if (str == null) {
                Intrinsics.m26844a("channelUrl");
            }
            w = chatDataRepositoryContract.mo4553x(str);
        }
        w = w.subscribeOn(SchedulerProvider.m23886b());
        CompositeDisposable compositeDisposable = this.f29845g;
        if (compositeDisposable == null) {
            Intrinsics.m26844a("disposables");
        }
        ObservableSource observableSource = w;
        ChatDataRepositoryContract chatDataRepositoryContract2 = this.f29839a;
        if (chatDataRepositoryContract2 == null) {
            Intrinsics.m26844a("chatDataRepository");
        }
        String str2 = this.f29842d;
        if (str2 == null) {
            Intrinsics.m26844a("channelUrl");
        }
        Object subscribe = Observable.zip(observableSource, chatDataRepositoryContract2.mo4525d(str2, z ^ 1), MessagingSettingsPresenter$setChannelMuted$1.f29835a).observeOn(SchedulerProvider.m23887c()).subscribe(new MessagingSettingsPresenter$setChannelMuted$2(this, z), (Consumer) new MessagingSettingsPresenter$setChannelMuted$3(this));
        Intrinsics.m26843a(subscribe, "Observable.zip(\n        …nelMuteToggle()\n        }");
        DisposableKt.m26766a(compositeDisposable, subscribe);
    }

    public final void mo5183a(String str, String str2) {
        Intrinsics.m26847b(str, "userId");
        Intrinsics.m26847b(str2, "userName");
        View view = this.f29843e;
        if (view == null) {
            Intrinsics.m26844a("view");
        }
        view.mo7574a(str, str2);
    }

    public final void mo5192d() {
        View view = this.f29843e;
        if (view == null) {
            Intrinsics.m26844a("view");
        }
        view.mo7581b();
    }

    public final void mo5193e() {
        ContactData contactData;
        List list = this.f29844f;
        if (list == null) {
            Intrinsics.m26844a("members");
        }
        for (Object next : list) {
            if ((Intrinsics.m26845a(((UserData) next).f22464a, SessionUtil.m23898d()) ^ 1) != 0) {
                break;
            }
        }
        Object next2 = null;
        UserData userData = (UserData) next2;
        if (userData != null) {
            ContactData contactData2 = new ContactData(userData.f22465b, userData.f22466c, userData.f22464a, null, userData.f22470g, null, null, (int) JpegConst.SOI);
        } else {
            contactData = null;
        }
        View view = this.f29843e;
        if (view == null) {
            Intrinsics.m26844a("view");
        }
        view.mo7572a(contactData);
    }

    public final void mo5191c(boolean z) {
        if (z) {
            z = this.f29843e;
            if (!z) {
                Intrinsics.m26844a("view");
            }
            z.mo7589h();
        }
    }

    public final void mo5190c(String str) {
        Intrinsics.m26847b(str, "name");
        str = StringsKt__StringsKt.m42456b((CharSequence) str).toString();
        if ((((CharSequence) str).length() == 0 ? 1 : null) != null) {
            str = this.f29843e;
            if (str == null) {
                Intrinsics.m26844a("view");
            }
            String f = Util.m24027f((int) C1761R.string.chat_error_channel_name_blank);
            Intrinsics.m26843a((Object) f, "Util.getString(R.string.…error_channel_name_blank)");
            str.mo7573a(f);
            return;
        }
        View view = this.f29843e;
        if (view == null) {
            Intrinsics.m26844a("view");
        }
        view.mo7590i();
        view = this.f29843e;
        if (view == null) {
            Intrinsics.m26844a("view");
        }
        view.mo7588g();
        CompositeDisposable compositeDisposable = this.f29845g;
        if (compositeDisposable == null) {
            Intrinsics.m26844a("disposables");
        }
        ChatDataRepositoryContract chatDataRepositoryContract = this.f29839a;
        if (chatDataRepositoryContract == null) {
            Intrinsics.m26844a("chatDataRepository");
        }
        String str2 = this.f29842d;
        if (str2 == null) {
            Intrinsics.m26844a("channelUrl");
        }
        Object subscribe = chatDataRepositoryContract.mo4509a(str2, str).observeOn(SchedulerProvider.m23887c()).subscribe(MessagingSettingsPresenter$renameChannel$1.f29833a, new MessagingSettingsPresenter$renameChannel$2(this));
        Intrinsics.m26843a(subscribe, "chatDataRepository.setCh…_channel))\n            })");
        DisposableKt.m26766a(compositeDisposable, subscribe);
    }

    public final void mo5194f() {
        View view = this.f29843e;
        if (view == null) {
            Intrinsics.m26844a("view");
        }
        String str = this.f29842d;
        if (str == null) {
            Intrinsics.m26844a("channelUrl");
        }
        List list = this.f29844f;
        if (list == null) {
            Intrinsics.m26844a("members");
        }
        view.mo7575a(str, list);
    }

    public final void mo5195g() {
        View view = this.f29843e;
        if (view == null) {
            Intrinsics.m26844a("view");
        }
        String str = this.f29842d;
        if (str == null) {
            Intrinsics.m26844a("channelUrl");
        }
        List list = this.f29844f;
        if (list == null) {
            Intrinsics.m26844a("members");
        }
        view.mo7576a(str, CollectionsKt___CollectionsKt.m41451p(list));
    }

    public final Observable<Object> mo5178a(String str, String str2, String str3) {
        Intrinsics.m26847b(str, "userName");
        Intrinsics.m26847b(str2, "userId");
        Intrinsics.m26847b(str3, "reason");
        ChatAnalytics chatAnalytics = this.f29840b;
        if (chatAnalytics == null) {
            Intrinsics.m26844a("chatAnalytics");
        }
        String str4 = this.f29842d;
        if (str4 == null) {
            Intrinsics.m26844a("channelUrl");
        }
        chatAnalytics.m24474b(str4, str2, Source.f22284d);
        str2 = this.f29839a;
        if (str2 == null) {
            Intrinsics.m26844a("chatDataRepository");
        }
        return str2.mo4522c(str, str3);
    }

    public final void mo5187b(String str) {
        Intrinsics.m26847b(str, "userId");
        CompositeDisposable compositeDisposable = this.f29845g;
        if (compositeDisposable == null) {
            Intrinsics.m26844a("disposables");
        }
        ChatDataRepositoryContract chatDataRepositoryContract = this.f29839a;
        if (chatDataRepositoryContract == null) {
            Intrinsics.m26844a("chatDataRepository");
        }
        ObservableSource o = chatDataRepositoryContract.mo4544o(str);
        ChatDataRepositoryContract chatDataRepositoryContract2 = this.f29839a;
        if (chatDataRepositoryContract2 == null) {
            Intrinsics.m26844a("chatDataRepository");
        }
        ObservableSource n = chatDataRepositoryContract2.mo4543n(str);
        ChatDataRepositoryContract chatDataRepositoryContract3 = this.f29839a;
        if (chatDataRepositoryContract3 == null) {
            Intrinsics.m26844a("chatDataRepository");
        }
        String str2 = this.f29842d;
        if (str2 == null) {
            Intrinsics.m26844a("channelUrl");
        }
        Object subscribe = Observable.zip(o, n, (ObservableSource) chatDataRepositoryContract3.mo4546q(str2), (Function3) MessagingSettingsPresenter$blockUser$1.f29823a).observeOn(SchedulerProvider.m23887c()).subscribe(new MessagingSettingsPresenter$blockUser$2(this, str), (Consumer) new MessagingSettingsPresenter$blockUser$3(this));
        Intrinsics.m26843a(subscribe, "Observable.zip(\n        …ror: \" + error)\n        }");
        DisposableKt.m26766a(compositeDisposable, subscribe);
    }

    public final void mo5185b() {
        CompositeDisposable compositeDisposable = this.f29845g;
        if (compositeDisposable == null) {
            Intrinsics.m26844a("disposables");
        }
        compositeDisposable.mo5626a();
    }

    public final void mo5180a(StateStorageContract stateStorageContract) {
        Intrinsics.m26847b(stateStorageContract, "stateStorage");
        String str = this.f29841c;
        String str2 = this.f29842d;
        if (str2 == null) {
            Intrinsics.m26844a("channelUrl");
        }
        stateStorageContract.mo4475a(str, (CharSequence) str2);
        stateStorageContract = SendBird.m25001k();
        if (stateStorageContract != null) {
            ChatDataRepositoryContract chatDataRepositoryContract = this.f29839a;
            if (chatDataRepositoryContract == null) {
                Intrinsics.m26844a("chatDataRepository");
            }
            Object d = stateStorageContract.m25021d();
            Intrinsics.m26843a(d, "it.userId");
            chatDataRepositoryContract.mo4549t(d);
        }
    }

    public final void mo5186b(StateStorageContract stateStorageContract) {
        Intrinsics.m26847b(stateStorageContract, "stateStorage");
        stateStorageContract = stateStorageContract.mo4477b(this.f29841c);
        if (stateStorageContract == null) {
            throw ((Throwable) new Exception("weird. restore should return notnull channel url"));
        }
        this.f29842d = stateStorageContract;
    }

    public static final /* synthetic */ void m30829a(MessagingSettingsPresenter messagingSettingsPresenter, boolean z) {
        View view = messagingSettingsPresenter.f29843e;
        if (view == null) {
            Intrinsics.m26844a("view");
        }
        view.b_(z);
        if (z) {
            messagingSettingsPresenter.mo5184a(true);
        }
    }
}
