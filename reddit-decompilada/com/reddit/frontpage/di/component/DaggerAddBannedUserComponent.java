package com.reddit.frontpage.di.component;

import com.reddit.common.rx.PostExecutionThread;
import com.reddit.frontpage.di.module.AddBannedUserViewModule;
import com.reddit.frontpage.di.module.AddBannedUserViewModule_ViewFactory;
import com.reddit.frontpage.domain.repository.ModToolsRepository;
import com.reddit.frontpage.presentation.modtools.ban.add.AddBannedUserContract.View;
import com.reddit.frontpage.presentation.modtools.ban.add.AddBannedUserPresenter;
import com.reddit.frontpage.presentation.modtools.ban.add.AddBannedUserScreen;
import com.reddit.frontpage.presentation.modtools.ban.add.AddBannedUserScreen_MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DaggerAddBannedUserComponent implements AddBannedUserComponent {
    private UserComponent f27499a;
    private Provider<View> f27500b;

    public static final class Builder {
        private AddBannedUserViewModule f20148a;
        private UserComponent f20149b;

        private Builder() {
        }

        public final AddBannedUserComponent m22043a() {
            StringBuilder stringBuilder;
            if (this.f20148a == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(AddBannedUserViewModule.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            } else if (this.f20149b != null) {
                return new DaggerAddBannedUserComponent();
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append(UserComponent.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            }
        }

        public final Builder m22045a(AddBannedUserViewModule addBannedUserViewModule) {
            this.f20148a = (AddBannedUserViewModule) Preconditions.m26012a(addBannedUserViewModule);
            return this;
        }

        public final Builder m22044a(UserComponent userComponent) {
            this.f20149b = (UserComponent) Preconditions.m26012a(userComponent);
            return this;
        }
    }

    private DaggerAddBannedUserComponent(Builder builder) {
        this.f27500b = DoubleCheck.m31842a(AddBannedUserViewModule_ViewFactory.m34448a(builder.f20148a));
        this.f27499a = builder.f20149b;
    }

    public static Builder m28994a() {
        return new Builder();
    }

    public final void mo4581a(AddBannedUserScreen addBannedUserScreen) {
        AddBannedUserScreen_MembersInjector.m29746a(addBannedUserScreen, new AddBannedUserPresenter((View) this.f27500b.get(), (ModToolsRepository) Preconditions.m26013a(this.f27499a.mo4630r(), "Cannot return null from a non-@Nullable component method"), (PostExecutionThread) Preconditions.m26013a(this.f27499a.mo4633u(), "Cannot return null from a non-@Nullable component method")));
    }
}
