package com.google.android.exoplayer2.extractor.wav;

import android.util.Log;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;

final class WavHeaderReader {

    private static final class ChunkHeader {
        public final int f4644a;
        public final long f4645b;

        private ChunkHeader(int i, long j) {
            this.f4644a = i;
            this.f4645b = j;
        }

        public static ChunkHeader m3882a(ExtractorInput extractorInput, ParsableByteArray parsableByteArray) throws IOException, InterruptedException {
            extractorInput.mo1340c(parsableByteArray.f5256a, 0, 8);
            parsableByteArray.m4249c(0);
            return new ChunkHeader(parsableByteArray.m4259j(), parsableByteArray.m4258i());
        }
    }

    public static WavHeader m3883a(ExtractorInput extractorInput) throws IOException, InterruptedException {
        Assertions.m4182a((Object) extractorInput);
        ParsableByteArray parsableByteArray = new ParsableByteArray(16);
        if (ChunkHeader.m3882a(extractorInput, parsableByteArray).f4644a != Util.m4326g("RIFF")) {
            return null;
        }
        extractorInput.mo1340c(parsableByteArray.f5256a, 0, 4);
        parsableByteArray.m4249c(0);
        int j = parsableByteArray.m4259j();
        if (j != Util.m4326g("WAVE")) {
            StringBuilder stringBuilder = new StringBuilder("Unsupported RIFF format: ");
            stringBuilder.append(j);
            Log.e("WavHeaderReader", stringBuilder.toString());
            return null;
        }
        ChunkHeader a;
        while (true) {
            a = ChunkHeader.m3882a(extractorInput, parsableByteArray);
            if (a.f4644a == Util.m4326g("fmt ")) {
                break;
            }
            extractorInput.mo1339c((int) a.f4645b);
        }
        Assertions.m4186b(a.f4645b >= 16);
        extractorInput.mo1340c(parsableByteArray.f5256a, 0, 16);
        parsableByteArray.m4249c(0);
        int f = parsableByteArray.m4254f();
        int f2 = parsableByteArray.m4254f();
        int o = parsableByteArray.m4264o();
        int o2 = parsableByteArray.m4264o();
        int f3 = parsableByteArray.m4254f();
        int f4 = parsableByteArray.m4254f();
        int i = (f2 * f4) / 8;
        if (f3 != i) {
            StringBuilder stringBuilder2 = new StringBuilder("Expected block alignment: ");
            stringBuilder2.append(i);
            stringBuilder2.append("; got: ");
            stringBuilder2.append(f3);
            throw new ParserException(stringBuilder2.toString());
        }
        int b = Util.m4316b(f4);
        if (b == 0) {
            stringBuilder = new StringBuilder("Unsupported WAV bit depth: ");
            stringBuilder.append(f4);
            Log.e("WavHeaderReader", stringBuilder.toString());
            return null;
        } else if (f == 1 || f == 65534) {
            extractorInput.mo1339c(((int) a.f4645b) - 16);
            return new WavHeader(f2, o, o2, f3, f4, b);
        } else {
            stringBuilder = new StringBuilder("Unsupported WAV format type: ");
            stringBuilder.append(f);
            Log.e("WavHeaderReader", stringBuilder.toString());
            return null;
        }
    }

    public static void m3884a(ExtractorInput extractorInput, WavHeader wavHeader) throws IOException, InterruptedException {
        Assertions.m4182a((Object) extractorInput);
        Assertions.m4182a((Object) wavHeader);
        extractorInput.mo1332a();
        ParsableByteArray parsableByteArray = new ParsableByteArray(8);
        ChunkHeader a = ChunkHeader.m3882a(extractorInput, parsableByteArray);
        while (a.f4644a != Util.m4326g("data")) {
            StringBuilder stringBuilder = new StringBuilder("Ignoring unknown WAV chunk: ");
            stringBuilder.append(a.f4644a);
            Log.w("WavHeaderReader", stringBuilder.toString());
            long j = 8 + a.f4645b;
            if (a.f4644a == Util.m4326g("RIFF")) {
                j = 12;
            }
            if (j > 2147483647L) {
                wavHeader = new StringBuilder("Chunk is too large (~2GB+) to skip; id: ");
                wavHeader.append(a.f4644a);
                throw new ParserException(wavHeader.toString());
            }
            extractorInput.mo1335b((int) j);
            a = ChunkHeader.m3882a(extractorInput, parsableByteArray);
        }
        extractorInput.mo1335b(8);
        long c = extractorInput.mo1338c();
        long j2 = a.f4645b;
        wavHeader.f4642g = c;
        wavHeader.f4643h = j2;
    }
}
