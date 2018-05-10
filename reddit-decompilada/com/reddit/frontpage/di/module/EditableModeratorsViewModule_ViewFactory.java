package com.reddit.frontpage.di.module;

import com.reddit.frontpage.presentation.modtools.base.BaseModeratorsContract.View;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class EditableModeratorsViewModule_ViewFactory implements Factory<View> {
    private final EditableModeratorsViewModule f33551a;

    private EditableModeratorsViewModule_ViewFactory(EditableModeratorsViewModule editableModeratorsViewModule) {
        this.f33551a = editableModeratorsViewModule;
    }

    public static EditableModeratorsViewModule_ViewFactory m34476a(EditableModeratorsViewModule editableModeratorsViewModule) {
        return new EditableModeratorsViewModule_ViewFactory(editableModeratorsViewModule);
    }

    public final /* synthetic */ Object get() {
        return (View) Preconditions.m26013a(this.f33551a.f20234a, "Cannot return null from a non-@Nullable @Provides method");
    }
}
