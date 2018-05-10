package com.reddit.frontpage.di.component;

import com.reddit.common.rx.PostExecutionThread;
import com.reddit.frontpage.di.module.UserAccountViewModule;
import com.reddit.frontpage.di.module.UserAccountViewModule_ViewFactory;
import com.reddit.frontpage.domain.repository.AccountRepository;
import com.reddit.frontpage.domain.repository.TrophiesRepository;
import com.reddit.frontpage.presentation.formatter.AccountFormatter;
import com.reddit.frontpage.presentation.profile.user.UserAccountContract.View;
import com.reddit.frontpage.presentation.profile.user.UserAccountPresenter;
import com.reddit.frontpage.presentation.profile.user.UserAccountScreen;
import com.reddit.frontpage.presentation.profile.user.UserAccountScreen_MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DaggerUserAccountComponent implements UserAccountComponent {
    private UserComponent f27922a;
    private Provider<View> f27923b;

    public static final class Builder {
        private UserAccountViewModule f20219a;
        private UserComponent f20220b;

        private Builder() {
        }

        public final UserAccountComponent m22172a() {
            StringBuilder stringBuilder;
            if (this.f20219a == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(UserAccountViewModule.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            } else if (this.f20220b != null) {
                return new DaggerUserAccountComponent();
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append(UserComponent.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            }
        }

        public final Builder m22171a(UserAccountViewModule userAccountViewModule) {
            this.f20219a = (UserAccountViewModule) Preconditions.m26012a(userAccountViewModule);
            return this;
        }

        public final Builder m22170a(UserComponent userComponent) {
            this.f20220b = (UserComponent) Preconditions.m26012a(userComponent);
            return this;
        }
    }

    private DaggerUserAccountComponent(Builder builder) {
        this.f27923b = DoubleCheck.m31842a(UserAccountViewModule_ViewFactory.m34541a(builder.f20219a));
        this.f27922a = builder.f20220b;
    }

    public static Builder m29289a() {
        return new Builder();
    }

    public final void mo4746a(UserAccountScreen userAccountScreen) {
        UserAccountScreen_MembersInjector.m29854a(userAccountScreen, new UserAccountPresenter((View) this.f27923b.get(), (AccountRepository) Preconditions.m26013a(this.f27922a.mo4614b(), "Cannot return null from a non-@Nullable component method"), (TrophiesRepository) Preconditions.m26013a(this.f27922a.mo4638z(), "Cannot return null from a non-@Nullable component method"), (PostExecutionThread) Preconditions.m26013a(this.f27922a.mo4633u(), "Cannot return null from a non-@Nullable component method"), (AccountFormatter) Preconditions.m26013a(this.f27922a.mo4626n(), "Cannot return null from a non-@Nullable component method")));
    }
}
