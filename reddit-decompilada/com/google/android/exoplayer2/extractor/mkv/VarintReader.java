package com.google.android.exoplayer2.extractor.mkv;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import java.io.IOException;

final class VarintReader {
    private static final long[] f4320b = new long[]{128, 64, 32, 16, 8, 4, 2, 1};
    int f4321a;
    private final byte[] f4322c = new byte[8];
    private int f4323d;

    public static long m3784a(byte[] r1, int r2, boolean r3) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.google.android.exoplayer2.extractor.mkv.VarintReader.a(byte[], int, boolean):long
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:116)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:249)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
Caused by: jadx.core.utils.exceptions.DecodeException: Unknown instruction: not-long
	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:568)
	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:56)
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:102)
	... 5 more
*/
        /*
        // Can't load method instructions.
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.mkv.VarintReader.a(byte[], int, boolean):long");
    }

    public final void m3786a() {
        this.f4323d = 0;
        this.f4321a = 0;
    }

    public final long m3785a(ExtractorInput extractorInput, boolean z, boolean z2, int i) throws IOException, InterruptedException {
        if (this.f4323d == 0) {
            if (!extractorInput.mo1333a(this.f4322c, 0, 1, z)) {
                return -1;
            }
            this.f4321a = m3783a(this.f4322c[0] & 255);
            if (this.f4321a) {
                throw new IllegalStateException("No valid varint length mask found");
            }
            this.f4323d = 1;
        }
        if (this.f4321a > i) {
            this.f4323d = 0;
            return -2;
        }
        if (!this.f4321a) {
            extractorInput.mo1336b(this.f4322c, 1, this.f4321a - 1);
        }
        this.f4323d = 0;
        return m3784a(this.f4322c, this.f4321a, z2);
    }

    public static int m3783a(int i) {
        for (int i2 = 0; i2 < f4320b.length; i2++) {
            if ((f4320b[i2] & ((long) i)) != 0) {
                return i2 + 1;
            }
        }
        return -1;
    }
}
