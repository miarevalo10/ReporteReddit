package com.google.android.exoplayer2.extractor.flv;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.flv.TagPayloadReader.UnsupportedFormatException;
import com.google.android.exoplayer2.util.CodecSpecificDataUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import io.fabric.sdk.android.services.events.EventsFilesManager;
import java.util.Collections;

final class AudioTagPayloadReader extends TagPayloadReader {
    private static final int[] f12840a = new int[]{5512, 11025, 22050, 44100};
    private boolean f12841c;
    private boolean f12842d;
    private int f12843e;

    public AudioTagPayloadReader(TrackOutput trackOutput) {
        super(trackOutput);
    }

    protected final boolean mo1349a(ParsableByteArray parsableByteArray) throws UnsupportedFormatException {
        if (this.f12841c) {
            parsableByteArray.m4251d(1);
        } else {
            int d = parsableByteArray.m4250d();
            r0.f12843e = (d >> 4) & 15;
            if (r0.f12843e == 2) {
                r0.b.mo1345a(Format.m3558a(null, "audio/mpeg", -1, -1, 1, f12840a[(d >> 2) & 3], null, null, null));
                r0.f12842d = true;
            } else {
                if (r0.f12843e != 7) {
                    if (r0.f12843e != 8) {
                        if (r0.f12843e != 10) {
                            StringBuilder stringBuilder = new StringBuilder("Audio format not supported: ");
                            stringBuilder.append(r0.f12843e);
                            throw new UnsupportedFormatException(stringBuilder.toString());
                        }
                    }
                }
                r0.b.mo1345a(Format.m3557a(null, r0.f12843e == 7 ? "audio/g711-alaw" : "audio/g711-mlaw", -1, -1, 1, EventsFilesManager.MAX_BYTE_SIZE_PER_FILE, (d & 1) == 1 ? 2 : 3, null, null, 0, null));
                r0.f12842d = true;
            }
            r0.f12841c = true;
        }
        return true;
    }

    protected final void mo1348a(ParsableByteArray parsableByteArray, long j) {
        if (this.f12843e == 2) {
            int b = parsableByteArray.m4246b();
            this.b.mo1346a(parsableByteArray, b);
            this.b.mo1344a(j, 1, b, 0, null);
            return;
        }
        int d = parsableByteArray.m4250d();
        if (d != 0 || this.f12842d) {
            if (this.f12843e != 10 || d == 1) {
                int b2 = parsableByteArray.m4246b();
                this.b.mo1346a(parsableByteArray, b2);
                this.b.mo1344a(j, 1, b2, 0, null);
            }
            return;
        }
        byte[] bArr = new byte[parsableByteArray.m4246b()];
        parsableByteArray.m4245a(bArr, 0, bArr.length);
        parsableByteArray = CodecSpecificDataUtil.m4192a(bArr);
        this.b.mo1345a(Format.m3558a(null, "audio/mp4a-latm", -1, -1, ((Integer) parsableByteArray.second).intValue(), ((Integer) parsableByteArray.first).intValue(), Collections.singletonList(bArr), null, null));
        this.f12842d = true;
    }
}
