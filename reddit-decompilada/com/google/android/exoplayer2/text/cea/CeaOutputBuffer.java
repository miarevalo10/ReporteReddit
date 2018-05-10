package com.google.android.exoplayer2.text.cea;

import com.google.android.exoplayer2.text.SubtitleOutputBuffer;

public final class CeaOutputBuffer extends SubtitleOutputBuffer {
    private final CeaDecoder f19033d;

    public CeaOutputBuffer(CeaDecoder ceaDecoder) {
        this.f19033d = ceaDecoder;
    }

    public final void mo3924e() {
        CeaDecoder ceaDecoder = this.f19033d;
        mo1321a();
        ceaDecoder.f17034a.add(this);
    }
}
