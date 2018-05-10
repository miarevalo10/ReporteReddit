package com.google.android.exoplayer2.extractor.ogg;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import io.fabric.sdk.android.services.common.AbstractSpiCall;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class OpusReader extends StreamReader {
    private static final int f13025c = Util.m4326g("Opus");
    private static final byte[] f13026d = new byte[]{(byte) 79, (byte) 112, (byte) 117, (byte) 115, (byte) 72, (byte) 101, (byte) 97, (byte) 100};
    private boolean f13027e;

    OpusReader() {
    }

    public static boolean m12139a(ParsableByteArray parsableByteArray) {
        if (parsableByteArray.m4246b() < f13026d.length) {
            return false;
        }
        byte[] bArr = new byte[f13026d.length];
        parsableByteArray.m4245a(bArr, 0, f13026d.length);
        return Arrays.equals(bArr, f13026d);
    }

    protected final void mo1372a(boolean z) {
        super.mo1372a(z);
        if (z) {
            this.f13027e = false;
        }
    }

    protected final long mo1374b(ParsableByteArray parsableByteArray) {
        parsableByteArray = parsableByteArray.f5256a;
        int i = parsableByteArray[0] & 255;
        switch (i & 3) {
            case 0:
                parsableByteArray = 1;
                break;
            case 1:
            case 2:
                parsableByteArray = 2;
                break;
            default:
                parsableByteArray = parsableByteArray[1] & 63;
                break;
        }
        i >>= 3;
        int i2 = i & 3;
        i = i >= 16 ? 2500 << i2 : i >= 12 ? AbstractSpiCall.DEFAULT_TIMEOUT << (i2 & 1) : i2 == 3 ? 60000 : AbstractSpiCall.DEFAULT_TIMEOUT << i2;
        return m3838b((long) (parsableByteArray * i));
    }

    protected final boolean mo1373a(ParsableByteArray parsableByteArray, long j, SetupData setupData) throws IOException, InterruptedException {
        boolean z = true;
        if (this.f13027e == null) {
            parsableByteArray = Arrays.copyOf(parsableByteArray.f5256a, parsableByteArray.f5258c);
            int i = parsableByteArray[9] & 255;
            j = ((parsableByteArray[11] & 255) << 8) | (parsableByteArray[10] & 255);
            List arrayList = new ArrayList(3);
            arrayList.add(parsableByteArray);
            m12138a(arrayList, j);
            m12138a(arrayList, 3840);
            setupData.f4511a = Format.m3558a(null, "audio/opus", -1, -1, i, 48000, arrayList, null, null);
            this.f13027e = true;
            return true;
        }
        if (parsableByteArray.m4259j() != f13025c) {
            z = false;
        }
        parsableByteArray.m4249c(0);
        return z;
    }

    private static void m12138a(List<byte[]> list, int i) {
        list.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong((((long) i) * 1000000000) / 48000).array());
    }
}
