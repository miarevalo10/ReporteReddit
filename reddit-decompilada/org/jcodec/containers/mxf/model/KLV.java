package org.jcodec.containers.mxf.model;

import java.io.IOException;
import java.nio.ByteBuffer;
import org.jcodec.common.SeekableByteChannel;

public class KLV {
    public final long dataOffset;
    public final UL key;
    public final long len;
    public final long offset;
    ByteBuffer value;

    public KLV(UL ul, long j, long j2, long j3) {
        this.key = ul;
        this.len = j;
        this.offset = j2;
        this.dataOffset = j3;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("KLV [offset=");
        stringBuilder.append(this.offset);
        stringBuilder.append(", dataOffset=");
        stringBuilder.append(this.dataOffset);
        stringBuilder.append(", key=");
        stringBuilder.append(this.key);
        stringBuilder.append(", len=");
        stringBuilder.append(this.len);
        stringBuilder.append(", value=");
        stringBuilder.append(this.value);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public static KLV readKL(SeekableByteChannel seekableByteChannel) throws IOException {
        long position = seekableByteChannel.position();
        if (position >= seekableByteChannel.size() - 1) {
            return null;
        }
        byte[] bArr = new byte[16];
        seekableByteChannel.read(ByteBuffer.wrap(bArr));
        return new KLV(new UL(bArr), BER.decodeLength(seekableByteChannel), position, seekableByteChannel.position());
    }

    public int getLenByteCount() {
        int i = (int) ((this.dataOffset - this.offset) - 16);
        return i <= 0 ? 4 : i;
    }

    public static boolean matches(byte[] bArr, byte[] bArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (bArr[i2] != bArr2[i2]) {
                return false;
            }
        }
        return 1;
    }

    public static KLV readKL(ByteBuffer byteBuffer, long j) {
        if (byteBuffer.remaining() < 17) {
            return null;
        }
        return new KLV(UL.read(byteBuffer), BER.decodeLength(byteBuffer), j + ((long) byteBuffer.position()), j + ((long) byteBuffer.position()));
    }
}
