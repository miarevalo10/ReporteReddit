package com.reddit.social.presentation.chatinbox.presentation;

import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.datalibrary.social.data.common.StateStorageContract;
import com.reddit.datalibrary.social.data.repo.ChatDataRepositoryContract;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.util.SchedulerProvider;
import com.reddit.frontpage.util.SessionUtil;
import com.reddit.frontpage.util.kotlin.ObservablesKt;
import com.reddit.social.analytics.ChatAnalytics;
import com.reddit.social.analytics.ChatPerformanceAnalyticsContract;
import com.reddit.social.domain.functions.ChannelConversationTransformer;
import com.reddit.social.domain.functions.ChatInboxChannelsTransformer;
import com.reddit.social.domain.usecases.ChatInboxListUseCase;
import com.reddit.social.presentation.chatinbox.ChatInboxContract.Presenter;
import com.reddit.social.presentation.chatinbox.ChatInboxContract.View;
import com.reddit.social.util.ChatUtilKt;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010$\u001a\u00020%H\u0002J:\u0010&\u001a&\u0012\"\u0012 \u0012\n\u0012\b\u0012\u0004\u0012\u00020*0)\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020,0+0(0'2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020*0)H\u0003J\u0010\u0010.\u001a\u00020%2\u0006\u0010/\u001a\u00020\u0004H\u0003J\b\u00100\u001a\u00020%H\u0002J\b\u00101\u001a\u00020%H\u0016J\u0010\u00102\u001a\u00020%2\u0006\u00103\u001a\u00020!H\u0002J\u0010\u00104\u001a\u00020%2\u0006\u0010\"\u001a\u00020#H\u0016J\b\u00105\u001a\u00020%H\u0016J\b\u00106\u001a\u00020%H\u0002J\b\u00107\u001a\u00020%H\u0016J\u0010\u00108\u001a\u00020%2\u0006\u00109\u001a\u00020:H\u0016J\u0010\u0010;\u001a\u00020%2\u0006\u00109\u001a\u00020:H\u0016J\b\u0010<\u001a\u00020%H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u001fX.¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X.¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/reddit/social/presentation/chatinbox/presentation/ChatInboxPresenter;", "Lcom/reddit/social/presentation/chatinbox/ChatInboxContract$Presenter;", "()V", "CHANNEL_HANDLER_CHATS_ID", "", "CHANNEL_HANDLER_INVITES_ID", "chatAnalytics", "Lcom/reddit/social/analytics/ChatAnalytics;", "getChatAnalytics", "()Lcom/reddit/social/analytics/ChatAnalytics;", "setChatAnalytics", "(Lcom/reddit/social/analytics/ChatAnalytics;)V", "chatDataRepository", "Lcom/reddit/datalibrary/social/data/repo/ChatDataRepositoryContract;", "getChatDataRepository", "()Lcom/reddit/datalibrary/social/data/repo/ChatDataRepositoryContract;", "setChatDataRepository", "(Lcom/reddit/datalibrary/social/data/repo/ChatDataRepositoryContract;)V", "chatInboxListUseCase", "Lcom/reddit/social/domain/usecases/ChatInboxListUseCase;", "getChatInboxListUseCase", "()Lcom/reddit/social/domain/usecases/ChatInboxListUseCase;", "setChatInboxListUseCase", "(Lcom/reddit/social/domain/usecases/ChatInboxListUseCase;)V", "chatPerfAnalytics", "Lcom/reddit/social/analytics/ChatPerformanceAnalyticsContract;", "getChatPerfAnalytics", "()Lcom/reddit/social/analytics/ChatPerformanceAnalyticsContract;", "setChatPerfAnalytics", "(Lcom/reddit/social/analytics/ChatPerformanceAnalyticsContract;)V", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "loadingMore", "", "view", "Lcom/reddit/social/presentation/chatinbox/ChatInboxContract$View;", "checkIfShowSplashScreen", "", "fetchUserData", "Lio/reactivex/Observable;", "Lkotlin/Pair;", "", "Lcom/sendbird/android/GroupChannel;", "", "Lcom/reddit/social/presentation/presentationobjects/UserData;", "groupChannels", "loadChatInboxItems", "userId", "loadInboxScreen", "loadMore", "networkConnectionHandler", "isConnected", "onCreateView", "onDestroyView", "reconnect", "refresh", "restore", "stateStorage", "Lcom/reddit/datalibrary/social/data/common/StateStorageContract;", "save", "splashStartClicked", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ChatInboxPresenter.kt */
public final class ChatInboxPresenter implements Presenter {
    @Inject
    public ChatDataRepositoryContract f29614a;
    @Inject
    public ChatAnalytics f29615b;
    @Inject
    public ChatInboxListUseCase f29616c;
    @Inject
    public ChatPerformanceAnalyticsContract f29617d;
    private final String f29618e = "CHANNEL_HANDLER_CHATS_INBOX";
    private final String f29619f = "CHANNEL_HANDLER_INVITES_INBOX";
    private View f29620g;
    private CompositeDisposable f29621h;
    private boolean f29622i;

