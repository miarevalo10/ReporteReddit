package org.jcodec.codecs.h264.io.write;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import org.jcodec.codecs.h264.io.model.NALUnit;
import org.jcodec.common.NIOUtils;

public class NALUnitWriter {
    private static ByteBuffer _MARKER;
    private final WritableByteChannel to;

    static {
        ByteBuffer allocate = ByteBuffer.allocate(4);
        _MARKER = allocate;
        allocate.putInt(1);
        _MARKER.flip();
    }

    public NALUnitWriter(WritableByteChannel writableByteChannel) {
        this.to = writableByteChannel;
    }

    public void writeUnit(NALUnit nALUnit, ByteBuffer byteBuffer) throws IOException {
        ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.remaining() + 1024);
        NIOUtils.write(allocate, _MARKER);
        nALUnit.write(allocate);
        emprev(allocate, byteBuffer);
        allocate.flip();
        this.to.write(allocate);
    }

    private void emprev(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        byteBuffer2 = byteBuffer2.duplicate();
        byte b = (byte) 1;
        byte b2 = (byte) 1;
        while (byteBuffer2.hasRemaining()) {
            byte b3 = byteBuffer2.get();
            if (b == (byte) 0 && r1 == (byte) 0 && (b3 & 3) == b3) {
                byteBuffer.put((byte) 3);
                b2 = (byte) 3;
            } else {
                b2 = b;
            }
            byteBuffer.put(b3);
            b = b3;
        }
    }
}
