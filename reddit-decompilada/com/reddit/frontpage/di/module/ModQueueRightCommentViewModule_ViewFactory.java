package com.reddit.frontpage.di.module;

import com.reddit.frontpage.widgets.modtools.modview.rightcomment.ModQueueRightCommentContract.View;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class ModQueueRightCommentViewModule_ViewFactory implements Factory<View> {
    private final ModQueueRightCommentViewModule f33602a;

    private ModQueueRightCommentViewModule_ViewFactory(ModQueueRightCommentViewModule modQueueRightCommentViewModule) {
        this.f33602a = modQueueRightCommentViewModule;
    }

    public static ModQueueRightCommentViewModule_ViewFactory m34500a(ModQueueRightCommentViewModule modQueueRightCommentViewModule) {
        return new ModQueueRightCommentViewModule_ViewFactory(modQueueRightCommentViewModule);
    }

    public final /* synthetic */ Object get() {
        return (View) Preconditions.m26013a(this.f33602a.f20244a, "Cannot return null from a non-@Nullable @Provides method");
    }
}
