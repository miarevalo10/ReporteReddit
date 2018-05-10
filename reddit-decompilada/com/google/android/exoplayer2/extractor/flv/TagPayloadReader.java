package com.google.android.exoplayer2.extractor.flv;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.ParsableByteArray;

abstract class TagPayloadReader {
    protected final TrackOutput f4273b;

    public static final class UnsupportedFormatException extends ParserException {
        public UnsupportedFormatException(String str) {
            super(str);
        }
    }

    protected abstract void mo1348a(ParsableByteArray parsableByteArray, long j) throws ParserException;

    protected abstract boolean mo1349a(ParsableByteArray parsableByteArray) throws ParserException;

    protected TagPayloadReader(TrackOutput trackOutput) {
        this.f4273b = trackOutput;
    }

    public final void m3764b(ParsableByteArray parsableByteArray, long j) throws ParserException {
        if (mo1349a(parsableByteArray)) {
            mo1348a(parsableByteArray, j);
        }
    }
}
