package com.reddit.frontpage.presentation.profile.user;

import com.reddit.common.rx.PostExecutionThread;
import com.reddit.datalibrary.social.data.repo.ChatDataRepository;
import com.reddit.frontpage.domain.repository.AccountRepository;
import com.reddit.frontpage.domain.repository.TrophiesRepository;
import com.reddit.frontpage.presentation.common.DisposablePresenter;
import com.reddit.frontpage.presentation.formatter.AccountFormatter;
import com.reddit.frontpage.presentation.profile.user.UserAccountContract.Presenter;
import com.reddit.frontpage.presentation.profile.user.UserAccountContract.View;
import com.reddit.frontpage.util.SchedulerProvider;
import com.reddit.frontpage.util.kotlin.SinglesKt;
import com.reddit.social.analytics.ChatAnalytics;
import io.reactivex.Single;
import io.reactivex.rxkotlin.SubscribersKt;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B/\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/reddit/frontpage/presentation/profile/user/UserAccountPresenter;", "Lcom/reddit/frontpage/presentation/common/DisposablePresenter;", "Lcom/reddit/frontpage/presentation/profile/user/UserAccountContract$Presenter;", "view", "Lcom/reddit/frontpage/presentation/profile/user/UserAccountContract$View;", "accountRepository", "Lcom/reddit/frontpage/domain/repository/AccountRepository;", "trophiesRepository", "Lcom/reddit/frontpage/domain/repository/TrophiesRepository;", "scheduler", "Lcom/reddit/common/rx/PostExecutionThread;", "formatter", "Lcom/reddit/frontpage/presentation/formatter/AccountFormatter;", "(Lcom/reddit/frontpage/presentation/profile/user/UserAccountContract$View;Lcom/reddit/frontpage/domain/repository/AccountRepository;Lcom/reddit/frontpage/domain/repository/TrophiesRepository;Lcom/reddit/common/rx/PostExecutionThread;Lcom/reddit/frontpage/presentation/formatter/AccountFormatter;)V", "getAccountRepository", "()Lcom/reddit/frontpage/domain/repository/AccountRepository;", "getFormatter", "()Lcom/reddit/frontpage/presentation/formatter/AccountFormatter;", "getScheduler", "()Lcom/reddit/common/rx/PostExecutionThread;", "getTrophiesRepository", "()Lcom/reddit/frontpage/domain/repository/TrophiesRepository;", "getView", "()Lcom/reddit/frontpage/presentation/profile/user/UserAccountContract$View;", "attach", "", "startChat", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: UserAccountPresenter.kt */
public final class UserAccountPresenter extends DisposablePresenter implements Presenter {
    final View f34145a;
    final AccountFormatter f34146b;
    private final AccountRepository f34147c;
    private final TrophiesRepository f34148d;
    private final PostExecutionThread f34149e;

    @Inject
    public UserAccountPresenter(View view, AccountRepository accountRepository, TrophiesRepository trophiesRepository, PostExecutionThread postExecutionThread, AccountFormatter accountFormatter) {
        Intrinsics.m26847b(view, "view");
        Intrinsics.m26847b(accountRepository, "accountRepository");
        Intrinsics.m26847b(trophiesRepository, "trophiesRepository");
        Intrinsics.m26847b(postExecutionThread, "scheduler");
        Intrinsics.m26847b(accountFormatter, "formatter");
        this.f34145a = view;
        this.f34147c = accountRepository;
        this.f34148d = trophiesRepository;
        this.f34149e = postExecutionThread;
        this.f34146b = accountFormatter;
    }

    public final void attach() {
        String a = this.f34145a.mo7419a();
        if (a != null) {
            Object zip = Single.zip(this.f34147c.m22394a(a), this.f34148d.m22509a(a), UserAccountPresenter$attach$1.f28742a);
            Intrinsics.m26843a(zip, "Single\n            .zip(…          }\n            )");
            handleDispose(SubscribersKt.m26769a(SinglesKt.m24094b(zip, this.f34149e), (Function1) new UserAccountPresenter$attach$2(this), (Function1) new UserAccountPresenter$attach$3(this)));
        }
    }

    public final void m34867a() {
        this.f34145a.mo7422a(false);
        ChatAnalytics chatAnalytics = new ChatAnalytics();
        if (this.f34145a.mo7423b() == null) {
            String a = this.f34145a.mo7419a();
            if (a != null) {
                Object subscribe = new ChatDataRepository().mo4547r(a).subscribeOn(SchedulerProvider.m23886b()).observeOn(SchedulerProvider.m23887c()).doAfterTerminate(new UserAccountPresenter$startChat$1(this)).subscribe(new UserAccountPresenter$startChat$2(this, chatAnalytics), UserAccountPresenter$startChat$3.f28746a);
                Intrinsics.m26843a(subscribe, "ChatDataRepository().get…\"Error creating chat\") })");
                handleDispose(subscribe);
                return;
            }
            return;
        }
        String b = this.f34145a.mo7423b();
        if (b != null) {
            this.f34145a.mo7421a(b);
            this.f34145a.mo7422a(true);
            ChatAnalytics.m24468b();
        }
    }
}
