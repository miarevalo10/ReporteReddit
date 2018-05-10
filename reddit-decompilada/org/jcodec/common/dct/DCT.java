package org.jcodec.common.dct;

public abstract class DCT {
    public abstract int[] decode(int[] iArr);

    public short[] encode(byte[] bArr) {
        throw new UnsupportedOperationException();
    }

    public void decodeAll(int[][] iArr) {
        for (int i = 0; i < iArr.length; i++) {
            iArr[i] = decode(iArr[i]);
        }
    }
}
