package com.reddit.frontpage.di.component;

import com.reddit.frontpage.di.module.ModUsersOptionsViewModule;
import com.reddit.frontpage.di.module.ModUsersOptionsViewModule_ViewFactory;
import com.reddit.frontpage.presentation.modtools.bottomsheet.modusersoptions.ModUsersOptionsContract.View;
import com.reddit.frontpage.presentation.modtools.bottomsheet.modusersoptions.ModUsersOptionsPresenter;
import com.reddit.frontpage.presentation.modtools.bottomsheet.modusersoptions.ModUsersOptionsScreen;
import com.reddit.frontpage.presentation.modtools.bottomsheet.modusersoptions.ModUsersOptionsScreen_MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DaggerModUsersOptionsComponent implements ModUsersOptionsComponent {
    private Provider<View> f27751a;

    public static final class Builder {
        private ModUsersOptionsViewModule f20200a;
        private UserComponent f20201b;

        private Builder() {
        }

        public final ModUsersOptionsComponent m22141a() {
            StringBuilder stringBuilder;
            if (this.f20200a == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(ModUsersOptionsViewModule.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            } else if (this.f20201b != null) {
                return new DaggerModUsersOptionsComponent();
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append(UserComponent.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            }
        }

        public final Builder m22140a(ModUsersOptionsViewModule modUsersOptionsViewModule) {
            this.f20200a = (ModUsersOptionsViewModule) Preconditions.m26012a(modUsersOptionsViewModule);
            return this;
        }

        public final Builder m22139a(UserComponent userComponent) {
            this.f20201b = (UserComponent) Preconditions.m26012a(userComponent);
            return this;
        }
    }

    private DaggerModUsersOptionsComponent(Builder builder) {
        this.f27751a = DoubleCheck.m31842a(ModUsersOptionsViewModule_ViewFactory.m34504a(builder.f20200a));
    }

    public static Builder m29185a() {
        return new Builder();
    }

    public final void mo4688a(ModUsersOptionsScreen modUsersOptionsScreen) {
        ModUsersOptionsScreen_MembersInjector.m29773a(modUsersOptionsScreen, new ModUsersOptionsPresenter((View) this.f27751a.get()));
    }
}
