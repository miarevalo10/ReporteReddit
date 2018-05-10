package com.reddit.frontpage.bus;

import com.reddit.frontpage.widgets.video.ClippingBoundsBus;
import dagger.internal.DoubleCheck;
import javax.inject.Provider;

public final class DaggerBusComponent implements BusComponent {
    private Provider<KeyEventBus> f27427a;
    private Provider<ClippingBoundsBus> f27428b;
    private Provider<VideoPlayerStateChangedEventBus> f27429c;

    public static final class Builder {
        private Builder() {
        }
    }

    private DaggerBusComponent() {
        this.f27427a = DoubleCheck.m31842a(BusModule_ProvideKeyEventBusFactory.m34364a());
        this.f27428b = DoubleCheck.m31842a(BusModule_ProvideClippingBoundsBusFactory.m34363a());
        this.f27429c = DoubleCheck.m31842a(BusModule_ProvidePlayerStateChangedBusFactory.m34365a());
    }

    public static Builder m28894d() {
        return new Builder();
    }

    public final KeyEventBus mo4568a() {
        return (KeyEventBus) this.f27427a.get();
    }

    public final ClippingBoundsBus mo4569b() {
        return (ClippingBoundsBus) this.f27428b.get();
    }

    public final VideoPlayerStateChangedEventBus mo4570c() {
        return (VideoPlayerStateChangedEventBus) this.f27429c.get();
    }
}
