package com.reddit.frontpage.di.module;

import com.reddit.frontpage.presentation.modtools.bottomsheet.modqueueoptions.ModQueueOptionsContract.View;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class ModQueueOptionsViewModule_ViewFactory implements Factory<View> {
    private final ModQueueOptionsViewModule f33601a;

    private ModQueueOptionsViewModule_ViewFactory(ModQueueOptionsViewModule modQueueOptionsViewModule) {
        this.f33601a = modQueueOptionsViewModule;
    }

    public static ModQueueOptionsViewModule_ViewFactory m34499a(ModQueueOptionsViewModule modQueueOptionsViewModule) {
        return new ModQueueOptionsViewModule_ViewFactory(modQueueOptionsViewModule);
    }

    public final /* synthetic */ Object get() {
        return (View) Preconditions.m26013a(this.f33601a.f20243a, "Cannot return null from a non-@Nullable @Provides method");
    }
}
