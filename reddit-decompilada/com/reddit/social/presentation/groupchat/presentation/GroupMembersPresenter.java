package com.reddit.social.presentation.groupchat.presentation;

import com.reddit.datalibrary.social.data.common.StateStorageContract;
import com.reddit.datalibrary.social.data.repo.ChatDataRepositoryContract;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.util.SchedulerProvider;
import com.reddit.frontpage.util.kotlin.ObservablesKt;
import com.reddit.social.analytics.ChatAnalytics;
import com.reddit.social.analytics.ChatAnalytics.Source;
import com.reddit.social.presentation.groupchat.GroupMembersContract.Presenter;
import com.reddit.social.presentation.groupchat.GroupMembersContract.View;
import com.reddit.social.presentation.presentationobjects.UserData;
import com.sendbird.android.SendBird;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010,\u001a\u00020-2\u0006\u0010&\u001a\u00020'H\u0016J\u0010\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u00020\u0004H\u0016J\b\u00100\u001a\u00020-H\u0016J\u001e\u00101\u001a\u00020-2\u0006\u0010\t\u001a\u00020\u00042\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 H\u0016J\u0010\u00102\u001a\u00020-2\u0006\u00103\u001a\u000204H\u0002J\b\u00105\u001a\u00020-H\u0002J \u00106\u001a\u00020-2\u0006\u00107\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u00042\u0006\u00108\u001a\u00020\u0004H\u0017J\u0018\u00109\u001a\u00020-2\u0006\u0010/\u001a\u00020\u00042\u0006\u00107\u001a\u00020\u0004H\u0016J\u0010\u0010:\u001a\u00020-2\u0006\u0010;\u001a\u00020<H\u0016J\u0010\u0010=\u001a\u00020-2\u0006\u0010;\u001a\u00020<H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u00020\u00148\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR \u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020'X.¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u0006>"}, d2 = {"Lcom/reddit/social/presentation/groupchat/presentation/GroupMembersPresenter;", "Lcom/reddit/social/presentation/groupchat/GroupMembersContract$Presenter;", "()V", "MEMBERS_KEY", "", "getMEMBERS_KEY", "()Ljava/lang/String;", "URL_KEY", "getURL_KEY", "channelUrl", "getChannelUrl", "setChannelUrl", "(Ljava/lang/String;)V", "chatAnalytics", "Lcom/reddit/social/analytics/ChatAnalytics;", "getChatAnalytics", "()Lcom/reddit/social/analytics/ChatAnalytics;", "setChatAnalytics", "(Lcom/reddit/social/analytics/ChatAnalytics;)V", "chatDataRepository", "Lcom/reddit/datalibrary/social/data/repo/ChatDataRepositoryContract;", "getChatDataRepository", "()Lcom/reddit/datalibrary/social/data/repo/ChatDataRepositoryContract;", "setChatDataRepository", "(Lcom/reddit/datalibrary/social/data/repo/ChatDataRepositoryContract;)V", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "getDisposables", "()Lio/reactivex/disposables/CompositeDisposable;", "setDisposables", "(Lio/reactivex/disposables/CompositeDisposable;)V", "members", "", "Lcom/reddit/social/presentation/presentationobjects/UserData;", "getMembers", "()Ljava/util/List;", "setMembers", "(Ljava/util/List;)V", "view", "Lcom/reddit/social/presentation/groupchat/GroupMembersContract$View;", "getView", "()Lcom/reddit/social/presentation/groupchat/GroupMembersContract$View;", "setView", "(Lcom/reddit/social/presentation/groupchat/GroupMembersContract$View;)V", "attachView", "", "blockUser", "userId", "detach", "init", "networkConnectionChange", "isConnected", "", "reloadMembers", "reportUser", "userName", "reason", "requestUserBlock", "restore", "stateStorage", "Lcom/reddit/datalibrary/social/data/common/StateStorageContract;", "save", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: GroupMembersPresenter.kt */
public final class GroupMembersPresenter implements Presenter {
    @Inject
    public ChatDataRepositoryContract f29739a;
    @Inject
    public ChatAnalytics f29740b;
    public String f29741c;
    public View f29742d;
    public CompositeDisposable f29743e;
    List<UserData> f29744f = CollectionsKt__CollectionsKt.m26790a();
    private final String f29745g = "URL_KEY";
    private final String f29746h = "MEMBERS_KEY";

