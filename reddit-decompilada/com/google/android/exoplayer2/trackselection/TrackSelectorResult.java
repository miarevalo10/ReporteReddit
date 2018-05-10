package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.RendererConfiguration;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.util.Util;

public final class TrackSelectorResult {
    public final TrackGroupArray f5151a;
    public final TrackSelectionArray f5152b;
    public final Object f5153c;
    public final RendererConfiguration[] f5154d;

    public TrackSelectorResult(TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray, Object obj, RendererConfiguration[] rendererConfigurationArr) {
        this.f5151a = trackGroupArray;
        this.f5152b = trackSelectionArray;
        this.f5153c = obj;
        this.f5154d = rendererConfigurationArr;
    }

    public final boolean m4136a(TrackSelectorResult trackSelectorResult, int i) {
        if (trackSelectorResult == null || !Util.m4313a(this.f5152b.f5148b[i], trackSelectorResult.f5152b.f5148b[i]) || Util.m4313a(this.f5154d[i], trackSelectorResult.f5154d[i]) == null) {
            return false;
        }
        return true;
    }
}
