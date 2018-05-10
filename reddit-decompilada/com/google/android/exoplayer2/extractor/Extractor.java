package com.google.android.exoplayer2.extractor;

import java.io.IOException;

public interface Extractor {
    int mo1350a(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException, InterruptedException;

    void mo1351a(long j, long j2);

    void mo1352a(ExtractorOutput extractorOutput);

    boolean mo1353a(ExtractorInput extractorInput) throws IOException, InterruptedException;
}
