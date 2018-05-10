package com.reddit.frontpage.di.component;

import com.reddit.common.rx.PostExecutionThread;
import com.reddit.frontpage.di.module.ApprovedSubmittersViewModule;
import com.reddit.frontpage.di.module.ApprovedSubmittersViewModule_ViewFactory;
import com.reddit.frontpage.domain.repository.ModToolsRepository;
import com.reddit.frontpage.presentation.modtools.approvedsubmitters.ApprovedSubmittersPresenter;
import com.reddit.frontpage.presentation.modtools.approvedsubmitters.ApprovedSubmittersScreen;
import com.reddit.frontpage.presentation.modtools.approvedsubmitters.ApprovedSubmittersScreen_MembersInjector;
import com.reddit.frontpage.presentation.modtools.base.BaseModeratorsContract.View;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DaggerApprovedSubmittersComponent implements ApprovedSubmittersComponent {
    private UserComponent f27512a;
    private Provider<View> f27513b;

    public static final class Builder {
        private ApprovedSubmittersViewModule f20158a;
        private UserComponent f20159b;

        private Builder() {
        }

        public final ApprovedSubmittersComponent m22065a() {
            StringBuilder stringBuilder;
            if (this.f20158a == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(ApprovedSubmittersViewModule.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            } else if (this.f20159b != null) {
                return new DaggerApprovedSubmittersComponent();
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append(UserComponent.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            }
        }

        public final Builder m22067a(ApprovedSubmittersViewModule approvedSubmittersViewModule) {
            this.f20158a = (ApprovedSubmittersViewModule) Preconditions.m26012a(approvedSubmittersViewModule);
            return this;
        }

        public final Builder m22066a(UserComponent userComponent) {
            this.f20159b = (UserComponent) Preconditions.m26012a(userComponent);
            return this;
        }
    }

    private DaggerApprovedSubmittersComponent(Builder builder) {
        this.f27513b = DoubleCheck.m31842a(ApprovedSubmittersViewModule_ViewFactory.m34467a(builder.f20158a));
        this.f27512a = builder.f20159b;
    }

    public static Builder m29028a() {
        return new Builder();
    }

    public final void mo4610a(ApprovedSubmittersScreen approvedSubmittersScreen) {
        ApprovedSubmittersScreen_MembersInjector.m29742a(approvedSubmittersScreen, new ApprovedSubmittersPresenter((View) this.f27513b.get(), (ModToolsRepository) Preconditions.m26013a(this.f27512a.mo4630r(), "Cannot return null from a non-@Nullable component method"), (PostExecutionThread) Preconditions.m26013a(this.f27512a.mo4633u(), "Cannot return null from a non-@Nullable component method")));
    }
}
