package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import java.io.IOException;

public interface SampleStream {
    int mo1397a(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean z);

    void mo1398a(long j);

    boolean mo1399a();

    void mo1400b() throws IOException;
}
