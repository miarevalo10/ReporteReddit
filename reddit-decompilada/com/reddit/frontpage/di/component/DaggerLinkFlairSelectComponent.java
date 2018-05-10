package com.reddit.frontpage.di.component;

import com.reddit.frontpage.di.module.LinkFlairSelectViewModule;
import com.reddit.frontpage.di.module.LinkFlairSelectViewModule_ViewFactory;
import com.reddit.frontpage.presentation.flair.LinkFlairSelectContract.View;
import com.reddit.frontpage.presentation.flair.LinkFlairSelectPresenter;
import com.reddit.frontpage.ui.submit.LinkFlairSelectScreen;
import com.reddit.frontpage.ui.submit.LinkFlairSelectScreen_MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DaggerLinkFlairSelectComponent implements LinkFlairSelectComponent {
    private Provider<View> f27728a;

    public static final class Builder {
        private LinkFlairSelectViewModule f20190a;
        private UserComponent f20191b;

        private Builder() {
        }

        public final LinkFlairSelectComponent m22118a() {
            StringBuilder stringBuilder;
            if (this.f20190a == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(LinkFlairSelectViewModule.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            } else if (this.f20191b != null) {
                return new DaggerLinkFlairSelectComponent();
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append(UserComponent.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            }
        }

        public final Builder m22117a(LinkFlairSelectViewModule linkFlairSelectViewModule) {
            this.f20190a = (LinkFlairSelectViewModule) Preconditions.m26012a(linkFlairSelectViewModule);
            return this;
        }

        public final Builder m22116a(UserComponent userComponent) {
            this.f20191b = (UserComponent) Preconditions.m26012a(userComponent);
            return this;
        }
    }

    private DaggerLinkFlairSelectComponent(Builder builder) {
        this.f27728a = DoubleCheck.m31842a(LinkFlairSelectViewModule_ViewFactory.m34496a(builder.f20190a));
    }

    public static Builder m29164a() {
        return new Builder();
    }

    public final void mo4677a(LinkFlairSelectScreen linkFlairSelectScreen) {
        LinkFlairSelectScreen_MembersInjector.m30395a(linkFlairSelectScreen, new LinkFlairSelectPresenter((View) this.f27728a.get()));
    }
}
