package com.reddit.frontpage.presentation.navdrawer;

import com.reddit.common.rx.PostExecutionThread;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.frontpage.domain.usecase.AccountInfoUseCase;
import com.reddit.frontpage.presentation.formatter.AccountFormatter;
import com.reddit.frontpage.presentation.navdrawer.RedditNavHeaderContract.View;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class RedditNavHeaderPresenter_Factory implements Factory<RedditNavHeaderPresenter> {
    private final Provider<View> f34093a;
    private final Provider<AccountInfoUseCase> f34094b;
    private final Provider<PostExecutionThread> f34095c;
    private final Provider<AccountFormatter> f34096d;
    private final Provider<SessionManager> f34097e;

    private RedditNavHeaderPresenter_Factory(Provider<View> provider, Provider<AccountInfoUseCase> provider2, Provider<PostExecutionThread> provider3, Provider<AccountFormatter> provider4, Provider<SessionManager> provider5) {
        this.f34093a = provider;
        this.f34094b = provider2;
        this.f34095c = provider3;
        this.f34096d = provider4;
        this.f34097e = provider5;
    }

    public static RedditNavHeaderPresenter_Factory m34814a(Provider<View> provider, Provider<AccountInfoUseCase> provider2, Provider<PostExecutionThread> provider3, Provider<AccountFormatter> provider4, Provider<SessionManager> provider5) {
        return new RedditNavHeaderPresenter_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public final /* synthetic */ Object get() {
        return new RedditNavHeaderPresenter((View) this.f34093a.get(), (AccountInfoUseCase) this.f34094b.get(), (PostExecutionThread) this.f34095c.get(), (AccountFormatter) this.f34096d.get(), (SessionManager) this.f34097e.get());
    }
}
