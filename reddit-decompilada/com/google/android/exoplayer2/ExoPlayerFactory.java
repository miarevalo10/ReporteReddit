package com.google.android.exoplayer2;

import android.content.Context;
import com.google.android.exoplayer2.trackselection.TrackSelector;

public final class ExoPlayerFactory {
    @Deprecated
    public static SimpleExoPlayer m3545a(Context context, TrackSelector trackSelector, LoadControl loadControl) {
        return new SimpleExoPlayer(new DefaultRenderersFactory(context), trackSelector, loadControl);
    }
}
