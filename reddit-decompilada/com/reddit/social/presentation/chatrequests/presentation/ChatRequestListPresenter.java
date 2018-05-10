package com.reddit.social.presentation.chatrequests.presentation;

import com.reddit.datalibrary.social.data.common.StateStorageContract;
import com.reddit.datalibrary.social.data.repo.ChatDataRepositoryContract;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.util.SchedulerProvider;
import com.reddit.frontpage.util.SessionUtil;
import com.reddit.frontpage.util.kotlin.ObservablesKt;
import com.reddit.social.analytics.ChatAnalytics;
import com.reddit.social.domain.functions.ChannelConversationTransformer;
import com.reddit.social.domain.usecases.LoadInvitesUseCase;
import com.reddit.social.domain.usecases.LoadInvitesUseCaseKt$sam$Function$af391548;
import com.reddit.social.presentation.chatrequests.ChatRequestListContract.Presenter;
import com.reddit.social.presentation.chatrequests.ChatRequestListContract.View;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.rxkotlin.DisposableKt;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0016J\b\u0010\u001e\u001a\u00020\u001cH\u0002J\b\u0010\u001f\u001a\u00020\u001cH\u0016J\u0010\u0010 \u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\"H\u0002J\b\u0010#\u001a\u00020\u001cH\u0002J\b\u0010$\u001a\u00020\u001cH\u0016J\u0010\u0010%\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020'H\u0016J\u0010\u0010(\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020'H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u0002\n\u0000R\u001e\u0010\u0013\u001a\u00020\u00148\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX.¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/reddit/social/presentation/chatrequests/presentation/ChatRequestListPresenter;", "Lcom/reddit/social/presentation/chatrequests/ChatRequestListContract$Presenter;", "()V", "CHANNEL_HANDLER_INVITES_ID", "", "chatAnalytics", "Lcom/reddit/social/analytics/ChatAnalytics;", "getChatAnalytics", "()Lcom/reddit/social/analytics/ChatAnalytics;", "setChatAnalytics", "(Lcom/reddit/social/analytics/ChatAnalytics;)V", "chatDataRepository", "Lcom/reddit/datalibrary/social/data/repo/ChatDataRepositoryContract;", "getChatDataRepository", "()Lcom/reddit/datalibrary/social/data/repo/ChatDataRepositoryContract;", "setChatDataRepository", "(Lcom/reddit/datalibrary/social/data/repo/ChatDataRepositoryContract;)V", "composite", "Lio/reactivex/disposables/CompositeDisposable;", "loadInvitesUseCase", "Lcom/reddit/social/domain/usecases/LoadInvitesUseCase;", "getLoadInvitesUseCase", "()Lcom/reddit/social/domain/usecases/LoadInvitesUseCase;", "setLoadInvitesUseCase", "(Lcom/reddit/social/domain/usecases/LoadInvitesUseCase;)V", "view", "Lcom/reddit/social/presentation/chatrequests/ChatRequestListContract$View;", "attachView", "", "detach", "loadChatRequestListItems", "loadMore", "networkConnectionChange", "isConnected", "", "reconnect", "refresh", "restore", "stateStorage", "Lcom/reddit/datalibrary/social/data/common/StateStorageContract;", "save", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ChatRequestListPresenter.kt */
public final class ChatRequestListPresenter implements Presenter {
    @Inject
    public ChatDataRepositoryContract f29642a;
    @Inject
    public ChatAnalytics f29643b;
    @Inject
    public LoadInvitesUseCase f29644c;
    private CompositeDisposable f29645d;
    private View f29646e;
    private final String f29647f = "CHANNEL_HANDLER_INVITES_CHAT_REQUEST_LIST";

    public final void mo5117a(StateStorageContract stateStorageContract) {
        Intrinsics.m26847b(stateStorageContract, "stateStorage");
    }

    public final void mo5120b(StateStorageContract stateStorageContract) {
        Intrinsics.m26847b(stateStorageContract, "stateStorage");
    }

    public ChatRequestListPresenter() {
        FrontpageApplication.m28878n().mo5088a(this);
    }

