package org.jcodec.containers.mp4.boxes;

import com.coremedia.iso.boxes.StaticChunkOffsetBox;
import java.nio.ByteBuffer;

public class ChunkOffsetsBox extends FullBox {
    private long[] chunkOffsets;

    public static String fourcc() {
        return StaticChunkOffsetBox.TYPE;
    }

    public ChunkOffsetsBox(long[] jArr) {
        super(new Header(fourcc()));
        this.chunkOffsets = jArr;
    }

    public ChunkOffsetsBox() {
        super(new Header(fourcc()));
    }

    public void parse(ByteBuffer byteBuffer) {
        super.parse(byteBuffer);
        int i = byteBuffer.getInt();
        this.chunkOffsets = new long[i];
        for (int i2 = 0; i2 < i; i2++) {
            this.chunkOffsets[i2] = ((long) byteBuffer.getInt()) & 4294967295L;
        }
    }

    public void doWrite(ByteBuffer byteBuffer) {
        super.doWrite(byteBuffer);
        byteBuffer.putInt(this.chunkOffsets.length);
        for (long j : this.chunkOffsets) {
            byteBuffer.putInt((int) j);
        }
    }

    public long[] getChunkOffsets() {
        return this.chunkOffsets;
    }

    public void setChunkOffsets(long[] jArr) {
        this.chunkOffsets = jArr;
    }
}
