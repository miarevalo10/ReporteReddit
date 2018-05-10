package org.jcodec.common;

import java.io.IOException;
import java.nio.ByteBuffer;

public class ByteBufferSeekableByteChannel implements SeekableByteChannel {
    private ByteBuffer backing;
    private int contentLength;
    private boolean open = true;

    public ByteBufferSeekableByteChannel(ByteBuffer byteBuffer) {
        this.backing = byteBuffer;
    }

    public boolean isOpen() {
        return this.open;
    }

    public void close() throws IOException {
        this.open = false;
    }

    public int read(ByteBuffer byteBuffer) throws IOException {
        if (!this.backing.hasRemaining()) {
            return -1;
        }
        int min = Math.min(this.backing.remaining(), byteBuffer.remaining());
        byteBuffer.put(NIOUtils.read(this.backing, min));
        this.contentLength = Math.max(this.contentLength, this.backing.position());
        return min;
    }

    public int write(ByteBuffer byteBuffer) throws IOException {
        int min = Math.min(this.backing.remaining(), byteBuffer.remaining());
        this.backing.put(NIOUtils.read(byteBuffer, min));
        this.contentLength = Math.max(this.contentLength, this.backing.position());
        return min;
    }

    public long position() throws IOException {
        return (long) this.backing.position();
    }

    public SeekableByteChannel position(long j) throws IOException {
        this.backing.position((int) j);
        this.contentLength = Math.max(this.contentLength, this.backing.position());
        return this;
    }

    public long size() throws IOException {
        return (long) this.contentLength;
    }

    public SeekableByteChannel truncate(long j) throws IOException {
        this.contentLength = (int) j;
        return this;
    }

    public ByteBuffer getContents() {
        ByteBuffer duplicate = this.backing.duplicate();
        duplicate.position(0);
        duplicate.limit(this.contentLength);
        return duplicate;
    }
}
