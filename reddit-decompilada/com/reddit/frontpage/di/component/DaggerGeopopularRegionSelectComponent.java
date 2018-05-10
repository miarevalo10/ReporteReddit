package com.reddit.frontpage.di.component;

import android.content.Context;
import com.reddit.common.rx.PostExecutionThread;
import com.reddit.datalibrary.frontpage.data.provider.GeocodedAddressProvider;
import com.reddit.frontpage.di.module.GeopopularRegionSelectViewModule;
import com.reddit.frontpage.di.module.GeopopularRegionSelectViewModule_GeocodedAddressProviderFactory;
import com.reddit.frontpage.di.module.GeopopularRegionSelectViewModule_NavigatorFactory;
import com.reddit.frontpage.di.module.GeopopularRegionSelectViewModule_ViewFactory;
import com.reddit.frontpage.domain.repository.PreferenceRepository;
import com.reddit.frontpage.domain.repository.RegionRepository;
import com.reddit.frontpage.presentation.geopopular.select.GeopopularRegionSelectContract.Navigator;
import com.reddit.frontpage.presentation.geopopular.select.GeopopularRegionSelectContract.View;
import com.reddit.frontpage.presentation.geopopular.select.GeopopularRegionSelectPresenter;
import com.reddit.frontpage.presentation.geopopular.select.GeopopularRegionSelectScreen;
import com.reddit.frontpage.presentation.geopopular.select.GeopopularRegionSelectScreen_MembersInjector;
import com.reddit.frontpage.util.PermissionRepository;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DaggerGeopopularRegionSelectComponent implements GeopopularRegionSelectComponent {
    private UserComponent f27678a;
    private Provider<View> f27679b;
    private Provider<GeocodedAddressProvider> f27680c;
    private Provider<Navigator> f27681d;

    public static final class Builder {
        private GeopopularRegionSelectViewModule f20186a;
        private UserComponent f20187b;

        private Builder() {
        }

        public final GeopopularRegionSelectComponent m22109a() {
            StringBuilder stringBuilder;
            if (this.f20186a == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(GeopopularRegionSelectViewModule.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            } else if (this.f20187b != null) {
                return new DaggerGeopopularRegionSelectComponent();
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append(UserComponent.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            }
        }

        public final Builder m22108a(GeopopularRegionSelectViewModule geopopularRegionSelectViewModule) {
            this.f20186a = (GeopopularRegionSelectViewModule) Preconditions.m26012a(geopopularRegionSelectViewModule);
            return this;
        }

        public final Builder m22107a(UserComponent userComponent) {
            this.f20187b = (UserComponent) Preconditions.m26012a(userComponent);
            return this;
        }
    }

    private DaggerGeopopularRegionSelectComponent(Builder builder) {
        this.f27679b = DoubleCheck.m31842a(GeopopularRegionSelectViewModule_ViewFactory.m34488a(builder.f20186a));
        this.f27680c = DoubleCheck.m31842a(GeopopularRegionSelectViewModule_GeocodedAddressProviderFactory.m34486a(builder.f20186a));
        this.f27681d = DoubleCheck.m31842a(GeopopularRegionSelectViewModule_NavigatorFactory.m34487a(builder.f20186a));
        this.f27678a = builder.f20187b;
    }

    public static Builder m29134a() {
        return new Builder();
    }

    public final void mo4662a(GeopopularRegionSelectScreen geopopularRegionSelectScreen) {
        GeopopularRegionSelectScreen_MembersInjector.m29537a(geopopularRegionSelectScreen, new GeopopularRegionSelectPresenter((View) this.f27679b.get(), (GeocodedAddressProvider) this.f27680c.get(), (Navigator) this.f27681d.get(), (RegionRepository) Preconditions.m26013a(this.f27678a.mo4631s(), "Cannot return null from a non-@Nullable component method"), (PreferenceRepository) Preconditions.m26013a(this.f27678a.mo4613a(), "Cannot return null from a non-@Nullable component method"), (PostExecutionThread) Preconditions.m26013a(this.f27678a.mo4633u(), "Cannot return null from a non-@Nullable component method"), new PermissionRepository((Context) Preconditions.m26013a(this.f27678a.mo4619g(), "Cannot return null from a non-@Nullable component method"))));
    }
}
