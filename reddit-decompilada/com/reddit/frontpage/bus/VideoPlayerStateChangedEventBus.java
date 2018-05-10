package com.reddit.frontpage.bus;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

public class VideoPlayerStateChangedEventBus {
    private final Subject<PlayerState> bus = PublishSubject.create();

    public static final class PlayerState {
        public final boolean playing;
        public final String url;

        public PlayerState(String str, boolean z) {
            this.url = str;
            this.playing = z;
        }
    }

    VideoPlayerStateChangedEventBus() {
    }

    public Observable<PlayerState> getBus() {
        return this.bus;
    }

    public void post(PlayerState playerState) {
        this.bus.onNext(playerState);
    }
}
