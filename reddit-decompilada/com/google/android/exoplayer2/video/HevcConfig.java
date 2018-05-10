package com.google.android.exoplayer2.video;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.Collections;
import java.util.List;

public final class HevcConfig {
    public final List<byte[]> f5316a;
    public final int f5317b;

    public static HevcConfig m4339a(ParsableByteArray parsableByteArray) throws ParserException {
        try {
            int i;
            int e;
            parsableByteArray.m4251d(21);
            int d = parsableByteArray.m4250d() & 3;
            int d2 = parsableByteArray.m4250d();
            int i2 = parsableByteArray.f5257b;
            int i3 = 0;
            int i4 = i3;
            while (i3 < d2) {
                parsableByteArray.m4251d(1);
                int e2 = parsableByteArray.m4252e();
                i = i4;
                for (i4 = 0; i4 < e2; i4++) {
                    e = parsableByteArray.m4252e();
                    i += 4 + e;
                    parsableByteArray.m4251d(e);
                }
                i3++;
                i4 = i;
            }
            parsableByteArray.m4249c(i2);
            Object obj = new byte[i4];
            i3 = 0;
            i = i3;
            while (i3 < d2) {
                parsableByteArray.m4251d(1);
                e = parsableByteArray.m4252e();
                int i5 = i;
                for (i = 0; i < e; i++) {
                    int e3 = parsableByteArray.m4252e();
                    System.arraycopy(NalUnitUtil.f5248a, 0, obj, i5, NalUnitUtil.f5248a.length);
                    i5 += NalUnitUtil.f5248a.length;
                    System.arraycopy(parsableByteArray.f5256a, parsableByteArray.f5257b, obj, i5, e3);
                    i5 += e3;
                    parsableByteArray.m4251d(e3);
                }
                i3++;
                i = i5;
            }
            if (i4 == 0) {
                parsableByteArray = null;
            } else {
                parsableByteArray = Collections.singletonList(obj);
            }
            return new HevcConfig(parsableByteArray, d + 1);
        } catch (ParsableByteArray parsableByteArray2) {
            throw new ParserException("Error parsing HEVC config", parsableByteArray2);
        }
    }

    private HevcConfig(List<byte[]> list, int i) {
        this.f5316a = list;
        this.f5317b = i;
    }
}
