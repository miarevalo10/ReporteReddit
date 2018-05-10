package org.jcodec.containers.mkv.boxes;

import java.io.IOException;
import java.nio.ByteBuffer;
import org.jcodec.common.SeekableByteChannel;

public class EbmlVoid extends EbmlBase {
    public ByteBuffer getData() {
        return null;
    }

    public EbmlVoid(byte[] bArr) {
        this.id = bArr;
    }

    public void skip(SeekableByteChannel seekableByteChannel) throws IOException {
        seekableByteChannel.position(this.dataOffset + ((long) this.dataLen));
    }
}
