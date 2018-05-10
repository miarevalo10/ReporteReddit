package com.reddit.frontpage.presentation.modtools.mute.add;

import com.reddit.common.rx.PostExecutionThread;
import com.reddit.frontpage.commons.analytics.AppAnalytics;
import com.reddit.frontpage.commons.analytics.builders.ModEventBuilder;
import com.reddit.frontpage.commons.analytics.builders.ModNoun;
import com.reddit.frontpage.domain.repository.ModToolsRepository;
import com.reddit.frontpage.presentation.common.DisposablePresenter;
import com.reddit.frontpage.presentation.modtools.mute.add.AddMutedUserContract.View;
import com.reddit.frontpage.util.kotlin.SinglesKt;
import io.reactivex.functions.Consumer;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0016\u001a\u00020\u0011H\u0002R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0017"}, d2 = {"Lcom/reddit/frontpage/presentation/modtools/mute/add/AddMutedUserPresenter;", "Lcom/reddit/frontpage/presentation/common/DisposablePresenter;", "Lcom/reddit/frontpage/presentation/modtools/mute/add/AddMutedUserContract$Presenter;", "view", "Lcom/reddit/frontpage/presentation/modtools/mute/add/AddMutedUserContract$View;", "repository", "Lcom/reddit/frontpage/domain/repository/ModToolsRepository;", "scheduler", "Lcom/reddit/common/rx/PostExecutionThread;", "(Lcom/reddit/frontpage/presentation/modtools/mute/add/AddMutedUserContract$View;Lcom/reddit/frontpage/domain/repository/ModToolsRepository;Lcom/reddit/common/rx/PostExecutionThread;)V", "getRepository", "()Lcom/reddit/frontpage/domain/repository/ModToolsRepository;", "getScheduler", "()Lcom/reddit/common/rx/PostExecutionThread;", "getView", "()Lcom/reddit/frontpage/presentation/modtools/mute/add/AddMutedUserContract$View;", "attach", "", "muteUser", "username", "", "modNote", "sendMuteEvent", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: AddMutedUserPresenter.kt */
public final class AddMutedUserPresenter extends DisposablePresenter {
    final View f34085a;
    private final ModToolsRepository f34086b;
    private final PostExecutionThread f34087c;

    public final void attach() {
    }

    @Inject
    public AddMutedUserPresenter(View view, ModToolsRepository modToolsRepository, PostExecutionThread postExecutionThread) {
        Intrinsics.m26847b(view, "view");
        Intrinsics.m26847b(modToolsRepository, "repository");
        Intrinsics.m26847b(postExecutionThread, "scheduler");
        this.f34085a = view;
        this.f34086b = modToolsRepository;
        this.f34087c = postExecutionThread;
    }

    public final void m34812a(String str, String str2) {
        Intrinsics.m26847b(str, "username");
        Intrinsics.m26847b(str2, "modNote");
        Object subscribe = SinglesKt.m24094b(this.f34086b.m22442a(this.f34085a.mo7401b(), str, str2), this.f34087c).subscribe(new AddMutedUserPresenter$muteUser$1(this, str), (Consumer) new AddMutedUserPresenter$muteUser$2(this));
        Intrinsics.m26843a(subscribe, "repository.muteUser(view…alizedMessage)\n        })");
        handleDispose(subscribe);
    }

    public static final /* synthetic */ void m34811a(AddMutedUserPresenter addMutedUserPresenter) {
        boolean a = StringsKt__StringsJVMKt.m41943a((CharSequence) addMutedUserPresenter.f34085a.mo7403c());
        ModEventBuilder q = AppAnalytics.m21880q();
        if (!a) {
            ((ModEventBuilder) ((ModEventBuilder) ((ModEventBuilder) ((ModEventBuilder) q.m21888a(ModEventBuilder.f27453d)).m21892b(ModEventBuilder.f27450a)).m21895c(ModNoun.f20039K.f20068M)).m21889a(addMutedUserPresenter.f34085a.mo7399a(), addMutedUserPresenter.f34085a.mo7401b())).m21890a(addMutedUserPresenter.f34085a.mo7403c(), addMutedUserPresenter.f34085a.mo7404d(), addMutedUserPresenter.f34085a.mo7405e());
        }
        if (!StringsKt__StringsJVMKt.m41943a((CharSequence) addMutedUserPresenter.f34085a.S_())) {
            q.m21893b(addMutedUserPresenter.f34085a.S_(), addMutedUserPresenter.f34085a.mo7403c());
        }
        if (!a) {
            q.m21891a();
        }
        q.m21891a();
    }
}
