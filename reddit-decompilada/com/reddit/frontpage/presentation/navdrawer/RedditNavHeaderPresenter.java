package com.reddit.frontpage.presentation.navdrawer;

import com.reddit.common.rx.PostExecutionThread;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.frontpage.domain.usecase.AccountInfoUseCase;
import com.reddit.frontpage.domain.usecase.AccountInfoUseCase.AccountInfoUseCaseParams;
import com.reddit.frontpage.presentation.common.DisposablePresenter;
import com.reddit.frontpage.presentation.formatter.AccountFormatter;
import com.reddit.frontpage.presentation.navdrawer.RedditNavHeaderContract.Presenter;
import com.reddit.frontpage.presentation.navdrawer.RedditNavHeaderContract.View;
import com.reddit.frontpage.util.kotlin.SinglesKt;
import io.reactivex.rxkotlin.SubscribersKt;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B/\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\b\u0010\u001c\u001a\u00020\u001dH\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00178BX\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/reddit/frontpage/presentation/navdrawer/RedditNavHeaderPresenter;", "Lcom/reddit/frontpage/presentation/common/DisposablePresenter;", "Lcom/reddit/frontpage/presentation/navdrawer/RedditNavHeaderContract$Presenter;", "view", "Lcom/reddit/frontpage/presentation/navdrawer/RedditNavHeaderContract$View;", "accountInfoUseCase", "Lcom/reddit/frontpage/domain/usecase/AccountInfoUseCase;", "scheduler", "Lcom/reddit/common/rx/PostExecutionThread;", "formatter", "Lcom/reddit/frontpage/presentation/formatter/AccountFormatter;", "sessionManager", "Lcom/reddit/datalibrary/frontpage/redditauth/account/SessionManager;", "(Lcom/reddit/frontpage/presentation/navdrawer/RedditNavHeaderContract$View;Lcom/reddit/frontpage/domain/usecase/AccountInfoUseCase;Lcom/reddit/common/rx/PostExecutionThread;Lcom/reddit/frontpage/presentation/formatter/AccountFormatter;Lcom/reddit/datalibrary/frontpage/redditauth/account/SessionManager;)V", "getAccountInfoUseCase", "()Lcom/reddit/frontpage/domain/usecase/AccountInfoUseCase;", "getFormatter", "()Lcom/reddit/frontpage/presentation/formatter/AccountFormatter;", "getScheduler", "()Lcom/reddit/common/rx/PostExecutionThread;", "getSessionManager", "()Lcom/reddit/datalibrary/frontpage/redditauth/account/SessionManager;", "username", "", "getUsername", "()Ljava/lang/String;", "getView", "()Lcom/reddit/frontpage/presentation/navdrawer/RedditNavHeaderContract$View;", "attach", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: RedditNavHeaderPresenter.kt */
public final class RedditNavHeaderPresenter extends DisposablePresenter implements Presenter {
    final View f34088a;
    final AccountFormatter f34089b;
    private final AccountInfoUseCase f34090c;
    private final PostExecutionThread f34091d;
    private final SessionManager f34092e;

    @Inject
    public RedditNavHeaderPresenter(View view, AccountInfoUseCase accountInfoUseCase, PostExecutionThread postExecutionThread, AccountFormatter accountFormatter, SessionManager sessionManager) {
        Intrinsics.m26847b(view, "view");
        Intrinsics.m26847b(accountInfoUseCase, "accountInfoUseCase");
        Intrinsics.m26847b(postExecutionThread, "scheduler");
        Intrinsics.m26847b(accountFormatter, "formatter");
        Intrinsics.m26847b(sessionManager, "sessionManager");
        this.f34088a = view;
        this.f34090c = accountInfoUseCase;
        this.f34091d = postExecutionThread;
        this.f34089b = accountFormatter;
        this.f34092e = sessionManager;
    }

    private final String m34813a() {
        return this.f34092e.c().getUsername();
    }

    public final void attach() {
        if (!this.f34092e.c().isAnonymous()) {
            if (m34813a() != null) {
                this.f34088a.U_();
                View view = this.f34088a;
                String a = m34813a();
                if (a == null) {
                    Intrinsics.m26842a();
                }
                view.setUsername(a);
                AccountInfoUseCase accountInfoUseCase = this.f34090c;
                String a2 = m34813a();
                if (a2 == null) {
                    Intrinsics.m26842a();
                }
                handleDispose(SubscribersKt.m26769a(SinglesKt.m24094b(accountInfoUseCase.m22528b(new AccountInfoUseCaseParams(a2)), this.f34091d), (Function1) new RedditNavHeaderPresenter$attach$1(this), (Function1) new RedditNavHeaderPresenter$attach$2(this)));
                return;
            }
        }
        this.f34088a.mo4916b();
    }
}
