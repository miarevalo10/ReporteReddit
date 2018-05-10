package com.reddit.frontpage.di.component;

import com.reddit.common.rx.PostExecutionThread;
import com.reddit.frontpage.di.module.UserModalModule;
import com.reddit.frontpage.di.module.UserModalModule_ViewFactory;
import com.reddit.frontpage.domain.repository.AccountRepository;
import com.reddit.frontpage.domain.repository.ModToolsRepository;
import com.reddit.frontpage.presentation.formatter.AccountFormatter;
import com.reddit.frontpage.presentation.usermodal.UserModalContract.View;
import com.reddit.frontpage.presentation.usermodal.UserModalPresenter;
import com.reddit.frontpage.presentation.usermodal.UserModalScreen;
import com.reddit.frontpage.presentation.usermodal.UserModalScreen_MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DaggerUserModalComponent implements UserModalComponent {
    private UserComponent f27924a;
    private Provider<View> f27925b;

    public static final class Builder {
        private UserModalModule f20221a;
        private UserComponent f20222b;

        private Builder() {
        }

        public final UserModalComponent m22177a() {
            StringBuilder stringBuilder;
            if (this.f20221a == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(UserModalModule.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            } else if (this.f20222b != null) {
                return new DaggerUserModalComponent();
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append(UserComponent.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            }
        }

        public final Builder m22176a(UserModalModule userModalModule) {
            this.f20221a = (UserModalModule) Preconditions.m26012a(userModalModule);
            return this;
        }

        public final Builder m22175a(UserComponent userComponent) {
            this.f20222b = (UserComponent) Preconditions.m26012a(userComponent);
            return this;
        }
    }

    private DaggerUserModalComponent(Builder builder) {
        this.f27925b = DoubleCheck.m31842a(UserModalModule_ViewFactory.m34542a(builder.f20221a));
        this.f27924a = builder.f20222b;
    }

    public static Builder m29291a() {
        return new Builder();
    }

    public final void mo4747a(UserModalScreen userModalScreen) {
        UserModalScreen_MembersInjector.m29903a(userModalScreen, new UserModalPresenter((View) this.f27925b.get(), (ModToolsRepository) Preconditions.m26013a(this.f27924a.mo4630r(), "Cannot return null from a non-@Nullable component method"), (PostExecutionThread) Preconditions.m26013a(this.f27924a.mo4633u(), "Cannot return null from a non-@Nullable component method"), (AccountRepository) Preconditions.m26013a(this.f27924a.mo4614b(), "Cannot return null from a non-@Nullable component method")));
        UserModalScreen_MembersInjector.m29902a(userModalScreen, (AccountFormatter) Preconditions.m26013a(this.f27924a.mo4626n(), "Cannot return null from a non-@Nullable component method"));
    }
}
