package com.reddit.frontpage.di.component;

import com.reddit.common.rx.PostExecutionThread;
import com.reddit.frontpage.di.module.AddMutedUserViewModule;
import com.reddit.frontpage.di.module.AddMutedUserViewModule_ViewFactory;
import com.reddit.frontpage.domain.repository.ModToolsRepository;
import com.reddit.frontpage.presentation.modtools.mute.add.AddMutedUserContract.View;
import com.reddit.frontpage.presentation.modtools.mute.add.AddMutedUserPresenter;
import com.reddit.frontpage.presentation.modtools.mute.add.AddMutedUserScreen;
import com.reddit.frontpage.presentation.modtools.mute.add.AddMutedUserScreen_MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DaggerAddMutedUserComponent implements AddMutedUserComponent {
    private UserComponent f27503a;
    private Provider<View> f27504b;

    public static final class Builder {
        private AddMutedUserViewModule f20152a;
        private UserComponent f20153b;

        private Builder() {
        }

        public final AddMutedUserComponent m22053a() {
            StringBuilder stringBuilder;
            if (this.f20152a == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(AddMutedUserViewModule.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            } else if (this.f20153b != null) {
                return new DaggerAddMutedUserComponent();
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append(UserComponent.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            }
        }

        public final Builder m22055a(AddMutedUserViewModule addMutedUserViewModule) {
            this.f20152a = (AddMutedUserViewModule) Preconditions.m26012a(addMutedUserViewModule);
            return this;
        }

        public final Builder m22054a(UserComponent userComponent) {
            this.f20153b = (UserComponent) Preconditions.m26012a(userComponent);
            return this;
        }
    }

    private DaggerAddMutedUserComponent(Builder builder) {
        this.f27504b = DoubleCheck.m31842a(AddMutedUserViewModule_ViewFactory.m34450a(builder.f20152a));
        this.f27503a = builder.f20153b;
    }

    public static Builder m28998a() {
        return new Builder();
    }

    public final void mo4583a(AddMutedUserScreen addMutedUserScreen) {
        AddMutedUserScreen_MembersInjector.m29799a(addMutedUserScreen, new AddMutedUserPresenter((View) this.f27504b.get(), (ModToolsRepository) Preconditions.m26013a(this.f27503a.mo4630r(), "Cannot return null from a non-@Nullable component method"), (PostExecutionThread) Preconditions.m26013a(this.f27503a.mo4633u(), "Cannot return null from a non-@Nullable component method")));
    }
}