    public final void mo5110b(StateStorageContract stateStorageContract) {
        Intrinsics.m26847b(stateStorageContract, "stateStorage");
    }

    public ChatInboxPresenter() {
        FrontpageApplication.m28878n().mo5086a(this);
    }

    public static final /* synthetic */ View m30626a(ChatInboxPresenter chatInboxPresenter) {
        chatInboxPresenter = chatInboxPresenter.f29620g;
        if (chatInboxPresenter == null) {
            Intrinsics.m26844a("view");
        }
        return chatInboxPresenter;
    }

    public final ChatAnalytics m30640e() {
        ChatAnalytics chatAnalytics = this.f29615b;
        if (chatAnalytics == null) {
            Intrinsics.m26844a("chatAnalytics");
        }
        return chatAnalytics;
    }

    public final ChatInboxListUseCase m30641f() {
        ChatInboxListUseCase chatInboxListUseCase = this.f29616c;
        if (chatInboxListUseCase == null) {
            Intrinsics.m26844a("chatInboxListUseCase");
        }
        return chatInboxListUseCase;
    }

    public final ChatPerformanceAnalyticsContract m30642g() {
        ChatPerformanceAnalyticsContract chatPerformanceAnalyticsContract = this.f29617d;
        if (chatPerformanceAnalyticsContract == null) {
            Intrinsics.m26844a("chatPerfAnalytics");
        }
        return chatPerformanceAnalyticsContract;
    }

    public final void mo5108a(View view) {
        Intrinsics.m26847b(view, "view");
        this.f29620g = view;
        this.f29621h = new CompositeDisposable();
        Object a = FrontpageSettings.a();
        Intrinsics.m26843a(a, "FrontpageSettings.getInstance()");
        if (a.l() != null) {
            m30632h();
            return;
        }
        view = this.f29614a;
        if (view == null) {
            Intrinsics.m26844a("chatDataRepository");
        }
        Observable observeOn = view.mo4535h().subscribeOn(SchedulerProvider.m23886b()).observeOn(SchedulerProvider.m23887c());
        Intrinsics.m26843a((Object) observeOn, "chatDataRepository.isCha…n(SchedulerProvider.ui())");
        ObservablesKt.m24091a(observeOn, (Function1) new ChatInboxPresenter$checkIfShowSplashScreen$1(this));
    }

    private final void m30629a(String str) {
        View view = this.f29620g;
        if (view == null) {
            Intrinsics.m26844a("view");
        }
        view.mo7491a();
        CompositeDisposable compositeDisposable = this.f29621h;
        if (compositeDisposable == null) {
            Intrinsics.m26844a("disposables");
        }
        ChatInboxListUseCase chatInboxListUseCase = this.f29616c;
        if (chatInboxListUseCase == null) {
            Intrinsics.m26844a("chatInboxListUseCase");
        }
        Object subscribe = chatInboxListUseCase.m24490a(str, false, false).observeOn(SchedulerProvider.m23887c()).doOnNext(new ChatInboxPresenter$loadChatInboxItems$1(this)).flatMap(new ChatInboxPresenter$loadChatInboxItems$2(this)).doOnNext(new ChatInboxPresenter$loadChatInboxItems$3(this)).observeOn(SchedulerProvider.m23887c()).subscribe(new ChatInboxPresenter$loadChatInboxItems$4(this), new ChatInboxPresenter$loadChatInboxItems$5(this));
        Intrinsics.m26843a(subscribe, "chatInboxListUseCase.cha…owable.message)\n        }");
        DisposableKt.m26766a(compositeDisposable, subscribe);
    }

