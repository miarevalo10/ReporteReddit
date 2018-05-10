package com.coremedia.iso.boxes;

import com.coremedia.iso.BoxParser;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.AbstractContainerBox;
import com.googlecode.mp4parser.DataSource;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

public class DataReferenceBox extends AbstractContainerBox implements FullBox {
    public static final String TYPE = "dref";
    private int flags;
    private int version;

    public DataReferenceBox() {
        super(TYPE);
    }

    public int getVersion() {
        return this.version;
    }

    public void setVersion(int i) {
        this.version = i;
    }

    public int getFlags() {
        return this.flags;
    }

    public void setFlags(int i) {
        this.flags = i;
    }

    public void parse(DataSource dataSource, ByteBuffer byteBuffer, long j, BoxParser boxParser) throws IOException {
        byteBuffer = ByteBuffer.allocate(8);
        dataSource.read(byteBuffer);
        byteBuffer.rewind();
        this.version = IsoTypeReader.m3284d(byteBuffer);
        this.flags = IsoTypeReader.m3282b(byteBuffer);
        initContainer(dataSource, j - 8, boxParser);
    }

    public void getBox(WritableByteChannel writableByteChannel) throws IOException {
        writableByteChannel.write(getHeader());
        ByteBuffer allocate = ByteBuffer.allocate(8);
        IsoTypeWriter.m3303c(allocate, this.version);
        IsoTypeWriter.m3295a(allocate, this.flags);
        IsoTypeWriter.m3300b(allocate, (long) getBoxes().size());
        writableByteChannel.write((ByteBuffer) allocate.rewind());
        writeContainer(writableByteChannel);
    }

    public long getSize() {
        int i;
        long containerSize = getContainerSize() + 8;
        if (!this.largeBox) {
            if (8 + containerSize < 4294967296L) {
                i = 8;
                return containerSize + ((long) i);
            }
        }
        i = 16;
        return containerSize + ((long) i);
    }
}
