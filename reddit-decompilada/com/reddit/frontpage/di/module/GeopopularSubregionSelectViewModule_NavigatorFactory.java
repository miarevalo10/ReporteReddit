package com.reddit.frontpage.di.module;

import com.reddit.frontpage.presentation.geopopular.subregion.GeopopularSubregionSelectContract.Navigator;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class GeopopularSubregionSelectViewModule_NavigatorFactory implements Factory<Navigator> {
    private final GeopopularSubregionSelectViewModule f33576a;

    private GeopopularSubregionSelectViewModule_NavigatorFactory(GeopopularSubregionSelectViewModule geopopularSubregionSelectViewModule) {
        this.f33576a = geopopularSubregionSelectViewModule;
    }

    public static GeopopularSubregionSelectViewModule_NavigatorFactory m34489a(GeopopularSubregionSelectViewModule geopopularSubregionSelectViewModule) {
        return new GeopopularSubregionSelectViewModule_NavigatorFactory(geopopularSubregionSelectViewModule);
    }

    public final /* synthetic */ Object get() {
        return (Navigator) Preconditions.m26013a(this.f33576a.f20240b, "Cannot return null from a non-@Nullable @Provides method");
    }
}