    private final void m30632h() {
        View view = this.f29620g;
        if (view == null) {
            Intrinsics.m26844a("view");
        }
        view.mo7499f();
        CompositeDisposable compositeDisposable = this.f29621h;
        if (compositeDisposable == null) {
            Intrinsics.m26844a("disposables");
        }
        ChatDataRepositoryContract chatDataRepositoryContract = this.f29614a;
        if (chatDataRepositoryContract == null) {
            Intrinsics.m26844a("chatDataRepository");
        }
        View view2 = this.f29620g;
        if (view2 == null) {
            Intrinsics.m26844a("view");
        }
        DisposableKt.m26766a(compositeDisposable, chatDataRepositoryContract.mo4516a((Function1) new ChatInboxPresenter$loadInboxScreen$1(view2), (Function1) new ChatInboxPresenter$loadInboxScreen$2(this)));
        compositeDisposable = this.f29621h;
        if (compositeDisposable == null) {
            Intrinsics.m26844a("disposables");
        }
        chatDataRepositoryContract = this.f29614a;
        if (chatDataRepositoryContract == null) {
            Intrinsics.m26844a("chatDataRepository");
        }
        Observable observeOn = chatDataRepositoryContract.mo4518b(this.f29618e).flatMap(new ChatInboxPresenter$loadInboxScreen$3(this)).observeOn(SchedulerProvider.m23887c());
        Intrinsics.m26843a((Object) observeOn, "chatDataRepository.liste…n(SchedulerProvider.ui())");
        DisposableKt.m26766a(compositeDisposable, ObservablesKt.m24091a(observeOn, (Function1) new ChatInboxPresenter$loadInboxScreen$4(this)));
        compositeDisposable = this.f29621h;
        if (compositeDisposable == null) {
            Intrinsics.m26844a("disposables");
        }
        chatDataRepositoryContract = this.f29614a;
        if (chatDataRepositoryContract == null) {
            Intrinsics.m26844a("chatDataRepository");
        }
        observeOn = chatDataRepositoryContract.mo4521c(this.f29619f).flatMap(new ChatInboxPresenter$loadInboxScreen$5(this)).observeOn(SchedulerProvider.m23887c());
        Intrinsics.m26843a((Object) observeOn, "chatDataRepository.liste…n(SchedulerProvider.ui())");
        DisposableKt.m26766a(compositeDisposable, ObservablesKt.m24091a(observeOn, (Function1) new ChatInboxPresenter$loadInboxScreen$6(this)));
        String d = SessionUtil.m23898d();
        if (d != null) {
            m30629a(d);
            return;
        }
        view = this.f29620g;
        if (view == null) {
            Intrinsics.m26844a("view");
        }
        view.mo7497d();
    }

    public final void mo5112d() {
        ChatDataRepositoryContract chatDataRepositoryContract = this.f29614a;
        if (chatDataRepositoryContract == null) {
            Intrinsics.m26844a("chatDataRepository");
        }
        Observable subscribeOn = chatDataRepositoryContract.mo4537i().subscribeOn(SchedulerProvider.m23886b());
        Intrinsics.m26843a((Object) subscribeOn, "chatDataRepository.setCh…n(SchedulerProvider.io())");
        ObservablesKt.m24091a(subscribeOn, (Function1) ChatInboxPresenter$splashStartClicked$1.f37508a);
        Object a = FrontpageSettings.a();
        Intrinsics.m26843a(a, "FrontpageSettings.getInstance()");
        a.f(true);
        ChatAnalytics chatAnalytics = this.f29615b;
        if (chatAnalytics == null) {
            Intrinsics.m26844a("chatAnalytics");
        }
        chatAnalytics.m24471a("click", "opt_in");
        m30632h();
    }

    public final void mo5106a() {
        ChatDataRepositoryContract chatDataRepositoryContract = this.f29614a;
        if (chatDataRepositoryContract == null) {
            Intrinsics.m26844a("chatDataRepository");
        }
        if (chatDataRepositoryContract.mo4524c()) {
            if (!this.f29622i) {
                this.f29622i = true;
                Object d = SessionUtil.m23898d();
                View view = this.f29620g;
                if (view == null) {
                    Intrinsics.m26844a("view");
                }
                view.mo7495b();
                CompositeDisposable compositeDisposable = this.f29621h;
                if (compositeDisposable == null) {
                    Intrinsics.m26844a("disposables");
                }
                ChatDataRepositoryContract chatDataRepositoryContract2 = this.f29614a;
                if (chatDataRepositoryContract2 == null) {
                    Intrinsics.m26844a("chatDataRepository");
                }
                Intrinsics.m26843a(d, "userId");
                ObservableSource f = chatDataRepositoryContract2.mo4531f(d);
                ChatDataRepositoryContract chatDataRepositoryContract3 = this.f29614a;
                if (chatDataRepositoryContract3 == null) {
                    Intrinsics.m26844a("chatDataRepository");
                }
                d = Observable.zip(f, chatDataRepositoryContract3.mo4528e(d), ChatInboxPresenter$loadMore$1.f29606a).flatMap(new ChatInboxPresenter$loadMore$2(this)).map(new ChannelConversationTransformer(SessionUtil.m23898d(), SessionUtil.m23899e())).map(ChatInboxPresenter$loadMore$3.f29608a).map(new ChatInboxChannelsTransformer()).observeOn(SchedulerProvider.m23887c()).doFinally(new ChatInboxPresenter$loadMore$4(this)).subscribe(new ChatInboxPresenter$loadMore$5(this), new ChatInboxPresenter$loadMore$6(this));
                Intrinsics.m26843a(d, "Observable.zip<List<Grou…owable.message)\n        }");
                DisposableKt.m26766a(compositeDisposable, d);
            }
        }
    }

