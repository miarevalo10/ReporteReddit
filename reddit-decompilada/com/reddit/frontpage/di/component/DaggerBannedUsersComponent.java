package com.reddit.frontpage.di.component;

import com.reddit.common.rx.PostExecutionThread;
import com.reddit.frontpage.di.module.BannedUsersViewModule;
import com.reddit.frontpage.di.module.BannedUsersViewModule_ViewFactory;
import com.reddit.frontpage.domain.repository.ModToolsRepository;
import com.reddit.frontpage.presentation.modtools.ban.BannedUsersPresenter;
import com.reddit.frontpage.presentation.modtools.ban.BannedUsersScreen;
import com.reddit.frontpage.presentation.modtools.ban.BannedUsersScreen_MembersInjector;
import com.reddit.frontpage.presentation.modtools.base.BaseModeratorsContract.View;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DaggerBannedUsersComponent implements BannedUsersComponent {
    private UserComponent f27515a;
    private Provider<View> f27516b;

    public static final class Builder {
        private BannedUsersViewModule f20162a;
        private UserComponent f20163b;

        private Builder() {
        }

        public final BannedUsersComponent m22074a() {
            StringBuilder stringBuilder;
            if (this.f20162a == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(BannedUsersViewModule.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            } else if (this.f20163b != null) {
                return new DaggerBannedUsersComponent();
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append(UserComponent.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            }
        }

        public final Builder m22076a(BannedUsersViewModule bannedUsersViewModule) {
            this.f20162a = (BannedUsersViewModule) Preconditions.m26012a(bannedUsersViewModule);
            return this;
        }

        public final Builder m22075a(UserComponent userComponent) {
            this.f20163b = (UserComponent) Preconditions.m26012a(userComponent);
            return this;
        }
    }

    private DaggerBannedUsersComponent(Builder builder) {
        this.f27516b = DoubleCheck.m31842a(BannedUsersViewModule_ViewFactory.m34469a(builder.f20162a));
        this.f27515a = builder.f20163b;
    }

    public static Builder m29032a() {
        return new Builder();
    }

    public final void mo4612a(BannedUsersScreen bannedUsersScreen) {
        BannedUsersScreen_MembersInjector.m29745a(bannedUsersScreen, new BannedUsersPresenter((View) this.f27516b.get(), (ModToolsRepository) Preconditions.m26013a(this.f27515a.mo4630r(), "Cannot return null from a non-@Nullable component method"), (PostExecutionThread) Preconditions.m26013a(this.f27515a.mo4633u(), "Cannot return null from a non-@Nullable component method")));
    }
}
