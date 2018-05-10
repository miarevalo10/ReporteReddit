package com.reddit.frontpage.bus;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class BusModule_ProvideKeyEventBusFactory implements Factory<KeyEventBus> {
    private static final BusModule_ProvideKeyEventBusFactory f33487a = new BusModule_ProvideKeyEventBusFactory();

    public static BusModule_ProvideKeyEventBusFactory m34364a() {
        return f33487a;
    }

    public final /* synthetic */ Object get() {
        return (KeyEventBus) Preconditions.m26013a(BusModule.m21802a(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
