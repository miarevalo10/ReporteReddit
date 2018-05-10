package com.reddit.frontpage.di.component;

import com.reddit.frontpage.di.module.BanReasonsViewModule;
import com.reddit.frontpage.di.module.BanReasonsViewModule_ViewFactory;
import com.reddit.frontpage.presentation.modtools.ban.add.bottomsheet.BanReasonsContract.View;
import com.reddit.frontpage.presentation.modtools.ban.add.bottomsheet.BanReasonsPresenter;
import com.reddit.frontpage.presentation.modtools.ban.add.bottomsheet.BanReasonsScreen;
import com.reddit.frontpage.presentation.modtools.ban.add.bottomsheet.BanReasonsScreen_MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DaggerBanReasonsComponent implements BanReasonsComponent {
    private Provider<View> f27514a;

    public static final class Builder {
        private BanReasonsViewModule f20160a;
        private UserComponent f20161b;

        private Builder() {
        }

        public final BanReasonsComponent m22069a() {
            StringBuilder stringBuilder;
            if (this.f20160a == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(BanReasonsViewModule.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            } else if (this.f20161b != null) {
                return new DaggerBanReasonsComponent();
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append(UserComponent.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            }
        }

        public final Builder m22071a(BanReasonsViewModule banReasonsViewModule) {
            this.f20160a = (BanReasonsViewModule) Preconditions.m26012a(banReasonsViewModule);
            return this;
        }

        public final Builder m22070a(UserComponent userComponent) {
            this.f20161b = (UserComponent) Preconditions.m26012a(userComponent);
            return this;
        }
    }

    private DaggerBanReasonsComponent(Builder builder) {
        this.f27514a = DoubleCheck.m31842a(BanReasonsViewModule_ViewFactory.m34468a(builder.f20160a));
    }

    public static Builder m29030a() {
        return new Builder();
    }

    public final void mo4611a(BanReasonsScreen banReasonsScreen) {
        BanReasonsScreen_MembersInjector.m29752a(banReasonsScreen, new BanReasonsPresenter((View) this.f27514a.get()));
    }
}
