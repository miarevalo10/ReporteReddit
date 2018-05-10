package com.reddit.frontpage.di.module;

import com.reddit.frontpage.presentation.flair.LinkFlairSelectContract.View;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class LinkFlairSelectViewModule_ViewFactory implements Factory<View> {
    private final LinkFlairSelectViewModule f33596a;

    private LinkFlairSelectViewModule_ViewFactory(LinkFlairSelectViewModule linkFlairSelectViewModule) {
        this.f33596a = linkFlairSelectViewModule;
    }

    public static LinkFlairSelectViewModule_ViewFactory m34496a(LinkFlairSelectViewModule linkFlairSelectViewModule) {
        return new LinkFlairSelectViewModule_ViewFactory(linkFlairSelectViewModule);
    }

    public final /* synthetic */ Object get() {
        return (View) Preconditions.m26013a(this.f33596a.f20241a, "Cannot return null from a non-@Nullable @Provides method");
    }
}
