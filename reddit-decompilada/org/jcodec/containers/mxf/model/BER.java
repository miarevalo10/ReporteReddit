package org.jcodec.containers.mxf.model;

import java.io.IOException;
import java.nio.ByteBuffer;
import org.jcodec.common.NIOUtils;
import org.jcodec.common.SeekableByteChannel;

public class BER {
    public static final byte ASN_LONG_LEN = Byte.MIN_VALUE;

    public static final long decodeLength(SeekableByteChannel seekableByteChannel) throws IOException {
        int readByte = NIOUtils.readByte(seekableByteChannel) & 255;
        if ((readByte & -128) <= 0) {
            return (long) (readByte & 255);
        }
        readByte &= 127;
        if (readByte == 0) {
            throw new IOException("Indefinite lengths are not supported");
        } else if (readByte > 8) {
            throw new IOException("Data length > 4 bytes are not supported!");
        } else {
            seekableByteChannel = NIOUtils.readNByte(seekableByteChannel, readByte);
            long j = 0;
            for (int i = 0; i < readByte; i++) {
                j = (j << 8) | ((long) (seekableByteChannel[i] & 255));
            }
            if (j >= 0) {
                return j;
            }
            throw new IOException("mxflib does not support data lengths > 2^63");
        }
    }

    public static long decodeLength(ByteBuffer byteBuffer) {
        int i = byteBuffer.get() & 255;
        if ((i & -128) <= 0) {
            return (long) (i & 255);
        }
        i &= 127;
        if (i == 0) {
            throw new RuntimeException("Indefinite lengths are not supported");
        } else if (i > 8) {
            throw new RuntimeException("Data length > 8 bytes are not supported!");
        } else {
            long j = 0;
            for (int i2 = 0; i2 < i; i2++) {
                j = (j << 8) | ((long) (byteBuffer.get() & 255));
            }
            if (j >= 0) {
                return j;
            }
            throw new RuntimeException("mxflib does not support data lengths > 2^63");
        }
    }
}
