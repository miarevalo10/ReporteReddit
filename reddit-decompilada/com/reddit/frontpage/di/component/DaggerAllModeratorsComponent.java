package com.reddit.frontpage.di.component;

import com.reddit.common.rx.PostExecutionThread;
import com.reddit.frontpage.di.module.AllModeratorsViewModule;
import com.reddit.frontpage.di.module.AllModeratorsViewModule_ViewFactory;
import com.reddit.frontpage.domain.repository.ModToolsRepository;
import com.reddit.frontpage.presentation.modtools.modlist.all.AllModeratorsContract.View;
import com.reddit.frontpage.presentation.modtools.modlist.all.AllModeratorsPresenter;
import com.reddit.frontpage.presentation.modtools.modlist.all.AllModeratorsScreen;
import com.reddit.frontpage.presentation.modtools.modlist.all.AllModeratorsScreen_MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DaggerAllModeratorsComponent implements AllModeratorsComponent {
    private UserComponent f27505a;
    private Provider<View> f27506b;

    public static final class Builder {
        private AllModeratorsViewModule f20154a;
        private UserComponent f20155b;

        private Builder() {
        }

        public final AllModeratorsComponent m22058a() {
            StringBuilder stringBuilder;
            if (this.f20154a == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(AllModeratorsViewModule.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            } else if (this.f20155b != null) {
                return new DaggerAllModeratorsComponent();
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append(UserComponent.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            }
        }

        public final Builder m22060a(AllModeratorsViewModule allModeratorsViewModule) {
            this.f20154a = (AllModeratorsViewModule) Preconditions.m26012a(allModeratorsViewModule);
            return this;
        }

        public final Builder m22059a(UserComponent userComponent) {
            this.f20155b = (UserComponent) Preconditions.m26012a(userComponent);
            return this;
        }
    }

    private DaggerAllModeratorsComponent(Builder builder) {
        this.f27506b = DoubleCheck.m31842a(AllModeratorsViewModule_ViewFactory.m34454a(builder.f20154a));
        this.f27505a = builder.f20155b;
    }

    public static Builder m29000a() {
        return new Builder();
    }

    public final void mo4584a(AllModeratorsScreen allModeratorsScreen) {
        AllModeratorsScreen_MembersInjector.m29785a(allModeratorsScreen, new AllModeratorsPresenter((View) this.f27506b.get(), (ModToolsRepository) Preconditions.m26013a(this.f27505a.mo4630r(), "Cannot return null from a non-@Nullable component method"), (PostExecutionThread) Preconditions.m26013a(this.f27505a.mo4633u(), "Cannot return null from a non-@Nullable component method")));
    }
}