    public static final /* synthetic */ View m30661a(ChatRequestListPresenter chatRequestListPresenter) {
        chatRequestListPresenter = chatRequestListPresenter.f29646e;
        if (chatRequestListPresenter == null) {
            Intrinsics.m26844a("view");
        }
        return chatRequestListPresenter;
    }

    public final LoadInvitesUseCase m30670d() {
        LoadInvitesUseCase loadInvitesUseCase = this.f29644c;
        if (loadInvitesUseCase == null) {
            Intrinsics.m26844a("loadInvitesUseCase");
        }
        return loadInvitesUseCase;
    }

    public final void mo5118a(View view) {
        Intrinsics.m26847b(view, "view");
        this.f29646e = view;
        this.f29645d = new CompositeDisposable();
        CompositeDisposable compositeDisposable = this.f29645d;
        if (compositeDisposable == null) {
            Intrinsics.m26844a("composite");
        }
        ChatDataRepositoryContract chatDataRepositoryContract = this.f29642a;
        if (chatDataRepositoryContract == null) {
            Intrinsics.m26844a("chatDataRepository");
        }
        DisposableKt.m26766a(compositeDisposable, chatDataRepositoryContract.mo4516a((Function1) new ChatRequestListPresenter$attachView$1(view), (Function1) new ChatRequestListPresenter$attachView$2(this)));
        compositeDisposable = this.f29645d;
        if (compositeDisposable == null) {
            Intrinsics.m26844a("composite");
        }
        chatDataRepositoryContract = this.f29642a;
        if (chatDataRepositoryContract == null) {
            Intrinsics.m26844a("chatDataRepository");
        }
        Observable observeOn = chatDataRepositoryContract.mo4521c(this.f29647f).flatMap(new ChatRequestListPresenter$attachView$3(this)).observeOn(SchedulerProvider.m23887c());
        Intrinsics.m26843a((Object) observeOn, "chatDataRepository.liste…n(SchedulerProvider.ui())");
        DisposableKt.m26766a(compositeDisposable, ObservablesKt.m24091a(observeOn, (Function1) new ChatRequestListPresenter$attachView$4(view)));
        m30663e();
    }

    public final void mo5116a() {
        ChatDataRepositoryContract chatDataRepositoryContract = this.f29642a;
        if (chatDataRepositoryContract == null) {
            Intrinsics.m26844a("chatDataRepository");
        }
        if (chatDataRepositoryContract.mo4527d()) {
            chatDataRepositoryContract = this.f29642a;
            if (chatDataRepositoryContract == null) {
                Intrinsics.m26844a("chatDataRepository");
            }
            if (!chatDataRepositoryContract.mo4530e()) {
                View view = this.f29646e;
                if (view == null) {
                    Intrinsics.m26844a("view");
                }
                view.mo7504b();
                CompositeDisposable compositeDisposable = this.f29645d;
                if (compositeDisposable == null) {
                    Intrinsics.m26844a("composite");
                }
                LoadInvitesUseCase loadInvitesUseCase = this.f29644c;
                if (loadInvitesUseCase == null) {
                    Intrinsics.m26844a("loadInvitesUseCase");
                }
                ChatDataRepositoryContract chatDataRepositoryContract2 = loadInvitesUseCase.f22308a;
                if (chatDataRepositoryContract2 == null) {
                    Intrinsics.m26844a("chatDataRepository");
                }
                Object d = SessionUtil.m23898d();
                Intrinsics.m26843a(d, "getTypedCurrentSessionAccountID()");
                Object map = chatDataRepositoryContract2.mo4531f(d).map(LoadInvitesUseCase$loadMore$1.f29593a).flatMap(new LoadInvitesUseCaseKt$sam$Function$af391548(new LoadInvitesUseCase$loadMore$2(loadInvitesUseCase))).map(new ChannelConversationTransformer(SessionUtil.m23898d(), SessionUtil.m23899e()));
                Intrinsics.m26843a(map, "chatDataRepository.unacc…), getCurrentUsername()))");
                Observable observeOn = map.observeOn(SchedulerProvider.m23887c());
                View view2 = this.f29646e;
                if (view2 == null) {
                    Intrinsics.m26844a("view");
                }
                map = observeOn.subscribe(new ChatRequestListPresenterKt$sam$Consumer$f84eda71(new ChatRequestListPresenter$loadMore$1(view2)), new ChatRequestListPresenter$loadMore$2(this));
                Intrinsics.m26843a(map, "loadInvitesUseCase.loadM…er.e(e.message)\n        }");
                DisposableKt.m26766a(compositeDisposable, map);
            }
        }
    }

