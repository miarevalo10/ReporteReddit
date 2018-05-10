package org.jcodec.codecs.mpeg12;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import org.jcodec.containers.mps.MPSDemuxer.MPEGPacket;

public class MPEGES extends SegmentReader {
    public long curPts;
    private int frameNo;

    public MPEGES(ReadableByteChannel readableByteChannel) throws IOException {
        super(readableByteChannel, 4096);
    }

    public MPEGES(ReadableByteChannel readableByteChannel, int i) throws IOException {
        super(readableByteChannel, i);
    }

    public MPEGPacket getFrame(ByteBuffer byteBuffer) throws IOException {
        ByteBuffer duplicate = byteBuffer.duplicate();
        while (this.curMarker != 256 && this.curMarker != 435) {
            if (skipToMarker() == null) {
                break;
            }
        }
        while (this.curMarker != 256) {
            if (readToNextMarker(duplicate) == null) {
                break;
            }
        }
        readToNextMarker(duplicate);
        while (this.curMarker != 256 && this.curMarker != 435) {
            if (readToNextMarker(duplicate) == null) {
                break;
            }
        }
        duplicate.flip();
        if (duplicate.hasRemaining() == null) {
            return null;
        }
        long j = this.curPts;
        int i = this.frameNo;
        this.frameNo = i + 1;
        return new MPEGPacket(duplicate, j, 90000, 0, (long) i, true, null);
    }
}
