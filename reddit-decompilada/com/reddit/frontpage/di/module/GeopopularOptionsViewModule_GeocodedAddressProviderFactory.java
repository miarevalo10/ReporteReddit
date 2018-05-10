package com.reddit.frontpage.di.module;

import com.reddit.datalibrary.frontpage.data.provider.GeocodedAddressProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class GeopopularOptionsViewModule_GeocodedAddressProviderFactory implements Factory<GeocodedAddressProvider> {
    private final GeopopularOptionsViewModule f33570a;

    private GeopopularOptionsViewModule_GeocodedAddressProviderFactory(GeopopularOptionsViewModule geopopularOptionsViewModule) {
        this.f33570a = geopopularOptionsViewModule;
    }

    public static GeopopularOptionsViewModule_GeocodedAddressProviderFactory m34483a(GeopopularOptionsViewModule geopopularOptionsViewModule) {
        return new GeopopularOptionsViewModule_GeocodedAddressProviderFactory(geopopularOptionsViewModule);
    }

    public final /* synthetic */ Object get() {
        return (GeocodedAddressProvider) Preconditions.m26013a(GeopopularOptionsViewModule.m22339a(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
