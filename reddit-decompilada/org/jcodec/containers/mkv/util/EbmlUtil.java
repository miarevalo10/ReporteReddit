package org.jcodec.containers.mkv.util;

import org.jcodec.containers.mxf.model.BER;

public class EbmlUtil {
    public static final long[] ebmlLengthMasks = new long[]{0, 127, two, three, four, five, six, seven, eight};
    public static final long eight = 71494644084506624L;
    public static final long five = 34091302912L;
    public static final long four = 266338304;
    public static final byte[] lengthOptions = new byte[]{(byte) 0, BER.ASN_LONG_LEN, (byte) 64, (byte) 32, (byte) 16, (byte) 8, (byte) 4, (byte) 2, (byte) 1};
    public static final long one = 127;
    public static final long seven = 558551906910208L;
    public static final long six = 4363686772736L;
    public static final long three = 2080768;
    public static final long two = 16256;

    public static byte[] ebmlEncode(long j, int i) {
        byte[] bArr = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            bArr[(i - i2) - 1] = (byte) ((int) ((j >>> (8 * i2)) & 255));
        }
        bArr[0] = (byte) (bArr[0] | (128 >>> (i - 1)));
        return bArr;
    }

    public static byte[] ebmlEncode(long j) {
        return ebmlEncode(j, ebmlLength(j));
    }

    public static int computeLength(byte b) {
        if (b == (byte) 0) {
            throw new RuntimeException("Invalid head element for ebml sequence");
        }
        int i = 1;
        while ((lengthOptions[i] & b) == 0) {
            i++;
        }
        return i;
    }

    public static int ebmlLength(long j) {
        if (j == 0) {
            return 1;
        }
        int i = 8;
        while (i > 0 && (j & ebmlLengthMasks[i]) == 0) {
            i--;
        }
        return i;
    }

    public static String toHexString(byte[] bArr) {
        StringBuilder stringBuilder = new StringBuilder();
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            stringBuilder.append(String.format("0x%02x ", new Object[]{Integer.valueOf(bArr[i] & 255)}));
        }
        return stringBuilder.toString();
    }
}
