package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.source.TrackGroupArray;

public abstract class TrackSelector {
    public InvalidationListener f5150b;

    public interface InvalidationListener {
    }

    public abstract TrackSelectorResult mo1464a(RendererCapabilities[] rendererCapabilitiesArr, TrackGroupArray trackGroupArray) throws ExoPlaybackException;

    public abstract void mo1465a(Object obj);
}