    public GroupMembersPresenter() {
        FrontpageApplication.m28878n().mo5094a(this);
    }

    public final View m30768b() {
        View view = this.f29742d;
        if (view == null) {
            Intrinsics.m26844a("view");
        }
        return view;
    }

    public final void mo5153a(View view) {
        Intrinsics.m26847b(view, "view");
        this.f29742d = view;
        this.f29743e = new CompositeDisposable();
        CompositeDisposable compositeDisposable = this.f29743e;
        if (compositeDisposable == null) {
            Intrinsics.m26844a("disposables");
        }
        ChatDataRepositoryContract chatDataRepositoryContract = this.f29739a;
        if (chatDataRepositoryContract == null) {
            Intrinsics.m26844a("chatDataRepository");
        }
        DisposableKt.m26766a(compositeDisposable, chatDataRepositoryContract.mo4516a((Function1) new GroupMembersPresenter$attachView$1(view), (Function1) new GroupMembersPresenter$attachView$2(this)));
        view.mo7544a(this.f29744f);
    }

    public final void mo5157a(String str, List<UserData> list) {
        Intrinsics.m26847b(str, "channelUrl");
        Intrinsics.m26847b(list, "members");
        this.f29741c = str;
        this.f29744f = list;
    }

    public final void mo5155a(String str, String str2) {
        Intrinsics.m26847b(str, "userId");
        Intrinsics.m26847b(str2, "userName");
        View view = this.f29742d;
        if (view == null) {
            Intrinsics.m26844a("view");
        }
        view.mo7542a(str, str2);
    }

    public final void mo5154a(String str) {
        Intrinsics.m26847b(str, "userId");
        CompositeDisposable compositeDisposable = this.f29743e;
        if (compositeDisposable == null) {
            Intrinsics.m26844a("disposables");
        }
        ChatDataRepositoryContract chatDataRepositoryContract = this.f29739a;
        if (chatDataRepositoryContract == null) {
            Intrinsics.m26844a("chatDataRepository");
        }
        ObservableSource o = chatDataRepositoryContract.mo4544o(str);
        ChatDataRepositoryContract chatDataRepositoryContract2 = this.f29739a;
        if (chatDataRepositoryContract2 == null) {
            Intrinsics.m26844a("chatDataRepository");
        }
        Object subscribe = Observable.zip(o, chatDataRepositoryContract2.mo4543n(str), GroupMembersPresenter$blockUser$1.f29733a).observeOn(SchedulerProvider.m23887c()).subscribe(new GroupMembersPresenter$blockUser$2(this, str), (Consumer) new GroupMembersPresenter$blockUser$3(this));
        Intrinsics.m26843a(subscribe, "Observable.zip(\n        …ror: \" + error)\n        }");
        DisposableKt.m26766a(compositeDisposable, subscribe);
    }

