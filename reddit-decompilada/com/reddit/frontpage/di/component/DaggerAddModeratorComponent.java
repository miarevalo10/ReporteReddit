package com.reddit.frontpage.di.component;

import com.reddit.common.rx.PostExecutionThread;
import com.reddit.frontpage.di.module.AddModeratorViewModule;
import com.reddit.frontpage.di.module.AddModeratorViewModule_ViewFactory;
import com.reddit.frontpage.domain.repository.ModToolsRepository;
import com.reddit.frontpage.presentation.modtools.modlist.add.AddModeratorContract.View;
import com.reddit.frontpage.presentation.modtools.modlist.add.AddModeratorPresenter;
import com.reddit.frontpage.presentation.modtools.modlist.add.AddModeratorScreen;
import com.reddit.frontpage.presentation.modtools.modlist.add.AddModeratorScreen_MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DaggerAddModeratorComponent implements AddModeratorComponent {
    private UserComponent f27501a;
    private Provider<View> f27502b;

    public static final class Builder {
        private AddModeratorViewModule f20150a;
        private UserComponent f20151b;

        private Builder() {
        }

        public final AddModeratorComponent m22048a() {
            StringBuilder stringBuilder;
            if (this.f20150a == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(AddModeratorViewModule.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            } else if (this.f20151b != null) {
                return new DaggerAddModeratorComponent();
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append(UserComponent.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            }
        }

        public final Builder m22050a(AddModeratorViewModule addModeratorViewModule) {
            this.f20150a = (AddModeratorViewModule) Preconditions.m26012a(addModeratorViewModule);
            return this;
        }

        public final Builder m22049a(UserComponent userComponent) {
            this.f20151b = (UserComponent) Preconditions.m26012a(userComponent);
            return this;
        }
    }

    private DaggerAddModeratorComponent(Builder builder) {
        this.f27502b = DoubleCheck.m31842a(AddModeratorViewModule_ViewFactory.m34449a(builder.f20150a));
        this.f27501a = builder.f20151b;
    }

    public static Builder m28996a() {
        return new Builder();
    }

    public final void mo4582a(AddModeratorScreen addModeratorScreen) {
        AddModeratorScreen_MembersInjector.m29775a(addModeratorScreen, new AddModeratorPresenter((View) this.f27502b.get(), (ModToolsRepository) Preconditions.m26013a(this.f27501a.mo4630r(), "Cannot return null from a non-@Nullable component method"), (PostExecutionThread) Preconditions.m26013a(this.f27501a.mo4633u(), "Cannot return null from a non-@Nullable component method")));
    }
}
