package com.reddit.frontpage.di.module;

import com.reddit.frontpage.presentation.geopopular.subregion.GeopopularSubregionSelectContract.View;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class GeopopularSubregionSelectViewModule_ViewFactory implements Factory<View> {
    private final GeopopularSubregionSelectViewModule f33577a;

    private GeopopularSubregionSelectViewModule_ViewFactory(GeopopularSubregionSelectViewModule geopopularSubregionSelectViewModule) {
        this.f33577a = geopopularSubregionSelectViewModule;
    }

    public static GeopopularSubregionSelectViewModule_ViewFactory m34490a(GeopopularSubregionSelectViewModule geopopularSubregionSelectViewModule) {
        return new GeopopularSubregionSelectViewModule_ViewFactory(geopopularSubregionSelectViewModule);
    }

    public final /* synthetic */ Object get() {
        return (View) Preconditions.m26013a(this.f33577a.f20239a, "Cannot return null from a non-@Nullable @Provides method");
    }
}
