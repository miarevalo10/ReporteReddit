package com.reddit.frontpage.bus;

import com.reddit.frontpage.widgets.video.ClippingBoundsBus;
import javax.inject.Singleton;

@Singleton
public interface BusComponent {
    KeyEventBus mo4568a();

    ClippingBoundsBus mo4569b();

    VideoPlayerStateChangedEventBus mo4570c();
}
