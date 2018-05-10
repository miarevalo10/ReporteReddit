package com.google.android.exoplayer2;

import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.upstream.Allocator;

public interface LoadControl {
    void mo1276a();

    void mo1277a(Renderer[] rendererArr, TrackSelectionArray trackSelectionArray);

    boolean mo1278a(long j);

    boolean mo1279a(long j, boolean z);

    void mo1280b();

    void mo1281c();

    Allocator mo1282d();
}
