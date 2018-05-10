package com.reddit.frontpage.di.component;

import com.reddit.common.rx.PostExecutionThread;
import com.reddit.frontpage.di.module.ModQueueOptionsViewModule;
import com.reddit.frontpage.di.module.ModQueueOptionsViewModule_ViewFactory;
import com.reddit.frontpage.domain.repository.ModToolsRepository;
import com.reddit.frontpage.presentation.modtools.bottomsheet.modqueueoptions.ModQueueOptionsContract.View;
import com.reddit.frontpage.presentation.modtools.bottomsheet.modqueueoptions.ModQueueOptionsPresenter;
import com.reddit.frontpage.presentation.modtools.bottomsheet.modqueueoptions.ModQueueOptionsScreen;
import com.reddit.frontpage.presentation.modtools.bottomsheet.modqueueoptions.ModQueueOptionsScreen_MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DaggerModQueueOptionsComponent implements ModQueueOptionsComponent {
    private UserComponent f27746a;
    private Provider<View> f27747b;

    public static final class Builder {
        private ModQueueOptionsViewModule f20194a;
        private UserComponent f20195b;

        private Builder() {
        }

        public final ModQueueOptionsComponent m22128a() {
            StringBuilder stringBuilder;
            if (this.f20194a == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(ModQueueOptionsViewModule.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            } else if (this.f20195b != null) {
                return new DaggerModQueueOptionsComponent();
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append(UserComponent.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            }
        }

        public final Builder m22127a(ModQueueOptionsViewModule modQueueOptionsViewModule) {
            this.f20194a = (ModQueueOptionsViewModule) Preconditions.m26012a(modQueueOptionsViewModule);
            return this;
        }

        public final Builder m22126a(UserComponent userComponent) {
            this.f20195b = (UserComponent) Preconditions.m26012a(userComponent);
            return this;
        }
    }

    private DaggerModQueueOptionsComponent(Builder builder) {
        this.f27746a = builder.f20195b;
        this.f27747b = DoubleCheck.m31842a(ModQueueOptionsViewModule_ViewFactory.m34499a(builder.f20194a));
    }

    public static Builder m29179a() {
        return new Builder();
    }

    public final void mo4685a(ModQueueOptionsScreen modQueueOptionsScreen) {
        ModQueueOptionsScreen_MembersInjector.m29772a(modQueueOptionsScreen, new ModQueueOptionsPresenter((ModToolsRepository) Preconditions.m26013a(this.f27746a.mo4630r(), "Cannot return null from a non-@Nullable component method"), (View) this.f27747b.get(), (PostExecutionThread) Preconditions.m26013a(this.f27746a.mo4633u(), "Cannot return null from a non-@Nullable component method")));
    }
}
