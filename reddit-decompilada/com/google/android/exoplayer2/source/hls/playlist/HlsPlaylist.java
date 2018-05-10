package com.google.android.exoplayer2.source.hls.playlist;

import java.util.Collections;
import java.util.List;

public abstract class HlsPlaylist {
    public final String f4890o;
    public final List<String> f4891p;

    protected HlsPlaylist(String str, List<String> list) {
        this.f4890o = str;
        this.f4891p = Collections.unmodifiableList(list);
    }
}
