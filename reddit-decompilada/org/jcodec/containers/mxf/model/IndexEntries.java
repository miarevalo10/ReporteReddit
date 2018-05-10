package org.jcodec.containers.mxf.model;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.jcodec.common.NIOUtils;

public class IndexEntries {
    private byte[] displayOff;
    private long[] fileOff;
    private byte[] flags;
    private byte[] keyFrameOff;

    public IndexEntries(byte[] bArr, byte[] bArr2, byte[] bArr3, long[] jArr) {
        this.displayOff = bArr;
        this.keyFrameOff = bArr2;
        this.flags = bArr3;
        this.fileOff = jArr;
    }

    public byte[] getDisplayOff() {
        return this.displayOff;
    }

    public byte[] getFlags() {
        return this.flags;
    }

    public long[] getFileOff() {
        return this.fileOff;
    }

    public byte[] getKeyFrameOff() {
        return this.keyFrameOff;
    }

    public static IndexEntries read(ByteBuffer byteBuffer) {
        int i;
        byteBuffer.order(ByteOrder.BIG_ENDIAN);
        int i2 = byteBuffer.getInt();
        int i3 = byteBuffer.getInt();
        int[] iArr = new int[i2];
        byte[] bArr = new byte[i2];
        long[] jArr = new long[i2];
        byte[] bArr2 = new byte[i2];
        for (i = 0; i < i2; i++) {
            iArr[i] = byteBuffer.get() + i;
            bArr2[i] = byteBuffer.get();
            bArr[i] = byteBuffer.get();
            jArr[i] = byteBuffer.getLong();
            NIOUtils.skip(byteBuffer, i3 - 11);
        }
        byteBuffer = new byte[i2];
        for (i3 = 0; i3 < i2; i3++) {
            for (i = 0; i < i2; i++) {
                if (iArr[i] == i3) {
                    byteBuffer[i3] = (byte) (i - i3);
                    break;
                }
            }
        }
        return new IndexEntries(byteBuffer, bArr2, bArr, jArr);
    }
}
