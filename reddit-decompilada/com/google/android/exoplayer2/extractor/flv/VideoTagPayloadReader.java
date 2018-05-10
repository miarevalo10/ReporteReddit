package com.google.android.exoplayer2.extractor.flv;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.flv.TagPayloadReader.UnsupportedFormatException;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.video.AvcConfig;

final class VideoTagPayloadReader extends TagPayloadReader {
    private final ParsableByteArray f12860a = new ParsableByteArray(NalUnitUtil.f5248a);
    private final ParsableByteArray f12861c = new ParsableByteArray(4);
    private int f12862d;
    private boolean f12863e;
    private int f12864f;

    public VideoTagPayloadReader(TrackOutput trackOutput) {
        super(trackOutput);
    }

    protected final boolean mo1349a(ParsableByteArray parsableByteArray) throws UnsupportedFormatException {
        parsableByteArray = parsableByteArray.m4250d();
        int i = (parsableByteArray >> 4) & 15;
        parsableByteArray &= 15;
        if (parsableByteArray != 7) {
            StringBuilder stringBuilder = new StringBuilder("Video format not supported: ");
            stringBuilder.append(parsableByteArray);
            throw new UnsupportedFormatException(stringBuilder.toString());
        }
        this.f12864f = i;
        return i != 5 ? true : null;
    }

    protected final void mo1348a(ParsableByteArray parsableByteArray, long j) throws ParserException {
        int d = parsableByteArray.m4250d();
        long g = j + (((long) parsableByteArray.m4256g()) * 1000);
        if (d != 0 || this.f12863e) {
            if (d == 1 && this.f12863e) {
                byte[] bArr = this.f12861c.f5256a;
                bArr[0] = (byte) 0;
                bArr[1] = (byte) 0;
                bArr[2] = (byte) 0;
                d = 4 - this.f12862d;
                int i = 0;
                while (parsableByteArray.m4246b() > 0) {
                    parsableByteArray.m4245a(this.f12861c.f5256a, d, this.f12862d);
                    this.f12861c.m4249c(0);
                    int n = this.f12861c.m4263n();
                    this.f12860a.m4249c(0);
                    this.b.mo1346a(this.f12860a, 4);
                    i += 4;
                    this.b.mo1346a(parsableByteArray, n);
                    i += n;
                }
                this.b.mo1344a(g, this.f12864f == 1 ? 1 : 0, i, 0, null);
            }
            return;
        }
        ParsableByteArray parsableByteArray2 = new ParsableByteArray(new byte[parsableByteArray.m4246b()]);
        parsableByteArray.m4245a(parsableByteArray2.f5256a, 0, parsableByteArray.m4246b());
        parsableByteArray = AvcConfig.m4334a(parsableByteArray2);
        this.f12862d = parsableByteArray.f5293b;
        this.b.mo1345a(Format.m3560a(null, "video/avc", parsableByteArray.f5294c, parsableByteArray.f5295d, parsableByteArray.f5292a, parsableByteArray.f5296e));
        this.f12863e = true;
    }
}
