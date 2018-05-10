package com.reddit.frontpage.di.component;

import com.reddit.common.rx.PostExecutionThread;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.frontpage.domain.usecase.AccountInfoUseCase;
import com.reddit.frontpage.presentation.formatter.AccountFormatter;
import com.reddit.frontpage.presentation.navdrawer.RedditNavHeaderContract.View;
import com.reddit.frontpage.presentation.navdrawer.RedditNavHeaderPresenter;
import com.reddit.frontpage.presentation.navdrawer.RedditNavHeaderPresenter_Factory;
import dagger.internal.DoubleCheck;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DaggerNavUserAccountComponent implements NavUserAccountComponent {
    private Provider<View> f27760a;
    private C2272x5ad35b3b f27761b;
    private C2273xdbdd5b83 f27762c;
    private com_reddit_frontpage_di_component_UserComponent_accountFormatter f27763d;
    private com_reddit_frontpage_di_component_UserComponent_sessionManager f27764e;
    private Provider<RedditNavHeaderPresenter> f27765f;

    private static final class Builder implements com.reddit.frontpage.di.component.NavUserAccountComponent.Builder {
        private UserComponent f27754a;
        private View f27755b;

        private Builder() {
        }

        public final NavUserAccountComponent mo4692a() {
            StringBuilder stringBuilder;
            if (this.f27754a == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(UserComponent.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            } else if (this.f27755b != null) {
                return new DaggerNavUserAccountComponent();
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append(View.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            }
        }
    }

    private static class com_reddit_frontpage_di_component_UserComponent_accountFormatter implements Provider<AccountFormatter> {
        private final UserComponent f27756a;

        com_reddit_frontpage_di_component_UserComponent_accountFormatter(UserComponent userComponent) {
            this.f27756a = userComponent;
        }

        public /* synthetic */ Object get() {
            return (AccountFormatter) Preconditions.m26013a(this.f27756a.mo4626n(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C2272x5ad35b3b implements Provider<AccountInfoUseCase> {
        private final UserComponent f27757a;

        C2272x5ad35b3b(UserComponent userComponent) {
            this.f27757a = userComponent;
        }

        public /* synthetic */ Object get() {
            return (AccountInfoUseCase) Preconditions.m26013a(this.f27757a.mo4615c(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C2273xdbdd5b83 implements Provider<PostExecutionThread> {
        private final UserComponent f27758a;

        C2273xdbdd5b83(UserComponent userComponent) {
            this.f27758a = userComponent;
        }

        public /* synthetic */ Object get() {
            return (PostExecutionThread) Preconditions.m26013a(this.f27758a.mo4633u(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class com_reddit_frontpage_di_component_UserComponent_sessionManager implements Provider<SessionManager> {
        private final UserComponent f27759a;

        com_reddit_frontpage_di_component_UserComponent_sessionManager(UserComponent userComponent) {
            this.f27759a = userComponent;
        }

        public /* synthetic */ Object get() {
            return (SessionManager) Preconditions.m26013a(this.f27759a.mo4621i(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private DaggerNavUserAccountComponent(Builder builder) {
        this.f27760a = InstanceFactory.m35583a(builder.f27755b);
        this.f27761b = new C2272x5ad35b3b(builder.f27754a);
        this.f27762c = new C2273xdbdd5b83(builder.f27754a);
        this.f27763d = new com_reddit_frontpage_di_component_UserComponent_accountFormatter(builder.f27754a);
        this.f27764e = new com_reddit_frontpage_di_component_UserComponent_sessionManager(builder.f27754a);
        this.f27765f = DoubleCheck.m31842a(RedditNavHeaderPresenter_Factory.m34814a(this.f27760a, this.f27761b, this.f27762c, this.f27763d, this.f27764e));
    }

    public static com.reddit.frontpage.di.component.NavUserAccountComponent.Builder m29194a() {
        return new Builder();
    }

    public final RedditNavHeaderPresenter mo4693b() {
        return (RedditNavHeaderPresenter) this.f27765f.get();
    }
}
