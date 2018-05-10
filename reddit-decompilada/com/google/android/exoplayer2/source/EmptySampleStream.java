package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import java.io.IOException;

public final class EmptySampleStream implements SampleStream {
    public final void mo1398a(long j) {
    }

    public final boolean mo1399a() {
        return true;
    }

    public final void mo1400b() throws IOException {
    }

    public final int mo1397a(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean z) {
        decoderInputBuffer.f4220a = 4;
        return -4;
    }
}
