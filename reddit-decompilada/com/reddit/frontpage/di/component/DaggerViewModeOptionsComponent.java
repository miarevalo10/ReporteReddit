package com.reddit.frontpage.di.component;

import com.reddit.frontpage.di.module.ViewModeOptionsViewModule;
import com.reddit.frontpage.di.module.ViewModeOptionsViewModule_ViewFactory;
import com.reddit.frontpage.presentation.viewmode.ViewModeOptionsContract.View;
import com.reddit.frontpage.presentation.viewmode.ViewModeOptionsPresenter;
import com.reddit.frontpage.presentation.viewmode.ViewModeOptionsScreen;
import com.reddit.frontpage.presentation.viewmode.ViewModeOptionsScreen_MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DaggerViewModeOptionsComponent implements ViewModeOptionsComponent {
    private Provider<View> f27952a;

    public static final class Builder {
        private ViewModeOptionsViewModule f20223a;
        private UserComponent f20224b;

        private Builder() {
        }

        public final ViewModeOptionsComponent m22181a() {
            StringBuilder stringBuilder;
            if (this.f20223a == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(ViewModeOptionsViewModule.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            } else if (this.f20224b != null) {
                return new DaggerViewModeOptionsComponent();
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append(UserComponent.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            }
        }

        public final Builder m22180a(ViewModeOptionsViewModule viewModeOptionsViewModule) {
            this.f20223a = (ViewModeOptionsViewModule) Preconditions.m26012a(viewModeOptionsViewModule);
            return this;
        }

        public final Builder m22179a(UserComponent userComponent) {
            this.f20224b = (UserComponent) Preconditions.m26012a(userComponent);
            return this;
        }
    }

    private DaggerViewModeOptionsComponent(Builder builder) {
        this.f27952a = DoubleCheck.m31842a(ViewModeOptionsViewModule_ViewFactory.m34551a(builder.f20223a));
    }

    public static Builder m29305a() {
        return new Builder();
    }

    public final void mo4754a(ViewModeOptionsScreen viewModeOptionsScreen) {
        ViewModeOptionsScreen_MembersInjector.m29905a(viewModeOptionsScreen, new ViewModeOptionsPresenter((View) this.f27952a.get()));
    }
}
