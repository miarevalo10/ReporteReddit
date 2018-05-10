package com.googlecode.mp4parser;

import com.googlecode.mp4parser.util.CastUtils;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

public class MemoryDataSourceImpl implements DataSource {
    ByteBuffer f15121a;

    public void close() throws IOException {
    }

    public MemoryDataSourceImpl(ByteBuffer byteBuffer) {
        this.f15121a = byteBuffer;
    }

    public int read(ByteBuffer byteBuffer) throws IOException {
        if (this.f15121a.remaining() == 0 && byteBuffer.remaining() != 0) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), this.f15121a.remaining());
        if (byteBuffer.hasArray()) {
            byteBuffer.put(this.f15121a.array(), this.f15121a.position(), min);
            this.f15121a.position(this.f15121a.position() + min);
        } else {
            byte[] bArr = new byte[min];
            this.f15121a.get(bArr);
            byteBuffer.put(bArr);
        }
        return min;
    }

    public long size() throws IOException {
        return (long) this.f15121a.capacity();
    }

    public long position() throws IOException {
        return (long) this.f15121a.position();
    }

    public void position(long j) throws IOException {
        this.f15121a.position(CastUtils.m7705a(j));
    }

    public long transferTo(long j, long j2, WritableByteChannel writableByteChannel) throws IOException {
        return (long) writableByteChannel.write((ByteBuffer) ((ByteBuffer) this.f15121a.position(CastUtils.m7705a(j))).slice().limit(CastUtils.m7705a(j2)));
    }

    public ByteBuffer map(long j, long j2) throws IOException {
        int position = this.f15121a.position();
        this.f15121a.position(CastUtils.m7705a(j));
        j = this.f15121a.slice();
        j.limit(CastUtils.m7705a(j2));
        this.f15121a.position(position);
        return j;
    }
}
