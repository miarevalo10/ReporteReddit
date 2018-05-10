package com.reddit.frontpage.di.component;

import android.content.Context;
import com.reddit.datalibrary.frontpage.data.provider.GeocodedAddressProvider;
import com.reddit.frontpage.di.module.GeopopularOptionsViewModule;
import com.reddit.frontpage.di.module.GeopopularOptionsViewModule_GeocodedAddressProviderFactory;
import com.reddit.frontpage.di.module.GeopopularOptionsViewModule_NavigatorFactory;
import com.reddit.frontpage.di.module.GeopopularOptionsViewModule_ViewFactory;
import com.reddit.frontpage.domain.repository.PreferenceRepository;
import com.reddit.frontpage.domain.repository.RegionRepository;
import com.reddit.frontpage.presentation.geopopular.option.GeopopularOptionContract.Navigator;
import com.reddit.frontpage.presentation.geopopular.option.GeopopularOptionContract.View;
import com.reddit.frontpage.presentation.geopopular.option.GeopopularOptionsPresenter;
import com.reddit.frontpage.presentation.geopopular.option.GeopopularOptionsScreen;
import com.reddit.frontpage.presentation.geopopular.option.GeopopularOptionsScreen_MembersInjector;
import com.reddit.frontpage.util.PermissionRepository;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DaggerGeopopularOptionsComponent implements GeopopularOptionsComponent {
    private UserComponent f27674a;
    private Provider<View> f27675b;
    private Provider<GeocodedAddressProvider> f27676c;
    private Provider<Navigator> f27677d;

    public static final class Builder {
        private GeopopularOptionsViewModule f20184a;
        private UserComponent f20185b;

        private Builder() {
        }

        public final GeopopularOptionsComponent m22104a() {
            StringBuilder stringBuilder;
            if (this.f20184a == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(GeopopularOptionsViewModule.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            } else if (this.f20185b != null) {
                return new DaggerGeopopularOptionsComponent();
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append(UserComponent.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            }
        }

        public final Builder m22103a(GeopopularOptionsViewModule geopopularOptionsViewModule) {
            this.f20184a = (GeopopularOptionsViewModule) Preconditions.m26012a(geopopularOptionsViewModule);
            return this;
        }

        public final Builder m22102a(UserComponent userComponent) {
            this.f20185b = (UserComponent) Preconditions.m26012a(userComponent);
            return this;
        }
    }

    private DaggerGeopopularOptionsComponent(Builder builder) {
        this.f27675b = DoubleCheck.m31842a(GeopopularOptionsViewModule_ViewFactory.m34485a(builder.f20184a));
        this.f27676c = DoubleCheck.m31842a(GeopopularOptionsViewModule_GeocodedAddressProviderFactory.m34483a(builder.f20184a));
        this.f27674a = builder.f20185b;
        this.f27677d = DoubleCheck.m31842a(GeopopularOptionsViewModule_NavigatorFactory.m34484a(builder.f20184a));
    }

    public static Builder m29132a() {
        return new Builder();
    }

    public final void mo4661a(GeopopularOptionsScreen geopopularOptionsScreen) {
        GeopopularOptionsScreen_MembersInjector.m29534a(geopopularOptionsScreen, new GeopopularOptionsPresenter((View) this.f27675b.get(), (GeocodedAddressProvider) this.f27676c.get(), (RegionRepository) Preconditions.m26013a(this.f27674a.mo4631s(), "Cannot return null from a non-@Nullable component method"), (PreferenceRepository) Preconditions.m26013a(this.f27674a.mo4613a(), "Cannot return null from a non-@Nullable component method"), (Navigator) this.f27677d.get(), new PermissionRepository((Context) Preconditions.m26013a(this.f27674a.mo4619g(), "Cannot return null from a non-@Nullable component method"))));
    }
}
