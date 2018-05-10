package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader.TrackIdGenerator;
import com.google.android.exoplayer2.util.ParsableByteArray;

public interface ElementaryStreamReader {
    void mo1376a();

    void mo1377a(long j, boolean z);

    void mo1378a(ExtractorOutput extractorOutput, TrackIdGenerator trackIdGenerator);

    void mo1379a(ParsableByteArray parsableByteArray);

    void mo1380b();
}
