package com.coremedia.iso.boxes.mdat;

import com.coremedia.iso.BoxParser;
import com.coremedia.iso.boxes.Box;
import com.coremedia.iso.boxes.Container;
import com.googlecode.mp4parser.DataSource;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

public final class MediaDataBox implements Box {
    public static final String TYPE = "mdat";
    private DataSource dataSource;
    private long offset;
    Container parent;
    private long size;

    public final String getType() {
        return TYPE;
    }

    public final Container getParent() {
        return this.parent;
    }

    public final void setParent(Container container) {
        this.parent = container;
    }

    private static void transfer(DataSource dataSource, long j, long j2, WritableByteChannel writableByteChannel) throws IOException {
        long j3 = 0;
        while (j3 < j2) {
            j3 += dataSource.transferTo(j + j3, Math.min(67076096, j2 - j3), writableByteChannel);
        }
    }

    public final void getBox(WritableByteChannel writableByteChannel) throws IOException {
        transfer(this.dataSource, this.offset, this.size, writableByteChannel);
    }

    public final long getSize() {
        return this.size;
    }

    public final long getOffset() {
        return this.offset;
    }

    public final void parse(DataSource dataSource, ByteBuffer byteBuffer, long j, BoxParser boxParser) throws IOException {
        this.offset = dataSource.position() - ((long) byteBuffer.remaining());
        this.dataSource = dataSource;
        this.size = ((long) byteBuffer.remaining()) + j;
        dataSource.position(dataSource.position() + j);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("MediaDataBox{size=");
        stringBuilder.append(this.size);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
