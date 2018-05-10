package com.reddit.frontpage.bus;

import com.reddit.frontpage.widgets.video.ClippingBoundsBus;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class BusModule_ProvideClippingBoundsBusFactory implements Factory<ClippingBoundsBus> {
    private static final BusModule_ProvideClippingBoundsBusFactory f33486a = new BusModule_ProvideClippingBoundsBusFactory();

    public static BusModule_ProvideClippingBoundsBusFactory m34363a() {
        return f33486a;
    }

    public final /* synthetic */ Object get() {
        return (ClippingBoundsBus) Preconditions.m26013a(BusModule.m21803b(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
