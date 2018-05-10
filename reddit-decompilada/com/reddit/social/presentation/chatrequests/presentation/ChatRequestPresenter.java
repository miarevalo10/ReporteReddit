package com.reddit.social.presentation.chatrequests.presentation;

import com.reddit.datalibrary.social.data.common.StateStorageContract;
import com.reddit.datalibrary.social.data.repo.ChatDataRepositoryContract;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.util.SchedulerProvider;
import com.reddit.frontpage.util.kotlin.ObservablesKt;
import com.reddit.social.analytics.ChatAnalytics;
import com.reddit.social.analytics.ChatAnalytics.Source;
import com.reddit.social.domain.usecases.LoadInviteUseCase;
import com.reddit.social.domain.usecases.LoadMessagesUseCase;
import com.reddit.social.presentation.chatrequests.ChatRequestContract.Presenter;
import com.reddit.social.presentation.chatrequests.ChatRequestContract.View;
import com.reddit.social.presentation.presentationobjects.UserData;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function3;
import io.reactivex.rxkotlin.DisposableKt;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u0014H\u0016J\b\u0010,\u001a\u00020*H\u0016J\u0010\u0010-\u001a\u00020*2\u0006\u0010'\u001a\u00020(H\u0016J\u0010\u0010.\u001a\u00020*2\u0006\u0010/\u001a\u00020\u0004H\u0016J\b\u00100\u001a\u00020*H\u0016J\b\u00101\u001a\u00020*H\u0016J\b\u00102\u001a\u00020*H\u0002J\u0010\u00103\u001a\u00020*2\u0006\u00104\u001a\u00020\u0014H\u0002J\b\u00105\u001a\u00020*H\u0002J&\u00106\u001a\b\u0012\u0004\u0012\u000208072\u0006\u00109\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u00042\u0006\u0010:\u001a\u00020\u0004H\u0017J\u0010\u0010;\u001a\u00020*2\u0006\u0010<\u001a\u00020=H\u0016J\u0010\u0010>\u001a\u00020*2\u0006\u0010<\u001a\u00020=H\u0016J\u0010\u0010?\u001a\u00020*2\u0006\u0010@\u001a\u00020AH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0015\u001a\u00020\u00168\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001b\u001a\u00020\u001c8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0010\u0010!\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\"\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u000e\u0010'\u001a\u00020(X.¢\u0006\u0002\n\u0000¨\u0006B"}, d2 = {"Lcom/reddit/social/presentation/chatrequests/presentation/ChatRequestPresenter;", "Lcom/reddit/social/presentation/chatrequests/ChatRequestContract$Presenter;", "()V", "URL_KEY", "", "chatAnalytics", "Lcom/reddit/social/analytics/ChatAnalytics;", "getChatAnalytics", "()Lcom/reddit/social/analytics/ChatAnalytics;", "setChatAnalytics", "(Lcom/reddit/social/analytics/ChatAnalytics;)V", "chatDataRepository", "Lcom/reddit/datalibrary/social/data/repo/ChatDataRepositoryContract;", "getChatDataRepository", "()Lcom/reddit/datalibrary/social/data/repo/ChatDataRepositoryContract;", "setChatDataRepository", "(Lcom/reddit/datalibrary/social/data/repo/ChatDataRepositoryContract;)V", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "hasNsfwMember", "", "loadInviteUseCase", "Lcom/reddit/social/domain/usecases/LoadInviteUseCase;", "getLoadInviteUseCase", "()Lcom/reddit/social/domain/usecases/LoadInviteUseCase;", "setLoadInviteUseCase", "(Lcom/reddit/social/domain/usecases/LoadInviteUseCase;)V", "loadMessagesUseCase", "Lcom/reddit/social/domain/usecases/LoadMessagesUseCase;", "getLoadMessagesUseCase", "()Lcom/reddit/social/domain/usecases/LoadMessagesUseCase;", "setLoadMessagesUseCase", "(Lcom/reddit/social/domain/usecases/LoadMessagesUseCase;)V", "title", "url", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "view", "Lcom/reddit/social/presentation/chatrequests/ChatRequestContract$View;", "accept", "", "neverSeenNsfwDialog", "acceptInvite", "attachView", "blockUser", "userId", "decline", "detachView", "loadChannelInfo", "networkConnectionChange", "isConnected", "reconnect", "reportUser", "Lio/reactivex/Observable;", "", "userName", "reason", "restore", "stateStorage", "Lcom/reddit/datalibrary/social/data/common/StateStorageContract;", "save", "viewProfile", "userData", "Lcom/reddit/social/presentation/presentationobjects/UserData;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ChatRequestPresenter.kt */
public final class ChatRequestPresenter implements Presenter {
    @Inject
    public ChatDataRepositoryContract f29659a;
    @Inject
    public ChatAnalytics f29660b;
    @Inject
    public LoadInviteUseCase f29661c;
    @Inject
    public LoadMessagesUseCase f29662d;
    String f29663e;
    private final String f29664f = "URL_KEY";
    private CompositeDisposable f29665g;
    private View f29666h;
    private boolean f29667i;
    private String f29668j;

    public ChatRequestPresenter() {
        FrontpageApplication.m28878n().mo5089a(this);
    }

    public static final /* synthetic */ View m30676a(ChatRequestPresenter chatRequestPresenter) {
        chatRequestPresenter = chatRequestPresenter.f29666h;
        if (chatRequestPresenter == null) {
            Intrinsics.m26844a("view");
        }
        return chatRequestPresenter;
    }

    public final ChatAnalytics m30692d() {
        ChatAnalytics chatAnalytics = this.f29660b;
        if (chatAnalytics == null) {
            Intrinsics.m26844a("chatAnalytics");
        }
        return chatAnalytics;
    }

    public final void mo5127a(String str) {
        this.f29663e = str;
    }

    public final void mo5125a(View view) {
        Intrinsics.m26847b(view, "view");
        this.f29665g = new CompositeDisposable();
        if (this.f29663e == null) {
            Timber.e("Channel url is null", new Object[0]);
            view.mo7506a((int) C1761R.string.chat_error_something_went_wrong);
        }
        this.f29666h = view;
        CompositeDisposable compositeDisposable = this.f29665g;
        if (compositeDisposable == null) {
            Intrinsics.m26844a("disposables");
        }
        ChatDataRepositoryContract chatDataRepositoryContract = this.f29659a;
        if (chatDataRepositoryContract == null) {
            Intrinsics.m26844a("chatDataRepository");
        }
        DisposableKt.m26766a(compositeDisposable, chatDataRepositoryContract.mo4516a((Function1) new ChatRequestPresenter$attachView$1(view), (Function1) new ChatRequestPresenter$attachView$2(this)));
        m30680e();
    }

    public final void mo5128a(boolean z) {
        if (this.f29667i && z) {
            z = this.f29666h;
            if (!z) {
                Intrinsics.m26844a("view");
            }
            z.mo7516d();
            return;
        }
        mo5123a();
    }

    public final void mo5126a(UserData userData) {
        Intrinsics.m26847b(userData, "userData");
        userData = this.f29660b;
        if (userData == null) {
            Intrinsics.m26844a("chatAnalytics");
        }
        String str = this.f29663e;
        if (str == null) {
            str = "";
        }
        Intrinsics.m26847b(str, "channelUrl");
        BiFunction biFunction = ChatAnalytics$invitationViewMember$combine$1.f29571a;
        LoadMessagesUseCase loadMessagesUseCase = userData.f22294d;
        if (loadMessagesUseCase == null) {
            Intrinsics.m26844a("loadMessagesUseCase");
        }
        ObservableSource a = loadMessagesUseCase.m24494a(str, false);
        ChatDataRepositoryContract chatDataRepositoryContract = userData.f22291a;
        if (chatDataRepositoryContract == null) {
            Intrinsics.m26844a("chatDataRepository");
        }
        Observable zip = Observable.zip(a, chatDataRepositoryContract.mo4506a(str), biFunction);
        Intrinsics.m26843a((Object) zip, "Observable.zip(loadMessa…nel(channelUrl), combine)");
        ObservablesKt.m24091a(zip, (Function1) new ChatAnalytics$invitationViewMember$1(userData, str));
    }

    public final void mo5132c() {
        CompositeDisposable compositeDisposable = this.f29665g;
        if (compositeDisposable == null) {
            Intrinsics.m26844a("disposables");
        }
        compositeDisposable.mo5626a();
    }

    public final void mo5130b(StateStorageContract stateStorageContract) {
        Intrinsics.m26847b(stateStorageContract, "stateStorage");
        this.f29663e = stateStorageContract.mo4477b(this.f29664f);
    }

    private final void m30680e() {
        String str = this.f29663e;
        if (str != null) {
            Function3 function3 = ChatRequestPresenter$loadChannelInfo$combine$1.f29658a;
            CompositeDisposable compositeDisposable = this.f29665g;
            if (compositeDisposable == null) {
                Intrinsics.m26844a("disposables");
            }
            ChatDataRepositoryContract chatDataRepositoryContract = this.f29659a;
            if (chatDataRepositoryContract == null) {
                Intrinsics.m26844a("chatDataRepository");
            }
            ObservableSource a = chatDataRepositoryContract.mo4506a(str);
            LoadInviteUseCase loadInviteUseCase = this.f29661c;
            if (loadInviteUseCase == null) {
                Intrinsics.m26844a("loadInviteUseCase");
            }
            Intrinsics.m26847b(str, "channelUrl");
            ChatDataRepositoryContract chatDataRepositoryContract2 = loadInviteUseCase.f22307a;
            if (chatDataRepositoryContract2 == null) {
                Intrinsics.m26844a("chatDataRepository");
            }
            Object flatMap = chatDataRepositoryContract2.mo4506a(str).flatMap(new LoadInviteUseCase$load$1(loadInviteUseCase));
            Intrinsics.m26843a(flatMap, "chatDataRepository.group…getMembersAndInviter()) }");
            ObservableSource observableSource = (ObservableSource) flatMap;
            LoadMessagesUseCase loadMessagesUseCase = this.f29662d;
            if (loadMessagesUseCase == null) {
                Intrinsics.m26844a("loadMessagesUseCase");
            }
            Object subscribe = Observable.zip(a, observableSource, (ObservableSource) loadMessagesUseCase.m24494a(str, true), function3).observeOn(SchedulerProvider.m23887c()).subscribe(new ChatRequestPresenter$loadChannelInfo$1(this, str), new ChatRequestPresenter$loadChannelInfo$2(this));
            Intrinsics.m26843a(subscribe, "Observable.zip(chatDataR…ing_went_wrong)\n        }");
            DisposableKt.m26766a(compositeDisposable, subscribe);
        }
    }

    public final void mo5123a() {
        if (this.f29663e == null) {
            Timber.e("Channel url is null", new Object[0]);
            View view = this.f29666h;
            if (view == null) {
                Intrinsics.m26844a("view");
            }
            view.mo7506a((int) C1761R.string.chat_error_something_went_wrong);
        }
        String str = this.f29663e;
        if (str != null) {
            View view2 = this.f29666h;
            if (view2 == null) {
                Intrinsics.m26844a("view");
            }
            view2.mo7515c();
            CompositeDisposable compositeDisposable = this.f29665g;
            if (compositeDisposable == null) {
                Intrinsics.m26844a("disposables");
            }
            ChatDataRepositoryContract chatDataRepositoryContract = this.f29659a;
            if (chatDataRepositoryContract == null) {
                Intrinsics.m26844a("chatDataRepository");
            }
            Object subscribeWith = chatDataRepositoryContract.mo4540k(str).observeOn(SchedulerProvider.m23887c()).doAfterTerminate(new ChatRequestPresenter$acceptInvite$1(this)).subscribeWith(new ChatRequestPresenter$acceptInvite$2(this, str));
            Intrinsics.m26843a(subscribeWith, "chatDataRepository.accep…OP\n          }\n        })");
            DisposableKt.m26766a(compositeDisposable, (Disposable) subscribeWith);
        }
    }

    public final void mo5129b() {
        if (this.f29663e == null) {
            Timber.e("Channel url is null", new Object[0]);
            View view = this.f29666h;
            if (view == null) {
                Intrinsics.m26844a("view");
            }
            view.mo7506a((int) C1761R.string.chat_error_something_went_wrong);
        }
        String str = this.f29663e;
        if (str != null) {
            View view2 = this.f29666h;
            if (view2 == null) {
                Intrinsics.m26844a("view");
            }
            view2.mo7515c();
            CompositeDisposable compositeDisposable = this.f29665g;
            if (compositeDisposable == null) {
                Intrinsics.m26844a("disposables");
            }
            ChatDataRepositoryContract chatDataRepositoryContract = this.f29659a;
            if (chatDataRepositoryContract == null) {
                Intrinsics.m26844a("chatDataRepository");
            }
            Object subscribeWith = chatDataRepositoryContract.mo4541l(str).observeOn(SchedulerProvider.m23887c()).doAfterTerminate(new ChatRequestPresenter$decline$1(this)).subscribeWith(new ChatRequestPresenter$decline$2(this, str));
            Intrinsics.m26843a(subscribeWith, "chatDataRepository.decli…{\n\n          }\n        })");
            DisposableKt.m26766a(compositeDisposable, (Disposable) subscribeWith);
        }
    }

    public final void mo5131b(String str) {
        Intrinsics.m26847b(str, "userId");
        String str2 = this.f29663e;
        if (str2 == null) {
            str = this.f29666h;
            if (str == null) {
                Intrinsics.m26844a("view");
            }
            str.mo7506a((int) C1761R.string.chat_error_something_went_wrong);
            return;
        }
        CompositeDisposable compositeDisposable = this.f29665g;
        if (compositeDisposable == null) {
            Intrinsics.m26844a("disposables");
        }
        ChatDataRepositoryContract chatDataRepositoryContract = this.f29659a;
        if (chatDataRepositoryContract == null) {
            Intrinsics.m26844a("chatDataRepository");
        }
        ObservableSource a = chatDataRepositoryContract.mo4506a(str2);
        chatDataRepositoryContract = this.f29659a;
        if (chatDataRepositoryContract == null) {
            Intrinsics.m26844a("chatDataRepository");
        }
        ObservableSource o = chatDataRepositoryContract.mo4544o(str);
        ChatDataRepositoryContract chatDataRepositoryContract2 = this.f29659a;
        if (chatDataRepositoryContract2 == null) {
            Intrinsics.m26844a("chatDataRepository");
        }
        Object subscribe = Observable.zip(a, o, (ObservableSource) chatDataRepositoryContract2.mo4543n(str), (Function3) ChatRequestPresenter$blockUser$1.f29650a).observeOn(SchedulerProvider.m23887c()).subscribe(new ChatRequestPresenter$blockUser$2(this, str), (Consumer) new ChatRequestPresenter$blockUser$3(this));
        Intrinsics.m26843a(subscribe, "Observable.zip(\n        …ror: \" + error)\n        }");
        DisposableKt.m26766a(compositeDisposable, subscribe);
    }

    public final Observable<Object> mo5122a(String str, String str2, String str3) {
        Intrinsics.m26847b(str, "userName");
        Intrinsics.m26847b(str2, "userId");
        Intrinsics.m26847b(str3, "reason");
        String str4 = this.f29663e;
        if (str4 == null) {
            throw ((Throwable) new Exception("You don't have channel url"));
        }
        ChatAnalytics chatAnalytics = this.f29660b;
        if (chatAnalytics == null) {
            Intrinsics.m26844a("chatAnalytics");
        }
        chatAnalytics.m24474b(str4, str2, Source.f22286f);
        str2 = this.f29659a;
        if (str2 == null) {
            Intrinsics.m26844a("chatDataRepository");
        }
        return str2.mo4522c(str, str3);
    }

    public final void mo5124a(StateStorageContract stateStorageContract) {
        Intrinsics.m26847b(stateStorageContract, "stateStorage");
        if (this.f29663e != null) {
            String str = this.f29664f;
            String str2 = this.f29663e;
            if (str2 == null) {
                Intrinsics.m26842a();
            }
            stateStorageContract.mo4475a(str, (CharSequence) str2);
        }
    }

    public static final /* synthetic */ void m30678a(ChatRequestPresenter chatRequestPresenter, boolean z) {
        View view = chatRequestPresenter.f29666h;
        if (view == null) {
            Intrinsics.m26844a("view");
        }
        view.mo7512a(z);
        if (z) {
            chatRequestPresenter.m30680e();
        }
    }
}
