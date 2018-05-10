package com.reddit.frontpage.bus;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class BusModule_ProvidePlayerStateChangedBusFactory implements Factory<VideoPlayerStateChangedEventBus> {
    private static final BusModule_ProvidePlayerStateChangedBusFactory f33488a = new BusModule_ProvidePlayerStateChangedBusFactory();

    public static BusModule_ProvidePlayerStateChangedBusFactory m34365a() {
        return f33488a;
    }

    public final /* synthetic */ Object get() {
        return (VideoPlayerStateChangedEventBus) Preconditions.m26013a(BusModule.m21804c(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
