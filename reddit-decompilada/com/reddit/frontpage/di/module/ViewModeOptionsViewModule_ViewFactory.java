package com.reddit.frontpage.di.module;

import com.reddit.frontpage.presentation.viewmode.ViewModeOptionsContract.View;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class ViewModeOptionsViewModule_ViewFactory implements Factory<View> {
    private final ViewModeOptionsViewModule f33709a;

    private ViewModeOptionsViewModule_ViewFactory(ViewModeOptionsViewModule viewModeOptionsViewModule) {
        this.f33709a = viewModeOptionsViewModule;
    }

    public static ViewModeOptionsViewModule_ViewFactory m34551a(ViewModeOptionsViewModule viewModeOptionsViewModule) {
        return new ViewModeOptionsViewModule_ViewFactory(viewModeOptionsViewModule);
    }

    public final /* synthetic */ Object get() {
        return (View) Preconditions.m26013a(this.f33709a.f20258a, "Cannot return null from a non-@Nullable @Provides method");
    }
}