    public final void mo5109b() {
        String d = SessionUtil.m23898d();
        if (d != null) {
            ChatInboxListUseCase chatInboxListUseCase = this.f29616c;
            if (chatInboxListUseCase == null) {
                Intrinsics.m26844a("chatInboxListUseCase");
            }
            chatInboxListUseCase.m24490a(d, true, true).observeOn(SchedulerProvider.m23887c()).subscribe(new ChatInboxPresenter$refresh$$inlined$apply$lambda$1(this), new ChatInboxPresenter$refresh$$inlined$apply$lambda$2(this));
        }
    }

    public final void mo5111c() {
        CompositeDisposable compositeDisposable = this.f29621h;
        if (compositeDisposable == null) {
            Intrinsics.m26844a("disposables");
        }
        compositeDisposable.mo5626a();
        ChatDataRepositoryContract chatDataRepositoryContract = this.f29614a;
        if (chatDataRepositoryContract == null) {
            Intrinsics.m26844a("chatDataRepository");
        }
        chatDataRepositoryContract.mo4526d(this.f29618e);
        chatDataRepositoryContract = this.f29614a;
        if (chatDataRepositoryContract == null) {
            Intrinsics.m26844a("chatDataRepository");
        }
        chatDataRepositoryContract.mo4526d(this.f29619f);
        View view = this.f29620g;
        if (view == null) {
            Intrinsics.m26844a("view");
        }
        if (view.an_()) {
            ChatAnalytics chatAnalytics = this.f29615b;
            if (chatAnalytics == null) {
                Intrinsics.m26844a("chatAnalytics");
            }
            chatAnalytics.m24471a("click", "opt_out");
        }
    }

    public final void mo5107a(StateStorageContract stateStorageContract) {
        Intrinsics.m26847b(stateStorageContract, "stateStorage");
        stateStorageContract = SessionUtil.m23898d();
        if (stateStorageContract != null) {
            ChatDataRepositoryContract chatDataRepositoryContract = this.f29614a;
            if (chatDataRepositoryContract == null) {
                Intrinsics.m26844a("chatDataRepository");
            }
            chatDataRepositoryContract.mo4548s(stateStorageContract);
        }
    }

    public static final /* synthetic */ void m30628a(ChatInboxPresenter chatInboxPresenter, boolean z) {
        View view = chatInboxPresenter.f29620g;
        if (view == null) {
            Intrinsics.m26844a("view");
        }
        view.mo7493a(z);
        if (z) {
            String d = SessionUtil.m23898d();
            Intrinsics.m26843a((Object) d, "SessionUtil.getTypedCurrentSessionAccountID()");
            chatInboxPresenter.m30629a(d);
            return;
        }
        chatInboxPresenter = chatInboxPresenter.f29614a;
        if (chatInboxPresenter == null) {
            Intrinsics.m26844a("chatDataRepository");
        }
        Object d2 = SessionUtil.m23898d();
        Intrinsics.m26843a(d2, "SessionUtil.getTypedCurrentSessionAccountID()");
        chatInboxPresenter.mo4548s(d2);
    }

    public static final /* synthetic */ Observable m30627a(ChatInboxPresenter chatInboxPresenter, List list) {
        chatInboxPresenter = chatInboxPresenter.f29614a;
        if (chatInboxPresenter == null) {
            Intrinsics.m26844a("chatDataRepository");
        }
        Object flatMap = chatInboxPresenter.mo4515a(ChatUtilKt.m24761b(list)).flatMap(new ChatInboxPresenter$fetchUserData$1(list));
        Intrinsics.m26843a(flatMap, "chatDataRepository.users…upChannels, usersData)) }");
        return flatMap;
    }
}
