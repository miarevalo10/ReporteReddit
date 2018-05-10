package com.reddit.frontpage.bus;

import com.reddit.frontpage.widgets.video.ClippingBoundsBus;
import javax.inject.Singleton;

class BusModule {
    @Singleton
    static KeyEventBus m21802a() {
        return new KeyEventBus();
    }

    @Singleton
    static ClippingBoundsBus m21803b() {
        return new ClippingBoundsBus();
    }

    @Singleton
    static VideoPlayerStateChangedEventBus m21804c() {
        return new VideoPlayerStateChangedEventBus();
    }
}
