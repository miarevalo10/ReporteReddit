package com.google.android.exoplayer2.extractor.mkv;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import java.io.IOException;

interface EbmlReaderOutput {
    int mo1357a(int i);

    void mo1358a(int i, double d) throws ParserException;

    void mo1359a(int i, int i2, ExtractorInput extractorInput) throws IOException, InterruptedException;

    void mo1360a(int i, long j) throws ParserException;

    void mo1361a(int i, long j, long j2) throws ParserException;

    void mo1362a(int i, String str) throws ParserException;

    boolean mo1363b(int i);

    void mo1364c(int i) throws ParserException;
}
