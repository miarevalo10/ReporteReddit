package com.reddit.frontpage.di.module;

import com.reddit.frontpage.presentation.modtools.actions.ModToolsActionsContract.View;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class ModToolsActionsViewModule_ViewFactory implements Factory<View> {
    private final ModToolsActionsViewModule f33603a;

    private ModToolsActionsViewModule_ViewFactory(ModToolsActionsViewModule modToolsActionsViewModule) {
        this.f33603a = modToolsActionsViewModule;
    }

    public static ModToolsActionsViewModule_ViewFactory m34501a(ModToolsActionsViewModule modToolsActionsViewModule) {
        return new ModToolsActionsViewModule_ViewFactory(modToolsActionsViewModule);
    }

    public final /* synthetic */ Object get() {
        return (View) Preconditions.m26013a(this.f33603a.f20245a, "Cannot return null from a non-@Nullable @Provides method");
    }
}
