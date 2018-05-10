package com.coremedia.iso.boxes;

import com.coremedia.iso.BoxParser;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.AbstractContainerBox;
import com.googlecode.mp4parser.DataSource;
import com.googlecode.mp4parser.MemoryDataSourceImpl;
import com.googlecode.mp4parser.util.CastUtils;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

public class MetaBox extends AbstractContainerBox {
    public static final String TYPE = "meta";
    private int flags;
    private boolean isFullBox = true;
    private int version;

    public MetaBox() {
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

    protected final long parseVersionAndFlags(ByteBuffer byteBuffer) {
        this.version = IsoTypeReader.m3284d(byteBuffer);
        this.flags = IsoTypeReader.m3282b(byteBuffer);
        return 4;
    }

    protected final void writeVersionAndFlags(ByteBuffer byteBuffer) {
        IsoTypeWriter.m3303c(byteBuffer, this.version);
        IsoTypeWriter.m3295a(byteBuffer, this.flags);
    }

    public void parse(DataSource dataSource, ByteBuffer byteBuffer, long j, BoxParser boxParser) throws IOException {
        byteBuffer = ByteBuffer.allocate(CastUtils.m7705a(j));
        dataSource.read(byteBuffer);
        byteBuffer.position(4);
        if (HandlerBox.TYPE.equals(IsoTypeReader.m3291k(byteBuffer)) != null) {
            this.isFullBox = null;
            initContainer(new MemoryDataSourceImpl((ByteBuffer) byteBuffer.rewind()), j, boxParser);
            return;
        }
        this.isFullBox = true;
        parseVersionAndFlags((ByteBuffer) byteBuffer.rewind());
        initContainer(new MemoryDataSourceImpl(byteBuffer), j - 4, boxParser);
    }

    public void getBox(WritableByteChannel writableByteChannel) throws IOException {
        writableByteChannel.write(getHeader());
        if (this.isFullBox) {
            ByteBuffer allocate = ByteBuffer.allocate(4);
            writeVersionAndFlags(allocate);
            writableByteChannel.write((ByteBuffer) allocate.rewind());
        }
        writeContainer(writableByteChannel);
    }

    public long getSize() {
        int i;
        long containerSize = getContainerSize() + (this.isFullBox ? 4 : 0);
        if (!this.largeBox) {
            if (containerSize < 4294967296L) {
                i = 8;
                return containerSize + ((long) i);
            }
        }
        i = 16;
        return containerSize + ((long) i);
    }
}
