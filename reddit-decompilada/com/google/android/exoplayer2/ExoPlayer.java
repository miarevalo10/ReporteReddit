package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.MediaSource;

public interface ExoPlayer extends Player {

    public interface ExoPlayerComponent {
        void mo3312a(int i, Object obj) throws ExoPlaybackException;
    }

    public static final class ExoPlayerMessage {
        public final ExoPlayerComponent f3977a;
        public final int f3978b;
        public final Object f3979c;

        public ExoPlayerMessage(ExoPlayerComponent exoPlayerComponent, int i, Object obj) {
            this.f3977a = exoPlayerComponent;
            this.f3978b = i;
            this.f3979c = obj;
        }
    }

    @Deprecated
    public interface EventListener extends com.google.android.exoplayer2.Player.EventListener {
    }

    void mo3333a(MediaSource mediaSource, boolean z, boolean z2);

    void mo3335a(ExoPlayerMessage... exoPlayerMessageArr);

    void mo3338b(ExoPlayerMessage... exoPlayerMessageArr);
}
