package com.google.android.exoplayer2.video;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.CodecSpecificDataUtil;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.ArrayList;
import java.util.List;

public final class AvcConfig {
    public final List<byte[]> f5292a;
    public final int f5293b;
    public final int f5294c;
    public final int f5295d;
    public final float f5296e;

    public static AvcConfig m4334a(ParsableByteArray parsableByteArray) throws ParserException {
        try {
            parsableByteArray.m4251d(4);
            int d = (parsableByteArray.m4250d() & 3) + 1;
            if (d == 3) {
                throw new IllegalStateException();
            }
            int i;
            int i2;
            float f;
            int i3;
            List arrayList = new ArrayList();
            int d2 = parsableByteArray.m4250d() & 31;
            for (i = 0; i < d2; i++) {
                arrayList.add(m4335b(parsableByteArray));
            }
            i = parsableByteArray.m4250d();
            for (i2 = 0; i2 < i; i2++) {
                arrayList.add(m4335b(parsableByteArray));
            }
            if (d2 > 0) {
                parsableByteArray = NalUnitUtil.m4223a((byte[]) arrayList.get(0), d, ((byte[]) arrayList.get(0)).length);
                d2 = parsableByteArray.f5239b;
                int i4 = parsableByteArray.f5240c;
                f = parsableByteArray.f5241d;
                i2 = d2;
                i3 = i4;
            } else {
                f = 1.0f;
                i2 = -1;
                i3 = i2;
            }
            return new AvcConfig(arrayList, d, i2, i3, f);
        } catch (ParsableByteArray parsableByteArray2) {
            throw new ParserException("Error parsing AVC config", parsableByteArray2);
        }
    }

    private AvcConfig(List<byte[]> list, int i, int i2, int i3, float f) {
        this.f5292a = list;
        this.f5293b = i;
        this.f5294c = i2;
        this.f5295d = i3;
        this.f5296e = f;
    }

    private static byte[] m4335b(ParsableByteArray parsableByteArray) {
        int e = parsableByteArray.m4252e();
        int i = parsableByteArray.f5257b;
        parsableByteArray.m4251d(e);
        return CodecSpecificDataUtil.m4195a(parsableByteArray.f5256a, i, e);
    }
}
