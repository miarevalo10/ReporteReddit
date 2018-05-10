package org.jcodec.containers.mxf.model;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.jcodec.common.NIOUtils;

public class DeltaEntries {
    private int[] elementData;
    private byte[] posTabIdx;
    private byte[] slice;

    public DeltaEntries(byte[] bArr, byte[] bArr2, int[] iArr) {
        this.posTabIdx = bArr;
        this.slice = bArr2;
        this.elementData = iArr;
    }

    public static DeltaEntries read(ByteBuffer byteBuffer) {
        byteBuffer.order(ByteOrder.BIG_ENDIAN);
        int i = byteBuffer.getInt();
        int i2 = byteBuffer.getInt();
        byte[] bArr = new byte[i];
        byte[] bArr2 = new byte[i];
        int[] iArr = new int[i];
        for (int i3 = 0; i3 < i; i3++) {
            bArr[i3] = byteBuffer.get();
            bArr2[i3] = byteBuffer.get();
            iArr[i3] = byteBuffer.getInt();
            NIOUtils.skip(byteBuffer, i2 - 6);
        }
        return new DeltaEntries(bArr, bArr2, iArr);
    }
}
