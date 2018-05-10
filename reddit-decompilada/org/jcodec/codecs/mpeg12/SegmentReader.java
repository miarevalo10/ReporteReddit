package org.jcodec.codecs.mpeg12;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import org.jcodec.common.NIOUtils;

public class SegmentReader {
    private ByteBuffer buf;
    private ReadableByteChannel channel;
    protected int curMarker;
    private boolean done;
    private int fetchSize;
    private long pos;

    public SegmentReader(ReadableByteChannel readableByteChannel) throws IOException {
        this(readableByteChannel, 4096);
    }

    public SegmentReader(ReadableByteChannel readableByteChannel, int i) throws IOException {
        this.channel = readableByteChannel;
        this.fetchSize = i;
        this.buf = NIOUtils.fetchFrom(readableByteChannel, 4);
        this.pos = (long) this.buf.remaining();
        this.curMarker = this.buf.getInt();
    }

    public final boolean readToNextMarker(ByteBuffer byteBuffer) throws IOException {
        if (this.done) {
            return false;
        }
        int i = 1;
        while (true) {
            if (this.buf.hasRemaining()) {
                if (this.curMarker >= 256 && this.curMarker <= 511) {
                    if (i == 0) {
                        return true;
                    }
                    i--;
                }
                byteBuffer.put((byte) (this.curMarker >>> 24));
                this.curMarker = (this.curMarker << 8) | (this.buf.get() & 255);
            } else {
                this.buf = NIOUtils.fetchFrom(this.channel, this.fetchSize);
                this.pos += (long) this.buf.remaining();
                if (!this.buf.hasRemaining()) {
                    byteBuffer.putInt(this.curMarker);
                    this.done = true;
                    return false;
                }
            }
        }
    }

    public final boolean skipToMarker() throws IOException {
        if (this.done) {
            return false;
        }
        while (true) {
            if (this.buf.hasRemaining()) {
                this.curMarker = (this.curMarker << 8) | (this.buf.get() & 255);
                if (this.curMarker >= 256 && this.curMarker <= 511) {
                    return true;
                }
            }
            this.buf = NIOUtils.fetchFrom(this.channel, this.fetchSize);
            this.pos += (long) this.buf.remaining();
            if (!this.buf.hasRemaining()) {
                this.done = true;
                return false;
            }
        }
    }

    public final boolean read(ByteBuffer byteBuffer, int i) throws IOException {
        if (this.done) {
            return false;
        }
        while (true) {
            if (this.buf.hasRemaining()) {
                int i2 = i - 1;
                if (i == 0) {
                    return true;
                }
                byteBuffer.put((byte) (this.curMarker >>> 24));
                this.curMarker = (this.curMarker << 8) | (this.buf.get() & 255);
                i = i2;
            } else {
                this.buf = NIOUtils.fetchFrom(this.channel, this.fetchSize);
                this.pos += (long) this.buf.remaining();
                if (!this.buf.hasRemaining()) {
                    byteBuffer.putInt(this.curMarker);
                    this.done = true;
                    return false;
                }
            }
        }
    }

    public final long curPos() {
        return (this.pos - ((long) this.buf.remaining())) - 4;
    }
}
