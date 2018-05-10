package com.google.android.exoplayer2.extractor.ogg;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.SeekMap;
import java.io.IOException;

interface OggSeeker {
    long mo1369a(long j);

    long mo1370a(ExtractorInput extractorInput) throws IOException, InterruptedException;

    SeekMap mo1371a();
}
