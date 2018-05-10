package com.google.android.exoplayer2.text;

import com.google.android.exoplayer2.decoder.DecoderInputBuffer;

public final class SubtitleInputBuffer extends DecoderInputBuffer implements Comparable<SubtitleInputBuffer> {
    public long f17031f;

    public final /* synthetic */ int compareTo(Object obj) {
        SubtitleInputBuffer subtitleInputBuffer = (SubtitleInputBuffer) obj;
        if (m3715c() != subtitleInputBuffer.m3715c()) {
            return m3715c() != null ? 1 : -1;
        } else {
            obj = ((this.d - subtitleInputBuffer.d) > 0 ? 1 : ((this.d - subtitleInputBuffer.d) == 0 ? 0 : -1));
            if (obj == null) {
                return null;
            }
            return obj > null ? 1 : -1;
        }
    }

    public SubtitleInputBuffer() {
        super(1);
    }
}
