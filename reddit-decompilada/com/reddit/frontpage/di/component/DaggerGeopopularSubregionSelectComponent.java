package com.reddit.frontpage.di.component;

import com.reddit.common.rx.PostExecutionThread;
import com.reddit.frontpage.di.module.GeopopularSubregionSelectViewModule;
import com.reddit.frontpage.di.module.GeopopularSubregionSelectViewModule_NavigatorFactory;
import com.reddit.frontpage.di.module.GeopopularSubregionSelectViewModule_ViewFactory;
import com.reddit.frontpage.domain.repository.PreferenceRepository;
import com.reddit.frontpage.presentation.geopopular.subregion.GeopopularSubregionSelectContract.Navigator;
import com.reddit.frontpage.presentation.geopopular.subregion.GeopopularSubregionSelectContract.View;
import com.reddit.frontpage.presentation.geopopular.subregion.GeopopularSubregionSelectPresenter;
import com.reddit.frontpage.presentation.geopopular.subregion.GeopopularSubregionSelectScreen;
import com.reddit.frontpage.presentation.geopopular.subregion.GeopopularSubregionSelectScreen_MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DaggerGeopopularSubregionSelectComponent implements GeopopularSubregionSelectComponent {
    private UserComponent f27682a;
    private Provider<View> f27683b;
    private Provider<Navigator> f27684c;

    public static final class Builder {
        private GeopopularSubregionSelectViewModule f20188a;
        private UserComponent f20189b;

        private Builder() {
        }

        public final GeopopularSubregionSelectComponent m22114a() {
            StringBuilder stringBuilder;
            if (this.f20188a == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(GeopopularSubregionSelectViewModule.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            } else if (this.f20189b != null) {
                return new DaggerGeopopularSubregionSelectComponent();
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append(UserComponent.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            }
        }

        public final Builder m22113a(GeopopularSubregionSelectViewModule geopopularSubregionSelectViewModule) {
            this.f20188a = (GeopopularSubregionSelectViewModule) Preconditions.m26012a(geopopularSubregionSelectViewModule);
            return this;
        }

        public final Builder m22112a(UserComponent userComponent) {
            this.f20189b = (UserComponent) Preconditions.m26012a(userComponent);
            return this;
        }
    }

    private DaggerGeopopularSubregionSelectComponent(Builder builder) {
        this.f27683b = DoubleCheck.m31842a(GeopopularSubregionSelectViewModule_ViewFactory.m34490a(builder.f20188a));
        this.f27684c = DoubleCheck.m31842a(GeopopularSubregionSelectViewModule_NavigatorFactory.m34489a(builder.f20188a));
        this.f27682a = builder.f20189b;
    }

    public static Builder m29136a() {
        return new Builder();
    }

    public final void mo4663a(GeopopularSubregionSelectScreen geopopularSubregionSelectScreen) {
        GeopopularSubregionSelectScreen_MembersInjector.m29546a(geopopularSubregionSelectScreen, new GeopopularSubregionSelectPresenter((View) this.f27683b.get(), (Navigator) this.f27684c.get(), (PreferenceRepository) Preconditions.m26013a(this.f27682a.mo4613a(), "Cannot return null from a non-@Nullable component method"), (PostExecutionThread) Preconditions.m26013a(this.f27682a.mo4633u(), "Cannot return null from a non-@Nullable component method")));
    }
}
