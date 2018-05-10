package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.TrackOutput.CryptoData;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.EOFException;
import java.io.IOException;

public final class DummyTrackOutput implements TrackOutput {
    public final void mo1344a(long j, int i, int i2, int i3, CryptoData cryptoData) {
    }

    public final void mo1345a(Format format) {
    }

    public final int mo1343a(ExtractorInput extractorInput, int i, boolean z) throws IOException, InterruptedException {
        extractorInput = extractorInput.mo1330a(i);
        if (extractorInput != -1) {
            return extractorInput;
        }
        if (z) {
            return -1;
        }
        throw new EOFException();
    }

    public final void mo1346a(ParsableByteArray parsableByteArray, int i) {
        parsableByteArray.m4251d(i);
    }
}
