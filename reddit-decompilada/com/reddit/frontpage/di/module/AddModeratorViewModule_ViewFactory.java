package com.reddit.frontpage.di.module;

import com.reddit.frontpage.presentation.modtools.modlist.add.AddModeratorContract.View;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class AddModeratorViewModule_ViewFactory implements Factory<View> {
    private final AddModeratorViewModule f33502a;

    private AddModeratorViewModule_ViewFactory(AddModeratorViewModule addModeratorViewModule) {
        this.f33502a = addModeratorViewModule;
    }

    public static AddModeratorViewModule_ViewFactory m34449a(AddModeratorViewModule addModeratorViewModule) {
        return new AddModeratorViewModule_ViewFactory(addModeratorViewModule);
    }

    public final /* synthetic */ Object get() {
        return (View) Preconditions.m26013a(this.f33502a.f20227a, "Cannot return null from a non-@Nullable @Provides method");
    }
}
