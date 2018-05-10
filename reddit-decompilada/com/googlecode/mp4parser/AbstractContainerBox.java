package com.googlecode.mp4parser;

import com.coremedia.iso.BoxParser;
import com.coremedia.iso.IsoTypeWriter;
import com.coremedia.iso.boxes.Box;
import com.coremedia.iso.boxes.Container;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

public class AbstractContainerBox extends BasicContainer implements Box {
    protected boolean largeBox;
    private long offset;
    Container parent;
    protected String type;

    public AbstractContainerBox(String str) {
        this.type = str;
    }

    public Container getParent() {
        return this.parent;
    }

    public long getOffset() {
        return this.offset;
    }

    public void setParent(Container container) {
        this.parent = container;
    }

    public long getSize() {
        int i;
        long containerSize = getContainerSize();
        if (!this.largeBox) {
            if (8 + containerSize < 4294967296L) {
                i = 8;
                return containerSize + ((long) i);
            }
        }
        i = 16;
        return containerSize + ((long) i);
    }

    public String getType() {
        return this.type;
    }

    protected ByteBuffer getHeader() {
        byte[] bArr;
        ByteBuffer wrap;
        if (!this.largeBox) {
            if (getSize() < 4294967296L) {
                bArr = new byte[8];
                bArr[4] = this.type.getBytes()[0];
                bArr[5] = this.type.getBytes()[1];
                bArr[6] = this.type.getBytes()[2];
                bArr[7] = this.type.getBytes()[3];
                wrap = ByteBuffer.wrap(bArr);
                IsoTypeWriter.m3300b(wrap, getSize());
                wrap.rewind();
                return wrap;
            }
        }
        bArr = new byte[16];
        bArr[3] = (byte) 1;
        bArr[4] = this.type.getBytes()[0];
        bArr[5] = this.type.getBytes()[1];
        bArr[6] = this.type.getBytes()[2];
        bArr[7] = this.type.getBytes()[3];
        wrap = ByteBuffer.wrap(bArr);
        wrap.position(8);
        IsoTypeWriter.m3296a(wrap, getSize());
        wrap.rewind();
        return wrap;
    }

    public void parse(DataSource dataSource, ByteBuffer byteBuffer, long j, BoxParser boxParser) throws IOException {
        this.offset = dataSource.position() - ((long) byteBuffer.remaining());
        this.largeBox = byteBuffer.remaining() == 16 ? true : null;
        initContainer(dataSource, j, boxParser);
    }

    public void getBox(WritableByteChannel writableByteChannel) throws IOException {
        writableByteChannel.write(getHeader());
        writeContainer(writableByteChannel);
    }

    public void initContainer(DataSource dataSource, long j, BoxParser boxParser) throws IOException {
        int i;
        this.dataSource = dataSource;
        this.parsePosition = dataSource.position();
        long j2 = this.parsePosition;
        if (!this.largeBox) {
            if (8 + j < 4294967296L) {
                i = 8;
                this.startPosition = j2 - ((long) i);
                dataSource.position(dataSource.position() + j);
                this.endPosition = dataSource.position();
                this.boxParser = boxParser;
            }
        }
        i = 16;
        this.startPosition = j2 - ((long) i);
        dataSource.position(dataSource.position() + j);
        this.endPosition = dataSource.position();
        this.boxParser = boxParser;
    }
}
