package com.google.android.exoplayer2.extractor.ogg;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;
import java.util.Arrays;

final class OggPacket {
    final OggPageHeader f4494a = new OggPageHeader();
    final ParsableByteArray f4495b = new ParsableByteArray(new byte[65025], 0);
    int f4496c = -1;
    boolean f4497d;
    private int f4498e;

    OggPacket() {
    }

    public final boolean m3825a(ExtractorInput extractorInput) throws IOException, InterruptedException {
        Assertions.m4186b(extractorInput != null);
        if (this.f4497d) {
            this.f4497d = false;
            this.f4495b.m4241a();
        }
        while (!this.f4497d) {
            int i;
            int i2;
            if (this.f4496c < 0) {
                if (!this.f4494a.m3827a(extractorInput, true)) {
                    return false;
                }
                i = this.f4494a.f4507h;
                if ((this.f4494a.f4501b & 1) == 1 && this.f4495b.f5258c == 0) {
                    i += m3824a(0);
                    i2 = this.f4498e + 0;
                } else {
                    i2 = 0;
                }
                extractorInput.mo1335b(i);
                this.f4496c = i2;
            }
            i = m3824a(this.f4496c);
            i2 = this.f4496c + this.f4498e;
            if (i > 0) {
                if (this.f4495b.m4248c() < this.f4495b.f5258c + i) {
                    this.f4495b.f5256a = Arrays.copyOf(this.f4495b.f5256a, this.f4495b.f5258c + i);
                }
                extractorInput.mo1336b(this.f4495b.f5256a, this.f4495b.f5258c, i);
                this.f4495b.m4247b(this.f4495b.f5258c + i);
                this.f4497d = this.f4494a.f4509j[i2 + -1] != 255;
            }
            if (i2 == this.f4494a.f4506g) {
                i2 = -1;
            }
            this.f4496c = i2;
        }
        return true;
    }

    private int m3824a(int i) {
        int i2 = 0;
        this.f4498e = 0;
        while (this.f4498e + i < this.f4494a.f4506g) {
            int[] iArr = this.f4494a.f4509j;
            int i3 = this.f4498e;
            this.f4498e = i3 + 1;
            int i4 = iArr[i3 + i];
            i2 += i4;
            if (i4 != 255) {
                break;
            }
        }
        return i2;
    }
}
