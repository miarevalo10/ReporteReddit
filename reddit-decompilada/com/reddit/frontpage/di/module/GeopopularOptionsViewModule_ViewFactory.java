package com.reddit.frontpage.di.module;

import com.reddit.frontpage.presentation.geopopular.option.GeopopularOptionContract.View;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class GeopopularOptionsViewModule_ViewFactory implements Factory<View> {
    private final GeopopularOptionsViewModule f33572a;

    private GeopopularOptionsViewModule_ViewFactory(GeopopularOptionsViewModule geopopularOptionsViewModule) {
        this.f33572a = geopopularOptionsViewModule;
    }

    public static GeopopularOptionsViewModule_ViewFactory m34485a(GeopopularOptionsViewModule geopopularOptionsViewModule) {
        return new GeopopularOptionsViewModule_ViewFactory(geopopularOptionsViewModule);
    }

    public final /* synthetic */ Object get() {
        return (View) Preconditions.m26013a(this.f33572a.f20235a, "Cannot return null from a non-@Nullable @Provides method");
    }
}
