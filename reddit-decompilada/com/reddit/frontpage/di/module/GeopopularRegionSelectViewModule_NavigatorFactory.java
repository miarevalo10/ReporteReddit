package com.reddit.frontpage.di.module;

import com.reddit.frontpage.presentation.geopopular.select.GeopopularRegionSelectContract.Navigator;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class GeopopularRegionSelectViewModule_NavigatorFactory implements Factory<Navigator> {
    private final GeopopularRegionSelectViewModule f33574a;

    private GeopopularRegionSelectViewModule_NavigatorFactory(GeopopularRegionSelectViewModule geopopularRegionSelectViewModule) {
        this.f33574a = geopopularRegionSelectViewModule;
    }

    public static GeopopularRegionSelectViewModule_NavigatorFactory m34487a(GeopopularRegionSelectViewModule geopopularRegionSelectViewModule) {
        return new GeopopularRegionSelectViewModule_NavigatorFactory(geopopularRegionSelectViewModule);
    }

    public final /* synthetic */ Object get() {
        return (Navigator) Preconditions.m26013a(this.f33574a.f20238b, "Cannot return null from a non-@Nullable @Provides method");
    }
}
