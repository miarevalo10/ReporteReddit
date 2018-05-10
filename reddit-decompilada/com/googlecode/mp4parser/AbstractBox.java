package com.googlecode.mp4parser;

import com.coremedia.iso.BoxParser;
import com.coremedia.iso.Hex;
import com.coremedia.iso.IsoFile;
import com.coremedia.iso.IsoTypeWriter;
import com.coremedia.iso.boxes.Box;
import com.coremedia.iso.boxes.Container;
import com.googlecode.mp4parser.util.CastUtils;
import com.googlecode.mp4parser.util.Logger;
import com.googlecode.mp4parser.util.Path;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

public abstract class AbstractBox implements Box {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static Logger LOG = Logger.m7708a(AbstractBox.class);
    private ByteBuffer content;
    DataSource dataSource;
    private ByteBuffer deadBytes = null;
    boolean isParsed;
    long offset;
    private Container parent;
    protected String type;
    private byte[] userType;

    public abstract void _parseDetails(ByteBuffer byteBuffer);

    public abstract void getContent(ByteBuffer byteBuffer);

    public abstract long getContentSize();

    public long getOffset() {
        return this.offset;
    }

    protected AbstractBox(String str) {
        this.type = str;
        this.isParsed = true;
    }

    protected AbstractBox(String str, byte[] bArr) {
        this.type = str;
        this.userType = bArr;
        this.isParsed = true;
    }

    public void parse(DataSource dataSource, ByteBuffer byteBuffer, long j, BoxParser boxParser) throws IOException {
        this.offset = dataSource.position() - ((long) byteBuffer.remaining());
        this.dataSource = dataSource;
        this.content = ByteBuffer.allocate(CastUtils.m7705a(j));
        while (this.content.remaining() > null) {
            dataSource.read(this.content);
        }
        this.content.position(0);
        this.isParsed = false;
    }

    public void getBox(WritableByteChannel writableByteChannel) throws IOException {
        ByteBuffer allocate;
        if (this.isParsed) {
            allocate = ByteBuffer.allocate(CastUtils.m7705a(getSize()));
            getHeader(allocate);
            getContent(allocate);
            if (this.deadBytes != null) {
                this.deadBytes.rewind();
                while (this.deadBytes.remaining() > 0) {
                    allocate.put(this.deadBytes);
                }
            }
            writableByteChannel.write((ByteBuffer) allocate.rewind());
            return;
        }
        int i = 16;
        int i2 = isSmallBox() ? 8 : 16;
        if (!"uuid".equals(getType())) {
            i = 0;
        }
        allocate = ByteBuffer.allocate(i2 + i);
        getHeader(allocate);
        writableByteChannel.write((ByteBuffer) allocate.rewind());
        writableByteChannel.write((ByteBuffer) this.content.position(0));
    }

    public final synchronized void parseDetails() {
        Logger logger = LOG;
        StringBuilder stringBuilder = new StringBuilder("parsing details of ");
        stringBuilder.append(getType());
        logger.mo2531a(stringBuilder.toString());
        if (this.content != null) {
            ByteBuffer byteBuffer = this.content;
            this.isParsed = true;
            byteBuffer.rewind();
            _parseDetails(byteBuffer);
            if (byteBuffer.remaining() > 0) {
                this.deadBytes = byteBuffer.slice();
            }
            this.content = null;
        }
    }

    public long getSize() {
        long contentSize;
        int i = 0;
        if (this.isParsed) {
            contentSize = getContentSize();
        } else {
            contentSize = (long) (this.content != null ? this.content.limit() : 0);
        }
        contentSize += (long) ((8 + (contentSize >= 4294967288L ? 8 : 0)) + ("uuid".equals(getType()) ? 16 : 0));
        if (this.deadBytes != null) {
            i = this.deadBytes.limit();
        }
        return contentSize + ((long) i);
    }

    public String getType() {
        return this.type;
    }

    public byte[] getUserType() {
        return this.userType;
    }

    public Container getParent() {
        return this.parent;
    }

    public void setParent(Container container) {
        this.parent = container;
    }

    public boolean isParsed() {
        return this.isParsed;
    }

    private boolean verify(ByteBuffer byteBuffer) {
        ByteBuffer allocate = ByteBuffer.allocate(CastUtils.m7705a(getContentSize() + ((long) (this.deadBytes != null ? this.deadBytes.limit() : 0))));
        getContent(allocate);
        if (this.deadBytes != null) {
            this.deadBytes.rewind();
            while (this.deadBytes.remaining() > 0) {
                allocate.put(this.deadBytes);
            }
        }
        byteBuffer.rewind();
        allocate.rewind();
        if (byteBuffer.remaining() != allocate.remaining()) {
            PrintStream printStream = System.err;
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(getType()));
            stringBuilder.append(": remaining differs ");
            stringBuilder.append(byteBuffer.remaining());
            stringBuilder.append(" vs. ");
            stringBuilder.append(allocate.remaining());
            printStream.print(stringBuilder.toString());
            Logger logger = LOG;
            stringBuilder = new StringBuilder(String.valueOf(getType()));
            stringBuilder.append(": remaining differs ");
            stringBuilder.append(byteBuffer.remaining());
            stringBuilder.append(" vs. ");
            stringBuilder.append(allocate.remaining());
            logger.mo2533c(stringBuilder.toString());
            return false;
        }
        int position = byteBuffer.position();
        int limit = byteBuffer.limit() - 1;
        int limit2 = allocate.limit() - 1;
        while (limit >= position) {
            if (byteBuffer.get(limit) != allocate.get(limit2)) {
                LOG.mo2533c(String.format("%s: buffers differ at %d: %2X/%2X", new Object[]{getType(), Integer.valueOf(limit), Byte.valueOf(byteBuffer.get(limit)), Byte.valueOf(allocate.get(limit2))}));
                byte[] bArr = new byte[byteBuffer.remaining()];
                byte[] bArr2 = new byte[allocate.remaining()];
                byteBuffer.get(bArr);
                allocate.get(bArr2);
                byteBuffer = System.err;
                StringBuilder stringBuilder2 = new StringBuilder("original      : ");
                stringBuilder2.append(Hex.m3278a(bArr, 4));
                byteBuffer.println(stringBuilder2.toString());
                byteBuffer = System.err;
                stringBuilder2 = new StringBuilder("reconstructed : ");
                stringBuilder2.append(Hex.m3278a(bArr2, 4));
                byteBuffer.println(stringBuilder2.toString());
                return false;
            }
            limit--;
            limit2--;
        }
        return true;
    }

    private boolean isSmallBox() {
        int i = "uuid".equals(getType()) ? 24 : 8;
        if (!this.isParsed) {
            return ((long) (this.content.limit() + i)) < 4294967296L;
        } else {
            return (getContentSize() + ((long) (this.deadBytes != null ? this.deadBytes.limit() : 0))) + ((long) i) < 4294967296L;
        }
    }

    private void getHeader(ByteBuffer byteBuffer) {
        if (isSmallBox()) {
            IsoTypeWriter.m3300b(byteBuffer, getSize());
            byteBuffer.put(IsoFile.m17057a(getType()));
        } else {
            IsoTypeWriter.m3300b(byteBuffer, 1);
            byteBuffer.put(IsoFile.m17057a(getType()));
            IsoTypeWriter.m3296a(byteBuffer, getSize());
        }
        if ("uuid".equals(getType())) {
            byteBuffer.put(getUserType());
        }
    }

    public String getPath() {
        return Path.m7717a(this);
    }
}
