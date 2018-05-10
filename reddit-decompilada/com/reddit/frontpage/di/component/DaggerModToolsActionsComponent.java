package com.reddit.frontpage.di.component;

import com.reddit.frontpage.di.module.ModToolsActionsViewModule;
import com.reddit.frontpage.di.module.ModToolsActionsViewModule_ViewFactory;
import com.reddit.frontpage.presentation.modtools.actions.ModToolsActionsContract.View;
import com.reddit.frontpage.presentation.modtools.actions.ModToolsActionsPresenter;
import com.reddit.frontpage.presentation.modtools.actions.ModToolsActionsScreen;
import com.reddit.frontpage.presentation.modtools.actions.ModToolsActionsScreen_MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DaggerModToolsActionsComponent implements ModToolsActionsComponent {
    private Provider<View> f27750a;

    public static final class Builder {
        private ModToolsActionsViewModule f20198a;
        private UserComponent f20199b;

        private Builder() {
        }

        public final ModToolsActionsComponent m22137a() {
            StringBuilder stringBuilder;
            if (this.f20198a == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(ModToolsActionsViewModule.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            } else if (this.f20199b != null) {
                return new DaggerModToolsActionsComponent();
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append(UserComponent.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            }
        }

        public final Builder m22136a(ModToolsActionsViewModule modToolsActionsViewModule) {
            this.f20198a = (ModToolsActionsViewModule) Preconditions.m26012a(modToolsActionsViewModule);
            return this;
        }

        public final Builder m22135a(UserComponent userComponent) {
            this.f20199b = (UserComponent) Preconditions.m26012a(userComponent);
            return this;
        }
    }

    private DaggerModToolsActionsComponent(Builder builder) {
        this.f27750a = DoubleCheck.m31842a(ModToolsActionsViewModule_ViewFactory.m34501a(builder.f20198a));
    }

    public static Builder m29183a() {
        return new Builder();
    }

    public final void mo4687a(ModToolsActionsScreen modToolsActionsScreen) {
        ModToolsActionsScreen_MembersInjector.m29731a(modToolsActionsScreen, new ModToolsActionsPresenter((View) this.f27750a.get()));
    }
}
