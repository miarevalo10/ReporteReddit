package org.jcodec.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import org.jcodec.common.io.AutoPool;
import org.jcodec.common.io.AutoResource;

public class AutoFileChannelWrapper implements SeekableByteChannel, AutoResource {
    private static final long THRESHOLD = 5000;
    private long accessTime;
    private FileChannel ch;
    private long curTime = System.currentTimeMillis();
    private File file;
    private long savedPos;

    public AutoFileChannelWrapper(File file) throws IOException {
        this.file = file;
        AutoPool.getInstance().add(this);
        ensureOpen();
    }

    private void ensureOpen() throws IOException {
        this.accessTime = this.curTime;
        if (this.ch == null || !this.ch.isOpen()) {
            this.ch = new FileInputStream(this.file).getChannel();
            this.ch.position(this.savedPos);
        }
    }

    public int read(ByteBuffer byteBuffer) throws IOException {
        ensureOpen();
        byteBuffer = this.ch.read(byteBuffer);
        this.savedPos = this.ch.position();
        return byteBuffer;
    }

    public void close() throws IOException {
        if (this.ch != null && this.ch.isOpen()) {
            this.savedPos = this.ch.position();
            this.ch.close();
            this.ch = null;
        }
    }

    public boolean isOpen() {
        return this.ch != null && this.ch.isOpen();
    }

    public int write(ByteBuffer byteBuffer) throws IOException {
        ensureOpen();
        byteBuffer = this.ch.write(byteBuffer);
        this.savedPos = this.ch.position();
        return byteBuffer;
    }

    public long position() throws IOException {
        ensureOpen();
        return this.ch.position();
    }

    public SeekableByteChannel position(long j) throws IOException {
        ensureOpen();
        this.ch.position(j);
        this.savedPos = j;
        return this;
    }

    public long size() throws IOException {
        ensureOpen();
        return this.ch.size();
    }

    public SeekableByteChannel truncate(long j) throws IOException {
        ensureOpen();
        this.ch.truncate(j);
        this.savedPos = this.ch.position();
        return this;
    }

    public void setCurTime(long j) {
        this.curTime = j;
        if (this.ch != null && this.ch.isOpen() && j - this.accessTime > THRESHOLD) {
            try {
                close();
            } catch (long j2) {
                throw new RuntimeException(j2);
            }
        }
    }
}
