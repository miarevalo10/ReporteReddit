package com.reddit.frontpage.di.module;

import com.reddit.common.rx.BackgroundThread;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class RxModule_BackgroundThreadFactory implements Factory<BackgroundThread> {
    private final RxModule f33655a;

    private RxModule_BackgroundThreadFactory(RxModule rxModule) {
        this.f33655a = rxModule;
    }

    public static RxModule_BackgroundThreadFactory m34527a(RxModule rxModule) {
        return new RxModule_BackgroundThreadFactory(rxModule);
    }

    public final /* synthetic */ Object get() {
        return (BackgroundThread) Preconditions.m26013a(RxModule.m22367b(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
