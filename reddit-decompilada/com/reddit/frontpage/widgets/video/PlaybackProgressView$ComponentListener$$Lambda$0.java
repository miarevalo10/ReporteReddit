package com.reddit.frontpage.widgets.video;

import io.reactivex.functions.Consumer;

final /* synthetic */ class PlaybackProgressView$ComponentListener$$Lambda$0 implements Consumer {
    private final ComponentListener f29555a;

    PlaybackProgressView$ComponentListener$$Lambda$0(ComponentListener componentListener) {
        this.f29555a = componentListener;
    }

    public final void accept(Object obj) {
        ComponentListener componentListener = this.f29555a;
        Long l = (Long) obj;
        if (componentListener.f34567a.f22163s != null && componentListener.f34567a.f22136A) {
            componentListener.f34567a.f22163s.f22221c.a(l.longValue());
        }
    }
}
