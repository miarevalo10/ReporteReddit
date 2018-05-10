package com.google.android.exoplayer2.source.hls;

import com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist;

public final class HlsManifest {
    public final HlsMasterPlaylist f4875a;
    public final HlsMediaPlaylist f4876b;

    HlsManifest(HlsMasterPlaylist hlsMasterPlaylist, HlsMediaPlaylist hlsMediaPlaylist) {
        this.f4875a = hlsMasterPlaylist;
        this.f4876b = hlsMediaPlaylist;
    }
}
