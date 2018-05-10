package com.reddit.frontpage.di.module;

import com.reddit.frontpage.presentation.geopopular.select.GeopopularRegionSelectContract.View;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class GeopopularRegionSelectViewModule_ViewFactory implements Factory<View> {
    private final GeopopularRegionSelectViewModule f33575a;

    private GeopopularRegionSelectViewModule_ViewFactory(GeopopularRegionSelectViewModule geopopularRegionSelectViewModule) {
        this.f33575a = geopopularRegionSelectViewModule;
    }

    public static GeopopularRegionSelectViewModule_ViewFactory m34488a(GeopopularRegionSelectViewModule geopopularRegionSelectViewModule) {
        return new GeopopularRegionSelectViewModule_ViewFactory(geopopularRegionSelectViewModule);
    }

    public final /* synthetic */ Object get() {
        return (View) Preconditions.m26013a(this.f33575a.f20237a, "Cannot return null from a non-@Nullable @Provides method");
    }
}
