package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.MpegAudioHeader;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader.TrackIdGenerator;
import com.google.android.exoplayer2.util.ParsableByteArray;
import org.jcodec.codecs.mjpeg.JpegConst;

public final class MpegAudioReader implements ElementaryStreamReader {
    private final ParsableByteArray f13151a;
    private final MpegAudioHeader f13152b;
    private final String f13153c;
    private String f13154d;
    private TrackOutput f13155e;
    private int f13156f;
    private int f13157g;
    private boolean f13158h;
    private boolean f13159i;
    private long f13160j;
    private int f13161k;
    private long f13162l;

    public final void mo1380b() {
    }

    public MpegAudioReader() {
        this(null);
    }

    public MpegAudioReader(String str) {
        this.f13156f = 0;
        this.f13151a = new ParsableByteArray(4);
        this.f13151a.f5256a[0] = (byte) -1;
        this.f13152b = new MpegAudioHeader();
        this.f13153c = str;
    }

    public final void mo1376a() {
        this.f13156f = 0;
        this.f13157g = 0;
        this.f13159i = false;
    }

    public final void mo1378a(ExtractorOutput extractorOutput, TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.m3876a();
        this.f13154d = trackIdGenerator.m3878c();
        this.f13155e = extractorOutput.mo1415a(trackIdGenerator.m3877b(), 1);
    }

    public final void mo1377a(long j, boolean z) {
        this.f13162l = j;
    }

    public final void mo1379a(ParsableByteArray parsableByteArray) {
        MpegAudioReader mpegAudioReader = this;
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        while (parsableByteArray.m4246b() > 0) {
            int min;
            switch (mpegAudioReader.f13156f) {
                case 0:
                    byte[] bArr = parsableByteArray2.f5256a;
                    int i = parsableByteArray2.f5258c;
                    for (int i2 = parsableByteArray2.f5257b; i2 < i; i2++) {
                        boolean z = (bArr[i2] & 255) == 255;
                        boolean z2 = mpegAudioReader.f13159i && (bArr[i2] & JpegConst.APP0) == JpegConst.APP0;
                        mpegAudioReader.f13159i = z;
                        if (z2) {
                            parsableByteArray2.m4249c(i2 + 1);
                            mpegAudioReader.f13159i = false;
                            mpegAudioReader.f13151a.f5256a[1] = bArr[i2];
                            mpegAudioReader.f13157g = 2;
                            mpegAudioReader.f13156f = 1;
                            break;
                        }
                    }
                    parsableByteArray2.m4249c(i);
                    break;
                case 1:
                    min = Math.min(parsableByteArray.m4246b(), 4 - mpegAudioReader.f13157g);
                    parsableByteArray2.m4245a(mpegAudioReader.f13151a.f5256a, mpegAudioReader.f13157g, min);
                    mpegAudioReader.f13157g += min;
                    if (mpegAudioReader.f13157g < 4) {
                        break;
                    }
                    mpegAudioReader.f13151a.m4249c(0);
                    if (!MpegAudioHeader.m3755a(mpegAudioReader.f13151a.m4259j(), mpegAudioReader.f13152b)) {
                        mpegAudioReader.f13157g = 0;
                        mpegAudioReader.f13156f = 1;
                        break;
                    }
                    mpegAudioReader.f13161k = mpegAudioReader.f13152b.f4263c;
                    if (!mpegAudioReader.f13158h) {
                        mpegAudioReader.f13160j = (1000000 * ((long) mpegAudioReader.f13152b.f4267g)) / ((long) mpegAudioReader.f13152b.f4264d);
                        mpegAudioReader.f13155e.mo1345a(Format.m3558a(mpegAudioReader.f13154d, mpegAudioReader.f13152b.f4262b, -1, 4096, mpegAudioReader.f13152b.f4265e, mpegAudioReader.f13152b.f4264d, null, null, mpegAudioReader.f13153c));
                        mpegAudioReader.f13158h = true;
                    }
                    mpegAudioReader.f13151a.m4249c(0);
                    mpegAudioReader.f13155e.mo1346a(mpegAudioReader.f13151a, 4);
                    mpegAudioReader.f13156f = 2;
                    break;
                case 2:
                    min = Math.min(parsableByteArray.m4246b(), mpegAudioReader.f13161k - mpegAudioReader.f13157g);
                    mpegAudioReader.f13155e.mo1346a(parsableByteArray2, min);
                    mpegAudioReader.f13157g += min;
                    if (mpegAudioReader.f13157g < mpegAudioReader.f13161k) {
                        break;
                    }
                    mpegAudioReader.f13155e.mo1344a(mpegAudioReader.f13162l, 1, mpegAudioReader.f13161k, 0, null);
                    mpegAudioReader.f13162l += mpegAudioReader.f13160j;
                    mpegAudioReader.f13157g = 0;
                    mpegAudioReader.f13156f = 0;
                    break;
                default:
                    break;
            }
        }
    }
}
