package com.reddit.frontpage.di.component;

import com.reddit.common.rx.PostExecutionThread;
import com.reddit.frontpage.di.module.AddApprovedSubmitterViewModule;
import com.reddit.frontpage.di.module.AddApprovedSubmitterViewModule_ViewFactory;
import com.reddit.frontpage.domain.repository.ModToolsRepository;
import com.reddit.frontpage.presentation.modtools.approvedsubmitters.add.AddApprovedSubmitterContract.View;
import com.reddit.frontpage.presentation.modtools.approvedsubmitters.add.AddApprovedSubmitterPresenter;
import com.reddit.frontpage.presentation.modtools.approvedsubmitters.add.AddApprovedSubmitterScreen;
import com.reddit.frontpage.presentation.modtools.approvedsubmitters.add.AddApprovedSubmitterScreen_MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DaggerAddApprovedSubmitterComponent implements AddApprovedSubmitterComponent {
    private UserComponent f27497a;
    private Provider<View> f27498b;

    public static final class Builder {
        private AddApprovedSubmitterViewModule f20146a;
        private UserComponent f20147b;

        private Builder() {
        }

        public final AddApprovedSubmitterComponent m22038a() {
            StringBuilder stringBuilder;
            if (this.f20146a == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(AddApprovedSubmitterViewModule.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            } else if (this.f20147b != null) {
                return new DaggerAddApprovedSubmitterComponent();
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append(UserComponent.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            }
        }

        public final Builder m22040a(AddApprovedSubmitterViewModule addApprovedSubmitterViewModule) {
            this.f20146a = (AddApprovedSubmitterViewModule) Preconditions.m26012a(addApprovedSubmitterViewModule);
            return this;
        }

        public final Builder m22039a(UserComponent userComponent) {
            this.f20147b = (UserComponent) Preconditions.m26012a(userComponent);
            return this;
        }
    }

    private DaggerAddApprovedSubmitterComponent(Builder builder) {
        this.f27498b = DoubleCheck.m31842a(AddApprovedSubmitterViewModule_ViewFactory.m34447a(builder.f20146a));
        this.f27497a = builder.f20147b;
    }

    public static Builder m28992a() {
        return new Builder();
    }

    public final void mo4580a(AddApprovedSubmitterScreen addApprovedSubmitterScreen) {
        AddApprovedSubmitterScreen_MembersInjector.m29743a(addApprovedSubmitterScreen, new AddApprovedSubmitterPresenter((View) this.f27498b.get(), (ModToolsRepository) Preconditions.m26013a(this.f27497a.mo4630r(), "Cannot return null from a non-@Nullable component method"), (PostExecutionThread) Preconditions.m26013a(this.f27497a.mo4633u(), "Cannot return null from a non-@Nullable component method")));
    }
}
