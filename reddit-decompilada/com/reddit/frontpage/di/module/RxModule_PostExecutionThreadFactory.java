package com.reddit.frontpage.di.module;

import com.reddit.common.rx.PostExecutionThread;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class RxModule_PostExecutionThreadFactory implements Factory<PostExecutionThread> {
    private final RxModule f33656a;

    private RxModule_PostExecutionThreadFactory(RxModule rxModule) {
        this.f33656a = rxModule;
    }

    public static RxModule_PostExecutionThreadFactory m34528a(RxModule rxModule) {
        return new RxModule_PostExecutionThreadFactory(rxModule);
    }

    public final /* synthetic */ Object get() {
        return (PostExecutionThread) Preconditions.m26013a(RxModule.m22366a(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
