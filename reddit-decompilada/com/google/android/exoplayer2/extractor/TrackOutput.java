package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;
import java.util.Arrays;

public interface TrackOutput {

    public static final class CryptoData {
        public final int f4269a;
        public final byte[] f4270b;
        public final int f4271c;
        public final int f4272d;

        public CryptoData(int i, byte[] bArr, int i2, int i3) {
            this.f4269a = i;
            this.f4270b = bArr;
            this.f4271c = i2;
            this.f4272d = i3;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null) {
                if (getClass() == obj.getClass()) {
                    CryptoData cryptoData = (CryptoData) obj;
                    return this.f4269a == cryptoData.f4269a && this.f4271c == cryptoData.f4271c && this.f4272d == cryptoData.f4272d && Arrays.equals(this.f4270b, cryptoData.f4270b) != null;
                }
            }
            return false;
        }

        public final int hashCode() {
            return (31 * ((((this.f4269a * 31) + Arrays.hashCode(this.f4270b)) * 31) + this.f4271c)) + this.f4272d;
        }
    }

    int mo1343a(ExtractorInput extractorInput, int i, boolean z) throws IOException, InterruptedException;

    void mo1344a(long j, int i, int i2, int i3, CryptoData cryptoData);

    void mo1345a(Format format);

    void mo1346a(ParsableByteArray parsableByteArray, int i);
}