    public final void mo5156a(String str, String str2, String str3) {
        Intrinsics.m26847b(str, "userName");
        Intrinsics.m26847b(str2, "userId");
        Intrinsics.m26847b(str3, "reason");
        ChatAnalytics chatAnalytics = this.f29740b;
        if (chatAnalytics == null) {
            Intrinsics.m26844a("chatAnalytics");
        }
        String str4 = this.f29741c;
        if (str4 == null) {
            Intrinsics.m26844a("channelUrl");
        }
        chatAnalytics.m24474b(str4, str2, Source.f22284d);
        str2 = this.f29743e;
        if (str2 == null) {
            Intrinsics.m26844a("disposables");
        }
        ChatDataRepositoryContract chatDataRepositoryContract = this.f29739a;
        if (chatDataRepositoryContract == null) {
            Intrinsics.m26844a("chatDataRepository");
        }
        Object subscribe = chatDataRepositoryContract.mo4522c(str, str3).subscribeOn(SchedulerProvider.m23887c()).subscribe((Consumer) new GroupMembersPresenter$reportUser$1(this), new GroupMembersPresenter$reportUser$2(this));
        Intrinsics.m26843a(subscribe, "chatDataRepository.repor…iew.reportUserError(it) }");
        DisposableKt.m26766a(str2, subscribe);
    }

    public final void mo5151a() {
        CompositeDisposable compositeDisposable = this.f29743e;
        if (compositeDisposable == null) {
            Intrinsics.m26844a("disposables");
        }
        compositeDisposable.mo5626a();
    }

    public final void mo5152a(StateStorageContract stateStorageContract) {
        Intrinsics.m26847b(stateStorageContract, "stateStorage");
        String str = this.f29745g;
        String str2 = this.f29741c;
        if (str2 == null) {
            Intrinsics.m26844a("channelUrl");
        }
        stateStorageContract.mo4475a(str, (CharSequence) str2);
        stateStorageContract.mo4476a(this.f29746h, new ArrayList(this.f29744f));
        stateStorageContract = SendBird.m25001k();
        if (stateStorageContract != null) {
            ChatDataRepositoryContract chatDataRepositoryContract = this.f29739a;
            if (chatDataRepositoryContract == null) {
                Intrinsics.m26844a("chatDataRepository");
            }
            Object d = stateStorageContract.m25021d();
            Intrinsics.m26843a(d, "it.userId");
            chatDataRepositoryContract.mo4549t(d);
        }
    }

    public final void mo5158b(StateStorageContract stateStorageContract) {
        Intrinsics.m26847b(stateStorageContract, "stateStorage");
        String b = stateStorageContract.mo4477b(this.f29745g);
        if (b == null) {
            throw ((Throwable) new Exception("weird. restore should return notnull channel url"));
        }
        this.f29741c = b;
        stateStorageContract = stateStorageContract.mo4478c(this.f29746h);
        if (stateStorageContract != null) {
            if (stateStorageContract == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.List<com.reddit.social.presentation.presentationobjects.UserData>");
            }
            List list = (List) stateStorageContract;
            if (list != null) {
                this.f29744f = list;
                return;
            }
        }
        throw ((Throwable) new Exception("weird. restore should return notnull membersList"));
    }

    public static final /* synthetic */ void m30760a(GroupMembersPresenter groupMembersPresenter, boolean z) {
        View view = groupMembersPresenter.f29742d;
        if (view == null) {
            Intrinsics.m26844a("view");
        }
        view.mo7545a(z);
        if (z) {
            z = groupMembersPresenter.f29743e;
            if (!z) {
                Intrinsics.m26844a("disposables");
            }
            ChatDataRepositoryContract chatDataRepositoryContract = groupMembersPresenter.f29739a;
            if (chatDataRepositoryContract == null) {
                Intrinsics.m26844a("chatDataRepository");
            }
            String str = groupMembersPresenter.f29741c;
            if (str == null) {
                Intrinsics.m26844a("channelUrl");
            }
            Observable observeOn = chatDataRepositoryContract.mo4529e(str, true).observeOn(SchedulerProvider.m23887c());
            Intrinsics.m26843a((Object) observeOn, "chatDataRepository.getMe…n(SchedulerProvider.ui())");
            DisposableKt.m26766a(z, ObservablesKt.m24091a(observeOn, (Function1) new GroupMembersPresenter$reloadMembers$1(groupMembersPresenter)));
        }
    }
}
