package com.reddit.frontpage.di.component;

import com.reddit.common.rx.PostExecutionThread;
import com.reddit.frontpage.di.module.ModCommunitiesViewModule;
import com.reddit.frontpage.di.module.ModCommunitiesViewModule_ViewFactory;
import com.reddit.frontpage.domain.repository.SubredditRepository;
import com.reddit.frontpage.presentation.modtools.modqueue.modcommunities.ModCommunitiesContract.View;
import com.reddit.frontpage.presentation.modtools.modqueue.modcommunities.ModCommunitiesPresenter;
import com.reddit.frontpage.presentation.modtools.modqueue.modcommunities.ModCommunitiesScreen;
import com.reddit.frontpage.presentation.modtools.modqueue.modcommunities.ModCommunitiesScreen_MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DaggerModCommunitiesComponent implements ModCommunitiesComponent {
    private UserComponent f27744a;
    private Provider<View> f27745b;

    public static final class Builder {
        private ModCommunitiesViewModule f20192a;
        private UserComponent f20193b;

        private Builder() {
        }

        public final ModCommunitiesComponent m22123a() {
            StringBuilder stringBuilder;
            if (this.f20192a == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(ModCommunitiesViewModule.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            } else if (this.f20193b != null) {
                return new DaggerModCommunitiesComponent();
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append(UserComponent.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            }
        }

        public final Builder m22122a(ModCommunitiesViewModule modCommunitiesViewModule) {
            this.f20192a = (ModCommunitiesViewModule) Preconditions.m26012a(modCommunitiesViewModule);
            return this;
        }

        public final Builder m22121a(UserComponent userComponent) {
            this.f20193b = (UserComponent) Preconditions.m26012a(userComponent);
            return this;
        }
    }

    private DaggerModCommunitiesComponent(Builder builder) {
        this.f27745b = DoubleCheck.m31842a(ModCommunitiesViewModule_ViewFactory.m34498a(builder.f20192a));
        this.f27744a = builder.f20193b;
    }

    public static Builder m29177a() {
        return new Builder();
    }

    public final void mo4684a(ModCommunitiesScreen modCommunitiesScreen) {
        ModCommunitiesScreen_MembersInjector.m29797a(modCommunitiesScreen, new ModCommunitiesPresenter((View) this.f27745b.get(), (SubredditRepository) Preconditions.m26013a(this.f27744a.mo4635w(), "Cannot return null from a non-@Nullable component method"), (PostExecutionThread) Preconditions.m26013a(this.f27744a.mo4633u(), "Cannot return null from a non-@Nullable component method")));
    }
}
