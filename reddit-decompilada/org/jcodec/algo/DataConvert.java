package org.jcodec.algo;

public class DataConvert {
    public static int[] from16BE(byte[] bArr) {
        int i = 0;
        int[] iArr = new int[(bArr.length >> 1)];
        int i2 = 0;
        while (i < iArr.length) {
            int i3 = i2 + 1;
            int i4 = i3 + 1;
            iArr[i] = ((bArr[i2] & 255) << 8) | (bArr[i3] & 255);
            i++;
            i2 = i4;
        }
        return iArr;
    }

    public static int[] from24BE(byte[] bArr) {
        int i = 0;
        int[] iArr = new int[(bArr.length / 3)];
        int i2 = 0;
        while (i < iArr.length) {
            int i3 = i2 + 1;
            int i4 = i3 + 1;
            i2 = ((bArr[i2] & 255) << 16) | ((bArr[i3] & 255) << 8);
            i3 = i4 + 1;
            iArr[i] = i2 | (bArr[i4] & 255);
            i++;
            i2 = i3;
        }
        return iArr;
    }

    public static int[] from16LE(byte[] bArr) {
        int i = 0;
        int[] iArr = new int[(bArr.length >> 1)];
        int i2 = 0;
        while (i < iArr.length) {
            int i3 = i2 + 1;
            int i4 = i3 + 1;
            iArr[i] = (bArr[i2] & 255) | ((bArr[i3] & 255) << 8);
            i++;
            i2 = i4;
        }
        return iArr;
    }

    public static int[] from24LE(byte[] bArr) {
        int i = 0;
        int[] iArr = new int[(bArr.length / 3)];
        int i2 = 0;
        while (i < iArr.length) {
            int i3 = i2 + 1;
            int i4 = i3 + 1;
            i2 = (bArr[i2] & 255) | ((bArr[i3] & 255) << 8);
            i3 = i4 + 1;
            iArr[i] = i2 | ((bArr[i4] & 255) << 16);
            i++;
            i2 = i3;
        }
        return iArr;
    }

    public static byte[] to16BE(int[] iArr) {
        int i = 0;
        byte[] bArr = new byte[(iArr.length << 1)];
        int i2 = 0;
        while (i < iArr.length) {
            int i3 = i2 + 1;
            bArr[i2] = (byte) ((iArr[i] >> 8) & 255);
            i2 = i3 + 1;
            bArr[i3] = (byte) (iArr[i] & 255);
            i++;
        }
        return bArr;
    }

    public static byte[] to24BE(int[] iArr) {
        int i = 0;
        byte[] bArr = new byte[(iArr.length * 3)];
        int i2 = 0;
        while (i < iArr.length) {
            int i3 = i2 + 1;
            bArr[i2] = (byte) ((iArr[i] >> 16) & 255);
            i2 = i3 + 1;
            bArr[i3] = (byte) ((iArr[i] >> 8) & 255);
            i3 = i2 + 1;
            bArr[i2] = (byte) (iArr[i] & 255);
            i++;
            i2 = i3;
        }
        return bArr;
    }

    public static byte[] to16LE(int[] iArr) {
        int i = 0;
        byte[] bArr = new byte[(iArr.length << 1)];
        int i2 = 0;
        while (i < iArr.length) {
            int i3 = i2 + 1;
            bArr[i2] = (byte) (iArr[i] & 255);
            i2 = i3 + 1;
            bArr[i3] = (byte) ((iArr[i] >> 8) & 255);
            i++;
        }
        return bArr;
    }

    public static byte[] to24LE(int[] iArr) {
        int i = 0;
        byte[] bArr = new byte[(iArr.length * 3)];
        int i2 = 0;
        while (i < iArr.length) {
            int i3 = i2 + 1;
            bArr[i2] = (byte) (iArr[i] & 255);
            i2 = i3 + 1;
            bArr[i3] = (byte) ((iArr[i] >> 8) & 255);
            i3 = i2 + 1;
            bArr[i2] = (byte) ((iArr[i] >> 16) & 255);
            i++;
            i2 = i3;
        }
        return bArr;
    }

    public static int[] fromByte(byte[] bArr, int i, boolean z) {
        if (i == 24) {
            if (z) {
                return from24BE(bArr);
            }
            return from24LE(bArr);
        } else if (i != 16) {
            StringBuilder stringBuilder = new StringBuilder("Conversion from ");
            stringBuilder.append(i);
            stringBuilder.append("bit ");
            stringBuilder.append(z ? "big endian" : "little endian");
            stringBuilder.append(" is not supported.");
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (z) {
            return from16BE(bArr);
        } else {
            return from16LE(bArr);
        }
    }

    public static byte[] toByte(int[] iArr, int i, boolean z) {
        if (i == 24) {
            if (z) {
                return to24BE(iArr);
            }
            return to24LE(iArr);
        } else if (i != 16) {
            StringBuilder stringBuilder = new StringBuilder("Conversion to ");
            stringBuilder.append(i);
            stringBuilder.append("bit ");
            stringBuilder.append(z ? "big endian" : "little endian");
            stringBuilder.append(" is not supported.");
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (z) {
            return to16BE(iArr);
        } else {
            return to16LE(iArr);
        }
    }
}
