package com.reddit.frontpage.di.component;

import com.reddit.common.rx.PostExecutionThread;
import com.reddit.frontpage.di.module.MutedUsersViewModule;
import com.reddit.frontpage.di.module.MutedUsersViewModule_ViewFactory;
import com.reddit.frontpage.domain.repository.ModToolsRepository;
import com.reddit.frontpage.presentation.modtools.base.BaseModeratorsContract.View;
import com.reddit.frontpage.presentation.modtools.mute.MutedUsersPresenter;
import com.reddit.frontpage.presentation.modtools.mute.MutedUsersScreen;
import com.reddit.frontpage.presentation.modtools.mute.MutedUsersScreen_MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DaggerMutedUsersComponent implements MutedUsersComponent {
    private UserComponent f27752a;
    private Provider<View> f27753b;

    public static final class Builder {
        private MutedUsersViewModule f20202a;
        private UserComponent f20203b;

        private Builder() {
        }

        public final MutedUsersComponent m22146a() {
            StringBuilder stringBuilder;
            if (this.f20202a == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(MutedUsersViewModule.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            } else if (this.f20203b != null) {
                return new DaggerMutedUsersComponent();
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append(UserComponent.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            }
        }

        public final Builder m22145a(MutedUsersViewModule mutedUsersViewModule) {
            this.f20202a = (MutedUsersViewModule) Preconditions.m26012a(mutedUsersViewModule);
            return this;
        }

        public final Builder m22144a(UserComponent userComponent) {
            this.f20203b = (UserComponent) Preconditions.m26012a(userComponent);
            return this;
        }
    }

    private DaggerMutedUsersComponent(Builder builder) {
        this.f27753b = DoubleCheck.m31842a(MutedUsersViewModule_ViewFactory.m34505a(builder.f20202a));
        this.f27752a = builder.f20203b;
    }

    public static Builder m29187a() {
        return new Builder();
    }

    public final void mo4689a(MutedUsersScreen mutedUsersScreen) {
        MutedUsersScreen_MembersInjector.m29798a(mutedUsersScreen, new MutedUsersPresenter((View) this.f27753b.get(), (ModToolsRepository) Preconditions.m26013a(this.f27752a.mo4630r(), "Cannot return null from a non-@Nullable component method"), (PostExecutionThread) Preconditions.m26013a(this.f27752a.mo4633u(), "Cannot return null from a non-@Nullable component method")));
    }
}