    private final void m30663e() {
        CompositeDisposable compositeDisposable = this.f29645d;
        if (compositeDisposable == null) {
            Intrinsics.m26844a("composite");
        }
        LoadInvitesUseCase loadInvitesUseCase = this.f29644c;
        if (loadInvitesUseCase == null) {
            Intrinsics.m26844a("loadInvitesUseCase");
        }
        Observable observeOn = loadInvitesUseCase.m24492a(false).observeOn(SchedulerProvider.m23887c());
        View view = this.f29646e;
        if (view == null) {
            Intrinsics.m26844a("view");
        }
        observeOn = observeOn.doOnNext(new ChatRequestListPresenterKt$sam$Consumer$f84eda71(new ChatRequestListPresenter$loadChatRequestListItems$1(view))).flatMap(new ChatRequestListPresenter$loadChatRequestListItems$2(this)).doOnNext(new ChatRequestListPresenter$loadChatRequestListItems$3(this)).observeOn(SchedulerProvider.m23887c());
        view = this.f29646e;
        if (view == null) {
            Intrinsics.m26844a("view");
        }
        Object subscribe = observeOn.subscribe(new ChatRequestListPresenterKt$sam$Consumer$f84eda71(new ChatRequestListPresenter$loadChatRequestListItems$4(view)), new ChatRequestListPresenter$loadChatRequestListItems$5(this));
        Intrinsics.m26843a(subscribe, "loadInvitesUseCase.load(…er.e(e.message)\n        }");
        DisposableKt.m26766a(compositeDisposable, subscribe);
    }

    public final void mo5119b() {
        CompositeDisposable compositeDisposable = this.f29645d;
        if (compositeDisposable == null) {
            Intrinsics.m26844a("composite");
        }
        LoadInvitesUseCase loadInvitesUseCase = this.f29644c;
        if (loadInvitesUseCase == null) {
            Intrinsics.m26844a("loadInvitesUseCase");
        }
        Observable observeOn = loadInvitesUseCase.m24492a(true).observeOn(SchedulerProvider.m23887c());
        View view = this.f29646e;
        if (view == null) {
            Intrinsics.m26844a("view");
        }
        Object subscribe = observeOn.subscribe(new ChatRequestListPresenterKt$sam$Consumer$f84eda71(new ChatRequestListPresenter$refresh$1(view)), new ChatRequestListPresenter$refresh$2(this));
        Intrinsics.m26843a(subscribe, "loadInvitesUseCase.load(…er.e(e.message)\n        }");
        DisposableKt.m26766a(compositeDisposable, subscribe);
    }

    public final void mo5121c() {
        CompositeDisposable compositeDisposable = this.f29645d;
        if (compositeDisposable == null) {
            Intrinsics.m26844a("composite");
        }
        compositeDisposable.mo5626a();
        ChatDataRepositoryContract chatDataRepositoryContract = this.f29642a;
        if (chatDataRepositoryContract == null) {
            Intrinsics.m26844a("chatDataRepository");
        }
        chatDataRepositoryContract.mo4526d(this.f29647f);
    }

    public static final /* synthetic */ void m30662a(ChatRequestListPresenter chatRequestListPresenter, boolean z) {
        View view = chatRequestListPresenter.f29646e;
        if (view == null) {
            Intrinsics.m26844a("view");
        }
        view.mo7503a(z);
        if (z) {
            z = chatRequestListPresenter.f29646e;
            if (!z) {
                Intrinsics.m26844a("view");
            }
            z.mo7500a();
            chatRequestListPresenter.m30663e();
        }
    }
}
