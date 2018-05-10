package org.jcodec.containers.mkv.boxes;

import java.nio.ByteBuffer;
import org.jcodec.containers.mkv.util.EbmlUtil;

public class EbmlSint extends EbmlBin {
    public static final long[] signedComplement = new long[]{0, 63, 8191, 1048575, 134217727, 17179869183L, 2199023255551L, 281474976710655L, 36028797018963967L};

    public static int ebmlSignedLength(long j) {
        return (j > 64 || j < -63) ? (j > 8192 || j < -8191) ? (j > 1048576 || j < -1048575) ? (j > 134217728 || j < -134217727) ? (j > 17179869184L || j < -17179869183L) ? (j > 2199023255552L || j < -2199023255551L) ? (j > 281474976710656L || j < -281474976710655L) ? 8 : 7 : 6 : 5 : 4 : 3 : 2 : 1;
    }

    public EbmlSint(byte[] bArr) {
        super(bArr);
    }

    public void set(long j) {
        this.data = ByteBuffer.wrap(convertToBytes(j));
    }

    public long get() {
        if (this.data.limit() - this.data.position() == 8) {
            return this.data.duplicate().getLong();
        }
        byte[] array = this.data.array();
        long j = 0;
        for (int length = array.length - 1; length >= 0; length--) {
            j |= (((long) array[length]) & 255) << (((array.length - 1) - length) * 8);
        }
        return j;
    }

    public static byte[] convertToBytes(long j) {
        int ebmlSignedLength = ebmlSignedLength(j);
        return EbmlUtil.ebmlEncode(j + signedComplement[ebmlSignedLength], ebmlSignedLength);
    }
}
