package com.reddit.frontpage.di.module;

import com.reddit.frontpage.presentation.geopopular.option.GeopopularOptionContract.Navigator;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class GeopopularOptionsViewModule_NavigatorFactory implements Factory<Navigator> {
    private final GeopopularOptionsViewModule f33571a;

    private GeopopularOptionsViewModule_NavigatorFactory(GeopopularOptionsViewModule geopopularOptionsViewModule) {
        this.f33571a = geopopularOptionsViewModule;
    }

    public static GeopopularOptionsViewModule_NavigatorFactory m34484a(GeopopularOptionsViewModule geopopularOptionsViewModule) {
        return new GeopopularOptionsViewModule_NavigatorFactory(geopopularOptionsViewModule);
    }

    public final /* synthetic */ Object get() {
        return (Navigator) Preconditions.m26013a(this.f33571a.f20236b, "Cannot return null from a non-@Nullable @Provides method");
    }
}
