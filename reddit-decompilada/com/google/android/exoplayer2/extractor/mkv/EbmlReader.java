package com.google.android.exoplayer2.extractor.mkv;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import java.io.IOException;

interface EbmlReader {
    void mo1354a();

    void mo1355a(EbmlReaderOutput ebmlReaderOutput);

    boolean mo1356a(ExtractorInput extractorInput) throws IOException, InterruptedException;
}
