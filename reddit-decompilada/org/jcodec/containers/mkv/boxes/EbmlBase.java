package org.jcodec.containers.mkv.boxes;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.jcodec.common.SeekableByteChannel;
import org.jcodec.containers.mkv.MKVType;
import org.jcodec.containers.mkv.util.EbmlUtil;

public abstract class EbmlBase {
    public int dataLen = 0;
    public long dataOffset;
    public byte[] id = new byte[]{(byte) 0};
    public long offset;
    protected EbmlMaster parent;
    public MKVType type;
    public int typeSizeLength;

    public abstract ByteBuffer getData();

    public boolean equalId(byte[] bArr) {
        return Arrays.equals(this.id, bArr);
    }

    public long size() {
        return (long) ((this.dataLen + EbmlUtil.ebmlLength((long) this.dataLen)) + this.id.length);
    }

    public long mux(SeekableByteChannel seekableByteChannel) throws IOException {
        return (long) seekableByteChannel.write(getData());
    }
}
