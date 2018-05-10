package com.reddit.frontpage.di.module;

import com.reddit.datalibrary.frontpage.data.provider.GeocodedAddressProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class GeopopularRegionSelectViewModule_GeocodedAddressProviderFactory implements Factory<GeocodedAddressProvider> {
    private final GeopopularRegionSelectViewModule f33573a;

    private GeopopularRegionSelectViewModule_GeocodedAddressProviderFactory(GeopopularRegionSelectViewModule geopopularRegionSelectViewModule) {
        this.f33573a = geopopularRegionSelectViewModule;
    }

    public static GeopopularRegionSelectViewModule_GeocodedAddressProviderFactory m34486a(GeopopularRegionSelectViewModule geopopularRegionSelectViewModule) {
        return new GeopopularRegionSelectViewModule_GeocodedAddressProviderFactory(geopopularRegionSelectViewModule);
    }

    public final /* synthetic */ Object get() {
        return (GeocodedAddressProvider) Preconditions.m26013a(GeopopularRegionSelectViewModule.m22340a(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
